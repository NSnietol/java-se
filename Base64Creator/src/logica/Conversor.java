/*
 * Aplicando Base64 16/12/2016 NS 
 */
package logica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NS
 */
public class Conversor {

    private BufferedInputStream bufferEnvio;
    private byte[] contenido;
    private File direccionRecibido;
    private boolean hiloIniciado = false;
    Thread abrirCarpeta;

    public Conversor(String direccionRecibido) {
        try {
            if (!direccionRecibido.isEmpty()) {
                this.direccionRecibido = new File(direccionRecibido);

            } else if (System.getProperty("os.name").contains("windows")) {

                String dir = System.getProperty("user.home") + "\\Desktop";
                this.direccionRecibido = new File(dir);

            } else {
                String dir = System.getProperty("user.home");
                this.direccionRecibido = new File(dir);

            }
        } catch (Exception ee) {
            System.err.println("No sé puede establecer la ruta\n se estableció el escritorio por defecto");

            if (System.getProperty("os.name").contains("windows")) {

                String dir = System.getProperty("user.home") + "\\Desktop";
                this.direccionRecibido = new File(dir);

            } else {
                String dir = System.getProperty("user.home");
                this.direccionRecibido = new File(dir);

            }
        }
    }

    /**
     * @param cadena es la cadena en Base64 que se va a convertir en un archivo
     * @return true si logra realizar la operación y guardar el archivo
     */
    public boolean decodificarBase64(String cadena, String nombre) throws IOException {

        contenido = Base64.getDecoder().decode(cadena);

        System.out.println("Procesando... ");
        String filePath = direccionRecibido.getPath() + "\\" + nombre;
        System.out.println("Path procesado" + filePath);

        if (new File(direccionRecibido.getPath()).canWrite()) {

            try {
                if (contenido != null) {
                    FileOutputStream nuevo = new FileOutputStream(filePath);
                    BufferedOutputStream outputStream = new BufferedOutputStream(nuevo);
                    outputStream.write(contenido);
                    outputStream.close();

                    System.out.println("Archivo creado.");
                    abrirCarpeta=carpeta();
                    abrirCarpeta.start();

                    return true;
                }
            } catch (IOException ex) {
                System.out.println("Error al decodificar el archivo,por favor verifique su contenido");
                return false;

            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException(ex.getMessage());
            }
        } else {
            throw new IOException("No se puede escribir en la dirección establecida : \n" + direccionRecibido.getAbsolutePath());

        }

        return false;
    }

    public Thread carpeta() {

        return new Thread() {
            @Override
            public void run() {

                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccionRecibido.getPath());

                    // INFORMACIÓN DE EJECUTAR COMANDOS DESDE JAVA
                } catch (IOException ex) {
                    Logger.getLogger(Conversor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
    }

    /**
     * @param archivoProcesado es el archivo a convertir en texto(Base64)
     * @return Cadana convertirda a Base64
     */
    public String codificarBase64(File archivoProcesado) {

        try {
            System.out.println("Archivo a procesar : " + archivoProcesado.getAbsolutePath());
            bufferEnvio = new BufferedInputStream(new FileInputStream(archivoProcesado));
        } catch (FileNotFoundException ex) {
            System.err.println("Error codificando el archivo");
            return "Error al codificar";
        }
        long length = archivoProcesado.length();

        byte[] buffer = new byte[(int) archivoProcesado.length()];

        try {
            int readBytes = bufferEnvio.read(buffer);
            bufferEnvio.close();
        } catch (IOException ex) {
            return "Error al converir en los binarios";
        }
        System.out.println("Convirtiendo...");
        /*Codificamos a base 64*/
        String base64 = Base64.getEncoder().encodeToString(buffer);
        System.out.println("OK");
        return base64;
    }

    public BufferedInputStream getBufferEnvio() {
        return bufferEnvio;
    }

    public void setBufferEnvio(BufferedInputStream bufferEnvio) {
        this.bufferEnvio = bufferEnvio;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public File getDireccionRecibido() {
        return direccionRecibido;
    }

    public void setDireccionRecibido(File direccionRecibido) {
        this.direccionRecibido = direccionRecibido;
    }

}
