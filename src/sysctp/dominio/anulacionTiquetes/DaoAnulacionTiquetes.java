package sysctp.dominio.anulacionTiquetes;

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
public class DaoAnulacionTiquetes 
{
    private ConexionBD nueva=new ConexionBD();   
    private static long idanulacion;

    public static long getIdanulacion() {
        return idanulacion;
    }

    public static void setIdanulacion(long idanulacion) {
        DaoAnulacionTiquetes.idanulacion = idanulacion;
    }
   
    
  public void anularTiquete(AnulacionTiquetes anulacion)
  {
       ResultSet obj=nueva.executeQuery("INSERT INTO inventario.anulacion_tiquetes(fecha_anulacion,id_usuario,observacion)VALUES('"+anulacion.getFecha_anulacion()+"', "+anulacion.getId_usuario()+", '"+anulacion.getObservacion()+"')RETURNING id_anulacion_tiquete");
       JOptionPane.showMessageDialog(null, "Se registro con exito!");
        try {
              while(obj.next()==true)
              {
                  setIdanulacion(obj.getLong("id_anulacion_tiquete"));
              }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAnulacionTiquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
            nueva.desconectar();
   }
}
