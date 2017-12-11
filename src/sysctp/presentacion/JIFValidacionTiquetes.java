package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.ventas.DaoDetalleValidacion;
import sysctp.dominio.ventas.DaoPagoValidaciones;
import sysctp.dominio.ventas.DaoValidacionTiquetes;
import sysctp.dominio.ventas.DetalleValidacion;
import sysctp.dominio.ventas.PagoValidaciones;
import sysctp.dominio.ventas.Validacion_tiquetes;
import sysctp.reporte.validacion.ReporteValidacion;
/**
 *
 * @author jarteaga
 */
public class JIFValidacionTiquetes extends javax.swing.JInternalFrame {
    
    private  ConexionBD nueva =new ConexionBD();
    public static MDIPrincipal principal;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloPago;
    private long montoPagado=0;
    private ReporteValidacion reporte;
    
  
    public JIFValidacionTiquetes() {
        initComponents();
        modelo=new DefaultTableModel();
        modeloPago=new DefaultTableModel();
        

     try
    {
       
        ResultSet obj1=nueva.executeQuery("SELECT MAX(id_revalidacion)+1 as id_revalidacion FROM ventas.validacion_tiquetes");
        
         while(obj1.next())
        {
            txt_id_validacion.setText(String.valueOf(obj1.getLong("id_revalidacion")));
        }
        nueva.desconectar();
        
        
        } catch(SQLException e)
        {
         JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        modelo.addColumn("ID");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Vlor.Validación");
        modelo.addColumn("Total Parcial");
        
        
        modeloPago.addColumn("ID");
        modeloPago.addColumn("Forma de Pago");
        modeloPago.addColumn("N° Cuenta");
        modeloPago.addColumn("Cuenta Bancaria");
        modeloPago.addColumn("Monto");
  
    }
    
      public static JTextField gettxtIDEspecificacion() {
        return txt_id_esp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFValidacionTiquetes.txt_id_esp.setText(String.valueOf(id));
    }
    
    public static JTextField gettxtIDFormaPago() {
        return txt_id_fp;
    }

    public static void settxtIDFormaPago(int  id) {
        JIFValidacionTiquetes.txt_id_fp.setText(String.valueOf(id));
    }
    
      public static JTextField gettxtIDCtaBan() {
        return txt_ctaban;
    }

    public static void settxtIDCtaBan(int  id) {
        JIFValidacionTiquetes.txt_ctaban.setText(String.valueOf(id));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        JD_Detalle_Validacion = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_id_esp = new javax.swing.JTextField();
        btn_Adicionar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_vlorValidacion = new javax.swing.JTextField();
        JD_Forma_Pago = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_fp = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        btn_fp = new javax.swing.JButton();
        btn_aceptar_fp = new javax.swing.JButton();
        btn_cancelar_fp = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_ctaban = new javax.swing.JTextField();
        btn_ctaban = new javax.swing.JButton();
        panel_principal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txta_obse = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_id_validacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_recibo = new javax.swing.JTextField();
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
        labelTotalVenta = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        clientePanel = new javax.swing.JPanel();
        cb_cliente = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        controlButtonsPanel = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        JD_Detalle_Validacion.setTitle("Linea de Venta");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad:");

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Monto: $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vlorValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_cantidad)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txt_id_esp, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_Adicionar))))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Adicionar)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_id_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_vlorValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_aceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Detalle_ValidacionLayout = new javax.swing.GroupLayout(JD_Detalle_Validacion.getContentPane());
        JD_Detalle_Validacion.getContentPane().setLayout(JD_Detalle_ValidacionLayout);
        JD_Detalle_ValidacionLayout.setHorizontalGroup(
            JD_Detalle_ValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_ValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_Detalle_ValidacionLayout.setVerticalGroup(
            JD_Detalle_ValidacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Detalle_ValidacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JD_Forma_Pago.setTitle("Forma de Pago");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("ID Forma de Pago:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("ID Cuenta Bancaria:");

        btn_ctaban.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_ctaban.setContentAreaFilled(false);
        btn_ctaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctabanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_aceptar_fp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancelar_fp))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_monto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txt_id_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_id_fp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txt_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar_fp)
                    .addComponent(btn_cancelar_fp))
                .addContainerGap())
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
        setTitle("Sistema de Control Tiquetes Prepagos -Validación Tiquetes  Clientes");

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
                .addComponent(jScrollPane3)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Validación Tiquetes"));

        txt_id_validacion.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Venta:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Recibo Caja N°:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_id_validacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id_validacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
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

        lineasDeVentaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lineas de Validación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));
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

        labelTotalVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotalVenta.setText("Valor Total:$");

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("0,0");

        javax.swing.GroupLayout totalVentaPanelLayout = new javax.swing.GroupLayout(totalVentaPanel);
        totalVentaPanel.setLayout(totalVentaPanelLayout);
        totalVentaPanelLayout.setHorizontalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalVentaPanelLayout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(labelTotalVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        totalVentaPanelLayout.setVerticalGroup(
            totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalVentaPanelLayout.createSequentialGroup()
                .addGroup(totalVentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalVenta)
                    .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Cliente");

        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        JD_Detalle_Validacion.pack();
        JD_Detalle_Validacion.setLocationRelativeTo(null);
        JD_Detalle_Validacion.setVisible(true);
        JD_Detalle_Validacion.setResizable(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);        
        jdETP.setLocation(700, 0);       
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Detalle_Validacion.dispose();
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
            
            Validacion_tiquetes validacion=new Validacion_tiquetes();
            DaoValidacionTiquetes daovalidacion=new DaoValidacionTiquetes();
            
            DetalleValidacion detalle=new DetalleValidacion();
            DaoDetalleValidacion daoDetalle=new DaoDetalleValidacion();
            
            ResultSet obj=nueva.executeQuery("SELECT id_revalidacion FROM ventas.validacion_tiquetes WHERE id_revalidacion="+txt_id_validacion.getText()+"");
            
            if(obj.next()==false)
            {
                long id_item=0;
                int id_usurio= principal.getSeccion();
  
             if(cb_cliente.getSelectedItem()!=null)
            {
            try {
                String item=cb_cliente.getSelectedItem().toString();
                ResultSet obj1=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+item+"'");
                
                while(obj1.next())
                {
                    id_item=obj1.getLong("id_cliente_sede");
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
             
             validacion.setRecibo_caja(Long.parseLong(txt_recibo.getText()));
             validacion.setObse(txta_obse.getText());
             validacion.setFecha_revalidacion(new Date());
             validacion.setId_sede(id_item);
             validacion.setId_usuario(id_usurio);
             
             daovalidacion.registrovalidacion(validacion);

            
             txt_id_validacion.setText(String.valueOf(daovalidacion.getValidacion_id()));
             
             
                detalle.setCantidad(Long.parseLong(txt_cantidad.getText()));
                detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
                detalle.setCosto_validacion(Long.parseLong(txt_vlorValidacion.getText()));
                detalle.setId_validacion(Long.parseLong(txt_id_validacion.getText()));
        
                daoDetalle.regDetalleValidacion(detalle);
        
                txt_id_esp.setText("");
                txt_cantidad.setText("");
                txt_vlorValidacion.setText("");
        
                LimpiarTablaDetalle();
                consultaDetalleTabla();
                totalValidacion();
                totalMonto();
                
            }else
            {
                detalle.setCantidad(Long.parseLong(txt_cantidad.getText()));
                detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
                detalle.setCosto_validacion(Long.parseLong(txt_vlorValidacion.getText()));
                detalle.setId_validacion(Long.parseLong(txt_id_validacion.getText()));
        
                daoDetalle.regDetalleValidacion(detalle);
        
                txt_id_esp.setText("");
                txt_cantidad.setText("");
                txt_vlorValidacion.setText("");
        
                LimpiarTablaDetalle();
                consultaDetalleTabla();
                totalValidacion();
                totalMonto();
            }
   
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
        
        
    
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_aceptar_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_fpActionPerformed
      try
      {
      
      PagoValidaciones pago=new PagoValidaciones();
      DaoPagoValidaciones daoPago=new DaoPagoValidaciones();
      
      pago.setId_formaPago(Integer.parseInt(txt_id_fp.getText()));
      pago.setId_ctaBanco(Integer.parseInt(txt_ctaban.getText()));
      pago.setPagoValidacion(Long.parseLong(txt_monto.getText()));
      pago.setIdvalidacion(Long.parseLong(txt_id_validacion.getText()));
      
      daoPago.registrarPagoValidaciones(pago);
      LimpiarTablaPago();
      detalleTablaFormaPago();
      JD_Forma_Pago.dispose();
      
      
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e, "Error",JOptionPane.ERROR_MESSAGE);
      }
      
        
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
    }//GEN-LAST:event_btnAdicionarPagoActionPerformed

    private void btn_cancelar_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_fpActionPerformed
       JD_Forma_Pago.dispose();
    }//GEN-LAST:event_btn_cancelar_fpActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
            ConexionBD nuevaCone=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tableLineasVenta.isRowSelected(tableLineasVenta.getSelectedRow()))
        {

           int row = tableLineasVenta.getSelectedRow();

        
           nuevaCone.executeUpdateQuery("DELETE FROM ventas.detalle_validacion WHERE id_dv="+modelo.getValueAt(row,0)+" AND id_validacion="+txt_id_validacion.getText()+"");
           
        
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
          totalValidacion();
          totalMonto();
        

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
           try
        {
            ConexionBD nuevaCone=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tablePagosVenta.isRowSelected(tablePagosVenta.getSelectedRow()))
        {

           int row = tablePagosVenta.getSelectedRow();

        for(int i = 0; i < modeloPago.getRowCount(); i++)
        {
           nuevaCone.executeUpdateQuery("DELETE FROM ventas.pago_validacion WHERE id_pa_va="+modeloPago.getValueAt(row,0)+" AND id_validacion="+txt_id_validacion.getText()+"");
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
          nuevaCone.desconectar();
          LimpiarTablaPago();
          detalleTablaFormaPago();
        

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                
         //Comprueba si la tableLineasVenta esta vacia
         ConexionBD nuevaCone=new ConexionBD();
         int opc=JOptionPane.showConfirmDialog(null,"Desea cancelar la venta?", "Aviso!", JOptionPane.YES_NO_OPTION); 
         
          if(opc==JOptionPane.YES_OPTION)
        {
  
        if(tableLineasVenta.getRowCount()== 0 && tableLineasVenta.getSelectedRow()==-1)
        {
            //this.dispose();  
        }
        
        nuevaCone.executeUpdateQuery("BEGIN;"
                + "DELETE FROM ventas.detalle_validacion WHERE id_validacion="+txt_id_validacion.getText()+";"
                + "DELETE FROM ventas.pago_validacion WHERE id_validacion="+txt_id_validacion.getText()+";"
                + "DELETE FROM ventas.validacion_tiquetes WHERE id_revalidacion="+txt_id_validacion.getText()+";"
                + "ROLLBACK;"
                + "COMMIT;");
        
            nuevaCone.desconectar();
            dispose();
        }  
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
           long recibo = Long.parseLong(txt_recibo.getText());
           reporte=new ReporteValidacion();          
           reporte.ejecutarReporte(recibo);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void txt_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyReleased
           if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                cb_cliente.removeAllItems();
                buscarCliente();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_clienteKeyReleased

    private void cb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteActionPerformed
        if(cb_cliente.getSelectedItem()!=null)
            {
                long nit;
                
                ConexionBD nuevaCone=new ConexionBD();
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nuevaCone.executeQuery("SELECT cli_nit FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                
                while(obj.next())
                {
                    nit=obj.getLong("cli_nit");
                    txt_cliente.setText("");
                    txt_cliente.setText(String.valueOf(nit));
                }
                nuevaCone.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void btn_ctabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctabanActionPerformed
        jDTablaCuentaBancaria jdTCtaBan=new jDTablaCuentaBancaria(new javax.swing.JFrame(), true);
        jdTCtaBan.setLocation(700, 0);
        jdTCtaBan.setVisible(true);
    }//GEN-LAST:event_btn_ctabanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Detalle_Validacion;
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
    private javax.swing.JButton btn_ctaban;
    private javax.swing.JButton btn_fp;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel controlButtonsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelTotalVenta;
    private javax.swing.JLabel label_total;
    private javax.swing.JPanel lineasDeVentaPanel;
    private javax.swing.JPanel pagos;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tableLineasVenta;
    private javax.swing.JTable tablePagosVenta;
    private javax.swing.JPanel totalVentaPanel;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente;
    public static javax.swing.JTextField txt_ctaban;
    public static javax.swing.JTextField txt_id_esp;
    public static javax.swing.JTextField txt_id_fp;
    private javax.swing.JTextField txt_id_validacion;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_recibo;
    private javax.swing.JTextField txt_vlorValidacion;
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
   
    //Buscar cliente
    public void buscarCliente() throws SQLException
    {
       
            ConexionBD nuevaCone=new ConexionBD();
            
            ResultSet obj=nuevaCone.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion ilike '%"+txt_cliente.getText().toUpperCase()+"%' ORDER BY sede_descripcion");
            
            while(obj.next())
            {
                cb_cliente.addItem(obj.getObject("sede_descripcion"));
            }
            nuevaCone.desconectar();

    }
 
    // Muestra el detalle de la venta en la tabla *tableLineasVenta*
    public void consultaDetalleTabla()
    {
      ConexionBD nuevaCone=new ConexionBD();
      ResultSet obj=nuevaCone.executeQuery("SELECT dv.id_dv,dv.cantidad,(cat.cat_nombre ||'-'||tea.tea_nombre)AS descripcion,"
              + "dv.vlor_validacion,((dv.cantidad)*(dv.vlor_validacion)) AS subtotal "
              + "FROM ventas.validacion_tiquetes va JOIN ventas.detalle_validacion dv ON va.id_revalidacion=dv.id_validacion "
              + "JOIN inventario.especificacion_tiquete_prepago etp ON dv.id_etp=etp.etp_id "
              + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id JOIN inventario.tipo_eje_adicional tea ON etp.tea_id=tea.tea_id "
              + "WHERE va.id_revalidacion="+txt_id_validacion.getText()+" ORDER BY dv.id_dv");
        try {
            while (obj.next()) 
                  {
                  
                    Object [] datos = new Object[5];
                  
               
                    for (int i=0;i<5;i++)
                    {
                      datos[i] =obj.getObject(i+1);
                    }

                        modelo.addRow(datos);

                  }
            tableLineasVenta.setModel(modelo);
             nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
    //Muestra el detalle de forma de pago en la *tablePagosVenta*
     public void detalleTablaFormaPago()
    {
        ConexionBD nuevaCone=new ConexionBD();
        ResultSet obj=nuevaCone.executeQuery("SELECT pa.id_pa_va,fp.fp_descripcion,cta.cban_numero,cta.cban_banco, to_char(pa.pago_validacion,'999G999G999G999D99') "
                + "FROM ventas.validacion_tiquetes va JOIN ventas.pago_validacion pa ON va.id_revalidacion=pa.id_validacion "
                + "JOIN ventas.forma_de_pago fp ON pa.id_fp=fp.fp_id "
                + "JOIN ventas.cuenta_bancaria cta ON cta.cban_id=pa.id_ctaban "
                + "WHERE va.id_revalidacion="+txt_id_validacion.getText()+"");
        try {
            while (obj.next())
            {
                Object [] datos = new Object[5];
                 for (int i=0;i<5;i++)
                  {
                      datos[i] =obj.getObject(i+1);
                  }
                 modeloPago.addRow(datos);
                 
            }
            tablePagosVenta.setModel(modeloPago);
            nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Total venta dependencia
    public void totalValidacion()
    {
        ConexionBD nuevaCone=new ConexionBD();
        String total="";
        ResultSet obj=nuevaCone.executeQuery("SELECT to_char(SUM((dv.cantidad)*(dv.vlor_validacion)),'999G999G999G999D99') AS total "
                + "FROM ventas.validacion_tiquetes va JOIN ventas.detalle_validacion dv ON dv.id_validacion=va.id_revalidacion "
                + "WHERE va.id_revalidacion="+txt_id_validacion.getText()+"  ");
        try {
            while(obj.next())
            {
                total=obj.getString("total");
            }
            label_total.setText(total);
            nuevaCone.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    //Total Monto pagado
    public void totalMonto()
    {
        ConexionBD nuevaCone=new ConexionBD();
        ResultSet obj=nuevaCone.executeQuery("SELECT sum((dv.cantidad)*(dv.vlor_validacion)) AS total "
                + "FROM ventas.validacion_tiquetes va JOIN ventas.detalle_validacion dv ON dv.id_validacion=va.id_revalidacion "
                + "WHERE va.id_revalidacion="+txt_id_validacion.getText()+"");
        try {
            while(obj.next())
            {
                montoPagado=obj.getLong("total");
            }
           
            txt_monto.setText(String.valueOf(montoPagado));
            nuevaCone.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
