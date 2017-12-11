
package sysctp.dominio.devolucion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalle_devolucion 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    public void registroDetalle(Detalle_devolucion detalle)
    {
      try {  
        ResultSet obj1=conexion.executeQuery("SELECT MAX(conse_num_consecutivo_tiqute)AS maximo,MIN(conse_num_consecutivo_tiqute)AS minimo FROM inventario.consecutivos");
          if (obj1.next()==true)
          {
           
           long maximo=obj1.getLong("maximo");
           long minimo=obj1.getLong("minimo");
            
            if(detalle.getSerial_inicial() >= minimo && detalle.getSerial_final()<= maximo )
            { 
        
        
            ResultSet obj=conexion.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_estado="+false+" AND puv="+true+" AND conse_num_consecutivo_tiqute BETWEEN "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+"");
    
            if(obj.next()==true)
            {
               conexion.executeUpdateQuery("INSERT INTO ventas.detalle_devolucion (id_etp, serial_inicial,serial_final,id_devolucion)VALUES("+detalle.getId_etp()+","+detalle.getSerial_inicial()+","+detalle.getSerial_final()+","+detalle.getId_devolucion()+")");
               
               conexion.executeUpdateQuery("BEGIN");               
               conexion.executeUpdateQuery("UPDATE inventario.consecutivos SET conse_estado="+true+" WHERE conse_num_consecutivo_tiqute between "+detalle.getSerial_inicial()+" AND "+detalle.getSerial_final()+"");
               this.confirmarTransaccion();
               conexion.desconectar();   
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Rango de los tiquetes no se encuentran registrados en el inventario. \n y/o el rango no cumple con las condiciones ", "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
           else
            {
                JOptionPane.showMessageDialog(null,"El serial inicial es inferior al Minimo tiquete en el inventario y/o el serial final supera el último tiquete en inventario", "Error", JOptionPane.ERROR_MESSAGE);
                conexion.desconectar();
            }  
            
       }   
        } catch (SQLException ex) {
            Logger.getLogger(DaoDetalle_devolucion.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    } 
       public void confirmarTransaccion()
    {
        try
        {
            conexion.executeUpdateQuery("COMMIT");
        
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
            conexion.executeUpdateQuery("ROLLBACK");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
