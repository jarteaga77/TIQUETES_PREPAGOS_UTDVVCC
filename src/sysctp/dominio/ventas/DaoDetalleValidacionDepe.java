
package sysctp.dominio.ventas;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalleValidacionDepe 
{
    private ConexionBD nueva=new ConexionBD();
    public void regDetalleValidacion(DetalleValidacionDepe dvva)
    {
        try
        {
        nueva.executeUpdateQuery("INSERT INTO ventas.detalle_validacion_dependencias(cantidad,id_etp,vlor_validacion,id_validacion)VALUES("+dvva.getCantidad()+", "+dvva.getId_etp()+", "+dvva.getCosto_validacion()+", "+dvva.getId_validacion()+")");
        nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
   }
    
}
