
package sysctp.servicios.gestion_persistencia;

import java.util.Iterator;
import java.util.List;
import sysctp.servicios.persistencia.IAdaptadorPersistencia;

/**
 * Implementación de la CacheElementosAbstrataLRU, en la que se mantienen los elementos de forma persistente.
 * Esta clase está acoplada con la interfaz IAdaptador de persistencia, permitiendo así
 * utilizar cualquier implementación de persistencia, sea en disco u otro mecanismo de almacenamieno persistente.
 *
 * @author James Andres Payan Caicedo
 */
public class CacheEnDisco extends CacheElementosAbstractaLRU{
    
    private IAdaptadorPersistencia persistenciaLocal;
    
    /**
     * Contructor, recibe como parametro una implementación del IAdaptadorDePersistencia
     * 
     * @param persistenciaLocal instancia de IAdaptadorPersistencia, en la cual almacenar los datos de caché
     */
    public CacheEnDisco(IAdaptadorPersistencia persistenciaLocal){
        this.persistenciaLocal=persistenciaLocal;
    }

    /**
     * Implementación de metodo obtener de la CacheElementosAbstractaLRU.
     * Obtiene un ElementoEnCache dado un identificador.
     * 
     * @param id identificador de ElementoEnCache Solicitado
     * @return ElementoEnCache Correspondiente al identificador dado
     */
    @Override
    protected ElementoEnCache obtener(long id) {
        ElementoEnCache enCache = (ElementoEnCache) getPersistenciaLocal().recuperarElemento(ElementoEnCache.class, id);
        return enCache;
    }

    /**
     * Implementación del método adicionar de la CacheElementosAbatractaLRU.
     * Adiciona un elemento a la caché
     * 
     * @param enCache Elemento a ser adicionado en caché
     */
    @Override
    protected void adicionar(ElementoEnCache enCache) {
        getPersistenciaLocal().almacenarElemento(enCache);
    }

    /**
     * Implementación de metodo eliminar de la CacheElementosAbstractaLRU.
     * Elimina el elemento dado, del almacenamiento persistente.
     * 
     * @param enCache el elemento a ser eliminado
     */
    @Override
    protected void eliminar(ElementoEnCache enCache) {
        getPersistenciaLocal().eliminarElemento(enCache);
    }



    /**
     * Implementación de metodo obtenerCantidadElementos de la interfaz ICache.
     * Obtiene la cantida de elementos que contiene la caché
     * 
     * @return la cantidad de elementos que tiene la caché
     */
    @Override
    public int obtenerCantidadElementos() {
        List result = getPersistenciaLocal().recuperarTodosLosElementos(ElementoEnCache.class); // recupera la lista de elementos
        return result.size(); // y retorna su tamaño
    }

    /**
     * Obtiene el elemento menos recientemente usado
     * 
     * @return el elemento menosRecientementeUsado
     */
    @Override
    public ElementoEnCache getMenosRecientementeUsado() {
        List result = getPersistenciaLocal().recuperarElementos(ElementoEnCache.class, "cabeza", true);
        if (result.size() > 0)
            return (ElementoEnCache) result.get(0);
        else
            return null;
    }

    /**
     * marca el elemento dado como el menos recientemente usado
     * 
     * @param menosRecientementeUsado el  elemento a ser marcado como menosRecientementeUsado
     */
    @Override
    public void setMenosRecientementeUsado(ElementoEnCache menosUsadoRecientemente) {
        menosUsadoRecientemente.setCabeza(true);
        ElementoEnCache enCache = getMenosRecientementeUsado();
        if (enCache!=null){
            enCache.setCabeza(false);
            getPersistenciaLocal().almacenarElemento(enCache);
        }
        getPersistenciaLocal().almacenarElemento(menosUsadoRecientemente);
    }
    
    /**
     * Obtiene el elemento mas recientemente usado
     * 
     * @return el elemento masRecientementeUsado
     */
    @Override
    public ElementoEnCache getMasRecientementeUsado() {
        List result = getPersistenciaLocal().recuperarElementos(ElementoEnCache.class, "cola", true);
        if (result.size() > 0)
            return (ElementoEnCache) result.get(0);
        else
            return null;
    }

    /**
     * marca el elemento dado como elemento mas recientemento usado
     * 
     * @param masRecientementeUsado el elemento a ser marcado como el masRecientementeUsado
     */
    @Override
    public void setMasRecientementeUsado(ElementoEnCache masRecientementeUsado) {
        masRecientementeUsado.setCola(true);
        ElementoEnCache enCache = getMasRecientementeUsado();
        if (enCache!=null){
            enCache.setCola(false);
            getPersistenciaLocal().almacenarElemento(enCache);
        }
        getPersistenciaLocal().almacenarElemento(masRecientementeUsado);
    }

    /**
     * Elimina todos los elementos de la caché
     * 
     */
    @Override
    public void vaciarCache() {
        List result = getPersistenciaLocal().recuperarTodosLosElementos(ElementoEnCache.class);
        for (Iterator i = result.iterator();i.hasNext();){
            Object enCache = i.next();
            getPersistenciaLocal().eliminarElemento(enCache);
        }
        this.publicarVarciar();
    }

    /**
     * Getter del adaptador de persistencia
     * 
     * @return el adaptador de persistenciaLocal
     */
    public IAdaptadorPersistencia getPersistenciaLocal() {
        return persistenciaLocal;
    }

    /**
     * Setter del adaptador de persistencia local
     * 
     * @param persistenciaLocal el adaptador persistenciaLocal a ser asignado
     */
    public void setPersistenciaLocal(IAdaptadorPersistencia persistenciaLocal) {
        this.persistenciaLocal = persistenciaLocal;
    }
    
}
