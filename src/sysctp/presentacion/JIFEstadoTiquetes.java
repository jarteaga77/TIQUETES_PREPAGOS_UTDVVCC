
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class JIFEstadoTiquetes extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    public JIFEstadoTiquetes() {
        initComponents();
        
        modelo.addColumn("Tiquete - Serial");
        modelo.addColumn("Estado");
       
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_estadotiquetes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_serial2 = new javax.swing.JTextField();
        txt_serial1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jB_consultar = new javax.swing.JButton();
        label_cantidad = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estado de los Tiquetes UTDVVCC");

        jt_estadotiquetes.setAutoCreateRowSorter(true);
        jt_estadotiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_estadotiquetes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro por consecutivo de tiquetes"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Serial desde:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Serial hasta:");

        jB_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        jB_consultar.setToolTipText("Buscar");
        jB_consultar.setContentAreaFilled(false);
        jB_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_consultarActionPerformed(evt);
            }
        });

        label_cantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_cantidad.setText("Cantidad Tiquetes: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_cantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jB_consultar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_cantidad))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jB_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_consultarActionPerformed
       
        if(txt_serial1.getText().isEmpty() || txt_serial2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Campos vacios, Dilegencie los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(txt_serial1.getText().matches("[0-9]*") && txt_serial2.getText().matches("[0-9]*"))
        {
            long serial1=Long.parseLong(txt_serial1.getText());
            long serial2=Long.parseLong(txt_serial2.getText());
            LimpiarJTabla();
            estadoTiquetes(serial1, serial2);
        }else
        { 
            JOptionPane.showMessageDialog(null, "Solo se permiten datos numéricos");
        }
            
        }
        
    }//GEN-LAST:event_jB_consultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_estadotiquetes;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JTextField txt_serial1;
    private javax.swing.JTextField txt_serial2;
    // End of variables declaration//GEN-END:variables

public void estadoTiquetes(long serial1, long serial2)
{
   try
   {
       ConexionBD nueva=new ConexionBD();
       long total=0;
       
       ResultSet obj=nueva.executeQuery("SELECT  conse_num_consecutivo_tiqute,conse_estado,count(conse_num_consecutivo_tiqute)AS cantidad FROM inventario.consecutivos WHERE conse_num_consecutivo_tiqute BETWEEN "+serial1+" AND "+serial2+" GROUP BY conse_num_consecutivo_tiqute,conse_estado");
       
       while (obj.next()) 
        {
        
            
         total+=obj.getLong("cantidad");
         //activos+=obj.getLong("estado");
         //puv+=obj.getLong("puv");
         Object [] datos = new Object[2];
        
        
        
        for (int i=0;i<2;i++)
        {
            datos[i] =obj.getObject(i+1);
        }
         modelo.addRow(datos);
         jt_estadotiquetes.setModel(modelo);

        }
       
        label_cantidad.setText("Cantidad Tiquetes: " + total);
       
        nueva.desconectar();
       
   }catch(Exception e)
   {
       
   }             
}
        public void LimpiarJTabla()
        {

        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
        
        
    }

}
