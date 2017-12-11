
package sysctp.servicios.gestion_persistencia;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de la CacheElementosAbstrataLRU, en la que se mantienen los elementos en memoria ram.
 * Esta clase está acoplada con la interfaz IAdaptador de persistencia, permitiendo así
 * utilizar cualquier implementación de persistencia, sea en disco u otro mecanismo de almacenamieno persistente.
 *
 * @author James Andres Payan Caicedo
 */
public class CacheEnMemoria extends CacheElementosAbstractaLRU {
    
    private ElementoEnCache menosRecientementeUsado; // referencia al elemento menos recientemente usado
    private ElementoEnCache masRecientementeUsado; // referencia al elemento mas recientemente usado
    
    
    private Map<Long,ElementoEnCache> listaElementos = new HashMap(); // mapa de los elementos mantenidos por la caché
    
    /**
     * Constructor por defecto
     * 
     * 
     */
    public CacheEnMemoria(){
        
    }

    /**
     * Implementación del método definido en la superclase.
     * Obtiene un elemento en caché dado el identificador.
     * 
     * @param id identificador del elemento solicitado
     * @return El elemento correspondiente al identificador dado.
     */
    @Override
    protected ElementoEnCache obtener(long id) {
        ElementoEnCache enCache = listaElementos.get(id);
        return enCache;
    }

    /**
     * Implementación del método definido en la superclase.
     * adiciona un elemeto a la caché.
     * 
     * @param enCache elemento a ser adicionado
     */
    @Override
    protected void adicionar(ElementoEnCache enCache) {
        listaElementos.put(enCache.getId(), enCache);
    }

    /**
     * Implementación del método definido en la superclase.
     * elimina el elemento dado, de la caché
     * 
     * @param enCache
     */
    @Override
    protected void eliminar(ElementoEnCache enCache) {
        listaElementos.remove(enCache.getId());
    }



    /**
     * Getter del mapa de elementos
     * 
     * @return el mapa de elementos mantenidos por la caché
     */
    public Map<Long,ElementoEnCache> getlistaElementos() {
        return listaElementos;
    }

    /**
     * Setter del mapa de elementos mantenidos por la caché
     * 
     * @param listaElementos el mapa de elementos; Instancia de la clase Map.
     */
    public void setlistaElementos(Map<Long,ElementoEnCache> listaElementos) {
        this.listaElementos = listaElementos;
    }

    /**
     * Obtiene la cantidad de elementos mantenidos en la caché
     * 
     * @return la cantidad de elemento en caché
     */
    @Override
    public int obtenerCantidadElementos() {
        return listaElementos.size();
    }



    /**
     * Elimina todos los elementos mantenidos en el caché
     * 
     */
    @Override
    public void vaciarCache() {
        listaElementos =  new HashMap();
        menosRecientementeUsado=null;
        masRecientementeUsado=null;
        this.publicarVarciar();
    }

    /**
     * Obtiene el elemento menos recientemente usado
     * 
     * @return el elemento menosRecientementeUsado
     */
    public ElementoEnCache getMenosRecientementeUsado() {
        return menosRecientementeUsado;
    }

    /**
     * Asigna el elemento menos recientemente usado
     * 
     * @param menosRecientementeUsado el elemento a ser asignado como el menosRecientementeUsado
     */
    public void setMenosRecientementeUsado(ElementoEnCache menosRecientementeUsado) {
        this.menosRecientementeUsado = menosRecientementeUsado;
    }

    /**
     * Obtiene el elemento mas recientemente usado
     * 
     * @return el elemento masRecientementeUsado
     */
    public ElementoEnCache getMasRecientementeUsado() {
        return masRecientementeUsado;
    }

    /**
     * asigna el elemento mas recientemento usado
     * 
     * @param masRecientementeUsado el elemento a ser asignado como el masRecientementeUsado
     */
    public void setMasRecientementeUsado(ElementoEnCache masRecientementeUsado) {
        this.masRecientementeUsado = masRecientementeUsado;
    }
    
}
