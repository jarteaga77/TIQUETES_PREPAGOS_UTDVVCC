
package sysctp.presentacion;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reporte.devolucionDinero.ReporteDevolucion;

/**
 *
 * @author jarteaga
 */
public class JIFReportDevolucionDinero extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ReporteDevolucion reporte;
    public JIFReportDevolucionDinero() {
        initComponents();
        modelo=new DefaultTableModel();
        
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nit");
        modelo.addColumn("Razón Social");
        modelo.addColumn("Vlor. Consignado");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        date_fecha_1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_fecha_2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btn_reporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consulta = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP- Reporte Devolución de Dinero");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda Por fecha"));

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        jButton1.setToolTipText("Buscar");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_fecha_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_fecha_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabla_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_consulta);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Date fecha_1=date_fecha_1.getDate();
        Date fecha_2=date_fecha_2.getDate();
        LimpiarTablaConsulta();
        consultaReporte(fecha_1,fecha_2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
    
        if(tabla_consulta.isRowSelected(tabla_consulta.getSelectedRow()))
        {
                
            reporte=new ReporteDevolucion();
            int row=tabla_consulta.getSelectedRow();
             reporte.ejecutarReporte((long) modelo.getValueAt(row, 0));
        } else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para generar reporte!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
    }//GEN-LAST:event_btn_reporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reporte;
    private com.toedter.calendar.JDateChooser date_fecha_1;
    private com.toedter.calendar.JDateChooser date_fecha_2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_consulta;
    // End of variables declaration//GEN-END:variables

    public void LimpiarTablaConsulta()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);    
        }
    }
    
    
    public void consultaReporte(Date fecha_1, Date fecha_2)
    {
         try
        {
            ConexionBD conexion=new ConexionBD();
            
            ResultSet obj=conexion.executeQuery("SELECT devo.id_devolucion_dinero, devo.fecha,cli.cli_nit,(cli.cli_razon_social||'-'|| sede.sede_descripcion)AS cliente,"
                    + "to_char(con.vlor_cosnginado,'999G999G999G999D99') "
                    + "FROM ventas.devolucion_dinero devo JOIN ventas.consignacion con ON devo.id_devolucion_dinero=con.id_devolucion "
                    + "JOIN clientes.sedes_clientes sede ON sede.id_cliente_sede=devo.id_sede_cliente "
                    + "JOIN clientes.cliente cli ON cli.cli_nit=sede.cli_nit "
                    + "WHERE devo.fecha between '"+fecha_1+"' AND '"+fecha_2+"'");
            
         while (obj.next()) 
        {
        
        Object [] datos = new Object[5];
        
     
        for (int i=0;i<5;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_consulta.setModel(modelo);
           conexion.desconectar();
 
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }

}
