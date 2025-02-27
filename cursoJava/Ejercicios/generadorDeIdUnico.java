package Ejercicios;

import java.util.Random;
import java.util.Scanner;

public class generadorDeIdUnico {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner consola = new Scanner(System.in);
        System.out.print("ingrese su nombre: ");
        var nombre = consola.nextLine();
        System.out.print("ingrese su apellido: ");
        var apellido = consola.nextLine();
        System.out.print("ingrese su año de nacimiento: ");
        var anio = consola.nextLine();

        var numAleatorio = random.nextInt(9999) + 1;
        var numAleatorioFormat = String.format("%04d",numAleatorio);

        var caracterNombre = nombre.toUpperCase().substring(0,2);
        var caracterApellido = apellido.toUpperCase().substring(0,2);
        var caracterAnio = anio.substring(2);
        
        var idUnico = caracterNombre+caracterApellido+caracterAnio+numAleatorioFormat;
        System.out.printf("""
                %nHola %s,
                \tTu nuevo numero de identificacion (ID) generado por el sistema es:
                \t%s
                \tFelicidades!
                """,nombre,idUnico);
    }
}
