
package sysctp.dominio.ventas;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Mantiene una referencia a las formas de pago permitidas para pagar una venta.
 * Extiende la clase registro de la capa de servicios.gestion_persistencia
 *
 * @author James Andrés Payan Caicedo
 */
public class CatalogoCuentasBancarias extends Registro {
    
    /**
     * Constructor por defecto
     * 
     */
    public CatalogoCuentasBancarias(){
        super(CuentaBancaria.class);
    }
    /**
     * Obtiene la forma de pago correspondiente al identificador dado
     * 
     * @param idFormaPago identificador de la forma de pago solicitada
     * @return la forma de pago correspondiente al identificador dado
     */
    public CuentaBancaria obtenerCuentaBancaria(int idCuenta){
        return (CuentaBancaria) this.obtenerElemento(idCuenta);
    }
}
