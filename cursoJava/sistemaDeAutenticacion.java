import java.util.Scanner;

public class sistemaDeAutenticacion {
    public static void main(String[] args) {

        final var USUARIO_REGISTRADO = "Alitoo";
        final var CONTRASEÑA_REGISTRADA = "1234";
        var consola = new Scanner(System.in);
        System.out.print("ingrese su usuario: ");
        var usuarioIngresado = consola.nextLine();
        System.out.print("ingrese su contraseña: ");
        var contraseñaIngresada = consola.nextLine();

        var usuarioValido = usuarioIngresado.equals(USUARIO_REGISTRADO) && contraseñaIngresada.equals(CONTRASEÑA_REGISTRADA);
        System.out.print("el usuario ingresado es valido?: "+usuarioValido);

    }
}
