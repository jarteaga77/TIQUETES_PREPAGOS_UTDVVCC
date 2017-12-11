
package sysctp.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.informacion.clientes.ReporteClientes;

/**
 *
 * @author jarteaga
 */
public class JIFInformacionClientes extends javax.swing.JInternalFrame {

   private DefaultTableModel modelo;
   private ReporteClientes reporte;
    
    
    public JIFInformacionClientes() {
        initComponents();
     
        modelo=new DefaultTableModel();
        
        modelo.addColumn("Nit");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Telefono 1");
        modelo.addColumn("Telefono 2");
        modelo.addColumn("Fax");
        modelo.addColumn("Ciudad");
        modelo.addColumn("E-Mail");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_cliente = new javax.swing.JTextField();
        cb_cliente = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btn_clientes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SYSCTP-Información de Clientes");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Clientes"));

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

        jLabel1.setText("Cliente:");

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/icono_pdf.png"))); // NOI18N
        btn_clientes.setToolTipText("Genererar reporte Todos los Clientes");
        btn_clientes.setContentAreaFilled(false);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_cliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
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
        long nit=0; 
        ConexionBD nueva=new ConexionBD();
        LimpiarJTabla();
        if(cb_cliente.getSelectedItem()!=null)
            {
                String nombre=cb_cliente.getSelectedItem().toString();
                ResultSet obj=nueva.executeQuery("SELECT cli.cli_nit,sede_descripcion,cli.cli_direccion,cli_telefono_1,cli_telefono_2,cli_fax,muni.ciu_descripcion,cli_email "
                        + "FROM clientes.sedes_clientes cli JOIN municipio muni ON muni.ciu_id=cli.id_clie_ciudad "
                        + "WHERE sede_descripcion='"+nombre+"'");
            try {
          while(obj.next())
         {
        
           Object [] datos = new Object[8];
        
        for (int i=0;i<8;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
         tabla_cliente.setModel(modelo);
        }
       
         nueva.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFInformacionClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
           }    
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        reporte=new ReporteClientes();
        
        reporte.ejecutarReporte();
    }//GEN-LAST:event_btn_clientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTextField txt_cliente;
    // End of variables declaration//GEN-END:variables

       public void LimpiarJTabla()
    {
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);          
        }
    } 
    
    
    public void buscarCliente() throws SQLException
    {
       
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT sede_descripcion FROM clientes.sedes_clientes WHERE sede_descripcion like '%"+txt_cliente.getText().toUpperCase()+"%' ORDER BY sede_descripcion");
            
            while(obj.next())
            {
                cb_cliente.addItem(obj.getObject("sede_descripcion"));
            }
            
            nueva.desconectar();
    }

}
