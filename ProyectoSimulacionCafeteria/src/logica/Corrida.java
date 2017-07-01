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
public class Corrida {

    ArrayList<Cliente> clientes;

    public Corrida(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Corrida() {
        clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     Apartir de una instancia de corrida crea todos los valores correspondientes a los clientes, aplicando las distribuciones
     * @param corrida
     * @return número entero que permite indiicar hasta que punto de los números aleaotrios generados fueron utilizados 
     */
    public int crearCorrida(ArrayList<Double> corrida) {
        int acumular = 0;
        int i = 0;
        ArrayList<String> comida;
        String genero, tipo;
        Cliente cliente = new Cliente();
        int llegada;
        int servicio;

        NumerosAleatorios numeros = new NumerosAleatorios();
        
        
        // 1,2,34,5,65,343,43423,2342
       // 4 Horas = 14400 segundos 
        while (acumular < 14400) {
       
            int aux = numeros.multinomialCantidad(corrida.get(i));
            comida = new ArrayList<>();
            i++;
            genero = numeros.Genero(corrida.get(i));
            i++;
            for (int j = 0; j < aux; j++) {
                Boolean aux2 = true;
                while (aux2) {
                    int y = 0;
                    i++;
                    for (int z = 0; z < comida.size(); z++) {
                        if (comida.get(z) == null ? numeros.MultinomialProducto(corrida.get(i)) == null : comida.get(z).equals(numeros.MultinomialProducto(corrida.get(i)))) {
                            y = 1;
                        }
                    }
                    if (y == 0) {
                        aux2 = false;

                    }
                }
                comida.add(numeros.MultinomialProducto(corrida.get(i)));
            }

            i++;
            llegada = (int) (numeros.TiempoLlegada(corrida.get(i)));
            i++;
           // System.out.println(corrida.get(i));
            servicio = numeros.TiempoServicio(corrida.get(i));
            acumular = acumular + llegada;
            i++;
            tipo = numeros.MultimonialTipo(corrida.get(i));
            i++;
            genero = numeros.Genero(corrida.get(i));
            i++;
//                System.out.println(servicio+" "+llegada+" "+tipo+" "+comida+" "+genero);
            cliente = new Cliente(servicio, llegada, tipo, comida, genero);
            clientes.add(cliente);
        }
        
        return i;
    }
}
