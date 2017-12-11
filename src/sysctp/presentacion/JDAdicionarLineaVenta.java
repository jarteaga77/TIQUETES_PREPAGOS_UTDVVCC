


/*
 * JDAdicionarLineaVenta.java
 *
 * Created on 6/04/2011, 04:54:19 PM
 */

package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author james
 */
public class JDAdicionarLineaVenta extends javax.swing.JDialog {

    private boolean cancel = true;
    public static JIFRegistroVenta registroVenta;
    private ConexionBD nueva =new ConexionBD();
    

    /** Creates new form JDAdicionarLineaVenta
     * @param parent El la ventana o componente que llama a este dialogo
     * @param modal Este parametro con valor verdaro indica la ventana o componente que inició este dialogo se bloquea hasta que el dialogo se halla cerrado
     */
    public JDAdicionarLineaVenta(JIFRegistroVenta parent, boolean modal ) {
        //super(parent, modal);
        this.registroVenta=parent;
        this.setModal(modal);
        initComponents();
    }
    
    
    
    public static JTextField gettxtIDEspecificacion() {
        return txtIDEspecificacion;
    }

    public static void settxtIDEspecificacion(int  id) {
        JDAdicionarLineaVenta.txtIDEspecificacion.setText(String.valueOf(id));
    }


    /**
     * 
     * @return
     */
    public int getIDEspecificacion(){
        return Integer.parseInt(txtIDEspecificacion.getText());
    }

    /**
     * 
     * @return
     */
    public long getSerialInicial(){
        return Long.parseLong(txtSerialInicial.getText());
    }

    /**
     * 
     * @return
     */
    public long getSerialFinal(){
        return Long.parseLong(txtSerialFinal.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLineaVenta = new javax.swing.JPanel();
        labelIDEspecificacion = new javax.swing.JLabel();
        labelSerialInicial = new javax.swing.JLabel();
        txtSerialInicial = new javax.swing.JTextField();
        labelSerialFinal = new javax.swing.JLabel();
        txtSerialFinal = new javax.swing.JTextField();
        panelControl = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIDEspecificacion = new javax.swing.JTextField();
        btnMostrarEspecificaciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Venta...");

        panelLineaVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelLineaVenta.setLayout(new java.awt.GridBagLayout());

        labelIDEspecificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelIDEspecificacion.setText("ID Especificacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelLineaVenta.add(labelIDEspecificacion, gridBagConstraints);

        labelSerialInicial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSerialInicial.setText("Serial Inicial: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelLineaVenta.add(labelSerialInicial, gridBagConstraints);

        txtSerialInicial.setColumns(19);
        txtSerialInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelLineaVenta.add(txtSerialInicial, gridBagConstraints);

        labelSerialFinal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSerialFinal.setText("Serial Final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelLineaVenta.add(labelSerialFinal, gridBagConstraints);

        txtSerialFinal.setColumns(19);
        txtSerialFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelLineaVenta.add(txtSerialFinal, gridBagConstraints);

        panelControl.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });
        panelControl.add(btnAceptar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        panelControl.add(btnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLineaVenta.add(panelControl, gridBagConstraints);

        txtIDEspecificacion.setColumns(10);
        txtIDEspecificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelLineaVenta.add(txtIDEspecificacion, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 5, 0);
        panelLineaVenta.add(btnMostrarEspecificaciones, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLineaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLineaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            evt.getComponent().transferFocus(); 
            
        }else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_txtKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnMostrarEspecificacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesMouseEntered
        //btnMostrarEspecificaciones.setBorderPainted(true);
    }//GEN-LAST:event_btnMostrarEspecificacionesMouseEntered

    private void btnMostrarEspecificacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesMouseExited
       //btnMostrarEspecificaciones.setBorderPainted(false);
    }//GEN-LAST:event_btnMostrarEspecificacionesMouseExited

    private void btnMostrarEspecificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEspecificacionesActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);
        
        jdETP.setLocation(700, 0);
        
        jdETP.setVisible(true);
    }//GEN-LAST:event_btnMostrarEspecificacionesActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
          try
        {
        ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
        
        if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(Long.parseLong(txtSerialInicial.getText()) >= minimo && Long.parseLong(txtSerialFinal.getText())<= maximo )
            {
                ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_estado="+true+" AND conse_num_consecutivo_tiqute BETWEEN "+txtSerialInicial.getText()+" AND "+txtSerialFinal.getText()+"");
            if(obj.next()==true)
            {
   
               nueva.executeUpdateQuery("BEGIN;");
  
               nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+txtSerialInicial.getText()+" AND "+txtSerialFinal.getText()+"");

               this.confirmarTransaccion();
               
             this.setCancel(false);
             this.setVisible(false);

                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango del serial no esta disponible ", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
           }
            else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
            
        }
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Error", JOptionPane.ERROR_MESSAGE);
        }
            
            
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
          
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
 
        try
        {
        ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
        
        if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(Long.parseLong(txtSerialInicial.getText()) >= minimo && Long.parseLong(txtSerialFinal.getText())<= maximo )
            {
                ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_estado="+true+" AND conse_num_consecutivo_tiqute BETWEEN "+txtSerialInicial.getText()+" AND "+txtSerialFinal.getText()+";");
            if(obj.next()==true)
            {
   
               nueva.executeUpdateQuery("BEGIN;");
  
               nueva.executeUpdateQuery("UPDATE inventario.consecutivoss SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+txtSerialInicial.getText()+" AND "+txtSerialFinal.getText()+"");

               this.confirmarTransaccion();
               
             this.setCancel(false);
             this.setVisible(false);

                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango del serial no esta disponible ", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
           }
            else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
            
        }
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Error", JOptionPane.ERROR_MESSAGE);
        }
        }    
            
    }//GEN-LAST:event_btnAceptarKeyPressed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMostrarEspecificaciones;
    private javax.swing.JLabel labelIDEspecificacion;
    private javax.swing.JLabel labelSerialFinal;
    private javax.swing.JLabel labelSerialInicial;
    private javax.swing.JPanel panelControl;
    private javax.swing.JPanel panelLineaVenta;
    private static javax.swing.JTextField txtIDEspecificacion;
    private javax.swing.JTextField txtSerialFinal;
    private javax.swing.JTextField txtSerialInicial;
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
    
    
    
    public void confirmarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("COMMIT;");
            this.setCancel(false);                
            this.setVisible(false);
            System.out.println("Confirmar Transaccion");
            nueva.desconectar();

        }catch(Exception e)

        {
            this.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e + "Error al confirmar la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
    
    public void cancelarTransaccion()
    {
        try
        {
            
            nueva.executeUpdateQuery("ROLLBACK;");
            System.out.println("Cancelar Transaccion");
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
