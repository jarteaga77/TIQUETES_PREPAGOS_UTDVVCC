
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
public class JIFInformeCanExcedente extends javax.swing.JInternalFrame {

    private ConexionBD nueva=new ConexionBD();
    private  DefaultTableModel modelo;
    private  DefaultTableModel modelo2;

    public JIFInformeCanExcedente() {
        initComponents();
        
        modelo=new DefaultTableModel();
        modelo2=new DefaultTableModel();
               
        modelo.addColumn("Fecha");
        modelo.addColumn("Nit / C.C");
        modelo.addColumn("Razón Social");
        modelo.addColumn("Forma de Pago");
        modelo.addColumn("Banco / N° Cuenta");
        modelo.addColumn("Monto Consignado");   
        modelo.addColumn("Recibo de Caja");
        modelo.addColumn("Acta de Cambio N°");
        
        
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Nit / C.C");
        modelo2.addColumn("Razón Social");
        modelo2.addColumn("Forma de Pago");
        modelo2.addColumn("Banco / N° Cuenta");
        modelo2.addColumn("Monto Consignado");   
        modelo2.addColumn("Recibo de Caja");
        modelo2.addColumn("Acta de Cambio N°");
       
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_cliente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        date_choser_ini = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_choser_fin = new com.toedter.calendar.JDateChooser();
        btn_buscar = new javax.swing.JButton();
        btn_exportar_xls = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_clie = new javax.swing.JTable();
        panel_depen = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        date_choser_ini1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date_choser_fin1 = new com.toedter.calendar.JDateChooser();
        btn_buscar1 = new javax.swing.JButton();
        btn_exportar_xls1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_exce_depe = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Informe Cancelación Excedente");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final:");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_exportar_xls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/xls.png"))); // NOI18N
        btn_exportar_xls.setToolTipText("Exportar XLS");
        btn_exportar_xls.setContentAreaFilled(false);
        btn_exportar_xls.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exportar_xls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportar_xlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_choser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_choser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exportar_xls, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_exportar_xls, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(date_choser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(date_choser_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabla_reporte_clie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_reporte_clie.setToolTipText("");
        jScrollPane1.setViewportView(tabla_reporte_clie);

        javax.swing.GroupLayout panel_clienteLayout = new javax.swing.GroupLayout(panel_cliente);
        panel_cliente.setLayout(panel_clienteLayout);
        panel_clienteLayout.setHorizontalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panel_clienteLayout.setVerticalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_clienteLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cancelación Excedente - Clientes", panel_cliente);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        jLabel3.setText("Fecha Inicial:");

        jLabel4.setText("Fecha Final:");

        btn_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        btn_buscar1.setToolTipText("Buscar");
        btn_buscar1.setContentAreaFilled(false);
        btn_buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });

