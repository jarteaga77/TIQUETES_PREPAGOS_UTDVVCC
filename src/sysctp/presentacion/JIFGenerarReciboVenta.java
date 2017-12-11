
package sysctp.presentacion;

import sysctp.reportes.venta.ReporteVenta;

/**
 *
 * @author jarteaga
 */
public class JIFGenerarReciboVenta extends javax.swing.JInternalFrame {

   private ReporteVenta jasper;
    public JIFGenerarReciboVenta() {
        initComponents();
        jasper=new ReporteVenta();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_recibo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jB_generar_recibo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Recibo de Caja Venta");
        setToolTipText("");

        txt_recibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_reciboKeyPressed(evt);
            }
        });

        jLabel1.setText("N° Recibo de Caja:");

        jB_generar_recibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/printer2.png"))); // NOI18N
        jB_generar_recibo.setContentAreaFilled(false);
        jB_generar_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_generar_reciboActionPerformed(evt);
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
                .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_generar_recibo)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_generar_recibo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_reciboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_reciboKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            long consecutivo = Long.parseLong(txt_recibo.getText());
            jasper.ejecutarReporte(consecutivo);
            dispose();
        }
    }//GEN-LAST:event_txt_reciboKeyPressed

    private void jB_generar_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_generar_reciboActionPerformed
        Long recibo =Long.parseLong( txt_recibo.getText());
        jasper.ejecutarReporte(recibo);
        dispose();
    }//GEN-LAST:event_jB_generar_reciboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_generar_recibo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_recibo;
    // End of variables declaration//GEN-END:variables
}
