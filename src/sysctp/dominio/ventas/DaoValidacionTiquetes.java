
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
public class DaoValidacionTiquetes 
{
    
    private ConexionBD nueva=new ConexionBD();
    
     private static long id_validacion;

    public static long getValidacion_id() {
        return id_validacion;
    }

    public static void setValidacion_id(long id_validacion) {
        DaoValidacionTiquetes.id_validacion = id_validacion;
    }
    
    
    public void registrovalidacion(Validacion_tiquetes revalidacion)
    {
        ResultSet obj=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes WHERE recibo_caja="+revalidacion.getRecibo_caja()+"");
        ResultSet obj1=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+revalidacion.getRecibo_caja()+"");
        ResultSet obj3=nueva.executeQuery("SELECT recibo_caja FROM ventas.validacion_tiquetes_dependencias WHERE recibo_caja="+revalidacion.getRecibo_caja()+"");
        //ResultSet obj4=nueva.executeQuery("SELECT recibo_caja FROM ventas.cancelacion_excedente_dependencia WHERE recibo_caja="+revalidacion.getRecibo_caja()+"");    
        
        try {
            if(obj.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: "+revalidacion.getRecibo_caja() +" Se utilizó en Validación de Tiquetes.!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
            else if(obj1.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: " + revalidacion.getRecibo_caja()+ " se anuló anteriormente", "Alerta!", JOptionPane.WARNING_MESSAGE);

            }
            else if(obj3.next()==true)
            {
                JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: "+revalidacion.getRecibo_caja() +" Se utilizó en Validación de Tiquetes Dependencia.!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
//                else if(obj4.next()==true)
//                {
//                  JOptionPane.showMessageDialog(null, "El Recibo de Caja N°: "+revalidacion.getRecibo_caja() +" Se utilizó en Cancelación Excedente Dependencia.!", "Alerta!", JOptionPane.WARNING_MESSAGE);
//
//                }
                    else{
                            ResultSet obj2 =nueva.executeQuery("INSERT INTO ventas.validacion_tiquetes(recibo_caja,observacion,fecha_validacion,id_sede_cliente,id_usuario)VALUES("+revalidacion.getRecibo_caja()+", '"+revalidacion.getObse()+"', '"+revalidacion.getFecha_revalidacion()+"', "+revalidacion.getId_sede()+", "+revalidacion.getId_usuario()+")RETURNING id_revalidacion");
                            //JOptionPane.showMessageDialog(null,"Se registro con exito la validación de los tiquetes");
               
            while(obj2.next()==true)
            {
                setValidacion_id(obj2.getLong("id_revalidacion"));
            }
           }
            nueva.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoValidacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
