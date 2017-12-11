
package sysctp.dominio.anulacionTiquetes;

/**
 *
 * @author jarteaga
 */
public class Detalle_Anulacion_tiquetes 
{
    private long serial_inicial;
    private long serial_final;
    private long id_anulacion;
    private int tipo_anulacion;
    

    public long getSerial_inicial() {
        return serial_inicial;
    }

    public void setSerial_inicial(long serial_inicial) {
        this.serial_inicial = serial_inicial;
    }

    public long getSerial_final() {
        return serial_final;
    }

    public void setSerial_final(long serial_final) {
        this.serial_final = serial_final;
    }

    public long getId_anulacion() {
        return id_anulacion;
    }

    public void setId_anulacion(long id_anulacion) {
        this.id_anulacion = id_anulacion;
    }

    public int getTipo_anulacion() {
        return tipo_anulacion;
    }

    public void setTipo_anulacion(int tipo_anulacion) {
        this.tipo_anulacion = tipo_anulacion;
    }
    
    
    
    
}
