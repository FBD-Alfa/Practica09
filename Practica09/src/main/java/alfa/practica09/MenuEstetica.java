/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09;

import alfa.practica09.Modelo.Estetica;
import alfa.practica09.Servicio.EsteticaServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author annabeth
 */
public class MenuEstetica{
    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private Menu menu;
    private final EsteticaServicio esteticasBase;
    private List<Estetica> esteticas = new ArrayList<>();
   
    
    public MenuEstetica(Menu menu){
        this.menu = menu;
        this.esteticasBase = menu.getEsteticasBase();
        
    }
    
    public void despliegaMenuEstetica() throws Exception{
           System.out.println("\n-------[ Elige una opción ]-------\n"+
                           "1-. Crear Estetica\n"+
                           "2-. Leer Esteticas\n" +
                           "3-. Actualizar Estetica\n"+
                           "4-. Borrar Estetica\n" +
                           "5-. Regresar al menu anterior\n"+
                           "6-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println("Eligio Crear Estetica");
                break;
            case "2":
                System.out.println("Eligio Leer Esteticas");
                esteticas = esteticasBase.getEsteticas();
                for (Estetica c : esteticas){
                    System.out.println(c);
                }
                break;
            case "3":
                System.out.println("Eligio Actualizar Estetica");
                break;
            case "4":
                System.out.println("Eligio Borrar Estetica");
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
        despliegaMenuEstetica();
    }
    
}
