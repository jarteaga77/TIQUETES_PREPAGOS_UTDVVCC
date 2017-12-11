
package sysctp.servicios.persistencia;

/**
 * Clase que representa una eliminacion Pendiente.
 * Cada que se ejecuta su metodo ejecutar, trata de
 * eliminar el elemento mantenido, en el adaptador de persistencia
 * dado.
 *
 * @author James Andres Payan Caicedo
 */
public class EliminacionPendiente extends TareaPendiente{
    
    /**
     * Crea la eliminacion pendiente, con elemento a ser eliminado.
     * 
     * @param elemento elemento a ser eliminado
     */
    public EliminacionPendiente(Object elemento){
        super(elemento);
    }

    /**
     * Trata de eliminar el elemento del adaptador de persistencia dado
     * 
     * @param persistenciaExterna adaptador de persistencia del cual se necesita eliminar el elemento
     */
    @Override
    public void ejecutar(IAdaptadorPersistencia persistenciaExterna) {
        persistenciaExterna.eliminarElemento(elemento);
    }
    
}
