package sysctp.presentacion;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.ventas.DaoEdicionVentaParcial;
import sysctp.dominio.ventas.LineaVentaParcial;
import sysctp.reportes.venta.ReporteVenta;
/**
 *
 * @author jarteaga
 */
public class JIFEdicionVentaParcial extends javax.swing.JInternalFrame {

    private long vta_id=0;
    private DefaultTableModel modelo;
    private ConexionBD nueva;
    private LineaVentaParcial lineaVenta;
    private DaoEdicionVentaParcial daoVentaParcial;
    private ReporteVenta reporte;
    
    public JIFEdicionVentaParcial() {
        initComponents();
        modelo= new DefaultTableModel(); 
        nueva=new ConexionBD();
        lineaVenta=new LineaVentaParcial();
        daoVentaParcial=new DaoEdicionVentaParcial();
  
        //Modelo predeterminado de JTable
    modelo.addColumn("ID");
    modelo.addColumn("Serial Inicial");
    modelo.addColumn("Serial Final");
    modelo.addColumn("Cantidad");
    modelo.addColumn("Descripción");
    modelo.addColumn("Vlor. Unitario");
    modelo.addColumn("Total");

    }
    
        public static JTextField gettxtIDEspecificacion() {
        return txt_id;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFEdicionVentaParcial.txt_id.setText(String.valueOf(id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_LineaVenta = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_serial_inicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_serial_final = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();
        btn_tp = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_lineaVenta = new javax.swing.JTable();
        btn_adicionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        chb_cerrarVenta = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txt_recibo = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        JD_LineaVenta.setTitle("Registro Linea de Venta");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Especificación:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Serial Inicial:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Serial Final:");

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_tp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_tp.setBorderPainted(false);
        btn_tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tpActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_serial_final, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_serial_inicial, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_tp))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_serial_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_serial_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_LineaVentaLayout = new javax.swing.GroupLayout(JD_LineaVenta.getContentPane());
        JD_LineaVenta.getContentPane().setLayout(JD_LineaVentaLayout);
        JD_LineaVentaLayout.setHorizontalGroup(
            JD_LineaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_LineaVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_LineaVentaLayout.setVerticalGroup(
            JD_LineaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_LineaVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Edición Venta Parcial");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(770, 388));

        tabla_lineaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_lineaVenta);

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar.setBorderPainted(false);
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        chb_cerrarVenta.setSelected(true);
        chb_cerrarVenta.setText("Cerrar Venta");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Recibo de Venta:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar Venta Parcial");
        btn_buscar.setBorderPainted(false);
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Valor Total:");

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("0,0");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btn_imprimir)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_adicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chb_cerrarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_total)
                        .addGap(95, 95, 95)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chb_cerrarVenta)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(label_total)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
          JD_LineaVenta.pack();
          JD_LineaVenta.setLocationRelativeTo(null);
          JD_LineaVenta.setVisible(true);
          JD_LineaVenta.setResizable(false);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tpActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);     
        jdETP.setLocation(700, 0);      
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_tpActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_LineaVenta.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
       try
       {
           lineaVenta.setSerial_inicial(Long.parseLong(txt_serial_inicial.getText()));
           lineaVenta.setSerial_final(Long.parseLong(txt_serial_final.getText()));
           lineaVenta.setVent_id(vta_id);
           lineaVenta.setEtp_id(Integer.parseInt(txt_id.getText()));
           
           daoVentaParcial.actualizarVentaParcial(lineaVenta);
           JD_LineaVenta.dispose();
           LimpiarTabla();
           buscarVentaParcial();
           actualizarPago();
           sumatoriaTotales();
           
          txt_id.setText("");
          txt_serial_inicial.setText("");
          txt_serial_final.setText("");
           
           
       }catch(NumberFormatException | SQLException e)
       {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
        
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            buscarVentaParcial();
            sumatoriaTotales();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEdicionVentaParcial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       try
       {
           if(chb_cerrarVenta.isSelected()==true)
           {
               nueva.executeUpdateQuery("UPDATE ventas.venta SET venta_total="+true+", venta_parcial="+false+" WHERE ven_id="+vta_id+"");
               dispose();
               nueva.desconectar();
           }
           else
           {
               JOptionPane.showMessageDialog(null, "La venta queda abierta!");
               dispose();
           }
       }catch(Exception e)
       {
           System.out.println(e);
       }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
    
    try
    {
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_lineaVenta.isRowSelected(tabla_lineaVenta.getSelectedRow()))
        {

           int row = tabla_lineaVenta.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
        nueva.executeUpdateQuery("DELETE FROM ventas.detalle_venta WHERE dv_id="+modelo.getValueAt(row,0)+"");
        nueva.executeUpdateQuery("BEGIN;");
        nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row,1)+" AND "+modelo.getValueAt(row,2)+"");                
        this.confirmarTransaccion();
        }
         int numRows = tabla_lineaVenta.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         }
           LimpiarTabla();
           buscarVentaParcial();
           actualizarPago();
           sumatoriaTotales();
           nueva.desconectar();
         
        } 
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
        }catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e); 
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        reporte=new ReporteVenta();
         long recibo = Long.parseLong(txt_recibo.getText());
         reporte.ejecutarReporte(recibo);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_LineaVenta;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_tp;
    private javax.swing.JCheckBox chb_cerrarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_lineaVenta;
    public static javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_recibo;
    private javax.swing.JTextField txt_serial_final;
    private javax.swing.JTextField txt_serial_inicial;
    // End of variables declaration//GEN-END:variables

        public void buscarVentaParcial() throws SQLException
        {
          try
            {
      
            ResultSet obj=nueva.executeQuery("SELECT ven_id FROM ventas.venta WHERE ven_recibo_caja="+txt_recibo.getText()+" AND venta_parcial=true AND venta_total=false");
            
            if(obj.next()==true)
            {
             vta_id=obj.getLong("ven_id");
             
             
             ResultSet obj1=nueva.executeQuery("SELECT dv.dv_id,dv.dv_serial_1,dv.dv_serial_2,SUM(dv.dv_serial_2 - dv.dv_serial_1 + 1)AS cantidad,(cat.cat_nombre || '+' || tea.tea_nombre) AS descripcion,etp.etp_precio,SUM(dv.dv_serial_2 - dv.dv_serial_1 + 1)*etp.etp_precio AS total "
                    + "FROM ventas.detalle_venta dv JOIN ventas.venta ven ON ven.ven_id=dv.ven_id "
                    + "JOIN inventario.especificacion_tiquete_prepago etp ON dv.etp_id=etp.etp_id "
                    + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
                    + "JOIN inventario.tipo_eje_adicional tea ON etp.tea_id=tea.tea_id "
                    + "WHERE dv.ven_id="+vta_id+" AND ven.venta_parcial=true "
                    + "GROUP BY dv.dv_id,dv.dv_serial_1,dv.dv_serial_2,cat.cat_nombre,tea.tea_nombre,etp.etp_precio "
                    + "ORDER BY dv.dv_id ASC");
            
            while(obj1.next())
            {
                Object [] datos = new Object[7];
           
                for (int i=0;i<7;i++)
                {
                    datos[i] =obj1.getObject(i+1);
                }
                    modelo.addRow(datos);   
            }     
                    
           tabla_lineaVenta.setModel(modelo);
           nueva.desconectar();
        
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El recibo de venta no existe ó la venta no es parcial");
            }
        
  
        }catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
      }  //Fin del metodo BuscarVentaParcial 
      
        
