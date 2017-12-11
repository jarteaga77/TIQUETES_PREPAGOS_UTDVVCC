
package sysctp.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.vendedor.DaoEmpleado;
import sysctp.dominio.vendedor.Empleado;

/**
 *
 * @author jarteaga
 */
public class JIFEmpleado extends javax.swing.JInternalFrame {

  private ConexionBD nuevaCone=new ConexionBD();
  
  DaoEmpleado daoemple=new DaoEmpleado();
  
    public JIFEmpleado() {
        initComponents();
       
        try
        {
            ResultSet obj=nuevaCone.executeQuery("SELECT nombre FROM tbcargo ORDER BY nombre ASC");
            
            while(obj.next())
            {
                jCB_cargo.addItem(obj.getObject("nombre"));
            }
            nuevaCone.desconectar();
            
        }catch(SQLException esql)
      {
          System.err.println(esql.getMessage());
      }
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_id_emp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_apellido2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCB_cargo = new javax.swing.JComboBox();
        jB_buscar = new javax.swing.JButton();
        jCB_seccion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jB_ingresar = new javax.swing.JButton();
        jB_guardar = new javax.swing.JButton();
        jB_mod = new javax.swing.JButton();
        jB_actualizar = new javax.swing.JButton();
        jB_eliminar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(361, 361, 361))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID Empleado:");

        jtf_id_emp.setEnabled(false);

        jLabel2.setText("Nombre:");

        jtf_nombre.setEnabled(false);

        jLabel3.setText("Apellido: ");

        jtf_apellido.setEnabled(false);

        jLabel4.setText("Segundo Apellido:");

        jtf_apellido2.setEnabled(false);

        jLabel6.setText("Cargo:");

        jCB_cargo.setEnabled(false);

        jB_buscar.setText("Buscar");

        jCB_seccion.setEnabled(false);

        jLabel7.setText("Sección:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_id_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_buscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_nombre)
                            .addComponent(jCB_cargo, 0, 143, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jCB_seccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_id_emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_buscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jCB_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCB_seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );

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

        jB_mod.setText("Modificar");
        jB_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_modActionPerformed(evt);
            }
        });

        jB_actualizar.setText("Actualizar ");
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

        jButton6.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jB_ingresar)
                        .addGap(18, 18, 18)
                        .addComponent(jB_guardar)
                        .addGap(18, 18, 18)
                        .addComponent(jB_mod)
                        .addGap(18, 18, 18)
                        .addComponent(jB_actualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jB_eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_ingresar)
                    .addComponent(jB_guardar)
                    .addComponent(jB_mod)
                    .addComponent(jB_actualizar)
                    .addComponent(jB_eliminar)
                    .addComponent(jButton6))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ingresarActionPerformed
         jtf_id_emp.setEnabled(true);
         jtf_nombre.setEnabled(true);
         jtf_apellido.setEnabled(true);
         jtf_apellido2.setEnabled(true);
         jCB_cargo.setEnabled(true);
         jB_guardar.setEnabled(true);
         jB_ingresar.setEnabled(false);
         
    }//GEN-LAST:event_jB_ingresarActionPerformed

    private void jB_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_modActionPerformed
        jtf_id_emp.setEnabled(true);
        jB_buscar.setEnabled(true);
        jB_mod.setEnabled(true);
        jB_ingresar.setEnabled(true);
 
    }//GEN-LAST:event_jB_modActionPerformed

    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed
        try
        {
            int idseccion=0;
            int idcargo=0;
            
            Empleado oemple=new Empleado();
            
            oemple.setCedula(Integer.parseInt(jtf_id_emp.getText()));
            oemple.setNombre(jtf_nombre.getText());
            oemple.setApellido(jtf_apellido.getText());
            oemple.setApellido2(jtf_apellido2.getText());
            
            String cargo = jCB_cargo.getSelectedItem().toString();
            
            ResultSet obj=nuevaCone.executeQuery("SELECT idcargo FROM tbcargo WHERE nombre='"+cargo+"'");
            
            while(obj.next())
            {
                idcargo=obj.getInt(1);
            }
             String seccion = jCB_seccion.getSelectedItem().toString();
            
            obj=nuevaCone.executeQuery("SELECT id_seccion FROM tbseccion_empresa WHERE seccion_nombre='"+seccion+"'");
            
            while(obj.next())
            {
                idseccion=obj.getInt(1);
            }
            
            oemple.setCargo(idcargo);
            oemple.setSeccion(idseccion);
            
            daoemple.guardar(oemple);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_guardarActionPerformed

    private void jB_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_actualizarActionPerformed
        try
        {
            int idseccion=0;
            int idcargo=0;
            
            Empleado emple=new Empleado();
            emple.setNombre(jtf_nombre.getText());
            emple.setApellido(jtf_apellido.getText());
            emple.setApellido2(jtf_apellido2.getText());
            
            
            String cargo = jCB_cargo.getSelectedItem().toString();
            
            ResultSet obj=nuevaCone.executeQuery("SELECT idcargo FROM tbcargo WHERE nombre='"+cargo+"'");
            
            while(obj.next())
            {
                idcargo=obj.getInt(1);
            }
             String seccion = jCB_seccion.getSelectedItem().toString();
            
            obj=nuevaCone.executeQuery("SELECT id_seccion FROM tbseccion_empresa WHERE seccion_nombre='"+seccion+"'");
            
            while(obj.next())
            {
                idseccion=obj.getInt(1);
            }
            
            emple.setCargo(idcargo);
            emple.setSeccion(idseccion);
            
            daoemple.actualizar(emple, Integer.parseInt(jtf_id_emp.getText()));
    
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_actualizarActionPerformed

    private void jB_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_eliminarActionPerformed
       try
       {
           
           daoemple.eliminar(Integer.parseInt(jtf_id_emp.getText()));
           
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jB_eliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_actualizar;
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jB_eliminar;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JButton jB_ingresar;
    private javax.swing.JButton jB_mod;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jCB_cargo;
    private javax.swing.JComboBox jCB_seccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_apellido2;
    private javax.swing.JTextField jtf_id_emp;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables
}
