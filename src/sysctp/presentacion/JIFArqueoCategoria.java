
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.arqueo.categoria.Arqueo_Categoria;
import sysctp.dominio.arqueo.categoria.Dao_Arqueo_Categoria;
import sysctp.reporte.arqueo.categorias.dependencias.ArqueoCategoriaDepen;
import sysctp.reporte.arqueo_categoria.ArqueoCategoria;
import sysctp.reporte.consolidadoCat.ConsolidadoCat;
import sysctp.reporte.ventaDepeCat.ArqueoCatVenDepe;

/**
 *
 * @author jarteaga
 */
public class JIFArqueoCategoria extends javax.swing.JInternalFrame {

    
    private ArqueoCategoria reporte;
    private ArqueoCategoriaDepen reporte_depe;
    private ArqueoCatVenDepe ven_depe_cat;
    public static MDIPrincipal principal;
    private long total_venta;
    private ConsolidadoCat cat;
    
   
    public JIFArqueoCategoria() {
        initComponents();
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_generar = new javax.swing.JButton();
        date_fechaIni = new com.toedter.calendar.JDateChooser();
        date_fechaFin = new com.toedter.calendar.JDateChooser();
        cb_cliente = new javax.swing.JRadioButton();
        cb_depe = new javax.swing.JRadioButton();
        rb_ven_cat_dep = new javax.swing.JRadioButton();
        rb_remCat = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP-Arqueo Categorias");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha Inicial:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Fecha Final:");

        btn_generar.setText("Generar");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        buttonGroup1.add(cb_cliente);
        cb_cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_cliente.setSelected(true);
        cb_cliente.setText("Clientes");

        buttonGroup1.add(cb_depe);
        cb_depe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_depe.setText("Dependencias");

        buttonGroup1.add(rb_ven_cat_dep);
        rb_ven_cat_dep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rb_ven_cat_dep.setText("Venta-Cate-Dependencias");

