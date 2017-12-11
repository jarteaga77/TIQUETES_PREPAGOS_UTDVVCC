
package sysctp.dominio.ventas;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Validacion_tiquetes 

{
    private long recibo_caja;
    private String obse;
    private int id_usuario;
    private long id_sede;
    private Date fecha_revalidacion;

    public long getRecibo_caja() {
        return recibo_caja;
    }

    public void setRecibo_caja(long recibo_caja) {
        this.recibo_caja = recibo_caja;
    }

    public String getObse() {
        return obse;
    }

    public void setObse(String obse) {
        this.obse = obse;
    }

    public Date getFecha_revalidacion() {
        return fecha_revalidacion;
    }

    public void setFecha_revalidacion(Date fecha_revalidacion) {
        this.fecha_revalidacion = fecha_revalidacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_sede() {
        return id_sede;
    }

    public void setId_sede(long id_sede) {
        this.id_sede = id_sede;
    }
    
    
    
    
    
    
    
}
