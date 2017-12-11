
package sysctp.presentacion;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;
//import javax.swing.SwingUtilities;  

/**
 *
 * @author jarteaga
 */
public class JIFRestaurarTiquetes extends javax.swing.JInternalFrame {

    private ConexionBD conexion;
    public JIFRestaurarTiquetes() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_serialIni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_serialFin = new javax.swing.JTextField();
        cb_activar = new javax.swing.JCheckBox();
        cb_desactivar = new javax.swing.JCheckBox();
        btn_ejecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_ob = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("SYSCTP - Restaurar Tiquetes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Serial Inicial");

        txt_serialIni.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Serial Final");

        txt_serialFin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        buttonGroup1.add(cb_activar);
        cb_activar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_activar.setSelected(true);
        cb_activar.setText("Activar");

        buttonGroup1.add(cb_desactivar);
        cb_desactivar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_desactivar.setText("Desactivar");

        btn_ejecutar.setText("Ejecutar");
        btn_ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ejecutarActionPerformed(evt);
            }
        });

        txa_ob.setColumns(20);
        txa_ob.setRows(5);
        jScrollPane1.setViewportView(txa_ob);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Observación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_serialIni, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_serialFin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_activar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_desactivar)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ejecutar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_serialIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_serialFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_activar)
                    .addComponent(cb_desactivar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ejecutar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ejecutarActionPerformed
        conexion=new ConexionBD(); 
        Date fecha_sis=new Date();
        int desde=Integer.parseInt(txt_serialIni.getText());
        int hasta=Integer.parseInt(txt_serialFin.getText());
        
        int total=hasta-desde+1;
        int cant=hasta-desde +1;
        String obser=txa_ob.getText();
        
        try
        {
        
           ResultSet obj1=conexion.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");

             if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(Long.parseLong(txt_serialIni.getText()) >= minimo && Long.parseLong(txt_serialFin.getText())<= maximo )
            {
                
          ResultSet obj=conexion.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+txt_serialIni.getText()+" AND "+txt_serialFin.getText()+"");
            if(obj.next()==true)
            {
        
        
        if(cb_activar.isSelected())
        {
          conexion.executeUpdateQuery("BEGIN;");  
          conexion.executeUpdateQuery("UPDATE inventario.consecutivos set conse_estado=true WHERE conse_num_consecutivo_tiqute between "+txt_serialIni.getText()+" AND "+txt_serialFin.getText()+"");
          conexion.executeUpdateQuery("INSERT INTO inventario.reg_rest_tiq (fecha_reg,desde,hasta,can_tiq,observacion,act_desa) VALUES('"+fecha_sis+"',"+desde+", "+hasta+", "+cant+", '"+obser+"', 'T')");
          
          
          confirmarTransaccion();
          
          JOptionPane.showMessageDialog(null,"Se activaron los tiquetes Entre " + txt_serialIni.getText() + " Hasta " + txt_serialFin.getText()+"\n Total Cantidad Tiquetes: "+total);
          txt_serialIni.setText("");
          txt_serialFin.setText("");
          txa_ob.setText("");
          conexion.desconectar();
        }
        
        else
        {
           conexion.executeUpdateQuery("BEGIN;"); 
           conexion.executeUpdateQuery("UPDATE inventario.consecutivos set conse_estado=false WHERE conse_num_consecutivo_tiqute between "+txt_serialIni.getText()+" AND "+txt_serialFin.getText()+"");
           conexion.executeUpdateQuery("INSERT INTO inventario.reg_rest_tiq (fecha_reg,desde,hasta,can_tiq,observacion,act_desa) VALUES('"+fecha_sis+"',"+desde+", "+hasta+", "+cant+", '"+obser+"', 'F')");

           confirmarTransaccion();
           
           JOptionPane.showMessageDialog(null,"Se desactivaron los tiquetes Entre " + txt_serialIni.getText() + " Hasta " + txt_serialFin.getText() +"\n Total Cantidad Tiquetes: "+total);

          txt_serialIni.setText("");
          txt_serialFin.setText("");
          txa_ob.setText("");
           
           conexion.desconectar();
        }
       }
            }  
            
            else
                
            {
               JOptionPane.showMessageDialog(null,"El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango del serial no esta disponible", "Mensaje", JOptionPane.WARNING_MESSAGE);

            }
        }
             else
             {
                 JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Mensaje", JOptionPane.WARNING_MESSAGE);
             }
        conexion.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Error", JOptionPane.ERROR_MESSAGE);
            conexion.desconectar();
        }
    }//GEN-LAST:event_btn_ejecutarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ejecutar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cb_activar;
    private javax.swing.JCheckBox cb_desactivar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txa_ob;
    private javax.swing.JTextField txt_serialFin;
    private javax.swing.JTextField txt_serialIni;
    // End of variables declaration//GEN-END:variables


  public void confirmarTransaccion()
    {
        try
        {
            conexion.executeUpdateQuery("COMMIT;");
            System.out.println("confirmarTransaccion");
            conexion.desconectar();
            
        }catch(Exception e)

        {
            this.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e + "Se canceló la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
    
    public void cancelarTransaccion()
    {
        try
        {
            conexion.executeUpdateQuery("ROLLBACK;");
            System.out.println("Pase por cancelar Transaccion");
            conexion.desconectar();

            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
