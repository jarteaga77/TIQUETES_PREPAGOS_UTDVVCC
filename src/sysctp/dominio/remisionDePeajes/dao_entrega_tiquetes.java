
package sysctp.dominio.remisionDePeajes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class dao_entrega_tiquetes 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    private static int id_entrega;

    public static int getId_entrega() {
        return id_entrega;
    }

    public static void setId_entrega(int id_entrega) {
        dao_entrega_tiquetes.id_entrega = id_entrega;
    }
    
    public void reg_entrega_Tiquetes(entrega_tiquetes entrega)
    {
        ResultSet obj=conexion.executeQuery("INSERT INTO ventas.entrada_tiquetes_peajes(fecha_registro,fecha_remision,consecutivo,remitente,id_peaje,observacion,id_usuario)VALUES('"+entrega.getFecha_registro()+"','"+entrega.getFecha_remision()+"', '"+entrega.getConsecutivo()+"', '"+entrega.getRemitente()+"',"+entrega.getId_peaje()+",'"+entrega.getObser()+"',"+entrega.getId_usuario()+")RETURNING id_en_tiq");
        try {
            while(obj.next()==true)
            {
                setId_entrega(obj.getInt("id_en_tiq"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            conexion.desconectar();
        }
        conexion.desconectar();
    }
    
}
