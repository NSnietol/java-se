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
public class Relevantes {

    /**
     * numero de personas totales que compraron
     *
     * @param personas personas que llegaron en la corrida
     * @return numero de personas que llegaron en la corrida
     */
    public int numeroPersonas(ArrayList<Corrida> personas) {
        int cont = 0;
        for (Corrida persona : personas) {
            cont += persona.getClientes().size();
        }

        return cont;
    }

    /**
     * numero de hombres que compraron durante la corrida
     *
     * @param personas personas que llegaron a la tienda durante la corrida
     * @return numero de hombres que compraron
     */
    public int numeroHombres(ArrayList<Corrida> personas) {
        int hombres = 0;
        for (Corrida persona : personas) {
            for (Cliente cliente : persona.getClientes()) {
                if (cliente.getGenero().equals("Hombre")) {
                    hombres++;
                }
            }
        }

        return hombres;
    }

    /**
     * Numero de mujeres que llegaron a comprar durante la corrida
     *
     * @param personas personas que llegaron en la corrida
     * @return numero de mujeres que llegaron a comprar durante la corrida
     */
    public int numeroMujeres(ArrayList<Corrida> personas) {
        return numeroPersonas(personas) - numeroHombres(personas);
    }

    /**
     * comida mas popular entre un grupo de personas
     *
     * @param personas personas que pertenecen al grupo de interes
     * @return Comida mas popular entre ese grupo de personas
     */
    public String comidaPopular(ArrayList<Cliente> personas) {
        int comidas[] = new int[15];
        for (int i = 0; i < 15; i++) {
            comidas[i] = 0;
        }

        for (Cliente cliente : personas) {
            for (int i = 0; i < cliente.getComida().size(); i++) {
                if (cliente.getComida().get(i).equalsIgnoreCase("Agua")) {
                    comidas[0]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Barras")) {
                    comidas[1]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Bebidas energeticas")) {
                    comidas[2]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Bebidas lacteas")) {
                    comidas[3]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Chocolate")) {
                    comidas[4]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Comidas")) {
                    comidas[5]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Dulces")) {
                    comidas[6]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Fritos")) {
                    comidas[7]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Frutas")) {
                    comidas[8]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Galletas")) {
                    comidas[9]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Gaseosas")) {
                    comidas[10]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Jugos")) {
                    comidas[11]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Jugos naturales")) {
                    comidas[12]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("mecatos")) {
                    comidas[13]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("pan")) {
                    comidas[14]++;
                }
            }
        }
        int aux = 0, n = 0;
        for (int i = 0; i < 14; i++) {
            if (comidas[i] > aux) {
                aux = comidas[i];
                n = i;
            }
        }
        switch (n) {
            case 0:
                return "Agua";
            case 1:
                return "Barras";
            case 2:
                return "Bebidas energeticas";
            case 3:
                return "Bebidas lacteas";
            case 4:
                return "Chocolate";
            case 5:
                return "Comidas";
            case 6:
                return "Dulces";
            case 7:
                return "Fritos";
            case 8:
                return "Frutas";
            case 9:
                return "Galletas";
            case 10:
                return "Gaseosas";
            case 11:
                return "Jugos";
            case 12:
                return "Jugos naturales";
            case 13:
                return "mecatos";
            case 14:
                return "pan";

        }

        return "";
    }

    /**
     * Producto popular entre las mujeres
     *
     * @param personas personas que llegaron durante una corrida a la tienda
     * @return el producto mas popular entre las mujeres
     */
    public String CompradoPorMujeres(ArrayList<Corrida> personas) {
        ArrayList<Cliente> mujeres = new ArrayList<>();
        for (Corrida mujere : personas) {

            for (Cliente clientes : mujere.getClientes()) {
                if (clientes.getGenero().equals("Mujer")) {
                    mujeres.add(clientes);
                }
            }

        }
        return comidaPopular(mujeres);
    }

    /**
     * Producto mas popular entre los Hombres
     *
     * @param personas Personas que llegaron a la tienda en la corrida
     * @return compra mas popular entre los hombres
     */
    public String CompradoPorHombres(ArrayList<Corrida> personas) {
        ArrayList<Cliente> hombres = new ArrayList<>();

        for (Corrida hombre : personas) {

            for (Cliente clientes : hombre.getClientes()) {
                if (clientes.getGenero().equals("Hombre")) {
                    hombres.add(clientes);
                }
            }
        }
        return comidaPopular(hombres);
    }
    //-----------------------------------------------------

