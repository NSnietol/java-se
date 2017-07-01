/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probloqmay;

import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author NS
 */
public class BloqMayMin implements NativeKeyListener{

    public BloqMayMin() {

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(BloqMayMin.class.getName()).log(Level.SEVERE, null, ex);
        }

        GlobalScreen.getInstance().addNativeKeyListener(this);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {


        
        if (nke.getRawCode() == 20) {


            
             DesktopNotify.showDesktopMessage("Bloq mayús", "Tenga en cuenta que acaba de presionar la tecla bloq mayús", DesktopNotify.TIP, 14000L);
    

        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    //
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        
        
     
     
    }

    public static void main(String[] args) {
        
        try {
            ServerSocket puerto = new ServerSocket(7700);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"La aplicación ya se encuentra en ejecución");
            System.exit(0);
        }
      
      
        BloqMayMin a= new BloqMayMin();
        
    }
    
}
