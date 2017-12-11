
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sysctp.aplicacion.ControladorRegistroDeVentas;
import sysctp.conexion.ConexionBD;          
import sysctp.dominio.Empresa;
import sysctp.dominio.ventas.IObservadorVenta;
import sysctp.dominio.ventas.LineaDeVenta;
import sysctp.dominio.ventas.Pago;
import sysctp.dominio.ventas.Venta;
import sysctp.reportes.venta.ReporteVenta;

/**
 *
 * @author jarteaga
 */
public class JIFRegistroVenta extends javax.swing.JInternalFrame {

    private ControladorRegistroDeVentas controlador;
    private TableModelVenta ventaTableModel = new TableModelVenta();
    private TableModelPagosVenta pagosTableModel = new TableModelPagosVenta();
    private JIFRegistroVenta registroVenta;
    private ReporteVenta reporte;
    
    
    private static long total;
    private long totalVenta;
    public static MDIPrincipal principal;
    private ConexionBD nuevaCone =new ConexionBD();
    
     /** Creates new form JFRegistrarVenta
     * @param empresa 
     */
    public JIFRegistroVenta(Empresa empresa) {
            this.controlador = new ControladorRegistroDeVentas(
                empresa.getRegistroDeVentas(),
                empresa.getCatalogoTiquetesPrepago(),
                empresa.getCatalogoFormasDePago(),
                empresa.getRegistroDeClientes(),
                empresa.getCatalogoCuentasBancarias()
        
        );  
           
            initComponents(); 
            
            ResultSet obj=nuevaCone.executeQuery("SELECT estacion_peaje FROM dependencias.peajes ORDER BY estacion_peaje ASC ");
        try {            
            while(obj.next())
            {
                cb_estacion.addItem(obj.getString("estacion_peaje"));
            }
            nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    /**
     * 
     * @param fuente
     */
    
    public void onVentaModificaTotalVenta(Venta fuente){
        totalVenta = fuente.obtenerTotalVenta();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Valor Total: $' #,##0.00",dfs);
        labelTotalVenta.setText(formato.format(totalVenta));
       
   }
    
    public static long getttotal()
    {
        return JIFRegistroVenta.total;
    }
 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMonthChooserBeanInfo1 = new com.toedter.calendar.JMonthChooserBeanInfo();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        panel_principal = new javax.swing.JPanel();
        clientePanel = new javax.swing.JPanel();
        checkCliente = new javax.swing.JCheckBox();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cb_estacion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxta_obse = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        controlButtonsPanel = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_recibo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pagos = new javax.swing.JPanel();
        checkPago = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePagosVenta = new javax.swing.JTable();
        btnAdicionarPago = new javax.swing.JButton();
        btnEliminarPago = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_sobrante = new javax.swing.JTextField();
        lineasDeVentaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLineasVenta = new javax.swing.JTable();
        btnSubir = new javax.swing.JButton();
        btnBajar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        totalVentaPanel = new javax.swing.JPanel();
        labelTotalVenta = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cb_venta_total = new javax.swing.JCheckBox();
        cb_venta_parcial = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Sistema Control Tiquetes Prepago - Registro de Venta");
        setPreferredSize(new java.awt.Dimension(850, 897));
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

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setAutoscrolls(true);

        clientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estación - Cliente"));

        checkCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        checkCliente.setSelected(true);
        checkCliente.setText("NIT o Cédula:");

        txtCodigoCliente.setToolTipText("iniciles del cliente + shift");
        txtCodigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoClienteKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Cliente:");

        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Estación:");

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkCliente)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_estacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtxta_obse.setColumns(20);
        jtxta_obse.setRows(5);
        jtxta_obse.setText("Ninguna");
        jScrollPane3.setViewportView(jtxta_obse);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Observaciones:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
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
                .addContainerGap(487, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(controlButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(controlButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Venta"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("N° Recibo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pagos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagos"));

        checkPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkPago.setSelected(true);
        checkPago.setText("El valor de la venta está completo");

        tablePagosVenta.setModel(pagosTableModel);
        jScrollPane2.setViewportView(tablePagosVenta);

        btnAdicionarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btnAdicionarPago.setToolTipText("Adicionar Pago");
        btnAdicionarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPagoActionPerformed(evt);
            }
        });

        btnEliminarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btnEliminarPago.setToolTipText("Eliminar Pago");
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Sobrante a Favor UTD:$");

        txt_sobrante.setText("0");

        javax.swing.GroupLayout pagosLayout = new javax.swing.GroupLayout(pagos);
        pagos.setLayout(pagosLayout);
        pagosLayout.setHorizontalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarPago)
                            .addComponent(btnEliminarPago)))
                    .addGroup(pagosLayout.createSequentialGroup()
                        .addComponent(checkPago)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_sobrante, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pagosLayout.setVerticalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagosLayout.createSequentialGroup()
                        .addComponent(btnAdicionarPago)
                        .addGap(5, 5, 5)
                        .addComponent(btnEliminarPago))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPago)
                    .addComponent(jLabel4)
                    .addComponent(txt_sobrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lineasDeVentaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Lineas de Venta"));
        lineasDeVentaPanel.setLayout(new java.awt.GridBagLayout());

        tableLineasVenta.setModel(ventaTableModel);
        jScrollPane1.setViewportView(tableLineasVenta);

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

        btnSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/upArrow.png"))); // NOI18N
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        lineasDeVentaPanel.add(btnSubir, gridBagConstraints);

        btnBajar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/downArrow.png"))); // NOI18N
        btnBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        lineasDeVentaPanel.add(btnBajar, gridBagConstraints);

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
                .addContainerGap(556, Short.MAX_VALUE)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Venta"));

        buttonGroup1.add(cb_venta_total);
        cb_venta_total.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_venta_total.setSelected(true);
        cb_venta_total.setText("Venta Total");

        buttonGroup1.add(cb_venta_parcial);
        cb_venta_parcial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_venta_parcial.setText("Venta Parcial");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cb_venta_total)
                .addGap(18, 18, 18)
                .addComponent(cb_venta_parcial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_venta_total)
                    .addComponent(cb_venta_parcial)))
        );

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(panel_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
      try {
        
        long nit=0;
        int id_estacion=0;
        
        int opc=JOptionPane.showConfirmDialog(null,"Desea concluir la venta?", "Aviso!", JOptionPane.YES_NO_OPTION); 
        ConexionBD nueva=new ConexionBD();  
        if(opc==JOptionPane.YES_OPTION)
        {
            
        if(tableLineasVenta.getRowCount()== 0 && tableLineasVenta.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Linea de Venta no tiene items de venta!");
            
        }
        else if(tablePagosVenta.getRowCount()== 0 && tablePagosVenta.getSelectedRow()==-1)
        {
           JOptionPane.showMessageDialog(null, "La tabla Forma de Pago no tiene items de pago!");

        }
        else if(txtCodigoCliente.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null, "El Nit Cliente se encuentra vacio!","Alerta", JOptionPane.WARNING_MESSAGE);

        }
        else
        {
 
       // ResultSet obj=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedente_dependencia WHERE recibo_caja="+txt_recibo.getText()+"");
        ResultSet obj2=nueva.executeQuery("SELECT ven_recibo_caja FROM ventas.venta WHERE ven_recibo_caja="+txt_recibo.getText()+"");
        ResultSet obj3=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+txt_recibo.getText()+"");
        ResultSet obj4=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes_dependencias WHERE recibo_caja="+txt_recibo.getText()+"");
       // ResultSet obj5=nueva.executeQuery("SELECT ven_recibo_caja FROM ventas.venta where ven_recibo_caja="+txt_recibo.getText()+"");

        
//            if(obj.next()==true)
//            {
//                JOptionPane.showMessageDialog(null, "El recibo de caja N°: " +txt_recibo.getText()+ " fue utilizado para cancelación de excedentes", "Alerta", JOptionPane.WARNING_MESSAGE);
//            }
           
                if(obj2.next()==true)
                {
                    JOptionPane.showMessageDialog(null, "El recibo de caja N°: " +txt_recibo.getText()+ " fue utilizado para una venta", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            else
                    if(obj3.next()==true)
                    {
                      JOptionPane.showMessageDialog(null, "El recibo de caja N°: " +txt_recibo.getText()+ " ya fue anulado anteriormente", "Alerta", JOptionPane.WARNING_MESSAGE);

                    }
                    
                    else
                        if(obj4.next()==true)
                    {
                      JOptionPane.showMessageDialog(null, "El recibo de caja N°: " +txt_recibo.getText()+ " Fue utilizado en Validación Tiquetes a Dependencias", "Alerta", JOptionPane.WARNING_MESSAGE);

                    }
        
          else
          {
   
            if (checkCliente.isSelected()) {
                Long idCliente = Long.parseLong(txtCodigoCliente.getText());
                controlador.asignarCliente(idCliente);
            }
            
             if(cb_cliente.getSelectedItem()!=null)
            {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj1=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                 while(obj1.next())
                {
                    nit=obj1.getLong("id_cliente_sede");
                  
                }
                 controlador.asignarSedeCliente(nit);
            }
            

            if (txt_recibo.getText().equals("")) {
                throw new NullPointerException();

            } else 
            {

                long recibo = Long.parseLong(txt_recibo.getText());
                controlador.asignarRecibo(recibo);
            }
          
            String obs = jtxta_obse.getText();
            controlador.asignarObservaciones(obs);
            
            @SuppressWarnings("static-access")
            int id_usurio= principal.getSeccion();
            controlador.asignarIdUsuario(id_usurio);

            if (checkPago.isSelected()) {
                controlador.indicarSiCuentaEsPaga(true);
            }
            
            if(cb_venta_total.isSelected())
            {
                controlador.asignarVentaTotal(true);
            }
            else
            {
                controlador.asignarVentaTotal(false);
            }
            
            if(cb_venta_parcial.isSelected())
            {
                controlador.asignarVentaParcial(true);
            }
            else
            {
                controlador.asignarVentaParcial(false);
            }
            
            //Captura sobrante a favor de la utd
            int sobrante=Integer.parseInt(txt_sobrante.getText());
            controlador.asignarSobranteAFavor(sobrante);
            
            
             if(cb_estacion.getSelectedItem()!=null)
            {
                String estacion=cb_estacion.getSelectedItem().toString();
                ResultSet obj5=nueva.executeQuery("SELECT codigo_peaje FROM dependencias.peajes WHERE estacion_peaje='"+estacion+"'");
                 while(obj5.next())
                {
                    id_estacion=obj5.getInt("codigo_peaje");
                  
                }
                 controlador.asignarIDEstacion(id_estacion);
            }
  
            controlador.terminarVenta();
            this.dispose();
            nueva.desconectar();
          }//cierre del else
        }
       }//cierre del if
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El N° de Recibo es un campo númerico!.\n\t" + ex, "ERROR!", JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this,"No se ha especificado el N°Recibo o Consecutivo por favor digitelo !" + ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "* "+ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
        }
       
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ConexionBD nueva=new ConexionBD();
        //Comprueba si la tableLineasVenta esta vacia
        
         int opc=JOptionPane.showConfirmDialog(null,"Desea cancelar la venta?", "Aviso!", JOptionPane.YES_NO_OPTION); 
         
          if(opc==JOptionPane.YES_OPTION)
        {
  
        if(tableLineasVenta.getRowCount()== 0 && tableLineasVenta.getSelectedRow()==-1)
        {
            controlador.cancelarVenta();
            this.dispose();
            
        }
        else
        {
         
        for(int i = 0; i < tableLineasVenta.getRowCount(); i++)
        {
            nuevaCone.executeUpdateQuery("BEGIN;");
            nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+tableLineasVenta.getValueAt(i,3)+" AND "+tableLineasVenta.getValueAt(i,4)+"");                
            this.confirmarTransaccion();
        }  
        
            controlador.cancelarVenta();  
            this.dispose();
            nueva.desconectar();
        
        }
       } 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPagoActionPerformed
        JDAdicionarPagoVenta dialog = new JDAdicionarPagoVenta(registroVenta, true);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        
        boolean ret = true; //Bandera que indica que se debe solicitar nuevamente los datos de linea de venta
        
        total=totalVenta;//Se captura el total de la venta para pasarla a la GUI JDAdicionarFormaPago
        
        JDAdicionarPagoVenta.settxttxtMontoPagado(total);//asigna al campo txtMontoPagado el total de la venta
       
        while (ret) {
            dialog.setVisible(true);
            if (!dialog.isCancel()) {
                try {
                    controlador.adicionarPago(dialog.getIDFormaPago(), dialog.getSerialTransaccion(), dialog.getIDCuentaBancaria(), dialog.getMontoPagado());
                    ret = false;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El monto pagado debe ser un valor numerico.\n\t" + ex, "ERROR!", JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                ret = false;
            }
        }
    }//GEN-LAST:event_btnAdicionarPagoActionPerformed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
        try {
            controlador.eliminarPago(tablePagosVenta.getSelectedRow());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        try {
            int rowSelected = tableLineasVenta.getSelectedRow();
            controlador.cambiarPosicionLineaDeVenta(rowSelected, rowSelected - 1);
            tableLineasVenta.changeSelection(rowSelected - 1, 0, false, false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajarActionPerformed
        try {
            int rowSelected = tableLineasVenta.getSelectedRow();
            controlador.cambiarPosicionLineaDeVenta(rowSelected, rowSelected + 1);
            tableLineasVenta.changeSelection(rowSelected + 1, 0, false, false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBajarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
//        JDAdicionarLineaVenta dialog = new JDAdicionarLineaVenta(registroVenta, true);
//        dialog.pack();
//        dialog.setLocationRelativeTo(null);
//        
//        
//        boolean ret = true; //Bandera que indica que se debe solicitar nuevamente los datos de linea de venta 
//       
//        while (ret) {
//            dialog.setVisible(true);
//            if (!dialog.isCancel()) {
//      
//         try {
//                    
//                ResultSet obj1=nuevaCone.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
//        
//        if (obj1.next()==true)
//        {
//            long maximo=obj1.getLong("maximo");
//            long minimo=obj1.getLong("minimo");
//            
//            if(dialog.getSerialInicial() >= minimo && dialog.getSerialFinal()<= maximo )
//            {
//                ResultSet obj=nuevaCone.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_estado="+true+" AND puv="+true+" AND conse_num_consecutivo_tiqute BETWEEN "+dialog.getSerialInicial()+" AND "+dialog.getSerialFinal()+";");
//            if(obj.next()==true)
//            {
//   
//               nuevaCone.executeUpdateQuery("BEGIN");
//  
//               nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+dialog.getSerialInicial()+" AND "+dialog.getSerialFinal()+"");
//
//               this.confirmarTransaccion();
//               
//                 controlador.aniadirLineaDeVenta(dialog.getIDEspecificacion(), dialog.getSerialInicial(), dialog.getSerialFinal());
//                 ret = false;
//
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango del serial no esta disponible ", "Error", JOptionPane.ERROR_MESSAGE);
//                nuevaCone.desconectar();
//            }
//           }
//            else
//            {
//                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
//                nuevaCone.desconectar();
//            }
//            
//        }
//            nuevaCone.desconectar();
//                    
//               
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(this, "Algunos de los datos ingresados no son númericos.\n\t" + ex, "ERROR!", JOptionPane.ERROR_MESSAGE);
//                } catch (NullPointerException ex) {
//                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
//                }
//            } else {
//                ret = false;
//            }
//        }}
        
        JDAdicionarLineaVenta dialog = new JDAdicionarLineaVenta(registroVenta, true);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
  
        
        boolean ret = true; //Bandera que indica que se debe solicitar nuevamente los datos de linea de venta 
       
        while (ret) {
            dialog.setVisible(true);
            if (!dialog.isCancel()) {
                try {
                    controlador.aniadirLineaDeVenta(dialog.getIDEspecificacion(), dialog.getSerialInicial(), dialog.getSerialFinal());
                    ret = false;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Alguno de los datos ingresado no es númerico.\n\t" + ex, "ERROR!", JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex, "Cuidado!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                ret = false;
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
         
            int row = tableLineasVenta.getSelectedRow();
            
            nuevaCone.executeUpdateQuery("BEGIN;");
            nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos  SET conse_estado=" + true + " WHERE conse_num_consecutivo_tiqute between " + tableLineasVenta.getValueAt(row, 3) + " AND " + tableLineasVenta.getValueAt(row, 4) + "");
            this.confirmarTransaccion();
            nuevaCone.desconectar();
            controlador.eliminarLineaVenta(tableLineasVenta.getSelectedRow());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        controlador.iniciarVenta();
        Venta ventaActual = controlador.getVentaActual();
        ventaTableModel.setVenta(ventaActual);
        pagosTableModel.setVenta(ventaActual);
        IObservadorVenta observador = new IObservadorVenta(){

            @Override
            public void onAddLineaVenta(Venta fuente, LineaDeVenta linea) {
                onVentaModificaTotalVenta(fuente);
                
            }

            @Override
            public void onDeleteLineaVenta(Venta fuente, int posicion) {
                onVentaModificaTotalVenta(fuente);
            }

            @Override
            public void onCambioPosicionLineaVenta(Venta fuente, int posicion1, int posicion2) {
                
            }

            @Override
            public void onAdicionarPago(Venta fuente, Pago pago) {
               
                
            }

            @Override
            public void onEliminarPago(Venta fuente, int posicion) {
                
            }

        };
        ventaActual.addObservador(observador);
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formWindowClosing
         controlador.cancelarVenta();
         dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtCodigoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoClienteKeyReleased
           if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                cb_cliente.removeAllItems();
                buscarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodigoClienteKeyReleased

    private void cb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteActionPerformed
           if(cb_cliente.getSelectedItem()!=null)
            {
                long nit;
                
                ConexionBD nueva=new ConexionBD();
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT cli_nit FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                
                while(obj.next())
                {
                    nit=obj.getLong("cli_nit");
                    txtCodigoCliente.setText("");
                    txtCodigoCliente.setText(String.valueOf(nit));
                }
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
       reporte=new ReporteVenta();
       long recibo = Long.parseLong(txt_recibo.getText());
         reporte.ejecutarReporte(recibo);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAdicionarPago;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBajar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.JButton btnSubir;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JComboBox cb_estacion;
    private javax.swing.JCheckBox cb_venta_parcial;
    private javax.swing.JCheckBox cb_venta_total;
    private javax.swing.JCheckBox checkCliente;
    private javax.swing.JCheckBox checkPago;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel controlButtonsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooserBeanInfo jMonthChooserBeanInfo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jtxta_obse;
    private javax.swing.JLabel labelTotalVenta;
    private javax.swing.JPanel lineasDeVentaPanel;
    private javax.swing.JPanel pagos;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tableLineasVenta;
    private javax.swing.JTable tablePagosVenta;
    private javax.swing.JPanel totalVentaPanel;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txt_recibo;
    private javax.swing.JTextField txt_sobrante;
    // End of variables declaration//GEN-END:variables
    //Buscar cliente
    public void buscarCliente() throws SQLException
    {
       
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion ilike '%"+txtCodigoCliente.getText().toUpperCase()+"%' ORDER BY sede_descripcion");
            
            while(obj.next())
            {
                cb_cliente.addItem(obj.getObject("sede_descripcion"));
            }
            
            nueva.desconectar();

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
    
    

}