    /**
     * Devuelve el producto mas comprado entre los jovenes
     *
     * @param personas personas que llegan a la tienda en cada corrida
     * @return producto mas popular entre personas jovenes
     */
    public String CompradoPorJovenes(ArrayList<Corrida> personas) {
        ArrayList<Cliente> jovenes = new ArrayList<>();

        for (Corrida corridita : personas) {

            for (Cliente clientes : corridita.getClientes()) {
                if (clientes.getTipo().equals("joven")) {
                    jovenes.add(clientes);
                }
            }
        }
        return comidaPopular(jovenes);
    }

    /**
     * Devuelve el producto mas comprado entre los adultos
     *
     * @param personas personas que llegan a la tienda en cada corrida
     * @return producto mas popular entre personas jovenes
     */
    public String CompradoPorAdultos(ArrayList<Corrida> personas) {
        ArrayList<Cliente> Adulto = new ArrayList<>();

        for (Corrida cliente : personas) {

            for (Cliente clientes : cliente.getClientes()) {
                if (clientes.getTipo().equals("Adulto")) {
                    Adulto.add(clientes);
                }
            }
        }
        return comidaPopular(Adulto);
    }

    /**
     * Devuelve el producto mas comprado entre los adultos mayores
     *
     * @param personas personas que llegan a la tienda en cada corrida
     * @return producto mas popular entre los adultos mayores
     */
    public String CompradoPorAdultosMayores(ArrayList<Corrida> personas) {
        ArrayList<Cliente> AdultoMayor = new ArrayList<>();

        for (Corrida cliente : personas) {

            for (Cliente clientes : cliente.getClientes()) {
                if (clientes.getTipo().equals("Adulto mayor")) {
                    AdultoMayor.add(clientes);
                }
            }
        }
        return comidaPopular(AdultoMayor);
    }

    /**
     * Retorna el producto menos popular en un grupo de personas
     *
     * @param personas grupo de personas a evaluar
     * @return producto menos popular
     */
    public String menosPopular(ArrayList<Cliente> personas) {
        int comidas[] = new int[15];
        for (int i = 0; i < 15; i++) {
            comidas[i] = 0;
        }
        for (Cliente cliente : personas) {
            for (int i = 0; i < cliente.getComida().size(); i++) {
                if (cliente.getComida().get(i).equalsIgnoreCase("Agua")) {
                    comidas[0]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Barras")) {
                    comidas[1]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Bebidas energeticas")) {
                    comidas[2]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Bebidas lacteas")) {
                    comidas[3]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Chocolate")) {
                    comidas[4]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Comidas")) {
                    comidas[5]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Dulces")) {
                    comidas[6]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Fritos")) {
                    comidas[7]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Frutas")) {
                    comidas[8]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Galletas")) {
                    comidas[9]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Gaseosas")) {
                    comidas[10]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Jugos")) {
                    comidas[11]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("Jugos naturales")) {
                    comidas[12]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("mecatos")) {
                    comidas[13]++;
                }
                if (cliente.getComida().get(i).equalsIgnoreCase("pan")) {
                    comidas[14]++;
                }
            }
        }
        int aux = 1000, n = 0;
        for (int i = 0; i < 14; i++) {
            if (comidas[i] < aux) {
                aux = comidas[i];
                n = i;
            }
        }
        switch (n) {
            case 0:
                return "Agua";
            case 1:
                return "Barras";
            case 2:
                return "Bebidas energeticas";
            case 3:
                return "Bebidas lacteas";
            case 4:
                return "Chocolate";
            case 5:
                return "Comidas";
            case 6:
                return "Dulces";
            case 7:
                return "Fritos";
            case 8:
                return "Frutas";
            case 9:
                return "Galletas";
            case 10:
                return "Gaseosas";
            case 11:
                return "Jugos";
            case 12:
                return "Jugos naturales";
            case 13:
                return "mecatos";
            case 14:
                return "pan";

        }
        return "";
    }

