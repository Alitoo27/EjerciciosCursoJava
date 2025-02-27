package Ejercicios;

import java.util.Random;
import java.util.Scanner;

public class juegoAdivinanza {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println("*** juego adivinanza ***");
        var intentos = 0;
        var random = new Random();

        int numAleatorio = random.nextInt(50) + 1;
        System.out.print("introdusca un numero(1-50): ");
        var numero = Integer.parseInt(consola.nextLine());

        while (numAleatorio != numero){
            if(numAleatorio > numero){
                System.out.println("numero incorrecto, numero introducido menor al numero secreto");
                intentos++;
                System.out.print("introdusca un nuevo numero: ");
                numero = Integer.parseInt(consola.nextLine());
            }
            if (numAleatorio < numero){
                System.out.println("numero incorrecto, numero introducido mayor al numero secreto");
                intentos++;
                System.out.print("introdusca un nuevo numero: ");
                numero = Integer.parseInt(consola.nextLine());
            }
        }
        System.out.println("Felicidades!!! has encontrado el numero secreto: " + numAleatorio);
        System.out.println("Numero de intentos: " + intentos);

    }
}
