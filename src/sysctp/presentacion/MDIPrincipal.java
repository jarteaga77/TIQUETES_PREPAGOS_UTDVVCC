/*
 * MDIPrincipal.java
 *
 * Created on 14 de junio de 2008, 11:14 AM
 */

package sysctp.presentacion;

import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.Empresa;
import sysctp.servicios.gestion_persistencia.CacheDosNiveles;
import sysctp.servicios.gestion_persistencia.CacheElementosAbstractaLRU;
/**
 *
 * @author  UTDVVCC
 */
public class MDIPrincipal extends javax.swing.JFrame {

    private JIFRegUsuario jifRU;
    private JIFEspecificacionTP jifETP;
    private JIFConsecutivos jifcon;
    private JIFRegistroActaCambio jifCamTQT;
    private JIFGenerarReporteActaCambio jifacta;
    private JIFGenerarReciboVenta jifrecibo;
    private JIFEstadoTiquetes jifestadoTiquetes;
    private JIFRegistroVenta jifVenta;
    private JIFCliente_sedes jifsedes;
    private JIF_Cliente jifcliente;
    private JIFEdicionVentaParcial edicionVenta;
    private JIFAnulacionTiquetes anulacionTiquetes;
    private JIFRemisionTiqueteria remision;
    private JIFImprimirRemision imprimirRemision;
    private JIFInformeVentaClientes informeClientes;
    private JIFAnulacion_RecibosCaja anulacionRecibo;
    private JIFInformeReciboCajasAnulados informeRecibosAnulados;
    private JIFRegistroVentaDependencia ventaDepen;
    private JIFInformeVentaPeajes infoVenPeajes;
    private JIFImprimirVentaDepen imprimirVentaDep;
    private JIFInformeVentaDependencias infoVenDepe;
    private JIFValidacionTiquetes validacionTiquetes;
    private JIFImprimirValidacionTiquetesClientes imprimirValidacion;
    private JIFRegistroActaCambioDependencia cambioDependencia;
    private JIFReporteActaCambioDepe actaDependencia;
    private JIFValidacionTiquetesDepe validacionDepe;
    private JIFImprimirValidacionTiquetesDepe imprimirValiDepe;
    private JIFReciboExcedente reciboExce;
    private JIFReciboExcedenteDepe reciboExceDepe;
    private JIFInformeCanExcedente informeExcedentes;
    private JIFInformeValidaciones infoValidaciones;
    private JIFReporteVentasCliente reporteVentaCliente;
    private JIFArqueoCategoria arqueoCategoria;
    private JIFReporteTiqAnulados reportetiqAnulados;
    private JIFReporteRemisionPeajes reporteRemision; 
    //private ReporteArqueoGeneral reporte;
    private JIFConsultaTiquetesVendidos consultaTiquetes;
    private JIFReporteActasCambio reporteActas;
    private JIFInformacionClientes infoClientes;
    private JIFDevolucionDinero devoDinero;
    private JIFReportDevolucionDinero reporteDevolucion;
    private JIFArqueoGeneral arqueogeneral;
    private JIFRegEntregaTiqPeajes regentrega;
    private JIFImprimirRemisionDePeajes imprimirRem;
    private JIFRestaurarTiquetes restaurarTiq;
  
