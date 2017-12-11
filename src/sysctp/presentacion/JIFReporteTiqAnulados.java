
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reporte.TiquetesAnulados.ReporteTiquetesAnulados;

/**
 *
 * @author jarteaga
 */
public class JIFReporteTiqAnulados extends javax.swing.JInternalFrame 
{

    private  DefaultTableModel modelo;
    private ReporteTiquetesAnulados reporte;
    public JIFReporteTiqAnulados() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        
        modelo.addColumn("ID Anulación Tiquete");
        modelo.addColumn("Fecha Anulación");
        modelo.addColumn("Serial Inicial");
        modelo.addColumn("Serial Final");
        modelo.addColumn("Observación");
  
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        date_chooser_final = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_chooser_ini = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        btn_consultar = new javax.swing.JButton();
        btn_pdf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tiquetes_anulados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP- Reporte Tiquetes Anulados");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro por fecha"));

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_consultar.setBorderPainted(false);
        btn_consultar.setContentAreaFilled(false);
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/icono_pdf.png"))); // NOI18N
        btn_pdf.setBorderPainted(false);
        btn_pdf.setContentAreaFilled(false);
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(date_chooser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(date_chooser_final, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date_chooser_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(date_chooser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_consultar)
                    .addComponent(btn_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabla_tiquetes_anulados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_tiquetes_anulados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        LimpiarJTabla();
        
        Date fechaIni=date_chooser_ini.getDate();
        Date fechaFin=date_chooser_final.getDate();
        try {
            consultarTiquesAnulados(fechaIni,fechaFin);
        } catch (SQLException ex) {
            Logger.getLogger(JIFReporteTiqAnulados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
       reporte=new ReporteTiquetesAnulados();
       Date fecha_ini=date_chooser_ini.getDate();
       Date fecha_fin=date_chooser_final.getDate();

       reporte.ejecutarReporte(fecha_ini, fecha_fin);
    }//GEN-LAST:event_btn_pdfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_pdf;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser date_chooser_final;
    private com.toedter.calendar.JDateChooser date_chooser_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_tiquetes_anulados;
    // End of variables declaration//GEN-END:variables

    public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }

public void consultarTiquesAnulados(Date fechaIni, Date fechaFin) throws SQLException
{
    ConexionBD conexion=new ConexionBD();
    
    ResultSet obj=conexion.executeQuery("select anu.id_anulacion_tiquete,anu.fecha_anulacion,danu.da_serial1,danu.da_serial2,anu.observacion "
            + "FROM inventario.anulacion_tiquetes anu JOIN inventario.detalle_anulacion_tiquetes danu "
            + "ON anu.id_anulacion_tiquete=danu.id_anulacion "
            + "WHERE fecha_anulacion BETWEEN '"+fechaIni+"' AND '"+fechaFin+"' ");
     
    while(obj.next())
    {
            
      while (obj.next()) 
        {
        
            Object [] datos = new Object[5];
        
        for (int i=0;i<5;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_tiquetes_anulados.setModel(modelo);
        }
       
         conexion.desconectar();
    }
    
}




}
