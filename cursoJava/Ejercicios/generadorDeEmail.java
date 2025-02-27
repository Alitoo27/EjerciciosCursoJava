package Ejercicios;

public class generadorDeEmail {
    public static void main(String[] args) {
        System.out.println("*** generador de email***");
        var nombre = "Ubaldo Acosta Soto";
        var nombreUsuario = nombre.replace(" ", ".").toLowerCase();
        // System.out.println("nombreUsuario = " + nombreUsuario);
        var nombreEmpresa = "Global Mentoring";
        var extensionDominio = ".com.mx";
        var Dominio = nombreEmpresa.toLowerCase().replace(" ", "") + extensionDominio;
        System.out.println("email generado: "+nombreUsuario+"@"+Dominio);

    }
}
