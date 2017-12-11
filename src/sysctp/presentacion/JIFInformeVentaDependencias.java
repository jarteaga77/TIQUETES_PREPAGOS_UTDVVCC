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
public class JIFInformeVentaDependencias extends javax.swing.JInternalFrame {

    private ConexionBD nueva=new ConexionBD();
    
    private DefaultTableModel modeloPorFecha;
    private DefaultTableModel modeloConsolidado;
    public JIFInformeVentaDependencias() {
        initComponents();
        
        modeloPorFecha=new DefaultTableModel();
        modeloConsolidado=new DefaultTableModel();
        
        
//       try
//        {
//        ResultSet obj=nueva.executeQuery("SELECT depe_descripcion FROM dependencias.dependencia ORDER BY depe_descripcion ASC ");//Consulta para traer las dependencias
//        
//            while(obj.next())
//            {
//                cb_depen.addItem(obj.getObject("depe_descripcion"));//Llena JCombobox con el nombre del centro de costos
//            } 
//      
//        }catch(SQLException e)
//        {
//         JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
//        }
       
       modeloPorFecha.addColumn("Fecha");
       modeloPorFecha.addColumn("Dependencia");
       modeloPorFecha.addColumn("Cantidad");
       modeloPorFecha.addColumn("Vlor.Unitario");
       modeloPorFecha.addColumn("Total");
       
       modeloConsolidado.addColumn("Dependencia");
       modeloConsolidado.addColumn("Total");

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_por_fechas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date_fecha_final = new com.toedter.calendar.JDateChooser();
        btn_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        date_fecha_ini = new com.toedter.calendar.JDateChooser();
        btn_exportar_xls = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        date_fecha_final1 = new com.toedter.calendar.JDateChooser();
        btn_buscar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        date_fecha_ini1 = new com.toedter.calendar.JDateChooser();
        btn_exportarXLS = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_consolidado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Informe Ventas Dependencias");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setToolTipText("");

        jPanel2.setBorder(null);

        tabla_por_fechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_por_fechas);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fecha Inicial:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha Final:");

        btn_exportar_xls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/xls.png"))); // NOI18N
        btn_exportar_xls.setToolTipText("Exportar a XLS");
        btn_exportar_xls.setContentAreaFilled(false);
        btn_exportar_xls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportar_xlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_exportar_xls, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(date_fecha_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_exportar_xls, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informe por fecha", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Fecha Inicial:");

        btn_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar1.setToolTipText("Buscar");
        btn_buscar1.setContentAreaFilled(false);
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Final:");

