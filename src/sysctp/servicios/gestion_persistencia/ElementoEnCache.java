
package sysctp.servicios.gestion_persistencia;

import java.util.Date;

/**
 * Clase que encapsula un elemento a ser almacenado en cache.
 * Añade funcionalidad para la administración de los elementos en caché,
 * como referencia a los elementos adyacentes en la cola de elementos en caché,
 * fecha de creación del elemento en caché, e indicadores que notifican
 * si el elemento está o no en el final o el inicio de la cola
 *
 * @author james
 */
public class ElementoEnCache {
    private ElementoEnCache siguiente;
    private ElementoEnCache anterior;
    private IElementoDeRegistro elemento;
    private Date fechaCreacionEnCache;
    private long id;
    private boolean cola=false;
    private boolean cabeza=false;
    
    
    /**
     * Contructor por defecto. Solo admite elementos que implementen la interfaz
     * IElementoDeRegistro
     * 
     * 
     * @param elemento elemento a ser almacenado en una caché que implementa la interfaz IElementoDeRegistro
     */
    public ElementoEnCache(IElementoDeRegistro elemento){
        this.setElemento(elemento);
    }

    /**
     * Obtiene el siguiente elemento en la cola de caché
     * 
     * @return el siguiente elemento de la cola
     */
    public ElementoEnCache getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna una referencia a un el elemento como el siguiente en la cola
     * 
     * @param siguiente el elemento a ser referenciado como el siguiente en la cola
     */
    public void setSiguiente(ElementoEnCache siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene el elemento anterior en la cola de caché
     * 
     * @return el elemento anterior en la cola de caché
     */
    public ElementoEnCache getAnterior() {
        return anterior;
    }

    /**
     * Asigna una referencia a un el elemento como el anterior en la cola
     * 
     * @param anterior el elemento a ser referenciado como el anterior en la cola
     */
    public void setAnterior(ElementoEnCache anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtiene el elemento encapsulado, que se almacena en la caché
     * 
     * @return el elemento de caché encapsulado
     */
    public final IElementoDeRegistro getElemento() {
        return elemento;
    }

    /**
     * Asigna un elemento como elemento de caché, encapsulado su existencia
     * 
     * @param elemento el elemento a ser encapsulado
     */
    public final void setElemento(IElementoDeRegistro elemento) {
        this.elemento = elemento;
        this.id = elemento.getId(); // el ID del elementoEnCache, es el mismo ID del elemento encapsulado
    }

    /**
     * Obtiene el identificador de elementoEnCache
     * 
     * @return el identificador
     */
    public long getId() {
        return id;
    }

    /**
     * Asigna el identificador del elemento en caché
     * 
     * @param id el identificador a ser asignado
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de creación en caché
     * 
     * @return la fecha de creacionEnCache
     */
    public Date getFechaCreacionEnCache() {
        return fechaCreacionEnCache;
    }

    /**
     * Asigna la fecha de creación en caché
     * 
     * @param fechaCreacionEnCache la fecha de creacionEnCache a ser asignada
     */
    public void setFechaCreacionEnCache(Date fechaCreacionEnCache) {
        this.fechaCreacionEnCache = fechaCreacionEnCache;
    }

    /**
     * Identifica si el objeto está al final de la cola de elementos en caché
     * 
     * 
     * @return verdadero, si el elemento está al final de la cola
     */
    public boolean isCola() {
        return cola;
    }

    /**
     * Marca un elemento, como que está al final de la cola de elementos en caché
     * 
     * @param cola indica verdadero o falso, según sea el caso (está o no al final de la cola).
     */
    public void setCola(boolean cola) {
        this.cola = cola;
    }

    /**
     * Identifica si el objeto está al inicio de la cola de elementos en caché
     * 
     * @return verdadero, si el elemento está al inicio de la cola
     */
    public boolean isCabeza() {
        return cabeza;
    }

    /**
     * Marca un elemento, como que está al inicio de la cola de elementos en caché
     * 
     * @param cabeza indica verdadero o falso, según sea el caso (está o no al inicio de la cola).
     */
    public void setCabeza(boolean cabeza) {
        this.cabeza = cabeza;
    }


}
