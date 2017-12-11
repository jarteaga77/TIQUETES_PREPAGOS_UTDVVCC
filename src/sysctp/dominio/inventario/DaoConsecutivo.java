
package sysctp.dominio.inventario;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoConsecutivo 
{

   ConexionBD nueva=new ConexionBD();

    public void guardar(Consecutivo con)
    {
        try
        {
            
            ResultSet obj=nueva.executeQuery("SELECT conse_num_consecutivo_tiqute FROM inventario.consecutivos where conse_num_consecutivo_tiqute BETWEEN "+con.getConsecutivo_Inicial()+" AND "+con.getConsecutivo_Final()+" ");
            int total=(int) (con.getConsecutivo_Final()-con.getConsecutivo_Inicial());
            
            if(obj.next()==false)
            {
                 for(long i=con.getConsecutivo_Inicial(); i<=con.getConsecutivo_Final(); i++ )
            {
             nueva.executeUpdateQuery("INSERT INTO inventario.consecutivos (conse_num_consecutivo_tiqute,conse_remision,fecha_ingreso,id_usuario,fecha_remision,conse_estado,observacion)VALUES("+i+","+con.getRemision()+", '"+con.getFecha()+"', "+con.getId_usuario()+", '"+con.getFecha_remision()+"', "+con.isEstado()+", '"+con.getObse()+"')");
             System.out.println("Consecutivo N°: "+ i);
             nueva.desconectar();
             
             }
        
            JOptionPane.showMessageDialog(null, "Se ingresaron con exito los consecutivos" + "\n Cantidad Tiquetes: "+total );
            }else
            {
                JOptionPane.showMessageDialog(null, "Los consecutivos de tiquete entre " + con.getConsecutivo_Inicial() +"\n" + " y "+con.getConsecutivo_Final() +" Ya fueron ingresados" );
            }
            
   
        }catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
