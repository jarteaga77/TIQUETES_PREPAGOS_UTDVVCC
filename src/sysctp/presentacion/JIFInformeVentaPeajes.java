
package sysctp.presentacion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class JIFInformeVentaPeajes extends javax.swing.JInternalFrame {

    private ConexionBD nueva=new ConexionBD();
    private  DefaultTableModel modelo;
    public JIFInformeVentaPeajes() {
        initComponents();
        
          ResultSet obj=nueva.executeQuery("SELECT estacion_peaje FROM dependencias.peajes ORDER BY estacion_peaje ASC ");
        try {            
            while(obj.next())
            {
                cb_estacion.addItem(obj.getString("estacion_peaje"));
            }
            nueva.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelo=new DefaultTableModel();
               
        modelo.addColumn("Fecha");
        modelo.addColumn("Razon social");
        modelo.addColumn("Nit / C.C");
        modelo.addColumn("Tiquetes Vendidos");
        modelo.addColumn("Descripción");
        modelo.addColumn("Forma de Pago");   
        modelo.addColumn("Cuenta de Debito N°");
        modelo.addColumn("Monto Pagado");
        modelo.addColumn("Recibo de caja N°"); 
        modelo.addColumn("Estación");
        
        
        
        
    }
      public static JTextField gettxtIDEspecificacion() {
        return txt_id_etp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFInformeVentaPeajes.txt_id_etp.setText(String.valueOf(id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date_fecha_Ini = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        date_fecha_fin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cb_estacion = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btn_consulta = new javax.swing.JButton();
        btn_exportar = new javax.swing.JButton();
        txt_id_etp = new javax.swing.JTextField();
        btn_etp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_consulta = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Informe de ventas en peajes");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Generación de informe por fecha y Categoria"));

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final:");

        jLabel3.setText("Estación:");

        jLabel4.setText("Categoria:");

        btn_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_consulta.setContentAreaFilled(false);
        btn_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultaActionPerformed(evt);
            }
        });

        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/xls.png"))); // NOI18N
        btn_exportar.setContentAreaFilled(false);
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });

        btn_etp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_etp.setToolTipText("Especificacion Tiquete");
        btn_etp.setContentAreaFilled(false);
        btn_etp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date_fecha_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_id_etp, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_etp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btn_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_consulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_exportar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txt_id_etp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(date_fecha_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_etp)
                    .addComponent(jLabel1)
                    .addComponent(date_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
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

    private void btn_etpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etpActionPerformed
        JDTablaEspecificacionTPPeajes jdETP=new JDTablaEspecificacionTPPeajes(new javax.swing.JFrame(), true);
        
        jdETP.setLocation(700, 0);
        
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_etpActionPerformed

    private void btn_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultaActionPerformed
       try {
            
            int id_estacion=0;
            LimpiarJTabla();
            
            Date fecha_ini=(Date) date_fecha_Ini.getDate();
            Date fecha_fin=(Date) date_fecha_fin.getDate();
            
            
            if(cb_estacion.getSelectedItem()!=null)
            {
                String estacion=cb_estacion.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT codigo_peaje FROM dependencias.peajes WHERE estacion_peaje='"+estacion+"'");
                 while(obj.next())
                {
                    id_estacion=obj.getInt("codigo_peaje");
                  
                }   
            }
      
             buscarVentas(fecha_ini,fecha_fin,id_estacion,Integer.parseInt(txt_id_etp.getText()));
       } catch (SQLException ex) {
            Logger.getLogger(JIFInformeVentaPeajes.class.getName()).log(Level.SEVERE, null, ex);
       }   
    }//GEN-LAST:event_btn_consultaActionPerformed

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
         //creamos un filtro de archivos para definir que archivos ver en el JFileChooser
        javax.swing.filechooser.FileNameExtensionFilter filterXls = new javax.swing.filechooser.FileNameExtensionFilter("Documentos MS Excel 95/2003", "xls");
 
        //instanciamos una ventana de seleccion de archivo
        final JFileChooser fc = new JFileChooser();
 
        //agregamos el filtro al filechooser
        fc.setFileFilter(filterXls);
 
        //capturamos la respuesta del usuario
        int returnVal = fc.showSaveDialog(null);
 
        //definimos el comportamiento de la ventana
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 
        if (returnVal == JFileChooser.APPROVE_OPTION) {
 
            //@SuppressWarnings("UnusedAssignment")
            FileOutputStream fileOut = null;
           // @SuppressWarnings("UnusedAssignment")
            File fileXLS = null;
            try {
                //Creamos un objeto archivo con la ruta seleccionada
                fileXLS = fc.getSelectedFile();
 
 //Validamos si en la ruta el archivo se ha especificado la extensión
                String name = fileXLS.getName();
                if (name.indexOf('.') == -1) {
       //De no ser asi le agregamos
                    name += ".xls";
                    fileXLS = new File(fileXLS.getParentFile(), name);
                }
                fileOut = new FileOutputStream(fileXLS);
            
                     //Creamos la cabecera
                final String[] headers = {"FECHA", "CLIENTE RAZON SOCIAL", "NIT/C.C", "TIQUETES VENDIDOS","DESCRIPCIÓN", "FORMA DE PAGO","CTA DE AHORROS N°","MONTO PAGADO","RECIBO DE CAJA N°", "ESTACIÓN"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("INFORME DE VENTAS DE CLIENTES EN PEAJES");
                HSSFRow rowhead = sheet.createRow(0);
                
                //Definimos el estilo de la cabecera
                CellStyle headerStyle = wb.createCellStyle();
  //Color de fondo
                headerStyle.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
  //Estilo de la fuente
                Font hfont = wb.createFont();
                hfont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                headerStyle.setFont(hfont);
  //Alineacion Horizontal
                headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
                // Creamos una fila, las filas empiezan en 0
                Row titleRow = sheet.createRow((short) 0);
  //Creamos una celda para nuestra fila
                Cell hCell = titleRow.createCell((short) 0);               

                Row row = sheet.createRow((short) 0);
 /**
  Creamos nuestras celdas de acuerdo a nuestro array headers
  Por cada cabecera creamos una celda y le asignamos el estilo.
 */
                for (int i = 0; i < headers.length; i++) { 
                    Cell cell = row.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(headerStyle);
  //Asigna automaticamente el tamaño
                    sheet.autoSizeColumn(i);
                }
              
//                Obtiene el nombre de cabecera de las columnas      
//                for(int i = 0; i < jt_tabla_orden.getColumnCount(); i++)
//                {
//                 rowhead.createCell(i).setCellValue(jt_tabla_orden.getColumnName(i));
//                }  
                    
                //Cremos la fila y columna que contenga la JTable
                    for(int fil=1; fil<=tabla_consulta.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tabla_consulta.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tabla_consulta.getValueAt(fil -1 , col)));
                        }
                    }
 
                for (int i = 0; i < headers.length; i++) {
                    sheet.autoSizeColumn(i);
                }
