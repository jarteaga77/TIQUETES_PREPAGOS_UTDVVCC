
package sysctp.aplicacion;

/**
 * Se lanza cuando se detecta que no existe algún elemento de catalgo que corresponda con el ID dado
 *
 * @author James Andres Payan Caicedo
 */
public class IdentificadorNoValidoException extends Exception {

    /**
     * crea una nueva instancia de <code>IdentificadorNoValidoException</code> sin el mensaje de detalle.
     */
    public IdentificadorNoValidoException() {
    }

    /**
     * crea una nueva instancia de <code>IdentificadorNoValidoException</code> especificando el mensaje de detalle.
     * @param msg el mensaje de detalle.
     */
    public IdentificadorNoValidoException(String msg) {
        super(msg);
    }
}
