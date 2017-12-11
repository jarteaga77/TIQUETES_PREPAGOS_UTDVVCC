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
import sysctp.dominio.devolucion.Consignacion;
import sysctp.dominio.devolucion.DaoConsignacion;
import sysctp.dominio.devolucion.DaoDetalle_devolucion;
import sysctp.dominio.devolucion.DaoDevolucionDinero;
import sysctp.dominio.devolucion.Detalle_devolucion;
import sysctp.dominio.devolucion.Devolucion_dinero;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author jarteaga
 */
public class JIFDevolucionDinero extends javax.swing.JInternalFrame {

 private ConexionBD nueva=new ConexionBD();
 private DefaultTableModel modelo;
 private DefaultTableModel modeloCon;
 private long total;
 
    
    
    public JIFDevolucionDinero() {
        initComponents();
        modelo=new DefaultTableModel();
        modeloCon=new DefaultTableModel();
        
        
       //Consulta para traer el ultimo registro de y sumarle 1 
       ResultSet obj=nueva.executeQuery("SELECT MAX(id_devolucion_dinero)+1 AS id_devo FROM ventas.devolucion_dinero");
        try {
            while(obj.next())
            {
                txt_idDevolucion.setText(String.valueOf(obj.getLong("id_devo")));//Le asigna el consecutivo siguiente de orden compra al textfield
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.desconectar();
     
        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Serial Inicial");
        modelo.addColumn("Serial Final");
        modelo.addColumn("Cant.");
        modelo.addColumn("Vlor.Unitario");
        modelo.addColumn("Total Parcial");
        
        
        modeloCon.addColumn("ID");
        modeloCon.addColumn("Cuenta");
        modeloCon.addColumn("Banco");
        modeloCon.addColumn("Vlor. Consignado");
 
    }
    
     public static JTextField gettxtIDEspecificacion() {
        return txt_id_esp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFDevolucionDinero.txt_id_esp.setText(String.valueOf(id));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_LineaDevolucion = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_esp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_etp = new javax.swing.JButton();
        txt_serial_1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_serial_2 = new javax.swing.JTextField();
        btn_aceptar3 = new javax.swing.JButton();
        btn_cancelar_2 = new javax.swing.JButton();
        JD_Consignacion = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_cta_cliente = new javax.swing.JTextField();
        txt_banco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cb_tipo_cuenta = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txt_vlor_consignado = new javax.swing.JTextField();
        btn_aceptar_2 = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        dc_fecha = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idDevolucion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_recibo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_obse = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        cb_cliente = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txt_oficio_cliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_linea_devo = new javax.swing.JTable();
        btn_adicionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_con = new javax.swing.JTable();
        btn_adicionar_2 = new javax.swing.JButton();
        btn_eliminar_2 = new javax.swing.JButton();
        btn_aceptar_1 = new javax.swing.JButton();

        JD_LineaDevolucion.setTitle("Linea Devolución");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel6.setText("ID Especificación:");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("Serial Inicial:");

        btn_etp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_etp.setContentAreaFilled(false);
        btn_etp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etpActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel8.setText("Serial Final:");

        btn_aceptar3.setText("Aceptar");
        btn_aceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar3ActionPerformed(evt);
            }
        });

