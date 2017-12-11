
package sysctp.aplicacion;

import java.util.Date;
import sysctp.dominio.clientes.Cliente;
import sysctp.dominio.clientes.RegistroDeClientes;
import sysctp.dominio.inventario.CatalogoTiquetesPrepago;
import sysctp.dominio.inventario.EspecificacionTiquetePrepago;
import sysctp.dominio.ventas.*;

/**
 * Clase que controla el registro de una venta
 *
 * @author James Andrés Payan Caicedo
 */
public class ControladorRegistroDeVentas {
    private RegistroDeVentas registroDeVentas;
    private CatalogoTiquetesPrepago catalogoTiquetesPrepago;
    private CatalogoFormasDePago catalogoFormasDePago;
    private RegistroDeClientes registroDeClientes;
    private CatalogoCuentasBancarias catalogoCuentasBancarias;
    private Venta ventaActual;

    /**
     * Constructor del controlador de registro de ventas
     *
     * @param registroDeVentas El registro en el que se anotan las ventas
     * @param catalogoTiquetesPrepago El catalogo de especificaciones de tiquetes prepago disponibles para la venta
     * @param catalogoFormasDePago El catalogo de los posibles formas de pago permitidas
     * @param registroDeClientes La lista de los clientes registrados en el sistema El registro donde se consultan los clientes
     */
    public ControladorRegistroDeVentas( RegistroDeVentas registroDeVentas,
                                        CatalogoTiquetesPrepago catalogoTiquetesPrepago,
                                        CatalogoFormasDePago catalogoFormasDePago,
                                        RegistroDeClientes registroDeClientes,
                                        CatalogoCuentasBancarias catalogoCuentasBancarias)
    {
        this.registroDeVentas = registroDeVentas;
        this.catalogoTiquetesPrepago = catalogoTiquetesPrepago;
        this.catalogoFormasDePago = catalogoFormasDePago;
        this.registroDeClientes = registroDeClientes;
        this.catalogoCuentasBancarias = catalogoCuentasBancarias;
    }


    /**
     * Inicializa una nueva venta
     *
     */
    public void iniciarVenta(){
        ventaActual = new Venta();
        ventaActual.setFechaHora(new Date());
    }

    /**
     * Adiciona nuevas lineas de venta
     *
     * @param idEspecificacionTiquetePrepago Identificador de especificación de tiquete prepago
     * @param serialInicial Serial inicial del talon tiquetes prepago
     * @param serialFinal Serial final del talon de tiquetes prepago
     * @throws IdentificadorNoValidoException  Se lanza una nueva excepcion de identificador no valido el valor retornado por el catalogo es nulo
     */
    public void aniadirLineaDeVenta(int idEspecificacionTiquetePrepago, long serialInicial, long serialFinal) throws IdentificadorNoValidoException{
        EspecificacionTiquetePrepago esp = catalogoTiquetesPrepago.obtenerEspecificacion(idEspecificacionTiquetePrepago);
        if (esp != null)
            ventaActual.addLineaDeVenta(esp, serialInicial, serialFinal);
        else 
            throw new IdentificadorNoValidoException("No existe registrada la especificacion de tiquete prepago indicada");
    }

    /**
     * Elimina una linea de venta
     * 
     * @param posicion
     */
    public void eliminarLineaVenta(int posicion){
        ventaActual.eliminarLineaVenta(posicion);
    }

    /**
     * Intercambia la posición de dos lineas de venta
     * 
     * @param posicion1 la posicion 1
     * @param posicion2 la posición 2
     */
    public void cambiarPosicionLineaDeVenta(int posicion1, int posicion2){
        ventaActual.cambiarPosicionLineaDeVenta(posicion1, posicion2);
    }

    /**
     * Asigna un cliente a la actual transacción de venta
     *
     * @param id identificador de cliente
     * @throws IdentificadorNoValidoException Se lanza una nueva excepcion si el registro de clientes no devuelve algo con el identificador dado
     */
    public void asignarCliente(Long id) throws IdentificadorNoValidoException{
        Cliente cliente = registroDeClientes.obtenerCliente(id);
        if (cliente != null)
            ventaActual.setCliente(cliente);
        else 
            throw new IdentificadorNoValidoException("El nit indicado, no corresponde a ninguno de los clientes registrados");
    }
    
    /**
     * Asigna el recibo de caja para la factura actual
     */
    public void asignarRecibo(long recibo) 
    {
       ventaActual.setRecibo_caja(recibo);
    }
    
    public void asignarObservaciones(String obse)
    {
        ventaActual.setObservaciones(obse);
    }
    
    public void asignarIdUsuario(int id_usuario)
    {
        ventaActual.setId_usuario(id_usuario);
    }
    
    public void asignarSedeCliente(long sede)
    {
        ventaActual.setId_clie_sede(sede);
    }
    
