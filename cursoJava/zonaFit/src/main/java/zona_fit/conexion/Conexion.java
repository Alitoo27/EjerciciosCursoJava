package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static public Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "12345";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("error al conectarnos a la BD: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if(conexion != null)
            System.out.println("conexion exitosa" + conexion);
        else
            System.out.println("error al conectarse");
    }

}
