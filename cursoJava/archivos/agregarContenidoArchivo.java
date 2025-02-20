package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class agregarContenidoArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            //revisar si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "Nuevo\ncontenido";
            salida.println(nuevoContenido);
            // guardamos la informacion en el archivo
            salida.close();
            System.out.println("se agrego contenido al archivo...");
        }catch (Exception e){
            System.out.println("error al escribir al archivo: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
