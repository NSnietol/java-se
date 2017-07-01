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
public class NumerosAleatorios {

    private int numerosExponencial(double media, double aleatorio) {
        return (int) ((-media) * Math.log(aleatorio));
    }

    private ArrayList<Double> listas(double media) {
//        double media=(1/lamda);
        double acum = 0.0;
        ArrayList<Double> rangos = new ArrayList<Double>();
        int n = (int) (media * 2);
        double numerador, poisson;
        for (int i = 0; i < n; i++) {

            int factorial = 0;
            for (int j = 1; j <= n; j++) {
                factorial = factorial * j;
            }
            if (factorial == 0) {
                factorial = 1;
            }

            numerador = Math.pow(Math.E, -media) * Math.pow(media, i);
            poisson = numerador / factorial;

            acum = acum + poisson;
//            System.out.println(acum);
            rangos.add(acum);
        }
        return rangos;
    }

    /**
     * Esta funcion returna la variable aleatoria a la que corresponda el numero
     *
     * @param rango es una arrayList que hace referencia a los rangos obtenidos
     * el metodo listas
     * @param aleatorio numero aleatorio generado aleatoriamente
     * @return
     */
    private int NumeroPoisson(ArrayList<Double> rango, double aleatorio) {
        for (int i = 0; i < rango.size(); i++) {
            if (rango.get(0) > aleatorio) {
                return 0;
            }
            if (i != 0) {
                if (rango.get(i - 1) < aleatorio && rango.get(i) > aleatorio) {
                    return i;
                }
            }
        }
        return rango.size() + 1;
    }

    /**
     * Esta funcion devuelve una variable
     *
     * @param aleatorio valor aleatorio generado por la simulacion
     * @return retorna true si el numero causa exito si es fracaso retorna false
     *
     * Hombre 0,491736339 Mujer 0,508263661
     *
     */
    public String Genero(double aleatorio) {
        if (0.49173634 < aleatorio) {
            return "Mujer";
        }
        return "Hombre";
    }

    public String MultimonialTipo(double aleatorio) {
        if (aleatorio >= 0 && aleatorio < 0.879889382774196) {
            return "joven";
        }
        if (aleatorio >= 0.879889382774196 && aleatorio < 0.966872106964146) {
            return "Adulto";
        }
        return "Adulto mayor";
    }

    public String MultinomialProducto(double aleatorio) {

        if (aleatorio >= 0 && aleatorio < 0.0818915801614764) {
            return "Agua";
        }

        if (aleatorio >= 0.0818915801614764 && aleatorio < 0.092272203) {
            return "Barras";
        }

        //Bebidas energeticas	0,092272203	0,106113033
        if (aleatorio >= 0.092272203 && aleatorio < 0.106113033) {
            return "Bebidas energeticas";
        }

        //Bebidas lacteas	0,106113033	0,174163783
        if (aleatorio >= 0.106113033 && aleatorio < 0.174163783) {
            return "Bebidas lacteas";
        }

        //Chocolate	0,174163783	0,182237601
        if (aleatorio >= 0.174163783 && aleatorio < 0.182237601) {
            return "Chocolate";
        }

        //Comidas	0,182237601	0,23183391
        if (aleatorio >= 0.182237601 && aleatorio < 0.23183391) {
            return "Comidas";
        }

        //Dulces	0,23183391	0,24567474
        if (aleatorio >= 0.23183391 && aleatorio < 0.24567474) {
            return "Dulces";
        }
        //Fritos	0,24567474	0,435986159
        if (aleatorio >= 0.24567474 && aleatorio < 0.435986159) {
            return "Fritos";
        }

        //Frutas	0,435986159	0,440599769
        if (aleatorio >= 0.435986159 && aleatorio < 0.440599769) {
            return "Frutas";
        }

        //Galletas	0,440599769	0,484429066
        if (aleatorio >= 0.440599769 && aleatorio < 0.484429066) {
            return "Galletas";
        }
        //Gaseosas	0,484429066	0,722029988
        if (aleatorio >= 0.484429066 && aleatorio < 0.722029988) {
            return "Gaseosas";
        }
        //Jugos	0,722029988	0,821222607
        if (aleatorio >= 0.722029988 && aleatorio < 0.821222607) {
            return "Jugos";
        }
        //Jugos naturales	0,821222607	0,85467128
        if (aleatorio >= 0.821222607 && aleatorio < 0.85467128) {
            return "Jugos naturales";
        }
        //mecatos	0,85467128	0,880046136

        if (aleatorio >= 0.85467128 && aleatorio < 0.880046136) {
            return "mecatos";
        }
        //Pan	0,880046136	1

        return "pan";

    }

    public double TiempoLlegada(Double aleatorio) {
//        System.out.println(aleatorio); 67,12104348
        if (aleatorio == 0) {
            aleatorio = 0.5;
        }
        return this.numerosExponencial(67.121, aleatorio);
    }

    public int TiempoServicio(Double aleatorio) {
        if (aleatorio == 0) {
            aleatorio = 0.5;
        }
        return this.numerosExponencial(101.8558533, aleatorio);
    }

    public int multinomialCantidad(double aleatorio) {
        //1	0	0,532189547
        if (aleatorio >= 0 && aleatorio < 0.532189547) {
            return 1;
        }
        //2	0,532189547	0,960131826
        if (aleatorio >= 0.532189547 && aleatorio < 0.960131826) {
            return 2;
        }
        //3	0,960131826	0,993627499
        if (aleatorio >= 0.960131826 && aleatorio < 0.993627499) {
            return 3;
        }
        return 4;
    }
}
