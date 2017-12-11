
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class jDTablaFormaPago extends javax.swing.JDialog {

    private static int  id;

    public static int getid()
    {
        return jDTablaFormaPago.id;
    }
    
   
    public jDTablaFormaPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateTabla();
        
    }
    
     public void updateTabla()
    {
        try
        {
        ConexionBD nuevaCone=new ConexionBD();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID Forma Pago");
        modelo.addColumn("Descripción");
       
       
     
        ResultSet obj=nuevaCone.executeQuery("SELECT * FROM ventas.forma_de_pago ORDER BY fp_descripcion ASC");
        
        while (obj.next()) 
        {     
        Object [] datos = new Object[2];
        
        for (int i=0;i<2;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);

        }
         jT_FP.setModel(modelo);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_venta = new javax.swing.JRadioButton();
        rb_excedente = new javax.swing.JRadioButton();
        jB_copiar = new javax.swing.JButton();
        rb_venta_dep = new javax.swing.JRadioButton();
        rb_revalidacion = new javax.swing.JRadioButton();
        rb_exce_depe = new javax.swing.JRadioButton();
        rb_val_depe = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_FP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formas de Pago");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rb_venta);
        rb_venta.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_venta.setSelected(true);
        rb_venta.setText("Venta");

        buttonGroup1.add(rb_excedente);
        rb_excedente.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_excedente.setText("Cancelación de Excedente");

        jB_copiar.setText("Copiar ID");
        jB_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_copiarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_venta_dep);
        rb_venta_dep.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_venta_dep.setText("Venta Dependencia");

        buttonGroup1.add(rb_revalidacion);
        rb_revalidacion.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_revalidacion.setText("Validación Tiquetes");

        buttonGroup1.add(rb_exce_depe);
        rb_exce_depe.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_exce_depe.setText("Can. Excedente Dependencia");

        buttonGroup1.add(rb_val_depe);
        rb_val_depe.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_val_depe.setText("Validación Tiquetes Depe.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_venta)
                    .addComponent(jB_copiar)
                    .addComponent(rb_venta_dep)
                    .addComponent(rb_revalidacion)
                    .addComponent(rb_exce_depe)
                    .addComponent(rb_excedente)
                    .addComponent(rb_val_depe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_copiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_excedente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_exce_depe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_venta_dep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_revalidacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rb_val_depe)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jT_FP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jT_FP);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Forma de Pago");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addGap(204, 225, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_copiarActionPerformed
         
        if(rb_venta.isSelected()==true)
        {
             if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
          {
            id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
            JDAdicionarPagoVenta.settxtIDFormaPago(jDTablaFormaPago.getid());
            dispose();
          } else
          { 
              JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
          }
        }else
            if(rb_excedente.isSelected()==true)
            {
                 if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
          {
            id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
            JIFRegistroActaCambio.settxtIDFormaPago(jDTablaFormaPago.getid());
            dispose();
          } else
          { 
              JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
          }
            }else if(rb_venta_dep.isSelected()==true)
            {
             if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
            {
                id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
                JIFRegistroVentaDependencia.settxtIDFormaPago(jDTablaFormaPago.getid());
                dispose();
            } else
              { 
              JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
              }
             
            }
            else if(rb_revalidacion.isSelected()==true)
            {
                if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
                {   
                id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
                JIFValidacionTiquetes.settxtIDFormaPago(jDTablaFormaPago.getid());
                dispose();
                }
            
            else
              { 
              JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
              }
            }else if(rb_exce_depe.isSelected()==true)
            {
                if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
                {   
                    id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
                    JIFRegistroActaCambioDependencia.settxtIDFormaPago(jDTablaFormaPago.getid());
                    dispose();
                }
                else
                { 
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
                }
                
            }else if(rb_val_depe.isSelected()==true)
            {
                
                if(jT_FP.isRowSelected(jT_FP.getSelectedRow()))
                {   
                    id = (Integer) jT_FP.getValueAt(jT_FP.getSelectedRow(), 0);
                    JIFValidacionTiquetesDepe.settxtIDFormaPago(jDTablaFormaPago.getid());
                    dispose();
                }
                else
                { 
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla !", "Alerta!", JOptionPane.WARNING_MESSAGE);
              
                }
            }
        
       
    }//GEN-LAST:event_jB_copiarActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jB_copiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_FP;
    private javax.swing.JRadioButton rb_exce_depe;
    private javax.swing.JRadioButton rb_excedente;
    private javax.swing.JRadioButton rb_revalidacion;
    private javax.swing.JRadioButton rb_val_depe;
    private javax.swing.JRadioButton rb_venta;
    private javax.swing.JRadioButton rb_venta_dep;
    // End of variables declaration//GEN-END:variables
}
