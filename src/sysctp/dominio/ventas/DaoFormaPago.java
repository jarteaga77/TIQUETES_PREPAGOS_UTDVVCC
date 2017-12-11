
package sysctp.dominio.ventas;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */



public class DaoFormaPago 

{
    ConexionBD nueva=new  ConexionBD();
   

    public DaoFormaPago() 
    {}
    
    public void guardar(FormaPago ofp)
    {
        try
        {
        
            nueva.executeUpdateQuery("INSERT INTO ventas.forma_de_pago (fp_descripcion)VALUES('"+ofp.getDescri()+"')");
            JOptionPane.showMessageDialog(null, "Se ingreso con exito la forma de pago");
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    public void eliminar(int idFormaPago)
    {
        try
        {
            nueva.executeUpdateQuery("DELETE From ventas.forma_de_pago  where fp_id="+idFormaPago+"");
            JOptionPane.showMessageDialog(null, "Se elimino exitosamente la forma de pago");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}
