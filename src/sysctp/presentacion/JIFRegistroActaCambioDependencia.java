package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.ventas.CambioTiqueteDependencias;
import sysctp.dominio.ventas.Cancelacion_ExcedentesDepen;
import sysctp.dominio.ventas.DaoCambioTiqueteDependencias;
import sysctp.dominio.ventas.DaoCancelacionExcedentesDepen;
import sysctp.dominio.ventas.DaoDetalleTQEntregadosDepen;
import sysctp.dominio.ventas.DaoDetalleTQRecibidosDepen;
import sysctp.dominio.ventas.DetalleTiquetesEntregadosDepen;
import sysctp.dominio.ventas.DetalleTiquetesRecibidosDepen;
import sysctp.reporte.actaCambioDependencia.ReporteActaCambioDepe;

/**
 *
 * @author jarteaga
 */
public class JIFRegistroActaCambioDependencia extends javax.swing.JInternalFrame { 

    private ConexionBD nuevaCone =new ConexionBD();
    
    private long totalRecibidos=0, totalEntregados=0, diferencia=0, acta=0;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    public static MDIPrincipal principal;
    private DecimalFormat formateador = new DecimalFormat("###,###.##");
    private ReporteActaCambioDepe reporte;
    
   
    
    public static JTextField gettxtIDFormaPago() {
        return txt_fp;
    }

    public static void settxtIDFormaPago(int  id) {
        JIFRegistroActaCambioDependencia.txt_fp.setText(String.valueOf(id));
    }
    
     public static JTextField gettxtIDCtaBancaria() {
        return txt_idctaBan;
    }

