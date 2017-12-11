
package sysctp.servicios.gestion_persistencia;

/**
 * Interfaz que deben implementar todos los objetos que deseen ser notificados
 * de la adición o eliminación de elemento de un registro.
 *
 * @author James Andres Payan Caicedo
 */
public interface IObservadorRegistro {
    
    /**
     * Evento que se dispara cuando se adiciona un elemento al registro
     * 
     * @param source registro fuente al que se le adiciono elemento
     * @param elemento elemento adicionado al registro
     */
    public void onAdicionElemento(Registro source, IElementoDeRegistro elemento);
    
    /**
     * Evento que se dispara cuando se elimina un elemento del registro
     * 
     * @param source regitro fuente al que se le elemino el elemento
     * @param elemento elemento eliminado
     */
    public void onEliminacionElemento(Registro source, IElementoDeRegistro elemento);
}
