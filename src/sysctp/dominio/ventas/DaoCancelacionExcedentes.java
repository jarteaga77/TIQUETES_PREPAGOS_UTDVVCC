
package sysctp.dominio.ventas;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoCancelacionExcedentes 
{
    private ConexionBD nueva=new ConexionBD();
    
    public void registroCancelacionExcedente(Cancelacion_Excedentes canExce)
    { 
        try
        {
 
        ResultSet obj=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+canExce.getRecibo_caja()+"");
        //ResultSet obj2=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedente_dependencia WHERE recibo_caja="+canExce.getRecibo_caja()+"");
        ResultSet obj3=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedentes WHERE recibo_caja="+canExce.getRecibo_caja()+"");
        ResultSet obj4=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes_dependencias WHERE recibo_caja="+canExce.getRecibo_caja()+"");

        if(obj.next()==true)
        {
            JOptionPane.showMessageDialog(null,"El recibo de caja N°: "+ canExce.getRecibo_caja()+ " se ha anulado con anterioridad.!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
            //        }else
//            if(obj2.next()==true)
//            {
//              JOptionPane.showMessageDialog(null,"El recibo de caja N°: "+ canExce.getRecibo_caja()+ " se utilizó en Cancelación Excedente Dependencia.!", "Alerta!", JOptionPane.WARNING_MESSAGE);
//            }
            else 
                if(obj3.next()==true)
                {
                  JOptionPane.showMessageDialog(null,"El recibo de caja N°: "+ canExce.getRecibo_caja()+ " se utilizó en Cancelación Excedente.!", "Alerta!", JOptionPane.WARNING_MESSAGE);

                }  
                    else if(obj4.next()==true)
                    {
                        JOptionPane.showMessageDialog(null,"El recibo de caja N°: "+ canExce.getRecibo_caja()+ " se utilzó en Validación Tiquetes Dependencia.!", "Alerta!", JOptionPane.WARNING_MESSAGE);

                    }
                    else
                {
                    nueva.executeUpdateQuery("INSERT INTO ventas.cancelacion_excedentes(recibo_caja,id_acta_cambio,id_fp,cban_id,pa_monto)VALUES("+canExce.getRecibo_caja()+", "+canExce.getIdActaCambio()+","+canExce.getId_formPago()+", "+canExce.getCtaBan()+","+canExce.getPa_monto()+")");
                    JOptionPane.showMessageDialog(null,"Se registro con exito Acta de cambio y cancelación excedentes!");
                    nueva.desconectar();
                }

        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
}
