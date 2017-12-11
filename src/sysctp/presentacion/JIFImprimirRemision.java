
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sysctp.reporte.remisionTiqueteriaPeajes.Reporte_remision_de_peajes;

/**
 *
 * @author jarteaga
 */
public class JIFImprimirRemision extends javax.swing.JInternalFrame {

    private Reporte_remision_de_peajes reporte;
    public JIFImprimirRemision() {
        initComponents();
        reporte=new Reporte_remision_de_peajes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_remision = new javax.swing.JTextField();
        btn_imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("UTDVVCC-Imprimir Remisión");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Remisión N°:");

        txt_remision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_remisionKeyPressed(evt);
            }
        });

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/printer2.png"))); // NOI18N
        btn_imprimir.setContentAreaFilled(false);
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        long remision; 
        
        if(txt_remision.getText().matches("[0-9]*"))
          {
              remision=Long.parseLong(txt_remision.getText());
              reporte.ejecutarReporte(remision);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "El número de la remisión debe ser numérico!");
         }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void txt_remisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_remisionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             long remision; 
        
        if(txt_remision.getText().matches("[0-9]*"))
          {
              remision=Long.parseLong(txt_remision.getText());
              reporte.ejecutarReporte(remision);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "El número de la remisión debe ser numérico!");
         }
        }
    }//GEN-LAST:event_txt_remisionKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_remision;
    // End of variables declaration//GEN-END:variables
}
