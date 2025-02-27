package Ejercicios;

import java.util.Scanner;

public class tiendaConDescuento {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        final var MONTO_MIN = 1000;
        double montoFinal = 0;
        System.out.print("ingrese el monto de su compra: ");
        var montoCompra = Double.parseDouble(consola.nextLine());
        System.out.print("eres miembro de la tienda?: ");
        var isMiembro = Boolean.parseBoolean(consola.nextLine());

        if (montoCompra >= MONTO_MIN && isMiembro) {
            montoFinal = montoCompra - (montoCompra * 0.10);
            System.out.print("precio final: "+montoFinal);
        } else if (montoCompra >= MONTO_MIN || isMiembro) {
            montoFinal = montoCompra - (montoCompra * 0.05);
            System.out.print("precio final: "+montoFinal);
        }
        else{
            System.out.print("precio final: "+montoCompra);
        }


    }
}
