
package sysctp.presentacion;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.usuario.DaoUsuario;
import sysctp.dominio.usuario.Usuario;

/**
 *
 * @author jarteaga
 */
public class JIFRegUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFRegUsuario
     */
    ConexionBD nuevaCone=new ConexionBD();
    LimpiarCampos olimpiar=new LimpiarCampos(); 
    public JIFRegUsuario() {
        
        initComponents();

       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_cedula = new javax.swing.JTextField();
        jB_buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jpf_clave = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jpf_clave2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jB_ingresar = new javax.swing.JButton();
        jB_guardar = new javax.swing.JButton();
        jB_modificar = new javax.swing.JButton();
        jB_actualizar = new javax.swing.JButton();
        jB_eliminar = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del usuario"));

        jLabel1.setText("Nombre: ");

        jtf_nombre.setEnabled(false);

        jLabel2.setText("Apellido:");

        jtf_apellido.setEnabled(false);

        jLabel3.setText("Cédula:");

        jtf_cedula.setEnabled(false);

        jB_buscar.setText("Buscar");
        jB_buscar.setEnabled(false);
        jB_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_cedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jB_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtf_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta del usuario"));

        jLabel5.setText("Usuario:");

        jtf_usuario.setEnabled(false);

        jLabel6.setText("Contraseña:");

        jpf_clave.setEnabled(false);

        jLabel7.setText("Repetir Contraseña:");

        jpf_clave2.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_usuario)
                    .addComponent(jpf_clave, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jpf_clave2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jpf_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jpf_clave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jB_ingresar.setText("Ingresar");
        jB_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ingresarActionPerformed(evt);
            }
        });

        jB_guardar.setText("Guardar");
        jB_guardar.setEnabled(false);
        jB_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_guardarActionPerformed(evt);
            }
        });

        jB_modificar.setText("Modificar");
        jB_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_modificarActionPerformed(evt);
            }
        });

        jB_actualizar.setText("Actualizar");
        jB_actualizar.setEnabled(false);
        jB_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_actualizarActionPerformed(evt);
            }
        });

        jB_eliminar.setText("Eliminar");
        jB_eliminar.setEnabled(false);
        jB_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_eliminarActionPerformed(evt);
            }
        });

        jB_cancelar.setText("Cancelar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_ingresar)
                .addGap(18, 18, 18)
                .addComponent(jB_guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_modificar)
                .addGap(18, 18, 18)
                .addComponent(jB_actualizar)
                .addGap(18, 18, 18)
                .addComponent(jB_eliminar)
                .addGap(18, 18, 18)
                .addComponent(jB_cancelar)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_cancelar)
                    .addComponent(jB_eliminar)
                    .addComponent(jB_actualizar)
                    .addComponent(jB_modificar)
                    .addComponent(jB_guardar)
                    .addComponent(jB_ingresar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("USUARIO DEL SISTEMA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(264, 264, 264))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscarActionPerformed
        try {
            buscar(Integer.parseInt(jtf_cedula.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jB_buscarActionPerformed

    private void jB_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ingresarActionPerformed
        jtf_nombre.setEnabled(true);
        jtf_apellido.setEnabled(true);
        jtf_cedula.setEnabled(true);
        jtf_usuario.setEnabled(true);
        jpf_clave.setEnabled(true);
        jpf_clave.setEnabled(true);
        jB_guardar.setEnabled(true);
        jpf_clave2.setEnabled(true);
        jB_ingresar.setEnabled(false);
        jB_modificar.setEnabled(false);


    }//GEN-LAST:event_jB_ingresarActionPerformed

    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed
       try {

          
            DaoUsuario daousuario = new DaoUsuario();
            Usuario us = new Usuario();


            if (String.valueOf(jpf_clave.getPassword()).equals(String.valueOf(jpf_clave2.getPassword()))) {
                us.setNombre(jtf_nombre.getText());
                us.setApellido(jtf_apellido.getText());
                us.setCedula(Integer.parseInt(jtf_cedula.getText()));
                us.setUsuario(jtf_usuario.getText());
                us.setClave(jpf_clave.getPassword().toString());

                daousuario.guardar(us);

                olimpiar.limpiar(this.jPanel2);
                olimpiar.limpiar(this.jPanel3);

                

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            }


        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_jB_guardarActionPerformed

    private void jB_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_modificarActionPerformed
        jtf_cedula.setEnabled(true);
        jB_modificar.setEnabled(false);
        jB_buscar.setEnabled(true);

    }//GEN-LAST:event_jB_modificarActionPerformed

    private void jB_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_actualizarActionPerformed
        try {
            Usuario us = new Usuario();
           DaoUsuario daous = new DaoUsuario();

            if (String.valueOf(jpf_clave.getPassword()).equals(String.valueOf(jpf_clave2.getPassword()))) {
                us.setUsuario(jtf_usuario.getText());
                us.setClave((jpf_clave.getPassword().toString()));
                daous.actualizar(us, Integer.parseInt(jtf_cedula.getText()));

                JOptionPane.showMessageDialog(null, "Se actualizo con exito el usuario");
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jB_actualizarActionPerformed

    private void jB_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_eliminarActionPerformed
        try {
            DaoUsuario daousuario = new DaoUsuario();

            daousuario.eliminar(Integer.parseInt(jtf_cedula.getText()));

           olimpiar.limpiar(this.jPanel2);
           olimpiar.limpiar(this.jPanel3);
            confInicial();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jB_eliminarActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        olimpiar.limpiar(this.jPanel2);
        olimpiar.limpiar(this.jPanel3);
        confInicial();
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_actualizar;
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_eliminar;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JButton jB_ingresar;
    private javax.swing.JButton jB_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jpf_clave;
    private javax.swing.JPasswordField jpf_clave2;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_cedula;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables
  //Metodo de encargado de buscar al usuario para  poder realizar modificaciones
public void buscar(int cedula)
            
 {
     Usuario us= new Usuario();
        try
        {
            ResultSet obj=nuevaCone.executeQuery("SELECT nombre,apellido,usuario from tbusuario where cedula="+cedula+"");
            
            if(obj.next()==true)
            {
                us.setNombre(obj.getString("nombre"));
                us.setApellido(obj.getString("apellido"));
                us.setUsuario(obj.getString("usuario"));
                
                jtf_nombre.setText(us.getNombre());
                jtf_apellido.setText(us.getApellido());
                jtf_usuario.setText(us.getUsuario());
                
                jB_ingresar.setEnabled(false);
                jB_buscar.setEnabled(false);
                jtf_cedula.setEnabled(false);
                jpf_clave.setEnabled(true);
                jpf_clave2.setEnabled(true);
                jB_modificar.setEnabled(false);
                jB_actualizar.setEnabled(true);
                jB_eliminar.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
            }
            
            
        }catch(SQLException | HeadlessException e)
        {
            
        }
    }//Fin buscar()
            //Metodo encargado para limpiar los campos que estan en el jpanel
          

       //Configuracion inicial de los componentes de los componentes de la GUI
       public void confInicial()
       {
           jB_ingresar.setEnabled(true);
           jB_guardar.setEnabled(false);
           jB_modificar.setEnabled(true);
           jB_actualizar.setEnabled(false);
           jB_eliminar.setEnabled(false);
           jB_buscar.setEnabled(false);
           jtf_nombre.setEnabled(false);
           jtf_apellido.setEnabled(false);
           jtf_cedula.setEnabled(false);
           jtf_usuario.setEnabled(false);
           jpf_clave.setEnabled(false);
           jpf_clave2.setEnabled(false);
           
       }












}




