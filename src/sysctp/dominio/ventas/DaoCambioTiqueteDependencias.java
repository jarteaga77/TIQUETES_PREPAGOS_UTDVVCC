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
public class DaoCambioTiqueteDependencias 

{
    private static long id_actaCambio;
    ConexionBD nueva=new ConexionBD();

    public static long getId_actaCambio() {
        return id_actaCambio;
    }

    public static void setId_actaCambio(long id_actaCambio) {
        DaoCambioTiqueteDependencias.id_actaCambio = id_actaCambio;
    }

    
    
    public DaoCambioTiqueteDependencias() {

    }
    
    public void guardar(CambioTiqueteDependencias ctp)
    {
            ResultSet obj =nueva.executeQuery("INSERT INTO ventas.cambio_tiquete_dependencias(fecha,id_dependencia,nombre_persona_recibe,apellido_persona_recibe,cedula_persona_recibe, observaciones, id_usuario)VALUES('"+ctp.getFecha()+"',"+ctp.getDependencia()+",'"+ctp.getNombre()+"','"+ctp.getApellido()+"',"+ctp.getCedula()+", '"+ctp.getObservaciones()+"', "+ctp.getId_usuario()+")RETURNING id_acta_consecutivo"); 
            JOptionPane.showMessageDialog(null, "Se guardo con exito el Acta de cambio" );
        try {
            while(obj.next()==true)
                 {
                     setId_actaCambio(obj.getLong("id_acta_consecutivo"));
                 }
            nueva.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCambioTiqueteDependencias.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}  