//        public void obtenerTotalVenta() throws SQLException
//        {
//            String total="";
//            ResultSet obj=nueva.executeQuery("SELECT to_char(pa_monto,'999G999G999G999D99')AS monto FROM ventas.pago WHERE ven_id="+vta_id+"");
//            
//            if(obj.next()==true)
//            {
//              total=obj.getString("monto");
//                
//            }
//             label_total.setText(total);
//             nueva.desconectar();
//                        
//        }  
        
     public void LimpiarTabla()
    {
         
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
     public void actualizarPago()
     {
        try
        {
          long total=0;  
        
         ResultSet obj=nueva.executeQuery("select sum(dv.dv_serial_2 - dv.dv_serial_1 +1)*etp.etp_precio as total from ventas.detalle_venta dv "
                 + "JOIN inventario.especificacion_tiquete_prepago etp "
                 + "ON dv.etp_id=etp.etp_id WHERE dv.ven_id="+vta_id+""
                 + "GROUP BY etp.etp_precio");
 
         while(obj.next())
         {
             total+=obj.getLong("total");
             
         }
         
         nueva.executeUpdateQuery("UPDATE ventas.pago SET pa_monto="+total+" WHERE ven_id="+vta_id+"");
         nueva.desconectar();
         }catch(SQLException e)
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
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total: $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tabla_lineaVenta.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tabla_lineaVenta.getValueAt(i,6)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          
           }
    }
    
    
    
 }