        btn_exportar_xls1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/xls.png"))); // NOI18N
        btn_exportar_xls1.setToolTipText("Exportar XLS");
        btn_exportar_xls1.setContentAreaFilled(false);
        btn_exportar_xls1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exportar_xls1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportar_xls1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_choser_ini1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_choser_fin1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exportar_xls1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_exportar_xls1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(date_choser_fin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(date_choser_ini1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabla_exce_depe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_exce_depe);

        javax.swing.GroupLayout panel_depenLayout = new javax.swing.GroupLayout(panel_depen);
        panel_depen.setLayout(panel_depenLayout);
        panel_depenLayout.setHorizontalGroup(
            panel_depenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        panel_depenLayout.setVerticalGroup(
            panel_depenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_depenLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cancelación Excedente - Dependencias", panel_depen);

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
                final String[] headers = {"FECHA", "NIT/C.C", "RAZÓN SOCIAL","FORMA DE PAGO", "BANCO / N°CUENTA","MONTO PAGADO","RECIBO DE CAJA N°", "ACTA DE CAMBIO N°"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("INFORME DE CANCELACIÓN EXCEDENTES CLIENTES");
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
                    for(int fil=1; fil<=tabla_reporte_clie.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tabla_reporte_clie.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tabla_reporte_clie.getValueAt(fil -1 , col)));
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

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
 
            Date fechaIni=date_choser_ini.getDate();
            Date fechaFin=date_choser_fin.getDate();
            
            LimpiarJTabla();
            
            consultarExcedentesClientes(fechaIni,fechaFin);
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeCanExcedente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
         try {

            Date fechaIni=date_choser_ini1.getDate();
            Date fechaFin=date_choser_fin1.getDate();
            
            LimpiarJTabla2();
            
            consultarExcedentesDependencias(fechaIni,fechaFin);
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeCanExcedente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void btn_exportar_xls1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportar_xls1ActionPerformed
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
                final String[] headers = {"FECHA", "NIT/C.C", "RAZÓN SOCIAL-DEPENDECIA","FORMA DE PAGO", "BANCO / N°CUENTA","MONTO PAGADO","RECIBO DE CAJA N°", "ACTA DE CAMBIO N°"};
                
                
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("INFORME DE CANCELACIÓN EXCEDENTES DEPENDENCIAS");
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
                    for(int fil=1; fil<=tabla_exce_depe.getRowCount(); fil++)
                    {    
                
                        rowhead = sheet.createRow(fil);
                        for(int col=0; col<tabla_exce_depe.getColumnCount(); col++)
                        {
                        rowhead.createCell(col).setCellValue(String.valueOf(tabla_exce_depe.getValueAt(fil -1 , col)));
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
    }//GEN-LAST:event_btn_exportar_xls1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton btn_exportar_xls;
    private javax.swing.JButton btn_exportar_xls1;
    private com.toedter.calendar.JDateChooser date_choser_fin;
    private com.toedter.calendar.JDateChooser date_choser_fin1;
    private com.toedter.calendar.JDateChooser date_choser_ini;
    private com.toedter.calendar.JDateChooser date_choser_ini1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_cliente;
    private javax.swing.JPanel panel_depen;
    private javax.swing.JTable tabla_exce_depe;
    private javax.swing.JTable tabla_reporte_clie;
    // End of variables declaration//GEN-END:variables

    public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    }
    
     public void LimpiarJTabla2()
    {
        for(int i=modelo2.getRowCount()-1;i>=0;i--)
        {
            modelo2.removeRow(i);          
        }
    }
    
    
    public void consultarExcedentesClientes(Date fechaIni, Date fechaFin) throws SQLException
    {
         ResultSet obj=nueva.executeQuery("SELECT acta.fecha,cli.cli_nit,(cli.cli_razon_social ||'-'|| sede.sede_descripcion) AS cliente,fp.fp_descripcion,(cta.cban_banco ||' N° '|| cta.cban_numero) AS banco,exce.pa_monto,exce.recibo_caja,acta.id_acta_consecutivo "
            + "FROM ventas.cambio_tiquete acta JOIN ventas.cancelacion_excedentes exce ON exce.id_acta_cambio=acta.id_acta_consecutivo "
            + "JOIN clientes.sedes_clientes sede ON sede.id_cliente_sede=acta.clie_sede "
            + "JOIN clientes.cliente cli ON cli.cli_nit=sede.cli_nit "
            + "JOIN ventas.forma_de_pago fp ON fp.fp_id=exce.id_fp "
            + "JOIN ventas.cuenta_bancaria cta ON cta.cban_id=exce.cban_id "
            + "WHERE acta.fecha between '"+fechaIni+"' AND '"+fechaFin+"' "
            + "ORDER BY acta.fecha,exce.recibo_caja ASC");
    
        
      while (obj.next()) 
        {
        
            Object [] datos = new Object[8];
        
        for (int i=0;i<8;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_reporte_clie.setModel(modelo);
        }
       
         nueva.desconectar();
    
    
}
    
    
      public void consultarExcedentesDependencias(Date fechaIni, Date fechaFin) throws SQLException
    {
         ResultSet obj=nueva.executeQuery("SELECT acta.fecha,depe.nit_depe,(depe.depe_descripcion ||'-'|| itdepe.item_depen_descrip) AS dependencia,fp.fp_descripcion,(cta.cban_banco ||' N° '|| cta.cban_numero) AS banco,exce.pa_monto, exce.recibo_caja,acta.id_acta_consecutivo "
                 + "FROM ventas.cambio_tiquete_dependencias acta JOIN ventas.cancelacion_excedente_dependencia exce ON exce.id_acta_cambio=acta.id_acta_consecutivo "
                 + "JOIN dependencias.item_dependencia itdepe ON itdepe.id_item_depen=acta.id_dependencia "
                 + "JOIN dependencias.dependencia depe ON depe.id_dependencia=itdepe.id_dependencia "
                 + "JOIN ventas.forma_de_pago fp ON fp.fp_id=exce.id_fp "
                 + "JOIN ventas.cuenta_bancaria cta ON cta.cban_id=exce.cban_id "
                 + "WHERE acta.fecha between '"+fechaIni+"' AND '"+fechaFin+"'"
                 + "ORDER BY acta.fecha");
    
        
      while (obj.next()) 
        {
        
            Object [] datos = new Object[8];
        
        for (int i=0;i<8;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo2.addRow(datos);
         tabla_exce_depe.setModel(modelo2);
        }
       
         nueva.desconectar();
    
    
}





}
