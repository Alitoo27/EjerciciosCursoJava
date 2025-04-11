package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger =
			LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("iniciando la aplicacion");
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				\n*** Aplicacion zona fit (GYM) ***
				
				1. Listar clientes
				2. Buscar clientes
				3. Agregar clientes
				4. Eliminar clientes
				6. Salir
				elige una opcion:\s""");
		return Integer.parseInt(consola.nextLine());
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(nl + "--- listado de clientes ---" +nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString()));
			}
			case 2 -> {
				logger.info(nl+"--- buscar cliente por Id ---"+ nl);
				logger.info("id del cliente a buscar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null)
					logger.info("cliente encontrado: " + cliente +nl);
				else
					logger.info("cliente no encontrado: "+ cliente +nl);
			}
			case 3 -> {
				logger.info("--- agregar cliente ---"+ nl);
				logger.info("nombre: ");
				var nombre = consola.nextLine();
				logger.info("apellido: ");
				var apellido = consola.nextLine();
				logger.info("membresia: ");
				var membresia = Integer.parseInt(consola.nextLine());
				var cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);
				clienteServicio.guardarCliente(cliente);
				logger.info("cliente agregado: "+ cliente);
			}
			case 4 -> {
				logger.info("--- modificar cliente ---"+ nl);
				logger.info("id del cliente a odificar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					logger.info("nombre: ");
					var nombre = consola.nextLine();
					logger.info("apellido: ");
					var apellido = consola.nextLine();
					logger.info("membresia: ");
					var membresia = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("cliente modificado: " + cliente+ nl);
				}else {
					logger.info("cliente no modificado: " + cliente + nl);
				}
			}
			case 5 -> {
				logger.info("--- eliminar cliente ---"+ nl);
				logger.info("id del cliente a eliminar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("cliente eliminado: "+ cliente + nl);

				}else
					logger.info("cliente no eliminado: "+ cliente + nl);
			}
			case 6 -> {
				logger.info("adios!!!"+nl+nl);
				salir = true;
			}
			default -> logger.info("opcion invalida: "+ opcion + nl);
		}
		return salir;
	}
}
