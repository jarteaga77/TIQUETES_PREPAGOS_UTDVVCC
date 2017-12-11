

package sysctp.dominio.ventas;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Se encarga de registrar ventas
 *
 * @author James Andrés Payan Caicedo
 */
public class RegistroDeVentas extends Registro {

    
    /**
     * Metodo contructor
     * 
     */
    public RegistroDeVentas(){
        super(Venta.class); // indica al registro que se van a almacenar ventas
    }
    
    /**
     * Registra una venta
     *
     * @param venta la venta a ser registrada
     */
    public void registrarVenta(Venta venta){
        super.registrarElemento(venta);
    }

    
}
