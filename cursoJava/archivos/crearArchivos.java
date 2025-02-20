package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class crearArchivos {
    public static void main(String[] args) {
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            if(archivo.exists()){
                System.out.println("el archivo ya existe");
            } else {
                //creamos el archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("se ha creado el archivo");
            }
        } catch (IOException e){
            System.out.println("error al crear el archivo" + e.getMessage());
            e.printStackTrace();
        }
    }
}
