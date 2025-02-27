package Ejercicios;

import java.util.Scanner;

public class recetaCocina {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println("---Receta Cocina---");
        System.out.print("nombre de la receta: ");
        var nombre = consola.nextLine();
        System.out.print("ingrese los ingredientes: ");
        var ingredientes = consola.nextLine();
        System.out.print("tiempo de preparacion (min): ");
        var tiempo = Integer.parseInt(consola.nextLine());
        System.out.print("dificultad: ");
        var dificultad = consola.nextLine();
        System.out.println();
        System.out.println("nombre receta: "+nombre);
        System.out.println("ingredientes: "+ingredientes);
        System.out.println("tiempo de preparacion: "+tiempo+" min");
        System.out.println("dificultad: "+dificultad);
    }
}