    public void asignarVentaParcial(boolean parcial)
    {
        ventaActual.setVenta_parcial(parcial);
        
    }
    
    public void asignarVentaTotal(boolean total)
    {
        ventaActual.setVenta_total(total);
    }
    
    public void asignarSobranteAFavor(int sobrante)
    {
        ventaActual.setSobrante_afavor(sobrante);
    }
    public void asignarIDEstacion(int id_estacion)
    {
        ventaActual.setId_estacion(id_estacion);
    }
    
  
    /**
     * Adiciona un pago a la actual transacción de venta
     * 
     * @param id identificador de forma de pago
     * @throws IdentificadorNoValidoException se lanza esta excepción si el identificador no correponde a ninguna forma de pago
     */
    public void adicionarPago(int idFormaPago, String serialTransaccion, int idCuentaBancaria, long montoPagado)throws IdentificadorNoValidoException{
        FormaDePago formaPago = this.catalogoFormasDePago.obtenerFormaDePago(idFormaPago);
        CuentaBancaria cuenta = catalogoCuentasBancarias.obtenerCuentaBancaria(idCuentaBancaria); 
        if (formaPago != null)
            ventaActual.adicionarPago(formaPago, serialTransaccion, cuenta, montoPagado);
        else
            throw new IdentificadorNoValidoException("El identificador de forma de pago no corresponde a ninguna existente");
    }
    
    public void eliminarPago(int posicion){
        ventaActual.eliminarPago(posicion);
    }
    
    public void indicarSiCuentaEsPaga(boolean esPaga){
        ventaActual.setEstaPagada(esPaga);
    }

    /**
     * Finaliza la actual transacción de venta y la registra
     *
     */
    public void terminarVenta(){
        registroDeVentas.registrarVenta(ventaActual);
        ventaActual = null;
    }

    /**
     * Cancela la transacción de venta actual.
     * 
     */
    public void cancelarVenta(){
        ventaActual = null;
    }

    /**
     * Getter del registro de ventas
     * 
     * @return El registro en el que se anotan las ventas
     */
    public RegistroDeVentas getRegistroDeVentas() {
        return registroDeVentas;
    }

    /**
     * Setter del registro de ventas
     * 
     * @param registroDeVentas registro de ventas a ser asignado
     */
    public void setRegistroDeVentas(RegistroDeVentas registroDeVentas) {
        this.registroDeVentas = registroDeVentas;
    }

    /**
     * Getter del catalogo de tiquetes prepago
     * 
     * @return El catalogo de tiquetes prepago disponibles
     */
    public CatalogoTiquetesPrepago getCatalogoTiquetesPrepago() {
        return catalogoTiquetesPrepago;
    }

    /**
     * Setter del catalogo de tiquetes prepago
     * 
     * @param catalogoTiquetesPrepago El catalogo de tiquetes prepago a ser asignado
     */
    public void setCatalogoTiquetesPrepago(CatalogoTiquetesPrepago catalogoTiquetesPrepago) {
        this.catalogoTiquetesPrepago = catalogoTiquetesPrepago;
    }

    /**
     * Retorna la transacción actual de venta
     * 
     * @return la venta actual
     */
    public Venta getVentaActual() {
        return ventaActual;
    }

    /**
     * Getter del registro de clientes
     * 
     * @return el registro de clientes
     */
    public RegistroDeClientes getRegistroDeClientes() {
        return registroDeClientes;
    }

    /**
     * Setter del registro de clientes
     * 
     * @param registroDeClientes el registro de clientes a ser asignado
     */
    public void setRegistroDeClientes(RegistroDeClientes registroDeClientes) {
        this.registroDeClientes = registroDeClientes;
    }

    /**
     * Getter del catologo de formas de pago
     * 
     * @return el catalogoFormasDePago disponible
     */
    public CatalogoFormasDePago getCatalogoFormasDePago() {
        return catalogoFormasDePago;
    }

    /**
     * Asigna un nuevo Catalogo de Formas de Pago al controlador de registro de ventas
     * 
     * @param catalogoFormasDePago el catalogoFormasDePago a ser asignado
     */
    public void setCatalogoFormasDePago(CatalogoFormasDePago catalogoFormasDePago) {
        this.catalogoFormasDePago = catalogoFormasDePago;
    }

    /**
     * @return the catalogoCuentasBancarias
     */
    public CatalogoCuentasBancarias getCatalogoCuentasBancarias() {
        return catalogoCuentasBancarias;
    }

    /**
     * @param catalogoCuentasBancarias the catalogoCuentasBancarias to set
     */
    public void setCatalogoCuentasBancarias(CatalogoCuentasBancarias catalogoCuentasBancarias) {
        this.catalogoCuentasBancarias = catalogoCuentasBancarias;
    }

}
