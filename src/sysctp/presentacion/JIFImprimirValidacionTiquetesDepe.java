
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sysctp.reporte.validacion.dependencia.ReporteValidacionDepe;

/**
 *
 * @author jarteaga
 */
public class JIFImprimirValidacionTiquetesDepe extends javax.swing.JInternalFrame {

    private ReporteValidacionDepe reporte;
    public JIFImprimirValidacionTiquetesDepe() {
        initComponents();
        reporte=new ReporteValidacionDepe();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idValidacion = new javax.swing.JTextField();
        btn_imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP- Imprimir Validación Tiquetes Dependencias");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Recibo caja N°:");

        txt_idValidacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idValidacionKeyPressed(evt);
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
                .addComponent(txt_idValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        long recibo; 
        
        if(txt_idValidacion.getText().matches("[0-9]*"))
          {
              recibo=Long.parseLong(txt_idValidacion.getText());
              reporte.ejecutarReporte(recibo);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "Elrecibo de caja debe ser numérico!");
         }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void txt_idValidacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idValidacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             long recibo; 
        
        if(txt_idValidacion.getText().matches("[0-9]*"))
          {
              recibo=Long.parseLong(txt_idValidacion.getText());
              reporte.ejecutarReporte(recibo);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "El Recibo de caja debe ser numérico!");
         }
        }
    }//GEN-LAST:event_txt_idValidacionKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_idValidacion;
    // End of variables declaration//GEN-END:variables
}
