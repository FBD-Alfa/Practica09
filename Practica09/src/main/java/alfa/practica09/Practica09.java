/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package alfa.practica09;

import alfa.practica09.Conexion.ConexionBD;
import alfa.practica09.Modelo.Estetica;
import alfa.practica09.Servicio.EsteticaServicio;
import java.util.List;

/**
 *
 * @author alex89
 */
public class Practica09 {

    public static void main(String[] args) {
        ConexionBD conexion= new ConexionBD();
        try {
            conexion.conectar();
            EsteticaServicio estetica = new EsteticaServicio();
            List<Estetica> listaEsteticas= estetica.getEsteticas();
            for (int i=0; i<5; i++){
                System.out.println(listaEsteticas.get(i));
            }
            conexion.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
