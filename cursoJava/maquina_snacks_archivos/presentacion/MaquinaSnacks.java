package maquina_snacks_archivos.presentacion;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServicioSnacks;
import maquina_snacks_archivos.servicio.ServicioSnacksArchivos;
import maquina_snacks_archivos.servicio.ServicioSnacksLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //creamos el objeto para obtener el servicio de snack
        //IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
        // creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** maquina de snack ***");
        servicioSnacks.mostrarSnacks(); //mostrar inventario de snacks dsponibles
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);
            }catch (Exception e){
                System.out.println("ocurrio un error: "+ e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.println("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. mostrar inventario
                5. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola,
                                            List<Snack> productos,
                                            IServicioSnacks servicioSnacks){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola, servicioSnacks);
            case 4 -> listarInventarioSnack(consola, servicioSnacks);
            case 5 -> {
                System.out.println("requesa pronto");
                salir = true;
            }
            default -> System.out.println("opcion invalida" + opcion);
        }
        return salir;
    }

    private static void listarInventarioSnack(Scanner consola, IServicioSnacks servicioSnacks){
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        System.out.println("que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(consola.nextLine());
        // validar que elsnack exista en la lista de snack
        var snackEncontrado = false;
        for(var snack: servicioSnacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                // agregamos el snack a la lista de productos
                productos.add(snack);
                System.out.println("ok, snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if(!snackEncontrado){
            System.out.println("id de snack no encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for(var producto: productos){
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total +=producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola,IServicioSnacks servicioSnacks){
        System.out.print("nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.print("precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.print("snack agregado correctamente");
        servicioSnacks.mostrarSnacks();
    }





}