    private static int seccion;

   
    private JFAdministradorCategorias frameAdministradorCategorias = null;
    private JFAdministradorTiposEjeAdicional frameAdministradorTiposEjeAdicional = null;
    private Empresa empresa;
    private ConexionBD nuevaCone;
    
    
    /** Creates new form MDIPrincipal */
    public MDIPrincipal() {
        initComponents();
        desktopPane.setBorder(new Imagenfondo());
        enableComponents(false);
        empresa = new Empresa();
        //reporte=new ReporteArqueoGeneral();
        
         nuevaCone=new ConexionBD();
        
        //Se carga todos los usuarios del sistema al jComboBox 
        
            ResultSet obj=nuevaCone.executeQuery("SELECT usuario FROM tbusuario ORDER BY usuario ASC");
        try {            
            while(obj.next())
            {
                cb_usuario.addItem(obj.getObject("usuario"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());       
        }
            nuevaCone.desconectar();
        
         
     }
    @SuppressWarnings("unchecked")
    @Override
    public Image getIconImage() 
      {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("sysctp/presentacion/recursos/icono.png"));
        return retValue;
    }

    
    //get Seccion para obtener la cedula del usuario del sistema
     public static int getSeccion() {
        return MDIPrincipal.seccion;
    }

     //Set statico para mantener vigente la cedula del usuario del sistema
    public static void setSeccion(int seccion) {
        MDIPrincipal.seccion = seccion;
    }
    
    private void enableComponents(boolean bool){
//            conectarDataBaseMenuItem.setEnabled(!bool);
//            registrarVentaMenuItem.setEnabled(bool);
//            desinstalarMenuItem.setEnabled(bool);
//            intalacionMenuItem.setEnabled(bool);
//            recepcionMenuItem.setEnabled(bool);
//            registrarDatosPeajeMenuItem.setEnabled(bool);
//            remisionSalidaMenuItem.setEnabled(bool);
//            sensoresMenuItem.setEnabled(bool);
//            calcularPisadasMenuItem.setEnabled(bool);
//            pisadasSensoresInstaladosMenuItem.setEnabled(bool);
//            RemisionesMenuItem.setEnabled(bool);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDLogueo = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jB_ingresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jpf_clave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jB_salir = new javax.swing.JButton();
        cb_usuario = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2=(Graphics2D)g.create();

                Rectangle clip=g2.getClipBounds();
                g2.setPaint(new GradientPaint(0.0f, 0.0f,Color.WHITE,0.0f,super.getHeight(),super.getBackground().darker()));
                g2.fillRect(clip.x,clip.y,clip.width,clip.height);
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jB_venta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jB_acta = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jB_consecutivos = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMI_cerrar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        ventasMenu = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        registrarVentaMenuItem = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        administracionMenu = new javax.swing.JMenu();
        menu_camEsTiq = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        categoriaMenuItem = new javax.swing.JMenuItem();
        tiposEjeAdicionalMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        menu_retiq = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        reportesMenu = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        menuItem_arqueoGeneral = new javax.swing.JMenuItem();
        menuItem_arqueCat = new javax.swing.JMenuItem();
        configuracionesMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        configuracionAdaptadoresMenuItem = new javax.swing.JMenuItem();
        configuracionDataBaseMenuItem = new javax.swing.JMenuItem();
        verCacheEspecificacionesTiquete = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        JDLogueo.setUndecorated(true);
        JDLogueo.setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(65, 238, 232));

        jPanel1.setBackground(new java.awt.Color(65, 238, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(65, 238, 232));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jB_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/ingresar.png"))); // NOI18N
        jB_ingresar.setToolTipText("Ingresar");
        jB_ingresar.setBorder(null);
        jB_ingresar.setBorderPainted(false);
        jB_ingresar.setContentAreaFilled(false);
        jB_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_ingresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/IngresarR.png"))); // NOI18N
        jB_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ingresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Contraseña:");

        jpf_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_claveKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Usuario:");

        jB_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/salirS.png"))); // NOI18N
        jB_salir.setToolTipText("Salir");
        jB_salir.setBorder(null);
        jB_salir.setBorderPainted(false);
        jB_salir.setContentAreaFilled(false);
        jB_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/salirSR.png"))); // NOI18N
        jB_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpf_clave, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(cb_usuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jB_ingresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jB_salir)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpf_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_ingresar)
                    .addComponent(jB_salir))
                .addGap(21, 21, 21))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/login_manager.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SYSCTP", jPanel1);

        javax.swing.GroupLayout JDLogueoLayout = new javax.swing.GroupLayout(JDLogueo.getContentPane());
        JDLogueo.getContentPane().setLayout(JDLogueoLayout);
        JDLogueoLayout.setHorizontalGroup(
            JDLogueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        JDLogueoLayout.setVerticalGroup(
            JDLogueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDLogueoLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuItem9.setText("jMenuItem9");

        jMenuItem12.setText("jMenuItem12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control de Tiquetes Prepagos - UTDVVCC versión (1.0)");
        setIconImage(getIconImage());

        desktopPane.setBackground(new java.awt.Color(226, 226, 238));
        desktopPane.setAutoscrolls(true);

        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/cliente.png"))); // NOI18N
        jButton2.setText("Clientes");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);
        jToolBar2.add(jSeparator6);

        jB_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/venta_1.png"))); // NOI18N
        jB_venta.setText("Ventas");
        jB_venta.setToolTipText("Ventas");
        jB_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_venta.setFocusable(false);
        jB_venta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_venta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ventaActionPerformed(evt);
            }
        });
        jToolBar2.add(jB_venta);
        jToolBar2.add(jSeparator1);

        jB_acta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Venta.png"))); // NOI18N
        jB_acta.setText("Acta de Cambio");
        jB_acta.setToolTipText("Acta de Cambio");
        jB_acta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_acta.setFocusable(false);
        jB_acta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_acta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_acta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_actaActionPerformed(evt);
            }
        });
        jToolBar2.add(jB_acta);
        jToolBar2.add(jSeparator2);

        jB_consecutivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/ticket.png"))); // NOI18N
        jB_consecutivos.setText("Consecutivo de Tiquetes");
        jB_consecutivos.setToolTipText("Consecutivo de Tiquetes");
        jB_consecutivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_consecutivos.setFocusable(false);
        jB_consecutivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_consecutivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_consecutivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_consecutivosActionPerformed(evt);
            }
        });
        jToolBar2.add(jB_consecutivos);
        jToolBar2.add(jSeparator4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/printer.png"))); // NOI18N
        jButton1.setText("Imprimir Recibo de Venta");
        jButton1.setToolTipText("Imprimir Recibo de Venta");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);
        jToolBar2.add(jSeparator5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel3.setBounds(0, 0, 750, 100);
        desktopPane.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Archivo");

        jMI_cerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMI_cerrar.setText("Bloquear");
        jMI_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_cerrarActionPerformed(evt);
            }
        });
        jMenu1.add(jMI_cerrar);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menuBar.add(jMenu1);

        ventasMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/ventas.png"))); // NOI18N
        ventasMenu.setText("Ventas");

        jMenu7.setText("Venta");

        registrarVentaMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/registrar_venta.png"))); // NOI18N
        registrarVentaMenuItem.setText("Registrar Venta");
        registrarVentaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarVentaMenuItemActionPerformed(evt);
            }
        });
        jMenu7.add(registrarVentaMenuItem);

        jMenuItem11.setText("Imprimir Recibo Venta");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem16.setText("Edición Venta Parcial");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        ventasMenu.add(jMenu7);

        jMenu8.setText("Venta Dependencias Internas");

        jMenuItem24.setText("Venta dependencias");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem24);

        jMenuItem26.setText("Imprimir Ven.Depen.");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        ventasMenu.add(jMenu8);

        jMenu6.setText("Acta de cambio");

        jMenu12.setText("Clientes");

        jMenuItem8.setText("Acta de Cambio");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem8);

        jMenuItem10.setText("Imprimir");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem10);

        jMenuItem38.setText("Impri. Excedentes ");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem38);

        jMenu6.add(jMenu12);

        jMenu13.setText("Dependencias");

        jMenuItem32.setText("Acta de cambio");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem32);

        jMenuItem33.setText("Imprimir");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem33);

        jMenuItem39.setText("Impri. Excedente");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem39);

        jMenu6.add(jMenu13);

        ventasMenu.add(jMenu6);

        jMenu4.setText("Remisión Tiqueteria");

        jMenuItem18.setText("Remisión Tiqueteria");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuItem19.setText("Imprimir Remisión");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);

        ventasMenu.add(jMenu4);

        jMenu9.setText("Validación Tiquetes");

        jMenu10.setText("Clientes");

        jMenuItem28.setText("Validación Tiquetes Clie.");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem28);

        jMenuItem29.setText("Imprimir");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem29);

        jMenu9.add(jMenu10);

        jMenu11.setText("Dependencias");

        jMenuItem30.setText("Validación de Tiquetes Depe.");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem30);

        jMenuItem31.setText("Imprimir");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem31);

        jMenu9.add(jMenu11);

        ventasMenu.add(jMenu9);

        jMenuItem21.setText("Anulación Recibo de caja");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        ventasMenu.add(jMenuItem21);

        jMenu17.setText("Devolución de Dinero");

        jMenuItem34.setText("Devolución de Dinero");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem34);

        jMenuItem42.setText("Reporte");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem42);

        ventasMenu.add(jMenu17);

        jMenu18.setText("Entrada Tiquetes de Peajes");

        jMenuItem43.setText("Reg. Entrada de Tiquetes");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem43);

        jMenuItem44.setText("Imprimir Entrada Tiquetes");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem44);

        ventasMenu.add(jMenu18);

        menuBar.add(ventasMenu);

        administracionMenu.setText("Edición");

        menu_camEsTiq.setText("Tiquetes Prepagos");

        jMenuItem7.setText("Consecutivos de Tiquete");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(jMenuItem7);

        categoriaMenuItem.setText("Categorias...");
        categoriaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaMenuItemActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(categoriaMenuItem);

        tiposEjeAdicionalMenuItem.setText("Tipos de Eje Adicional...");
        tiposEjeAdicionalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposEjeAdicionalMenuItemActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(tiposEjeAdicionalMenuItem);

        jMenuItem4.setText("Tiquete Prepago");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(jMenuItem4);

        jMenuItem17.setText("Anulación de Tiquetes");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(jMenuItem17);

        menu_retiq.setText("Cambio de Estado de Tiquetes");
        menu_retiq.setEnabled(false);
        menu_retiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_retiqActionPerformed(evt);
            }
        });
        menu_camEsTiq.add(menu_retiq);

        administracionMenu.add(menu_camEsTiq);

        jMenu2.setText("Clientes");

        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem15.setText("Sede/Dependencia");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        administracionMenu.add(jMenu2);

        menuBar.add(administracionMenu);

        reportesMenu.setText("Reportes");

        jMenu14.setText("Consultas");

        jMenuItem14.setText("Estado de Tiquetes");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem14);

        jMenuItem13.setText("Consulta Tiquetes");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem13);

        jMenuItem41.setText("Clientes");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem41);

        reportesMenu.add(jMenu14);

        jMenu16.setText("Reportes");

        jMenuItem37.setText(" Actas de Cambio");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem37);

        jMenuItem6.setText(" Ventas Clientes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem6);

        jMenuItem36.setText("Remisión Peajes");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem36);

        jMenuItem35.setText("Tiquetes Anulados");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem35);

        reportesMenu.add(jMenu16);

        jMenu5.setText("Informes");

        jMenuItem20.setText("Venta a Clientes");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        jMenuItem25.setText("Venta a Peajes");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem25);

        jMenuItem27.setText("Venta Dependencias");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem27);

        jMenuItem22.setText("Cancelación de Excedentes");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenuItem40.setText("Validación Tiquetes");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem40);

        jMenuItem23.setText("Anulación Recibo de caja");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        reportesMenu.add(jMenu5);

        menuBar.add(reportesMenu);

        jMenu15.setText("Arqueo");

        menuItem_arqueoGeneral.setText("Arqueo - General");
        menuItem_arqueoGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_arqueoGeneralActionPerformed(evt);
            }
        });
        jMenu15.add(menuItem_arqueoGeneral);

        menuItem_arqueCat.setText("Arqueo-Categorias");
        menuItem_arqueCat.setEnabled(false);
        menuItem_arqueCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_arqueCatActionPerformed(evt);
            }
        });
        jMenu15.add(menuItem_arqueCat);

        menuBar.add(jMenu15);

        configuracionesMenu.setText("Configuraciones");

        jMenuItem5.setText("Usuario del Sistema");
        jMenuItem5.setEnabled(false);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        configuracionesMenu.add(jMenuItem5);

        configuracionAdaptadoresMenuItem.setText("Configuración Adaptadores...");
        configuracionAdaptadoresMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionAdaptadoresMenuItemActionPerformed(evt);
            }
        });
        configuracionesMenu.add(configuracionAdaptadoresMenuItem);

        configuracionDataBaseMenuItem.setText("Configuración del Servidor de Base de Datos");
        configuracionDataBaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionDataBaseMenuItemActionPerformed(evt);
            }
        });
        configuracionesMenu.add(configuracionDataBaseMenuItem);

        verCacheEspecificacionesTiquete.setText("Visor Cache Especificaciones Tiquete en Memoria");
        verCacheEspecificacionesTiquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCacheEspecificacionesTiqueteActionPerformed(evt);
            }
        });
        configuracionesMenu.add(verCacheEspecificacionesTiquete);

        jMenuItem1.setText("Visor Cache Especificaciones Tiquete en Disco");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        configuracionesMenu.add(jMenuItem1);

        menuBar.add(configuracionesMenu);

        helpMenu.setText("Ayuda");

        contentMenuItem.setText("Contenido");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setText("Acerca de...");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void registrarVentaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarVentaMenuItemActionPerformed
        if(estacerrado(jifVenta))
      {
       jifVenta=new JIFRegistroVenta(empresa);
       desktopPane.add(jifVenta);
       jifVenta.setLocation(200, 0);
       jifVenta.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
}//GEN-LAST:event_registrarVentaMenuItemActionPerformed

