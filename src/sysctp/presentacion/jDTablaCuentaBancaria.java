
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class jDTablaCuentaBancaria extends javax.swing.JDialog {

    /**
     * Creates new form jDTablaCuentaBancaria
     */
    public jDTablaCuentaBancaria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        updateTabla();
    }
    
     private static int  id;
    
    
    public static int getid()
    {
        return jDTablaCuentaBancaria.id;
    }

    public void updateTabla()
    {
        try
        {
        ConexionBD nuevaCone=new ConexionBD();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID Cuenta");
        modelo.addColumn("Número de cuenta");
        modelo.addColumn("Nombre del banco");
       
     
        ResultSet obj=nuevaCone.executeQuery("SELECT * FROM ventas.cuenta_bancaria");
        
        while (obj.next()) 
        {     
        Object [] datos = new Object[3];
        
        for (int i=0;i<3;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);

        }
         jT_CTA.setModel(modelo);

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
        jB_copiar = new javax.swing.JButton();
        rb_excedente = new javax.swing.JRadioButton();
        rb_revalidacion = new javax.swing.JRadioButton();
        rb_exce_dep = new javax.swing.JRadioButton();
        rb_vali_dep = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_CTA = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas Bancarias");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rb_venta);
        rb_venta.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_venta.setSelected(true);
        rb_venta.setText("Venta");

        jB_copiar.setText("Copiar ID");
        jB_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_copiarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_excedente);
        rb_excedente.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_excedente.setText("Cancelación de excedente");

        buttonGroup1.add(rb_revalidacion);
        rb_revalidacion.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_revalidacion.setText("Validación Tiquetes");

        buttonGroup1.add(rb_exce_dep);
        rb_exce_dep.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_exce_dep.setText("Can. Excedente Depe.");

        buttonGroup1.add(rb_vali_dep);
        rb_vali_dep.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_vali_dep.setText("Validación Tiquetes Depe.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_copiar)
                    .addComponent(rb_venta)
                    .addComponent(rb_excedente)
                    .addComponent(rb_revalidacion)
                    .addComponent(rb_exce_dep)
                    .addComponent(rb_vali_dep))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_copiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_excedente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_exce_dep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_revalidacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_vali_dep)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jT_CTA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jT_CTA);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Cuenta Bancaria");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(158, 158, 158)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
          if(jT_CTA.isRowSelected(jT_CTA.getSelectedRow()))
            {
        
                id = (Integer) jT_CTA.getValueAt(jT_CTA.getSelectedRow(), 0);
                JDAdicionarPagoVenta.settxtIDCuentaBancaria(jDTablaCuentaBancaria.getid());
                dispose();
            }else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
        }else
            if(rb_excedente.isSelected()==true)
            {
                 if(jT_CTA.isRowSelected(jT_CTA.getSelectedRow()))
                 {
                     id = (Integer) jT_CTA.getValueAt(jT_CTA.getSelectedRow(), 0);
                     JIFRegistroActaCambio.settxtIDCtaBancaria(id);
                     dispose();
                 }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                }
            }else if(rb_revalidacion.isSelected()==true)
            {
                if(jT_CTA.isRowSelected(jT_CTA.getSelectedRow()))
                 {
                     id = (Integer) jT_CTA.getValueAt(jT_CTA.getSelectedRow(), 0);
                     JIFValidacionTiquetes.settxtIDCtaBan(id);
                     dispose();
                 }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                }
            }else if(rb_exce_dep.isSelected()==true)
            {
                if(jT_CTA.isRowSelected(jT_CTA.getSelectedRow()))
                 {
                     id = (Integer) jT_CTA.getValueAt(jT_CTA.getSelectedRow(), 0);
                     JIFRegistroActaCambioDependencia.settxtIDCtaBancaria(id);
                     dispose();
                 }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                }
            }else if(rb_vali_dep.isSelected()==true)
            {
                if(jT_CTA.isRowSelected(jT_CTA.getSelectedRow()))
                 {
                     id = (Integer) jT_CTA.getValueAt(jT_CTA.getSelectedRow(), 0);
                     JIFValidacionTiquetesDepe.settxtIDCtaBan(id);
                     dispose();
                 }
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
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
    private javax.swing.JTable jT_CTA;
    private javax.swing.JRadioButton rb_exce_dep;
    private javax.swing.JRadioButton rb_excedente;
    private javax.swing.JRadioButton rb_revalidacion;
    private javax.swing.JRadioButton rb_vali_dep;
    private javax.swing.JRadioButton rb_venta;
    // End of variables declaration//GEN-END:variables
}
