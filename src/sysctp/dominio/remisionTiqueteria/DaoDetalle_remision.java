
package sysctp.dominio.remisionTiqueteria;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalle_remision 
{
    
    private ConexionBD nueva=new ConexionBD();
    
    public void registroDetalleRemision(Detalle_remision detalle)
    {
        try {
        
         ResultSet obj1=nueva.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
          if (obj1.next()==true)
          {
           
                long maximo=obj1.getLong("maximo");
                long minimo=obj1.getLong("minimo");
            
                if(detalle.getSerial_inicial() >= minimo && detalle.getSerial_final()<= maximo )
                { 
        
        
        
                 ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+" AND conse_estado="+false+" ");
       // ResultSet obj1=nueva.executeQuery("SELECT dr_serial1,dr_serial2 FROM detalle_remision WHERE ");
     
                    if(obj.next()==true)
                    {
                        JOptionPane.showMessageDialog(null,"No se puede remisionar el rango de tiquetes!");
                    }
                        else
                        {
                            nueva.executeUpdateQuery("INSERT INTO ventas.detalle_remision (dr_serial1,dr_serial2,id_etp,id_remision)VALUES("+detalle.getSerial_inicial()+", "+detalle.getSerial_final()+", "+detalle.getEspeTiquetePrepago()+", "+detalle.getId_remision()+")");
                            nueva.executeUpdateQuery("BEGIN;");
                            nueva.executeUpdateQuery("UPDATE inventario.consecutivos set conse_estado=false WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+"");
                            this.confirmarTransaccion();
                        
                        }
                            nueva.desconectar();
                }
            
                  else
                 {   
                    JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                    nueva.desconectar();
                 }   
        }
            } catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    
    
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