private void configuracionAdaptadoresMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionAdaptadoresMenuItemActionPerformed
//    ConfigurarAdaptadoresInternalFrame frame=new ConfigurarAdaptadoresInternalFrame();
//    desktopPane.add(frame);
//    frame.setVisible(true);
}//GEN-LAST:event_configuracionAdaptadoresMenuItemActionPerformed

private void configuracionDataBaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionDataBaseMenuItemActionPerformed
//    ConfigurarServidorDataBaseInternalFrame frame=new ConfigurarServidorDataBaseInternalFrame();
//    desktopPane.add(frame);
//    frame.setVisible(true);
}//GEN-LAST:event_configuracionDataBaseMenuItemActionPerformed

private void verCacheEspecificacionesTiqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCacheEspecificacionesTiqueteActionPerformed
    CacheDosNiveles cache2L= (CacheDosNiveles) empresa.getCatalogoTiquetesPrepago().getCache();
    CacheElementosAbstractaLRU cacheLRU = (CacheElementosAbstractaLRU) cache2L.getNivel_1();
    VisorCache frame = new VisorCache(cacheLRU);
    frame.setVisible(true);
}//GEN-LAST:event_verCacheEspecificacionesTiqueteActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    CacheDosNiveles cache2L= (CacheDosNiveles) empresa.getCatalogoTiquetesPrepago().getCache();
    CacheElementosAbstractaLRU cacheLRU = (CacheElementosAbstractaLRU) cache2L.getNivel_2();
    VisorCache frame = new VisorCache(cacheLRU);
    frame.setVisible(true);
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void categoriaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaMenuItemActionPerformed
    if (frameAdministradorCategorias == null){
        frameAdministradorCategorias = new JFAdministradorCategorias(empresa);
        frameAdministradorCategorias.setVisible(true);
    }{
        frameAdministradorCategorias.pack();
        frameAdministradorCategorias.setLocationRelativeTo(null);
        frameAdministradorCategorias.setVisible(true);
        
    }
}//GEN-LAST:event_categoriaMenuItemActionPerformed

