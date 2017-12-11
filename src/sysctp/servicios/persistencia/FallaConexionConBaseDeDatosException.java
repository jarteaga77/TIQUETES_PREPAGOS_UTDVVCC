
package sysctp.servicios.persistencia;

/**
 * Excepcion creada para ser disparada cuando halla un problema con la comunicacion con la BD
 *
 * @author James Andres Payan Caicedo
 */
public class FallaConexionConBaseDeDatosException extends RuntimeException {

    /**
     * Crea una nueva instancia de <code>FallaConexionConBaseDeDatosException</code>.
     */
    public FallaConexionConBaseDeDatosException() {
    }

    /**
     * Crea una nueva instancia de <code>FallaConexionConBaseDeDatosException</code> especificando el detalle de la excepcion.
     * @param msg el mensaje, que detalla la razon de la excepcion.
     */
    public FallaConexionConBaseDeDatosException(String msg) {
        super(msg);
    }
}
