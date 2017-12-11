
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;
import sysctp.reporte.remisionPeaje.ReporteRemisionTiqueteria;

/**
 *
 * @author jarteaga
 */
public class JIFReporteRemisionPeajes extends javax.swing.JInternalFrame {

    private ConexionBD nueva=new ConexionBD();
    private ReporteRemisionTiqueteria reporte;
    
    
    public JIFReporteRemisionPeajes() {
        initComponents();
        
        ResultSet obj=nueva.executeQuery("SELECT estacion_peaje	FROM dependencias.peajes ORDER BY estacion_peaje");
        try {
            while (obj.next())
            {
                cbox_peaje.addItem(obj.getString("estacion_peaje"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFReporteRemisionPeajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        date_fecha_inicial = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        date_fecha_final = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btn_reporte = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_todos = new javax.swing.JButton();
        cbox_peaje = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP-Reporte Remisión a Peajes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final");

        btn_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/icono_pdf.png"))); // NOI18N
        btn_reporte.setToolTipText("Reporte x Fecha");
        btn_reporte.setContentAreaFilled(false);
        btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_todos.setText("Todos");
        btn_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_todosActionPerformed(evt);
            }
        });

        cbox_peaje.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        jLabel3.setText("Peaje:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_todos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(date_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(date_fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbox_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btn_todos)))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
       
        int id_estacion=0;
        reporte=new ReporteRemisionTiqueteria();
        if(cbox_peaje.getSelectedItem()!=null)
            {
            try {
                String estacion=cbox_peaje.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT codigo_peaje FROM dependencias.peajes WHERE estacion_peaje='"+estacion+"'");
                 while(obj.next())
                {
                    id_estacion=obj.getInt("codigo_peaje");
                  
                }

            } catch (SQLException ex) {
                Logger.getLogger(JIFReporteRemisionPeajes.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
              Date fecha_ini=date_fecha_inicial.getDate();
              Date fecha_fin=date_fecha_final.getDate();
             
             reporte.ejecutarReporte(fecha_ini,fecha_fin,id_estacion);
                 
    }//GEN-LAST:event_btn_reporteActionPerformed

    private void btn_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_todosActionPerformed
        reporte=new ReporteRemisionTiqueteria();
        reporte.ejecutarReporteTodosPeajes();
    }//GEN-LAST:event_btn_todosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reporte;
    private javax.swing.JButton btn_todos;
    private javax.swing.JComboBox cbox_peaje;
    private com.toedter.calendar.JDateChooser date_fecha_final;
    private com.toedter.calendar.JDateChooser date_fecha_inicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
