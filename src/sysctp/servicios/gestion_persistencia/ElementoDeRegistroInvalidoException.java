
package sysctp.servicios.gestion_persistencia;

/**
 * Excepcion que ocurre cuando se intenta almacenar en un registro, un elemento que 
 * no es de la clase de elementos que almacena.
 *
 * @author James Andres Payan Caicedo
 */
public class ElementoDeRegistroInvalidoException extends RuntimeException{
    
    /**
     * Crea una nueva instancia de la excepcion
     * 
     */
    public ElementoDeRegistroInvalidoException(){
        super();
    }
    
    /**
     * crea una nueva instancia de la excepcion, indicando un mensaje
     * 
     * @param mensaje el mensaje de detalle de la excepcion
     */
    public ElementoDeRegistroInvalidoException(String mensaje){
        super(mensaje);
    }
}
