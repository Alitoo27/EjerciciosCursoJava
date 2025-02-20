package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class leerArchivos {
    public static void main(String[] args) {
        // leer el archivo
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            System.out.println("contenido del archivo: ");
            // abrir el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // leemos linea a linea el archivo
            var linea = entrada.readLine();
            // leemos todas las lineas
            while(linea != null){
                System.out.println(linea);
                // antes de terminar el ciclo, nos movvemos a la siguiente linea
                linea = entrada.readLine();
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("error al leer el archivo: "+e);
        }
    }
}