    public static void settxtIDCtaBancaria(int  id) {
        JIFRegistroActaCambioDependencia.txt_idctaBan.setText(String.valueOf(id));
    }
   
  
    public JIFRegistroActaCambioDependencia() {
       
        initComponents();

       
        
        modelo= new DefaultTableModel(); 
        modelo2=new DefaultTableModel();
  
            //Consulta para traer el ultimo registro  y sumarle 1 
       ResultSet obj=nuevaCone.executeQuery("SELECT MAX(id_acta_consecutivo)+1 idacta FROM ventas.cambio_tiquete_dependencias");
        try {
            while(obj.next())
            {
                jtf_consecutivo.setText(String.valueOf(obj.getLong("idacta")));//Le asigna el consecutivo siguiente de orden compra al textfield
            }
            
            ResultSet obj1=nuevaCone.executeQuery("SELECT depe_descripcion FROM dependencias.dependencia ORDER BY depe_descripcion ASC ");//Consulta para traer las dependencias
        
             while(obj1.next())
             {
                cb_depen.addItem(obj1.getObject("depe_descripcion"));//Llena JCombobox con el nombre del centro de costos
             }
            
             ResultSet obj2=nuevaCone.executeQuery("SELECT MAX(id_can_exce)+1 AS id FROM ventas.cancelacion_excedente_dependencia ");
             
             while(obj2.next())
            {
                txt_id.setText(String.valueOf(obj2.getLong("id")));//Le asigna el consecutivo siguiente de orden compra al textfield
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        nuevaCone.desconectar();       
        
//         Modelo Recibidos
        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Vlor Unitario");    
        modelo.addColumn("Serial Del");
        modelo.addColumn("Serial Hasta");
        modelo.addColumn("SubTotal");
       
//        Modelo Entregados
        modelo2.addColumn("ID");
        modelo2.addColumn("Descripción");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Vlor Unitario");    
        modelo2.addColumn("Serial Del");
        modelo2.addColumn("Serial Hasta");
        modelo2.addColumn("SubTotal");
  
    }
    
    public static JTextField gettxtIDEspecificacion() {
        return txt_idesp;
    }

    public static void settxtIDEspecificacion(int  id) {
        JIFRegistroActaCambioDependencia.txt_idesp.setText(String.valueOf(id));
    }
    
     public static JTextField gettxtIDEspecificacion2() {
        return txt_idesp1;
    }

    public static void settxtIDEspecificacion2(int  id) {
        JIFRegistroActaCambioDependencia.txt_idesp1.setText(String.valueOf(id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        localeEditor1 = new com.toedter.components.LocaleEditor();
        JD_Especificacion1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_idesp = new javax.swing.JTextField();
        btn_etp1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_serial1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_serial2 = new javax.swing.JTextField();
        btn_guardar_recibidos = new javax.swing.JButton();
        btn_cancelar_recibidos = new javax.swing.JButton();
        rb_dv = new javax.swing.JRadioButton();
        rb_nv = new javax.swing.JRadioButton();
        JD_Especificacion2 = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_idesp1 = new javax.swing.JTextField();
        btn_etp2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_serial3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_serial4 = new javax.swing.JTextField();
        btn_guardar_enrtregados = new javax.swing.JButton();
        btn_cancelar_entregados = new javax.swing.JButton();
        JD_CancelacionExce = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_fp = new javax.swing.JTextField();
        btn_fp = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_idctaBan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_montoPagado = new javax.swing.JTextField();
        btn_ctaban = new javax.swing.JButton();
        btn_cancExce = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jtp_tab = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_consecutivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtf_apellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_cedula = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_ob = new javax.swing.JTextArea();
        jb_guardar = new javax.swing.JButton();
        cb_item_depen = new javax.swing.JComboBox();
        cb_depen = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btn_adicionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_recibidos = new javax.swing.JTable();
        jl_tr = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_entregados = new javax.swing.JTable();
        btn_adicionarEntregados = new javax.swing.JButton();
        btn_eliminarEntregados = new javax.swing.JButton();
        jl_te = new javax.swing.JLabel();
        jl_dfutd = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jB_salir = new javax.swing.JButton();

        JD_Especificacion1.setTitle("Especificación Tiquete Prepago");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("ID Especificación:");

        btn_etp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_etp1.setContentAreaFilled(false);
        btn_etp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etp1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Serial Inicial:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setText("Serial Final");

        btn_guardar_recibidos.setText("Aceptar");
        btn_guardar_recibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_recibidosActionPerformed(evt);
            }
        });

        btn_cancelar_recibidos.setText("Cancelar");
        btn_cancelar_recibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_recibidosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_dv);
        rb_dv.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_dv.setSelected(true);
        rb_dv.setText("Disponible Venta");

        buttonGroup1.add(rb_nv);
        rb_nv.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        rb_nv.setText("No disponible");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_guardar_recibidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancelar_recibidos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_idesp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_etp1))
                            .addComponent(txt_serial1)
                            .addComponent(txt_serial2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(rb_dv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_nv)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_idesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_etp1))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_serial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_dv)
                    .addComponent(rb_nv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_recibidos)
                    .addComponent(btn_guardar_recibidos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Especificacion1Layout = new javax.swing.GroupLayout(JD_Especificacion1.getContentPane());
        JD_Especificacion1.getContentPane().setLayout(JD_Especificacion1Layout);
        JD_Especificacion1Layout.setHorizontalGroup(
            JD_Especificacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Especificacion1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JD_Especificacion1Layout.setVerticalGroup(
            JD_Especificacion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Especificacion1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JD_Especificacion2.setTitle("Especificación Tiquete Prepago");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setText("ID Especificación:");

        btn_etp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_etp2.setContentAreaFilled(false);
        btn_etp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etp2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel14.setText("Serial Inicial:");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel15.setText("Serial Final");

        btn_guardar_enrtregados.setText("Aceptar");
        btn_guardar_enrtregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_enrtregadosActionPerformed(evt);
            }
        });

        btn_cancelar_entregados.setText("Cancelar");
        btn_cancelar_entregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_entregadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btn_guardar_enrtregados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancelar_entregados))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_idesp1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_etp2))
                    .addComponent(txt_serial3)
                    .addComponent(txt_serial4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_idesp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_etp2))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_serial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_serial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar_enrtregados)
                    .addComponent(btn_cancelar_entregados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Especificacion2Layout = new javax.swing.GroupLayout(JD_Especificacion2.getContentPane());
        JD_Especificacion2.getContentPane().setLayout(JD_Especificacion2Layout);
        JD_Especificacion2Layout.setHorizontalGroup(
            JD_Especificacion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Especificacion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_Especificacion2Layout.setVerticalGroup(
            JD_Especificacion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Especificacion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        JD_CancelacionExce.setTitle("Cancelación de Excedente");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("ID Forma de Pago:");

        btn_fp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_fp.setContentAreaFilled(false);
        btn_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fpActionPerformed(evt);
            }
        });

        jLabel18.setText("ID Cuenta Bancaria:");

        jLabel20.setText("Monto Pagado:$ ");

        txt_montoPagado.setEditable(false);

        btn_ctaban.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_ctaban.setContentAreaFilled(false);
        btn_ctaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctabanActionPerformed(evt);
            }
        });

        btn_cancExce.setText("Aceptar");
        btn_cancExce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancExceActionPerformed(evt);
            }
        });

        jLabel21.setText("ID Can. Exce.N°");

        txt_id.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancExce)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txt_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txt_idctaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btn_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_montoPagado)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txt_fp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_montoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ctaban, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txt_idctaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancExce)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_CancelacionExceLayout = new javax.swing.GroupLayout(JD_CancelacionExce.getContentPane());
        JD_CancelacionExce.getContentPane().setLayout(JD_CancelacionExceLayout);
        JD_CancelacionExceLayout.setHorizontalGroup(
            JD_CancelacionExceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_CancelacionExceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JD_CancelacionExceLayout.setVerticalGroup(
            JD_CancelacionExceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JD_CancelacionExceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("SYSCTP-Acta de Cambio - Dependencias");

        jtp_tab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtp_tab.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Consecutivo:");

        jtf_consecutivo.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Dependencia:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Persona quien Recibe el Acta");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Nombre:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Apellido:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Cédula:");

        jtf_cedula.setText("0");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Observaciones:");

        jta_ob.setColumns(20);
        jta_ob.setRows(5);
        jta_ob.setText("Ninguna Observación");
        jScrollPane1.setViewportView(jta_ob);

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        cb_item_depen.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N

        cb_depen.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        cb_depen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_depenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_guardar)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(jtf_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cb_depen, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_item_depen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_consecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_item_depen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_depen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtf_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jb_guardar)
                .addGap(36, 36, 36))
        );

        jtp_tab.addTab("Info. General del Acta", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionar.setToolTipText("Registrar");
        btn_adicionar.setBorderPainted(false);
        btn_adicionar.setContentAreaFilled(false);
        btn_adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jt_recibidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jt_recibidos);

        jl_tr.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jl_tr.setText("0,0");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Total Recibido: $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jl_tr, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_adicionar)
                    .addComponent(btn_eliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jl_tr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtp_tab.addTab("Tiquetes Recibidos", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jt_entregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jt_entregados);

        btn_adicionarEntregados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        btn_adicionarEntregados.setToolTipText("Registrar");
        btn_adicionarEntregados.setBorderPainted(false);
        btn_adicionarEntregados.setContentAreaFilled(false);
        btn_adicionarEntregados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_adicionarEntregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarEntregadosActionPerformed(evt);
            }
        });

        btn_eliminarEntregados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/delete.png"))); // NOI18N
        btn_eliminarEntregados.setToolTipText("Eliminar");
        btn_eliminarEntregados.setBorderPainted(false);
        btn_eliminarEntregados.setContentAreaFilled(false);
        btn_eliminarEntregados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminarEntregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarEntregadosActionPerformed(evt);
            }
        });

        jl_te.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jl_te.setText("0,0");

        jl_dfutd.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jl_dfutd.setText("0,0");
        jl_dfutd.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel17.setText("Total Entregado: $");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel19.setText("Diferencia A Favor UTDVVCC: $");

        jB_salir.setText("Terminar");
        jB_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jl_dfutd, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84)
                                        .addComponent(jl_te, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_adicionarEntregados, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_eliminarEntregados, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jB_salir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_adicionarEntregados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminarEntregados, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jl_te))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_dfutd)
                    .addComponent(jLabel19))
                .addGap(73, 73, 73)
                .addComponent(jB_salir)
                .addGap(260, 260, 260))
        );

        jtp_tab.addTab("Tiquetes Entregados", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtp_tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtp_tab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("static-access")
    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
           
                int id_usurio= MDIPrincipal.getSeccion();
                int id_item=0;
                ConexionBD nueva=new ConexionBD();
                CambioTiqueteDependencias ctdep=new CambioTiqueteDependencias();
                DaoCambioTiqueteDependencias daoctdep=new DaoCambioTiqueteDependencias();
                
                 if(cb_item_depen.getSelectedItem()!=null)
                {
                    try {
                            String item=cb_item_depen.getSelectedItem().toString();
                            ResultSet obj=nueva.executeQuery("SELECT id_item_depen FROM dependencias.item_dependencia WHERE item_depen_descrip='"+item+"'");
                
                            while(obj.next())
                            {
                                id_item=obj.getInt("id_item_depen");
                            }
                         } catch (SQLException ex) {
                            Logger.getLogger(JIFRegistroVentaDependencia.class.getName()).log(Level.SEVERE, null, ex);
                          }
                 } 
                 nueva.desconectar();
                ctdep.setFecha(new Date());
                ctdep.setDependencia(id_item);
                ctdep.setNombre(jtf_nombre.getText().toUpperCase());
                ctdep.setApellido(jtf_apellido.getText().toUpperCase());
                ctdep.setCedula(Long.parseLong(jtf_cedula.getText()));
                ctdep.setObservaciones(jta_ob.getText());
                ctdep.setId_usuario(id_usurio);

                daoctdep.guardar(ctdep);
                deshabilitar();
                
                acta=Long.parseLong(jtf_consecutivo.getText());
                
                jtf_consecutivo.setText(String.valueOf(daoctdep.getId_actaCambio()));
                
               

    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jB_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salirActionPerformed
        
        int opc=JOptionPane.showConfirmDialog(null, "Desea Concluir el acta de cambio?", "Aviso!", JOptionPane.YES_NO_OPTION);
        
        if(opc==JOptionPane.YES_OPTION)
        {  
            try {
                
                reporte=new ReporteActaCambioDepe();
                reporte.ejecutarReporte(Long.parseLong(jtf_consecutivo.getText()));
                cancelacionExcedente();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroActaCambioDependencia.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_jB_salirActionPerformed

    private void btn_adicionarEntregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarEntregadosActionPerformed
          JD_Especificacion2.pack();
          JD_Especificacion2.setLocationRelativeTo(null);
          JD_Especificacion2.setVisible(true);
          JD_Especificacion2.setResizable(false);
    }//GEN-LAST:event_btn_adicionarEntregadosActionPerformed

    private void btn_eliminarEntregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarEntregadosActionPerformed
        elimarRegistroTablaEntregados();
    }//GEN-LAST:event_btn_eliminarEntregadosActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        elimarRegistroTablaRecibios();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
          JD_Especificacion1.pack();
          JD_Especificacion1.setLocationRelativeTo(null);
          JD_Especificacion1.setVisible(true);
          JD_Especificacion1.setResizable(false);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_guardar_recibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_recibidosActionPerformed
        DetalleTiquetesRecibidosDepen detalle=new DetalleTiquetesRecibidosDepen();
        DaoDetalleTQRecibidosDepen daodtr=new DaoDetalleTQRecibidosDepen();
       
        
        detalle.setId_espe_tiquete(Integer.parseInt(txt_idesp.getText()));
        detalle.setSerial_inicial(Long.parseLong(txt_serial1.getText()));
        detalle.setSerial_final(Long.parseLong(txt_serial2.getText()));
        detalle.setId_actaCambio(Long.parseLong(jtf_consecutivo.getText()));
        
        daodtr.guardar(detalle);
        LimpiarJTabla();
        detalleTablaRecibidos();
        actualizartotalRecibidos();
        
         if(rb_dv.isSelected()==true)
        {
          nuevaCone.executeUpdateQuery("BEGIN;");
          nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+"");
          this.confirmarTransaccion();
        }else if(rb_nv.isSelected()==true)
        {
            nuevaCone.executeUpdateQuery("BEGIN;");
            nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+"");
            this.confirmarTransaccion();
        }
          nuevaCone.desconectar();
        
        txt_idesp.setText("");
        txt_serial1.setText("");
        txt_serial2.setText("");
        
        
    }//GEN-LAST:event_btn_guardar_recibidosActionPerformed

    private void btn_etp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etp1ActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);     
        jdETP.setLocation(700, 0);      
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_etp1ActionPerformed

    private void btn_etp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etp2ActionPerformed
        JDTablaEspecificacionTP jdETP=new JDTablaEspecificacionTP(new javax.swing.JFrame(), true);     
        jdETP.setLocation(700, 0);      
        jdETP.setVisible(true);
    }//GEN-LAST:event_btn_etp2ActionPerformed

    private void btn_cancelar_recibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_recibidosActionPerformed
        JD_Especificacion1.dispose();
    }//GEN-LAST:event_btn_cancelar_recibidosActionPerformed

    private void btn_cancelar_entregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_entregadosActionPerformed
        JD_Especificacion2.dispose();
    }//GEN-LAST:event_btn_cancelar_entregadosActionPerformed

    private void btn_guardar_enrtregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_enrtregadosActionPerformed
        DetalleTiquetesEntregadosDepen detalleTE=new DetalleTiquetesEntregadosDepen();
        DaoDetalleTQEntregadosDepen daoDetalleTE=new DaoDetalleTQEntregadosDepen();
      
        detalleTE.setId_espe_tiquete(Integer.parseInt(txt_idesp1.getText()));
        detalleTE.setSerial_inicial(Long.parseLong(txt_serial3.getText()));
        detalleTE.setSerial_final(Long.parseLong(txt_serial4.getText()));
        detalleTE.setId_actaCambio(Long.parseLong(jtf_consecutivo.getText()));
        
        daoDetalleTE.guardar(detalleTE);
        LimpiarJTabla2();
        detalleTablaEntregados();
        actualizarTotalEntregados();
      
        txt_idesp1.setText("");
        txt_serial3.setText("");
        txt_serial4.setText("");     
    }//GEN-LAST:event_btn_guardar_enrtregadosActionPerformed

    private void btn_cancExceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancExceActionPerformed
       Cancelacion_ExcedentesDepen canExce=new Cancelacion_ExcedentesDepen();
       DaoCancelacionExcedentesDepen daocanExce=new DaoCancelacionExcedentesDepen();
   
       
       canExce.setIdActaCambio(Long.parseLong(jtf_consecutivo.getText()));
       canExce.setId_formPago(Integer.parseInt(txt_fp.getText()));
       canExce.setCtaBan(Integer.parseInt(txt_idctaBan.getText()));
       canExce.setPa_monto(Long.parseLong(txt_montoPagado.getText()));
       
       String obse="Se cancela excedente por valor de $ "+ String.valueOf(diferencia)+ "Según Recibo de caja N° "+String.valueOf(txt_id.getText());
       
       daocanExce.registroCancelacionExcedente(canExce);
       nuevaCone.executeUpdateQuery("UPDATE ventas.cambio_tiquete_dependencias SET observaciones='"+obse+"' WHERE id_acta_consecutivo="+jtf_consecutivo.getText()+"");
       nuevaCone.desconectar();
            habilitar();
            LimpiarCampos lc= new LimpiarCampos();
            lc.limpiar(jPanel3);
            lc.limpiar(jPanel2);
            jl_te.setText("0,0");
            jl_tr.setText("0,0");
            jl_dfutd.setText("0,0");
            LimpiarJTabla();
            LimpiarJTabla2();
            JD_CancelacionExce.dispose();
            
            totalEntregados=0;
            totalRecibidos=0;
            diferencia=0;
            
            
    }//GEN-LAST:event_btn_cancExceActionPerformed

    private void btn_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fpActionPerformed
        jDTablaFormaPago fp=new jDTablaFormaPago(new javax.swing.JFrame(), true);     
        fp.setLocation(700, 0);      
        fp.setVisible(true);
    }//GEN-LAST:event_btn_fpActionPerformed

    private void btn_ctabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctabanActionPerformed
        jDTablaCuentaBancaria ctaban=new jDTablaCuentaBancaria(new javax.swing.JFrame(), true);     
        ctaban.setLocation(700, 0);      
        ctaban.setVisible(true);
    }//GEN-LAST:event_btn_ctabanActionPerformed

    private void cb_depenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_depenActionPerformed
          try
        {
            int id_depen=0;
            ConexionBD nueva=new ConexionBD();

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

            ResultSet obj2=nuevaCone.executeQuery("SELECT item_depen_descrip FROM dependencias.item_dependencia WHERE id_dependencia="+id_depen+" ORDER BY item_depen_descrip ASC ");

            while(obj2.next())
            {
                cb_item_depen.addItem(obj2.getObject("item_depen_descrip"));
            }
            nuevaCone.desconectar();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cb_depenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_CancelacionExce;
    private javax.swing.JDialog JD_Especificacion1;
    private javax.swing.JDialog JD_Especificacion2;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_adicionarEntregados;
    private javax.swing.JButton btn_cancExce;
    private javax.swing.JButton btn_cancelar_entregados;
    private javax.swing.JButton btn_cancelar_recibidos;
    private javax.swing.JButton btn_ctaban;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_eliminarEntregados;
    private javax.swing.JButton btn_etp1;
    private javax.swing.JButton btn_etp2;
    private javax.swing.JButton btn_fp;
    private javax.swing.JButton btn_guardar_enrtregados;
    private javax.swing.JButton btn_guardar_recibidos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_depen;
    private javax.swing.JComboBox cb_item_depen;
    private javax.swing.JButton jB_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JLabel jl_dfutd;
    private javax.swing.JLabel jl_te;
    private javax.swing.JLabel jl_tr;
    private javax.swing.JTable jt_entregados;
    private javax.swing.JTable jt_recibidos;
    private javax.swing.JTextArea jta_ob;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_cedula;
    private javax.swing.JTextField jtf_consecutivo;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTabbedPane jtp_tab;
    private com.toedter.components.LocaleEditor localeEditor1;
    private javax.swing.JRadioButton rb_dv;
    private javax.swing.JRadioButton rb_nv;
    public static javax.swing.JTextField txt_fp;
    private javax.swing.JTextField txt_id;
    public static javax.swing.JTextField txt_idctaBan;
    public static javax.swing.JTextField txt_idesp;
    public static javax.swing.JTextField txt_idesp1;
    private javax.swing.JTextField txt_montoPagado;
    private javax.swing.JTextField txt_serial1;
    private javax.swing.JTextField txt_serial2;
    private javax.swing.JTextField txt_serial3;
    private javax.swing.JTextField txt_serial4;
    // End of variables declaration//GEN-END:variables

public void detalleTablaRecibidos()
{
    try
        {
        ConexionBD nueva=new ConexionBD();
 
        ResultSet obj=nueva.executeQuery("SELECT dtr.id_detalle_recibido,(cat.cat_nombre ||''|| tea.tea_nombre)AS descripcion,(dtr.consecutivo_final - dtr.consecutivo_inicial+1) as cantidad,etp.etp_precio,dtr.consecutivo_inicial,dtr.consecutivo_final,SUM(dtr.consecutivo_final - dtr.consecutivo_inicial+1) *etp_precio AS subtotal FROM   "
                + "ventas.cambio_tiquete_dependencias ct JOIN ventas.detalle_recibidos_dependencias dtr ON dtr.id_actacambio=ct.id_acta_consecutivo "
                + "JOIN inventario.especificacion_tiquete_prepago etp  ON dtr.id_especificacion_tiquete=etp.etp_id "
                + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
                + "JOIN inventario.tipo_eje_adicional tea ON  tea.tea_id=etp.tea_id WHERE ct.id_acta_consecutivo='"+jtf_consecutivo.getText()+"'"
                + "GROUP BY dtr.id_detalle_recibido,cat.cat_nombre,tea.tea_nombre, cantidad,etp.etp_precio,dtr.consecutivo_inicial,dtr.consecutivo_final ORDER BY dtr.id_detalle_recibido ASC");
   
        while (obj.next()) 
        {
        
        Object [] datos = new Object[7];
     
        
        for (int i=0;i<7;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);

        }
         nueva.desconectar();
 
          jt_recibidos.setModel(modelo);
          
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }
}

public void detalleTablaEntregados()
{
    try
        {
        
        ConexionBD nueva=new ConexionBD();

        ResultSet obj=nueva.executeQuery("SELECT dte.id_detalle_entregado,(cat.cat_nombre ||''|| tea.tea_nombre)AS descripcion,(dte.consecutivo_final - dte.consecutivo_inicial+1) as cantidad,etp.etp_precio,dte.consecutivo_inicial,dte.consecutivo_final,SUM(dte.consecutivo_final - dte.consecutivo_inicial+1) * etp_precio AS subtotal FROM "
                + "ventas.cambio_tiquete_dependencias ct JOIN ventas.detalle_entregados_dependencia dte ON dte.id_actacambio=ct.id_acta_consecutivo "
                + "JOIN inventario.especificacion_tiquete_prepago etp ON dte.id_esp_tiquete=etp.etp_id "
                + "JOIN inventario.categoria cat ON etp.cat_id=cat.cat_id "
                + "JOIN inventario.tipo_eje_adicional tea ON  tea.tea_id=etp.tea_id WHERE ct.id_acta_consecutivo='"+jtf_consecutivo.getText()+"'"
                + "GROUP BY id_detalle_entregado,cat.cat_nombre,tea.tea_nombre,cantidad,etp.etp_precio,dte.consecutivo_inicial,dte.consecutivo_final ORDER BY dte.id_detalle_entregado ASC");

        while (obj.next()) 
        {
        
        Object [] datos = new Object[7];
   
        for (int i=0;i<7;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo2.addRow(datos);

        }
          nuevaCone.desconectar();
          jt_entregados.setModel(modelo2);
          
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        }

}

public void elimarRegistroTablaRecibios()
{
 
    //ConexionBD nueva=new ConexionBD();
    
    try
    {
        if(jt_recibidos.isRowSelected(jt_recibidos.getSelectedRow()))
        {

            int row = jt_recibidos.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
            nuevaCone.executeUpdateQuery("BEGIN;");
            nuevaCone.executeUpdateQuery("DELETE FROM ventas.detalle_recibidos_dependencias WHERE id_detalle_recibido="+modelo.getValueAt(row,0)+" AND id_actacambio='"+jtf_consecutivo.getText()+"'");
            this.confirmarTransaccion();
        }
         nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos  SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+modelo.getValueAt(row, 4)+" AND "+modelo.getValueAt(row, 5)+" ");
         int numRows = jt_recibidos.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
         }
     }
 
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminarlo."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nuevaCone.desconectar();
         actualizartotalRecibidos();

    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    
 }

