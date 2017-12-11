
package sysctp.presentacion;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sysctp.conexion.ConexionBD;
import sysctp.reportes.clientes.BDClientes;
import sysctp.reportes.clientes.Clientexnit;

/**
 *
 * @author jarteaga
 */
public class JIFBDClientes extends javax.swing.JInternalFrame {

  DefaultTableModel modelo = new DefaultTableModel();
  private Clientexnit jasper;
  private BDClientes jasper2;
  
    public JIFBDClientes() {
        initComponents();
        jasper=new Clientexnit();
        jasper2=new BDClientes();
        
        modelo.addColumn("NIT");
        modelo.addColumn("Razón Social");
        modelo.addColumn("Dirección");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono 1");
        modelo.addColumn("Telefono 2");
        modelo.addColumn("Fax");
        modelo.addColumn("E-Mail/Sitio Web");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jB_consultarxnit = new javax.swing.JButton();
        txt_nit = new javax.swing.JTextField();
        jB_generarReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jB_consultartodos = new javax.swing.JButton();
        jB_reporteBdClientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_cliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Información de los Clientes");
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta cliente x nit"));

        jLabel1.setText("Nit Cliente: ");

        jB_consultarxnit.setText("Consultar");
        jB_consultarxnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_consultarxnitActionPerformed(evt);
            }
        });

        jB_generarReporte.setText("Generar Reporte");
        jB_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_generarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_consultarxnit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_generarReporte)
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_consultarxnit)
                    .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jB_generarReporte))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta todos los clientes"));

        jB_consultartodos.setText("Consultar");
        jB_consultartodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_consultartodosActionPerformed(evt);
            }
        });

        jB_reporteBdClientes.setText("Generar Reporte");
        jB_reporteBdClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_reporteBdClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jB_consultartodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_reporteBdClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_consultartodos)
                    .addComponent(jB_reporteBdClientes))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jtable_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable_cliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_consultarxnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_consultarxnitActionPerformed
 
        try
        {
           LimpiarJTabla();
           long nit=0;
        
           if(txt_nit.getText().isEmpty() )
           {
               throw new NullPointerException();
           }
        
           if(txt_nit.getText().matches("[0-9]*"))
           {
               nit=Long.parseLong(txt_nit.getText());
 
             ConsultarxNit(nit);
      
           }else{
               throw new NumberFormatException();
           }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_consultarxnitActionPerformed

    private void jB_consultartodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_consultartodosActionPerformed
        LimpiarJTabla();
        consultarClientes();
    }//GEN-LAST:event_jB_consultartodosActionPerformed

    private void jB_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_generarReporteActionPerformed
        try
        {
            if(txt_nit.getText().isEmpty())
            {
                throw new NullPointerException();
            }
            if(txt_nit.getText().matches("[0-9]*"))
            {
                long nit=Long.parseLong(txt_nit.getText());
                jasper.ejecutarReporte(nit);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_jB_generarReporteActionPerformed

    private void jB_reporteBdClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_reporteBdClientesActionPerformed
       jasper2.ejecutarReporte();
    }//GEN-LAST:event_jB_reporteBdClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_consultartodos;
    private javax.swing.JButton jB_consultarxnit;
    private javax.swing.JButton jB_generarReporte;
    private javax.swing.JButton jB_reporteBdClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_cliente;
    private javax.swing.JTextField txt_nit;
    // End of variables declaration//GEN-END:variables

   public void LimpiarJTabla()
    {

        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }

    public void ConsultarxNit(long nit)
    {
        try
        {
            ConexionBD nueva=new ConexionBD();
            
             ResultSet obj=nueva.executeQuery("SELECT cli_nit,cli_razon_social,cli_direccion,cli_ciudad,cli_telefono_1,cli_telefono_2,cli_fax,cli_email FROM clientes.cliente WHERE cli_nit="+nit+"");
             
             while(obj.next())
             {
                 Object [] datos = new Object[8];
                 
                 for (int i=0;i<8;i++)
                 {
                     datos[i] =obj.getObject(i+1);
                 }
                    modelo.addRow(datos);
                    jtable_cliente.setModel(modelo);

             }
                nueva.desconectar();
                 
             
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void consultarClientes()
    {
           try
        {
            ConexionBD nueva=new ConexionBD();
            
             ResultSet obj=nueva.executeQuery("SELECT cli_nit,cli_razon_social,cli_direccion,cli_ciudad,cli_telefono_1,cli_telefono_2,cli_fax,cli_email FROM clientes.cliente ");
             
             while(obj.next())
             {
                 Object [] datos = new Object[8];
                 
                 for (int i=0;i<8;i++)
                 {
                     datos[i] =obj.getObject(i+1);
                 }
                    modelo.addRow(datos);
                    jtable_cliente.setModel(modelo);

             }
                nueva.desconectar();
                 
             
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}



