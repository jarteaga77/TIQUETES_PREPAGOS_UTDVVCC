
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
 * Clase que encapsula los datos de una categoría de los tiquetes prepagos
 *
 * @author James Andres Payan Caicedo
 */
@Entity
@Table(name="inventario.categoria")
public class Categoria implements IElementoDeRegistro{
    
    private long id;
    private String nombre;
    
    
    /**
     * Constructor por defecto (necesario para hibernate)
     * 
     */
    public Categoria () {}

    /**
     * Getter del Identificador de categoría
     * 
     * @return el identificador de la categoría
     */
    @Override
    @Id
    @GeneratedValue(generator="gen_cat_id")
    @GenericGenerator(
            name="gen_cat_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="inventario.categoria_cat_id_seq")
            }
     )
    @Column(name="cat_id")
    public long getId() {
        return id;
    }

    
    /**
     * Setter del Identificador de categoría
     * 
     * @param id identificador a ser asignado
     */
    @Override
    public void setId(long id) {
        this.id=id;
    }

    /**
     * Getter del nombre
     * 
     * @return el nombre de la categoría
     */
    @Column(name="cat_nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * 
     * @param nombre el nombre a ser asignado a la categoría
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
