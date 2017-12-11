
package sysctp.servicios.persistencia;

/**
 * Clase que representa una tarea pendiente.
 * No se pueden crear propiamente instancias de esta clase
 * por que hay que definir exactamente que clase de tarea esta pendiente
 * por ejemplo de eliminacion o de almacenamiento
 *
 * @author James Andres Payan Caicedo
 */
public abstract class TareaPendiente {
    
    /**
     * Elemento relacionado con la tarea de persistencia pendiente
     * 
     */
    protected Object elemento;
    
    /**
     * Contructor de la tarea pendiente. Recibe el elemento relacionado con la tarea pendiente
     * 
     * @param elemento el elemento relacionado con la tarea pendiente
     */
    public TareaPendiente(Object elemento){
        this.elemento = elemento;
    }

    /**
     * Obtiene el elemento relacionado con la tarea pendiente
     * 
     * @return el elemento relacionado con la tarea pendiente
     */
    public Object getElemento() {
        return elemento;
    }

    /**
     * Asgina el elemento relacionado con la tarea pendiente
     * 
     * @param elemento el elemento a ser asignado
     */
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    /**
     * Metodo que ejecuta la tarea pendiente, en el adaptador de persistencia dado.
     * La implementacion se realiza en las subclases.
     * 
     * @param persistenciaExterna el adapdor de persistencia en el cual se ejecutará la tarea pendiente
     */
    public abstract void ejecutar(IAdaptadorPersistencia persistenciaExterna);
    
}
