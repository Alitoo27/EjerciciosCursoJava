import java.util.Scanner;

public class sumaDiagonalMatriz {
    public static void main(String[] args) {
        System.out.println("*** suma diagonal matriz ***");
        int filas = 3, columnas = 3;
        var matriz = new int [filas][columnas];
        var consola = new Scanner(System.in);

        for (var fil=0; fil < filas; fil++){
            for (var col= 0; col < columnas; col++){
                System.out.print("ingrese valor["+fil+"]["+col+"] = ");
                matriz[fil][col] = Integer.parseInt(consola.nextLine());
            }
        }

        var sumaDiagonal = 0;
        for (var fil=0; fil < filas; fil++){
            for (var col= 0; col < columnas; col++){
                if(fil == col)
                    sumaDiagonal += matriz[fil][col];
            }
        }

        for (var fil=0; fil < filas; fil++){
            for (var col= 0; col < columnas; col++){
                System.out.println("matriz["+fil+"]["+col+"] = "+matriz[fil][col]);

            }
        }
        System.out.println();
        System.out.println("suma diagonal: "+sumaDiagonal);

    }
}
