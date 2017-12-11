
package sysctp.dominio.inventario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 * Clase que encapsula los datos de los tipos de tiquete prepago
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="inventario.tipo_tiquete_prepago")
public class TipoTiquetePrepago implements IElementoDeRegistro {
    
    private long id; // Identificador de tipo de tiquete prepago
    private String descripcion; // Descripción del Tipo de Tiquete Prepago

    /**
     * Metodo Constructor
     * 
     * @param descrip La descripcion del tipo de Tiquete
     */
    public TipoTiquetePrepago (String descrip) {
        descripcion = descrip;
    }
    
    /**
     * Constructor por defecto (necesario para hibernate)
     * 
     */
    public TipoTiquetePrepago () {}

    /**
     * Getter de la descripción del tipo de tiquete prepago
     * 
     * @return retorna la descripcion del Tipo de Tiquete Prepago
     */
    @Column(name="ttp_descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción del Tipo de Tiquete Prepago
     * 
     * @param descripcion es la descripcion a ser asignada
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter del identificador
     * 
     * @return el identificador del tipo de tiquete prepago
     */
    @Override
    @Id
    @GeneratedValue(generator="gen_ttp_id")
    @GenericGenerator(
            name="gen_ttp_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="inventario.tipo_tiquete_prepago_ttp_id_seq")
            }
     )
    @Column(name="ttp_id")
    public long getId() {
        return id;
    }

    /**
     * Setter del identificador
     * 
     * @param id el identificador a ser asignado
     */
    @Override
    public void setId(long id) {
        this.id=id;
    }
    
    public String toString(){
        return descripcion;
    }
}
