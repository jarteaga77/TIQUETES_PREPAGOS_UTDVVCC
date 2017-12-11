
package sysctp.presentacion;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.clientes.DaoSedes_clientes;
import sysctp.dominio.clientes.Sedes_clientes;

/**
 *
 * @author jarteaga
 */
public class JIFCliente_sedes extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFCliente
     */
    
    
    ConexionBD nueva=new ConexionBD();
    LimpiarCampos olimpiar=new LimpiarCampos(); 
    private JIF_Cliente jifCliente;
    private long nit;
    private long id_cliente_sede;
    
    public static MDIPrincipal principal;
    
    public JIFCliente_sedes() {
        initComponents();
        
        //Objeto jPanel encabezado con color personalizado
        Color c1 = new Color(66,111,166);
        Color c2 = new Color(102,174,118);
        JPColor jpmicolor = new JPColor(c1,c2);
        jpmicolor.setSize(this.getSize());        
        panel_encabezado.add(jpmicolor); 
  
        try
        {
            
            ResultSet obj=nueva.executeQuery("SELECT ciu_descripcion FROM municipio ORDER BY ciu_descripcion ");
            
            while(obj.next())
            {
                cb_ciudad.addItem(obj.getObject("ciu_descripcion"));
            }
   
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_encabezado = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_nit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_des = new javax.swing.JTextField();
        cb_cliente = new javax.swing.JComboBox();
        cb_ciudad = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tel1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tel2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_fax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        txt_id_sede = new javax.swing.JTextField();
        cb_descrip = new javax.swing.JComboBox();
        b_buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jB_guardar = new javax.swing.JButton();
        jB_actu = new javax.swing.JButton();
        jB_mod = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jB_salir = new javax.swing.JButton();
        jB_ingresar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sedes - Clientes");

        panel_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(253, 243, 243));
        jLabel8.setText("CLIENTES");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/cliente.png"))); // NOI18N

        javax.swing.GroupLayout panel_encabezadoLayout = new javax.swing.GroupLayout(panel_encabezado);
        panel_encabezado.setLayout(panel_encabezadoLayout);
        panel_encabezadoLayout.setHorizontalGroup(
            panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(348, 348, 348))
        );
        panel_encabezadoLayout.setVerticalGroup(
            panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_encabezadoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Cédula/Nit: ");

        jtf_nit.setToolTipText("Buscar Cliente ej: sena + shift");
        jtf_nit.setEnabled(false);
        jtf_nit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_nitKeyReleased(evt);
            }
        });

        jLabel2.setText("Descripción:");

        txt_des.setEnabled(false);

        cb_cliente.setEnabled(false);
        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });

        cb_ciudad.setEnabled(false);

        jLabel3.setText("Ciudad:");

        jLabel4.setText("Dirección:");

        txt_dir.setEnabled(false);

        jLabel5.setText("Tel 1:");

        txt_tel1.setEnabled(false);

        jLabel6.setText("Tel 2:");

        txt_tel2.setEnabled(false);

        jLabel9.setText("Fax:");

        txt_fax.setEnabled(false);

        jLabel10.setText("E-mail:");

        txt_mail.setText("@");
        txt_mail.setEnabled(false);

        txt_id_sede.setToolTipText("Buscar  sede + shift");
        txt_id_sede.setEnabled(false);
        txt_id_sede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_id_sedeKeyReleased(evt);
            }
        });

        cb_descrip.setEnabled(false);
        cb_descrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_descripActionPerformed(evt);
            }
        });

        b_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Buscar.png"))); // NOI18N
        b_buscar.setToolTipText("");
        b_buscar.setContentAreaFilled(false);
        b_buscar.setEnabled(false);
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_des, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(txt_dir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tel1)
                                    .addComponent(cb_ciudad, 0, 180, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fax, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)
                                .addComponent(txt_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_id_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_buscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txt_fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jB_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/save.png"))); // NOI18N
        jB_guardar.setToolTipText("Guardar");
        jB_guardar.setBorderPainted(false);
        jB_guardar.setContentAreaFilled(false);
        jB_guardar.setEnabled(false);
        jB_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_guardarActionPerformed(evt);
            }
        });

        jB_actu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/actualizar.png"))); // NOI18N
        jB_actu.setToolTipText("Actualizar");
        jB_actu.setBorderPainted(false);
        jB_actu.setContentAreaFilled(false);
        jB_actu.setEnabled(false);
        jB_actu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_actuActionPerformed(evt);
            }
        });

        jB_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/mod_detalle.png"))); // NOI18N
        jB_mod.setToolTipText("Modificar");
        jB_mod.setBorderPainted(false);
        jB_mod.setContentAreaFilled(false);
        jB_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_modActionPerformed(evt);
            }
        });

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/cancelar.png"))); // NOI18N
        jB_cancelar.setToolTipText("Cancelar");
        jB_cancelar.setBorderPainted(false);
        jB_cancelar.setContentAreaFilled(false);
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        jB_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/eqsl_exit.png"))); // NOI18N
        jB_salir.setBorderPainted(false);
        jB_salir.setContentAreaFilled(false);
        jB_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salirActionPerformed(evt);
            }
        });

        jB_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/ingresar_1.png"))); // NOI18N
        jB_ingresar.setToolTipText("Ingresar");
        jB_ingresar.setBorderPainted(false);
        jB_ingresar.setContentAreaFilled(false);
        jB_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ingresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jB_ingresar)
                .addGap(18, 18, 18)
                .addComponent(jB_guardar)
                .addGap(18, 18, 18)
                .addComponent(jB_mod)
                .addGap(18, 18, 18)
                .addComponent(jB_actu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_cancelar)
                .addGap(18, 18, 18)
                .addComponent(jB_salir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_guardar)
                    .addComponent(jB_mod)
                    .addComponent(jB_actu)
                    .addComponent(jB_cancelar)
                    .addComponent(jB_ingresar)
                    .addComponent(jB_salir))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ingresarActionPerformed
        jtf_nit.setEnabled(true);
        txt_des.setEnabled(true);
        cb_ciudad.setEnabled(true);
        cb_cliente.setEnabled(true);
        txt_dir.setEnabled(true);
        txt_tel1.setEnabled(true);
        txt_tel2.setEnabled(true);
        txt_fax.setEnabled(true);
        txt_mail.setEnabled(true);

        jB_ingresar.setEnabled(false);
        jB_guardar.setEnabled(true);
        jB_mod.setEnabled(false);
        jB_actu.setEnabled(false);
       
       
    }//GEN-LAST:event_jB_ingresarActionPerformed

    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed
        try
        {
            
             Sedes_clientes sedes=new Sedes_clientes();
             DaoSedes_clientes daosedes=new DaoSedes_clientes();
             int id_ciudad=0;
          
             ResultSet obj1=nueva.executeQuery("SELECT cli_nit FROM clientes.cliente where cli_nit="+jtf_nit.getText()+"");
             
             if(obj1.next()==true)
             {
             
                sedes.setNit_cliente(Long.parseLong(jtf_nit.getText()));
                sedes.setDescripcion(txt_des.getText());
                
                if(cb_ciudad.getSelectedItem()!=null)
                {
                String ciudad=cb_ciudad.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT ciu_id FROM municipio WHERE ciu_descripcion='"+ciudad+"'");
                
                while(obj.next())
                {
                    id_ciudad=obj.getInt(1);
                }
               }
                sedes.setId_ciudad(id_ciudad);
                sedes.setDir(txt_dir.getText().toUpperCase());
                sedes.setTel1(txt_tel1.getText());
                sedes.setTel2(txt_tel2.getText());
                sedes.setFax(txt_fax.getText());
                sedes.setMail(txt_mail.getText());
                
                daosedes.guardarDependencia(sedes);
          
                LimpiarCampos lc= new LimpiarCampos();
                lc.limpiar(jPanel2);
                confInicial();
                
                nueva.desconectar();
             }else
             {
               JOptionPane.showMessageDialog(null, "El cliente no esta registrado!", "Error", JOptionPane.ERROR_MESSAGE);
                jifCliente=new JIF_Cliente();
                MDIPrincipal.desktopPane.add(jifCliente);
                jifCliente.setLocation(250, 150);
                jifCliente.show();

             }
    
        } catch (SQLException ex) {
            Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
        }catch( NumberFormatException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_guardarActionPerformed

    private void jB_actuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_actuActionPerformed
   try
        {
            
             Sedes_clientes sedes=new Sedes_clientes();
             DaoSedes_clientes daosedes=new DaoSedes_clientes();
             int id_ciudad=0;
          
            
                sedes.setDescripcion(txt_des.getText());
                
                if(cb_ciudad.getSelectedItem()!=null)
                {
                String ciudad=cb_ciudad.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT ciu_id FROM municipio WHERE ciu_descripcion='"+ciudad+"'");
                
                while(obj.next())
                {
                    id_ciudad=obj.getInt(1);
                }
               }
                sedes.setId_ciudad(id_ciudad);
                sedes.setDir(txt_dir.getText().toUpperCase());
                sedes.setTel1(txt_tel1.getText());
                sedes.setTel2(txt_tel2.getText());
                sedes.setFax(txt_fax.getText());
                sedes.setMail(txt_mail.getText());
                
                daosedes.actualizarDependencia(sedes, Long.parseLong(txt_id_sede.getText()));
          
                LimpiarCampos lc= new LimpiarCampos();
                lc.limpiar(jPanel2);
                confInicial();
                
                nueva.desconectar();
           
    
        } catch (SQLException ex) {
            Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
        }catch( NumberFormatException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jB_actuActionPerformed

    private void jB_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_modActionPerformed
       
        txt_id_sede.setEnabled(true);
        cb_descrip.setEnabled(true);
        b_buscar.setEnabled(true);
        

    }//GEN-LAST:event_jB_modActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        confInicial();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    private void jB_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salirActionPerformed
        dispose();
    }//GEN-LAST:event_jB_salirActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        buscar();
    }//GEN-LAST:event_b_buscarActionPerformed

    private void jtf_nitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nitKeyReleased
       if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                cb_cliente.removeAllItems();
                buscarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtf_nitKeyReleased

    private void cb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteActionPerformed
        
            if(cb_cliente.getSelectedItem()!=null)
            {
            try {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT cli_nit FROM clientes.cliente WHERE cli_razon_social='"+nombre+"'");
                
                while(obj.next())
                {
                    nit=obj.getLong("cli_nit");
                    jtf_nit.setText("");
                    jtf_nit.setText(String.valueOf(nit));
                }
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void txt_id_sedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_sedeKeyReleased
        if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                cb_descrip.removeAllItems();
                buscarCliente_sede();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_id_sedeKeyReleased

    private void cb_descripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_descripActionPerformed
          if(cb_descrip.getSelectedItem()!=null)
            {
            try {
                String nombre=cb_descrip.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT id_cliente_sede FROM clientes.sedes_clientes WHERE sede_descripcion='"+nombre+"'");
                
                while(obj.next())
                {
                    id_cliente_sede=obj.getLong("id_cliente_sede");
                    txt_id_sede.setText("");
                    txt_id_sede.setText(String.valueOf(id_cliente_sede));
                }
                nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCliente_sedes.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
    }//GEN-LAST:event_cb_descripActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_buscar;
    private javax.swing.JComboBox cb_ciudad;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JComboBox cb_descrip;
    private javax.swing.JButton jB_actu;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JButton jB_ingresar;
    private javax.swing.JButton jB_mod;
    private javax.swing.JButton jB_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jtf_nit;
    private javax.swing.JPanel panel_encabezado;
    private javax.swing.JTextField txt_des;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_fax;
    private javax.swing.JTextField txt_id_sede;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_tel1;
    private javax.swing.JTextField txt_tel2;
    // End of variables declaration//GEN-END:variables

public void confInicial()
{    
    txt_id_sede.setEnabled(false);
    cb_descrip.setEnabled(false);
    b_buscar.setEnabled(false);
    jtf_nit.setEnabled(false);
    txt_des.setEnabled(false);
    cb_ciudad.setEnabled(false);
    cb_cliente.setEnabled(false);
    txt_dir.setEnabled(false);
    txt_tel1.setEnabled(false);
    txt_tel2.setEnabled(false);
    txt_fax.setEnabled(false);
    txt_mail.setEnabled(false);

    
    jB_ingresar.setEnabled(true);
    jB_guardar.setEnabled(false);
    jB_mod.setEnabled(true);
    jB_actu.setEnabled(false);
    olimpiar.limpiar(jPanel2);
}

public void buscar()
{
    try
    {
        Sedes_clientes sedes=new Sedes_clientes();
        
        ResultSet obj=nueva.executeQuery("SELECT sede_descripcion,cli_direccion,cli_telefono_1,cli_telefono_2,cli_fax,cli_email,cli_nit FROM clientes.sedes_clientes WHERE id_cliente_sede="+txt_id_sede.getText()+"");
        
        if(obj.next()==true)
        {
            sedes.setDescripcion(obj.getString("sede_descripcion"));
            sedes.setDir(obj.getString("cli_direccion"));
            sedes.setTel1(obj.getString("cli_telefono_1"));
            sedes.setNit_cliente(obj.getLong("cli_nit"));
            sedes.setTel1(obj.getString("cli_telefono_1"));
            sedes.setTel2(obj.getString("cli_telefono_2"));
            sedes.setFax(obj.getString("cli_fax"));
            sedes.setMail(obj.getString("cli_email"));
            
            jtf_nit.setText(String.valueOf(sedes.getNit_cliente()));
            txt_des.setText(sedes.getDescripcion());
            txt_dir.setText(sedes.getDir());
            txt_tel1.setText(sedes.getTel1());
            txt_tel2.setText(sedes.getTel2());
            txt_fax.setText(sedes.getFax());
            txt_mail.setText(sedes.getMail());
            
            txt_des.setEnabled(true);
            cb_ciudad.setEnabled(true);
            txt_dir.setEnabled(true);
            txt_tel1.setEnabled(true);
            txt_tel2.setEnabled(true);
            txt_fax.setEnabled(true);
            txt_mail.setEnabled(true);
            jB_actu.setEnabled(true);
            
            nueva.desconectar();
 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El cliente con el nit: "+jtf_nit.getText() + " No fue encontrado");
        }
                
    }catch(SQLException | HeadlessException e)
    {
        JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        
    }
}


        
    public void buscarClientes() throws SQLException
    {
        
        
        ResultSet obj=nueva.executeQuery("SELECT cli_razon_social FROM clientes.cliente WHERE cli_razon_social like '%"+jtf_nit.getText().toUpperCase()+"%' ORDER BY cli_razon_social ASC");
        
        while(obj.next())
        {
            cb_cliente.addItem(obj.getObject("cli_razon_social"));
        }
        
        
        nueva.desconectar();
        
    }
    
    public void buscarCliente_sede() throws SQLException
    {
       ResultSet obj=nueva.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion like '%"+txt_id_sede.getText().toUpperCase()+"%' ORDER BY sede_descripcion ASC");
        
        while(obj.next())
        {
            cb_descrip.addItem(obj.getObject("sede_descripcion"));
        }

        nueva.desconectar();
        
    }  
  }












