
package sysctp.presentacion;

import java.awt.Color;
import java.util.Date;
import javax.swing.SwingWorker;
import sysctp.dominio.inventario.Consecutivo;
import sysctp.dominio.inventario.DaoConsecutivo;

/**
 *
 * @author jarteaga
 */
public class JIFConsecutivos extends javax.swing.JInternalFrame {
public static MDIPrincipal principal;
    public JIFConsecutivos() {
        initComponents();
           //Objeto jPanel encabezado con color personalizado
        Color c1 = new Color(66,111,166);
        Color c2 = new Color(102,174,118);
        JPColor jpmicolor = new JPColor(c1,c2);
        jpmicolor.setSize(this.getSize());        
        panel_encabezado.add(jpmicolor); 
     
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtf_inicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_final = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        b_guardar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jl_espera = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_remision = new javax.swing.JTextField();
        dc_fecha_remision = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        chb_puv = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txarea_obse = new javax.swing.JTextArea();
        ch_box_tvsin = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consecutivos de Tiquetes");

        panel_encabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 247, 247));
        jLabel1.setText("CONSECUTIVOS TIQUETES");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/ticket_2.png"))); // NOI18N

        javax.swing.GroupLayout panel_encabezadoLayout = new javax.swing.GroupLayout(panel_encabezado);
        panel_encabezado.setLayout(panel_encabezadoLayout);
        panel_encabezadoLayout.setHorizontalGroup(
            panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(165, 165, 165))
        );
        panel_encabezadoLayout.setVerticalGroup(
            panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_encabezadoLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panel_encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Consecutivo Inicial:");

        jLabel3.setText("Consecutivo Final:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_guardar.setText("Aceptar");
        b_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        jl_espera.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jl_espera.setText("--");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_espera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_guardar)
                .addGap(18, 18, 18)
                .addComponent(b_cancelar)
                .addGap(219, 219, 219))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_guardar)
                    .addComponent(b_cancelar)
                    .addComponent(jl_espera))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Remisión N°:");

        jLabel6.setText("Fecha Remisión:");

        buttonGroup1.add(chb_puv);
        chb_puv.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chb_puv.setSelected(true);
        chb_puv.setText("Disponible para Venta");
        chb_puv.setToolTipText("");

        txarea_obse.setColumns(20);
        txarea_obse.setRows(5);
        jScrollPane1.setViewportView(txarea_obse);

        buttonGroup1.add(ch_box_tvsin);
        ch_box_tvsin.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        ch_box_tvsin.setText("Tiquetes vendidos sin Inventario");

        jLabel7.setText("Observación:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_inicial)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dc_fecha_remision, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jtf_final)))
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chb_puv)
                                .addGap(18, 18, 18)
                                .addComponent(ch_box_tvsin)))
                        .addGap(88, 88, 88)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_remision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(dc_fecha_remision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chb_puv)
                    .addComponent(ch_box_tvsin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardarActionPerformed

        final SwingWorker worker = new SwingWorker() {//Permite que la GUI no se congele SwingWorker

      @Override
      protected Object doInBackground() throws Exception {
      
       jl_espera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/wait.gif")));
       jl_espera.setText("Espere por favor...");
       b_cancelar.setEnabled(false);
    
       Consecutivo conse=new Consecutivo();
        DaoConsecutivo daocon= new DaoConsecutivo();
        int id_usurio= MDIPrincipal.getSeccion();
        
        conse.setConsecutivo_Inicial(Long.parseLong(jtf_inicial.getText()));
        conse.setConsecutivo_Final(Long.parseLong((jtf_final.getText())));
        conse.setId_usuario(id_usurio);
        conse.setRemision(Long.parseLong(txt_remision.getText()));
        conse.setFecha(new Date());
        conse.setFecha_remision(dc_fecha_remision.getDate());
        conse.setObse(txarea_obse.getText());
        
        if(chb_puv.isSelected()==true)
        {
            conse.setPuv(true);
            conse.setEstado(true);
//        }else if(ch_box_no_disponible.isSelected()==true)
//        {
//            conse.setPuv(false);
//            conse.setEstado(false);
//        }
 
        }else if(ch_box_tvsin.isSelected()==true)
        {
            conse.setPuv(true);
            conse.setEstado(false);
        }
        daocon.guardar(conse);
        
        jtf_final.setText("");
        jtf_inicial.setText("");
        txt_remision.setText("");
        txarea_obse.setText("");
        
        b_guardar.setEnabled(true);
        b_cancelar.setEnabled(true);
        jl_espera.setIcon(null);
 
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
                
       worker.execute();
 
 
    }//GEN-LAST:event_b_guardarActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        dispose();
        
    }//GEN-LAST:event_b_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_guardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ch_box_tvsin;
    private javax.swing.JCheckBox chb_puv;
    private com.toedter.calendar.JDateChooser dc_fecha_remision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_espera;
    private javax.swing.JTextField jtf_final;
    private javax.swing.JTextField jtf_inicial;
    private javax.swing.JPanel panel_encabezado;
    private javax.swing.JTextArea txarea_obse;
    private javax.swing.JTextField txt_remision;
    // End of variables declaration//GEN-END:variables
}
