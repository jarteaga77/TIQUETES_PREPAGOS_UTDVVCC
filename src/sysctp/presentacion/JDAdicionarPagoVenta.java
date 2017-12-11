
/*
 * JDAdicionarPagoVenta.java
 *
 * Created on 17/08/2011, 10:48:09 AM
 */
package sysctp.presentacion;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author james
 */
public class JDAdicionarPagoVenta extends javax.swing.JDialog {

    

    private boolean cancel = true;
    
    public static JIFRegistroVenta registroVenta;
    
    /** Creates new form JDAdicionarPagoVenta */
   
    public static JTextField gettxtIDFormaPago() {
        return txtIDFormaPago;
    }

    public static void settxtIDFormaPago(int  id) {
        JDAdicionarPagoVenta.txtIDFormaPago.setText(String.valueOf(id));
    }
    
    public static JTextField gettxtIDCuentaBancaria() {
        return txtIDCuentaBancaria;
    }

    public static void settxtIDCuentaBancaria(int  id) {
        JDAdicionarPagoVenta.txtIDCuentaBancaria.setText(String.valueOf(id));
    }
    
    public static void settxttxtMontoPagado(long totalventa)
    {
        JDAdicionarPagoVenta.txtMontoPagado.setText(String.valueOf(totalventa));
    }
    
    
    public JDAdicionarPagoVenta(JIFRegistroVenta parent, boolean modal) {
        //super(parent, modal);

        this.registroVenta=parent;
        this.setModal(modal);
        initComponents();
    }

    public int getIDFormaPago(){
        try{
            return Integer.parseInt(txtIDFormaPago.getText());
        }catch(Exception e){
            return 0;
        }
    }
    
    public long getMontoPagado(){
        return Long.parseLong(txtMontoPagado.getText());
    }
    
    public int getIDCuentaBancaria(){
        try{
            return Integer.parseInt(txtIDCuentaBancaria.getText());
        }catch(Exception e){
            return 0;
        }    
    }
    
    public String getSerialTransaccion(){
        return txtSerialTransaccion.getText().trim();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDFormaPago = new javax.swing.JTextField();
        txtMontoPagado = new javax.swing.JTextField();
        txtIDCuentaBancaria = new javax.swing.JTextField();
        txtSerialTransaccion = new javax.swing.JTextField();
        btnMostrarEspecificaciones = new javax.swing.JButton();
        btnMostrarEspecificaciones1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar pago...");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("ID Cuenta Bancaria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Serial Transacción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Forma de Pago:");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Monto Pagado :  $");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(txtIDFormaPago, gridBagConstraints);

        txtMontoPagado.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(txtMontoPagado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(txtIDCuentaBancaria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txtSerialTransaccion, gridBagConstraints);

        btnMostrarEspecificaciones.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        btnMostrarEspecificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btnMostrarEspecificaciones.setBorderPainted(false);
        btnMostrarEspecificaciones.setFocusable(false);
        btnMostrarEspecificaciones.setPreferredSize(new java.awt.Dimension(23, 23));
        btnMostrarEspecificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarEspecificacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarEspecificacionesMouseExited(evt);
            }
        });
        btnMostrarEspecificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEspecificacionesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(btnMostrarEspecificaciones, gridBagConstraints);

        btnMostrarEspecificaciones1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        btnMostrarEspecificaciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btnMostrarEspecificaciones1.setBorderPainted(false);
        btnMostrarEspecificaciones1.setFocusable(false);
        btnMostrarEspecificaciones1.setPreferredSize(new java.awt.Dimension(23, 23));
        btnMostrarEspecificaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarEspecificaciones1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarEspecificaciones1MouseExited(evt);
            }
        });
        btnMostrarEspecificaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEspecificaciones1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(btnMostrarEspecificaciones1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarEspecificacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesMouseEntered
        //        jButton1.setBorderPainted(true);
}//GEN-LAST:event_btnMostrarEspecificacionesMouseEntered

    private void btnMostrarEspecificacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesMouseExited
        //        jButton1.setBorderPainted(false);
}//GEN-LAST:event_btnMostrarEspecificacionesMouseExited

    private void btnMostrarEspecificaciones1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificaciones1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarEspecificaciones1MouseEntered

    private void btnMostrarEspecificaciones1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificaciones1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarEspecificaciones1MouseExited

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       
        if(txtIDCuentaBancaria.getText().isEmpty() || txtIDFormaPago.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(registroVenta,"El ID de la cuenta bancaria y el ID de forma de pago son campos oblicatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
            
        {
           this.setCancel(false);
           this.setVisible(false); 
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setCancel(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMostrarEspecificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesActionPerformed
         jDTablaCuentaBancaria jdCTA=new jDTablaCuentaBancaria(new javax.swing.JFrame(), true);
        
        jdCTA.setLocation(700, 0);
        
        jdCTA.setVisible(true);
    }//GEN-LAST:event_btnMostrarEspecificacionesActionPerformed

    private void btnMostrarEspecificaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEspecificaciones1ActionPerformed
        jDTablaFormaPago jdTFP=new jDTablaFormaPago(new javax.swing.JFrame(), true);
        
        jdTFP.setLocation(700, 0);
        
        jdTFP.setVisible(true);
    
    }//GEN-LAST:event_btnMostrarEspecificaciones1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMostrarEspecificaciones;
    private javax.swing.JButton btnMostrarEspecificaciones1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField txtIDCuentaBancaria;
    private static javax.swing.JTextField txtIDFormaPago;
    private static javax.swing.JTextField txtMontoPagado;
    private javax.swing.JTextField txtSerialTransaccion;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the cancel
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
