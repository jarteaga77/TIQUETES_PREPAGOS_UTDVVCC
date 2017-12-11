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
import sysctp.dominio.ventas.DaoDetalle_Venta_Dependencia;
import sysctp.dominio.ventas.DaoPago_venta_dependencia;
import sysctp.dominio.ventas.DaoVentas_dependencias;
import sysctp.dominio.ventas.Detalle_venta_dependencia;
import sysctp.dominio.ventas.Pago_venta_dependencia;
import sysctp.dominio.ventas.Venta_dependencias;
import sysctp.reporte.ventaDependencia.ReporteVentaDependencia;
/**
 *
 * @author jarteaga
 */
public class JIFRegistroVentaDependencia extends javax.swing.JInternalFrame {
    
    private  ConexionBD nueva ;
    public static MDIPrincipal principal;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloPago;
    private long montoPagado=0;
    private ReporteVentaDependencia reporte;
  
    public JIFRegistroVentaDependencia() {
        initComponents();
     
        modelo=new DefaultTableModel();
        modeloPago=new DefaultTableModel();
        nueva=new ConexionBD();

     try
    {
        ResultSet obj=nueva.executeQuery("SELECT depe_descripcion FROM dependencias.dependencia ORDER BY depe_descripcion ASC ");//Consulta para traer las dependencias
        
        while(obj.next())
        {
            cb_depen.addItem(obj.getObject("depe_descripcion"));//Llena JCombobox con el nombre del centro de costos
        }
        
        ResultSet obj1=nueva.executeQuery("SELECT MAX(ven_dep_id)+1 as id_ven_dep FROM ventas.venta_dependencia");
        
         while(obj1.next())
        {
            txt_recibo.setText(String.valueOf(obj1.getLong("id_ven_dep")));
        }
        nueva.desconectar();
        
        
        } catch(SQLException e)
        {
         JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        modelo.addColumn("ID");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Serial Inicial");
        modelo.addColumn("Serial Final");
        modelo.addColumn("Vlor.Unitario");
        modelo.addColumn("Total Parcial");
        
        
        modeloPago.addColumn("ID");
        modeloPago.addColumn("Forma de Pago");
        modeloPago.addColumn("Monto");
  
    }
    
      public static JTextField gettxtIDEspecificacion() {
        return txt_id_esp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFRegistroVentaDependencia.txt_id_esp.setText(String.valueOf(id));
    }
    
    public static JTextField gettxtIDFormaPago() {
        return txt_id_fp;
    }

    public static void settxtIDFormaPago(int  id) {
        JIFRegistroVentaDependencia.txt_id_fp.setText(String.valueOf(id));
    }
    
 
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        JD_Detalle_Venta = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_serial_1 = new javax.swing.JTextField();
        txt_serial_2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id_esp = new javax.swing.JTextField();
        btn_Adicionar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        JD_Forma_Pago = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_fp = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        btn_fp = new javax.swing.JButton();
        btn_aceptar_fp = new javax.swing.JButton();
        btn_cancelar_fp = new javax.swing.JButton();
        demoTable1 = new com.toedter.calendar.demo.DemoTable();
        panel_principal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txta_obse = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_recibo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pagos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePagosVenta = new javax.swing.JTable();
        btnAdicionarPago = new javax.swing.JButton();
        btnEliminarPago = new javax.swing.JButton();
        lineasDeVentaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLineasVenta = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        totalVentaPanel = new javax.swing.JPanel();
        label_total = new javax.swing.JLabel();
        clientePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_item_depen = new javax.swing.JComboBox();
        cb_depen = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        controlButtonsPanel = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        JD_Detalle_Venta.setTitle("Linea de Venta");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Serial Inicial:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Serial Final:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("ID Especificación:");

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
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
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
                    .addComponent(jLabel8)
                    .addComponent(txt_id_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Adicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_serial_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serial_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
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

        JD_Forma_Pago.setTitle("Forma de Pago");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("ID Forma de Pago:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Monto Pagado: $");

        txt_id_fp.setEditable(false);

        txt_monto.setEditable(false);

        btn_fp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_fp.setToolTipText("");
        btn_fp.setContentAreaFilled(false);
        btn_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fpActionPerformed(evt);
            }
        });

        btn_aceptar_fp.setText("Aceptar");
        btn_aceptar_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_fpActionPerformed(evt);
            }
        });

        btn_cancelar_fp.setText("Cancelar");
        btn_cancelar_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_fpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_monto)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_id_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_fp))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_aceptar_fp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancelar_fp)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_id_fp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar_fp)
                    .addComponent(btn_cancelar_fp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Forma_PagoLayout = new javax.swing.GroupLayout(JD_Forma_Pago.getContentPane());
        JD_Forma_Pago.getContentPane().setLayout(JD_Forma_PagoLayout);
        JD_Forma_PagoLayout.setHorizontalGroup(
            JD_Forma_PagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Forma_PagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_Forma_PagoLayout.setVerticalGroup(
            JD_Forma_PagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Forma_PagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Sistema de Control Tiquetes Prepagos -Venta Dependencias");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txta_obse.setColumns(20);
        txta_obse.setRows(5);
        jScrollPane3.setViewportView(txta_obse);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Observaciones:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Venta"));

        txt_recibo.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Venta:");

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

        javax.swing.GroupLayout pagosLayout = new javax.swing.GroupLayout(pagos);
        pagos.setLayout(pagosLayout);
        pagosLayout.setHorizontalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarPago)
                    .addComponent(btnEliminarPago)))
        );
        pagosLayout.setVerticalGroup(
            pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagosLayout.createSequentialGroup()
                .addGroup(pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pagosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pagosLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnAdicionarPago)
                        .addGap(5, 5, 5)
                        .addComponent(btnEliminarPago)))
                .addContainerGap())
        );

        lineasDeVentaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Lineas de Venta"));
        lineasDeVentaPanel.setLayout(new java.awt.GridBagLayout());

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

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total $ 0,0");

        javax.swing.GroupLayout totalVentaPanelLayout = new javax.swing.GroupLayout(totalVentaPanel);
        totalVentaPanel.setLayout(totalVentaPanelLayout);
        totalVentaPanelLayout.setHorizontalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalVentaPanelLayout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        totalVentaPanelLayout.setVerticalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalVentaPanelLayout.createSequentialGroup()
                .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        lineasDeVentaPanel.add(totalVentaPanel, gridBagConstraints);

        clientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la dependencia"));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Item Dependencia:");

        cb_depen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_depenActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Dependencia:");

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_depen, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(cb_item_depen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_item_depen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cb_depen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

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
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(clientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineasDeVentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_depenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_depenActionPerformed
         try
        {
            int id_depen=0;
            //ConexionBD nuevaCone=new ConexionBD();
            nueva=new ConexionBD();

            if(cb_depen.getSelectedItem()!=null)
            {
                String depen=cb_depen.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT id_dependencia FROM dependencias.dependencia WHERE depe_descripcion='"+depen+"'");

                while(obj.next())
                {
                    id_depen=obj.getInt("id_dependencia");
                }
                cb_item_depen.removeAllItems();
            }

            ResultSet obj2=nueva.executeQuery("SELECT item_depen_descrip FROM dependencias.item_dependencia WHERE id_dependencia="+id_depen+" ORDER BY item_depen_descrip ASC ");

            while(obj2.next())
            {
                cb_item_depen.addItem(obj2.getObject("item_depen_descrip"));
            }
            nueva.desconectar();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cb_depenActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        JD_Detalle_Venta.pack();
        JD_Detalle_Venta.setLocationRelativeTo(null);
        JD_Detalle_Venta.setVisible(true);
        JD_Detalle_Venta.setResizable(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);        
        jdETP.setLocation(700, 0);       
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Detalle_Venta.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         if(tableLineasVenta.getRowCount()== 0 && tableLineasVenta.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Linea de Venta no tiene items de venta!");
            
        }
        else if(tablePagosVenta.getRowCount()== 0 && tablePagosVenta.getSelectedRow()==-1)
        {
           JOptionPane.showMessageDialog(null, "La tabla Forma de Pago no tiene items de pago!");

        }else
        {
            dispose();
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
       try
       {
           
            Venta_dependencias venta=new Venta_dependencias();
            DaoVentas_dependencias daoVentas=new DaoVentas_dependencias();
            Detalle_venta_dependencia detalle=new Detalle_venta_dependencia();
            DaoDetalle_Venta_Dependencia daoDetalle=new DaoDetalle_Venta_Dependencia();
            nueva=new ConexionBD();
            
            
           ResultSet obj=nueva.executeQuery("SELECT ven_dep_id FROM ventas.venta_dependencia WHERE ven_dep_id="+txt_recibo.getText()+"");
           
           
           if(obj.next()==false)
           {
    
            int id_item=0;
            int id_usurio= principal.getSeccion();
             if(cb_item_depen.getSelectedItem()!=null)
            {
            
                String item=cb_item_depen.getSelectedItem().toString();
                ResultSet obj1=nueva.executeQuery("SELECT id_item_depen FROM dependencias.item_dependencia WHERE item_depen_descrip='"+item+"'");
                
                while(obj1.next())
                {
                    id_item=obj1.getInt("id_item_depen");
                }
            } 
            

             venta.setVen_dep_fecha(new Date());
             venta.setId_item_depen(id_item);
             venta.setVen_dep_obse(txta_obse.getText());
             venta.setId_iusuario(id_usurio);
             
             daoVentas.registrarVentaDependencia(venta);
             
        
            detalle.setEtp(Integer.parseInt(txt_id_esp.getText()));
            detalle.setDvd_serial_1(Long.parseLong(txt_serial_1.getText()));
            detalle.setDvd_serial_2(Long.parseLong(txt_serial_2.getText()));
            detalle.setVen_dep_id(Long.parseLong(txt_recibo.getText()));
        
            daoDetalle.registrarDetalleVenta(detalle);
        
     
            LimpiarTablaDetalle();
            consultaDetalleTabla();
            sumatoriaTotales();
            totalMonto();
        
            txt_serial_1.setText("");
            txt_serial_2.setText("");
            txt_id_esp.setText("");
  
           }else
           {
            detalle.setEtp(Integer.parseInt(txt_id_esp.getText()));
            detalle.setDvd_serial_1(Long.parseLong(txt_serial_1.getText()));
            detalle.setDvd_serial_2(Long.parseLong(txt_serial_2.getText()));
            detalle.setVen_dep_id(Long.parseLong(txt_recibo.getText()));
        
            daoDetalle.registrarDetalleVenta(detalle);
            
            LimpiarTablaDetalle();
            consultaDetalleTabla();
            sumatoriaTotales();
            totalMonto();
            
            txt_serial_1.setText("");
            txt_serial_2.setText("");
            txt_id_esp.setText("");
           }
            nueva.desconectar();
           
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_aceptar_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_fpActionPerformed
        Pago_venta_dependencia pvd=new Pago_venta_dependencia();
        DaoPago_venta_dependencia daopvd=new DaoPago_venta_dependencia();
        
        pvd.setFp(Integer.parseInt(txt_id_fp.getText()));
        pvd.setPago_monto(Long.parseLong(txt_monto.getText()));
        pvd.setVen_dep_id(Long.parseLong(txt_recibo.getText()));
        
        daopvd.registrarPago(pvd);
        JD_Forma_Pago.dispose();
        LimpiarTablaPago();
        detalleTablaFormaPago();
        
        txt_id_fp.setText("");
        txt_monto.setText("");
        
    }//GEN-LAST:event_btn_aceptar_fpActionPerformed

    private void btn_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fpActionPerformed
        jDTablaFormaPago jdTFP=new jDTablaFormaPago(new javax.swing.JFrame(), true);
        jdTFP.setLocation(700, 0);
        jdTFP.setVisible(true);
    }//GEN-LAST:event_btn_fpActionPerformed

    private void btnAdicionarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPagoActionPerformed
       JD_Forma_Pago.pack();
       JD_Forma_Pago.setLocationRelativeTo(null);
       JD_Forma_Pago.setVisible(true);
       JD_Forma_Pago.setResizable(false);
       totalMonto();
    }//GEN-LAST:event_btnAdicionarPagoActionPerformed

    private void btn_cancelar_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_fpActionPerformed
       JD_Forma_Pago.dispose();
    }//GEN-LAST:event_btn_cancelar_fpActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
         nueva=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tableLineasVenta.isRowSelected(tableLineasVenta.getSelectedRow()))
        {

           int row = tableLineasVenta.getSelectedRow();

           nueva.executeUpdateQuery("DELETE FROM ventas.detalle_venta_dependencia  WHERE dvd_id="+modelo.getValueAt(row,0)+" AND ven_dep_id="+txt_recibo.getText()+"");
           nueva.executeUpdateQuery("BEGIN;");
           nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 3) +" AND "+modelo.getValueAt(row, 4)+" ");
           this.confirmarTransaccion();
         int numRows = tableLineasVenta.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         }
        } else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nueva.desconectar();
          LimpiarTablaDetalle();
          consultaDetalleTabla();
          sumatoriaTotales();
          totalMonto();
          nueva.desconectar();
        

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
           try
        {
           nueva=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tablePagosVenta.isRowSelected(tablePagosVenta.getSelectedRow()))
        {

           int row = tablePagosVenta.getSelectedRow();

        for(int i = 0; i < modeloPago.getRowCount(); i++)
        {
           nueva.executeUpdateQuery("DELETE FROM ventas.pago_ven_dep WHERE pago_ven_dep="+modeloPago.getValueAt(row,0)+" AND ven_dep_id="+txt_recibo.getText()+"");
        }
         int numRows = tablePagosVenta.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modeloPago.removeRow(row);
         }
        } else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nueva.desconectar();
          LimpiarTablaPago();
          detalleTablaFormaPago();
        

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                
         //Comprueba si la tableLineasVenta esta vacia
            nueva=new ConexionBD();
         int opc=JOptionPane.showConfirmDialog(null,"Desea cancelar la venta?", "Aviso!", JOptionPane.YES_NO_OPTION); 
         
          if(opc==JOptionPane.YES_OPTION)
        {
  
        if(tableLineasVenta.getRowCount()== 0 && tableLineasVenta.getSelectedRow()==-1)
        {
            //this.dispose();  
        }
        else
        {
            for(int i = 0; i < tableLineasVenta.getRowCount(); i++)
            {
                nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+tableLineasVenta.getValueAt(i,3)+" AND "+tableLineasVenta.getValueAt(i,4)+"");                
            }  
         }
        nueva.executeUpdateQuery("BEGIN;"
                + "DELETE FROM ventas.detalle_venta_dependencia WHERE ven_dep_id="+txt_recibo.getText()+";"
                + "DELETE FROM ventas.pago_ven_dep WHERE ven_dep_id="+txt_recibo.getText()+";"
                + "DELETE FROM ventas.venta_dependencia WHERE ven_dep_id="+txt_recibo.getText()+";"
                + "ROLLBACK;"
                + "COMMIT;");
        
            nueva.desconectar();
            dispose();
        }  
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        reporte=new ReporteVentaDependencia();
        long  ven_dep_id = Long.parseLong(txt_recibo.getText());
        reporte.ejecutarReporte(ven_dep_id);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle_Venta;
    private javax.swing.JDialog JD_Forma_Pago;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAdicionarPago;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_aceptar_fp;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar_fp;
    private javax.swing.JButton btn_fp;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JComboBox cb_depen;
    private javax.swing.JComboBox cb_item_depen;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel controlButtonsPanel;
    private com.toedter.calendar.demo.DemoTable demoTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_total;
    private javax.swing.JPanel lineasDeVentaPanel;
    private javax.swing.JPanel pagos;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tableLineasVenta;
    private javax.swing.JTable tablePagosVenta;
    private javax.swing.JPanel totalVentaPanel;
    public static javax.swing.JTextField txt_id_esp;
    public static javax.swing.JTextField txt_id_fp;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_recibo;
    private javax.swing.JTextField txt_serial_1;
    private javax.swing.JTextField txt_serial_2;
    private javax.swing.JTextArea txta_obse;
    // End of variables declaration//GEN-END:variables

  public void LimpiarTablaDetalle()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);    
        }
    }
  
   public void LimpiarTablaPago()
    {
        for(int i=modeloPago.getRowCount()-1;i>=0;i--)
        {
            modeloPago.removeRow(i);  
        }
    }
    // Muestra el detalle de la venta en la tabla *tableLineasVenta*
    public void consultaDetalleTabla()
    {
      ConexionBD nuevaCone=new ConexionBD();
      ResultSet obj=nuevaCone.executeQuery("SELECT dvd.dvd_id,(dvd_serial_2 - dvd_serial_1 +1) as cantidad, (cat.cat_nombre ||'-'||tea.tea_nombre)AS descripcion,dvd.dvd_serial_1,dvd_serial_2,etp.etp_precio,((dvd_serial_2 - dvd_serial_1 +1)*(etp.etp_precio)) AS subtotal FROM ventas.venta_dependencia ven JOIN ventas.detalle_venta_dependencia dvd ON ven.ven_dep_id=dvd.ven_dep_id "
              + "JOIN inventario.especificacion_tiquete_prepago etp ON dvd.etp=etp.etp_id "
              + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
              + "JOIN inventario.tipo_eje_adicional tea ON etp.tea_id=tea.tea_id "
              + "WHERE ven.ven_dep_id="+txt_recibo.getText()+" "
              + "ORDER BY dvd.dvd_id");
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
            tableLineasVenta.setModel(modelo);
             nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    //Muestra el detalle de forma de pago en la *tablePagosVenta*
     public void detalleTablaFormaPago()
    {
        ConexionBD nuevaCone=new ConexionBD();
        ResultSet obj=nuevaCone.executeQuery("SELECT pa.pago_ven_dep,fp.fp_descripcion, to_char(pa.pago_monto,'999G999G999G999D99') FROM ventas.venta_dependencia ven JOIN ventas.pago_ven_dep pa ON ven.ven_dep_id=pa.ven_dep_id "
                + "JOIN ventas.forma_de_pago fp ON pa.fp_ven_dep=fp.fp_id WHERE ven.ven_dep_id="+txt_recibo.getText()+"");
        try {
            while (obj.next())
            {
                Object [] datos = new Object[3];
                 for (int i=0;i<3;i++)
                  {
                      datos[i] =obj.getObject(i+1);
                  }
                 modeloPago.addRow(datos);
                 
            }
            tablePagosVenta.setModel(modeloPago);
            nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Total venta dependencia
//    public void totalVenta()
//    {
//        ConexionBD nuevaCone=new ConexionBD();
//        String total="";
//        ResultSet obj=nuevaCone.executeQuery("SELECT to_char(sum((dvd.dvd_serial_2 - dvd.dvd_serial_1 +1)*(etp.etp_precio)),'999G999G999G999D99') AS total "
//                + "FROM ventas.venta_dependencia ven JOIN ventas.detalle_venta_dependencia dvd ON dvd.ven_dep_id=ven.ven_dep_id JOIN inventario.especificacion_tiquete_prepago etp ON dvd.etp=etp.etp_id WHERE ven.ven_dep_id="+txt_recibo.getText()+" ");
//        try {
//            while(obj.next())
//            {
//                total=obj.getString("total");
//            }
//            label_total.setText(total);
//            nuevaCone.desconectar();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
    
    //Total Monto pagado
    public void totalMonto()
    {
        ConexionBD nuevaCone=new ConexionBD();
        ResultSet obj=nuevaCone.executeQuery("SELECT sum((dvd.dvd_serial_2 - dvd.dvd_serial_1 +1)*(etp.etp_precio)) AS total "
                + "FROM ventas.venta_dependencia ven JOIN ventas.detalle_venta_dependencia dvd ON dvd.ven_dep_id=ven.ven_dep_id JOIN inventario.especificacion_tiquete_prepago etp ON dvd.etp=etp.etp_id WHERE ven.ven_dep_id="+txt_recibo.getText()+"");
        try {
            while(obj.next())
            {
                montoPagado=obj.getLong("total");
            }
           
            txt_monto.setText(String.valueOf(montoPagado));
            nuevaCone.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    
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
            JOptionPane.showMessageDialog(null, e + "Se canceló la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }

    public void cancelarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("ROLLBACK;");
            System.out.println("Pase por cancelar Transaccion");
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
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total: $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tableLineasVenta.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tableLineasVenta.getValueAt(i,6)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          
           }
    }
    
    
    
}
