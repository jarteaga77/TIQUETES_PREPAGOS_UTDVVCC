
package sysctp.servicios.gestion_persistencia;

/**
 * Interfaz que deben implementar todos los elementos que deseen
 * ser mantenidos por un registro
 *
 * @author James Andres Payan Caicedo
 */
public interface IElementoDeRegistro {
    
    /**
     * Obtiene el identificador del elemento
     * 
     * @return
     */
    public long getId();
    
    
    /**
     * Asigna el identificador de elemento
     * 
     * @param id
     */
    public void setId(long id);
    
}
