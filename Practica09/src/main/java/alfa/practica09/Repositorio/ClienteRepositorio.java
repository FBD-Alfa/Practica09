package alfa.practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import alfa.practica09.Conexion.ConexionBD;
import alfa.practica09.Modelo.Cliente;

/**
 * Clase que permite las operaciones CRUD de la tabla cliente de la base de 
 * datos
 * @author alex89
 * @version  
 */
public class ClienteRepositorio {
    private final ConexionBD conexion = new ConexionBD();
    //Objeto para ejecutar queries
    private Statement stmt;
    //Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;
    
    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de los clientes
     * @return List<Cliente> Una lista de clientees
     * @throws SQLException -- Excepcion que sale si no se logra a hacer 
     * la query de la consulta o la conexion
     */
    public List<Cliente> getClientes() throws SQLException{
        String query = "SELECT * FROM cliente"; //Escribimos nuestra query
        List clienteLista = new ArrayList<Cliente>();
        try{
            //Nos conectamos a la base de datos
            conexion.conectar();
            //Preparamos la base de datos
           stmt = conexion.prepararDeclaracion();
           //Ejecuto mi query y me regresa un iterador
           ResultSet rs = stmt.executeQuery(query);
           while(rs.next()){
               //System.out.println(rs.getString("curp"));
               Cliente op = new Cliente(
               rs.getString("curp"),
               rs.getString("apellidoM"),
               rs.getString("apellidoP"),   
               rs.getString("nombre"),
               rs.getString("estado"),
               rs.getString("calle"),
               rs.getInt("numero"),
               rs.getInt("cp"),
               rs.getLong("telefono"),
               rs.getDate("cumpleanios"),
               rs.getString("email"),
               rs.getBoolean("esFrecuente"));
               //Agrego el resultado
               clienteLista.add(op);
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
        return clienteLista;
    }
    
    /**
     * Metodo que obtiene a un cliente dentro de la base a partir de su curp
     * @param curp -- La curp del cliente a buscar
     * @return Cliente -- El cliente en caso de encontrarse null, en otro caso
     * @throws SQLException --Excepcion que sale si no se logra a hacer 
     * la query de la consulta o la conexion
     */
    public Cliente getCliente(String curp) throws SQLException{
        String query = "SELECT * FROM cliente WHERE curp = ?";
        Cliente op = null;
        try{
            //Conectamos a la Base
            conexion.conectar();
            //Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            //Modificamos la consulta, para ver que sustituira
            ps.setString(1, curp);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               op = new Cliente(
               rs.getString("curp"),
               rs.getString("apellidoM"),
               rs.getString("apellidoP"),
               rs.getString("nombre"),
               rs.getString("estado"),
               rs.getString("calle"),
               rs.getInt("numero"),
               rs.getInt("cp"),
               rs.getLong("telefono"),
               rs.getDate("cumpleanios"),
               rs.getString("email"),
               rs.getBoolean("esFrecuente"));
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
     * Metodo que inserta un cliente dentro de la base de datos
     * @param cliente -- El cliente que deseamos insertar en la base de datos
     */
    public void insertarCliente(Cliente cliente){
        String query = "INSERT INTO cliente "
                + "(curp, apellidoM, apellidoP, nombre, estado, "
                + "calle, numero, cp, telefono, cumpleanios, email, esFrecuente)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);       
            ps.setString(1, cliente.getCurp());
            ps.setString(2, cliente.getApellidoM());
            ps.setString(3, cliente.getApellidoP());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getEstado());
            ps.setString(6, cliente.getCalle());
            ps.setInt(7, cliente.getNumero());
            ps.setInt(8, cliente.getCp());
            ps.setLong(9, cliente.getTelefono());
            ps.setDate(10, cliente.getCumpleanios());
            ps.setString(11, cliente.getEmail());
            ps.setBoolean(12, cliente.getEsFrecuente());
            ps.executeUpdate();    //Utilizamos esta instruccion para insertar y actualizar
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
     * Metodo que actualiza un cliente dentro de la base de datos
     * @param curp -- El curp del cliente a buscar para actualizar
     * @param cliente -- El cliente que vamos a intercambiar sus valores
     */
    public void actualizarCliente(String curp, Cliente cliente){
        String query = "UPDATE cliente SET curp = ?, apellidoM = ?, apellidoP = ?, nombre = ?, "
                + "estado = ?, calle = ?, numero = ?, cp = ?, telefono = ?, cumpleanios = ?, "
                + "email = ?, esFrecuente = ? WHERE curp = ?";
        try{
            conexion.conectar();;
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, cliente.getCurp());
            ps.setString(2, cliente.getApellidoM());
            ps.setString(3, cliente.getApellidoP());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getEstado());
            ps.setString(6, cliente.getCalle());
            ps.setInt(7, cliente.getNumero());
            ps.setInt(8, cliente.getCp());
            ps.setLong(9, cliente.getTelefono());
            ps.setDate(10, cliente.getCumpleanios());
            ps.setString(11, cliente.getEmail());
            ps.setBoolean(12, cliente.getEsFrecuente());
            ps.setString(13, curp);
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
     * Metodo para borrar un cliente
     * @param curp -- Curp del cliente a eliminar
     * @return Boolean -- true si se realizo, false en caso contrario
     */
    public Boolean borrarCliente(String curp){
        String query = "DELETE FROM cliente WHERE curp = ?";
        boolean ok = false;
        try{
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, curp);
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