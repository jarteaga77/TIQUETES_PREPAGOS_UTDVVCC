
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
 *
 * @author james
 */
@Entity
@Table(name="inventario.tipo_eje_adicional")
public class TipoEjeAdicional  implements IElementoDeRegistro{
    
    
    @Id
    @GeneratedValue(generator="gen_tea_id")
    @GenericGenerator(
            name="gen_tea_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="inventario.tipo_eje_adicional_tea_id_seq")
            }
     )
    @Column(name="tea_id")
    private long id;
    
    @Column(name="tea_nombre")
    private String nombre;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
