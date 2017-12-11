
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.banco.CuentaBanco;
import sysctp.dominio.banco.DaoBanco;

/**
 *
 * @author jarteaga
 */
public class JIFCuentaBanco extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFCuentaBanco
     */
    LimpiarCampos olimpiar=new LimpiarCampos();
    
    ConexionBD nueva=new ConexionBD();
    
    public JIFCuentaBanco() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_ctaNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_banco = new javax.swing.JTextField();
        jB_guardar = new javax.swing.JButton();
        jB_eliminar = new javax.swing.JButton();
        jB_buscar = new javax.swing.JButton();
        jB_ingresar = new javax.swing.JButton();
        jB_mod = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cuenta bancaria");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("CUENTA BANCARIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Cuenta Número:");

        jtf_ctaNum.setEnabled(false);

        jLabel2.setText("Nombre del banco:");

        jtf_banco.setEnabled(false);

        jB_guardar.setText("Guardar");
        jB_guardar.setEnabled(false);
        jB_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_guardarActionPerformed(evt);
            }
        });

        jB_eliminar.setText("Eliminar");
        jB_eliminar.setEnabled(false);

        jB_buscar.setText("Buscar");
        jB_buscar.setEnabled(false);

        jB_ingresar.setText("Ingresar");
        jB_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ingresarActionPerformed(evt);
            }
        });

        jB_mod.setText("Modificar");
        jB_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_modActionPerformed(evt);
            }
        });

        jB_cancelar.setText("Cancelar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jB_ingresar)
                        .addGap(18, 18, 18)
                        .addComponent(jB_guardar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_ctaNum)
                    .addComponent(jtf_banco)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jB_mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jB_eliminar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_buscar)
                    .addComponent(jB_cancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_ctaNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_buscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_ingresar)
                    .addComponent(jB_guardar)
                    .addComponent(jB_mod)
                    .addComponent(jB_eliminar)
                    .addComponent(jB_cancelar))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ingresarActionPerformed
        jB_ingresar.setEnabled(false);
        jtf_ctaNum.setEnabled(true);
        jtf_banco.setEnabled(true);
        jB_guardar.setEnabled(true);
        
    }//GEN-LAST:event_jB_ingresarActionPerformed

    //Metodo ActionEvent que utiliza la Clase DaCuentaBanco para utilizar los metodos crud.
    
    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed
      try
      {
        
        CuentaBanco ctabanco=new CuentaBanco();
        DaoBanco daobanco=new DaoBanco();
      
        ctabanco.setCta_numero(jtf_ctaNum.getText());
        ctabanco.setCta_banco(jtf_banco.getText());
        
      
        confIncial();
        olimpiar.limpiar(jPanel2);
      
        daobanco.guardar(ctabanco);
        
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_jB_guardarActionPerformed

    private void jB_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_modActionPerformed
     jtf_ctaNum.setEnabled(true);
     jB_buscar.setEnabled(true);
     jB_ingresar.setEnabled(false);
     jB_mod.setEnabled(false);
    }//GEN-LAST:event_jB_modActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        jtf_ctaNum.setEnabled(false);
        jtf_banco.setEnabled(false);
        jB_ingresar.setEnabled(true);
        jB_mod.setEnabled(true);
        jB_eliminar.setEnabled(false);
        dispose();
        
    }//GEN-LAST:event_jB_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_eliminar;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JButton jB_ingresar;
    private javax.swing.JButton jB_mod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_banco;
    private javax.swing.JTextField jtf_ctaNum;
    // End of variables declaration//GEN-END:variables


        //Configuracion Inicial de la Interfaz Grafica
        public void confIncial()
        {
            jtf_ctaNum.setEnabled(false);
            jtf_banco.setEnabled(false);
            jB_ingresar.setEnabled(true);
            jB_guardar.setEnabled(false);
            jB_mod.setEnabled(true);
            jB_eliminar.setEnabled(false);
            olimpiar.limpiar(jPanel2);
    
        }
    
        
        // Metodo para consultar la Base de Datos 
    public void consulta()
    {
    try
    {
        CuentaBanco ctabanco= new CuentaBanco();
        
        ResultSet obj=nueva.executeQuery("SELECT cban_numero,cban_banco FROM ventas.cuenta_bancaria where cban_numero="+jtf_ctaNum.getText()+"");
        
        if(obj.next()==true)
        {
            obj.getInt("cban_numero");
            ctabanco.setCta_banco(obj.getString("cban_banco"));
            jtf_banco.setText(ctabanco.getCta_banco());
            
            jtf_ctaNum.setEnabled(false);
            jtf_banco.setEnabled(false);  
            jB_eliminar.setEnabled(true);
            
           JOptionPane.showMessageDialog(null,"La  cuenta bancaria fue encontrada, Puede eliminarla !");
        }

        else
        {
            JOptionPane.showMessageDialog(null," La cuenta bancaria no fue encontrada");
        }
        
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
    }


    }

}
