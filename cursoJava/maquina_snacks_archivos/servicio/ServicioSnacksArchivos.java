package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    // crear la lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    // constructor clase
    public ServicioSnacksArchivos(){
        //creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try{
            existe = archivo.exists();
            if(existe){
                this.snacks = obtenerSnacks();
            }
            else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("error al crear el archivo: "+ e.getMessage());
        }
        // si no existe, cargamos algunos snacks iniciales
        if(!existe)
            cargarSnacksIniciales();
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("papas", 700));
        this.agregarSnack(new Snack("refresco", 500));
        this.agregarSnack(new Snack("sanguche", 700));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea: lineas){
                String[] lineaSnack = linea.split(","); //parseo separado por coma
                var idSnack = lineaSnack[0];
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                snacks.add(snack); // agregamos el snack leido a la lista

            }
        }catch (Exception e){
            System.out.println("error al leer archivo de snacks: "+ e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        this.snacks.add(snack);
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        }catch (Exception e){
            System.out.println("error al agregar snack: "+e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- snack en el inventario---");
        //mostramos la lista en el archivo
        var inventarioSnack = "";
        for(var snack: this.snacks){
            inventarioSnack += snack.toString() + "\n";
        }
        System.out.println(inventarioSnack);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
