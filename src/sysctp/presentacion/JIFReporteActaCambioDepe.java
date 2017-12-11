
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import sysctp.reporte.actaCambioDependencia.ReporteActaCambioDepe;

/**
 *
 * @author jarteaga
 */
public class JIFReporteActaCambioDepe extends javax.swing.JInternalFrame {
    
    private ReporteActaCambioDepe jasper;

    public JIFReporteActaCambioDepe() {
        initComponents();
        jasper=new ReporteActaCambioDepe();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_consecutivo = new javax.swing.JTextField();
        jB_generar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reporte Acta de Cambio- Dependencia  UTDVVCC");

        jLabel1.setText("Consecutivo Acta de Cambio:");

        txt_consecutivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_consecutivoKeyPressed(evt);
            }
        });

        jB_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/printer2.png"))); // NOI18N
        jB_generar.setToolTipText("Imprimir Acta");
        jB_generar.setContentAreaFilled(false);
        jB_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_generar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_generar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_generarActionPerformed
        long consecutivo=Long.parseLong(txt_consecutivo.getText());
        jasper.ejecutarReporte(consecutivo);
        txt_consecutivo.setText("");
        dispose();
        
    }//GEN-LAST:event_jB_generarActionPerformed

    private void txt_consecutivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_consecutivoKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        long consecutivo=Long.parseLong(txt_consecutivo.getText());
        jasper.ejecutarReporte(consecutivo);
        txt_consecutivo.setText("");
        dispose();
        }
    }//GEN-LAST:event_txt_consecutivoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_generar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_consecutivo;
    // End of variables declaration//GEN-END:variables
}
