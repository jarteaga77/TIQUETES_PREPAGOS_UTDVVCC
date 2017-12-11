
package sysctp.dominio.remisionTiqueteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoRemisionTiqueteria 
{
    
    private ConexionBD nueva=new ConexionBD();
    private static long id_remision;

    public static long getId_remision() {
        return id_remision;
    }

    public static void setId_remision(long id_remision) {
        DaoRemisionTiqueteria.id_remision = id_remision;
    }

    public void registroRemision(RemisionTiqueteriaPeajes remision)
    {
        ResultSet obj=nueva.executeQuery("INSERT INTO ventas.remision_peaje (fecha_remision,id_peaje,observacion,id_usuario)VALUES('"+remision.getFecha_remision()+"',"+remision.getId_peaje()+",'"+remision.getObservacion()+"', "+remision.getId_usuario()+")RETURNING id_remision_peaje"); 
//        JOptionPane.showMessageDialog(null, "Se registro con exito la remisión!");
        try {
            while(obj.next()==true)
                 {
                     setId_remision(obj.getLong("id_remision_peaje"));
                 }
            nueva.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DaoRemisionTiqueteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
