/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generadorMixto;

import java.util.ArrayList;

/**
 *
 * @author Jesus esta clase hace brujeria
 */
public class Respuesta extends ArrayList<Double[]>{
    String salida;

    public Respuesta(String salida) {
        this.salida = salida;
    }
    
    
    public Respuesta() {
        this.salida = "";
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public void showMensaje(String mensaje){
        this.salida += mensaje;
    } 
}
