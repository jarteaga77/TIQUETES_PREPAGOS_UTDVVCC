
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */
public class DetalleTiquetesRecibidosDepen 
{

    public long getId_actaCambio() {
        return id_actaCambio;
    }

    public void setId_actaCambio(long id_actaCambio) {
        this.id_actaCambio = id_actaCambio;
    }

    public int getId_espe_tiquete() {
        return id_espe_tiquete;
    }

    public void setId_espe_tiquete(int id_espe_tiquete) {
        this.id_espe_tiquete = id_espe_tiquete;
    }

    public long getSerial_final() {
        return serial_final;
    }

    public void setSerial_final(long serial_final) {
        this.serial_final = serial_final;
    }

    public long getSerial_inicial() {
        return serial_inicial;
    }

    public void setSerial_inicial(long serial_inicial) {
        this.serial_inicial = serial_inicial;
    }
    
    
  private int  id_espe_tiquete;
  private long id_actaCambio;
  private long serial_inicial;
  private long serial_final;
  
    
}
