
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
public class DaoValidacionTiquetesDependencia 
{
    
    private ConexionBD nueva=new ConexionBD();
    
     private static long id_validacion;

    public static long getValidacion_id() {
        return id_validacion;
    }

    public static void setValidacion_id(long id_validacion) {
        DaoValidacionTiquetesDependencia.id_validacion = id_validacion;
    }
    
    
    public void registrovalidacion(Validacion_Tiquetes_Dependencia validacion)
    {
        ResultSet obj=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes WHERE recibo_caja="+validacion.getRecibo_caja()+"");
        ResultSet obj1=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+validacion.getRecibo_caja()+"");
        ResultSet obj3=nueva.executeQuery("SELECT ven_recibo_caja FROM ventas.venta where ven_recibo_caja="+validacion.getRecibo_caja()+"");
        ResultSet obj4=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes_dependencias WHERE recibo_caja="+validacion.getRecibo_caja()+"");

        try {
            if(obj.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: " + validacion.getRecibo_caja()+" Se utilizó en Validación de Tiquetes", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
            else if(obj1.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: " + validacion.getRecibo_caja()+" esta anulado. !" , "Alerta!", JOptionPane.WARNING_MESSAGE);

            }
            else if(obj3.next()==true)
            {
              JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: " + validacion.getRecibo_caja()+" se utilizó en una venta. !" , "Alerta!", JOptionPane.WARNING_MESSAGE);

            }
            
            else if(obj4.next()==true)
            {
              JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: " + validacion.getRecibo_caja()+" Se utilizó en Validación Tiquetes Dependencias. !" , "Alerta!", JOptionPane.WARNING_MESSAGE);

            }
            else{
                ResultSet obj2 =nueva.executeQuery("INSERT INTO ventas.validacion_tiquetes_dependencias(recibo_caja,observacion,fecha_validacion,id_dependencia,id_usuario)VALUES("+validacion.getRecibo_caja()+", '"+validacion.getObse()+"', '"+validacion.getFecha_revalidacion()+"', "+validacion.getId_itemDependencia()+", "+validacion.getId_usuario()+")RETURNING id_validacion");
               // JOptionPane.showMessageDialog(null,"Se registro con exito la validación de los tiquetes");
               
            while(obj2.next()==true)
            {
                setValidacion_id(obj2.getLong("id_validacion"));
            }
           }
            nueva.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoValidacionTiquetesDependencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
