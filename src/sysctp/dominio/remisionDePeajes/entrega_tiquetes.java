/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.dominio.remisionDePeajes;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class entrega_tiquetes 
{
    
    private Date fecha_registro;
    private Date fecha_remision;
    private String consecutivo;
    private String remitente;
    private int id_peaje;
    private long id_usuario;
    private String obser;

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_remision() {
        return fecha_remision;
    }

    public void setFecha_remision(Date fecha_remision) {
        this.fecha_remision = fecha_remision;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public int getId_peaje() {
        return id_peaje;
    }

    public void setId_peaje(int id_peaje) {
        this.id_peaje = id_peaje;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getObser() {
        return obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }
    
    
    
    
    
    
    
    
    
}
