
package sysctp.dominio.arqueo.general;

import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class Dao_Arqueo_General 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    public void registroArqueoGeneral(ArqueoGeneral arqueo)
    {
        conexion.executeUpdateQuery("INSERT INTO controles_arqueos.arqueo_general(fecha_hora_arqueo,id_usuario,total_sistema,total_vendidos,total_inhabilitados,total_disponibles,total_remisionados, total_falla, total_proveedor, total_cliente)VALUES('"+arqueo.getFecha_hora()+"', "+arqueo.getId_usuario()+", "+arqueo.getTotalSistema()+", "+arqueo.getTotal_vendidos()+", "+arqueo.getTotal_anulados()+", "+arqueo.getTotal_disponibles()+", "+arqueo.getTotal_remisionados()+", "+arqueo.getTotal_anu_mala_per()+", "+arqueo.getTotal_anu_provee()+", "+arqueo.getTotal_devue_cli()+")");
        conexion.desconectar();
    
    }
    
}
