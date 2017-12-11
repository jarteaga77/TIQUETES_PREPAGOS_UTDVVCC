
package sysctp.dominio.inventario;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoTipoPrepago 

{
     ConexionBD nueva=new ConexionBD();
    
    public void guardar(TipoTiquetePrepago ttp)
    {
        
        try
        {
            
            nueva.executeUpdateQuery("INSERT INTO inventario.tipo_tiquete_prepago (ttp_descripcion)VALUES('"+ttp.getDescripcion()+"')");
            nueva.desconectar();
            
            JOptionPane.showMessageDialog(null, "Se guardo con exito el tipo de tiquete prepago");
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
                
        
        
        
        
    }
           
    
    
    
    
}