        btn_exportarXLS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/xls.png"))); // NOI18N
        btn_exportarXLS.setToolTipText("Exportar a XLS");
        btn_exportarXLS.setContentAreaFilled(false);
        btn_exportarXLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarXLSActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(date_fecha_ini1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_fecha_final1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exportarXLS, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_fecha_final1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(date_fecha_ini1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_exportarXLS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tabla_consolidado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_consolidado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consolidado dependencias", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        int id_item_dep=0;
//        if(cb_item_dep.getSelectedItem()!=null)
//            {
//            try {
//                String item=cb_item_dep.getSelectedItem().toString();
//                ResultSet obj=nueva.executeQuery("SELECT id_item_depen FROM dependencias.item_dependencia WHERE item_depen_descrip='"+item+"'");
//                
//                while(obj.next())
//                {
//                    id_item_dep=obj.getInt("id_item_depen");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
//            }
                
                Date fechaI=date_fecha_ini1.getDate();
                Date fechaF=date_fecha_final1.getDate();
            try {      
                LimPiarJTablaConsolidado();
                consultarConsolidado(fechaI,fechaF);
            } catch (SQLException ex) {
                Logger.getLogger(JIFInformeVentaDependencias.class.getName()).log(Level.SEVERE, null, ex);
            
            }
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Date fechaI=date_fecha_ini.getDate();
        Date fechaF=date_fecha_final.getDate();
        try {
            LimpiarJTablaPorFecha();
            consultarPorFecha(fechaI,fechaF);
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeVentaDependencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_exportar_xlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportar_xlsActionPerformed
           
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
                final String[] headers = {"FECHA", "AREA QUE SOLICITA", "CANTIDAD", "VALOR UNITARIO","VALOR TOTAL"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("INFORME DE VENTAS DEPENDENCIAS");
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
                    for(int fil=1; fil<=tabla_por_fechas.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tabla_por_fechas.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tabla_por_fechas.getValueAt(fil -1 , col)));
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
    }//GEN-LAST:event_btn_exportar_xlsActionPerformed

    private void btn_exportarXLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarXLSActionPerformed
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
                final String[] headers = {"Dependencia","VALOR TOTAL"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("INFORME DE VENTAS DEPENDENCIAS CONSOLIDADO INDIVIDUAL");
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
                    for(int fil=1; fil<=tabla_consolidado.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tabla_consolidado.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tabla_consolidado.getValueAt(fil -1 , col)));
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
    }//GEN-LAST:event_btn_exportarXLSActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton btn_exportarXLS;
    private javax.swing.JButton btn_exportar_xls;
    private com.toedter.calendar.JDateChooser date_fecha_final;
    private com.toedter.calendar.JDateChooser date_fecha_final1;
    private com.toedter.calendar.JDateChooser date_fecha_ini;
    private com.toedter.calendar.JDateChooser date_fecha_ini1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_consolidado;
    private javax.swing.JTable tabla_por_fechas;
    // End of variables declaration//GEN-END:variables
     public void LimpiarJTablaPorFecha()
    {
        for(int i=modeloPorFecha.getRowCount()-1;i>=0;i--)
        {
            modeloPorFecha.removeRow(i);          
        }
    }
     
     public void LimPiarJTablaConsolidado()
     {
          for(int i=modeloConsolidado.getRowCount()-1;i>=0;i--)
        {
            modeloConsolidado.removeRow(i);          
        }
     }
    
    public void consultarPorFecha(Date fechaInicial,Date fechaFinal) throws SQLException
    {
        ConexionBD nuevaCone=new ConexionBD();
        
        ResultSet obj=nuevaCone.executeQuery("SELECT ven.ven_dep_fecha,(de.depe_descripcion ||'-'|| it.item_depen_descrip)AS dependencia,(dvd.dvd_serial_2 -  dvd.dvd_serial_1 + 1) AS cantidad, etp.etp_precio,"
                + "(dvd.dvd_serial_2 -  dvd.dvd_serial_1 + 1)*(etp.etp_precio) AS total "
                + "FROM  ventas.venta_dependencia ven JOIN ventas.detalle_venta_dependencia dvd ON ven.ven_dep_id=dvd.ven_dep_id "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dvd.etp "
                + "JOIN dependencias.item_dependencia it ON it.id_item_depen=ven.item_dependecia "
                + "JOIN dependencias.dependencia de ON de.id_dependencia=it.id_dependencia "
                + "WHERE ven.ven_dep_fecha BETWEEN '"+fechaInicial+"' AND '"+fechaFinal+"' "
                + "ORDER BY ven.ven_dep_id");
    
        while (obj.next()) 
        {
        
            Object [] datos = new Object[5];
        
            for (int i=0;i<5;i++)
            {
                datos[i] =obj.getObject(i+1);
            }

             modeloPorFecha.addRow(datos);
         
        }
            tabla_por_fechas.setModel(modeloPorFecha);
       
         nuevaCone.desconectar();

    }
    
    public void consultarConsolidado(Date fechaInicial,Date fechaFinal) throws SQLException
    {
         
        ConexionBD nuevaCone=new ConexionBD();
        
        ResultSet obj=nuevaCone.executeQuery("SELECT (de.depe_descripcion ||'-'|| it.item_depen_descrip)AS dependencia, SUM(pa.pago_monto)AS total "
                + "FROM ventas.venta_dependencia ven JOIN dependencias.item_dependencia it ON it.id_item_depen=ven.item_dependecia "
                + "JOIN dependencias.dependencia de ON de.id_dependencia=it.id_dependencia "
                + "JOIN ventas.pago_ven_dep pa ON pa.ven_dep_id=ven.ven_dep_id "
                + "WHERE ven.ven_dep_fecha BETWEEN '"+fechaInicial+"'AND '"+fechaFinal+"' "
                + "GROUP BY de.depe_descripcion,it.item_depen_descrip");
    
        while (obj.next()) 
        {
        
            Object [] datos = new Object[2];
        
            for (int i=0;i<2;i++)
            {
                datos[i] =obj.getObject(i+1);
            }

             modeloConsolidado.addRow(datos);
         
        }
            tabla_consolidado.setModel(modeloConsolidado);
       
         nuevaCone.desconectar();

    }
    
    
    
    
    
    
    
    
    
    
    
    
}
