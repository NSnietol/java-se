/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 * 
 * @author andre
 */
public class Cliente {
    private int tiempoServicio;
    private int TiempoLlegada;
    private String tipo;
    private ArrayList<String> comida;
    private String genero;

    public Cliente() {
        comida=new ArrayList<>();
    }

    /**
     * @param tiempoServicio     tiempo que tarda la persona desde que la atienden hasta que se va 
     * @param TiempoLlegada     tiempo que tarda en llegar  las instalaciones
     * @param tipo              hace referencia a las categorias de las edades (Adulto,Joven, Adulto Mayor)
     * @param comida            Hace referencias a los distintos alimentos suministrados por la cafeteria
     * @param genero     
     */
    public Cliente(int tiempoServicio, int TiempoLlegada, String tipo, ArrayList<String> comida, String genero) {
        this.tiempoServicio = tiempoServicio;
        this.TiempoLlegada = TiempoLlegada;
        this.tipo = tipo;
        this.comida = comida;
        this.genero = genero;
    }


    public ArrayList<String> getComida() {
        return comida;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setComida(ArrayList<String> comida) {
        this.comida = comida;
    }

 
    

    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public int getTiempoLlegada() {
        return TiempoLlegada;
    }

    public void setTiempoLlegada(int TiempoLlegada) {
        this.TiempoLlegada = TiempoLlegada;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTiempoServicio() {
        return tiempoServicio*0.8;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    
}
