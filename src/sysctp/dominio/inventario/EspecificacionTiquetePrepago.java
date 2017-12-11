
package sysctp.dominio.inventario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 * Describe el precio y el año de un tiquete prepago. Esta especificación a su vez es descrita por el Tipo de Tiquete Prepago.
 * Esta clase implementa la interfaz IElementoDeRegistro para poder ser gestionada por un Registro (clase de la capa de servicios - gestión de persistencia)
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="inventario.especificacion_tiquete_prepago")
public class EspecificacionTiquetePrepago implements IElementoDeRegistro{
    
    @Id
    @GeneratedValue(generator="gen_etp_id")
    @GenericGenerator(
            name="gen_etp_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="inventario.especificacion_tiquete_prepago_etp_id_seq")
            }
     )
    @Column(name="etp_id")
    private long id; // Identificador de Especificación de tiquete prepago
    
    @Column(name="etp_anio")
    private int año; // año para el cual la especificación es valida.
    
    @Column(name="etp_precio")
    private long precio; // Precio de la especificación.
     
    @ManyToOne(optional=false)
    @JoinColumn(name="cat_id")
    private Categoria cate;// Categoria que describe está especificación
    
    @ManyToOne(optional=false)
    @JoinColumn(name="tea_id")
    private TipoEjeAdicional tea;// Eje Adcional que describe está especificación
    
    
    /**
     * Constructor indicando año, precio categoria y eje adicional
     *
     * @param año El año para el cual está especificación es valida
     * @param precio El precio de esta especificación
     * @param cate Categoria de tiquete prepago.
     * @param tea Eje Adicional .
     */
    public EspecificacionTiquetePrepago(int año, int precio, Categoria cate,TipoEjeAdicional tea){
        this.año=año; this.precio=precio; this.cate=cate; this.tea=tea;
    }
    
    /**
     * Constructor por defecto (necesario para hibernate)
     * 
     */
    public EspecificacionTiquetePrepago(){
        
    }

     /**
     * Getter Categoria
     * 
     * @return Categoria
     */
    
    public Categoria getCate() {
        return cate;
    }

      /**
     * Setter Categoria
     * 
     * @param cate Categoria a ser asignado
     */
    public void setCate(Categoria cate) {
        this.cate = cate;
    }
    
      /**
     * Getter Eje Adicional
     * 
     * @return Eje adicional
     */

    public TipoEjeAdicional getTea() {
        return tea;
    }
      /**
     * Setter de Eje Adicional
     * 
     * @param tea Eje Adicional a ser asignado
     */

    public void setTea(TipoEjeAdicional tea) {
        this.tea = tea;
    }

    /**
     * Getter del año
     * 
     * @return El Año
     */
    public int getAño() {
        return año;
    }

    /**
     * Setter del año
     * 
     * @param año El año a ser asignado.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Getter del precio
     * 
     * @return El Precio
     */
    public long getPrecio() {
        return precio;
    }

    /**
     * Setter del precio
     * 
     * @param precio El precio a ser asignado.
     */
    public void setPrecio(long precio) {
        this.precio = precio;
    }

 

    /**
     * Reescribe la función de la super clase Objeto.
     *
     * @return retorna la representación en cadena de está especificacion
     */
    @Override
    public String toString(){
        return "Año: " + this.año + ", "+" Categoria: " + this.cate.getNombre()+ "," +" Eje Adicional: " + this.getTea().getNombre();
    }

    /**
     * Getter del ID
     * 
     * @return retorna el identificador de está especificación de Tiquete Prepago
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Setter del ID
     * 
     * @param id el identificador a ser asignado
     */
    @Override
    public void setId(long id) {
        this.id=id;
    }
}
