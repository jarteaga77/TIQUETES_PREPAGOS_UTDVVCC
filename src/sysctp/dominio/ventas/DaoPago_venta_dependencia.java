
package sysctp.dominio.ventas;

import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoPago_venta_dependencia 
{
    
    private ConexionBD nueva=new ConexionBD();
    
    
    public void registrarPago(Pago_venta_dependencia pago)
    {
        nueva.executeUpdateQuery("INSERT INTO ventas.pago_ven_dep(fp_ven_dep,pago_monto,ven_dep_id)VALUES("+pago.getFp()+","+pago.getPago_monto()+", "+pago.getVen_dep_id()+")");
        nueva.desconectar();
    }
    
    public void eliminarPago(long id_pago)
    {
        nueva.executeUpdateQuery("DELETE FROM pago_ven_dep WHERE pago_ven_dep="+id_pago+"");
        nueva.desconectar();
    }
    
}
