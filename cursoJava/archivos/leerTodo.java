package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class leerTodo {
    public static void main(String[] args) {
        var nombreArchivo = "mi_archivo.txt";
        try{
            // leer todas las lineas de archivo
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("contenido del archivo: ");
            for(String linea: lineas){
                System.out.println(linea);
            }
        }catch (Exception e){
            System.out.println("error al leer archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
