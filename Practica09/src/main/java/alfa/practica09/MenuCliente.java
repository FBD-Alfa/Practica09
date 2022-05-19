/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alfa.practica09;

import alfa.practica09.Modelo.Cliente;
import alfa.practica09.Servicio.ClienteServicio;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que modela un MenuCliente.
 * @author Cynthia
 * @version 18-MAYO-2022
 */
public class MenuCliente {

    private final Scanner entrada = new Scanner(System.in);
    private String eleccion = "";
    private Menu menu;
    private final ClienteServicio clientesBase;
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Método constructor MenuCliente.
     * @param menu, el menu principal.
     */
    public MenuCliente(Menu menu) {
        this.menu = menu;
        this.clientesBase = menu.getClientesBase();

    }
    
    /**
     * Método despliegaMenuCliente
     * Despliega las opciones principales entre las que puede elegir el usuario
     * para manipular a los clientes.
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public void despliegaMenuCliente() throws Exception {
        System.out.println("\n-------[ Elige una opción ]-------\n"
                + "1-. Crear Cliente.\n"
                + "2-. Leer Clientes.\n"
                + "3-. Ver Cliente\n"
                + "4-. Actualizar Cliente.\n"
                + "5-. Borrar Cliente.\n"
                + "6-. Regresar al menu anterior.\n"
                + "7-. Salir.");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                System.out.println("Eligió Crear Cliente.");
                despliegaClienteNuevo();
                break;
            case "2":
                System.out.println("Eligió Leer Clientes.");
                clientes = clientesBase.getClientes();
                for (Cliente c : clientes) {
                    System.out.println(c);
                }
                break;
            case "3":
                System.out.println("Eligió Leer la información de un Cliente.");
                System.out.println("Ingrese el CURP del cliente que desea consultar:");
                String curp2 = entrada.nextLine();   
                if (curp2.length() == 18) {
                Cliente cli = clientesBase.getCliente(curp2);
                   if (cli != null) {
                    System.out.println("La información del clientes es:");
                    System.out.println(cli.toString());
                   }else{
                    System.out.println("El curp ingresado no existe.");
                    despliegaMenuCliente();
                   }
                } else {
                 System.out.println("El CURP debe de ser de 18 elementos, vuelva a intentarlo");
                 despliegaMenuCliente();
                }                
                break;  
            case "4":
                System.out.println("Eligió Actualizar Cliente.");
                System.out.println("Ingrese el CURP del cliente a editar:");
                String curp = entrada.nextLine();
                Cliente c = dameCliente(curp);
                if (c != null){
                    editaCliente(curp,c);
                }else{
                    System.out.println("El curp ingresado no existe.");
                    despliegaMenuCliente();
                }
                break;
            case "5":
                System.out.println("Eligió Borrar Cliente.");
                System.out.println("Ingrese el CURP del cliente a eliminar:");
                String curpE = entrada.nextLine();
                Cliente ce = dameCliente(curpE);
                if (ce != null){
                    clientesBase.borrarCliente(curpE);
                }else{
                    System.out.println("El curp ingresado no existe.");
                    despliegaMenuCliente();
                }
                break;
            case "6":
                System.out.println("Eligió Regresar al menu anterior.");
                menu.despliegaMenu();
                break;
            case "7":
                System.out.println("\n----------------[ FIN DEL PROGRAMA ADIÓS T-T ]---------------\n");
                System.exit(0);
                break;

            default:
                System.out.println("Esa opción no es valida, vuelvelo a intentar.\n");
                despliegaMenuCliente();
                break;
        }
    }
    
    /**
     * Método despliegaClienteNuevo
     * Despliega las instrucciones para la creación de un nuevo cliente.
     * @throws Exception -- Manda una excepción si ocurre un error
     */
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
        clientes = clientesBase.getClientes();
    }
    
    /**
     * Método verificaCURP
     * Verifica que el curp sea una cadena de longitud 18.
     * @return String -- El curp ya revisado.
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public String verificaCURP() throws Exception {
        clientes = clientesBase.getClientes();
        System.out.println("Escribe el curp del cliente con el formato LLLLNNNNNNLLLLLLNN.\n"
                         + "Donde L es una letra en mayuscula y N es un número.");
        String curp = entrada.nextLine();
        if (curp.length() == 18) {
            Cliente c = dameCliente(curp);
            if (c != null) {
                    System.out.println("El cliente ya existe, el CURP ingresado ya se encuentra en la base.");
                    System.out.println(c.toString());
                    return verificaCURP();
            }
            return curp;
        } else {
            System.out.println("El CURP debe de ser de 18 elementos, vuelva a intentarlo");
            return verificaCURP();
        }
    }
    
    
    /**
     * Método verificaCP
     * Verifica que el cp sea un entero valido.
     * @return int -- El cp ya revisado.
     */
    public int verificaCP() {
        System.out.println("Escribe el CP del cliente:");
        String cp = entrada.nextLine();
        try {
            int cpValido = Integer.parseInt(cp);
            return cpValido;
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Ocurrio un error. El CP no es valido, vuelva a intentarlo.");
            return verificaCP();
        }
    }
    
    /**
     * Método verificaNumero
     * Verifica que el numero sea un entero valido.
     * @return int -- El numero ya revisado.
     */
    public int verificaNumero() {
        System.out.println("Escribe el número exterior del cliente:");
        String numero = entrada.nextLine();
        try {
            int numeroValido = Integer.parseInt(numero);
            return numeroValido;
        } catch (NumberFormatException ex) {
            System.out.println("Ocurrio un error. El número no es valido, vuelva a intentarlo.");
            return verificaNumero();
        }
    }
    
    /**
     * Método verificaEsFrecuente
     * Transforma la opción ingresada por el usuario a un valor boolean.
     * @return boolean -- El valor de esFrecuente.
     */
    public boolean verificaEsFrecuente() {
        System.out.println("¿El cliente es frecuente?\n"
                + "1-. Si\n"
                + "2-. No");
        String esFrecuente = entrada.nextLine();
        switch (esFrecuente) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                System.out.println("Da un valor valido");
                return verificaEsFrecuente();
        }
    }
    
    /**
     * Método verificaTelefono
     * Verifica que el telefono sea un long valido de 10 digitos.
     * @return long -- El telefono ya revisado.
     */
    public long verificaTelefono() {
        System.out.println("Escribe el telefono del cliente:");
        String telefono = entrada.nextLine();
        if (telefono.length() != 10) {
            System.out.println("Ocurrio un error. El telefono no es valido, "
                    + "no cuenta con 10 digitos.\nVuelva a intentarlo.");
            return verificaTelefono();
        } else {
            try {
                long telefonoValido = Long.parseLong(telefono);
                return telefonoValido;
            } catch (NumberFormatException ex) {
                System.out.println("Ocurrio un error, el telefono no es valido.\n"
                        + "Vuelva a intentarlo");
                return verificaTelefono();
            }
        }
    }
    
    /**
     * Método verificaCumpleanios
     * Verifica que el cumpleanios este escrito en un formato de fecha valido.
     * @return Date -- El cumpleanios ya revisado.
     */
    public Date verificaCumpleanios() {
        System.out.println("Escribe el cumpleaños del cliente.\n"
                + "El formato del cumpleaños debe ser AAAA-MM-DD.");
        String cumpleanios = entrada.nextLine();
        try {
            Date cumpleaniosValido = Date.valueOf(cumpleanios);
            return cumpleaniosValido;
        } catch (IllegalArgumentException ex) {
            System.out.println("Ocurrio un error, el cumpleaños no es valido.\n"
                    + "Vuelva a intentarlo");
            return verificaCumpleanios();
        }
    }
    
    /**
     * Método dameCliente
     * Regresa el cliente que tenga el curp proporcionado.
     * @param curp -- El curp proporcionado para localizar el cliente.
     * @return Cliente -- El cliente con el curp.
     * @throws Exception -- Manda una excepción si ocurre un error.
     */
    public Cliente dameCliente(String curp) throws Exception {
        clientes = clientesBase.getClientes();
        for (Cliente c : clientes) {
            if (c.getCurp().equals(curp)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Método editaCliente
     * Cambia algún valor del cliente por uno nuevo.
     * @param curp -- El curp del cliente
     * @param c -- El cliente a editar
     * @throws Exception -- Manda una excepción si ocurre un error
     */
    public void editaCliente(String curp, Cliente c) throws Exception{
        clientes = clientesBase.getClientes();
        System.out.println("\n-------[ Elige una opción a editar]-------\n"
                + "1-. CURP\n"
                + "2-. Apellido Materno\n"
                + "3-. Apellido Paterno\n"
                + "4-. Nombre\n"
                + "5-. Estado\n"
                + "6-. Calle\n"
                + "7-. Número\n"
                + "8-. CP\n"
                + "9-. Telefono\n"
                + "10-. Cumpleaños\n"
                + "11-. Email\n"
                + "12-. esFrecuente\n"
                + "13-. Menu Anterior\n"
                + "14-. Salir");
        eleccion = entrada.nextLine();
        switch (eleccion) {
            case "1":
                String curpV = verificaCURP();
                c.setCurp(curpV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "2":
                System.out.println("Escribe el apellido materno del cliente:");
                String apellidoM = entrada.nextLine();
                c.setApellidoM(apellidoM);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "3":
                System.out.println("Escribe el apellido paterno del cliente:");
                String apellidoP = entrada.nextLine();
                c.setApellidoP(apellidoP);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "4":
                System.out.println("Escribe el nombre del cliente:");
                String nombre = entrada.nextLine();
                c.setNombre(nombre);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "5":
                System.out.println("Escribe el estado del cliente:");
                String estado = entrada.nextLine();
                c.setEstado(estado);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "6":
                System.out.println("Escribe la calle del cliente:");
                String calle = entrada.nextLine();
                c.setCalle(calle);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "7":
                int numeroV = verificaNumero();
                c.setNumero(numeroV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "8":
                int cpV = verificaCP();
                c.setCp(cpV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "9":
                long telefonoV = verificaTelefono();
                c.setTelefono(telefonoV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "10":
                Date cumpleaniosV = verificaCumpleanios();
                c.setCumpleanios(cumpleaniosV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "11":
                System.out.println("Escribe el email del cliente:");
                String email = entrada.nextLine();
                c.setEmail(email);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "12":
                boolean esFrecuenteV = verificaEsFrecuente();
                c.setEsFrecuente(esFrecuenteV);
                clientesBase.actualizarCliente(curp, c);
                break;
            case "13":
                despliegaMenuCliente();
                break;
            case "14":
                System.out.println("\n----------------[ FIN DEL PROGRAMA ADIÓS T-T ]---------------\n");
                System.exit(0);
                break;
            default:
                System.out.println("Esa opción no es valida, vuelvelo a intentar.\n");
                editaCliente(curp, c);
                break;    
        }
    }
}
