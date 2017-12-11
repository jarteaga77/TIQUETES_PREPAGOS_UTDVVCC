
package sysctp.presentacion;

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
import sysctp.dominio.remisionDePeajes.dao_deta_entrega_tiquetes;
import sysctp.dominio.remisionDePeajes.dao_entrega_tiquetes;
import sysctp.dominio.remisionDePeajes.detalle_entrega_tiquetes;
import sysctp.dominio.remisionDePeajes.entrega_tiquetes;
import sysctp.reporte.entregaTiqPea.Reporte_remision_boleteria;

/**
 *
 * @author jarteaga
 */
public class JIFRegEntregaTiqPeajes extends javax.swing.JInternalFrame {

   
    public static MDIPrincipal principal;
    private ConexionBD nuevaCone =new ConexionBD();
    private DefaultTableModel modelo;
    private Reporte_remision_boleteria reporte;
     /*
     * 
     */
    public JIFRegEntregaTiqPeajes() {
           
            initComponents(); 
            
            modelo=new DefaultTableModel();
            
            ResultSet obj=nuevaCone.executeQuery("SELECT estacion_peaje FROM dependencias.peajes ORDER BY estacion_peaje ASC ");
    try {            
           while(obj.next())
            {
                cb_estacion.addItem(obj.getString("estacion_peaje"));
            }
   
             ResultSet obj1=nuevaCone.executeQuery("SELECT MAX(id_en_tiq)+1 as id_entrega FROM ventas.entrada_tiquetes_peajes");
        
            while(obj1.next())
            {
             txt_control.setText(String.valueOf(obj1.getInt("id_entrega")));
            }
             nuevaCone.desconectar();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    
        modelo.addColumn("ID");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Serial Inicial");
        modelo.addColumn("Serial Final");
        modelo.addColumn("Vlor.Unitario");
        modelo.addColumn("Total Parcial");
      
    }
    public static JTextField gettxtIDEspecificacion() {
        return txt_id_esp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFRegEntregaTiqPeajes.txt_id_esp.setText(String.valueOf(id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMonthChooserBeanInfo1 = new com.toedter.calendar.JMonthChooserBeanInfo();
        buttonGroup1 = new javax.swing.ButtonGroup();
        JD_Detalle_Venta = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_serial_1 = new javax.swing.JTextField();
        txt_serial_2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_id_esp = new javax.swing.JTextField();
        btn_Adicionar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        panel_principal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_control = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        date_fecha_remi = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_estacion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txt_remitente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_consecutivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxta_obse = new javax.swing.JTextArea();
        lineasDeVentaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLineaDetalle = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        totalVentaPanel = new javax.swing.JPanel();
        labelTotalVenta = new javax.swing.JLabel();
        controlButtonsPanel = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        JD_Detalle_Venta.setTitle("Linea de Venta");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Serial Inicial:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Serial Final:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("ID Especificación:");

        btn_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_Adicionar.setToolTipText("");
        btn_Adicionar.setContentAreaFilled(false);
        btn_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionarActionPerformed(evt);
            }
        });

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_id_esp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Adicionar))
                    .addComponent(txt_serial_1)
                    .addComponent(txt_serial_2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_id_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Adicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_serial_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serial_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Detalle_VentaLayout = new javax.swing.GroupLayout(JD_Detalle_Venta.getContentPane());
        JD_Detalle_Venta.getContentPane().setLayout(JD_Detalle_VentaLayout);
        JD_Detalle_VentaLayout.setHorizontalGroup(
            JD_Detalle_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_Detalle_VentaLayout.setVerticalGroup(
            JD_Detalle_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Sistema Control Tiquetes Prepago - Registro de Venta");
        setPreferredSize(new java.awt.Dimension(820, 430));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formWindowClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        panel_principal.setPreferredSize(new java.awt.Dimension(500, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Entrega Tiquetes de Peaje"));

        txt_control.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("N° Consecutivo:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Fecha Remisión:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Estación:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Remitente:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Consecutivo Remisión:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Observaciones:");

        jtxta_obse.setColumns(20);
        jtxta_obse.setRows(5);
        jtxta_obse.setText("Ninguna");
        jScrollPane3.setViewportView(jtxta_obse);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_control, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(txt_remitente))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date_fecha_remi, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_remitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txt_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date_fecha_remi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lineasDeVentaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Lineas de Detalle"));
        lineasDeVentaPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setViewportView(tablaLineaDetalle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 649;
        gridBagConstraints.ipady = 139;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lineasDeVentaPanel.add(jScrollPane1, gridBagConstraints);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        lineasDeVentaPanel.add(btnAgregar, gridBagConstraints);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        lineasDeVentaPanel.add(btnEliminar, gridBagConstraints);

        totalVentaPanel.setPreferredSize(new java.awt.Dimension(450, 17));

        labelTotalVenta.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        labelTotalVenta.setText("Valor Total: $ 0,00");

        javax.swing.GroupLayout totalVentaPanelLayout = new javax.swing.GroupLayout(totalVentaPanel);
        totalVentaPanel.setLayout(totalVentaPanelLayout);
        totalVentaPanelLayout.setHorizontalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalVentaPanelLayout.createSequentialGroup()
                .addContainerGap(605, Short.MAX_VALUE)
                .addComponent(labelTotalVenta)
                .addContainerGap())
        );
        totalVentaPanelLayout.setVerticalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalVentaPanelLayout.createSequentialGroup()
                .addComponent(labelTotalVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        lineasDeVentaPanel.add(totalVentaPanel, gridBagConstraints);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlButtonsPanelLayout = new javax.swing.GroupLayout(controlButtonsPanel);
        controlButtonsPanel.setLayout(controlButtonsPanelLayout);
        controlButtonsPanelLayout.setHorizontalGroup(
            controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlButtonsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir)
                .addContainerGap())
        );
        controlButtonsPanelLayout.setVerticalGroup(
            controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlButtonsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)
                    .addComponent(btn_imprimir)))
        );

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlButtonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
            if(tablaLineaDetalle.getRowCount()== 0 && tablaLineaDetalle.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Linea Detalle no tiene items!");    
        }
        else
        {
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        JD_Detalle_Venta.pack();
        JD_Detalle_Venta.setLocationRelativeTo(null);
        JD_Detalle_Venta.setVisible(true);
        JD_Detalle_Venta.setResizable(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
           try
        {
         //ConexionBD nuevaCone=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tablaLineaDetalle.isRowSelected(tablaLineaDetalle.getSelectedRow()))
        {

           int row = tablaLineaDetalle.getSelectedRow();

           nuevaCone.executeUpdateQuery("DELETE FROM ventas.deta_entrega_tiq_peaje WHERE id_det_en_peaje="+modelo.getValueAt(row,0)+" AND id_ent_tiq_pea="+txt_control.getText()+"");
           nuevaCone.executeUpdateQuery("BEGIN;");
           nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 3) +" AND "+modelo.getValueAt(row, 4)+" ");
           this.confirmarTransaccion();
         int numRows = tablaLineaDetalle.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         }
        } else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nuevaCone.desconectar();
          LimpiarTablaDetalle();
          consultaDetalleTabla();
          sumatoriaTotales();

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    }  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        reporte=new Reporte_remision_boleteria();
        reporte.ejecutarReporte(Integer.parseInt(txt_control.getText()));
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);
        jdETP.setLocation(700, 0);
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
       try
       {
            
            entrega_tiquetes entrega=new entrega_tiquetes();
            dao_entrega_tiquetes daoentrega=new dao_entrega_tiquetes();
            detalle_entrega_tiquetes detalle=new detalle_entrega_tiquetes();
            dao_deta_entrega_tiquetes daoDetalle=new dao_deta_entrega_tiquetes();
          
           ResultSet obj=nuevaCone.executeQuery("SELECT id_en_tiq FROM ventas.entrada_tiquetes_peajes WHERE id_en_tiq="+txt_control.getText()+"");
           
           
           if(obj.next()==false)
           {
    
            int id_peaje=0;
            int id_usurio= principal.getSeccion();
             if(cb_estacion.getSelectedItem()!=null)
            {
            
                String peaje=cb_estacion.getSelectedItem().toString();
                ResultSet obj1=nuevaCone.executeQuery("SELECT codigo_peaje FROM dependencias.peajes WHERE estacion_peaje='"+peaje+"'");
                
                while(obj1.next())
                {
                    id_peaje=obj1.getInt("codigo_peaje");
                }
            } 
            

             entrega.setFecha_registro(new Date());
             entrega.setId_peaje(id_peaje);
             entrega.setFecha_remision(date_fecha_remi.getDate());
             entrega.setConsecutivo(txt_consecutivo.getText());
             entrega.setRemitente(txt_remitente.getText());
             entrega.setObser(jtxta_obse.getText());
             entrega.setId_usuario(id_usurio);
             
             daoentrega.reg_entrega_Tiquetes(entrega);
             txt_control.setText(String.valueOf(dao_entrega_tiquetes.getId_entrega()));
             
        
            detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
            detalle.setSerial_ini(Long.parseLong(txt_serial_1.getText()));
            detalle.setSerial_fin(Long.parseLong(txt_serial_2.getText()));
            detalle.setId_entregaTiqPeajes(Integer.parseInt(txt_control.getText()));
        
            daoDetalle.registrarDetalle(detalle);
        
     
            LimpiarTablaDetalle();
            consultaDetalleTabla();
            sumatoriaTotales();
            
        
            txt_serial_1.setText("");
            txt_serial_2.setText("");
            txt_id_esp.setText("");
  
           }else
           {
                detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
                detalle.setSerial_ini(Long.parseLong(txt_serial_1.getText()));
                detalle.setSerial_fin(Long.parseLong(txt_serial_2.getText()));
                detalle.setId_entregaTiqPeajes(Integer.parseInt(txt_control.getText()));
        
                daoDetalle.registrarDetalle(detalle);
     
            LimpiarTablaDetalle();
            consultaDetalleTabla();
            sumatoriaTotales();
       
            
            txt_serial_1.setText("");
            txt_serial_2.setText("");
            txt_id_esp.setText("");
           }

           
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       } 
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Detalle_Venta.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle_Venta;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_estacion;
    private javax.swing.JPanel controlButtonsPanel;
    private com.toedter.calendar.JDateChooser date_fecha_remi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtxta_obse;
    private javax.swing.JLabel labelTotalVenta;
    private javax.swing.JPanel lineasDeVentaPanel;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tablaLineaDetalle;
    private javax.swing.JPanel totalVentaPanel;
    private javax.swing.JTextField txt_consecutivo;
    private javax.swing.JTextField txt_control;
    public static javax.swing.JTextField txt_id_esp;
    private javax.swing.JTextField txt_remitente;
    private javax.swing.JTextField txt_serial_1;
    private javax.swing.JTextField txt_serial_2;
    // End of variables declaration//GEN-END:variables

     public void LimpiarTablaDetalle()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);    
        }
    }

     public void consultaDetalleTabla()
    {
      ConexionBD nuevaCone=new ConexionBD();
      ResultSet obj=nuevaCone.executeQuery("SELECT dv.id_det_en_peaje,(dv.serial_fin - dv.serial_ini +1) as cantidad, (cat.cat_nombre ||'-'||tea.tea_nombre)AS descripcion,dv.serial_ini,dv.serial_fin,etp.etp_precio,((dv.serial_fin - dv.serial_ini +1)*(etp.etp_precio)) AS subtotal FROM ventas.entrada_tiquetes_peajes ent JOIN ventas.deta_entrega_tiq_peaje dv ON ent.id_en_tiq=dv.id_ent_tiq_pea "
              + "JOIN inventario.especificacion_tiquete_prepago etp ON dv.id_etp=etp.etp_id "
              + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
              + "JOIN inventario.tipo_eje_adicional tea ON etp.tea_id=tea.tea_id "
              + "WHERE ent.id_en_tiq="+txt_control.getText()+" "
              + "ORDER BY dv.id_det_en_peaje");
        try {
            while (obj.next()) 
                  {
                  
                    Object [] datos = new Object[7];
                  
               
                    for (int i=0;i<7;i++)
                    {
                      datos[i] =obj.getObject(i+1);
                    }

                        modelo.addRow(datos);

                  }
            tablaLineaDetalle.setModel(modelo);
             nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
  
      public void confirmarTransaccion()
    {
        try
        {
            nuevaCone.executeUpdateQuery("COMMIT;");
            System.out.println("confirmarTransaccion");
            nuevaCone.desconectar();
        }catch(Exception e)

        {
            this.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e + "Se canceló la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
    public void cancelarTransaccion()
    {
        try
        {
            nuevaCone.executeUpdateQuery("ROLLBACK;");
            System.out.println("Pase por cancelar Transaccion");
            nuevaCone.desconectar();

            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
       public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total: $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tablaLineaDetalle.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tablaLineaDetalle.getValueAt(i,6)));
             sum_total+=sumatoria;
   
          labelTotalVenta.setText(formato.format(sum_total));
          
           }
    }
}
