
package sysctp.dominio.ventas;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class CambioTiquete 
{
    
    
    private Date fecha;
    private long cliente_sede;
    private String observaciones;
    private int id_usuario;
     
   //Datos de la persona que recibe el acta.
    private String nombre;
    private String apellido;   
    private long cedula;
    
   

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getCliente_sede() {
        return cliente_sede;
    }

    public void setCliente_sede(long cliente_sede) {
        this.cliente_sede = cliente_sede;
    }
    
    
  
}
