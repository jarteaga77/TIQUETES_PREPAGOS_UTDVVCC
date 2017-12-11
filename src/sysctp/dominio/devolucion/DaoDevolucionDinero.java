
package sysctp.dominio.devolucion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;
import sysctp.dominio.remisionTiqueteria.DaoRemisionTiqueteria;

/**
 *
 * @author jarteaga
 */
public class DaoDevolucionDinero 
{
    
    private ConexionBD conexion=new ConexionBD();
    private static long id_devolucion;
    
    public static long getID_devo()
    {
        return id_devolucion;
    }
    
     public static void setID_devo(long id_devo) {
        DaoDevolucionDinero.id_devolucion = id_devo;
    }
    
    public void guardarDevolucion(Devolucion_dinero devo)
    {
       ResultSet obj=conexion.executeQuery("INSERT INTO ventas.devolucion_dinero (recibo_caja, observaciones,id_sede_cliente,oficio_cliente,fecha,id_usuario)VALUES("+devo.getRecibo_caja()+", '"+devo.getObservaciones()+"', "+devo.getSede()+", '"+devo.getOficio_cliente()+"', '"+devo.getFecha()+"', "+devo.getId_usuario()+") RETURNING id_devolucion_dinero");
       
       try {
            while(obj.next()==true)
                 {
                     setID_devo(obj.getLong("id_devolucion_dinero"));
                 }
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DaoRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