    /**
     * muestra el producto menos popular entre todos los clientes
     *
     * @param personas lista de personas de la corrida
     * @return personas de las corridas
     */
    public String menosPopularGeneral(ArrayList<Corrida> personas) {

        ArrayList<Cliente> lista = new ArrayList<>();
        for (Corrida cliente : personas) {
            lista.addAll(cliente.getClientes());
        }

        return menosPopular(lista);
    }

    /**
     * retorna el producto menos popular entre los hombres
     *
     * @param personas hombres que fueron a la tienda
     * @return comida menos popular entre Hombres
     */
    public String menosPopularHombres(ArrayList<Corrida> personas) {
        ArrayList<Cliente> hombres = new ArrayList<>();

        for (Corrida hombre : personas) {

            for (Cliente a : hombre.getClientes()) {
                if (a.getGenero().equalsIgnoreCase("Hombre")) {
                    hombres.add(a);
                }
            }

        }
        return menosPopular(hombres);
    }

    /**
     * retorna el producto menos popular entre las mujeres
     *
     * @param personas mujeres que fueron a la tienda
     * @return comida menos popular entre mujeres
     */
    public String menosPopularMujeres(ArrayList<Corrida> personas) {
        ArrayList<Cliente> hombres = new ArrayList<>();

        for (Corrida hombre : personas) {

            for (Cliente a : hombre.getClientes()) {
                if (a.getGenero().equalsIgnoreCase("Hombre")) {
                    hombres.add(a);
                }
            }

        }
        return menosPopular(hombres);
    }

    /**
     * Productos populares entre mujeres jovenes
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre mujeres jovenes
     */
    public String CompradoPorMujeresJovenes(ArrayList<Corrida> personas) {
        ArrayList<Cliente> MujeresJovenes = new ArrayList<>();

        for (Corrida mujercita : personas) {
            for (Cliente clientes : mujercita.getClientes()) {
                if (clientes.getTipo().equals("joven") && clientes.getGenero().equalsIgnoreCase("Mujer")) {
                    MujeresJovenes.add(clientes);
                }
            }
        }

        return comidaPopular(MujeresJovenes);
    }

    /**
     * Productos populares entre mujeres Adultas
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre mujeres Adultas
     */
    public String CompradoPorMujeresAdultas(ArrayList<Corrida> personas) {
        ArrayList<Cliente> MujeresAdultas = new ArrayList<>();

        for (Corrida MujeresAdulta : personas) {
            for (Cliente clientes : MujeresAdulta.getClientes()) {
                if (clientes.getTipo().equals("Adulto") && clientes.getGenero().equalsIgnoreCase("Mujer")) {
                    MujeresAdultas.add(clientes);
                }
            }
        }

        return comidaPopular(MujeresAdultas);
    }

