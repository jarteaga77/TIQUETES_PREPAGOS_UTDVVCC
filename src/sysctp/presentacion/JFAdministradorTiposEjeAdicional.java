

/*
 * JFAdministradorCategorias.java
 *
 * Created on 18/11/2011, 04:05:32 PM
 */
package sysctp.presentacion;

import javax.swing.JOptionPane;
import sysctp.aplicacion.administracion.administracion_tipos_eje_adicional.ControladorAdministracionTiposEjeAdicional;
import sysctp.dominio.Empresa;
import sysctp.dominio.inventario.Categoria;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author james
 */
public class JFAdministradorTiposEjeAdicional extends javax.swing.JFrame {

    ControladorAdministracionTiposEjeAdicional controlador;
    TableModelTiposEjeAdicional tableModelCategorias;
    
    /** Creates new form JFAdministradorCategorias */
    public JFAdministradorTiposEjeAdicional(Empresa empresa) {
        controlador=new ControladorAdministracionTiposEjeAdicional(empresa);
        tableModelCategorias = new TableModelTiposEjeAdicional();
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTiposEjeAdicional = new javax.swing.JTable();
        jbInsertar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipos de Eje Adicional");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tableTiposEjeAdicional.setModel(tableModelCategorias);
        jScrollPane1.setViewportView(tableTiposEjeAdicional);

        jbInsertar.setText("Insertar");
        jbInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsertarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.setEnabled(false);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jbInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jbCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(jbCerrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try{
            controlador.iniciarAdministracion();
            tableModelCategorias.setControlador(controlador);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "No hay conexión con la base de datos.\n\t" + e, "ERROR!", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.finalizarAdministracion();
    }//GEN-LAST:event_formWindowClosing

    private void jbInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsertarActionPerformed
        controlador.iniciarInsercion();
        JDAdministrarNombre dialog = new JDAdministrarNombre(this,true);
        dialog.setTitle("Tipo de Eje Adicional...");
        dialog.setVisible(true);
        if(dialog.isConfirmado()){
            controlador.asignarNombre(dialog.getNombre());
            controlador.confirmarOperacion();
        }else{
            controlador.cancelarOperacion();
        }
    }//GEN-LAST:event_jbInsertarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        controlador.iniciarModificacion();
        controlador.seleccionarTipoEjeAdicional(tableTiposEjeAdicional.getSelectedRow());
        JDAdministrarNombre dialog = new JDAdministrarNombre(this,true);
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional) controlador.getOperacionActual().getElementoObjetivo();
        dialog.setId(tipoEjeAdicional.getId());
        dialog.setNombre(tipoEjeAdicional.getNombre());
        dialog.setTitle("Tipo de Eje Adicional...");
        dialog.setVisible(true);
        if(dialog.isConfirmado()){
            controlador.asignarNombre(dialog.getNombre());
            controlador.confirmarOperacion();
        }else{
            controlador.cancelarOperacion();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        controlador.iniciarEliminacion();
        controlador.seleccionarTipoEjeAdicional(tableTiposEjeAdicional.getSelectedRow());
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional) controlador.getOperacionActual().getElementoObjetivo();
        int res = JOptionPane.showConfirmDialog(this, "Se va a eliminar el tipo de eje adicional:" +
                                                      "\n   Identificador: " + tipoEjeAdicional.getId() + 
                                                      "\n   Nombre: " + tipoEjeAdicional.getNombre() +
                                                      "\n¿Está seguro que desea eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            controlador.confirmarOperacion();
        }else{
            controlador.cancelarOperacion();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        controlador.finalizarAdministracion();
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbInsertar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTable tableTiposEjeAdicional;
    // End of variables declaration//GEN-END:variables
}
