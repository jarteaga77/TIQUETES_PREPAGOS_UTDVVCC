
package sysctp.dominio.ventas;

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
public class DaoAnulacionReciboCaja 
{
    
    private ConexionBD nueva=new ConexionBD();
    
    
    
    public void anularRecibo(AnulacionReciboCaja anulacion)
    {
        ResultSet obj=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedentes WHERE recibo_caja="+anulacion.getNumReciboCaja()+"");
        ResultSet obj2=nueva.executeQuery("SELECT ven_recibo_caja FROM ventas.venta WHERE ven_recibo_caja="+anulacion.getNumReciboCaja()+"");
        ResultSet obj3=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+anulacion.getNumReciboCaja()+"");
        //ResultSet obj4=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedente_dependencia WHERE recibo_caja="+anulacion.getNumReciboCaja()+"");
        ResultSet obj5=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes WHERE recibo_caja="+anulacion.getNumReciboCaja()+"");
        ResultSet obj6=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes_dependencias WHERE recibo_caja="+anulacion.getNumReciboCaja()+"");

        try {
            if(obj.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " fue utilizado para cancelación de excedentes", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            else
                if(obj2.next()==true)
                {
                    JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " fue utilizado para una venta", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            else
                    if(obj3.next()==true)
                    {
                      JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " ya fue anulado anteriormente", "Alerta", JOptionPane.WARNING_MESSAGE);

                    }
                    
//                    else if(obj4.next()==true)
//                    {
//                       JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " se utilizó en Cancelación Excedentes a Dependencias!", "Alerta", JOptionPane.WARNING_MESSAGE);
//
//                    }
                    else if(obj5.next()==true)
                    {
                       JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " se utilizó en Validación Tiquetes.!", "Alerta", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(obj6.next()==true)
                    {
                        JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " se utilizó en Validación Tiquetes Dependencias.!", "Alerta", JOptionPane.WARNING_MESSAGE);

                    }
            else
                    {
                        nueva.executeUpdateQuery("INSERT INTO ventas.anulacion_recibo_caja(numero_recibo,observacion,fecha_hora,id_usuario)VALUES("+anulacion.getNumReciboCaja()+", '"+anulacion.getObservacion()+"', '"+anulacion.getFecha_hora()+"', "+anulacion.getId_usuario()+")");
                        JOptionPane.showMessageDialog(null, "El recibo de caja N°: "+anulacion.getNumReciboCaja()+ " se anulo correctamente");

                    }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAnulacionReciboCaja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
}
