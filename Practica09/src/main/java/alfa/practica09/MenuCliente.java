/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09;

import alfa.practica09.Modelo.Cliente;
import alfa.practica09.Servicio.ClienteServicio;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author annabeth
 */
public class MenuCliente {

    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private Menu menu;
    private final ClienteServicio clientesBase;
    private List<Cliente> clientes = new ArrayList<>();

    public MenuCliente(Menu menu) {
        this.menu = menu;
        this.clientesBase = menu.getClientesBase();

    }

    public void despliegaMenuCliente() throws Exception {
        System.out.println("\n-------[ Elige una opción ]-------\n"
                + "1-. Crear Cliente\n"
                + "2-. Leer Clientes\n"
                + "3-. Actualizar Cliente\n"
                + "4-. Borrar Cliente\n"
                + "5-. Regresar al menu anterior\n"
                + "6-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println("Eligio Crear Cliente");
                despliegaClienteNuevo();
                break;
            case "2":
                System.out.println("Eligio Leer Clientes");
                clientes = clientesBase.getClientes();
                for (Cliente c : clientes) {
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

    public void despliegaClienteNuevo() throws Exception {
        String apellidoM, apellidoP, nombre, estado, calle, email;
        String curpV = verificaCURP();
        System.out.println("Escribe el apellido materno del nuevo cliente");
        apellidoM = entrada.nextLine();
        System.out.println("Escribe el epellido paterno del nuevo cliente");
        apellidoP = entrada.nextLine();
        System.out.println("Escribe el nombre del nuevo cliente");
        nombre = entrada.nextLine();
        System.out.println("Escribe el estado del nuevo cliente");
        estado = entrada.nextLine();
        System.out.println("Escribe la calle del nuevo cliente");
        calle = entrada.nextLine();
        int numeroV = verificaNumero();
        int cpV = verificaCP();
        long telefonoV = verificaTelefono();
        Date cumpleaniosV = verificaCumpleanios();
        System.out.println("Escribe el email del nuevo cliente");
        email = entrada.nextLine();
        boolean esFrecuenteV = verificaEsFrecuente();
        Cliente c = new Cliente(curpV,
                apellidoM,
                apellidoP,
                nombre,
                estado,
                calle,
                numeroV,
                cpV,
                telefonoV,
                cumpleaniosV,
                email,
                esFrecuenteV);
        clientesBase.insertarCliente(c);
    }
    
    public String verificaCURP(){
        System.out.println("Escribe el curp del nuevo cliente con el formato LLLLNNNNNNLLLLLLNN\n"+
                           "Donde L es una letra en mayuscula y N es un número.");
        String curp = entrada.nextLine();
        if (curp.length() == 18){
            return curp;
        }else{
        System.out.println("El CURP debe de ser de 18 elementos, vuelva a intentarlo");
        verificaCURP();
        }
        return "";
    }

    public int verificaCP() {
        System.out.println("Escribe el cp del nuevo cliente");
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
        System.out.println("Escribe el numero exterior del nuevo cliente");
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

    public boolean verificaEsFrecuente() {
        System.out.println("Escribe si, si el nuevo cliente es frecuente, no, en caso contrario");
        String esFrecuente = entrada.nextLine();
        switch (esFrecuente) {
            case "si":
                return true;
            case "no":
                return false;
            default:
                System.out.println("Da un valor valido");
                verificaEsFrecuente();
                return false;
        }
    }

    public long verificaTelefono() {
        System.out.println("Escribe el telefono del nuevo cliente");
        String telefono = entrada.nextLine();
        if (telefono.length() != 10) {
            System.out.println("Ocurrio un error, el telefono no es valido,"
                    + "tiene más de 10 digitos.\nVuelva a intentarlo.");
            verificaTelefono();
        } else {
            try {
                long telefonoValido = Long.parseLong(telefono);
                return telefonoValido;
            } catch (NumberFormatException ex) {
                //ex.printStackTrace();
                System.out.println("Ocurrio un error, el telefono no es valido,vuelva a intentarlo");
                verificaTelefono();
                return 0;
            }
        }
        return 0;
    }

    public Date verificaCumpleanios() {
        System.out.println("Escribe el cumpleaños del nuevo cliente");
        String cumpleanios = entrada.nextLine();
        try {
            Date cumpleaniosValido = Date.valueOf(cumpleanios);
            return cumpleaniosValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error, el cumpleaños no es valido,vuelva a intentarlo");
            verificaCumpleanios();
            return null;
        }
    }
}
