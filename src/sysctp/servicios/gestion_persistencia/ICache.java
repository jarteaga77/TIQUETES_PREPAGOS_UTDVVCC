
package sysctp.servicios.gestion_persistencia;

/**
 * Esta interfaz define los metodos que debe implementar una caché
 *
 * @author James Andres Payan Caicedo
 */
public interface ICache {
    
    /**
     * Adiciona un elemento en cache
     * 
     * @param enCache el elemento a ser adicionado
     */
    public void adicionarElemento(IElementoDeRegistro enCache);
    
    /**
     * busca un elemento en la caché
     * 
     * @param id identificador del elemento solicitado
     * @return el elemento correspondiente al identificador dado
     */
    public ElementoEnCache buscarElemento(long id);
    
    /**
     * Elimina un elemento e la caché
     * 
     * @param enCache elemento a ser eliminado de la caché
     */
    public void eliminarElemento(IElementoDeRegistro enCache);
    
    /**
     * Asigna la maxima cantidad de elementos que puede mantener la caché
     * 
     * @param n la cantidad maxima de elementos que puede mantener la caché
     */
    public void setMaximaCantidadElementos(int n);
    
    /**
     * Obtiene la cantidad maxima de elementos que puede mantener la caché
     * 
     * @return la cantidad maxima de elementos que puede mantener la caché
     */
    public int getMaximaCantidadElementos();
    
    /**
     * Elimina todos los elementos de la caché
     * 
     */
    public void vaciarCache();
}
