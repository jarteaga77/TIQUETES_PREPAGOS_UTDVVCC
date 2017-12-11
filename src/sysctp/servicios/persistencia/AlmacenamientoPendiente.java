
package sysctp.servicios.persistencia;

/**
 * Clase que representa un almacenamiento Pendiente.
 * Cada que se ejecuta su metodo ejecutar, trata de
 * almacenar el elemento mantenido, en el adaptador de persistencia
 * dado.
 *
 * @author James Andres Payan Caicedo
 */
public class AlmacenamientoPendiente extends TareaPendiente {
    
    /**
     * Crea el almacenamiento pendiente, con elemento a ser almacenado.
     * 
     * @param elemento elemento a ser almacenado
     */
    public AlmacenamientoPendiente(Object elemento){
        super(elemento);
    }

    /**
     * Trata de almacenar el objeto en el adaptador persistencia dado
     * 
     * @param persistenciaExterna adaptador de persistencia en el cual se va a almacenar el elemento.
     */
    @Override
    public void ejecutar(IAdaptadorPersistencia persistenciaExterna) {
        persistenciaExterna.almacenarElemento(elemento);
    }
    
}
