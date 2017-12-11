
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import sysctp.reporte.ventaDependencia.ReporteVentaDependencia;

/**
 *
 * @author jarteaga
 */
public class JIFImprimirVentaDepen extends javax.swing.JInternalFrame {

    private ReporteVentaDependencia reporte;
    public JIFImprimirVentaDepen() {
        initComponents();
        reporte=new ReporteVentaDependencia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id_ven_dep = new javax.swing.JTextField();
        btn_imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("UTDVVCC-Imprimir  Venta Dependencias");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID Venta Dependencia:");

        txt_id_ven_dep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_ven_depKeyPressed(evt);
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
                .addComponent(txt_id_ven_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id_ven_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        long id_ven_dep; 
        
        if(txt_id_ven_dep.getText().matches("[0-9]*"))
          {
              id_ven_dep=Long.parseLong(txt_id_ven_dep.getText());
              reporte.ejecutarReporte(id_ven_dep);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "El ID de la Venta de dependecia debe ser numérico!");
         }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void txt_id_ven_depKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_ven_depKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             long id_ven_dep; 
        
        if(txt_id_ven_dep.getText().matches("[0-9]*"))
          {
              id_ven_dep=Long.parseLong(txt_id_ven_dep.getText());
              reporte.ejecutarReporte(id_ven_dep);
              dispose();
          }
         else
         {
             JOptionPane.showMessageDialog(null, "El ID de la Venta de dependecia debe ser numérico!");
         }
        }
    }//GEN-LAST:event_txt_id_ven_depKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_id_ven_dep;
    // End of variables declaration//GEN-END:variables
}
