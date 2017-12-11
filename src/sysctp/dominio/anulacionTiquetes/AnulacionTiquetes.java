
package sysctp.dominio.anulacionTiquetes;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class AnulacionTiquetes 

{
    private Date fecha_anulacion;
    private int id_usuario;
    private String observacion;

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
}
