package alfa.practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import alfa.practica09.Conexion.ConexionBD;
import alfa.practica09.Modelo.Estetica;

/**
 * Clase que permite las operaciones CRUD de la tabla estetica de la base de 
 * datos
 * @author alex89
 * @version  
 */
public class EsteticaRepositorio {
    private final ConexionBD conexion = new ConexionBD();
    //Objeto para ejecutar queries
    private Statement stmt;
    //Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;
    
    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de los esteticas
     * @return List<> -- Una lista de estéticas
     * @throws SQLException -- Excepcion que sale si no se logra a hacer 
     * la query de la consulta o la conexion
     */
    public List<Estetica> getEsteticas() throws SQLException{
        String query = "SELECT * FROM estetica"; //Escribimos nuestra query
        List esteticaLista = new ArrayList<Estetica>();
        try{
            //Nos conectamos a la base de datos
            conexion.conectar();
            //Preparamos la base de datos
           stmt = conexion.prepararDeclaracion();
           //Ejecuto mi query y me regresa un iterador
           ResultSet rs = stmt.executeQuery(query);
           while(rs.next()){
               Estetica op = new Estetica(
               rs.getInt("idEstetica"),
               rs.getString("nombre"),
               rs.getString("estado"),  
               rs.getString("calle"),
               rs.getInt("numero"),
               rs.getInt("cp"),
               rs.getInt("horario"),
               rs.getInt("noConsultorio"));
               //Agrego el resultado
               esteticaLista.add(op);
           }        
        }catch(SQLException sql){
            sql.printStackTrace();
        }finally{
            try{
                conexion.cerrar();
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        }
        return esteticaLista;
    }
    
    /**
     * Metodo que obtiene a un estetica dentro de la base a partir de su curp
     * @param idEstetica -- El identificador de la estética buscada.
     * @return Estetica -- El estetica en caso de encontrarse, null en otro caso.
     * @throws SQLException --Excepcion que sale si no se logra a hacer 
     * la query de la consulta o la conexion
     */
    public Estetica getEstetica(int idEstetica) throws SQLException{
        String query = "SELECT * FROM estetica WHERE idEstetica = ?";
        Estetica op = null;
        try{
            //Conectamos a la Base
            conexion.conectar();
            //Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            //Modificamos la consulta, para ver que sustituira
            ps.setInt(1, idEstetica);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               op = new Estetica(
               rs.getInt("idEstetica"),
               rs.getString("nombre"),
               rs.getString("estado"),  
               rs.getString("calle"),
               rs.getInt("numero"),
               rs.getInt("cp"),
               rs.getInt("horario"),
               rs.getInt("noConsultorio"));
            }
        }catch(SQLException sql){
            sql.printStackTrace();
        }finally{
            try{
                conexion.cerrar();
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        }
        return op;
    }
    
    /**
     * Metodo que inserta un estetica dentro de la base de datos
     * @param estetica -- El estetica que deseamos insertar en la base de datos
     */
    public void insertarEstetica(Estetica estetica){
        String query = "INSERT INTO estetica (idEstetica, nombre, estado, "
                + "calle, numero, cp, horario, noConsultorio) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try{
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);       
            ps.setInt(1, estetica.getIdEstetica());
            ps.setString(2, estetica.getNombre());
            ps.setString(3, estetica.getEstado());
            ps.setString(4, estetica.getCalle());
            ps.setInt(5, estetica.getNumero());
            ps.setInt(6, estetica.getCp());
            ps.setInt(7, estetica.getHorario());
            ps.setInt(8, estetica.getNoConsultorio());
            ps.executeUpdate();
        }catch(SQLException sql){
            sql.printStackTrace();
        }finally{
            try{
                conexion.cerrar();
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        } 
    }
    
    /**
     * Método que actualiza una estética dentro de la base de datos.
     * @param idEstetica -- El identificador del estetica a actualizar.
     * @param estetica -- La estética que vamos a intercambiar sus valores.
     */
    public void actualizarEstetica(int idEstetica, Estetica estetica){
        String query = "UPDATE estetica SET idEstetica = ?, nombre = ?, "
                + "estado = ?, calle = ?, numero = ?, cp = ?, horario = ?, "
                + "noConsultorio = ? WHERE idEstetica = ?";
        try{
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, estetica.getIdEstetica());
            ps.setString(2, estetica.getNombre());
            ps.setString(3, estetica.getEstado());
            ps.setString(4, estetica.getCalle());
            ps.setInt(5, estetica.getNumero());
            ps.setInt(6, estetica.getCp());
            ps.setInt(7, estetica.getHorario());
            ps.setInt(8, estetica.getNoConsultorio());
            ps.setInt(9, idEstetica);
            ps.executeUpdate();
        }catch(SQLException sql){
            sql.printStackTrace();
        }finally{
            try{
                conexion.cerrar();
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        } 
    }
    
    /**
     * Metodo para borrar un estetica
     * @param idEstetica -- Identificador de la estética a eliminar.
     * @return Boolean -- true si se realizo, false en caso contrario.
     */
    public Boolean borrarEstetica(int idEstetica){
        String query = "DELETE FROM estetica WHERE idEstetica = ?";
        boolean ok = false;
        try{
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, idEstetica);
            ps.executeUpdate();
            ok = true;
        }catch(SQLException sql){
            sql.printStackTrace();
        }finally{
            try{
                conexion.cerrar();
            }catch(SQLException sql){
                sql.printStackTrace();
            }
        } 
        return ok;
    }
    
}