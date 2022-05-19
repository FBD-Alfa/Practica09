
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09;

import alfa.practica09.Conexion.ConexionBD;
import alfa.practica09.Modelo.Cliente;
import alfa.practica09.Servicio.ClienteServicio;
import alfa.practica09.Servicio.EsteticaServicio;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.List;

/**
 * Clase Menu, la clase que lanza el menu principal.
 * @author cynthia
 * @version 18-MAYO-2022
 */
public class Menu {
    
    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private ClienteServicio clientesBase;
    private EsteticaServicio esteticasBase;
    
    /**
     * Método constructor Menu, crea un Menu.
     */
    public Menu(){
       ConexionBD conexion= new ConexionBD();
       System.out.println("Cargando datos de los clientes y las esteticas...");
       try {
           conexion.conectar();
           clientesBase = new ClienteServicio();
           esteticasBase = new EsteticaServicio();
           conexion.cerrar();
           System.out.println("Listo, los datos se cargaron de manera exitosa...");
       }catch(Exception e){
           e.printStackTrace();
           //System.out.println("Ocurrio un error durante la lectura de los datos");
          
       }
    }
    
    /**
     * Método setClientesBase, cambia los clientes de la base por otros nuevos.
     * @param clientesBase -- Los clientes obtenidos de la base de datos.
     */
    public void setClientesBase(ClienteServicio clientesBase){
        this.clientesBase = clientesBase;
    }
    
    /**
     * Método getClientesBase, regresa los clientes de la base de datos.
     * @return ClienteServicio -- Los clientes de la base de datos.
     */
    public ClienteServicio getClientesBase(){
        return clientesBase;
    }
    
    /**
     * Método setEsteticas, cambia los clientes de la base por otros nuevos.
     * @param esteticasBase -- Las esteticas obtenidas de la base de datos.
     */
    public void setEsteticasBase(EsteticaServicio esteticasBase){
        this.esteticasBase = esteticasBase;
    }
    
     /**
     * Método getEsteticasBase, regresa las esteticas de la base de datos.
     * @return EsteticaServicio -- Las esteticas de la base de datos.
     */
    public EsteticaServicio getEsteticasBase(){
        return esteticasBase;
    }
    
    /**
     *  Método despliegaMenu, despliega el menu principal para elegir si trabajar
     *  sobre clientes o sobre esteticas.
     * @throws java.lang.Exception -- En caso de un error.
     */
    public void despliegaMenu() throws Exception{
        System.out.println("\n-------[ Elige una opción ]-------\n"+
                           "1-. Estetica\n"+
                           "2-. Cliente\n"+
                           "3-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println("Eligio estetica");
                MenuEstetica me = new MenuEstetica(this); 
                me.despliegaMenuEstetica();
                break;
            case "2":
                System.out.println("Eligio Cliente");
                MenuCliente mc = new MenuCliente(this); 
                mc.despliegaMenuCliente();
                break;
            case "3":
            System.out.println("\n----------------[ FIN DEL PROGRAMA ADIÓS T-T ]---------------\n");
            System.exit(0);
            break;

            default:
            System.out.println("Esa opción no es valida, vuelvelo a intentar.\n");
            break;
        }
        despliegaMenu();
    }
  
}
