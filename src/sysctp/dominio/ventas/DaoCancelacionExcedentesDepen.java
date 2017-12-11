
package sysctp.dominio.ventas;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoCancelacionExcedentesDepen 
{
    private ConexionBD nueva=new ConexionBD();
    
    public void registroCancelacionExcedente(Cancelacion_ExcedentesDepen canExce)
    { 
        try
        {
                    nueva.executeUpdateQuery("INSERT INTO ventas.cancelacion_excedente_dependencia(id_acta_cambio,id_fp,cban_id,pa_monto)VALUES("+canExce.getIdActaCambio()+","+canExce.getId_formPago()+", "+canExce.getCtaBan()+","+canExce.getPa_monto()+")");
                    JOptionPane.showMessageDialog(null,"Se registro con exito Acta de cambio y cancelación excedentes!");
                    nueva.desconectar();
         

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
}
