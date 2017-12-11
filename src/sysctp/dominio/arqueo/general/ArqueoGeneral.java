
package sysctp.dominio.arqueo.general;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class ArqueoGeneral 

{

    private Date fecha_hora;
    private int id_usuario;
    private long totalSistema;
    private long total_vendidos;
    private long total_anulados;
    private long total_disponibles;
    private long total_remisionados;
    private long total_anu_mala_per;
    private long total_devue_cli;
    private long total_anu_provee;

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

    public long getTotalSistema() {
        return totalSistema;
    }

    public void setTotalSistema(long totalSistema) {
        this.totalSistema = totalSistema;
    }

    public long getTotal_vendidos() {
        return total_vendidos;
    }

    public void setTotal_vendidos(long total_vendidos) {
        this.total_vendidos = total_vendidos;
    }

   

    public long getTotal_disponibles() {
        return total_disponibles;
    }

    public void setTotal_disponibles(long total_disponibles) {
        this.total_disponibles = total_disponibles;
    }

    public long getTotal_remisionados() {
        return total_remisionados;
    }

    public void setTotal_remisionados(long total_remisionados) {
        this.total_remisionados = total_remisionados;
    }

    public long getTotal_anulados() {
        return total_anulados;
    }

    public void setTotal_anulados(long total_anulados) {
        this.total_anulados = total_anulados;
    }

    public long getTotal_anu_mala_per() {
        return total_anu_mala_per;
    }

    public void setTotal_anu_mala_per(long total_anu_mala_per) {
        this.total_anu_mala_per = total_anu_mala_per;
    }

    public long getTotal_devue_cli() {
        return total_devue_cli;
    }

    public void setTotal_devue_cli(long total_devue_cli) {
        this.total_devue_cli = total_devue_cli;
    }

    public long getTotal_anu_provee() {
        return total_anu_provee;
    }

    public void setTotal_anu_provee(long total_anu_provee) {
        this.total_anu_provee = total_anu_provee;
    }
    
    
    
    
    
}
