
package sysctp.dominio.ventas;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoPagoValidacionesDepe 
{
    private ConexionBD nueva=new ConexionBD();

    public void registrarPagoValidaciones(PagoValidacionesDepe pago)
    {
        try
        {
            nueva.executeUpdateQuery("INSERT INTO ventas.pago_validacion_depe(id_fp,id_ctaban,id_validacion,pago_validacion)VALUES("+pago.getId_formaPago()+","+pago.getId_ctaBanco()+","+pago.getIdvalidacion()+", "+pago.getPagoValidacion()+")");
            nueva.desconectar();
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
