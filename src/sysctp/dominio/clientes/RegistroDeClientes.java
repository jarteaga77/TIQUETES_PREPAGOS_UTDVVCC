

package sysctp.dominio.clientes;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * El registro de clientes contiene la lista de los clientes del sistema.
 * Esta clase extiende la clase Registro de la capa de servicios.gestion_persistencia
 *
 * @author James Andrés Payan Caicedo
 */
public class RegistroDeClientes extends Registro{

    /**
     * Constructor por defecto
     * 
     */
    public RegistroDeClientes (){
        super(Cliente.class); // indica la clase de elementos a los que mantiene referencia
    }
    /**
     * Obtiene el cliente correspondiente al indentificador dado
     *
     * @param id identificador del cliente
     * @return El cliente correspondiente al identificador
     */
    public Cliente obtenerCliente(long id){
        return (Cliente) super.obtenerElemento(id);
    }

}
