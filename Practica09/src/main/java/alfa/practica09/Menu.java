
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
 *
 * @author annabeth
 */
public class Menu {
    
    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private ClienteServicio clientesBase;
    private EsteticaServicio esteticasBase;
    //private EsteticaServicio esteticasBase;
    
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
    
    public void setClientesBase(ClienteServicio clientesBase){
        this.clientesBase = clientesBase;
    }
    
    public ClienteServicio getClientesBase(){
        return clientesBase;
    }
    
    public void setEsteticasBase(EsteticaServicio esteticasBase){
        this.esteticasBase = esteticasBase;
    }
    
    public EsteticaServicio getEsteticasBase(){
        return esteticasBase;
    }
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
