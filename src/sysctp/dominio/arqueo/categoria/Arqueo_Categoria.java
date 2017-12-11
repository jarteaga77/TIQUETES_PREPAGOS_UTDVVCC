
package sysctp.dominio.arqueo.categoria;



import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Arqueo_Categoria 
{
    
    private int id_usuario;
    private int id_estacion;
    private long total_venta;
    private Date fechaIni;
    private Date fechaFin;
    private Date fecha_arqueo;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public long getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(long total_venta) {
        this.total_venta = total_venta;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFecha_arqueo() {
        return fecha_arqueo;
    }

    public void setFecha_arqueo(Date fecha_arqueo) {
        this.fecha_arqueo = fecha_arqueo;
    }
    

}
