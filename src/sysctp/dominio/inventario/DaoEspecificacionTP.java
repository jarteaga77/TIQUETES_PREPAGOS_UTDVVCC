
package sysctp.dominio.inventario;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoEspecificacionTP 
{
    
    ConexionBD nueva=new ConexionBD();
    public void guardar(EspecificacionTP etp)
    {
        try
        {
            
            nueva.executeUpdateQuery("INSERT INTO inventario.especificacion_tiquete_prepago (etp_anio,etp_precio,cat_id,tea_id)VALUES"
                    + "("+etp.getAño()+","+etp.getPrecio()+", "+etp.getCate()+","+etp.getTea()+")");
            
            JOptionPane.showMessageDialog(null, "Se guardo con exito Especificacion Tiquete Prepago");
            nueva.desconectar();
            
        }catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
