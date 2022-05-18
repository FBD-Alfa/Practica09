package alfa.practica09.Servicio;

import alfa.practica09.Modelo.Estetica;
import alfa.practica09.Repositorio.EsteticaRepositorio;
import java.util.List;

/**
 *
 * @author Jesús Alberto Reyes Gutiérrez
 */
public class EsteticaServicio {
    private final EsteticaRepositorio esteticaRepositorio = new EsteticaRepositorio();
    
    /**
     * Metodo que se encarga de obtener a todas las esteticas
     * @return List<> -- Lista de las esteticas.
     * @throws Exception -- En caso de que suceda algun error en la query.
     */
    public List<Estetica> getEsteticas() throws Exception{
        return esteticaRepositorio.getEsteticas();
    }
    
    /**
     * Método que se encarga de insertar un estética.
     * @param estetica -- La estética a insertar.
     * @throws Exception  -- En caso de que suceda algun error en la query.
     */
    public void insertarEstetica(Estetica estetica) throws Exception{
        esteticaRepositorio.insertarEstetica(estetica);
    }
    
    /**
     * Método que se encarga de obtener un estética.
     * @param idEstetica -- El identificado del estetica a buscar.
     * @return Estetica -- Estética buscada.
     * @throws Exception -- En caso de que ocurra algun error en la query.
     */
    public Estetica getEstetica(int idEstetica)throws Exception{
        return esteticaRepositorio.getEstetica(idEstetica);
    }
    
    /**
     * Metodo que actualiza una estética.
     * @param idEstetica -- EL identificador de la estética a buscar.
     * @param estetica -- Los valores nuevos a actualizar.
     * @throws Exception -- En caso de que ocurra algun error.
     */
    public void actualizarEstetica(int idEstetica, Estetica estetica) throws Exception{
        esteticaRepositorio.actualizarEstetica(idEstetica, estetica);
    }
    
    /**
     * Método que borra un estética.
     * @param idEstetica -- El identificador de la estética a borrar.
     * @throws Exception  -- En caso de que ocurra algun error.
     */
    public void borrarEstetica(int idEstetica)throws Exception{
        esteticaRepositorio.borrarEstetica(idEstetica);
    }    
}
