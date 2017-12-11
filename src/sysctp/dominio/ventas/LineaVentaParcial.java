
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */
public class LineaVentaParcial 


{
    private long serial_inicial;
    private long serial_final;
    private long vent_id;
    private int etp_id;

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

    public long getVent_id() {
        return vent_id;
    }

    public void setVent_id(long vent_id) {
        this.vent_id = vent_id;
    }

    public int getEtp_id() {
        return etp_id;
    }

    public void setEtp_id(int etp_id) {
        this.etp_id = etp_id;
    }

}
