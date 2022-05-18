/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09.Modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author alex89
 */
public class Cliente {
    private String curp;
    private String apellidoM;
    private String apellidoP;
    private String nombre;
    private String estado;
    private String calle;
    private int numero;
    private int cp;  
    private long telefono; 
    private Date cumpleanios; 
    private String email;
    private boolean esFrecuente;

    
     /**
     * Constructor por parametros que crea un cliente
     * @param curp -- El CURP del cliente
     * @param nombre -- El nombre del cliente
     * @param apellidoP-- El apellido Paterno del cliente
     * @param apellidoM -- El apellido Materno del cliente
     * @param estado -- Estado de Residencia del cliente
     * @param numero -- El numero del domicilio del cliente
     * @param calle -- La calle donde vive el cliente
     * @param cp  -- El codigo postal donde vive el cliente
     * @param telefono -- El  el cliente
     * @param cumpleanios-- EL cumpleaños del cliente
     * @param email-- El email del cliente
     * @param esFrecuente-- Si es frecuente o no
     */
    public Cliente(String curp, String apellidoM, String apellidoP, String nombre, String estado, String calle, int numero, int cp, long telefono, Date cumpleanios, String email, boolean esFrecuente) {
        this.curp = curp;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.nombre = nombre;
        this.estado= estado;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.telefono = telefono;
        this.cumpleanios = cumpleanios;
        this.email = email;
        this.esFrecuente = esFrecuente;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Date getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(Date cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEsFrecuente() {
        return esFrecuente;
    }

    public void setEsFrecuente(boolean esFrecuente) {
        this.esFrecuente = esFrecuente;
    }
    
    /**
    * Metodo toString que imprime un operador
    * @return String -- lo que define a un operador
    */
    @Override
    public String toString() {
        return "Cliente{" + "curp=" + curp + ", nombre=" + nombre +
                ", apellidoP=" + apellidoP + ", apellidoM=" +
                apellidoM + ", estado=" + estado + 
                ", calle=" + calle + ", numero=" + numero +
                ", cp=" + cp + ", telefono=" + telefono +
                 ", cumpleaños=" + cumpleanios + 
                ", email=" + email +
                ", esFrecuente=" + esFrecuente + '}';
    }   
    
}
