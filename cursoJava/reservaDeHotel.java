import java.util.Scanner;

public class reservaDeHotel {
    public static void main(String[] args) {
        System.out.println("*** sistema de reserva de hotel ***");
        final var CUARTO_CON_VISTA_MAR = 45000.00;
        final var CUARTO_SIN_VISTA_MAR = 30000.00;
        var precioFinal = 0.00;
        var consola = new Scanner(System.in);
        System.out.print("nombre del cliente: ");
        var cliente = consola.nextLine();
        System.out.print("dias de estadia: ");
        var diasEstadia = Integer.parseInt(consola.nextLine());
        System.out.print("tiene vista al mar?: ");
        var hasVistaMar = Boolean.parseBoolean(consola.nextLine());

        if (hasVistaMar){
            precioFinal = CUARTO_CON_VISTA_MAR * diasEstadia;
        }
        else {
            precioFinal = CUARTO_SIN_VISTA_MAR * diasEstadia;
        }

        System.out.printf("""
                cliente: %s
                dias de estadia: %d
                precio: $%.2f
                tiene vista al mar: %s
                """,cliente, diasEstadia,precioFinal,hasVistaMar);
    }
}
