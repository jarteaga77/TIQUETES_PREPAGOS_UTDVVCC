
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.inventario.*;

/**
 *
 * @author jarteaga
 */
public final class JIFEspecificacionTP extends javax.swing.JInternalFrame {

    //Objeto de la clase ConexionBD
    ConexionBD nuevaCone=new ConexionBD();
    
    // Se inicializa un objeto de la clase LimpiarCampos
    LimpiarCampos olimpiar=new LimpiarCampos();
    
    //Variables para uso
    private int cat_id;
    private int tea_id;
    //Declaracion de objeto de una DefaultTableModel
    private DefaultTableModel modelo;
    
   
    
    
    public JIFEspecificacionTP() {
        initComponents();
        modelo= new DefaultTableModel(); 
     
        //Consultas  que llena los Combobox de la interfaz.
         try
        {
            ResultSet obj=nuevaCone.executeQuery("SELECT cat_nombre FROM inventario.categoria ORDER BY cat_nombre ASC  ");
            
            while(obj.next())
            {
                jCB_cat.addItem(obj.getObject("cat_nombre"));
            }
            nuevaCone.desconectar();
            
            obj=nuevaCone.executeQuery("SELECT tea_nombre FROM inventario.tipo_eje_adicional ORDER BY tea_nombre ASC");
            
            while(obj.next())
            {
               jCB_EjeAdicional.addItem(obj.getObject("tea_nombre"));
            }
            nuevaCone.desconectar();
            
            
            
        }catch(SQLException esql)
      {
          System.err.println(esql.getMessage());
      }
        modelo.addColumn("ID ");
        modelo.addColumn("Año");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCB_cat = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_precio = new javax.swing.JTextField();
        jYC_year = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        jCB_EjeAdicional = new javax.swing.JComboBox();
        jB_guardar = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaETP = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        btn_refrescar = new javax.swing.JButton();
        jYC_year1 = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("Especificación Tiquete Prepago");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Especificación Tiquete Prepago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Precio :$");

        jCB_cat.setMaximumRowCount(10);
        jCB_cat.setToolTipText("");

        jLabel2.setText("Año:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Eje Adicional:");

        jCB_EjeAdicional.setMaximumRowCount(10);
        jCB_EjeAdicional.setToolTipText("");

        jB_guardar.setText("Guardar");
        jB_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_guardarActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(318, 318, 318))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jYC_year, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCB_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jB_guardar)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jB_cancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49)
                                .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 90, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jCB_EjeAdicional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYC_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCB_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jCB_EjeAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_guardar)
                    .addComponent(jB_cancelar))
                .addGap(26, 26, 26))
        );

        jtablaETP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtablaETP);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_refrescar.setText("Refrescar ");
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_eliminar)
                            .addComponent(btn_refrescar)
                            .addComponent(jYC_year1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jYC_year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refrescar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action Event que llama a un metodo del da para guardar la informacion en la base de datos
    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed
          try
          {
            
            DaoEspecificacionTP daoETP=new DaoEspecificacionTP();
            EspecificacionTP etp= new EspecificacionTP();
              
            etp.setAño(jYC_year.getYear());            
            etp.setPrecio(Integer.parseInt(jtf_precio.getText()));
        
            String cate_nombre = jCB_cat.getSelectedItem().toString();

           ResultSet obj = nuevaCone.executeQuery("SELECT cat_id serial FROM inventario.categoria WHERE cat_nombre='" + cate_nombre + "'");

            while (obj.next()) {
               cat_id = obj.getInt(1);
               etp.setCate(cat_id);
            }
            
             String tea_nombre = jCB_EjeAdicional.getSelectedItem().toString();
            obj = nuevaCone.executeQuery("SELECT tea_id FROM inventario.tipo_eje_adicional WHERE tea_nombre='" + tea_nombre + "'");

            if (obj.next()==true) {
               tea_id = obj.getInt(1);
               etp.setTea(tea_id);
            }
              
              daoETP.guardar(etp);
              
              nuevaCone.desconectar();
              
              olimpiar.limpiar(jPanel2);
              LimpiarTabla();
              actualizarTabla();
              
          }catch(NumberFormatException | SQLException e)
          {
              JOptionPane.showMessageDialog(null, e, " Error", JOptionPane.ERROR_MESSAGE);
          }
                      
    }//GEN-LAST:event_jB_guardarActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
         elimarRegistroTabla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
        LimpiarTabla();
        actualizarTabla();
    }//GEN-LAST:event_btn_refrescarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JComboBox jCB_EjeAdicional;
    private javax.swing.JComboBox jCB_cat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYC_year;
    private com.toedter.calendar.JYearChooser jYC_year1;
    private javax.swing.JTable jtablaETP;
    private javax.swing.JTextField jtf_precio;
    // End of variables declaration//GEN-END:variables
   public void LimpiarTabla()
    {
        
   
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
// public void ingresarTabla()
// {
//      try
//        {
//
//       ResultSet obj=nuevaCone.executeQuery("SELECT a.etp_id, a.etp_anio,a.etp_precio, ca.cat_nombre,ea.tea_nombre FROM inventario.especificacion_tiquete_prepago a JOIN inventario.categoria ca ON a.cat_id=ca.cat_id JOIN inventario.tipo_eje_adicional ea ON a.tea_id=ea.tea_id "
//               + "GROUP BY a.etp_id, a.etp_anio,a.etp_precio, ca.cat_nombre,ea.tea_nombre");
//        
//        while (obj.next()) 
//        {
//        
//        Object [] datos = new Object[5];
//        
//        for (int i=0;i<5;i++)
//        {
//            datos[i] =obj.getObject(i+1);
//        }
//
//         modelo.addRow(datos);
//
//        }
//          jtablaETP.setModel(modelo);
//
//        }catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
//        } 
// }
 
    
    //Metodo que elimina una fila en la tabla y en la Base de datos
 public void elimarRegistroTabla()
{
 
     if(jtablaETP.isRowSelected(jtablaETP.getSelectedRow()))
     {

     try {

        int row = jtablaETP.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           nuevaCone.executeUpdateQuery("DELETE FROM inventario.especificacion_tiquete_prepago WHERE etp_id = '"+modelo.getValueAt(row, 0)+"'");

        }
      
         int numRows = jtablaETP.getSelectedRows().length;
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
            JOptionPane.showMessageDialog(null, "Registro eliminado satisfactoriamente.");
         }
         
 
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
      }
      
     }
     
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminar."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
     
     nuevaCone.desconectar();
}
 
 
 //Metodo que permite la actualizacion de la tabla en la base de datos
 public void actualizarTabla()
 {
     try
     {

 
     ResultSet obj=nuevaCone.executeQuery("SELECT a.etp_id, a.etp_anio,a.etp_precio, (ca.cat_nombre ||'-'|| ea.tea_nombre)AS descripcion FROM inventario.especificacion_tiquete_prepago a JOIN inventario.categoria ca ON a.cat_id=ca.cat_id JOIN inventario.tipo_eje_adicional ea ON a.tea_id=ea.tea_id WHERE a.etp_anio='"+jYC_year1.getYear()+"' GROUP BY a.etp_id, a.etp_anio,a.etp_precio, ca.cat_nombre,ea.tea_nombre ORDER BY descripcion ASC");
        
        
        while (obj.next()) 
        {     
        Object [] datos = new Object[4];
        
        for (int i=0;i<4;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);

        }
         jtablaETP.setModel(modelo);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
     nuevaCone.desconectar();

 }


 










}
