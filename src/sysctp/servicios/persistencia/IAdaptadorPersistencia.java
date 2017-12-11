
package sysctp.servicios.persistencia;

import java.util.List;

/**
 * Interfaz que define los metodos que deben implementar los adaptadores de persistencia
 *
 * @author James Andres Payan Caicedo
 */
public interface IAdaptadorPersistencia {
    
    /**
     * Almacena un objeto persistentemente
     * 
     * @param elemento objeto a ser persistido
     */
    public void almacenarElemento(Object elemento);
    
    /**
     * Recupera un objeto del almacenamiento persistente
     * 
     * @param clase clase del objeto a recuperar
     * @param id identificador del objeto
     * @return el objeto correpondiente a la clase e identificador dados.
     */
    public Object recuperarElemento(Class clase, long id);
    
    /**
     * Recupera todas las instancias de objetos, de la clase dada.
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @return todas las instancias de objetos, de la clase dada.
     */
    public List recuperarTodosLosElementos(Class clase);
    
    /**
     * Recupera todas las instancias de objetos de la clase dada,
     * cuyo atributo "atributo" es igual al valor dado.
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @param atributo el atributo señalado a ser inspeccionado
     * @param valor el valor que debe tener el atributo inspeccionado
     * @return todas las instancias de objetos de la clase dada, cuyo atributo "atributo" es igual al valor dado.
     */
    public List recuperarElementos(Class clase, String atributo, Object valor);
    
    /**
     * Elimina un objeto del almacenamiento persistente
     * 
     * @param elemento elemento a ser eliminado
     */
    public void eliminarElemento(Object elemento);
    
}
