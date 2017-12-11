
/*
 * Splash.java
 *
 * 
 */
package sysctp.presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import sysctp.servicios.util.PropiedadesDelSistema;


/**
 *
 * @author jarteaga
 */
public class Splash extends javax.swing.JFrame implements Runnable{

   Thread hilo;
   
   int num = 0;
  
    public Splash() 
    {
        initComponents();
        Color c1 = new Color(66,111,166);
        Color c2 = new Color(102,174,118);
        JPColor jpmicolor = new JPColor(c1,c2);
        jpmicolor.setSize(this.getSize());        
        jPanel1.add(jpmicolor); 
        
        
    }
    
     @SuppressWarnings("unchecked")
    @Override
    public Image getIconImage() 
      {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("sysctp/presentacion/recursos/icono.png"));
        return retValue;
    }
//    @Override
//    public Image getIconImage() {
//        Image retValue = Toolkit.getDefaultToolkit().
//                getImage(ClassLoader.getSystemResource("sysctp/presentacion/recursos/Logo.png"));
//
//
//        return retValue;
//    }
     public void progresoBarra() {
    while (num < 1000) {
      jPB_barra.setValue(num);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
      }
      num += 100;
    }
    
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPB_barra = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control de Tiquetes Prepagos - UTDVVCC versión (1.0)");
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPB_barra.setMaximum(1000);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("SYSCTP");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("V.1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("SYSCTP esta cargando,espere por favor.........");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysctp/presentacion/recursos/Logo_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(236, 236, 236))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPB_barra, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPB_barra, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void run()
{
    this.setLocationRelativeTo(null);
    this.setVisible(true);
        try {
            progresoBarra();
            hilo.sleep(500);
            this.dispose();
            
            PropiedadesDelSistema.obtenerInscancia().cargarPropiedades(); // Carga las propiedades del sistema
            MDIPrincipal principal = new MDIPrincipal(); // Inicializa la ventana con los menús de la aplicación
            principal.setLocationRelativeTo(null);
            principal.setVisible(false);//Frame Principal No arranca visible
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//Frame toma el tramaño de la resolución de la pantalla
            principal.inicioSeccion();
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
          catch (Exception ex) {
            ex.printStackTrace(); // Registra en la salida de linea de comandos, si hay un error en la inicialización del sistema
        }
}



    public static void main(String args[]) {
          try{

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
              //UIManager.setLookAndFeel("SyntheticaBlueLightLookAndFeel");
        }catch (Exception ex){
            
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jPB_barra;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
    
}
