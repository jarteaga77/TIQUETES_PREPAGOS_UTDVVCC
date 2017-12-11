
package sysctp.dominio.ventas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoVentas_dependencias 
{
    private ConexionBD nueva=new ConexionBD();
    
    private static long ven_dep_id;

    public static long getVen_dep_id() {
        return ven_dep_id;
    }

    public static void setVen_dep_id(long ven_dep_id) {
        DaoVentas_dependencias.ven_dep_id = ven_dep_id;
    }
 
    public void registrarVentaDependencia(Venta_dependencias ven_dep) 
    {
        ResultSet obj=nueva.executeQuery("INSERT INTO ventas.venta_dependencia(ven_dep_fecha,item_dependecia,ven_dep_obse,id_usuario)VALUES('"+ven_dep.getVen_dep_fecha()+"',"+ven_dep.getId_item_depen()+", '"+ven_dep.getVen_dep_obse()+"', "+ven_dep.getId_iusuario()+")RETURNING ven_dep_id");
        try {
            while(obj.next()==true)
            {
                setVen_dep_id(obj.getLong("ven_dep_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoVentas_dependencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.desconectar();
    }
}
