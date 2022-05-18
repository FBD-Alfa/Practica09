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
            despliegaEsteticaNueva();
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
    public void despliegaEsteticaNueva() throws Exception {
        String nombre, estado, calle;
        int  numero, cp , horario, noConsultorio;
        String idEsteticaV= verificaIDE();
        System.out.println("Escribe el nombre de la nueva estética");
        nombre = entrada.nextLine();
        System.out.println("Escribe el estado de la nueva estética");
        estado = entrada.nextLine();
        System.out.println("Escribe el nombre de la calle de la nueva estética");
        calle = entrada.nextLine();
        int numeroV = verificaNumero();
        int cpV = verificaCP();
        int horarioV = verificaHorario();
        int noConsultoriosV = verificaNoConsultorios();
        Estetica e = new Estetica(idEsteticaV,
                                  nombre,
                                  estado,
                                  calle,
                                  numeroV,
                                  cpV,
                                  horarioV,
                                  noConsultoriosV);
        esteticasBase.insertarEstetica(e);
        esteticas = esteticasBase.getClientes();
    }
    public String verificaIDE() throws Exception{
        esteticas =esteticasBase.getClientes();
        System.out.println("Escribe el ID de la nueva estética que deseas agregar");
        int idEstetica = entrada.nextInt();
        Estetica E = dameEstetica(idEstetica);
        if (E != null){
            System.out.println("La estética ya existe, el ID ingresado ya se encuentra en la base");
            System.out.println(E.toString());
            verificaIDE();
            return "";
        }
        return idEstetica;
    }
    public int verificaCP() {
        System.out.println("Escribe el cp de la nueva Estetica");
        String cp = entrada.nextLine();
        try {
            int cpValido = Integer.parseInt(cp);
            return cpValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error, el cp no es valido,vuelva a intentarlo");
            verificaCP();
            return 0;
        }
    }

    public int verificaNumero() {
        System.out.println("Escribe el numero exterior de la nueva Estetica");
        String numero = entrada.nextLine();
        try {
            int numeroValido = Integer.parseInt(numero);
            return numeroValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error, el numero no es valido,vuelva a intentarlo");
            verificaNumero();
            return 0;
        }
    }
    public int verificaHorario() {
        System.out.println("Escribe el horario de la nueva Estetica");
        String horario = entrada.nextLine();
        try {
            int horarioValido = Integer.parseInt(horario);
            return horarioValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error, el numero no es valido,vuelva a intentarlo");
            verificaHorario();
            return 0;
        }
    }
    public int verificaNoConsultorios() {
        System.out.println("Escribe el número de consultorios de la nueva Estetica");
        String consultorios = entrada.nextLine();
        try {
            int consultoriosValido = Integer.parseInt(consultorios);
            return consultoriosValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error, el numero no es valido,vuelva a intentarlo");
            verificaNoConsultorios();
            return 0;
        }
    }
    public Estetica dameEstetica(int idEstetica) {
        for (Estetica e : esteticas) {
            if (e.getIdEstetica().equals(idEstetica)) {
                return e;
            }
        }
        return null;
    }
}
