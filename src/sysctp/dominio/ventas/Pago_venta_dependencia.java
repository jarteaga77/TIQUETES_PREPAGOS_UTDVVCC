
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */
public class Pago_venta_dependencia 
{
    
    private long ven_dep_id;
    private int fp;//Forma de pago
    private long pago_monto;

    public long getVen_dep_id() {
        return ven_dep_id;
    }

    public void setVen_dep_id(long ven_dep_id) {
        this.ven_dep_id = ven_dep_id;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public long getPago_monto() {
        return pago_monto;
    }

    public void setPago_monto(long pago_monto) {
        this.pago_monto = pago_monto;
    }
    
    
    
    
    
}
