package alfa.practica09.Servicio;

import alfa.practica09.Modelo.Cliente;
import alfa.practica09.Repositorio.ClienteRepositorio;
import java.util.List;

/**
 *
 * @author alex89
 */
public class ClienteServicio {
    private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    
    /**
     * Metodo que se encarga de obtener a todos los clientes
     * @return List<Cliente> -- La lista de los clientes
     * @throws Exception
     * -- En caso de que suceda algun error
     */
    public List<Cliente> getClientes() throws Exception{
        return clienteRepositorio.getClientes();
    }
    
    /**
     * Metodo que se encarga de insertar un cliente
     * @param cliente -- EL cliente a insertar
     * @throws Exception  -- En caso de que suceda algun error
     */
    public void insertarCliente(Cliente cliente) throws Exception{
        clienteRepositorio.insertarCliente(cliente);
    }
    
    /**
     * Metodo que se encarga de obtener un cliente
     * @param curp -- El curp del cliente a buscar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public Cliente getCliente(String curp)throws Exception{
        return clienteRepositorio.getCliente(curp);
    }
    
    /**
     * Metodo que actualiza un cliente
     * @param curp -- EL curp del cliente a buscar
     * @param cliente -- Los valores nuevos a actualizar
     * @throws Exception -- En caso de que ocurra algun error 
     */
    public void actualizarCliente(String curp, Cliente cliente)throws Exception{
        clienteRepositorio.actualizarCliente(curp, cliente);
    }
    
    /**
     * Metodo que borra un cliente
     * @param curp -- El curp del cliente a borrar
     * @throws Exception  -- EN caso de que ocurra algun error
     */
    public void borrarCliente(String curp)throws Exception{
        clienteRepositorio.borrarCliente(curp);
    }    
}
