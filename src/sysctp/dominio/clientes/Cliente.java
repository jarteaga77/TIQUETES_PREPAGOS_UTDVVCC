

package sysctp.dominio.clientes;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 * Clase que encapsula los datos de un cliente
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="clientes.cliente")
public class Cliente implements IElementoDeRegistro, Serializable{
    private long id; // identificador de cliente
    private String razonSocial;
   

    /**
     * Constructor por defecto (necesario para hibernate)
     * 
     */
    public Cliente(){   
    }
    /**
     * Getter del ID
     * 
     * @return la identificación del cliente - NIT o Cedula
     */
    @Override
    @Id
    @Column(name="cli_nit")
    public long getId() {
        return id;
    }

    /**
     * Setter del ID
     * 
     * @param id la identificación a ser asignada
     */
    @Override
    public void setId(long id) {
        this.id=id;
    }

    /**
     * Getter de la razon social
     * 
     * @return la razonSocial o nombre del cliente
     */
    @Column(name="cli_razon_social")
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Setter de la razon social
     * 
     * @param razonSocial la razonSocial o nombre de cliente a ser asignado
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString(){
        return razonSocial;
    }
}
