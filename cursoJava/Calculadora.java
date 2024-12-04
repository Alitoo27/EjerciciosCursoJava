import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        var salir = false;
        double num1 = 0, num2 = 0, resultado;
        while (!salir) {
            System.out.print("""
                    *** Calculadora ***
                    Menu:
                    1. Sumar
                    2. Restar
                    3. Multiplicar
                    4. Dividir
                    5. Salir
                    Escoje una opcion:\s""");
            var opcion = consola.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.print("ingrese num1: ");
                    num1 = consola.nextDouble();
                    System.out.print("ingrese num2: ");
                    num2 = consola.nextDouble();
                    resultado = num1 + num2;
                    System.out.println("resultado de la operacion: "+ resultado);
                }
                case 2 -> {
                    System.out.print("ingrese num1: ");
                    num1 = consola.nextDouble();
                    System.out.print("ingrese num2: ");
                    num2 = consola.nextDouble();
                    resultado = num1 - num2;
                    System.out.println("resultado de la operacion: "+ resultado);
                }
                case 3 -> {
                    System.out.print("ingrese num1: ");
                    num1 = consola.nextDouble();
                    System.out.print("ingrese num2: ");
                    num2 = consola.nextDouble();
                    resultado = num1 * num2;
                    System.out.println("resultado de la operacion: "+ resultado);
                }
                case 4 -> {
                    System.out.print("ingrese num1: ");
                    num1 = consola.nextDouble();
                    System.out.print("ingrese num2: ");
                    num2 = consola.nextDouble();
                    if(num2 == 0){
                        System.out.println("error al dividir entre 0 (cero)");
                    }
                    else{
                        resultado = num1 % num2;
                        System.out.println("resultado de la operacion: "+ resultado);
                    }
                }
                case 5 -> {
                    System.out.print("saliendo...");
                    salir = true;
                }
                default -> System.out.println("opcion invalida");
            }
        }
    }
}
