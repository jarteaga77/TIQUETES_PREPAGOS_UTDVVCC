
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */
public class Detalle_venta_dependencia 
{
    private long dvd_serial_1;
    private long dvd_serial_2;
    private long ven_dep_id;
    private int etp;//Especificacion tiquete prepago

    public long getDvd_serial_1() {
        return dvd_serial_1;
    }

    public void setDvd_serial_1(long dvd_serial_1) {
        this.dvd_serial_1 = dvd_serial_1;
    }

    public long getDvd_serial_2() {
        return dvd_serial_2;
    }

    public void setDvd_serial_2(long dvd_serial_2) {
        this.dvd_serial_2 = dvd_serial_2;
    }

    public long getVen_dep_id() {
        return ven_dep_id;
    }

    public void setVen_dep_id(long ven_dep_id) {
        this.ven_dep_id = ven_dep_id;
    }

    public int getEtp() {
        return etp;
    }

    public void setEtp(int etp) {
        this.etp = etp;
    }
    
    
    
    
}
