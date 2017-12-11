
package sysctp.dominio.inventario;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Consecutivo 

{
    
    private long consecutivo_Inicial;
    private long consecutivo_Final;
    private long remision;
    private Date fecha;
    private int id_usuario;
    private Date fecha_remision;
    private boolean puv;
    private boolean estado;
    private String obse;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
    public long getConsecutivo_Final() {
        return consecutivo_Final;
    }

    public void setConsecutivo_Final(long consecutivo_Final) {
        this.consecutivo_Final = consecutivo_Final;
    }

    public long getConsecutivo_Inicial() {
        return consecutivo_Inicial;
    }

    public void setConsecutivo_Inicial(long consecutivo_Inicial) {
        this.consecutivo_Inicial = consecutivo_Inicial;
    }

    public long getRemision() {
        return remision;
    }

    public void setRemision(long remision) {
        this.remision = remision;
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

    public Date getFecha_remision() {
        return fecha_remision;
    }

    public void setFecha_remision(Date fecha_remision) {
        this.fecha_remision = fecha_remision;
    }

    public boolean isPuv() {
        return puv;
    }

    public void setPuv(boolean puv) {
        this.puv = puv;
    }

    public String getObse() {
        return obse;
    }

    public void setObse(String obse) {
        this.obse = obse;
    }
    
    
    
    
   
}
