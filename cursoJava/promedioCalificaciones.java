import java.util.Scanner;

public class promedioCalificaciones {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.print("proporciona la cantida de notas: ");
        var cantidadNotas = Integer.parseInt(consola.nextLine());
        var notas = new int[cantidadNotas];
        for(var i=0; i<cantidadNotas; i++){
            System.out.print("ingrese la nota n° "+(i+1)+": ");
            notas[i] = Integer.parseInt(consola.nextLine());
        }
        var sumaPromedios = 0;
        for(var i=0; i<cantidadNotas; i++){
            sumaPromedios += notas[i];
        }
        var promedio =sumaPromedios/cantidadNotas;
        System.out.println("promedio calificaciones: "+promedio);
    }
}
