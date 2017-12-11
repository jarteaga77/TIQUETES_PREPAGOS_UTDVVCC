
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reporte.entregaTiqPea.Reporte_remision_boleteria;

/**
 *
 * @author jarteaga
 */
public class JIFImprimirRemisionDePeajes extends javax.swing.JInternalFrame {

    private ConexionBD conexion;
    private DefaultTableModel modelo;
    private Reporte_remision_boleteria reporte;
   
            
    public JIFImprimirRemisionDePeajes() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Peaje");
        modelo.addColumn("Total Recibido");
        
        buscarRemisiones();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_entrega = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_visu = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP - Imprimir Remisión de Peajes");

        tabla_entrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_entrega);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_visu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_visu.setToolTipText("Visualizar");
        btn_visu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_visu)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_visu)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_visuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visuActionPerformed
        int id_rem;
        
         id_rem = (Integer) tabla_entrega.getValueAt(tabla_entrega.getSelectedRow(), 0);
        
         reporte=new Reporte_remision_boleteria();
         reporte.ejecutarReporte(id_rem);
        
    }//GEN-LAST:event_btn_visuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_visu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_entrega;
    // End of variables declaration//GEN-END:variables
     public void buscarRemisiones()
    {
        try
        {
       
            conexion=new ConexionBD();
            ResultSet obj=conexion.executeQuery("SELECT ent.id_en_tiq,ent.fecha_registro,pe.estacion_peaje,SUM(((dv.serial_fin - dv.serial_ini +1)*(etp.etp_precio))) AS total "
                    + "FROM ventas.entrada_tiquetes_peajes ent "
                    + "JOIN ventas.deta_entrega_tiq_peaje dv ON ent.id_en_tiq=dv.id_ent_tiq_pea "
                    + "JOIN dependencias.peajes pe ON pe.codigo_peaje=ent.id_peaje "
                    + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dv.id_etp "
                    + "GROUP BY ent.id_en_tiq,pe.estacion_peaje "
                    + "ORDER BY ent.id_en_tiq");

        while(obj.next())
        {
            Object [] datos = new Object[4];

              for (int i=0;i<4;i++)
               {
                 datos[i] =obj.getObject(i+1);
                }
                modelo.addRow(datos);        
        }
                tabla_entrega.setModel(modelo);
                conexion.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