public void elimarRegistroTablaEntregados()
{
 
    //ConexionBD nueva=new ConexionBD();

    try {
    
     if(jt_entregados.isRowSelected(jt_entregados.getSelectedRow()))
     {

        int row = jt_entregados.getSelectedRow();

        for(int i = 0; i < modelo2.getRowCount(); i++)
        {
           nuevaCone.executeUpdateQuery("DELETE FROM ventas.detalle_entregados_dependencia WHERE id_detalle_entregado= "+modelo2.getValueAt(row, 0)+" AND id_actacambio='"+jtf_consecutivo.getText()+"'");

        }
            nuevaCone.executeUpdateQuery("BEGIN;");
            nuevaCone.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+modelo2.getValueAt(row, 4)+" AND "+modelo2.getValueAt(row, 5)+" ");
            this.confirmarTransaccion();
            int numRows = jt_entregados.getSelectedRows().length;
         for(int i = 0; i < numRows ; i++ )
         {
            modelo2.removeRow(row);
         }
     }
     
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminarlo."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
        nuevaCone.desconectar();
        actualizarTotalEntregados();
        
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
      }
}

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

    public void actualizartotalRecibidos()
    {
        try
        {
            ConexionBD nueva=new ConexionBD();
           
     
         ResultSet obj=nueva.executeQuery("SELECT to_char(SUM((dr.consecutivo_final - dr.consecutivo_inicial +1) *(etp.etp_precio)),'999G999G999G999D99') AS total "
                 + "FROM ventas.detalle_recibidos_dependencias dr JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dr.id_especificacion_tiquete "
                 + "WHERE dr.id_actacambio="+jtf_consecutivo.getText()+"");
          while(obj.next())
          {
              
              jl_tr.setText(obj.getString("total"));
          }
          
          nueva.desconectar();
         }catch(Exception e)
         {
             System.out.println(e);
         } 
     }

    public void actualizarTotalEntregados()
    {
        try
        {
        
        ConexionBD nueva=new ConexionBD();

        ResultSet obj=nueva.executeQuery("SELECT to_char(SUM((de.consecutivo_final - de.consecutivo_inicial +1) *(etp.etp_precio)),'999G999G999G999D99') AS total "
                 + "FROM ventas.detalle_entregados_dependencia de JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=de.id_esp_tiquete "
                 + "WHERE de.id_actacambio="+jtf_consecutivo.getText()+"");          
        
          while(obj.next())
          
          {
              jl_te.setText(obj.getString("total"));
          }
 
          nueva.desconectar();
        }catch(SQLException | NumberFormatException e)
        {
            System.out.println(e);
        }
     }

    public void deshabilitar()
    {
        
        jtf_consecutivo.setEditable(false);
        jtf_cedula.setEditable(false);
        jtf_nombre.setEditable(false);
        jtf_apellido.setEditable(false);
        jta_ob.setEnabled(false);
        jb_guardar.setEnabled(false);
    }
    
     public void habilitar()
    {
        
        jtf_consecutivo.setEditable(true);
        jtf_cedula.setEditable(true);
        jtf_nombre.setEditable(true);
        jtf_apellido.setEditable(true);
        jta_ob.setEnabled(true);
        jb_guardar.setEnabled(true);
    }
  
      public void cancelacionExcedente() throws SQLException
      {
          ConexionBD nueva=new ConexionBD();
          
          ResultSet obj=nueva.executeQuery("SELECT SUM((dr.consecutivo_final - dr.consecutivo_inicial +1) *(etp.etp_precio)) AS total FROM ventas.detalle_recibidos_dependencias dr JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=dr.id_especificacion_tiquete WHERE dr.id_actacambio="+jtf_consecutivo.getText()+"");
      
          while(obj.next())
          {
              totalRecibidos=obj.getLong("total");
          }

          ResultSet obj2=nueva.executeQuery("SELECT SUM((de.consecutivo_final - de.consecutivo_inicial +1) *(etp.etp_precio)) AS total FROM ventas.detalle_entregados_dependencia de JOIN inventario.especificacion_tiquete_prepago etp ON etp.etp_id=de.id_esp_tiquete WHERE de.id_actacambio="+jtf_consecutivo.getText()+"");
      
          while(obj2.next())
          {
              totalEntregados=obj2.getLong("total");
          }
          
          diferencia=totalRecibidos-totalEntregados;
          jl_dfutd.setText(formateador.format(diferencia));
          
          nueva.executeUpdateQuery("UPDATE ventas.cambio_tiquete_dependencias SET diferencia="+diferencia+" WHERE id_acta_consecutivo="+jtf_consecutivo.getText()+"  ");
          nueva.desconectar();

          if(diferencia <  0)
          {
                 JD_CancelacionExce.pack();
                 JD_CancelacionExce.setLocationRelativeTo(null);
                 JD_CancelacionExce.setVisible(true);
                 JD_CancelacionExce.setResizable(false);
                 long monto= Math.abs(diferencia);
                 txt_montoPagado.setText(String.valueOf(monto));
          }
          else
          {
              JOptionPane.showMessageDialog(null,"Acta cambio concluida con exito!");
          }
      }
      
         public void confirmarTransaccion()
    {
        try
        {
            nuevaCone.executeUpdateQuery("COMMIT;");
        
            System.out.println("Pase por aqui");
            nuevaCone.desconectar();

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
            nuevaCone.executeUpdateQuery("ROLLBACK;");
            nuevaCone.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
}