        buttonGroup1.add(rb_remCat);
        rb_remCat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rb_remCat.setText("Remisión por Cat.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_generar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_cliente)
                        .addGap(18, 18, 18)
                        .addComponent(cb_depe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_ven_cat_dep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_remCat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_generar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(date_fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(date_fechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_cliente)
                    .addComponent(cb_depe)
                    .addComponent(rb_ven_cat_dep)
                    .addComponent(rb_remCat))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        
        @SuppressWarnings("static-access")
        int id_usurio= principal.getSeccion();
        Date fechaIni=date_fechaIni.getDate();
        Date fechaFin=date_fechaFin.getDate();
       
        
        if(cb_cliente.isSelected()==true)
        {
       
            Arqueo_Categoria arqueo=new Arqueo_Categoria();
            Dao_Arqueo_Categoria daoArqueo=new Dao_Arqueo_Categoria();
            try {
                    consultaTotal(fechaIni, fechaFin);
            } catch (SQLException ex) {
                    Logger.getLogger(JIFArqueoCategoria.class.getName()).log(Level.SEVERE, null, ex);
             }
        
                arqueo.setId_usuario(id_usurio);
                arqueo.setTotal_venta(total_venta);
                arqueo.setFechaIni(fechaIni);
                arqueo.setFechaFin(fechaFin);
                arqueo.setFecha_arqueo(new Date());
        
                daoArqueo.registroArqueoCategoria(arqueo);
        
                reporte=new ArqueoCategoria();
    
                reporte.ejecutarReporte(fechaIni,fechaFin);
   
       }else
            if(cb_depe.isSelected()==true)
            {
                Arqueo_Categoria arqueo=new Arqueo_Categoria();
            Dao_Arqueo_Categoria daoArqueo=new Dao_Arqueo_Categoria();
            try {
                    consultaTotalDependencias(fechaIni, fechaFin);
            } catch (SQLException ex) {
                    Logger.getLogger(JIFArqueoCategoria.class.getName()).log(Level.SEVERE, null, ex);
             }
        
                arqueo.setId_usuario(id_usurio);
                arqueo.setTotal_venta(total_venta);
                arqueo.setFechaIni(fechaIni);
                arqueo.setFechaFin(fechaFin);
                arqueo.setFecha_arqueo(new Date());
        
                daoArqueo.registroArqueoCategoriaDepe(arqueo);
        
                reporte_depe=new ArqueoCategoriaDepen();
    
                reporte_depe.ejecutarReporte(fechaIni,fechaFin);
                
            }else if(rb_ven_cat_dep.isSelected()==true)
            {
                Arqueo_Categoria arqueo=new Arqueo_Categoria();
                Dao_Arqueo_Categoria daoArqueo=new Dao_Arqueo_Categoria();
                
                
                arqueo.setFechaIni(fechaIni);
                arqueo.setFechaFin(fechaFin);
                arqueo.setFecha_arqueo(new Date());
                arqueo.setId_usuario(id_usurio);
                
                daoArqueo.registoArqVenCatDepe(arqueo);
                
                ven_depe_cat=new ArqueoCatVenDepe();
                ven_depe_cat.ejecutarReporte(fechaIni, fechaFin);
                
            }
        
            else if(rb_remCat.isSelected()==true)
            {
  
                cat=new ConsolidadoCat();
                cat.ejecutarReporte(fechaIni, fechaFin);
            }
    }//GEN-LAST:event_btn_generarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cb_cliente;
    private javax.swing.JRadioButton cb_depe;
    private com.toedter.calendar.JDateChooser date_fechaFin;
    private com.toedter.calendar.JDateChooser date_fechaIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rb_remCat;
    private javax.swing.JRadioButton rb_ven_cat_dep;
    // End of variables declaration//GEN-END:variables

     public void consultaTotal(Date fechaIni, Date fechaFin) throws SQLException
     {
         ConexionBD conexion=new ConexionBD();
         long total=0;
         ResultSet obj=conexion.executeQuery("SELECT (cat.cat_nombre ||'-'|| tea.tea_nombre)AS categoria, SUM((dv.dv_serial_2-dv.dv_serial_1 +1))AS cantidad, SUM((dv.dv_serial_2-dv.dv_serial_1 + 1)*(etp.etp_precio))AS subtotal "
                 + "FROM ventas.detalle_venta dv JOIN ventas.venta ven ON ven.ven_id=dv.ven_id "
                 + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dv.etp_id "
                 + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
                 + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                 + "WHERE ven.ven_fecha_hora between '"+fechaIni+"' AND '"+fechaFin+"' "
                 + "GROUP BY cat.cat_nombre,tea.tea_nombre "
                 + "ORDER BY categoria ASC");
     
         while(obj.next())
         {
             total+=obj.getLong("subtotal");
              System.out.println(total);
             
         }             
          total_venta=total;
     }
     
      public void consultaTotalDependencias(Date fechaIni, Date fechaFin) throws SQLException
     {
         ConexionBD conexion=new ConexionBD();
         long total=0;
         ResultSet obj=conexion.executeQuery("SELECT (cat.cat_nombre ||'-'|| tea.tea_nombre)AS categoria, SUM((dv.dvd_serial_2-dv.dvd_serial_1 +1))AS cantidad, SUM((dv.dvd_serial_2-dv.dvd_serial_1 + 1)*(etp.etp_precio))AS subtotal "
                 + "FROM ventas.detalle_venta_dependencia dv JOIN ventas.venta_dependencia ven ON ven.ven_dep_id=dv.ven_dep_id "
                 + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dv.etp "
                 + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
                 + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                 + "WHERE ven.ven_dep_fecha between '"+fechaIni+"' AND '"+fechaFin+"' "
                 + "GROUP BY cat.cat_nombre,tea.tea_nombre "
                 + "ORDER BY categoria ASC");
     
         while(obj.next())
         {
             total+=obj.getLong("subtotal");
              System.out.println(total);
             
         }             
          total_venta=total;
     }

 }
