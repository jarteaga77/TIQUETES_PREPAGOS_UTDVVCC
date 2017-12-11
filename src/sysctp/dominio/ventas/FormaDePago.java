
package sysctp.dominio.ventas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 * Encapsula la descripcion de una forma de pago. Esta especificación a su vez es descrita por el Tipo de Tiquete Prepago.
 * Esta clase implementa la interfaz IElementoDeRegistro para poder ser gestionada por un Registro (clase de la capa de servicios - gestión de persistencia)
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="ventas.forma_de_pago")
public class FormaDePago implements IElementoDeRegistro {
    
    @Id
    @GeneratedValue(generator="gen_fp_id")
    @GenericGenerator(
            name="gen_fp_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="ventas.forma_de_pago_fp_id_seq")
            }
     )
    @Column(name="fp_id")
    private long id; // identificador de la forma de pago
    
    @Column(name="fp_descripcion")
    private String descripcion; // descripcion de la forma de pago

    /**
     * Getter del identificador de forma de pago
     * 
     * @return el identificador
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Setter del identificador de forma de pago
     * 
     * @param id el identificador a ser asignado
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter de la descripcion de la forma de pago
     * 
     * @return la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion de la forma de pago
     * 
     * @param descripcion la descripcion a ser asignada
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString(){
        return descripcion;
    }
    
}
