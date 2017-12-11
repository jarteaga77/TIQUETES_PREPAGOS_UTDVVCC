
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.remisionTiqueteria.DaoDetalle_remision;
import sysctp.dominio.remisionTiqueteria.DaoRemisionTiqueteria;
import sysctp.dominio.remisionTiqueteria.Detalle_remision;
import sysctp.dominio.remisionTiqueteria.RemisionTiqueteriaPeajes;
import sysctp.reporte.remisionTiqueteriaPeajes.Reporte_remision_de_peajes;

/**
 *
 * @author jarteaga
 */
public class JIFRemisionTiqueteria extends javax.swing.JInternalFrame {

    public static MDIPrincipal principal;
    private ConexionBD nueva=new ConexionBD();
    private DefaultTableModel modelo;
    private Reporte_remision_de_peajes reporte;
   

    public JIFRemisionTiqueteria() {
        initComponents();
        modelo= new DefaultTableModel();
  
         //Consulta para traer el ultimo registro de y sumarle 1 
       ResultSet obj=nueva.executeQuery("SELECT MAX(id_remision_peaje)+1 as id_remision FROM ventas.remision_peaje");
        try {
            while(obj.next())
            {
                txt_remision.setText(String.valueOf(obj.getLong("id_remision")));//Le asigna el consecutivo siguiente de orden compra al textfield
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.desconectar();
        
           //Modelo predeterminado de JTable
         modelo.addColumn("ID");
         modelo.addColumn("Descripción");
         modelo.addColumn("Serial Inicial");
         modelo.addColumn("Serial Final");
         modelo.addColumn("Cantidad");
         modelo.addColumn("Vlor. Unitario");

    }

         public static JTextField gettxtIDEspecificacion() {
        return txt_idetp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFRemisionTiqueteria.txt_idetp.setText(String.valueOf(id));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_Detalle_remision = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_idetp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_serial1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_serial2 = new javax.swing.JTextField();
        btn_guardardetalle = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_etp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_peaje = new javax.swing.JTextField();
        cb_peaje = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_obse = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txt_remision = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        btn_adicionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        JD_Detalle_remision.setTitle("Detalle Remisión Tiqueteria");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("ID Especificación");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Serial Inicial:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Serial Final:");

        btn_guardardetalle.setText("Aceptar");
        btn_guardardetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardardetalleActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_etp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_etp.setToolTipText("ID Categoria Tiquete");
        btn_etp.setContentAreaFilled(false);
        btn_etp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(263, 263, 263)
                            .addComponent(btn_etp))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(btn_guardardetalle)
                            .addGap(18, 18, 18)
                            .addComponent(btn_cancelar)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idetp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(44, 44, 44)
                            .addComponent(txt_serial1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(51, 51, 51)
                            .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_idetp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_etp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardardetalle)
                    .addComponent(btn_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Detalle_remisionLayout = new javax.swing.GroupLayout(JD_Detalle_remision.getContentPane());
        JD_Detalle_remision.getContentPane().setLayout(JD_Detalle_remisionLayout);
        JD_Detalle_remisionLayout.setHorizontalGroup(
            JD_Detalle_remisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_remisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_Detalle_remisionLayout.setVerticalGroup(
            JD_Detalle_remisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_remisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP - Remision de Tiqueteria a peajes");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Peaje:");

        txt_peaje.setToolTipText("ej:Inicial del peaje + shift");
        txt_peaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_peajeKeyReleased(evt);
            }
        });

        cb_peaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_peajeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Observación:");

        txtarea_obse.setColumns(20);
        txtarea_obse.setRows(5);
        jScrollPane1.setViewportView(txtarea_obse);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Remisión Boleteria N°:");

        txt_remision.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(cb_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_peaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_detalle);

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar.setToolTipText("Adicionar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total Remisión $ 0,0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_adicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_total)
                .addGap(119, 119, 119))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(label_total))
        );

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_imprimir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_imprimir))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
          JD_Detalle_remision.pack();
          JD_Detalle_remision.setLocationRelativeTo(null);
          JD_Detalle_remision.setVisible(true);
          JD_Detalle_remision.setResizable(false);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_etpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etpActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);     
        jdETP.setLocation(700, 0);      
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_etpActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        dispose();
        nueva.desconectar();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void txt_peajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_peajeKeyReleased
        
         if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
        try {
                cb_peaje.removeAllItems();
                 buscarPeaje();
            }
         catch (SQLException ex) {
            Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }  
    }//GEN-LAST:event_txt_peajeKeyReleased

    private void cb_peajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_peajeActionPerformed
        if(cb_peaje.getSelectedItem()!=null)
            {
                long cod_peaje;
             
            try {
                String nombre=cb_peaje.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT codigo_peaje FROM dependencias.peajes WHERE estacion_peaje='"+nombre+"'");
                
                while(obj.next())
                {
                    cod_peaje=obj.getLong("codigo_peaje");
                    txt_peaje.setText("");
                    txt_peaje.setText(String.valueOf(cod_peaje));
                }
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_peajeActionPerformed

    private void btn_guardardetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardardetalleActionPerformed
  
        try
        {
            RemisionTiqueteriaPeajes remision=new RemisionTiqueteriaPeajes();
            DaoRemisionTiqueteria daoremision=new DaoRemisionTiqueteria();
                
            Detalle_remision detalle_remision=new Detalle_remision();
            DaoDetalle_remision daodetalle=new DaoDetalle_remision();
            
            
            ResultSet obj=nueva.executeQuery("SELECT id_remision_peaje FROM ventas.remision_peaje WHERE id_remision_peaje="+txt_remision.getText()+" ");
            
            if(obj.next()==false)
            {
 
                if(txt_peaje.getText().matches("[0-9]*"))
                {
                   int id_usuario= principal.getSeccion();       
                   remision.setFecha_remision(new Date());
                   remision.setObservacion(txtarea_obse.getText());
                   remision.setId_usuario(id_usuario);
                   remision.setId_peaje(Integer.parseInt(txt_peaje.getText()));
        
                   daoremision.registroRemision(remision);
                   txt_remision.setText(String.valueOf(daoremision.getId_remision()));
                   
                  detalle_remision.setSerial_inicial(Long.parseLong(txt_serial1.getText()));
                  detalle_remision.setSerial_final(Long.parseLong(txt_serial2.getText()));
                  detalle_remision.setEspeTiquetePrepago(Integer.parseInt(txt_idetp.getText()));
                  detalle_remision.setId_remision(Long.parseLong(txt_remision.getText()));
            
                  daodetalle.registroDetalleRemision(detalle_remision);
       
                   LimpiarTabla();
                   detalleTabla();
                   sumatoriaTotales();
                   
                  txt_idetp.setText("");
                  txt_serial1.setText("");
                  txt_serial2.setText("");
   
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El ID del peaje es un dato numérico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
 
            }else
            {
                
                  detalle_remision.setSerial_inicial(Long.parseLong(txt_serial1.getText()));
                  detalle_remision.setSerial_final(Long.parseLong(txt_serial2.getText()));
                  detalle_remision.setEspeTiquetePrepago(Integer.parseInt(txt_idetp.getText()));
                  detalle_remision.setId_remision(Long.parseLong(txt_remision.getText()));
            
                  daodetalle.registroDetalleRemision(detalle_remision);
                  
                  LimpiarTabla();
                  detalleTabla();
                  sumatoriaTotales();
                  
                  txt_idetp.setText("");
                  txt_serial1.setText("");
                  txt_serial2.setText("");
            
            }
  
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

            
           // JD_Detalle_remision.dispose();
 
    }//GEN-LAST:event_btn_guardardetalleActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            eliminarDetalle();
            sumatoriaTotales();
            LimpiarTabla();
            detalleTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
         
        reporte=new Reporte_remision_de_peajes();
        long  id_remision = Long.parseLong(txt_remision.getText());
        reporte.ejecutarReporte(id_remision);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Detalle_remision.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle_remision;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_etp;
    private javax.swing.JButton btn_guardardetalle;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JComboBox cb_peaje;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_detalle;
    public static javax.swing.JTextField txt_idetp;
    private javax.swing.JTextField txt_peaje;
    private javax.swing.JTextField txt_remision;
    private javax.swing.JTextField txt_serial1;
    private javax.swing.JTextField txt_serial2;
    private javax.swing.JTextArea txtarea_obse;
    // End of variables declaration//GEN-END:variables

      public void buscarPeaje() throws SQLException
    {
 
            ResultSet obj=nueva.executeQuery("SELECT estacion_peaje FROM dependencias.peajes WHERE estacion_peaje like '%"+txt_peaje.getText().toUpperCase()+"%'ORDER BY estacion_peaje ASC");
            
            while(obj.next())
            {
                cb_peaje.addItem(obj.getObject("estacion_peaje"));
            }
            nueva.desconectar();

    }
       public void detalleTabla()
    {
   
        try
        {
            ResultSet obj=nueva.executeQuery("SELECT dr.id_det_remision, cat.cat_nombre || '+' || tea.tea_nombre AS descripcion, dr.dr_serial1, dr.dr_serial2, SUM(dr.dr_serial2-dr.dr_serial1 + 1) AS cantidad, etp.etp_precio "
                    + "FROM ventas.detalle_remision dr JOIN ventas.remision_peaje rem ON dr.id_remision=rem.id_remision_peaje "
                    + "JOIN inventario.especificacion_tiquete_prepago etp ON dr.id_etp=etp.etp_id "
                    + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
                    + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
                    + "WHERE id_remision="+txt_remision.getText()+""
                    + "GROUP BY dr.id_det_remision,cat.cat_nombre,tea.tea_nombre,dr.dr_serial1, dr.dr_serial2,etp.etp_precio "
                    + "ORDER BY dr.id_det_remision ASC");
            
         while (obj.next()) 
        {
        
        Object [] datos = new Object[6];
        
     
        for (int i=0;i<6;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_detalle.setModel(modelo);
           nueva.desconectar();
 
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
          //Limpia la tabla de Detalle orden, remueve cada item
    public void LimpiarTabla()
    {
        
   
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
     public void eliminarDetalle()
    {
        
    try
    {
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_detalle.isRowSelected(tabla_detalle.getSelectedRow()))
        {

           int row = tabla_detalle.getSelectedRow();

      
           nueva.executeUpdateQuery("DELETE FROM ventas.detalle_remision WHERE id_det_remsion="+modelo.getValueAt(row,0)+" AND id_remision="+txt_remision.getText()+"");
           nueva.executeUpdateQuery("BEGIN;");
           nueva.executeUpdateQuery("UPDATE inventario.consecutivos set conse_estado=true WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 2) +" AND "+modelo.getValueAt(row, 3) +"");
           this.confirmarTransaccion();
        
         int numRows = tabla_detalle.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         }
        }
       else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nueva.desconectar();
        

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    }


    }
     
//     public void totalRemision() throws SQLException
//     {
//         long total_remision=0;
//         ResultSet obj=nueva.executeQuery("SELECT SUM(dr.dr_serial2 - dr.dr_serial1 +1)* etp.etp_precio AS total FROM ventas.detalle_remision dr JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dr.id_etp WHERE dr.id_remision="+txt_remision.getText()+" GROUP BY etp.etp_precio");
//            while(obj.next())
//            {
//                total_remision+=obj.getLong("total");
//            }
//            nueva.executeUpdateQuery("UPDATE ventas.remision_peaje SET total_remision="+total_remision+" WHERE id_remision_peaje="+txt_remision.getText()+"");
//            nueva.desconectar();
//     }

         public void confirmarTransaccion()
        {
        try
        {
            nueva.executeUpdateQuery("COMMIT;");
        
            System.out.println("Pase por aqui");
            nueva.desconectar();

        }catch(Exception e)

        {
            this.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e + "Error al confirmar la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
        }
    
    public void cancelarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("ROLLBACK;");
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
     public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total Remisión $' #,##0.00",dfs);
        long total_remision=0;
        
        ResultSet obj=nueva.executeQuery("SELECT SUM(dr.dr_serial2 - dr.dr_serial1 +1)* etp.etp_precio AS total FROM ventas.detalle_remision dr JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dr.id_etp WHERE dr.id_remision="+txt_remision.getText()+" GROUP BY etp.etp_precio");
        try {
            while(obj.next())
            {
                total_remision+=obj.getLong("total");
                label_total.setText(formato.format(total_remision));
            }
            
               nueva.executeUpdateQuery("UPDATE ventas.remision_peaje SET total_remision="+total_remision+" WHERE id_remision_peaje="+txt_remision.getText()+"");

            
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        int sum_total = 0;
//        int totalRow= tabla_detalle.getRowCount();
//        totalRow-=1; 
//        for(int i=0;i<=(totalRow);i++)
//        {
//             int sumatoria= Integer.parseInt(String.valueOf(tabla_detalle.getValueAt(i,5)));
//             sum_total+=sumatoria;
//   
//          
//          
//           }
        
        //nueva.desconectar();
    }

}
