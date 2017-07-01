/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import logica.Constantes;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author NS
 */
public class Persistencia implements Constantes {

    public Persistencia() {
    }

    public static JSONObject cargarJSONconf() throws ParseException, FileNotFoundException, IOException {

        JSONParser casteador = new JSONParser();
        JSONObject configuracion;
        Object parse = null;
        try {

            parse = casteador.parse(new FileReader("config.json"));
        } catch (ParseException ex) {
            throw new ParseException(ex.getErrorType());
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }

        configuracion = (JSONObject) parse;
      

        return configuracion;
    }

    /**
     * @param object el contenido del nuevo archivo
     * @param tipo es un valor booleando que si es true significa que es el
     * archivo de configuración sino entonces es un archivo procesado y se debe
     * buscar en su contenido cual será su nombre
     * @return
     */
    public static boolean guardarJSON(JSONObject object, short tipo, String URL) throws IOException {

        switch (tipo) {
            case archivoConfig: {
                FileWriter file = new FileWriter("config.json");
                file.write(object.toJSONString());
                file.flush();
                file.close();
                System.out.println("");
                return true;

            }
            case ArchivoContenido: {

                FileWriter file = new FileWriter(URL + ".json");
                file.write(object.toJSONString());
                file.flush();
                file.close();
                return true;

            }
            default: {
                String cadena = "qwertyuiopasdfghjklñzxcvbnm987654321";
                String aux = "";
                for (int i = 0; i < 5; i++) {
                    char charAt = cadena.charAt(new Random().nextInt(cadena.length()));
                    aux += String.valueOf(charAt);
                }

                FileWriter file = new FileWriter(aux + ".json");
                file.write(object.toJSONString());
                file.flush();
                file.close();
                return true;

            }
        }

    }

}
