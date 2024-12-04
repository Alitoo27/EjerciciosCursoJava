
import java.util.Scanner;

public class ValidacionPassword {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println("ingrese su contraseña (6 caracteres minimo): ");
        var contraseña = consola.nextLine();
        while (contraseña.length() < 6){
            System.out.println("contrasela invalida, debe tener 6 caracteres");
            System.out.print("ingresa un nuevo valor de contraseña: ");
            contraseña = consola.nextLine();
        }
        System.out.println("contraseña valida");
    }
}
