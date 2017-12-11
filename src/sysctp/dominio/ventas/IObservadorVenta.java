

package sysctp.dominio.ventas;

/**
 * Interfaz que debe implementar cualquier clase que sea un observador de la venta
 *
 * @author James Andrés Payan Caicedo
 */
public interface IObservadorVenta {
    
    /**
     * Este evento es llamado cada vez que a la venta se le adiciona una linea de venta
     *
     * @param fuente La venta a la cual se le adicionó una nueva linea de venta
     * @param linea la linea de venta adicionada.
     */
    public void onAddLineaVenta(Venta fuente, LineaDeVenta linea);
    
    /**
     * Evento que se llama cada vez que se elimina una linea de venta
     * 
     * @param fuente la venta a la cual se eliminó la linea de venta
     * @param posicion posición en que se encontraba la linea venta cuando fue eliminada
     */
    public void onDeleteLineaVenta(Venta fuente, int posicion);
    
    /**
     * Sucede cuando se cambian de posición dos lineas de venta
     * 
     * @param fuente la venta a la cual se modifica la posición de las dos lineas de venta
     * @param posicion1 primer posición intercambiada
     * @param posicion2 segunda posición intercambiada
     */
    public void onCambioPosicionLineaVenta(Venta fuente, int posicion1, int posicion2);
    
    
    /**
     * Sucede cuando se adiciona un pago a la venta
     * @param fuente venta en la que se origino el eveto de adicion de pago
     * @param pago el pago adicionado
     */
    public void onAdicionarPago(Venta fuente, Pago pago);
    
    /**
     * Sucede cuando se elimina un pago de la venta
     * @param fuente venta a la que se le eliminó el pago
     * @param posicion indice del cual fue eliminado el pago
     */
    public void onEliminarPago(Venta fuente, int posicion);
    
}