        btn_cancelar_2.setText("Cancelar");
        btn_cancelar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_id_esp, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_etp))
                    .addComponent(txt_serial_1)
                    .addComponent(txt_serial_2))
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(btn_aceptar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar_2)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_id_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_etp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_serial_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_serial_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar3)
                    .addComponent(btn_cancelar_2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_LineaDevolucionLayout = new javax.swing.GroupLayout(JD_LineaDevolucion.getContentPane());
        JD_LineaDevolucion.getContentPane().setLayout(JD_LineaDevolucionLayout);
        JD_LineaDevolucionLayout.setHorizontalGroup(
            JD_LineaDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_LineaDevolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_LineaDevolucionLayout.setVerticalGroup(
            JD_LineaDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_LineaDevolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JD_Consignacion.setTitle("Consignación");

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel9.setText("Cta Cliente:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel10.setText("Banco:");

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel11.setText("Tipo de Cuenta:");

        cb_tipo_cuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahorros", "Corriente" }));

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel12.setText("Vlor. Consignado: $");

        txt_vlor_consignado.setEditable(false);

        btn_aceptar_2.setText("Aceptar");
        btn_aceptar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_2ActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel13.setText("Fecha Consignación:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cta_cliente)
                            .addComponent(cb_tipo_cuenta, 0, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_banco, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txt_vlor_consignado))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(btn_aceptar_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_cta_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_tipo_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_vlor_consignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(dc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(61, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_aceptar_2)
                            .addComponent(btn_cancelar))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout JD_ConsignacionLayout = new javax.swing.GroupLayout(JD_Consignacion.getContentPane());
        JD_Consignacion.getContentPane().setLayout(JD_ConsignacionLayout);
        JD_ConsignacionLayout.setHorizontalGroup(
            JD_ConsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ConsignacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_ConsignacionLayout.setVerticalGroup(
            JD_ConsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ConsignacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP -  Devolución de Dinero");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Devolución Dinero:");

        txt_idDevolucion.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Recibo de Caja: ");

        txt_area_obse.setColumns(20);
        txt_area_obse.setRows(5);
        jScrollPane1.setViewportView(txt_area_obse);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Observaciones:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_idDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cliente:");

        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clienteKeyReleased(evt);
            }
        });

        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Oficio Cliente:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_oficio_cliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_oficio_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Linea Devolución"));

        tabla_linea_devo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_linea_devo);

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total $ 0,0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_adicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_total))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Consignación"));

        tabla_con.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabla_con);

        btn_adicionar_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionar_2ActionPerformed(evt);
            }
        });

        btn_eliminar_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar_2)
                    .addComponent(btn_adicionar_2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_adicionar_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_eliminar_2))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_aceptar_1.setText("Aceptar");
        btn_aceptar_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_aceptar_1)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_aceptar_1)
                .addContainerGap(14, Short.MAX_VALUE))
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
                
                ConexionBD conexion=new ConexionBD();
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=conexion.executeQuery("SELECT cli_nit FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                
                while(obj.next())
                {
                    nit=obj.getLong("cli_nit");
                    txt_cliente.setText("");
                    txt_cliente.setText(String.valueOf(nit));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void btn_aceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar3ActionPerformed
      
        try
        {
            
            Devolucion_dinero devo=new Devolucion_dinero();
            DaoDevolucionDinero daodevo=new DaoDevolucionDinero();
            
             Detalle_devolucion detalle=new Detalle_devolucion();
             DaoDetalle_devolucion daodetalle=new DaoDetalle_devolucion();
            
            ResultSet obj=nueva.executeQuery("SELECT id_devolucion_dinero FROM ventas.devolucion_dinero WHERE id_devolucion_dinero="+txt_idDevolucion.getText()+"");
            
            if(obj.next()==false)
            {

                int id_usurio= MDIPrincipal.getSeccion();
        
                long id_sede=0;
        
                devo.setRecibo_caja(Long.parseLong(txt_recibo.getText()));
                devo.setObservaciones(txt_area_obse.getText());
                devo.setOficio_cliente(txt_oficio_cliente.getText());
                devo.setFecha(new Date());
                devo.setId_usuario(id_usurio);
        
            if(cb_cliente.getSelectedItem()!=null)
            {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj1=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
            try {
                while(obj1.next())
               {
                   id_sede=obj1.getLong("id_cliente_sede");
               }
            } catch (SQLException ex) {
                Logger.getLogger(JIFDevolucionDinero.class.getName()).log(Level.SEVERE, null, ex);
            }
               devo.setSede(id_sede);
           }   
            daodevo.guardarDevolucion(devo);
            txt_idDevolucion.setText(String.valueOf(DaoDevolucionDinero.getID_devo()));
          
                //Detalle
       
               detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
               detalle.setSerial_inicial(Long.parseLong(txt_serial_1.getText()));
               detalle.setSerial_final(Long.parseLong(txt_serial_2.getText()));
               detalle.setId_devolucion(Long.parseLong(txt_idDevolucion.getText()));
               daodetalle.registroDetalle(detalle);
       
               LimpiarTablaDetalle();
               consultaDetalleTabla();
               sumatoriaTotales();

            }else
            {
               detalle.setId_etp(Integer.parseInt(txt_id_esp.getText()));
               detalle.setSerial_inicial(Long.parseLong(txt_serial_1.getText()));
               detalle.setSerial_final(Long.parseLong(txt_serial_2.getText()));
               detalle.setId_devolucion(Long.parseLong(txt_idDevolucion.getText()));
               daodetalle.registroDetalle(detalle);
       
               LimpiarTablaDetalle();
               consultaDetalleTabla();
               sumatoriaTotales();
            }
  
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
   
      
    }//GEN-LAST:event_btn_aceptar3ActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        JD_LineaDevolucion.pack();
        JD_LineaDevolucion.setLocationRelativeTo(null);
        JD_LineaDevolucion.setVisible(true);
        JD_LineaDevolucion.setResizable(false);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_etpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etpActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);        
        jdETP.setLocation(700, 0);       
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_etpActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
         try
        {
        
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_linea_devo.isRowSelected(tabla_linea_devo.getSelectedRow()))
        {

          int row = tabla_linea_devo.getSelectedRow();

          nueva.executeUpdateQuery("DELETE FROM ventas.detalle_devolucion  WHERE id_detalle_devolucion="+modelo.getValueAt(row,0)+" AND id_devolucion="+txt_idDevolucion.getText()+"");
          nueva.executeUpdateQuery("BEGIN");
          nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 2) +" AND "+modelo.getValueAt(row, 3) +" ");
          this.confirmarTransaccion();
         int numRows = tabla_linea_devo.getSelectedRows().length;
         
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

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_adicionar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionar_2ActionPerformed
       JD_Consignacion.pack();
       JD_Consignacion.setLocationRelativeTo(null);
       JD_Consignacion.setVisible(true);
       JD_Consignacion.setResizable(false);
    }//GEN-LAST:event_btn_adicionar_2ActionPerformed

    private void btn_aceptar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_2ActionPerformed
        Consignacion con=new Consignacion();
        DaoConsignacion daoCon=new DaoConsignacion();
        
        con.setCta_cliente(txt_cta_cliente.getText());
        con.setBanco_cliente(txt_banco.getText());
        con.setTipo_cta((String) cb_tipo_cuenta.getSelectedItem());
        con.setVlorconsignado(Long.parseLong(txt_vlor_consignado.getText()));
        con.setId_devolucion(Long.parseLong(txt_idDevolucion.getText()));
        con.setFecha_cons(dc_fecha.getDate());
     
        daoCon.registroConsignacion(con);
        
        LimpiarTablaPago();
        detalle_consignacion();
  
    }//GEN-LAST:event_btn_aceptar_2ActionPerformed

    private void btn_eliminar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_2ActionPerformed
         try
        {
         ConexionBD nuevaCone=new ConexionBD();
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_con.isRowSelected(tabla_con.getSelectedRow()))
        {
            
           int row = tabla_con.getSelectedRow();

           nuevaCone.executeUpdateQuery("DELETE FROM ventas.consignacion WHERE id_consignacion="+modelo.getValueAt(row,0)+" AND id_devolucion="+txt_idDevolucion.getText()+"");
        
           int numRows = tabla_con.getSelectedRows().length;
         
            for(int i = 0; i < numRows ; i++ )
            {
                modeloCon.removeRow(row);
            }
           //System.out.println("Paso por aqui");
        } 
        else
        {
          JOptionPane.showMessageDialog(this,"Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
        }
          nuevaCone.desconectar();
          LimpiarTablaPago();
          detalle_consignacion();

    }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btn_eliminar_2ActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_Consignacion.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_cancelar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_2ActionPerformed
        JD_LineaDevolucion.dispose();
    }//GEN-LAST:event_btn_cancelar_2ActionPerformed

    private void btn_aceptar_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_1ActionPerformed
        
         if(tabla_linea_devo.getRowCount()== 0 && tabla_linea_devo.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Detalle devolución no tiene items!");
            
        }
        else if(tabla_con.getRowCount()== 0 && tabla_con.getSelectedRow()==-1)
        {
           JOptionPane.showMessageDialog(null, "La tabla Consignación no tiene items!");

        }
         else
        {
            dispose(); 
        }
  
    }//GEN-LAST:event_btn_aceptar_1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Consignacion;
    private javax.swing.JDialog JD_LineaDevolucion;
    private javax.swing.JButton btn_aceptar3;
    private javax.swing.JButton btn_aceptar_1;
    private javax.swing.JButton btn_aceptar_2;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_adicionar_2;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar_2;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_eliminar_2;
    private javax.swing.JButton btn_etp;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JComboBox cb_tipo_cuenta;
    private com.toedter.calendar.JDateChooser dc_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_con;
    private javax.swing.JTable tabla_linea_devo;
    private javax.swing.JTextArea txt_area_obse;
    private javax.swing.JTextField txt_banco;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_cta_cliente;
    private javax.swing.JTextField txt_idDevolucion;
    public static javax.swing.JTextField txt_id_esp;
    private javax.swing.JTextField txt_oficio_cliente;
    private javax.swing.JTextField txt_recibo;
    private javax.swing.JTextField txt_serial_1;
    private javax.swing.JTextField txt_serial_2;
    private javax.swing.JTextField txt_vlor_consignado;
    // End of variables declaration//GEN-END:variables
     //Buscar cliente
    public void buscarCliente() throws SQLException
    {
       
            ConexionBD conexion=new ConexionBD();
            
            ResultSet obj=conexion.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion ilike '%"+txt_cliente.getText().toUpperCase()+"%' ORDER BY sede_descripcion");
            
            while(obj.next())
            {
                cb_cliente.addItem(obj.getObject("sede_descripcion"));
            }
            conexion.desconectar();
    }
  
     public void LimpiarTablaDetalle()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);    
        }
    }
  
   public void LimpiarTablaPago()
    {
        for(int i=modeloCon.getRowCount()-1;i>=0;i--)
        {
            modeloCon.removeRow(i);  
        }
    }
   
    public void consultaDetalleTabla()
    {
      ConexionBD nuevaCone=new ConexionBD();
      ResultSet obj=nuevaCone.executeQuery("SELECT det.id_detalle_devolucion,"
              + "(cat.cat_nombre ||'-'|| tea.tea_nombre) AS descripcion, det.serial_inicial,det.serial_final,"
              + "(det.serial_final - det.serial_inicial +1)AS cantidad,"
              + "etp.etp_precio, (det.serial_final - det.serial_inicial +1)*(etp.etp_precio) As subtotal "
              + "FROM ventas.detalle_devolucion det JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=det.id_etp "
              + "JOIN inventario.categoria cat ON cat.cat_id=etp.cat_id "
              + "JOIN inventario.tipo_eje_adicional tea ON tea.tea_id=etp.tea_id "
              + "WHERE det.id_devolucion="+txt_idDevolucion.getText()+"  ORDER BY det.id_detalle_devolucion ASC");
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
            tabla_linea_devo.setModel(modelo);
             nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    public void detalle_consignacion()
    {
         ConexionBD nuevaCone=new ConexionBD();
      ResultSet obj=nuevaCone.executeQuery("SELECT id_consignacion,cta_cliente,banco_cliente,to_char(vlor_cosnginado,'999G999G999G999D99') "
              + "FROM ventas.consignacion WHERE id_devolucion="+txt_idDevolucion.getText()+"");
        try {
            while (obj.next()) 
                  {
                  
                    Object [] datos = new Object[4];
                  
               
                    for (int i=0;i<4;i++)
                    {
                      datos[i] =obj.getObject(i+1);
                    }

                        modeloCon.addRow(datos);
                  }
            tabla_con.setModel(modeloCon);
             nuevaCone.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void totalConsignacion()
//    {
//        DecimalFormat formateador = new DecimalFormat("###,###.##");
//        
//        ConexionBD nuevaCone=new ConexionBD();
//        
//        ResultSet obj=nuevaCone.executeQuery("SELECT SUM((devo.serial_final - devo.serial_inicial + 1)*(etp.etp_precio)) AS total FROM ventas.detalle_devolucion devo JOIN inventario.especificacion_tiquete_prepago etp ON devo.id_etp=etp.etp_id WHERE devo.id_devolucion="+txt_idDevolucion.getText()+" ");
//        try {
//            while(obj.next())
//            {
//                total=obj.getLong("total");
//            }
//            label_total.setText(formateador.format(total));
//            txt_vlor_consignado.setText(String.valueOf(total));
//            nuevaCone.desconectar();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
         public void confirmarTransaccion()
        {
        try
        {
            nueva.executeUpdateQuery("COMMIT");
        
            System.out.println("Pase por aqui");

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
            nueva.executeUpdateQuery("ROLLBACK");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
      public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total Con. $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tabla_linea_devo.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tabla_linea_devo.getValueAt(i,6)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          txt_vlor_consignado.setText(String.valueOf(sum_total));
          
        }
        
       
    }

}
