
package sysctp.servicios.gestion_persistencia;

/**
 * Clase que implenta la interfaz ICache, y que representa una cache de dos niveles.
 * Ante los ojos de quien la usa, está cache se ve como una unica, pero internamente
 * utiliza dos niveles de cache.
 * 
 * Para la administración de los dos niveles de cache, está clase hace uso del patron GOF
 * "Administración de Caché"
 * 
 * Tenga en cuenta que está implementación de caché de dos niveles
 * no está acoplada con ninguna otra implementación de de ICache, así que es posible de utilizar
 * los niveles de cache con cualquier implementación que se desee. Por ejemplo, podría utilizarse un nivel
 * con una implentación de cache en memoria el segundo nivel con una cache en disco; o incloso, la cache de segundo
 * nivel podría a la vez ser otra cache de dos niveles, con lo cual tendriamos 3 niveles de caché, o tal vez más si seguimos
 * implementando ésta clase de la misma forma.
 *
 * @author James Andres Payan Caicedo
 */
public class CacheDosNiveles implements ICache {
    private ICache nivel_1; // Cache de nivel 1
    private ICache nivel_2; // Cache de nivel 2

    /**
     * Metodo que adiciona un elemento a la caché. Dicho elemento debe ser cubierto
     * por la clase ElementoEnCache, para así adicionar otras funcionalidades a los elementos mantenidos por la caché
     * 
     * @param enCache elemento a ser almacenado en la caché de dos niveles
     */
    @Override
    public void adicionarElemento(IElementoDeRegistro enCache) {
        if(nivel_1!=null)
            nivel_1.adicionarElemento(enCache);
        if(nivel_2!=null)
            nivel_2.adicionarElemento(enCache);
    }

    /**
     * Busca un elemento en los dos niveles de caché, dado un identificador
     * 
     * @param id identificador del elemento que se desea encontrar
     * @return El elemento de cache correspondiente al identificador indicado
     */
    @Override
    public ElementoEnCache buscarElemento(long id) {
        ElementoEnCache enCache = (nivel_1==null)? null : nivel_1.buscarElemento(id); // primero prueba que se halla asignado un cache de nivel 1
        if(enCache==null){
            enCache = (nivel_2==null)? null : nivel_2.buscarElemento(id);// primero prueba que se halla asignado un cache de nivel 2
            if (enCache!=null && nivel_1!=null){
                nivel_1.adicionarElemento(enCache.getElemento());
            }
        }
        return enCache;
    }

    /**
     * Elimina un elemento dado de los dos niveles de caché
     * 
     * @param enCache el elemento a ser eliminado
     */
    @Override
    public void eliminarElemento(IElementoDeRegistro enCache) {
        if(nivel_1!=null)
            nivel_1.eliminarElemento(enCache);
        if(nivel_2!=null)
            nivel_2.eliminarElemento(enCache);
    }

    /**
     * Esta operación definida por al interfaz ICache, pretende asignar un numero maximo de elementos en cache.
     * Para esta implementación de ICache, no esta implementada está operación, ya que el numero maximo de elementos
     * debe ser indicado explicitamente a cada nivel de cache por separado.
     * 
     * @param n nuemero maximo de elementos en caché
     */
    @Override
    public void setMaximaCantidadElementos(int n) {
        throw new UnsupportedOperationException("Operacion no soportada en cache de dos niveles, asigne la maxima cantidad de elementos a cada cache por separado.");
    }

    /**
     * Obtiene el numero máximo de elementos en caché. Esta operación está definida por la interfaz ICache, pero no
     * está implementada en esta cache de dos niveles, ya que ese indicador debe ser consultado a cada cache por separado.
     * 
     * @return
     */
    @Override
    public int getMaximaCantidadElementos() {
        throw new UnsupportedOperationException("Operacion no soportada en cache de dos niveles, consulte la maxima cantidad de elementos en cada cache por separado.");
    }

    /**
     * Metodo que limpia todos los elementos de los dos niveles de cache
     * 
     */
    @Override
    public void vaciarCache() {
        if(nivel_1!=null)
            nivel_1.vaciarCache();
        if(nivel_2!=null)
            nivel_2.vaciarCache();
    }

    /**
     * Getter del primer nivel de cache
     * 
     * @return el primer nivel de caché
     */
    public ICache getNivel_1() {
        return nivel_1;
    }

    /**
     * Setter del primer nivel de cache. 
     * 
     * @param nivel_1 el primer nivel de caché a ser asignada
     */
    public void setNivel_1(ICache nivel_1) {
        this.nivel_1 = nivel_1;
    }

    /**
     * Getter del segundo nivel de cache
     * 
     * @return el segundo nivel de caché
     */
    public ICache getNivel_2() {
        return nivel_2;
    }

    /**
     * Setter del segundo nivel de caché
     * 
     * @param nivel_2 La caché a ser asignado como segundo nivel
     */
    public void setNivel_2(ICache nivel_2) {
        this.nivel_2 = nivel_2;
    }
    
}
