
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reporte.excedenteDependencia.Reporte_Excedentes_Depe;

/**
 *
 * @author jarteaga
 */
public class JIFReciboExcedenteDepe extends javax.swing.JInternalFrame {

   private Reporte_Excedentes_Depe reporte;
   private ConexionBD conexion=new ConexionBD();
   private DefaultTableModel modelo;
    public JIFReciboExcedenteDepe() {
        initComponents();
        
        modelo= new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Acta N°");
        modelo.addColumn("Dependencia");
        modelo.addColumn("Monto Pagado");
        
        
        
        ResultSet obj=conexion.executeQuery("SELECT ex.id_can_exce,acta.fecha,id_acta_cambio,(depe.depe_descripcion ||'-'||item.item_depen_descrip)AS dependencia,ex.pa_monto "
                + "FROM ventas.cancelacion_excedente_dependencia ex JOIN ventas.cambio_tiquete_dependencias acta ON ex.id_acta_cambio=acta.id_acta_consecutivo "
                + "JOIN dependencias.item_dependencia item  ON item.id_item_depen=acta.id_dependencia "
                + "JOIN dependencias.dependencia depe ON depe.id_dependencia=item.id_dependencia "
                + "ORDER BY ex.id_can_exce ASC");
       try {
         
             while(obj.next())
           {
               Object [] datos = new Object[5];

                for (int i=0;i<5;i++)
                {
                 datos[i] =obj.getObject(i+1);
                }
                modelo.addRow(datos);        
           }
                tabla_excedente.setModel(modelo); 
                conexion.desconectar();
           
       } catch (SQLException ex) {
           Logger.getLogger(JIFReciboExcedenteDepe.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_generar_recibo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_excedente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP - Excedente - Dependencia");
        setToolTipText("");

        jB_generar_recibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        jB_generar_recibo.setContentAreaFilled(false);
        jB_generar_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_generar_reciboActionPerformed(evt);
            }
        });

        tabla_excedente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_excedente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_generar_recibo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_generar_recibo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_generar_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_generar_reciboActionPerformed
//        Long recibo =Long.parseLong( txt_recibo.getText());
//        jasper.ejecutarReporte(recibo);
//        dispose();
        
         long id;
        
         id = (Long) tabla_excedente.getValueAt(tabla_excedente.getSelectedRow(), 0);
        
        reporte=new Reporte_Excedentes_Depe();
        reporte.ejecutarReporte(id);
        
    }//GEN-LAST:event_jB_generar_reciboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_generar_recibo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_excedente;
    // End of variables declaration//GEN-END:variables
}
