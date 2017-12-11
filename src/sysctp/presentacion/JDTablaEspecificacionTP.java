
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class JDTablaEspecificacionTP extends javax.swing.JDialog {

    private static int  id;
    private ConexionBD nuevaCone=new ConexionBD();     
    private DefaultTableModel modelo = new DefaultTableModel();
        

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JDTablaEspecificacionTP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        modelo.addColumn("Año");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("ID");
         
   
    }
   
    public static int getid()
    {
        return JDTablaEspecificacionTP.id;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_ETP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_cpID1 = new javax.swing.JButton();
        rb_venta = new javax.swing.JRadioButton();
        rb_venta_parcial = new javax.swing.JRadioButton();
        rb_remision = new javax.swing.JRadioButton();
        rb_acta_re = new javax.swing.JRadioButton();
        rb_acta_ent = new javax.swing.JRadioButton();
        rb_dependencias = new javax.swing.JRadioButton();
        rb_revalidacion = new javax.swing.JRadioButton();
        rb_acta_re1 = new javax.swing.JRadioButton();
        rb_cam_ente = new javax.swing.JRadioButton();
        year_chooser = new com.toedter.calendar.JYearChooser();
        btn_filtrar = new javax.swing.JButton();
        rb_val_dep = new javax.swing.JRadioButton();
        rb_devo = new javax.swing.JRadioButton();
        rb_entrega = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Especificación Tiquetes prepagos");

        jT_ETP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jT_ETP);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Especificación Tiquete Prepago");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_cpID1.setText("Copiar ID");
        btn_cpID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cpID1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_venta);
        rb_venta.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_venta.setSelected(true);
        rb_venta.setText("Venta");

        buttonGroup1.add(rb_venta_parcial);
        rb_venta_parcial.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_venta_parcial.setText("Venta Parcial");

        buttonGroup1.add(rb_remision);
        rb_remision.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_remision.setText("Remisión Tiqueteria");

        buttonGroup1.add(rb_acta_re);
        rb_acta_re.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_acta_re.setText("Acta de Cambio Tiquetes Recibidos");

        buttonGroup1.add(rb_acta_ent);
        rb_acta_ent.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_acta_ent.setText("Acta de cambio Tiquetes Entregados");

        buttonGroup1.add(rb_dependencias);
        rb_dependencias.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_dependencias.setText("Venta dependencias Internas");

        buttonGroup1.add(rb_revalidacion);
        rb_revalidacion.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_revalidacion.setText("Validación Tiquetes");

        buttonGroup1.add(rb_acta_re1);
        rb_acta_re1.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_acta_re1.setText("Acta de Cambio Tiquetes Recibidos Depen.");

        buttonGroup1.add(rb_cam_ente);
        rb_cam_ente.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_cam_ente.setText("Acta de Cambio Tiquetes Entregados Depen.");

        btn_filtrar.setText("Filtrar");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_val_dep);
        rb_val_dep.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_val_dep.setText("Validación Tiquetes Depe.");

        buttonGroup1.add(rb_devo);
        rb_devo.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_devo.setText("Devolución de Dinero");

        buttonGroup1.add(rb_entrega);
        rb_entrega.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        rb_entrega.setText("Entrega Tiquetes de Peaje");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rb_acta_re)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(year_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(btn_filtrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cpID1)
                                .addGap(28, 28, 28)))
                        .addComponent(rb_acta_re1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_venta)
                            .addComponent(rb_venta_parcial)
                            .addComponent(rb_remision)
                            .addComponent(rb_acta_ent)
                            .addComponent(rb_dependencias)
                            .addComponent(rb_revalidacion)
                            .addComponent(rb_cam_ente)
                            .addComponent(rb_val_dep)
                            .addComponent(rb_devo)
                            .addComponent(rb_entrega))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_filtrar)
                        .addComponent(btn_cpID1))
                    .addComponent(year_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_venta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_venta_parcial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_remision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_acta_re)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_acta_ent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_acta_re1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_cam_ente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_dependencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_revalidacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_val_dep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_devo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rb_entrega)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cpID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cpID1ActionPerformed
       if(rb_venta.isSelected()==true)
       {
           if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
            {
                id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);    
                JDAdicionarLineaVenta.settxtIDEspecificacion(JDTablaEspecificacionTP.getid());          
                dispose();
       
            }else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
      }else
           if(rb_remision.isSelected()==true)
           {
             if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
             {
                id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                JIFRemisionTiqueteria.settxtIDEspecificacion(id); 
                dispose();
       
            }else
            {    
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            } 
           }else
               if(rb_venta_parcial.isSelected()==true)
               {
                    if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                    {
                        id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                        JIFEdicionVentaParcial.settxtIDEspecificacion(id); 
                        dispose();
       
                    }else
                        {
                           JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                        }
               }else
                   if(rb_acta_re.isSelected()==true)
                   {
                        if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegistroActaCambio.settxtIDEspecificacion(id); 
                            dispose();
       
                        }else
                        {
                           JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                        }
                   }else
                       if(rb_acta_ent.isSelected()==true)
                       {
                            if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegistroActaCambio.settxtIDEspecificacion2(id); 
                            dispose();
                        } 
                           else
                                
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        
                        }else if(rb_dependencias.isSelected()==true)
                        {
                             if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                            {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegistroVentaDependencia.settxtIDEspecificacion(id); 
                            dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        } else if(rb_revalidacion.isSelected()==true)
                        {
                            if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                            {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFValidacionTiquetes.settxtIDEspecificacion(id); 
                            dispose();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        }else if(rb_acta_re1.isSelected())
                        {
                             if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegistroActaCambioDependencia.settxtIDEspecificacion(id); 
                            dispose();
       
                        }else
                        {
                           JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                        }
                        }else if(rb_cam_ente.isSelected())
                        {
                            
                            if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegistroActaCambioDependencia.settxtIDEspecificacion2(id); 
                            dispose();
                        } 
                           else
                                
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                            
                            
                        }else if(rb_val_dep.isSelected()==true)
                        {
                              if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFValidacionTiquetesDepe.settxtIDEspecificacion(id); 
                            dispose();
                        } 
                           else
                                
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        }else if(rb_devo.isSelected()==true)
                        {
                          if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFDevolucionDinero.settxtIDEspecificacion(id); 
                            dispose();
                        } 
                           else
                                
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        }else if(rb_entrega.isSelected()==true)
                        {
                          if(jT_ETP.isRowSelected(jT_ETP.getSelectedRow()))
                        {
                            id = (Integer) jT_ETP.getValueAt(jT_ETP.getSelectedRow(), 3);  
                            JIFRegEntregaTiqPeajes.settxtIDEspecificacion(id); 
                            dispose();
                        } 
                           else
                                
                            {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
                            }
                        }
          
    }//GEN-LAST:event_btn_cpID1ActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        LimpiarJTabla();
        filtrarBusquedaFecha();
    }//GEN-LAST:event_btn_filtrarActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cpID1;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_ETP;
    private javax.swing.JRadioButton rb_acta_ent;
    private javax.swing.JRadioButton rb_acta_re;
    private javax.swing.JRadioButton rb_acta_re1;
    private javax.swing.JRadioButton rb_cam_ente;
    private javax.swing.JRadioButton rb_dependencias;
    private javax.swing.JRadioButton rb_devo;
    private javax.swing.JRadioButton rb_entrega;
    private javax.swing.JRadioButton rb_remision;
    private javax.swing.JRadioButton rb_revalidacion;
    private javax.swing.JRadioButton rb_val_dep;
    private javax.swing.JRadioButton rb_venta;
    private javax.swing.JRadioButton rb_venta_parcial;
    private com.toedter.calendar.JYearChooser year_chooser;
    // End of variables declaration//GEN-END:variables
  public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }
  
  public void filtrarBusquedaFecha()
  {
      try
        {
        ResultSet obj=nuevaCone.executeQuery("SELECT a.etp_anio,a.etp_precio,(ca.cat_nombre ||'-'|| ea.tea_nombre)AS descripcion,a.etp_id FROM inventario.especificacion_tiquete_prepago a "
                + "JOIN inventario.categoria ca ON a.cat_id=ca.cat_id "
                + "JOIN inventario.tipo_eje_adicional ea ON a.tea_id=ea.tea_id WHERE a.etp_anio="+year_chooser.getYear()+"  "
                + "GROUP BY a.etp_id, a.etp_anio,a.etp_precio, ca.cat_nombre,ea.tea_nombre ORDER BY ca.cat_nombre,ea.tea_nombre ASC");

        
        while (obj.next()) 
        {     
        Object [] datos = new Object[4];
        
        for (int i=0;i<4;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);

        }
         jT_ETP.setModel(modelo);

        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
  }



}
