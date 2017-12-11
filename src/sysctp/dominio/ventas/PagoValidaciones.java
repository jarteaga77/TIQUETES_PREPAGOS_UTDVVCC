
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */
public class PagoValidaciones 
{
    
    private int id_formaPago;
    private int id_ctaBanco;
    private long idvalidacion;
    private long pagoValidacion;

    public int getId_formaPago() {
        return id_formaPago;
    }

    public void setId_formaPago(int id_formaPago) {
        this.id_formaPago = id_formaPago;
    }

    public int getId_ctaBanco() {
        return id_ctaBanco;
    }

    public void setId_ctaBanco(int id_ctaBanco) {
        this.id_ctaBanco = id_ctaBanco;
    }

    public long getIdvalidacion() {
        return idvalidacion;
    }

    public void setIdvalidacion(long idvalidacion) {
        this.idvalidacion = idvalidacion;
    }

    public long getPagoValidacion() {
        return pagoValidacion;
    }

    public void setPagoValidacion(long pagoValidacion) {
        this.pagoValidacion = pagoValidacion;
    }
    
    
    
    
    
}
