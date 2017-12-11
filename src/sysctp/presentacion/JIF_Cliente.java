
package sysctp.presentacion;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.clientes.Cliente;
import sysctp.dominio.clientes.DaoCliente;

/**
 *
 * @author jarteaga
 */
public class JIF_Cliente extends javax.swing.JInternalFrame {

    private ConexionBD nueva;
    LimpiarCampos olimpiar=new LimpiarCampos(); 
    
    private DefaultTableModel modelo;
    private JIFCliente_sedes cliente;
    
    public JIF_Cliente() {
        initComponents();
        nueva=new ConexionBD();
        modelo= new DefaultTableModel(); //Crea el objeto modelo de tabla
     
          //Modelo predeterminado de JTable
        modelo.addColumn("Nit");
        modelo.addColumn("Cliente - Razon Social");
        //Llama al metodo detalle tabla que carga la información de clientes
        detalleTabla();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_cliente = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_nit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_rs = new javax.swing.JTextField();
        jB_guardar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        b_adicionar = new javax.swing.JButton();
        b_modificar = new javax.swing.JButton();
        btn_sede = new javax.swing.JButton();

        JD_cliente.setTitle("Cliente");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Cédula/Nit: ");

        jLabel2.setText("Razón Social:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtf_nit, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jtf_rs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_rs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_guardar.setText("Aceptar");
        jB_guardar.setToolTipText("Guardar");
        jB_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_guardarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JD_clienteLayout = new javax.swing.GroupLayout(JD_cliente.getContentPane());
        JD_cliente.getContentPane().setLayout(JD_clienteLayout);
        JD_clienteLayout.setHorizontalGroup(
            JD_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_clienteLayout.createSequentialGroup()
                .addGroup(JD_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_clienteLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jB_guardar)
                        .addGap(36, 36, 36)
                        .addComponent(b_cancelar))
                    .addGroup(JD_clienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JD_clienteLayout.setVerticalGroup(
            JD_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JD_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_guardar)
                    .addComponent(b_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_cliente);

        b_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/add.png"))); // NOI18N
        b_adicionar.setToolTipText("Adicionar Cliente");
        b_adicionar.setBorderPainted(false);
        b_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_adicionarActionPerformed(evt);
            }
        });

        b_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/mod_detalle.png"))); // NOI18N
        b_modificar.setBorderPainted(false);
        b_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_modificarActionPerformed(evt);
            }
        });

        btn_sede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/nuevo.png"))); // NOI18N
        btn_sede.setToolTipText("Registrar Datos del cliente");
        btn_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(b_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_guardarActionPerformed

        try
        {
    
            DaoCliente daoClie=new DaoCliente();
            Cliente clie=new Cliente();
            
            ResultSet obj=nueva.executeQuery("SELECT cli_nit FROM clientes.cliente WHERE cli_nit="+jtf_nit.getText()+"");
            
            if(obj.next()==true)
            {
                clie.setRazonSocial(jtf_rs.getText().toUpperCase());
                clie.setId(Long.parseLong(jtf_nit.getText()));
                daoClie.actualizar(clie);
                LimpiarTabla();
                detalleTabla();
                JD_cliente.dispose();
                nueva.desconectar();
                jtf_nit.setEnabled(true);
                
            }else
            {
        
           // ResultSet obj=nueva.executeQuery("SELECT cli_nit FROM clientes.cliente WHERE cli_nit="+jtf_nit.getText()+"");

            if(obj.next()==false)
            {
                clie.setId(Long.parseLong(jtf_nit.getText()));
                clie.setRazonSocial(jtf_rs.getText().toUpperCase());

                daoClie.guardar(clie);

                LimpiarCampos lc= new LimpiarCampos();
                lc.limpiar(jPanel2);
                nueva.desconectar();
                LimpiarTabla();
                detalleTabla();
                

            }
           } 

        }catch(SQLException | NumberFormatException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_guardarActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
       JD_cliente.dispose();
       jtf_nit.setEnabled(true);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_adicionarActionPerformed
          JD_cliente.pack();
          JD_cliente.setLocationRelativeTo(null);
          JD_cliente.setVisible(true);
          JD_cliente.setResizable(false);
    }//GEN-LAST:event_b_adicionarActionPerformed

    private void b_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_modificarActionPerformed
       if(tabla_cliente.isRowSelected(tabla_cliente.getSelectedRow()))
        {
             int row = tabla_cliente.getSelectedRow();
             
             for(int i = 0; i < modelo.getRowCount(); i++)
             {
                 jtf_nit.setText(modelo.getValueAt(row,0).toString());
                 jtf_rs.setText(modelo.getValueAt(row,1).toString());
                 
                   JD_cliente.pack();
                   JD_cliente.setLocationRelativeTo(null);
                   JD_cliente.setVisible(true);
                   JD_cliente.setResizable(false);
                   jtf_nit.setEnabled(false);
             }
        } 
    }//GEN-LAST:event_b_modificarActionPerformed

    private void btn_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sedeActionPerformed
        if(estacerrado(cliente))
        {
            cliente=new JIFCliente_sedes();
            MDIPrincipal.desktopPane.add(cliente);
            cliente.setLocation(300, 200);
            cliente.show();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_sedeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_cliente;
    private javax.swing.JButton b_adicionar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_modificar;
    private javax.swing.JButton btn_sede;
    private javax.swing.JButton jB_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_nit;
    private javax.swing.JTextField jtf_rs;
    private javax.swing.JTable tabla_cliente;
    // End of variables declaration//GEN-END:variables


     public final void detalleTabla()
    {
   
        try
        {
            ResultSet obj=nueva.executeQuery("SELECT cli_nit,cli_razon_social FROM clientes.cliente ORDER BY cli_razon_social ASC");
            
         while (obj.next()) 
        {
        
        Object [] datos = new Object[2];
        
     
        for (int i=0;i<2;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_cliente.setModel(modelo);
           nueva.desconectar();
           
           
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void LimpiarTabla()
    {
        
   
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
    private boolean estacerrado(Object obj){
        JInternalFrame[] activos=MDIPrincipal.desktopPane.getAllFrames();
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

}
