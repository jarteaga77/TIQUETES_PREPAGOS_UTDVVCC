/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.dominio.remisionDePeajes;

/**
 *
 * @author jarteaga
 */
public class detalle_entrega_tiquetes 
{
    
    private int id_etp;
    private long serial_ini;
    private long serial_fin;
    private int id_entregaTiqPeajes;

    public int getId_etp() {
        return id_etp;
    }

    public void setId_etp(int id_etp) {
        this.id_etp = id_etp;
    }

    public long getSerial_ini() {
        return serial_ini;
    }

    public void setSerial_ini(long serial_ini) {
        this.serial_ini = serial_ini;
    }

    public long getSerial_fin() {
        return serial_fin;
    }

    public void setSerial_fin(long serial_fin) {
        this.serial_fin = serial_fin;
    }

    public int getId_entregaTiqPeajes() {
        return id_entregaTiqPeajes;
    }

    public void setId_entregaTiqPeajes(int id_entregaTiqPeajes) {
        this.id_entregaTiqPeajes = id_entregaTiqPeajes;
    }
    
    
    
    
    
    
}
