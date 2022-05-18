package alfa.practica09.Modelo;

/**
 * Clase que representa una estética veterinaria de Little Friend.
 * @author Jesús Alberto Reyes Gutiérrez
 * @version 21/03/2022
 */
public class Estetica {
    private int idEstetica;
    private String nombre;
    private String estado;
    private String calle;
    private int numero;
    private int cp;
    private int horario;
    private int noConsultorio;

    /**
     * Constructor con todos los atributos.
     * @param idEstetica -- Es el identificador de la estética.
     * @param nombre -- Es el nombre de la estética.
     * @param estado --  Es el estado de la dirección de la estética.
     * @param calle -- Es la calle de la dirección de la estética.
     * @param numero -- Es el número de la dirección de la estética.
     * @param cp -- Es el código postal de la dirección de la estética.
     * @param horario -- Es el horario de servicio de la estética.
     * @param noConsultorio -- Es la cantidad de consultorios de la estética.
     */
    public Estetica(int idEstetica, String nombre, String estado, String calle, 
            int numero, int cp, int horario, int noConsultorio) {    
        this.idEstetica = idEstetica;
        this.nombre = nombre;
        this.estado = estado;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.horario = horario;
        this.noConsultorio = noConsultorio;
    }

    /**
     * Obtiene el identificador de la estética.
     * @return -- El identificador de la estética.
     */
    public int getIdEstetica() {
        return idEstetica;
    }

    /**
     * Modifica el identificador de la estética.
     * @param idEstetica -- El nuevo identificador de la estética.
     */
    public void setIdEstetica(int idEstetica) {
        this.idEstetica = idEstetica;
    }

    /**
     * Obtiene el nombre de la estética.
     * @return -- El nombre de la estética.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la estética.
     * @param nombre -- El nuevo nombre de la estética
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el estado de la dirección de la estética.
     * @return -- El estado de la dirección de la estética.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la dirección de la estética.
     * @param estado -- El nuevo estdo de la dirección de la estética.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la calle de la dirección de la estética.
     * @return -- La dirección de la dirección de la estética.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica la calle de la dirección de la estética.
     * @param calle -- La nueva calle de la dirección de la estética.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección de la estética.
     * @return -- El número de la dirección de la estética.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifica el número de la dirección de la estética.
     * @param numero -- El nuevo número de la dirección de la estética.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el código postal de la dirección de la estética.
     * @return -- El código postal de la dirección de la estética.
     */
    public int getCp() {
        return cp;
    }
 
    /**
     * Modifica el código postal de de la dirección de la estética.
     * @param cp -- El nuevo código postal de la dirección de la estética.
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Obtiene el horario de la estética.
     * @return -- El horario de la estética.
     */
    public int getHorario() {
        return horario;
    }

    /**
     * Modifica el horario de la estética.
     * @param horario -- El nuevo horario de la estética.
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * Obtiene el número de consultorios de la estética.
     * @return -- El número de consultorios de la estética.
     */
    public int getNoConsultorio() {
        return noConsultorio;
    }

    /**
     * Modifica el número de consultorios de la estética.
     * @param noConsultorio -- El nuevo número de consultorios.
     */
    public void setNoConsultorio(int noConsultorio) {
        this.noConsultorio = noConsultorio;
    }

    /**
     * Método toString de una Estética.
     * @return -- Los atributos de la estética separados por coma en una cadena.
     */
    @Override
    public String toString() {
        return this.idEstetica + "," + this.nombre + "," +
        horario + "," + noConsultorio;
    }
}