    public int cantidadesProductos(String genero, String Tipo, ArrayList<Corrida> personas, String Comida) {
        int i = 0;

        for (Corrida persona1 : personas) {

            for (Cliente persona : persona1.getClientes()) {
                if (persona.getGenero().equalsIgnoreCase(genero)) {
                    if (persona.getTipo().equalsIgnoreCase(Tipo)) {
                        for (String comida : persona.getComida()) {
                            if (comida.equalsIgnoreCase(Comida)) {
                                i++;
                            }
                        }
                    }
                    if (Tipo.equalsIgnoreCase("")) {
                        for (String comida : persona.getComida()) {
                            if (comida.equalsIgnoreCase(Comida)) {
                                i++;
                            }
                        }
                    }
                }
                if (genero.equalsIgnoreCase("")) {
                    if (persona.getTipo().equalsIgnoreCase(Tipo)) {
                        for (String comida : persona.getComida()) {
                            if (comida.equalsIgnoreCase(Comida)) {
                                i++;
                            }
                        }
                    }
                    if (Tipo.equalsIgnoreCase("")) {
                        for (String comida : persona.getComida()) {
                            if (comida.equalsIgnoreCase(Comida)) {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    /**
     * Productos populares entre mujeres Adultas mayores
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre mujeres Adultas mayores
     */
    public String CompradoPorMujeresAdultasMayores(ArrayList<Corrida> personas) {
        ArrayList<Cliente> MujeresAdultasMayores = new ArrayList<>();

        for (Corrida MujeresAdultasMayore : personas) {

            for (Cliente clientes : MujeresAdultasMayore.getClientes()) {
                if (clientes.getTipo().equals("Adulto mayor") && clientes.getGenero().equalsIgnoreCase("Mujer")) {
                    MujeresAdultasMayores.add(clientes);
                }
            }
        }
        return comidaPopular(MujeresAdultasMayores);
    }

    //------------------------------------------------------------------------
    /**
     * Productos populares entre los Hombres jovenes
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre mujeres jovenes
     */
    public String CompradoPorHombresJovenes(ArrayList<Corrida> personas) {
        ArrayList<Cliente> HombresJovenes = new ArrayList<>();
        for (Corrida HombresJovene : personas) {

            for (Cliente clientes : HombresJovene.getClientes()) {
                if (clientes.getTipo().equals("joven") && clientes.getGenero().equalsIgnoreCase("Hombre")) {
                    HombresJovenes.add(clientes);
                }
            }
        }
        return comidaPopular(HombresJovenes);
    }

    /**
     * Productos populares entre Hombre Adultos
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre Hombre Adultos
     */
    public String CompradoPorHombresAdultas(ArrayList<Corrida> personas) {
        ArrayList<Cliente> HombresAdultos = new ArrayList<>();

        for (Corrida HombresAdulto : personas) {

            for (Cliente clientes : HombresAdulto.getClientes()) {
                if (clientes.getTipo().equals("Adulto") && clientes.getGenero().equalsIgnoreCase("Hombre")) {
                    HombresAdultos.add(clientes);
                }
            }
        }
        return comidaPopular(HombresAdultos);
    }

    /**
     * Productos populares entre hombres Adultos mayores
     *
     * @param personas numero de personas en la corrida
     * @return retorna el producto mas comprado entre hombres Adultos mayores
     */
    public String CompradoPorHombreAdultosMayores(ArrayList<Corrida> personas) {
        ArrayList<Cliente> HombresAdultosMayores = new ArrayList<>();

        for (Corrida HombresAdultosMayore : personas) {

            for (Cliente clientes : HombresAdultosMayore.getClientes()) {
                if (clientes.getTipo().equals("Adulto mayor") && clientes.getGenero().equalsIgnoreCase("Hombre")) {
                    HombresAdultosMayores.add(clientes);
                }
            }
        }
        return comidaPopular(HombresAdultosMayores);
    }

    /**
     * probabilidad de que llegue un hombre a la tienda
     *
     * @param personas personas que llegan por corrida
     * @return retorna la probabilidad de que sea hombre
     */
    public double probabilidadH(ArrayList<Corrida> personas) {

        return this.numeroHombres(personas) / this.numeroPersonas(personas);
    }

    /**
     * probabilidad de que llegue una mujer a la tienda
     *
     * @param personas personas que llegan a comprar en un tienda
     * @return probabilidad de que llegue una mujer
     */
    public double probabilidadM(ArrayList<Corrida> personas) {
        return this.numeroMujeres(personas) / this.numeroPersonas(personas);
    }

    /**
     * Retorna el numero de personas de un genero especifico que compraron una
     * comida
     *
     * @param genero genero a consultar
     * @param comida comida a consultar
     * @param personas numero de personas que llegaron en un dia
     * @return numero de personas que compraron la comida de cierto genero
     */
    public int NumeroComidaPorGenero(String genero, String comida, ArrayList<Corrida> personas) {
        int i = 0;

        for (Corrida persona1 : personas) {

            for (Cliente persona : persona1.getClientes()) {
                if (persona.getGenero().equalsIgnoreCase(genero)) {
                    for (String comidas : persona.getComida()) {
                        if (comidas.equalsIgnoreCase(comida)) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    /**
     *
     * @param personas
     * @param comida
     * @return
     */
    public int numeroDeComidas(ArrayList<Corrida> personas, String comida) {
        int i = 0;

        for (Corrida persona1 : personas) {

            for (Cliente persona : persona1.getClientes()) {

                for (String comidas : persona.getComida()) {
                    if (comidas.equalsIgnoreCase(comida)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    /**
     *
     * @param personas
     * @param comida
     * @return
     */
    public double porcentajeTotalComida(ArrayList<Corrida> personas, String comida) {
        //System.out.println(numeroDeComidas(personas, comida)+" "+numeroPersonas(personas));
        double a, b;
        a = numeroPersonas(personas);
        b = numeroDeComidas(personas, comida);
        return b / a;
    }

    public double porcentajeComidaHombre(ArrayList<Corrida> personas, String comida) {
        double a, b, c;
        a = NumeroComidaPorGenero("Hombre", comida, personas);
        b = numeroHombres(personas);
        c = a / b;
        System.out.println("A " + a + "B " + b + " C " + c);
        return c;
    }

    public double porcentajeComidaMujer(ArrayList<Corrida> personas, String comida) {
       
        return NumeroComidaPorGenero("Mujer", comida, personas) / numeroMujeres(personas);
    }

    public double promedioLLegada(ArrayList<Corrida> personas) {
        double llegada = 0;
        for (Corrida persona1 : personas) {

            for (Cliente a : persona1.getClientes()) {
                llegada = +a.getTiempoLlegada();
            }
        }
        return llegada / numeroPersonas(personas);
    }

    public double promedioServicio(ArrayList<Corrida> personas) {
        double servicio = 0;
        for (Corrida persona1 : personas) {
            for (Cliente a : persona1.getClientes()) {
            servicio = +a.getTiempoServicio();
        }
        }
        
        return servicio / numeroPersonas(personas);
    }

    public double bayesComidaHombre(String comida, ArrayList<Corrida> personas) {
        double a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
        a = porcentajeTotalComida(personas, "Agua") * porcentajeComidaHombre(personas, "Agua");
        b = porcentajeTotalComida(personas, "Barras") * porcentajeComidaHombre(personas, "Barras");
        c = porcentajeTotalComida(personas, "Bebidas energeticas") * porcentajeComidaHombre(personas, "Bebidas energeticas");
        d = porcentajeTotalComida(personas, "Bebidas lacteas") * porcentajeComidaHombre(personas, "Bebidas lacteas");
        e = porcentajeTotalComida(personas, "Chocolate") * porcentajeComidaHombre(personas, "Chocolate");
        f = porcentajeTotalComida(personas, "Comidas") * porcentajeComidaHombre(personas, "Comidas");
        g = porcentajeTotalComida(personas, "Dulces") * porcentajeComidaHombre(personas, "Dulces");
        h = porcentajeTotalComida(personas, "Fritos") * porcentajeComidaHombre(personas, "Fritos");
        i = porcentajeTotalComida(personas, "Frutas") * porcentajeComidaHombre(personas, "Frutas");
        j = porcentajeTotalComida(personas, "Galletas") * porcentajeComidaHombre(personas, "Galletas");
        k = porcentajeTotalComida(personas, "Gaseosas") * porcentajeComidaHombre(personas, "Gaseosas");
        l = porcentajeTotalComida(personas, "Jugos") * porcentajeComidaHombre(personas, "Jugos");
        m = porcentajeTotalComida(personas, "Jugos naturales") * porcentajeComidaHombre(personas, "Jugos naturales");
        n = porcentajeTotalComida(personas, "mecatos") * porcentajeComidaHombre(personas, "mecatos");
        o = porcentajeTotalComida(personas, "pan") * porcentajeComidaHombre(personas, "pan");
        p = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o;

        double javafeliz = porcentajeComidaHombre(personas, comida) * porcentajeTotalComida(personas, comida);

        return ((javafeliz / p) * 100);
    }

    public double bayesComidaMujer(String comida, ArrayList<Corrida> personas) {
        double a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
        a = porcentajeTotalComida(personas, "Agua") * porcentajeComidaMujer(personas, "Agua");
        b = porcentajeTotalComida(personas, "Barras") * porcentajeComidaMujer(personas, "Barras");
        c = porcentajeTotalComida(personas, "Bebidas energeticas") * porcentajeComidaMujer(personas, "Bebidas energeticas");
        d = porcentajeTotalComida(personas, "Bebidas lacteas") * porcentajeComidaMujer(personas, "Bebidas lacteas");
        e = porcentajeTotalComida(personas, "Chocolate") * porcentajeComidaMujer(personas, "Chocolate");
        f = porcentajeTotalComida(personas, "Comidas") * porcentajeComidaMujer(personas, "Comidas");
        g = porcentajeTotalComida(personas, "Dulces") * porcentajeComidaMujer(personas, "Dulces");
        h = porcentajeTotalComida(personas, "Fritos") * porcentajeComidaMujer(personas, "Fritos");
        i = porcentajeTotalComida(personas, "Frutas") * porcentajeComidaMujer(personas, "Frutas");
        j = porcentajeTotalComida(personas, "Galletas") * porcentajeComidaMujer(personas, "Galletas");
        k = porcentajeTotalComida(personas, "Gaseosas") * porcentajeComidaMujer(personas, "Gaseosas");
        l = porcentajeTotalComida(personas, "Jugos") * porcentajeComidaMujer(personas, "Jugos");
        m = porcentajeTotalComida(personas, "Jugos naturales") * porcentajeComidaMujer(personas, "Jugos naturales");
        n = porcentajeTotalComida(personas, "mecatos") * porcentajeComidaMujer(personas, "mecatos");
        o = porcentajeTotalComida(personas, "pan") * porcentajeComidaMujer(personas, "pan");
        p = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o;

        double javafeliz = porcentajeComidaMujer(personas, comida) * porcentajeTotalComida(personas, comida);

        if (javafeliz == 0) {
            return 0;
        }
        return ((javafeliz / p) * 100);
    }

    public double porcentajeComidaHombreTipo(String tipo, ArrayList<Corrida> personas, String comida) {
        double a, b, c;

        a = NumeroComidaPorGeneroTipo("Hombre", tipo, comida, personas);
        b = numeroHombresTipo(personas, tipo);
        c = a / b;
        //System.out.println("A " + a + "B " + b + " C " + c);
        return c;
    }

    public double bayescomidaHombreTipo(String tipo, String Comida, ArrayList<Corrida> personas) {
        double a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
        //tipo = "joven";
        a = porcentajeTotalComida(personas, "Agua") * porcentajeComidaHombreTipo(tipo, personas, "Agua");
        b = porcentajeTotalComida(personas, "Barras") * porcentajeComidaHombreTipo(tipo, personas, "Barras");
        c = porcentajeTotalComida(personas, "Bebidas energeticas") * porcentajeComidaHombreTipo(tipo, personas, "Bebidas energeticas");
        d = porcentajeTotalComida(personas, "Bebidas lacteas") * porcentajeComidaHombreTipo(tipo, personas, "Bebidas lacteas");
        e = porcentajeTotalComida(personas, "Chocolate") * porcentajeComidaHombreTipo(tipo, personas, "Chocolate");
        f = porcentajeTotalComida(personas, "Comidas") * porcentajeComidaHombreTipo(tipo, personas, "Comidas");
        g = porcentajeTotalComida(personas, "Dulces") * porcentajeComidaHombreTipo(tipo, personas, "Dulces");
        h = porcentajeTotalComida(personas, "Fritos") * porcentajeComidaHombreTipo(tipo, personas, "Fritos");
        i = porcentajeTotalComida(personas, "Frutas") * porcentajeComidaHombreTipo(tipo, personas, "Frutas");
        j = porcentajeTotalComida(personas, "Galletas") * porcentajeComidaHombreTipo(tipo, personas, "Galletas");
        k = porcentajeTotalComida(personas, "Gaseosas") * porcentajeComidaHombreTipo(tipo, personas, "Gaseosas");
        l = porcentajeTotalComida(personas, "Jugos") * porcentajeComidaHombreTipo(tipo, personas, "Jugos");
        m = porcentajeTotalComida(personas, "Jugos naturales") * porcentajeComidaHombreTipo(tipo, personas, "Jugos naturales");
        n = porcentajeTotalComida(personas, "mecatos") * porcentajeComidaHombreTipo(tipo, personas, "mecatos");
        o = porcentajeTotalComida(personas, "pan") * porcentajeComidaHombreTipo(tipo, personas, "pan");
        p = (a + b + c + d + e + f + g + h + i + j + k + l + m + n + o);
        //System.out.println("hj : " + porcentajeComidaHombreTipo(tipo, personas, Comida));
        //System.out.println("total comi" + porcentajeTotalComida(personas, Comida));
        double javafeliz = porcentajeComidaHombreTipo(tipo, personas, Comida) * porcentajeTotalComida(personas, Comida);

        
        if (javafeliz == 0) {
            return 0;
        }
        
        return ((javafeliz / p) * 100);
    }

    public int NumeroComidaPorGeneroTipo(String genero, String tipo, String comida, ArrayList<Corrida> personas) {
        int i = 0;

        for (Corrida persona1 : personas) {

            for (Cliente persona : persona1.getClientes()) {
                if (persona.getGenero().equalsIgnoreCase(genero) && persona.getTipo().equals(tipo)) {
                    for (String comidas : persona.getComida()) {
                        if (comidas.equalsIgnoreCase(comida)) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public int numeroHombresTipo(ArrayList<Corrida> personas, String tipo) {
        int hombres = 0;
        for (Corrida persona1 : personas) {

            for (Cliente cliente : persona1.getClientes()) {
                if (cliente.getGenero().equals("Hombre") && cliente.getTipo().equals(tipo)) {
                    hombres++;
                }
            }
        }
        return hombres;
    }

    public double bayescomidaMujerTipo(String tipo, String Comida, ArrayList<Corrida> personas) {
        double a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
        //tipo = "joven";
        a = porcentajeTotalComida(personas, "Agua") * porcentajeComidaMujerTipo(tipo, personas, "Agua");
        b = porcentajeTotalComida(personas, "Barras") * porcentajeComidaMujerTipo(tipo, personas, "Barras");
        c = porcentajeTotalComida(personas, "Bebidas energeticas") * porcentajeComidaMujerTipo(tipo, personas, "Bebidas energeticas");
        d = porcentajeTotalComida(personas, "Bebidas lacteas") * porcentajeComidaMujerTipo(tipo, personas, "Bebidas lacteas");
        e = porcentajeTotalComida(personas, "Chocolate") * porcentajeComidaMujerTipo(tipo, personas, "Chocolate");
        f = porcentajeTotalComida(personas, "Comidas") * porcentajeComidaMujerTipo(tipo, personas, "Comidas");
        g = porcentajeTotalComida(personas, "Dulces") * porcentajeComidaMujerTipo(tipo, personas, "Dulces");
        h = porcentajeTotalComida(personas, "Fritos") * porcentajeComidaMujerTipo(tipo, personas, "Fritos");
        i = porcentajeTotalComida(personas, "Frutas") * porcentajeComidaMujerTipo(tipo, personas, "Frutas");
        j = porcentajeTotalComida(personas, "Galletas") * porcentajeComidaMujerTipo(tipo, personas, "Galletas");
        k = porcentajeTotalComida(personas, "Gaseosas") * porcentajeComidaMujerTipo(tipo, personas, "Gaseosas");
        l = porcentajeTotalComida(personas, "Jugos") * porcentajeComidaMujerTipo(tipo, personas, "Jugos");
        m = porcentajeTotalComida(personas, "Jugos naturales") * porcentajeComidaMujerTipo(tipo, personas, "Jugos naturales");
        n = porcentajeTotalComida(personas, "mecatos") * porcentajeComidaMujerTipo(tipo, personas, "mecatos");
        o = porcentajeTotalComida(personas, "pan") * porcentajeComidaMujerTipo(tipo, personas, "pan");
        p = (a + b + c + d + e + f + g + h + i + j + k + l + m + n + o);
        //System.out.println("hj : " + porcentajeComidaMujerTipo(tipo, personas, Comida));
        // System.out.println("total comi" + porcentajeTotalComida(personas, Comida));
        double javafeliz = porcentajeComidaMujerTipo(tipo, personas, Comida) * porcentajeTotalComida(personas, Comida);

        
        if (javafeliz == 0) {
            return 0;
        }
        return ((javafeliz / p) * 100);
    }

    public double porcentajeComidaMujerTipo(String tipo, ArrayList<Corrida> personas, String comida) {
        double a, b, c;

        a = NumeroComidaPorGeneroTipo("Mujer", tipo, comida, personas);
        b = numeroMujerTipo(personas, tipo);
        c = a / b;
        System.out.println("A " + a + "B " + b + " C " + c);
        return c;
    }

    public int numeroMujerTipo(ArrayList<Corrida> personas, String tipo) {
        int mujer = 0;
        for (Corrida persona1 : personas) {

            for (Cliente cliente : persona1.getClientes()) {
                if (cliente.getGenero().equals("Mujer") && cliente.getTipo().equals(tipo)) {
                    mujer++;
                }
            }
        }
        return mujer;
    }

}
