/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarma;

import com.panamahitek.ArduinoException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Rurik
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    Controlador controlador = new Controlador(4);
    static int ultrasonico,temperatura,luminosidad,proximidad;
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLuminosidad = new javax.swing.JLabel();
        txtProximidad = new javax.swing.JLabel();
        txtUltrasonico = new javax.swing.JLabel();
        txtTemperatura = new javax.swing.JLabel();
        btnPlotTemp = new javax.swing.JButton();
        btnPlotLum = new javax.swing.JButton();
        btnPlotProx = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnDistMax = new javax.swing.JButton();
        btnPrender = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnPlotDist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPuertoDisponibles = new javax.swing.JTextArea();
        btnGetPuertos = new javax.swing.JButton();
        tfPuerto = new javax.swing.JTextField();
        btnSetPuerto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLuminosidad.setText("Estado Sensor luminosidad:");
        getContentPane().add(txtLuminosidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 340, -1));

        txtProximidad.setText("Estado Sensor proximidad:");
        getContentPane().add(txtProximidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 350, -1));

        txtUltrasonico.setText("Estado Sensor Ultrasonico:");
        getContentPane().add(txtUltrasonico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, -1));

        txtTemperatura.setText("Estado Sensor Temperatura:");
        getContentPane().add(txtTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 340, 20));

        btnPlotTemp.setText("Grafica Temperatura");
        getContentPane().add(btnPlotTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 410, -1));

        btnPlotLum.setText("Grafica Luminosidad");
        getContentPane().add(btnPlotLum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 410, -1));

        btnPlotProx.setText("Grafica Proximidad");
        getContentPane().add(btnPlotProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 370, -1));

        btnReporte.setText("Generar Reporte");
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 370, -1));

        btnDistMax.setText("Establecer distancia maxima");
        getContentPane().add(btnDistMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 410, -1));

        btnPrender.setText("Prender");
        btnPrender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrenderMouseClicked(evt);
            }
        });
        getContentPane().add(btnPrender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        btnApagar.setText("Apagar");
        btnApagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApagarMouseClicked(evt);
            }
        });
        getContentPane().add(btnApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 91, -1));

        btnDetener.setText("detener");
        getContentPane().add(btnDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 95, -1));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        btnPlotDist.setText("Grafica Ultrasonico");
        getContentPane().add(btnPlotDist, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 370, -1));

        txtPuertoDisponibles.setColumns(20);
        txtPuertoDisponibles.setRows(5);
        jScrollPane1.setViewportView(txtPuertoDisponibles);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, 128));

        btnGetPuertos.setText("ver Puertos");
        btnGetPuertos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGetPuertosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGetPuertosMouseEntered(evt);
            }
        });
        getContentPane().add(btnGetPuertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 128));
        getContentPane().add(tfPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 223, -1));

        btnSetPuerto.setText("usar Puerto");
        btnSetPuerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSetPuertoMouseClicked(evt);
            }
        });
        btnSetPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetPuertoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSetPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 300, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrenderMouseClicked
        if(!Controlador.strpuerto.equals("")){
            Controlador.sl = new SerialPortEventListener() {
            @Override
            public synchronized void serialEvent(SerialPortEvent spe) {
                try {
                    if (controlador.arduino.isMessageAvailable()==true){
                        String inputLine = controlador.arduino.printMessage();
                        String [] parts = inputLine.split("=");
                        if(parts[0].equalsIgnoreCase("distancia")){
                            txtUltrasonico.setText("Estado Sensor Ultrasonico: " + parts[1]+"[cm]");
                            Ventana.ultrasonico=Integer.parseInt(parts[1]);
                        }
                        if(parts[0].equalsIgnoreCase("temperatura")){
                            txtTemperatura.setText("Estado sensor Temperatura: " + parts[1]+"[°C]");
                            Ventana.temperatura=Integer.parseInt(parts[1]);
                        }
                        if(parts[0].equalsIgnoreCase("luz")){
                            txtLuminosidad.setText("Estado Sensor Luminosidad: " + parts[1]+"[L]");
                            Ventana.luminosidad=Integer.parseInt(parts[1]);
                        }
                        if(parts[0].equalsIgnoreCase("proximidad")){
                            txtProximidad.setText("Estado sensor proximidad: " + parts[1]+"[U]");
                            Ventana.proximidad=Integer.parseInt(parts[1]);
                        }
                        System.out.println(Arrays.toString(parts));
                    }
                } catch (SerialPortException | ArduinoException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                
            }
        };
            controlador.iniciarConexion(Controlador.strpuerto);
        }else{
            JOptionPane.showMessageDialog(null, "No ha indicado un puerto");
        }
    }//GEN-LAST:event_btnPrenderMouseClicked

    private void btnApagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApagarMouseClicked
        controlador.terminarConexion();
    }//GEN-LAST:event_btnApagarMouseClicked

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        controlador.terminarConexion();
        controlador.iniciarConexion(controlador.getPuerto());
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnGetPuertosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGetPuertosMouseClicked
        txtPuertoDisponibles.setText(controlador.verPuertos());
        String[] port=txtPuertoDisponibles.getText().split("\n");
        tfPuerto.setText(port[0]);
    }//GEN-LAST:event_btnGetPuertosMouseClicked

    private void btnSetPuertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetPuertoMouseClicked
        controlador.setPuerto(tfPuerto.getText());
        if(!controlador.getPuerto().equals("")){
            JOptionPane.showMessageDialog(null, "puerto asignado: "+controlador.getPuerto());
        }
        else
            JOptionPane.showMessageDialog(null, "no asigno ningun puerto");
    }//GEN-LAST:event_btnSetPuertoMouseClicked

    private void btnSetPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetPuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSetPuertoActionPerformed

    private void btnGetPuertosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGetPuertosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGetPuertosMouseEntered

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnDistMax;
    private javax.swing.JButton btnGetPuertos;
    private javax.swing.JButton btnPlotDist;
    private javax.swing.JButton btnPlotLum;
    private javax.swing.JButton btnPlotProx;
    private javax.swing.JButton btnPlotTemp;
    private javax.swing.JButton btnPrender;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSetPuerto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfPuerto;
    private javax.swing.JLabel txtLuminosidad;
    private javax.swing.JLabel txtProximidad;
    private javax.swing.JTextArea txtPuertoDisponibles;
    private javax.swing.JLabel txtTemperatura;
    private javax.swing.JLabel txtUltrasonico;
    // End of variables declaration//GEN-END:variables
}