// // Escribimos el libro
                
                 wb.write(fileOut);
              
                fileOut.close(); 
                
              
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btn_exportarActionPerformed
        
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consulta;
    private javax.swing.JButton btn_etp;
    private javax.swing.JButton btn_exportar;
    private javax.swing.JComboBox cb_estacion;
    private com.toedter.calendar.JDateChooser date_fecha_Ini;
    private com.toedter.calendar.JDateChooser date_fecha_fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_consulta;
    public static javax.swing.JTextField txt_id_etp;
    // End of variables declaration//GEN-END:variables
public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }
    public void buscarVentas(Date fecha_inicial, Date fecha_final,int id_estacion, int etp) throws SQLException
    {
        ConexionBD nuevaCone=new ConexionBD();
        
        ResultSet obj=nuevaCone.executeQuery("SELECT to_char(ven.ven_fecha_hora,'DD/MM/YYYY')as fecha,clie.sede_descripcion,ven.cli_nit,SUM(dv.dv_serial_2 - dv.dv_serial_1 + 1) AS cantidad,cat.cat_nombre,fp.fp_descripcion,cta.cban_numero,pa.pa_monto,ven.ven_recibo_caja,es.estacion_peaje "
                + "FROM ventas.venta ven JOIN ventas.detalle_venta dv ON ven.ven_id=dv.ven_id JOIN inventario.especificacion_tiquete_prepago etp ON dv.etp_id=etp.etp_id JOIN clientes.sedes_clientes clie ON ven.clie_sede=clie.id_cliente_sede JOIN ventas.pago pa ON ven.ven_id=pa.ven_id JOIN ventas.forma_de_pago fp ON pa.fp_id=fp.fp_id JOIN ventas.cuenta_bancaria cta ON pa.cban_id=cta.cban_id JOIN dependencias.peajes es ON ven.id_estacion=es.codigo_peaje JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id  WHERE ven.ven_fecha_hora BETWEEN '"+fecha_inicial+"' AND '"+fecha_final+"' AND ven.id_estacion="+id_estacion+"  AND etp.etp_id="+txt_id_etp.getText()+"  GROUP BY ven.ven_id,clie.sede_descripcion,cat.cat_nombre,fp.fp_descripcion,pa.pa_monto,cta.cban_numero,es.estacion_peaje ORDER BY ven.ven_recibo_caja ASC");
    
      while (obj.next()) 
        {
        
            Object [] datos = new Object[10];
        
        for (int i=0;i<10;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_consulta.setModel(modelo);
        }
       
         nuevaCone.desconectar();

    }








}
