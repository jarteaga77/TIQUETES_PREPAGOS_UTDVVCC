

package sysctp.dominio.inventario;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Mantiene una referencia a las especificaciones tiquete prepago disponibles para vender.
 * Extiende la clase registro de la capa de servicios.gestion_persistencia
 *
 * @author James Andrés Payan Caicedo
 */
public class CatalogoTiquetesPrepago extends Registro{
    
    
    /**
     * Constructor por defecto
     * 
     */
    public CatalogoTiquetesPrepago(){
        super(EspecificacionTiquetePrepago.class); // indica a la super-clase que almacena Especificaciones de Tiquete prepago
    }

    /**
     * Obtiene un ejemplar de Especificación de tiquete Prepago, dado un identificador
     *
     * @param idEspTiquete identificador de especificación de tiquete prepago
     * @return ejemplar de tiquete prepago
     */
    public EspecificacionTiquetePrepago obtenerEspecificacion(long idEspTiquete){
        return (EspecificacionTiquetePrepago)super.obtenerElemento(idEspTiquete);
    }

}
