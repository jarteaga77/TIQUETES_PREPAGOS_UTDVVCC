

package sysctp.dominio.ventas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.dominio.inventario.EspecificacionTiquetePrepago;

/**
 * Representa una linea de detalle de una venta
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="ventas.detalle_venta")
public class LineaDeVenta {
    
    @Id
    @GeneratedValue(generator="gen_dv_id")
    @GenericGenerator(
            name="gen_dv_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="ventas.detalle_venta_dv_id_seq")
            }
     )
    @Column(name="dv_id")
    private long id; // identificador de linea de venta
    
    @Column(name="dv_serial_1")
    private long serialInicial; // serial inicial del talon de tiquetes
    
    @Column(name="dv_serial_2")
    private long serialFinal; // serial final del talon de tiquetes
    
    @ManyToOne(optional=false)
    @JoinColumn(name="etp_id")
    private EspecificacionTiquetePrepago especificacion; // especificación que describe a todos los tiquetes del talon

    /**
     * Contructor de la linea de venta
     *
     * @param especificacion especificación del talon de tiquete prepago
     * @param serialInicial serial del primer tiquete del talon
     * @param serialFinal serial del ultimo tiquete del talon
     */
    public LineaDeVenta(EspecificacionTiquetePrepago especificacion, long serialInicial, long serialFinal){
        this.serialInicial = serialInicial;
        this.serialFinal = serialFinal;
        this.especificacion = especificacion;
    }
    
    /**
     * Contructor por defecto (necesario para hibernate)
     * 
     */
    public LineaDeVenta(){
        
    }

    /**
     * Getter del serial inicial
     * 
     * @return el serialInicial
     */
    public long getSerialInicial() {
        return serialInicial;
    }

    /**
     * Setter del serial inicial
     * 
     * @param serialInicial el serial a ser asignado como serial inicial
     */
    public void setSerialInicial(long serialInicial) {
        this.serialInicial = serialInicial;
    }

    /**
     * Getter del serial final
     * 
     * @return the serialFinal
     */
    public long getSerialFinal() {
        return serialFinal;
    }

    /**
     * Setter del serial final
     * 
     * @param serialFinal el serial a ser asignado como serial final
     */
    public void setSerialFinal(long serialFinal) {
        this.serialFinal = serialFinal;
    }

    /**
     * Getter de la especificación de tiquete prepago
     * 
     * @return la especificacion de tiquete prepago que describe la linea de venta y los tiquetes del talon
     */
    public EspecificacionTiquetePrepago getEspecificacion() {
        return especificacion;
    }

    /**
     * Setter de la especificación de tiquete prepago
     * 
     * @param especificacion la especificación a ser asignada
     */
    public void setEspecificacion(EspecificacionTiquetePrepago especificacion) {
        this.especificacion = especificacion;
    }

    /**
     * Getter del identificador de linea de venta
     * 
     * @return el identificador de la linea de venta
     */
    public long getId() {
        return id;
    }

    /**
     * Setter del identificador
     * 
     * @param id el identificador a ser asignado a la linea de venta
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el total parcial de la linea de venta
     *
     * @return El total de la linea de venta
     */
    public long obtenerTotalParcial(){
        long parcial = especificacion.getPrecio();
        parcial = parcial * (long)getCantidadTiquetesPrepago();
        return parcial;
    }

    /**
     * Obtiene la cantidad de tiquetes prepago del talon de la linea de venta
     *
     * @return devuelve la cantidad de tiquete prepago para esta linea de venta
     */
    public int getCantidadTiquetesPrepago(){
        return (int)(serialFinal - serialInicial + 1);
    }

    /**
     * Obtiene el valor unitario de cada tiquete prepago del talon
     *
     * @return el precio de la especificacion de tiquete Prepago de está linea de venta
     */
    public long obtenerValorUnitario(){
        return especificacion.getPrecio();
    }

}
