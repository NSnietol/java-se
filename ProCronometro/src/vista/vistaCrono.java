/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

import logica.controlTiempo;

/**
 *
 * @author Nilson
 */
public final class vistaCrono extends javax.swing.JFrame {

    /**
     * Creates new form vistaCrono
     */
    controlTiempo manejador;
    boolean estado = false;

    public vistaCrono() {

        initComponents();
        setLocationRelativeTo(null);
        mostrarHora();
        manejador = new controlTiempo();

        manejador.manejarHora(JLHora);
        manejador.manejarCronometro(JLtiempo);
        manejador.getHiloHora().start();
        BTdetener.setEnabled(false);
        BTpausar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLtiempo = new javax.swing.JLabel();
        BTiniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BTdetener = new javax.swing.JButton();
        BTpausar = new javax.swing.JButton();
        JLHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cronox"));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));

        JLtiempo.setFont(new java.awt.Font("Caladea", 0, 48)); // NOI18N
        JLtiempo.setForeground(new java.awt.Color(102, 102, 255));
        JLtiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLtiempo.setText("0:0:0");
        JLtiempo.setToolTipText("Hora-Min-Segundos");

        BTiniciar.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        BTiniciar.setForeground(new java.awt.Color(51, 51, 255));
        BTiniciar.setText("Iniciar");
        BTiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTiniciarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 204));
        jLabel2.setText("Cronometro");

        BTdetener.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        BTdetener.setForeground(new java.awt.Color(204, 0, 0));
        BTdetener.setText("Detener");
        BTdetener.setToolTipText("Detener el tiempo");
        BTdetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTdetenerActionPerformed(evt);
            }
        });

        BTpausar.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        BTpausar.setForeground(new java.awt.Color(102, 102, 255));
        BTpausar.setText("Pausar");
        BTpausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTpausarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BTiniciar)
                                .addGap(45, 45, 45)
                                .addComponent(BTpausar)
                                .addGap(41, 41, 41)
                                .addComponent(BTdetener)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(JLtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTiniciar)
                    .addComponent(BTpausar)
                    .addComponent(BTdetener))
                .addContainerGap())
        );

        JLHora.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        JLHora.setForeground(new java.awt.Color(153, 153, 255));
        JLHora.setText("Hora :");

        jMenu1.setText("Información");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icon_Ayuda16x16.png"))); // NOI18N
        jMenuItem1.setText("Acerca de Cronox");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(JLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BTiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTiniciarActionPerformed

        BTpausar.setEnabled(true);
        BTdetener.setEnabled(true);
        if (estado == false) {
            manejador.getHiloCronometro().start();
            estado = true;
        } else {
            manejador.getHiloCronometro().resume(); // Se supende la implementación del HiloCronometro
        }

    }//GEN-LAST:event_BTiniciarActionPerformed

    private void BTdetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTdetenerActionPerformed
        // TODO add your handling code here:

        /*Se Reinician los valores del cronometro
         */
        manejador.getHiloCronometro().suspend(); // se suspende el hilo
        BTpausar.setEnabled(false);
        BTiniciar.setText("Iniciar");
        manejador.reiniciar();

        estado = true;

    }//GEN-LAST:event_BTdetenerActionPerformed

    private void BTpausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTpausarActionPerformed
        // TODO add your handling code here:
        manejador.getHiloCronometro().suspend();
        BTpausar.setEnabled(false);
        BTiniciar.setText("Reiniciar");


    }//GEN-LAST:event_BTpausarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "\tCronox es un cronometro para PC \nDiseñado por Nilson Nieto ©");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void mostrarHora() {
        GregorianCalendar HoraPC = new GregorianCalendar();

        int hora = HoraPC.get(Calendar.HOUR_OF_DAY);
        int min = HoraPC.get(Calendar.MINUTE);
        int seg = HoraPC.get(Calendar.SECOND);

        JLHora.setText(hora + " : " + min + " : " + seg);
        JLtiempo.setText("0 : 0 : 0 . 0");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaCrono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaCrono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaCrono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaCrono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
        org.jvnet.substance.SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin"); // Setencia que aplica el skin Creme de Substance
        org.jvnet.substance.SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceSteelBlueTheme"); // Tema 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaCrono().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTdetener;
    private javax.swing.JButton BTiniciar;
    private javax.swing.JButton BTpausar;
    private javax.swing.JLabel JLHora;
    private javax.swing.JLabel JLtiempo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
