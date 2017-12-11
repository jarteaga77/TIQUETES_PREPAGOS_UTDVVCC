
package sysctp.dominio.remisionDePeajes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class dao_deta_entrega_tiquetes 

{
      private ConexionBD conexion=new ConexionBD();

     public void registrarDetalle(detalle_entrega_tiquetes detalle)
    {
   try {
            ResultSet obj1=conexion.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
           
        if (obj1.next()==true)
        {
            long maximo=obj1.getLong("maximo");
            long minimo=obj1.getLong("minimo");
            
            if(detalle.getSerial_ini() >= minimo && detalle.getSerial_fin()<= maximo )
            {
  
             ResultSet obj=conexion.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+detalle.getSerial_ini()+" AND "+detalle.getSerial_fin()+" AND conse_estado=false");
      
            if(obj.next()==true)
            {
                conexion.executeUpdateQuery("BEGIN;");
                conexion.executeUpdateQuery("INSERT INTO ventas.deta_entrega_tiq_peaje(id_etp, serial_ini, serial_fin, id_ent_tiq_pea)VALUES("+detalle.getId_etp()+", "+detalle.getSerial_ini()+", "+detalle.getSerial_fin()+", "+detalle.getId_entregaTiqPeajes()+")");                
                conexion.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_ini()+" AND "+detalle.getSerial_fin()+" ");
                this.confirmarTransaccion();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Los Consecutivo de tiquetes ingresados no se encuentra en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                //conexion.desconectar();
            }
          } 
           else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                //conexion.desconectar();
            }
            
            
         }   
        } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                  cancelarTransaccion();  
                  conexion.desconectar();
        }
   
    }
    
        public void confirmarTransaccion()
    {
        try
        {
            conexion.executeUpdateQuery("COMMIT;");
            
            System.out.println("Pase por aqui");
            conexion.desconectar();

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
            conexion.executeUpdateQuery("ROLLBACK;");
            conexion.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
}
