package sysctp.dominio.remisionTiqueteria;

/**
 *
 * @author jarteaga
 */
public class Detalle_remision 
{
    
    private long serial_inicial;
    private long serial_final;
    private int espeTiquetePrepago;
    private long id_remision;

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

    public int getEspeTiquetePrepago() {
        return espeTiquetePrepago;
    }

    public void setEspeTiquetePrepago(int espeTiquetePrepago) {
        this.espeTiquetePrepago = espeTiquetePrepago;
    }

    public long getId_remision() {
        return id_remision;
    }

    public void setId_remision(long id_remision) {
        this.id_remision = id_remision;
    }
    
    
    
    
}
