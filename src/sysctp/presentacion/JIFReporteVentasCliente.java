
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reportes.venta.Clientes.ReporteVentasxCliente;

/**
 *
 * @author jarteaga
 */
public class JIFReporteVentasCliente extends javax.swing.JInternalFrame {

   private ConexionBD nueva=new ConexionBD();
   private DefaultTableModel modelo;
   private ReporteVentasxCliente reporte;
    public JIFReporteVentasCliente() {
        
    modelo=new DefaultTableModel();
    
    modelo.addColumn("Fecha");
    modelo.addColumn("Cliente Nit");
    modelo.addColumn("Razón Social");
    modelo.addColumn("Recibo de Caja");
    modelo.addColumn("Serial Inicial");
    modelo.addColumn("Serial Final");
    modelo.addColumn("Descripción");
    modelo.addColumn("Vlor. Unitario");
    modelo.addColumn("Subtotal");
    modelo.addColumn("Forma de Pago");
    modelo.addColumn("Banco/N°Cuenta");
    modelo.addColumn("Total");

        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox();
        btn_buscar = new javax.swing.JButton();
        btn_reporte = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        date_choser_ini = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        date_choser_fin = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reporte Venta Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoClienteKeyReleased(evt);
            }
        });

        jLabel1.setText("Cliente:");

        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/icono_pdf.png"))); // NOI18N
        btn_reporte.setToolTipText("Generar Reporte");
        btn_reporte.setContentAreaFilled(false);
        btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteActionPerformed(evt);
            }
        });

        jLabel2.setText("Entre:");

        jLabel3.setText("Hasta:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(date_choser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_choser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(date_choser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date_choser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabla_reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_reporte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
         
        long nit=0;
        
        LimpiarJTabla();
        if(cb_cliente.getSelectedItem()!=null)
            {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
            try {
                while(obj.next())
               {
                   nit=obj.getLong("id_cliente_sede");
               }
                Date fechaIni=date_choser_ini.getDate();
                Date fechaFin=date_choser_fin.getDate();
                consultarVentaCliente(fechaIni, fechaFin, nit);
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFReporteVentasCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            }   
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txtCodigoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoClienteKeyReleased
          if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                cb_cliente.removeAllItems();
                buscarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodigoClienteKeyReleased

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
        Date fechaIni=date_choser_ini.getDate();
        Date fechaFin=date_choser_fin.getDate();
        reporte=new ReporteVentasxCliente();
        long nit=0;
         if(cb_cliente.getSelectedItem()!=null)
            {
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
          
                while(obj.next())
               {
                   nit=obj.getLong("id_cliente_sede");
               }
                
                reporte.ejecutarReporte(fechaIni, fechaFin, nit);
                nueva.desconectar();
                
            } catch (SQLException ex) {
                Logger.getLogger(JIFReporteVentasCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            }
    }//GEN-LAST:event_btn_reporteActionPerformed

    private void cb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteActionPerformed
             if(cb_cliente.getSelectedItem()!=null)
            {
                long nit;
                
                
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT cli_nit FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                
                while(obj.next())
                {
                    nit=obj.getLong("cli_nit");
                    txtCodigoCliente.setText("");
                    txtCodigoCliente.setText(String.valueOf(nit));
                }
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_clienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_reporte;
    private javax.swing.JComboBox cb_cliente;
    private com.toedter.calendar.JDateChooser date_choser_fin;
    private com.toedter.calendar.JDateChooser date_choser_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_reporte;
    private javax.swing.JTextField txtCodigoCliente;
    // End of variables declaration//GEN-END:variables

  public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }
    
     public void buscarCliente() throws SQLException
    {
  
            ResultSet obj=nueva.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion ilike '%"+txtCodigoCliente.getText().toUpperCase()+"%' ORDER BY sede_descripcion");
            
            while(obj.next())
            {
                cb_cliente.addItem(obj.getObject("sede_descripcion"));
            }
            
            nueva.desconectar();

    } 
    public void consultarVentaCliente(Date fechaIni, Date fechaFin,long nit) throws SQLException
{
    ResultSet obj=nueva.executeQuery("SELECT ven.ven_fecha_hora, ven.cli_nit,(cli.cli_razon_social ||''|| sede.sede_descripcion)AS cliente,ven.ven_recibo_caja,dv.dv_serial_1,dv.dv_serial_2,"
            + "(cat.cat_nombre ||'-'|| tea.tea_nombre ||' año: ' || etp.etp_anio)AS descripcion,to_char(etp.etp_precio,'999G999G999G999D99')AS vlorUnitario,"
            + "to_char((dv.dv_serial_2-dv.dv_serial_1 + 1)*(etp.etp_precio),'999G999G999G999D99')AS subtotal,fp.fp_descripcion,(cta.cban_banco ||'-'||cta.cban_numero)AS banco,to_char(SUM(pa_monto),'999G999G999G999D99')AS monto "
            + "FROM ventas.venta ven JOIN ventas.detalle_venta dv ON ven.ven_id=dv.ven_id "
            + "JOIN clientes.cliente cli ON ven.cli_nit=cli.cli_nit "
            + "JOIN clientes.sedes_clientes sede ON ven.clie_sede=sede.id_cliente_sede "
            + "JOIN inventario.especificacion_tiquete_prepago etp ON dv.etp_id=etp.etp_id "
            + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
            + "JOIN ventas.pago pa ON pa.ven_id=ven.ven_id "
            + "JOIN ventas.forma_de_pago fp ON fp.fp_id=pa.fp_id JOIN ventas.cuenta_bancaria cta ON cta.cban_id=pa.cban_id "
            + "WHERE ven.clie_sede="+nit+" AND ven_fecha_hora between '"+fechaIni+"' AND '"+fechaFin+"'"
            + "GROUP BY ven.ven_fecha_hora,ven.cli_nit,cli.cli_razon_social,sede.sede_descripcion,ven.ven_recibo_caja,dv.dv_serial_1,"
            + "dv.dv_serial_2,cat.cat_nombre,tea.tea_nombre,etp.etp_anio,etp.etp_precio,fp.fp_descripcion,cta.cban_banco,cta.cban_numero "
            + "ORDER BY ven.ven_fecha_hora ASC");
    
     while (obj.next()) 
        {
        
            Object [] datos = new Object[12];
        
        for (int i=0;i<12;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_reporte.setModel(modelo);
        }
       
         nueva.desconectar();

}

}
