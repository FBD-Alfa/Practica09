/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09;

import alfa.practica09.Modelo.Cliente;
import alfa.practica09.Servicio.ClienteServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author annabeth
 */
public class MenuCliente{
    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private Menu menu;
    private final ClienteServicio clientesBase;
    private List<Cliente> clientes = new ArrayList<>();
   
    
    public MenuCliente(Menu menu){
        this.menu = menu;
        this.clientesBase = menu.getClientesBase();
        
    }
    
    public void despliegaMenuCliente() throws Exception{
           System.out.println("\n-------[ Elige una opción ]-------\n"+
                           "1-. Crear Cliente\n"+
                           "2-. Leer Clientes\n" +
                           "3-. Actualizar Cliente\n"+
                           "4-. Borrar Cliente\n" +
                           "5-. Regresar al menu anterior\n"+
                           "6-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println("Eligio Crear Cliente");
                break;
            case "2":
                System.out.println("Eligio Leer Clientes");
                clientes = clientesBase.getClientes();
                for (Cliente c : clientes){
                    System.out.println(c);
                }
                break;
            case "3":
                System.out.println("Eligio Actualizar Cliente");
                break;
            case "4":
                System.out.println("Eligio Borrar Cliente");
                break;
            case "5":
                System.out.println("Eligio Regresar al menu anterior");
                menu.despliegaMenu();
                break;
            case "6":
            System.out.println("\n----------------[ FIN DEL PROGRAMA ADIÓS T-T ]---------------\n");
            System.exit(0);
            break;

            default:
            System.out.println("Esa opción no es valida, vuelvelo a intentar.\n");
            break;
        }
        despliegaMenuCliente();
    }
    
}
