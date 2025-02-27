package Ejercicios;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        var saldo = 5000.00;
        var salir = false;

        while (!salir){
            System.out.print("""
                    *** Cajero Automatico ***
                    Menu:
                    1. Consultar saldo
                    2. Retirar
                    3. Depositar
                    4. Salir
                    Escoje una opcion: \s
                    """);
            var opcion = consola.nextInt();
            switch (opcion){
                case 1 -> System.out.println("saldo disponible: "+ saldo);
                case 2 -> {
                    System.out.println("ingrese monto a retirar: ");
                    var retiro = Double.parseDouble(consola.nextLine());
                    if (retiro > saldo){
                        System.out.println("saldo insuficiente");
                    }
                    else {
                        saldo = saldo - retiro;
                        System.out.println("retiro exitoso");
                        System.out.println("saldo disponible: "+ saldo);
                    }
                }
                case 3 -> {
                    System.out.println("ingrese monto a depositar: ");
                    var deposito = Double.parseDouble(consola.nextLine());
                    saldo = saldo + deposito;
                    System.out.println("deposito exitoso");
                    System.out.println("saldo disponible: "+ saldo);
                }
                case 4 -> {
                    salir = true;
                }
                default -> System.out.println("opcion invalida");
            }
        }
    }
}
