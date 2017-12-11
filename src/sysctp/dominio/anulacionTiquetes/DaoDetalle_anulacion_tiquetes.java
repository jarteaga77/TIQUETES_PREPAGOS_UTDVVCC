
package sysctp.dominio.anulacionTiquetes;

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
public class DaoDetalle_anulacion_tiquetes 
{
    
    private ConexionBD nueva=new ConexionBD();
    
    public void adicionarDetalleAnulacion(Detalle_Anulacion_tiquetes detalleanulacion, long serial1, long serial2)
    {
        try
        {
            
       
                nueva.executeUpdateQuery("INSERT INTO inventario.detalle_anulacion_tiquetes (da_serial1,da_serial2,id_anulacion,id_tipo)VALUES("+detalleanulacion.getSerial_inicial()+", "+detalleanulacion.getSerial_final()+", "+detalleanulacion.getId_anulacion()+", "+detalleanulacion.getTipo_anulacion()+")");
                
                nueva.executeUpdateQuery("BEGIN;");
                nueva.executeUpdateQuery("DELETE FROM inventario.consecutivos WHERE conse_num_consecutivo_tiqute BETWEEN "+serial1+" AND "+serial2+" ");
                this.confirmarTransaccion();
            
            } catch (Exception e) 
            {
             Logger.getLogger(DaoDetalle_anulacion_tiquetes.class.getName()).log(Level.SEVERE, null, e);
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
