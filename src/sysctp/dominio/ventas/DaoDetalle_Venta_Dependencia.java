
package sysctp.dominio.ventas;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalle_Venta_Dependencia 
{
    private ConexionBD nueva=new ConexionBD();
    
    
    public void registrarDetalleVenta(Detalle_venta_dependencia dvd)
    {
   try {
            ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
           
        if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(dvd.getDvd_serial_1() >= minimo && dvd.getDvd_serial_2()<= maximo )
            {
  
             ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+dvd.getDvd_serial_1()+" AND "+dvd.getDvd_serial_2()+" AND conse_estado=true");
      
            if(obj.next()==true)
            {
                nueva.executeUpdateQuery("INSERT INTO ventas.detalle_venta_dependencia(dvd_serial_1,dvd_serial_2,ven_dep_id,etp)VALUES("+dvd.getDvd_serial_1()+", "+dvd.getDvd_serial_2()+", "+dvd.getVen_dep_id()+", "+dvd.getEtp()+")");     
                nueva.executeUpdateQuery("BEGIN;");
                nueva.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+false+" WHERE conse_num_consecutivo_tiqute between "+dvd.getDvd_serial_1()+" AND "+dvd.getDvd_serial_2()+" ");
                this.confirmarTransaccion();
                nueva.desconectar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Los Consecutivo de tiquetes ingresados no se encuentra en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
          } 
           else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                nueva.desconectar();
            }
         }   
        } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
;
        }
   
    }

    public void eliminarDetalleVenta(long detalle_id)
    {
       nueva.executeUpdateQuery("DELETE FROM ventas.detalle_venta_dependencia WHERE dvd_id="+detalle_id+"");
       nueva.desconectar();
    }
    
    
     public void confirmarTransaccion()
    {
        try
        {
            nueva.executeUpdateQuery("COMMIT;");
            
            System.out.println("Pase por aqui");
            nueva.desconectar();

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
            nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
             
}
