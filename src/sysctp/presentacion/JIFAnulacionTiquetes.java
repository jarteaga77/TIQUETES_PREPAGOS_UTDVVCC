package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.anulacionTiquetes.AnulacionTiquetes;
import sysctp.dominio.anulacionTiquetes.DaoAnulacionTiquetes;
import sysctp.dominio.anulacionTiquetes.DaoDetalle_anulacion_tiquetes;
import sysctp.dominio.anulacionTiquetes.Detalle_Anulacion_tiquetes;


/**
 *
 * @author jarteaga
 */
public class JIFAnulacionTiquetes extends javax.swing.JInternalFrame {

    private ConexionBD nueva;
    public static MDIPrincipal principal;
    private DefaultTableModel modelo;
    
    
    public JIFAnulacionTiquetes() {
        initComponents();
        nueva=new ConexionBD();
        
        modelo=new DefaultTableModel();
        
        
         ResultSet obj3=nueva.executeQuery("SELECT MAX(id_anulacion_tiquete)+1 AS idanulacion  FROM inventario.anulacion_tiquetes");
        try {
            while(obj3.next())
            {
                txt_idanulacion.setText(String.valueOf(obj3.getLong("idanulacion")));//Le asigna el consecutivo siguiente de orden compra al textfield
            }
            
            
         ResultSet obj=nueva.executeQuery("SELECT tipo_anulacion FROM inventario.tipo_anulacion ORDER BY tipo_anulacion ASC ");
              
           while(obj.next())
            {
                cb_ta.addItem(obj.getString("tipo_anulacion"));
            }    
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnulacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.desconectar();
     
          modelo.addColumn("ID");
          modelo.addColumn("Serial Inicial");
          modelo.addColumn("Serial Final");
          modelo.addColumn("Cantidad");
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_Detalle = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        txt_serial1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_serial2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_ta = new javax.swing.JComboBox<>();
        btn_aceptar_2 = new javax.swing.JButton();
        btn_cancelar_2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idanulacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_obs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        btn_adicionar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Serial Inicial");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Serial Final");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tipo de Anulación");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_aceptar_2.setText("Aceptar");
        btn_aceptar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_2ActionPerformed(evt);
            }
        });

        btn_cancelar_2.setText("Cancelar");
        btn_cancelar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JD_DetalleLayout = new javax.swing.GroupLayout(JD_Detalle.getContentPane());
        JD_Detalle.getContentPane().setLayout(JD_DetalleLayout);
        JD_DetalleLayout.setHorizontalGroup(
            JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_DetalleLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_ta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JD_DetalleLayout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(btn_aceptar_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_2)))
                .addContainerGap())
        );
        JD_DetalleLayout.setVerticalGroup(
            JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JD_DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_ta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(JD_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar_2)
                    .addComponent(btn_cancelar_2))
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP - Anulación Tiquetes");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Anulación de tiquetes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Anulación Tiquetes:");

        txt_idanulacion.setEditable(false);

        txt_area_obs.setColumns(20);
        txt_area_obs.setRows(5);
        jScrollPane1.setViewportView(txt_area_obs);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Observación:");

        btn_guardar.setText("Guardar");
        btn_guardar.setToolTipText("");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idanulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_guardar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idanulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Anulación Tiquetes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_detalle);

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_adicionar))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_adicionar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("static-access")
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        AnulacionTiquetes anulacion=new AnulacionTiquetes();
        DaoAnulacionTiquetes daoanulacion=new DaoAnulacionTiquetes();
         @SuppressWarnings("static-access")
         int id_usurio= principal.getSeccion();
        
        anulacion.setFecha_anulacion(new Date());
        anulacion.setId_usuario(id_usurio);
        anulacion.setObservacion(txt_area_obs.getText());
        
        daoanulacion.anularTiquete(anulacion);  
        txt_idanulacion.setText(String.valueOf(daoanulacion.getIdanulacion()));

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_aceptar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_2ActionPerformed
           
            int id_tipo = 0;
            if(cb_ta.getSelectedItem()!=null)
            {
            
                String tipo=cb_ta.getSelectedItem().toString();
                ResultSet obj1=nueva.executeQuery("SELECT id FROM inventario.tipo_anulacion WHERE tipo_anulacion='"+tipo+"'");
                
                try {
                    while(obj1.next())
                    {
                        id_tipo=obj1.getInt("id");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JIFAnulacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 

            nueva.desconectar();

        Detalle_Anulacion_tiquetes detalle=new Detalle_Anulacion_tiquetes();
        DaoDetalle_anulacion_tiquetes daodetalle=new DaoDetalle_anulacion_tiquetes();
        
        detalle.setSerial_inicial(Long.parseLong(txt_serial1.getText()));
        detalle.setSerial_final(Long.parseLong(txt_serial2.getText()));
        detalle.setId_anulacion(Long.parseLong(txt_idanulacion.getText()));
        detalle.setTipo_anulacion(id_tipo);
    
        daodetalle.adicionarDetalleAnulacion(detalle, Long.parseLong(txt_serial1.getText()), Long.parseLong(txt_serial2.getText()));
        txt_serial1.setText("");
        txt_serial2.setText("");
        try {
            LimpiarTabla();
            detalleTabla();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnulacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_aceptar_2ActionPerformed

    private void btn_cancelar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_2ActionPerformed
        JD_Detalle.dispose();
    }//GEN-LAST:event_btn_cancelar_2ActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
          JD_Detalle.pack();
          JD_Detalle.setLocationRelativeTo(null);
          JD_Detalle.setVisible(true);
          JD_Detalle.setResizable(false);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_aceptar_2;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_cancelar_2;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_ta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_detalle;
    private javax.swing.JTextArea txt_area_obs;
    private javax.swing.JTextField txt_idanulacion;
    private javax.swing.JTextField txt_serial1;
    private javax.swing.JTextField txt_serial2;
    // End of variables declaration//GEN-END:variables

    public void detalleTabla() throws SQLException
    {
        ResultSet obj=nueva.executeQuery("SELECT da_idanulacion,da_serial1,da_serial2,SUM(da_serial2-da_serial1 + 1) AS cantidad FROM inventario.detalle_anulacion_tiquetes WHERE id_anulacion="+txt_idanulacion.getText()+" GROUP BY da_idanulacion,da_serial1,da_serial2 ORDER BY da_idanulacion");
        
        while(obj.next())
        {
          Object [] datos = new Object[4];

        for (int i=0;i<4;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_detalle.setModel(modelo);
           nueva.desconectar();

    }
     //Limpia la tabla de Detalle 
    public void LimpiarTabla()
    {
        
   
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
    

    public void eliminarDetalle()
    {
    try
    {
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_detalle.isRowSelected(tabla_detalle.getSelectedRow()))
        {

           int row = tabla_detalle.getSelectedRow();

       
           nueva.executeUpdateQuery("DELETE FROM inventario.detalle_anulacion_tiquetes WHERE da_idanulacion="+modelo.getValueAt(row, 0)+"");
           nueva.executeUpdateQuery("BEGIN;");
           nueva.executeUpdateQuery("UPDATE inventario.consecutivos set conse_estado=true WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 1) +" AND "+modelo.getValueAt(row, 2) +"");
           this.confirmarTransaccion();
        
         int numRows = tabla_detalle.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         }
       }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecciona la fila a eliminar");
        }
        
        nueva.desconectar();
    }catch (Exception e)
    {
         JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
            public void confirmarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("COMMIT;");
        
            System.out.println("Pase por aqui");
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
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
