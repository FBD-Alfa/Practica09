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
 * Clase que modela un MenuEstetica.
 * @author Gael
 * @version 18-MAYO-2022
 */
public class MenuEstetica{
    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private Menu menu;
    private final EsteticaServicio esteticasBase;
    private List<Estetica> esteticas = new ArrayList<>();
   
    /**
     * Método constructor MenuEstetica.
     * @param menu, el menu principal.
     */
    public MenuEstetica(Menu menu){
        this.menu = menu;
        this.esteticasBase = menu.getEsteticasBase();
        
    }
    /** Método despliegaMenuEstetica
        * Despliega las opciones principales entre las que puede elegir el usuario
        * para manipular a las esteticas.
        * @throws Exception -- Manda una excepción si ocurre un error
        */
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
            System.out.println("Ingrese el ID de la estética a editar:");
            String estetica0 = entrada.nextLine();
            int estetica= Integer.parseInt(estetica0);
            Estetica e = dameEstetica(estetica);
            if (e != null){
                editaEstetica(estetica,e);
            }else{
                System.out.println("El curp ingresado no existe.");
                 despliegaMenuEstetica();
            }
            break;
        case "4":
            System.out.println("Eligio Borrar Estetica");
            System.out.println("Ingrese el ID de la estética  a eliminar:");
            String IDEsteticaE0 = entrada.nextLine();
            int IDEsteticaE = Integer.parseInt(IDEsteticaE0);
            Estetica ee = dameEstetica(IDEsteticaE);
            if (ee != null){
                esteticasBase.borrarEstetica(IDEsteticaE);
            }else{
                System.out.println("El ID de la estética  ingresado no existe.");
                despliegaMenuEstetica();
            }
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
    /**
     * Método despliegaEsteticaNueva
     * Despliega las instrucciones para la creación de una nueva estética.
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public void despliegaEsteticaNueva() throws Exception {
        String nombre, estado, calle;
        int  numero, cp , horario, noConsultorio;
        int idEsteticaV = verificaIDE();
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
        esteticas = esteticasBase.getEsteticas();
    }
    /**
     * Método verifica el ID
     * Verifica que el curp sea un int.
     * @return int -- El ID ya revisado.
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public int verificaIDE() throws Exception{
        esteticas = esteticasBase.getEsteticas();
        System.out.println("Escribe el ID de la nueva estética que deseas agregar");
        int idEstetica = entrada.nextInt();
        Estetica E = dameEstetica(idEstetica);
        if (E != null){
            System.out.println("La estética ya existe, el ID ingresado ya se encuentra en la base");
            System.out.println(E.toString());
            verificaIDE();
            return 0;
        }
        return idEstetica;
    }
    /**
     * Método verificaCP
     * Verifica que el cp sea un entero valido.
     * @return int -- El cp ya revisado.
     */
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
    /**
     * Método verificaNumero
     * Verifica que el numero sea un entero valido.
     * @return int -- El numero ya revisado.
     */
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
    /**
     * Método verificaHorario
     * Verifica que el horario sea un entero valido.
     * @return int -- El numero ya revisado.
     */
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
    /**
     * Método verificaConsultorios
     * Verifica que el consultorio sea un entero valido.
     * @return int -- El numero ya revisado.
     */
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
    /**
     * Método dameEstetica
     * Regresa la estética que tiene el ID proporcionado.
     * @param idEstetica -- El ID proporcionado para localizar a la estética.
     * @return Estetica -- La estetica con el ID.
     * @throws Exception -- Manda una excepción si ocurre un error.
     */
    public Estetica dameEstetica(int idEstetica) {
        for (Estetica e : esteticas) {
            if (e.getIdEstetica() == idEstetica) {
                return e;
            }
        }
        return null;
    }
    /**
     * Método editaEstetica
     * Cambia algún valor de la estética por uno nuevo.
     * @param estetica -- El ID de la estética
     * @param e -- La estética a editar
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public void editaEstetica(int estetica, Estetica e) throws Exception{
        esteticas = esteticasBase.getEsteticas();
        System.out.println("\n-------[ Elige una opción a editar]-------\n"
                           + "1-. ID Estetica\n"
                           + "2-. Nombre\n"
                           + "3-. Estado\n"
                           + "4-. Calle\n"
                           + "5-. Número\n"
                           + "6-. CP\n"
                           + "7-. Horario\n"
                           + "8-. NoConsultorios\n"
                           + "9-. Menu Anterior\n"
                           + "10-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
        case "1":
            int esteticaV = verificaIDE();
            e.setIdEstetica(esteticaV);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "2":
            System.out.println("Escribe el nombre de la estética:");
            String nombre = entrada.nextLine();
            e.setNombre(nombre);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "3":
            System.out.println("Escribe el estado de la estética:");
            String estado = entrada.nextLine();
            e.setEstado(estado);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "4":
            System.out.println("Escribe la calle de la estética:");
            String calle  = entrada.nextLine();
            e.setCalle(calle);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "5":
            int numeroV = verificaNumero();
            e.setNumero(numeroV);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "6":
            int cpV = verificaCP();
            e.setCp(cpV);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "7":
            int horarioV = verificaHorario();
            e.setHorario(horarioV);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "8":
            int NoConsultoriosV = verificaNoConsultorios();
            e.setNoConsultorio(NoConsultoriosV);
            esteticasBase.actualizarEstetica(estetica, e);
            break;
        case "9":
            despliegaMenuEstetica();
            break;
        case "10":
            System.out.println("\n----------------[ FIN DEL PROGRAMA ADIÓS T-T ]---------------\n");
            System.exit(0);
            break;
        default:
            System.out.println("Esa opción no es valida, vuelvelo a intentar.\n");
            editaEstetica(estetica, e);
            break;    
        }
    }
}
