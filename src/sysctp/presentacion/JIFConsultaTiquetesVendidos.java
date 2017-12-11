
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class JIFConsultaTiquetesVendidos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
  
    public JIFConsultaTiquetesVendidos() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("Fecha");
        modelo.addColumn("ID Venta/Acta");
        modelo.addColumn("Nit");
        modelo.addColumn("Razon social");
        modelo.addColumn("Rango");
        modelo.addColumn("Descripcion");
  
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_serial_inicial = new javax.swing.JTextField();
        txt_serial_final = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rb_depe = new javax.swing.JRadioButton();
        rb_clientes = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        rb_depe2 = new javax.swing.JRadioButton();
        rb_clientes2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_resumen = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP-Consulta Tiquetes");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta por rango de tiquetes"));
        jPanel1.setToolTipText("");

        jLabel1.setText("Serial Inicial:");

        jLabel2.setText("Serial Inicial:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));

        buttonGroup1.add(rb_depe);
        rb_depe.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        rb_depe.setText("Dependencias");

        buttonGroup1.add(rb_clientes);
        rb_clientes.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        rb_clientes.setSelected(true);
        rb_clientes.setText("Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_clientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_depe)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_clientes)
                    .addComponent(rb_depe)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Actas (Entregados)"));

        buttonGroup1.add(rb_depe2);
        rb_depe2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        rb_depe2.setText("Dependencias");

        buttonGroup1.add(rb_clientes2);
        rb_clientes2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        rb_clientes2.setText("Clientes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_clientes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_depe2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_clientes2)
                    .addComponent(rb_depe2)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txt_serial_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_serial_final, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_serial_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_serial_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_resumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_resumen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        long serial1=Long.parseLong(txt_serial_inicial.getText());
        long serial2=Long.parseLong(txt_serial_final.getText());
   
        if(rb_clientes.isSelected()==true)
        {
            try {
                LimpiarJTabla();
                consultVentaClientes(serial1,serial2);
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaTiquetesVendidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(rb_depe.isSelected()==true)
             {
                 LimpiarJTabla();
            try {
                consultaVentaDependencias(serial1, serial2);
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaTiquetesVendidos.class.getName()).log(Level.SEVERE, null, ex);
            }
             }else if(rb_clientes2.isSelected()==true)
             {
                try {
                consultaActaEntregadosCliente(serial1, serial2);
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaTiquetesVendidos.class.getName()).log(Level.SEVERE, null, ex);
            } 
             }else if(rb_depe2.isSelected()==true)
             {
                 try {
                consultaActaEntregadosDependencias(serial1, serial2);
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaTiquetesVendidos.class.getName()).log(Level.SEVERE, null, ex);
            } 
             }
    }//GEN-LAST:event_btn_buscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_clientes;
    private javax.swing.JRadioButton rb_clientes2;
    private javax.swing.JRadioButton rb_depe;
    private javax.swing.JRadioButton rb_depe2;
    private javax.swing.JTable tabla_resumen;
    private javax.swing.JTextField txt_serial_final;
    private javax.swing.JTextField txt_serial_inicial;
    // End of variables declaration//GEN-END:variables

   public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }

    public void consultVentaClientes(long serial1, long serial2) throws SQLException
    {
        ConexionBD conexion=new ConexionBD();
        
        ResultSet obj=conexion.executeQuery("SELECT ven.ven_fecha_hora,ven.ven_recibo_caja, cli.cli_nit,(cli.cli_razon_social ||'-'||sede.sede_descripcion)AS cliente, (dv.dv_serial_1 ||'-'|| dv.dv_serial_2)AS rango,"
                + "(cat.cat_nombre ||'-'|| tea.tea_nombre ||'año-'|| etp.etp_anio)AS descripcion "
                + "FROM ventas.venta ven JOIN ventas.detalle_venta dv ON  ven.ven_id=dv.ven_id "
                + "JOIN clientes.cliente cli ON ven.cli_nit=cli.cli_nit "
                + "JOIN clientes.sedes_clientes sede ON ven.clie_sede=sede.id_cliente_sede "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dv.etp_id "
                + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
                + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                + "WHERE dv.dv_serial_1<="+serial1+" AND dv.dv_serial_2 >="+serial2+"");
        
        while (obj.next())
        {
          Object [] datos = new Object[6];
        
        for (int i=0;i<6;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_resumen.setModel(modelo);
        }
       
         conexion.desconectar();
        }
    
    
    public void consultaVentaDependencias(long serial1, long serial2) throws SQLException
    {
        ConexionBD conexion=new ConexionBD();
        ResultSet obj=conexion.executeQuery("SELECT ven.ven_dep_fecha,ven.ven_dep_id, depe.nit_depe,(depe.depe_descripcion ||'-'||item.item_depen_descrip)AS dependencia, (dv.dvd_serial_1 ||'-'|| dv.dvd_serial_2)AS rango,"
                + "(cat.cat_nombre ||'-'|| tea.tea_nombre ||'año-'|| etp.etp_anio)AS descripcion "
                + "FROM ventas.venta_dependencia ven JOIN ventas.detalle_venta_dependencia dv ON  ven.ven_dep_id=dv.ven_dep_id "
                + "JOIN dependencias.item_dependencia item ON ven.item_dependecia=item.id_item_depen "
                + "JOIN dependencias.dependencia depe ON depe.id_dependencia=item.id_dependencia "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dv.etp "
                + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
                + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                + "WHERE dv.dvd_serial_1<="+serial1+" AND dv.dvd_serial_2 >="+serial2+"");
        
         while (obj.next())
        {
          Object [] datos = new Object[6];
        
        for (int i=0;i<6;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_resumen.setModel(modelo);
        }
       
         conexion.desconectar();
        
    }
    
    public void consultaActaEntregadosCliente(long serial1, long serial2) throws SQLException
    {
        ConexionBD conexion=new ConexionBD();
        
        ResultSet obj=conexion.executeQuery("SELECT acta.fecha, acta.id_acta_consecutivo,cli.cli_nit,(cli.cli_razon_social ||'-'||sede.sede_descripcion)AS cliente,"
                + "(de.consecutivo_inicial ||'-'||de.consecutivo_final)AS rango, "
                + "(cat.cat_nombre ||''|| tea.tea_nombre ||'año '|| etp.etp_anio)AS descripcion "
                + "FROM ventas.cambio_tiquete acta JOIN ventas.detalle_entregados de ON acta.id_acta_consecutivo=de.id_actacambio "
                + "JOIN clientes.sedes_clientes sede ON sede.id_cliente_sede=acta.clie_sede "
                + "JOIN clientes.cliente cli ON cli.cli_nit=sede.cli_nit "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=de.id_esp_tiquete "
                + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
                + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                + "WHERE de.consecutivo_inicial<="+serial1+" AND de.consecutivo_final >="+serial2+"");
    
          while (obj.next())
        {
          Object [] datos = new Object[6];
        
        for (int i=0;i<6;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_resumen.setModel(modelo);
        }
       
         conexion.desconectar();
    
    }
    
    public void consultaActaEntregadosDependencias(long serial1, long serial2) throws SQLException
    {
        ConexionBD conexion=new ConexionBD();
        
        ResultSet obj=conexion.executeQuery("SELECT acta.fecha, acta.id_acta_consecutivo,depe.nit_depe,(depe.depe_descripcion ||'-'||item.item_depen_descrip)AS dependencia,"
                + "(de.consecutivo_inicial ||'-'||de.consecutivo_final)AS rango, "
                + "(cat.cat_nombre ||''|| tea.tea_nombre ||'año '|| etp.etp_anio)AS descripcion "
                + "FROM ventas.cambio_tiquete_dependencias acta JOIN ventas.detalle_entregados_dependencia de ON acta.id_acta_consecutivo=de.id_actacambio "
                + "JOIN dependencias.item_dependencia item ON acta.id_dependencia=item.id_item_depen "
                + "JOIN dependencias.dependencia depe ON depe.id_dependencia=item.id_dependencia "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=de.id_esp_tiquete "
                + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                + "WHERE de.consecutivo_inicial<="+serial1+" AND de.consecutivo_final >="+serial2+"");
    
          while (obj.next())
        {
          Object [] datos = new Object[6];
        
        for (int i=0;i<6;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_resumen.setModel(modelo);
        }
       
         conexion.desconectar();
    
    }
    
 
 }





