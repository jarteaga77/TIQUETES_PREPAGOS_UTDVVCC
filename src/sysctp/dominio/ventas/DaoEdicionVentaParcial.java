
package sysctp.dominio.ventas;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoEdicionVentaParcial 
{
    private ConexionBD nueva=new ConexionBD();
    
    public void actualizarVentaParcial(LineaVentaParcial lineaVenta)
    {
        
        try
        {
         
           
            ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
        
        if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(lineaVenta.getSerial_inicial() >= minimo && lineaVenta.getSerial_final()<= maximo )
            {
                ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_estado="+true+"AND conse_num_consecutivo_tiqute BETWEEN "+lineaVenta.getSerial_inicial()+" AND "+lineaVenta.getSerial_final()+"");
            if(obj.next()==true)
            {
   
               nueva.executeUpdateQuery("BEGIN;");
  
               nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado=false WHERE conse_num_consecutivo_tiqute between "+lineaVenta.getSerial_inicial()+" AND "+lineaVenta.getSerial_final()+"");

               this.confirmarTransaccion();
               
               nueva.executeUpdateQuery("INSERT INTO ventas.detalle_venta(dv_serial_1,dv_serial_2,ven_id,etp_id)VALUES("+lineaVenta.getSerial_inicial()+", "+lineaVenta.getSerial_final()+", "+lineaVenta.getVent_id()+","+lineaVenta.getEtp_id()+")");

    
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango del serial no esta disponible ", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
           }
            else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
            
        }
        
            nueva.desconectar();
            }catch(Exception e)
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
