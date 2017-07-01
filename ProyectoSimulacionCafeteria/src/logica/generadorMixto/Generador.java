/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.generadorMixto;

import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class Generador {

    private static ArrayList<Double> enteros;
    private static ArrayList<Double> decimales;

    
    /** Recive los parametros comunes para la generación de números mediante el método de congruencial mixto
     * 
     * @param a     
     * @param x     
     * @param c     
     * @param m     
     * @return      
     */
    static public Respuesta congruencialMixto(double a, double x, double c, double m) {
        enteros = new ArrayList<>();
        decimales = new ArrayList<>();

        Respuesta res = new Respuesta();

        double semilla = x;
        for (int i = 0; i < m; i++) {
            x = (a * x + c) % m;
            if (semilla == x) {
                res.showMensaje("- Tamaño de Serie: " + res.size());
                return res;
            }
            res.add(new Double[]{x, (x / m)});
            //***************
            enteros.add(x);
            decimales.add(x / m);
            //System.out.println(x/m);
        }

        res.showMensaje("- Tamaño de Serie: " + res.size());
        return res;
    }
}
