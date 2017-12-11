
package sysctp.dominio.remisionTiqueteria;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class RemisionTiqueteriaPeajes 
{
    private Date fecha_remision;
    private int id_peaje;
    private String observacion;
    private int id_usuario;
    private long total_remision;

    public Date getFecha_remision() {
        return fecha_remision;
    }

    public void setFecha_remision(Date fecha_remision) {
        this.fecha_remision = fecha_remision;
    }

    public int getId_peaje() {
        return id_peaje;
    }

    public void setId_peaje(int id_peaje) {
        this.id_peaje = id_peaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getTotal_remision() {
        return total_remision;
    }

    public void setTotal_remision(long total_remision) {
        this.total_remision = total_remision;
    }
    
    
    
    
    
    
    
}
