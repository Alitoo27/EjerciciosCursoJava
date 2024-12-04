import java.util.Scanner;

public class calculoRectangulo {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println("*** calculo rectangulo ***");
        System.out.print("ingrese la base del rectangulo: ");
        var base = Integer.parseInt(consola.nextLine());
        System.out.print("ingrese el alto del rectangulo: ");
        var altura = Integer.parseInt(consola.nextLine());

        var area = base * altura;
        var perimetro = (base + altura) * 2;

        System.out.printf("""
                area: %d
                perimetro: %d
                """, area, perimetro);
    }
}
