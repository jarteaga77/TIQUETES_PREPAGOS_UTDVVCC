
package sysctp.dominio.ventas;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalleTQEntregadosDepen 
{
    
   private  ConexionBD nueva=new ConexionBD();

    
    public void guardar(DetalleTiquetesEntregadosDepen detalleTE)
    {
      
        try
        {
         
           ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
          if (obj1.next()==true)
          {
           
           long maximo=obj1.getLong("maximo");
           long minimo=obj1.getLong("minimo");
           
            
            if(detalleTE.getSerial_inicial() >= minimo && detalleTE.getSerial_final()<= maximo )
            {  
            
            
           ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+detalleTE.getSerial_inicial()+" AND "+detalleTE.getSerial_final()+" AND conse_estado=true");
            
            if(obj.next()==true)
            {
            
            nueva.executeUpdateQuery("INSERT INTO ventas.detalle_entregados_dependencia (id_esp_tiquete,consecutivo_inicial,consecutivo_final,id_actacambio)"
                    + "VALUES("+detalleTE.getId_espe_tiquete()+", "+detalleTE.getSerial_inicial()+", "+detalleTE.getSerial_final()+", "+detalleTE.getId_actaCambio()+")");
            
            
            nueva.executeUpdateQuery("BEGIN;");
            nueva.executeUpdateQuery("UPDATE inventario.consecutivos  SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+detalleTE.getSerial_inicial()+" AND "+detalleTE.getSerial_final()+" ");
            this.confirmarTransaccion();
            nueva.desconectar();
            }else
            {
                JOptionPane.showMessageDialog(null, "Los Consecutivo de tiquetes ingresados no se encuentra en inventario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
             } 
           else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }  
            
          }   
            
            
        }catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
         public void confirmarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("COMMIT;");
        
            System.out.println("Pase por aqui");

        }catch(Exception e)

        {
            this.cancelarTransaccion();
            JOptionPane.showMessageDialog(null, e + "Error al confirmar la transacción", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
    
    public void cancelarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("ROLLBACK;");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
