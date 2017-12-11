
package sysctp.dominio.ventas;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class AnulacionReciboCaja 
{
    
    private long numReciboCaja;
    private String observacion;
    private Date fecha_hora;
    private int id_usuario;

    public long getNumReciboCaja() {
        return numReciboCaja;
    }

    public void setNumReciboCaja(long numReciboCaja) {
        this.numReciboCaja = numReciboCaja;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    
    
    
}
