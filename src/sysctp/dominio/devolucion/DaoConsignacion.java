
package sysctp.dominio.devolucion;

import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoConsignacion 
{
    private ConexionBD conexion=new ConexionBD();
    
    public void registroConsignacion(Consignacion con)
    {
        conexion.executeUpdateQuery("INSERT INTO ventas.consignacion(cta_cliente, banco_cliente,tipo_cuenta_cliente,vlor_cosnginado,id_devolucion,fecha_consignacion)VALUES('"+con.getCta_cliente()+"', '"+con.getBanco_cliente()+"', '"+con.getTipo_cta()+"', "+con.getVlorconsignado()+", "+con.getId_devolucion()+", '"+con.getFecha_cons()+"')");
        conexion.desconectar();
    }
    
}
