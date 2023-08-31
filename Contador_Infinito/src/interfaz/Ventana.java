package interfaz;


import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 *Las interrupciones son por tiempo, por teclado y por capacidad de numeros enteros. 
 *Cuando sucede cualquier caso de interrupcion el programa se detendra.
 *Las interrupciones se mostraran en un area de texto, donde se visualizaran las banderas accionadas.
 * 
 */
/**
 *
 * @author Julio Cesar Morales
 */
public class Ventana extends javax.swing.JFrame {

    private int contador = 0;
    private double tiempo = 0;
    boolean bandera1_Accion_Tecla = false;
    boolean bandera2_Interrupcion_Tiempo = false;
    boolean bandera2_Soporte_Enteros = false;

    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Regresar.setEnabled(false);
    }

    class Contador implements Runnable{

        @Override
        public void run() {
            
            long inicio = System.currentTimeMillis();
            
            while (bandera1_Accion_Tecla==false && bandera2_Interrupcion_Tiempo==false && bandera2_Soporte_Enteros==false) {                
                contador++;
                areaTexto1.append(String.valueOf(contador)+"\n");
                
                long fin = System.currentTimeMillis();
                // tiempo transcurrido 
                tiempo = (double) ((fin - inicio)/1000);
                
                //Si el contador llega a cincuenta datos el proceso es interrumpido 
                if(contador >= 50){
                    bandera2_Soporte_Enteros = true;
                    
                }
                //Si el tiempo es igual a 30 segundos transcurridos el proceso es interrumpido
                else if(tiempo >= 30){//Segundos
                    bandera2_Interrupcion_Tiempo = true;
                }
                //Es para que el contador se ejecute mas lento
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            //Se muestra en el area de texto las banderas que se activaron por la interrupcion  
            areaTexto2.append("Proceso interrumpido..\nActivacion de bandera 1 \nAccion por teclado: "+bandera1_Accion_Tecla+"\n\n");
            areaTexto2.append("Proceso interrumpido...\nActivacion de bandera 2 \nAccion por tiempo: "+bandera2_Interrupcion_Tiempo+"\n\n");
            areaTexto2.append("Proceso interrumpido...\nActivacion de bandera 3 \nAccion por fuera de rango: "+bandera2_Soporte_Enteros+"\n\n");
            
            // Se evalua que interrupcion se activo y manda el mensaje del porque se interrumpio el proceso
            if(bandera1_Accion_Tecla==true){
                JOptionPane.showMessageDialog(null,"El proceso se interrumpio por teclado");
                Regresar.setEnabled(true);
            }else if(bandera2_Interrupcion_Tiempo == true){
                JOptionPane.showMessageDialog(null,"Por seguridad el preceso se interrumpio debido al tiempo de espera");
                Regresar.setEnabled(true);
            }else if(bandera2_Soporte_Enteros == true){
                JOptionPane.showMessageDialog(null,"Se interrumpio el proceso debido a que el contador llego al limite de datos soportados");
                Iniciar.setEnabled(true);
            }   

        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        areaDeTexto1 = new javax.swing.JScrollPane();
        areaTexto1 = new javax.swing.JTextArea();
        areaDeTexto2 = new javax.swing.JScrollPane();
        areaTexto2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(new java.awt.Dimension(510, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setText("INTERRUPCIONES");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        Regresar.setText("Continuar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        Regresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RegresarKeyTyped(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 87, -1));

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        Iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IniciarKeyTyped(evt);
            }
        });
        getContentPane().add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 73, -1));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Salir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SalirKeyPressed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 69, -1));

        areaTexto1.setEditable(false);
        areaTexto1.setColumns(3);
        areaTexto1.setRows(5);
        areaTexto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaTexto1KeyTyped(evt);
            }
        });
        areaDeTexto1.setViewportView(areaTexto1);

        getContentPane().add(areaDeTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, 180));

        areaTexto2.setEditable(false);
        areaTexto2.setColumns(20);
        areaTexto2.setRows(5);
        areaDeTexto2.setViewportView(areaTexto2);

        getContentPane().add(areaDeTexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 240, 180));

        jLabel1.setText("Para interrumpir presione la tecla \" Shift + B\" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 260, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        Runnable r = new Contador();
        Thread t = new Thread(r);
        Iniciar.setEnabled(false);
        bandera2_Soporte_Enteros = false;
        bandera1_Accion_Tecla = false;
        this.contador = 0;
        areaTexto2.setText("");
        areaTexto1.setText("");
        t.start();
    }//GEN-LAST:event_IniciarActionPerformed
// Estos metodos son para reconocer las letra "B" para activar la bandera de accion por tecla 
    private void areaTexto1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTexto1KeyTyped
         char accionTeclado = evt.getKeyChar();
           if(accionTeclado == KeyEvent.VK_B){
               bandera1_Accion_Tecla = true;
           }
    }//GEN-LAST:event_areaTexto1KeyTyped

    private void IniciarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IniciarKeyTyped
           char accionTeclado = evt.getKeyChar();
           if(accionTeclado == KeyEvent.VK_B){
               bandera1_Accion_Tecla = true;
           }
    }//GEN-LAST:event_IniciarKeyTyped

    private void SalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalirKeyPressed
           char accionTeclado = evt.getKeyChar();
           if(accionTeclado == KeyEvent.VK_B){
               bandera1_Accion_Tecla = true;
             
           }
    }//GEN-LAST:event_SalirKeyPressed

    private void RegresarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RegresarKeyTyped
           char accionTeclado = evt.getKeyChar();
           if(accionTeclado == KeyEvent.VK_B){
               bandera1_Accion_Tecla = true;
           }
    }//GEN-LAST:event_RegresarKeyTyped
//EL metodo es para regresar al punto donde se quedo el contador y continuar contando.
    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        Runnable r = new Contador();
        Thread t = new Thread(r);
        Regresar.setEnabled(false);
        bandera1_Accion_Tecla = false;
        bandera2_Interrupcion_Tiempo = false;
        Iniciar.setEnabled(false);
        areaTexto2.setText("");
        t.start();
    }//GEN-LAST:event_RegresarActionPerformed

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
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane areaDeTexto1;
    private javax.swing.JScrollPane areaDeTexto2;
    private javax.swing.JTextArea areaTexto1;
    private javax.swing.JTextArea areaTexto2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
