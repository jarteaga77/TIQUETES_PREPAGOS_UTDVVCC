

package sysctp.dominio.inventario;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Catalogo de tipos de tiquete prepago permitidos según reglas del negocio.
 * Extiendo la clase sysctp.servicios.gestion_persistencia.Registro
 *
 * @author James Andrés Payan Caicedo
 */
public class ListaTiposTiquetesPrepagoPermitidos extends Registro {

    /**
     * Contructor por defecto
     * 
     */
    public ListaTiposTiquetesPrepagoPermitidos(){
        super(TipoTiquetePrepago.class); // Indica a la super clase que almacena Tipos de tiquete prepago

    }

}
