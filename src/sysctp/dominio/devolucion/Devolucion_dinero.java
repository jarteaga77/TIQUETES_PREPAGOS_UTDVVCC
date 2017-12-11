
package sysctp.dominio.devolucion;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Devolucion_dinero 
{
    
    private long recibo_caja, sede;
    private String oficio_cliente, observaciones;
    private Date fecha;
    private int id_usuario;

    public long getRecibo_caja() {
        return recibo_caja;
    }

    public void setRecibo_caja(long recibo_caja) {
        this.recibo_caja = recibo_caja;
    }

    public long getSede() {
        return sede;
    }

    public void setSede(long sede) {
        this.sede = sede;
    }

    public String getOficio_cliente() {
        return oficio_cliente;
    }

    public void setOficio_cliente(String oficio_cliente) {
        this.oficio_cliente = oficio_cliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    
    
}