private void tiposEjeAdicionalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposEjeAdicionalMenuItemActionPerformed
    if (frameAdministradorTiposEjeAdicional == null){
        frameAdministradorTiposEjeAdicional = new JFAdministradorTiposEjeAdicional(empresa);
        frameAdministradorTiposEjeAdicional.setVisible(true);
    }{
        frameAdministradorTiposEjeAdicional.pack();
        frameAdministradorTiposEjeAdicional.setLocationRelativeTo(null);
        frameAdministradorTiposEjeAdicional.setVisible(true);
    }
}//GEN-LAST:event_tiposEjeAdicionalMenuItemActionPerformed

    private void jB_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ingresarActionPerformed
        logueo();
    }//GEN-LAST:event_jB_ingresarActionPerformed

    private void jB_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_salirActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      if(estacerrado(jifRU))
      {
       jifRU=new JIFRegUsuario();
       desktopPane.add(jifRU);
       jifRU.setLocation(250, 0);
       jifRU.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         if(estacerrado(jifcliente))
      {
       jifcliente=new JIF_Cliente();
       desktopPane.add(jifcliente);
       jifcliente.setLocation(250, 150);
       jifcliente.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jpf_claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_claveKeyPressed
           if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            logueo();
        }
    }//GEN-LAST:event_jpf_claveKeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       if(estacerrado(jifETP))
      {
       jifETP=new JIFEspecificacionTP();
       desktopPane.add(jifETP);
       jifETP.setLocation(250, 150);
       jifETP.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       if(estacerrado(reporteVentaCliente))
      {
       reporteVentaCliente=new JIFReporteVentasCliente();
       desktopPane.add(reporteVentaCliente);
       reporteVentaCliente.setLocation(100, 100);
       reporteVentaCliente.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMI_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_cerrarActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_jMI_cerrarActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       if(estacerrado(jifcon))
      {
       jifcon=new JIFConsecutivos();
       desktopPane.add(jifcon);
       jifcon.setLocation(250, 150);
       jifcon.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
          if(estacerrado(jifCamTQT))
      {
       jifCamTQT=new JIFRegistroActaCambio();
       desktopPane.add(jifCamTQT);
       jifCamTQT.setLocation(150, 150);
       jifCamTQT.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
           if(estacerrado(jifacta))
      {
       jifacta=new JIFGenerarReporteActaCambio();
       desktopPane.add(jifacta);
       jifacta.setLocation(250, 150);
       jifacta.show();
       
       
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
         if(estacerrado(jifrecibo))
      {
       jifrecibo=new JIFGenerarReciboVenta();
       desktopPane.add(jifrecibo);
       jifrecibo.setLocation(250, 150);
       jifrecibo.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jB_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ventaActionPerformed
          if(estacerrado(jifVenta))
      {
       jifVenta=new JIFRegistroVenta(empresa);
       desktopPane.add(jifVenta);
       jifVenta.setLocation(200, 0);
       jifVenta.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jB_ventaActionPerformed

    private void jB_actaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_actaActionPerformed
         if(estacerrado(jifCamTQT))
      {
       jifCamTQT=new JIFRegistroActaCambio();
       desktopPane.add(jifCamTQT);
       jifCamTQT.setLocation(150, 150);
       jifCamTQT.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jB_actaActionPerformed

    private void jB_consecutivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_consecutivosActionPerformed
         if(estacerrado(jifcon))
      {
       jifcon=new JIFConsecutivos();
       desktopPane.add(jifcon);
       jifcon.setLocation(250, 150);
       jifcon.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jB_consecutivosActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
         if(estacerrado(jifestadoTiquetes))
      {
       jifestadoTiquetes=new JIFEstadoTiquetes();
       desktopPane.add(jifestadoTiquetes);
       jifestadoTiquetes.setLocation(250, 150);
       jifestadoTiquetes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(estacerrado(jifsedes))
      {
       jifsedes=new JIFCliente_sedes();
       desktopPane.add(jifsedes);
       jifsedes.setLocation(250, 150);
       jifsedes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if(estacerrado(jifsedes))
      {
       jifsedes=new JIFCliente_sedes();
       desktopPane.add(jifsedes);
       jifsedes.setLocation(250, 150);
       jifsedes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
          if(estacerrado(edicionVenta))
      {
       edicionVenta=new JIFEdicionVentaParcial();
       desktopPane.add(edicionVenta);
       edicionVenta.setLocation(250, 150);
       edicionVenta.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
          if(estacerrado(anulacionTiquetes))
      {
       anulacionTiquetes=new JIFAnulacionTiquetes();
       desktopPane.add(anulacionTiquetes);
       anulacionTiquetes.setLocation(250, 150);
       anulacionTiquetes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
       if(estacerrado(remision))
      {
       remision=new JIFRemisionTiqueteria();
       desktopPane.add(remision);
       remision.setLocation(250, 150);
       remision.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
           if(estacerrado(imprimirRemision))
      {
       imprimirRemision=new JIFImprimirRemision();
       desktopPane.add(imprimirRemision);
       imprimirRemision.setLocation(250, 150);
       imprimirRemision.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
      if(estacerrado(informeClientes))
      {
       informeClientes=new JIFInformeVentaClientes();
       desktopPane.add(informeClientes);
       informeClientes.setLocation(110, 100);
       informeClientes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
          if(estacerrado(anulacionRecibo))
      {
       anulacionRecibo=new JIFAnulacion_RecibosCaja();
       desktopPane.add(anulacionRecibo);
       anulacionRecibo.setLocation(370, 150);
       anulacionRecibo.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
         if(estacerrado(informeExcedentes))
      {
       informeExcedentes=new JIFInformeCanExcedente();
       desktopPane.add(informeExcedentes);
       informeExcedentes.setLocation(250, 100);
       informeExcedentes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        if(estacerrado(informeRecibosAnulados))
      {
       informeRecibosAnulados=new JIFInformeReciboCajasAnulados();
       desktopPane.add(informeRecibosAnulados);
       informeRecibosAnulados.setLocation(250, 100);
       informeRecibosAnulados.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if(estacerrado(ventaDepen))
      {
       ventaDepen=new JIFRegistroVentaDependencia();
       desktopPane.add(ventaDepen);
       ventaDepen.setLocation(200, 0);
       ventaDepen.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
           if(estacerrado(infoVenPeajes))
      {
       infoVenPeajes=new JIFInformeVentaPeajes();
       desktopPane.add(infoVenPeajes);
       infoVenPeajes.setLocation(110, 100);
       infoVenPeajes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      } 
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(estacerrado(jifrecibo))
        {
            jifrecibo=new JIFGenerarReciboVenta();
            desktopPane.add(jifrecibo);
            jifrecibo.setLocation(250, 150);
            jifrecibo.show();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
             if(estacerrado(imprimirVentaDep))
      {
       imprimirVentaDep=new JIFImprimirVentaDepen();
       desktopPane.add(imprimirVentaDep);
       imprimirVentaDep.setLocation(250, 150);
       imprimirVentaDep.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if(estacerrado(infoVenDepe))
      {
       infoVenDepe=new JIFInformeVentaDependencias();
       desktopPane.add(infoVenDepe);
       infoVenDepe.setLocation(250, 100);
       infoVenDepe.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      } 
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
       if(estacerrado(validacionTiquetes))
      {
       validacionTiquetes=new JIFValidacionTiquetes();
       desktopPane.add(validacionTiquetes);
       validacionTiquetes.setLocation(200, 0);
       validacionTiquetes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        if(estacerrado(imprimirValidacion))
      {
       imprimirValidacion=new JIFImprimirValidacionTiquetesClientes();
       desktopPane.add(imprimirValidacion);
       imprimirValidacion.setLocation(250, 150);
       imprimirValidacion.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
       if(estacerrado(cambioDependencia))
      {
       cambioDependencia=new JIFRegistroActaCambioDependencia();
       desktopPane.add(cambioDependencia);
       cambioDependencia.setLocation(150, 150);
       cambioDependencia.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
       if(estacerrado(actaDependencia))
      {
       actaDependencia=new JIFReporteActaCambioDepe();
       desktopPane.add(actaDependencia);
       actaDependencia.setLocation(150, 150);
       actaDependencia.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
          if(estacerrado(validacionDepe))
      {
       validacionDepe=new JIFValidacionTiquetesDepe();
       desktopPane.add(validacionDepe);
       validacionDepe.setLocation(200, 0);
       validacionDepe.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
          if(estacerrado(imprimirValiDepe))
      {
       imprimirValiDepe=new JIFImprimirValidacionTiquetesDepe();
       desktopPane.add(imprimirValiDepe);
       imprimirValiDepe.setLocation(250, 150);
       imprimirValiDepe.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        if(estacerrado(reciboExce))
      {
       reciboExce=new JIFReciboExcedente();
       desktopPane.add(reciboExce);
       reciboExce.setLocation(250, 150);
       reciboExce.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
       if(estacerrado(reciboExceDepe))
      {
       reciboExceDepe=new JIFReciboExcedenteDepe();
       desktopPane.add(reciboExceDepe);
       reciboExceDepe.setLocation(250, 150);
       reciboExceDepe.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        if(estacerrado(infoValidaciones))
      {
       infoValidaciones=new JIFInformeValidaciones();
       desktopPane.add(infoValidaciones);
       infoValidaciones.setLocation(250, 100);
       infoValidaciones.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void menuItem_arqueoGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_arqueoGeneralActionPerformed
//        TotalArqueoGeneral arqueoGeneral=new TotalArqueoGeneral();
//        ArqueoGeneral arqueo=new ArqueoGeneral();
//        Dao_Arqueo_General daoArqueo=new Dao_Arqueo_General();
//        
//        int idusuario=MDIPrincipal.getSeccion();
//        arqueo.setId_usuario(idusuario);
//        arqueo.setFecha_hora(new Date());
//        arqueo.setTotal_disponibles(arqueoGeneral.totaDisponibles());
//        arqueo.setTotal_inhabilitados(arqueoGeneral.totalAnulados());
//        arqueo.setTotal_remisionados(arqueoGeneral.totalRemision());
//        arqueo.setTotalSistema(arqueoGeneral.totalSistema());
//        arqueo.setTotal_vendidos(arqueoGeneral.totalVendidos());
//        
//        daoArqueo.registroArqueoGeneral(arqueo);
//        
//        reporte=new ReporteArqueoGeneral();
//        
//        reporte.ejecutarReporte();
        
        
       if(estacerrado(arqueogeneral))
      {
       arqueogeneral=new JIFArqueoGeneral();
       desktopPane.add(arqueogeneral);
       arqueogeneral.setLocation(250, 150);
       arqueogeneral.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
   
    }//GEN-LAST:event_menuItem_arqueoGeneralActionPerformed

    private void menuItem_arqueCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_arqueCatActionPerformed
      if(estacerrado(arqueoCategoria))
      {
       arqueoCategoria=new JIFArqueoCategoria();
       desktopPane.add(arqueoCategoria);
       arqueoCategoria.setLocation(250, 150);
       arqueoCategoria.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_menuItem_arqueCatActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
         if(estacerrado(reportetiqAnulados))
      {
       reportetiqAnulados=new JIFReporteTiqAnulados();
       desktopPane.add(reportetiqAnulados);
       reportetiqAnulados.setLocation(250, 100);
       reportetiqAnulados.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
      if(estacerrado(reporteRemision))
      {
       reporteRemision=new JIFReporteRemisionPeajes();
       desktopPane.add(reporteRemision);
       reporteRemision.setLocation(220, 100);
       reporteRemision.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       if(estacerrado(consultaTiquetes))
      {
       consultaTiquetes=new JIFConsultaTiquetesVendidos();
       desktopPane.add(consultaTiquetes);
       consultaTiquetes.setLocation(220, 100);
       consultaTiquetes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
       if(estacerrado(reporteActas))
      {
       reporteActas=new JIFReporteActasCambio();
       desktopPane.add(reporteActas);
       reporteActas.setLocation(220, 100);
       reporteActas.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        if(estacerrado(infoClientes))
      {
       infoClientes=new JIFInformacionClientes();
       desktopPane.add(infoClientes);
       infoClientes.setLocation(200, 100);
       infoClientes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
       if(estacerrado(devoDinero))
      {
       devoDinero=new JIFDevolucionDinero();
       desktopPane.add(devoDinero);
       devoDinero.setLocation(250, 100);
       devoDinero.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
      if(estacerrado(reporteDevolucion))
      {
       reporteDevolucion=new JIFReportDevolucionDinero();
       desktopPane.add(reporteDevolucion);
       reporteDevolucion.setLocation(250, 100);
       reporteDevolucion.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Sistema de Control Tiquetes Prepago! \n Desarrollado Por: \n - Jonathan Arteaga \n -James Payan \n E-mail: arteaga_jonathan@hotmail.com \n UTDVVCC");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
          if(estacerrado(regentrega))
      {
       regentrega=new JIFRegEntregaTiqPeajes();
       desktopPane.add(regentrega);
       regentrega.setLocation(200, 100);
       regentrega.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
           if(estacerrado(imprimirRem))
      {
       imprimirRem=new JIFImprimirRemisionDePeajes();
       desktopPane.add(imprimirRem);
       imprimirRem.setLocation(200, 100);
       imprimirRem.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void menu_retiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_retiqActionPerformed
        if(estacerrado(restaurarTiq))
      {
       restaurarTiq=new JIFRestaurarTiquetes();
       desktopPane.add(restaurarTiq);
       restaurarTiq.setLocation(200, 150);
       restaurarTiq.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_menu_retiqActionPerformed

   public static void main(String[] args) {

        try {
//          PropiedadesDelSistema.obtenerInscancia().cargarPropiedades(); // Carga las propiedades del sistema
//            MDIPrincipal principal = new MDIPrincipal(); // Inicializa la ventana con los menús de la aplicación
//            principal.setLocationRelativeTo(null);
//            principal.setVisible(false);//Frame Principal No arranca visible
//            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//Frame toma el tramaño de la resolución de la pantalla
//            principal.inicioSeccion(); // Hace visible la ventana
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;");
                    break;
       
                }
            }
            
       UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
            
             
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
         catch (Exception ex) {
            ex.printStackTrace(); // Registra en la salida de linea de comandos, si hay un error en la inicialización del sistema
        }
        
         SwingUtilities.invokeLater(new Runnable() {//Permite que el Frame no se congele
        

            public void run() {
                new Thread(new Splash()).start();
            }
        });
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JDLogueo;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu administracionMenu;
    private javax.swing.JMenuItem categoriaMenuItem;
    private javax.swing.JComboBox cb_usuario;
    private javax.swing.JMenuItem configuracionAdaptadoresMenuItem;
    private javax.swing.JMenuItem configuracionDataBaseMenuItem;
    private javax.swing.JMenu configuracionesMenu;
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jB_acta;
    private javax.swing.JButton jB_consecutivos;
    private javax.swing.JButton jB_ingresar;
    private javax.swing.JButton jB_salir;
    private javax.swing.JButton jB_venta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMI_cerrar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPasswordField jpf_clave;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_arqueCat;
    private javax.swing.JMenuItem menuItem_arqueoGeneral;
    private javax.swing.JMenu menu_camEsTiq;
    private javax.swing.JMenuItem menu_retiq;
    private javax.swing.JMenuItem registrarVentaMenuItem;
    private javax.swing.JMenu reportesMenu;
    private javax.swing.JMenuItem tiposEjeAdicionalMenuItem;
    private javax.swing.JMenu ventasMenu;
    private javax.swing.JMenuItem verCacheEspecificacionesTiquete;
    // End of variables declaration//GEN-END:variables

    //Inicio de la venta de dialogo para poder que el usuario se logue
    public void inicioSeccion()
    {
        JDLogueo.pack();
        JDLogueo.setLocationRelativeTo(null);
        JDLogueo.setVisible(true);
        JDLogueo.setResizable(false);
    }
    
    //Metodo para Validar al usuario (usuario y contraseña)
    public void logueo()
    {
        try
        {
            
           String usuario=cb_usuario.getSelectedItem().toString();
            ConexionBD nueva=new ConexionBD();
            ResultSet oResultSet=nueva.executeQuery("SELECT idusuario,usuario, clave,cedula FROM tbusuario WHERE usuario='"+usuario+"' AND clave= md5('"+String.valueOf(jpf_clave.getPassword())+"')");
    
         if(oResultSet.next()==true)
         {
           JDLogueo.dispose();
           jpf_clave.setText("");
           this.setVisible(true);
           
           //Se captura la cedula del usuario
           int id=oResultSet.getInt("cedula");
           String clave=oResultSet.getString("clave");
           int idusuario=oResultSet.getInt("idusuario");
           //System.out.println(id);
           //Se adiciona la cedula del usuario
           setSeccion(id);
           
           System.out.println(clave);
           
           if(idusuario==17)
           {
              // menuItem_arqueoGeneral.setEnabled(true);
               menuItem_arqueCat.setEnabled(true);
               menu_retiq.setEnabled(true);
               
           }
           nueva.desconectar();
          
         }
         else
         {
             
             jpf_clave.setText("");
             
             JOptionPane.showMessageDialog(null, "Usuario ó Contraseña innvalido,  \n Intentelo de nuevo!", "Error", JOptionPane.ERROR_MESSAGE);
             
         }
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private boolean estacerrado(Object obj){
        JInternalFrame[] activos=desktopPane.getAllFrames();
        boolean cerrado=true;
        int i=0;
        while (i<activos.length && cerrado){
            if(activos[i]==obj){
		cerrado=false;
            }
            i++;
        }
    return cerrado;
    }
    
     public void cerrarSesion()
 {
     this.setVisible(false);
     inicioSeccion();
    // menuItem_arqueoGeneral.setEnabled(false);
     menuItem_arqueCat.setEnabled(false);
     
 }
    
    
    
}