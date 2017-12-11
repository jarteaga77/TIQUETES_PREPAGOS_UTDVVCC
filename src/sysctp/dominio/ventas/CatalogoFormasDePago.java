
package sysctp.dominio.ventas;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Mantiene una referencia a las formas de pago permitidas para pagar una venta.
 * Extiende la clase registro de la capa de servicios.gestion_persistencia
 *
 * @author James Andrés Payan Caicedo
 */
public class CatalogoFormasDePago extends Registro {
    
    /**
     * Constructor por defecto
     * 
     */
    public CatalogoFormasDePago(){
        super(FormaDePago.class);
    }
    /**
     * Obtiene la forma de pago correspondiente al identificador dado
     * 
     * @param idFormaPago identificador de la forma de pago solicitada
     * @return la forma de pago correspondiente al identificador dado
     */
    public FormaDePago obtenerFormaDePago(int idFormaPago){
        return (FormaDePago) this.obtenerElemento(idFormaPago);
    }
}
