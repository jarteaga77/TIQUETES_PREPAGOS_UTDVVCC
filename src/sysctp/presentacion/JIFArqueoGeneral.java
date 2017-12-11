
package sysctp.presentacion;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.arqueo.general.ArqueoGeneral;
import sysctp.dominio.arqueo.general.Dao_Arqueo_General;
import sysctp.dominio.arqueo.general.TotalArqueoGeneral;
import sysctp.reporte.arqueoGeneral.ReporteArqueoGeneral;
import sysctp.reporte.arqueoGeneral.ReporteArqueoGeneral_2;

/**
 *
 * @author jarteaga
 */
public class JIFArqueoGeneral extends javax.swing.JInternalFrame {

    private ConexionBD conexion;
    private DefaultTableModel modelo;
    private ReporteArqueoGeneral reporte;
    private ReporteArqueoGeneral_2 reporte2;
            
    public JIFArqueoGeneral() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Fecha Arqueo");
        modelo.addColumn("Total Sistema");
        
        buscarArqueosGenerados();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_arqueo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_visu = new javax.swing.JButton();
        btn_generar_Arqueo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP - Arqueo General");

        tabla_arqueo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_arqueo);

        btn_visu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_visu.setToolTipText("Visualizar");
        btn_visu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visuActionPerformed(evt);
            }
        });

        btn_generar_Arqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/aceptar.png"))); // NOI18N
        btn_generar_Arqueo.setToolTipText("Generar Arqueo");
        btn_generar_Arqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_ArqueoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_generar_Arqueo)
                    .addComponent(btn_visu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_generar_Arqueo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_visu)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_visuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visuActionPerformed
        long id_arqueo;
        
         id_arqueo = (Long) tabla_arqueo.getValueAt(tabla_arqueo.getSelectedRow(), 0);
        
        reporte2=new ReporteArqueoGeneral_2();
        reporte2.ejecutarReporte(id_arqueo);
    }//GEN-LAST:event_btn_visuActionPerformed

    private void btn_generar_ArqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_ArqueoActionPerformed
        TotalArqueoGeneral arqueoGeneral=new TotalArqueoGeneral();
        ArqueoGeneral arqueo=new ArqueoGeneral();
        Dao_Arqueo_General daoArqueo=new Dao_Arqueo_General();
        
        int idusuario=MDIPrincipal.getSeccion();
        arqueo.setId_usuario(idusuario);
        arqueo.setFecha_hora(new Date());
        arqueo.setTotal_disponibles(arqueoGeneral.totaDisponibles());
        arqueo.setTotal_anulados(arqueoGeneral.totalAnulados());
        arqueo.setTotal_remisionados(arqueoGeneral.totalRemision());
        arqueo.setTotalSistema(arqueoGeneral.totalSistema());
        arqueo.setTotal_vendidos(arqueoGeneral.totalVendidos());
        arqueo.setTotal_anu_mala_per(arqueoGeneral.total_perforacion());
        arqueo.setTotal_anu_mala_per(arqueoGeneral.total_proveedor());
        arqueo.setTotal_anu_mala_per(arqueoGeneral.total_clientes());
        daoArqueo.registroArqueoGeneral(arqueo);
        
        reporte=new ReporteArqueoGeneral();
        
        reporte.ejecutarReporte();
        buscarArqueosGenerados();
    }//GEN-LAST:event_btn_generar_ArqueoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar_Arqueo;
    private javax.swing.JButton btn_visu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_arqueo;
    // End of variables declaration//GEN-END:variables
     public void buscarArqueosGenerados()
    {
        try
        {
       
            conexion=new ConexionBD();
            ResultSet obj=conexion.executeQuery("SELECT id_arqueo_general,fecha_hora_arqueo,total_sistema FROM controles_arqueos.arqueo_general ORDER BY id_arqueo_general");

        while(obj.next())
        {
            Object [] datos = new Object[3];

              for (int i=0;i<3;i++)
               {
                 datos[i] =obj.getObject(i+1);
                }
                modelo.addRow(datos);        
        }
                tabla_arqueo.setModel(modelo);
                conexion.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
