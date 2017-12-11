
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
public class DaoDetalleTQRecibidosDepen 
{
    
    ConexionBD nueva=new ConexionBD();

    public void guardar(DetalleTiquetesRecibidosDepen detalleTR)
    {
        try
        {
   
          ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
          if (obj1.next()==true)
          {
           
           long maximo=obj1.getLong("maximo");
           long minimo=obj1.getLong("minimo");
            
            if(detalleTR.getSerial_inicial() >= minimo && detalleTR.getSerial_final()<= maximo )
            { 
            
            
            ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+detalleTR.getSerial_inicial()+" AND "+detalleTR.getSerial_final()+" AND conse_estado=false ");
             //ResultSet obj2=nueva.executeQuery("SELECT dv_id,etp_id FROM ventas.detalle_venta WHERE dv_serial_1 BETWEEN "+detalleTR.getSerial_inicial()+"  AND "+detalleTR.getSerial_final()+" OR dv_serial_2 between "+detalleTR.getSerial_inicial()+" AND "+detalleTR.getSerial_final()+" AND etp_id="+detalleTR.getId_espe_tiquete()+"");
//             if(obj.next()==true)
//             {
                 if(obj.next()==true)
                 {
                      nueva.executeUpdateQuery("INSERT INTO ventas.detalle_recibidos_dependencias(id_especificacion_tiquete,consecutivo_inicial,consecutivo_final,id_actacambio)"
                    + "VALUES("+detalleTR.getId_espe_tiquete()+", "+detalleTR.getSerial_inicial()+", "+detalleTR.getSerial_final()+", "+detalleTR.getId_actaCambio()+")");
            
                     nueva.executeUpdateQuery("BEGIN;");
                     nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+detalleTR.getSerial_inicial()+" AND "+detalleTR.getSerial_final()+"");
                     confirmarTransaccion();
                     nueva.desconectar();
                 }
//                 else
//                 {
//                    JOptionPane.showMessageDialog(null, "El rango de tiquetes no se encuentra registrados en ninguna venta y/o la Especificacion del tiquete no le corresponde", "Error", JOptionPane.ERROR_MESSAGE);
//
//                 }
           
//             }
             else
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
