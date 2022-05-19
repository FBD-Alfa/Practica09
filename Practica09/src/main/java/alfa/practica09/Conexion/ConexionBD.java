package alfa.practica09.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que contiene los métodos para poder establecer una conexión con
 * nuestra base de datos.
 * @author alex89
 */
public class ConexionBD {
    Connection conexion=null;
    
    /**
     * Método para conectar la BD.
     * @throws SQLException -- Cuando no fue posible establecer la conexión.
     */
    public void conectar () throws SQLException{
        //driver:SMBD:puerto:ruta/BD
       String jdbc="jdbc:postgresql://localhost:5432/postgres";
       conexion=DriverManager.getConnection(jdbc,"postgres","fbd2022");
       System.out.println("Conexión Exitosa");
       
    }
    
     /**
     * Metodo que se encarga de preparar la base de datos para recibir una 
     * sentencia.
     * @return Statement -- Objeto que utilizaremos para crear sentencias sql.
     * @throws SQLException -- Si no se logra preparar lanza un error.
     */
    public Statement prepararDeclaracion() throws SQLException{
        return conexion.createStatement();
    }
    
    
    /**
     * Método que se encarga de preparar la base de datos para recibir una 
     * sentencia preparada.
     * @param query -- La query que modificaremos en caso de necesitar parametros
     * @return PreparedStatement -- Objeto que utilizaremos para las sentencias sql
     * @throws SQLException -- Si no se logra prepara lanza un error
     */
    public PreparedStatement prepararDeclaracionPreparada(String query)  throws SQLException{
        return conexion.prepareStatement(query);
    }
    
    /**
     * Método que cierra la conexión con la base de datos.
     * @throws SQLException -- Cuando ocurrió un error al cerrar.
     */
    public void cerrar() throws SQLException{
      conexion.close();
      System.out.println("Conexión cerrada");
    }
    
}
