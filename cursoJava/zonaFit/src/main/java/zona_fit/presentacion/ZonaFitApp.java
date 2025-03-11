package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);
        // creamos un objeto de la clase clienteDao
        IClienteDAO clienteDao = new ClienteDAO();
        while (!salir){
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);
            }catch (Exception e){
                System.out.println("error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.println("""
                *** zona fit (GYM) ***
                1. listar clientes
                2. buscar clientes
                3. agregar clientes
                4. modificar clientes
                5. eliminar clientes
                6. salir
                
                Elije una opcion:\s""");

        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion,
                                            IClienteDAO clienteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { // 1. listar clientes
                System.out.println("--- listado de clientes ---");
                var clientes = clienteDAO.listarCliente();
                clientes.forEach(System.out::println);
            }
            case 2 -> {// 2. buscar cliente
                System.out.println("--- buscar cliente ---");
                System.out.println("introduce el ID del cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if(encontrado){
                    System.out.println("cliente encontrado: " + cliente);
                }else {
                    System.out.println("cliente no encontrado: " + cliente);
                }
            }
            case 3 -> { // 3. agregar cliente
                System.out.println("--- agregar clientes ---");
                System.out.print("nombre: ");
                var nombre = consola.nextLine();
                System.out.print("apellido: ");
                var apellido = consola.nextLine();
                System.out.print("membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // creamos el objeto cliente (sin el id)
                var cliente = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                if(agregado){
                    System.out.println("cliente agregado: " + cliente);
                }else{
                    System.out.println("cliente no agregado: " + cliente);
                }
            }
            case 4 -> { // 4. modificar cliente
                System.out.println("--- modificar cliente ---");
                System.out.println("ingrese el ID del cliente a modificar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("nombre: ");
                var nombre = consola.nextLine();
                System.out.print("apellido: ");
                var apellido = consola.nextLine();
                System.out.print("membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // creamos el objeto a modificar
                var cliente = new Cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDAO.modificarCliente(cliente);
                if(modificado){
                    System.out.println("cliente modificado: " + cliente);
                }else {
                    System.out.println("cliente no modificado: " + cliente);
                }
            }
            case 5 -> { // 5. eliminar cliente
                System.out.println("--- eliminar cliente ---");
                System.out.println("introduce el ID del cliente a eliminar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if(eliminado){
                    System.out.println("cliente eliminado: " + cliente);
                }else {
                    System.out.println("cliente no eliminado: " + cliente);
                }
            }
            case 6 -> { // 6. salir
                System.out.println("adios");
                salir = true;
            }
            default -> System.out.println("opcion invalida: " + opcion);
        }
        return salir;
    }
}
