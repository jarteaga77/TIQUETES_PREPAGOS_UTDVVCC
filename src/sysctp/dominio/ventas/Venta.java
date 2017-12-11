

package sysctp.dominio.ventas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.dominio.clientes.Cliente;
import sysctp.dominio.inventario.EspecificacionTiquetePrepago;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 * representa una instancia de una venta
 *
 * @author James Andrés Payan Caicedo
 */
@Entity
@Table(name="ventas.venta")
public class Venta implements IElementoDeRegistro{
    
    @Id
    @GeneratedValue(generator="gen_ven_id")
    @GenericGenerator(
            name="gen_ven_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="ventas.venta_ven_id_seq")
            }
     )
    @Column(name="ven_id")
    private long id; // identificador de venta
    
    @Column(name="ven_fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora; // fecha en que se realizó la venta
    
    @ManyToOne(optional=true)
    @JoinColumn(name="cli_nit")
    private Cliente cliente; // Cliente quien realizó la compra
    
    
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name="ven_id", nullable=false)
    private List<LineaDeVenta> lineas = new ArrayList(); // lineas de detalle de la venta
    
    
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name="ven_id", nullable=false)
    private List<Pago> pagos = new ArrayList(); // Pagos de la venta
    
    @Column(name="ven_esta_paga")
    private boolean estaPagada;
    
    @Column(name="ven_recibo_caja")
    private long recibo_caja;
    
    @Column(name="ven_observaciones")
    private String observaciones;
  
    @Column(name="id_usuario")
    private int id_usuario;
    
    @Column(name="clie_sede")
    private long id_clie_sede;
    
    @Column(name="venta_total")
    private boolean venta_total;
    
    @Column(name="venta_parcial")
    private boolean venta_parcial;
    
    @Column(name="sobrante_afavor")
    private int sobrante_afavor;
    
    @Column(name="id_estacion")
    private int id_estacion;

    transient private ArrayList observadores = new ArrayList(); // observadores de la venta (patrón: Observer). trasient, indica que la variable es transitoria y que no se le provee persistencia

    /**
     * Constructor de la venta
     *
     */
    public Venta(){
//        fechaHora = new Date(); // por defecto asigna la hora actual
    }

    /**
     * Adiciona una linea de venta
     *
     * @param especificacion especificacion de los tiquetes prepagos del talon
     * @param serialInicial serial del primer tiquete prepago del talon
     * @param serialFinal serial de ultimo tiquete prepago del talon
     */
    public void addLineaDeVenta(EspecificacionTiquetePrepago especificacion, long serialInicial, long serialFinal){
        LineaDeVenta linea = new LineaDeVenta(especificacion, serialInicial,serialFinal);
        lineas.add(linea);
        this.publicarAdicionLineaVenta(linea);
    }

    /**
     * Elimina una linea de venta en la posicion indicada
     *
     * @param posicion La posicion de donde se va a eliminar la linea de venta
     */
    public void eliminarLineaVenta(int posicion){
        lineas.remove(posicion);
        this.publicarEliminarLineaVenta(posicion);
    }

    /**
     * Se van a cambiar de posicion dos lineas de venta dadas sus posiciones actuales
     *
     * @param posicion1 posicion de la prime linea de venta
     * @param posicion2 posicion de la segunda linea de venta
     */
    public void cambiarPosicionLineaDeVenta(int posicion1, int posicion2){
        LineaDeVenta linea = lineas.get(posicion1); // asigno a linea, el objeto el de la posición 1
        linea = lineas.set(posicion2, linea); // coloco linea en la posición 2 y el nuevo valor de linea es el antiguo objeto de la posicion 2
        lineas.set(posicion1, linea);// coloco el antiguo objeto de la posición 2, en la posicion 1
    }

    

    /**
     * Obtiene la fecha de la venta
     *
     * @return the fechaHora
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * setter de la fecha hora en que se realizó la venta
     * 
     * @param fechaHora la fecha hora a ser asignada
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Getter de la lista de lineas de venta
     * 
     * @return la lista de lineas de venta
     */
    public List getLineas() {
        return lineas;
    }

    /**
     * Setter de la lista de lineas de venta (necesario para hibernate)
     * 
     * @param lineas la lista de lineas de venta a ser asignada
     */
    public void setLineas(List lineas) {
        this.lineas = lineas;
    }

    

    /**
     * Obtiene el valor total a pagar de la venta
     *
     * @return El valor a pagar de la venta
     */
    public long obtenerTotalVenta(){
        long total = 0;
        for (Iterator i = lineas.iterator(); i.hasNext();){
            LineaDeVenta linea = (LineaDeVenta)i.next();
            total += linea.obtenerTotalParcial();
        }
        return total;
    }

    /**
     * Publica a los observadores de la venta, que se agregó una nueva linea de venta (patrón: Observer)
     *
     * @param linea la linea que se agrego a la venta
     */
    public void publicarAdicionLineaVenta(LineaDeVenta linea){
        for(Iterator i = observadores.iterator(); i.hasNext();){
            IObservadorVenta observador = (IObservadorVenta)i.next();
            observador.onAddLineaVenta(this, linea);
        }
    }

    /**
     * Publica a los observadores de la venta, que se eliminó una linea de venta en la posición indicada (patrón: Observer)
     *
     * @param posicion la posición de la cual se eliminó la linea de venta
     */
    public void publicarEliminarLineaVenta(int posicion){
        for(Iterator i = observadores.iterator(); i.hasNext();){
            IObservadorVenta observador = (IObservadorVenta)i.next();
            observador.onDeleteLineaVenta(this, posicion);
        }
    }

    /**
     * Publica a los observadores de la venta, que se cambió de posición dos lineas de venta (patrón: Observer)
     *
     * @param posicion1 primera posición intercambiada
     * @param posicion2 segunda posición intercambiada
     */
    public void publicarCambioPosicionLineaVenta(int posicion1, int posicion2){
        for(Iterator i = observadores.iterator(); i.hasNext();){
            IObservadorVenta observador = (IObservadorVenta) i.next();
            observador.onCambioPosicionLineaVenta(this, posicion1, posicion2);
        }
    }
    
    public void publicarAdicionPago(Pago pago){
        for(Iterator i = observadores.iterator(); i.hasNext();){
            IObservadorVenta observador = (IObservadorVenta) i.next();
            observador.onAdicionarPago(this, pago);
        }
    }
    
    public void publicarEliminarPago(int posicion){
        for(Iterator i = observadores.iterator(); i.hasNext();){
            IObservadorVenta observador = (IObservadorVenta)i.next();
            observador.onEliminarPago(this, posicion);
        }
    }

    /**
     * adiciona un nuevo observador
     *
     * @param observador el observador que va a recibir los eventos de la venta
     */
    public void addObservador(IObservadorVenta observador){
        if (observador == null)
            throw new NullPointerException("No se puede adicionar un objeto nulo como observador");
        observadores.add(observador);
    }
    
    /**
     * Elimina un observador de venta
     * 
     * @param observador el objeto observador a ser eliminado
     */
    public void deleteObservador(IObservadorVenta observador){
        if (observador == null)
            throw new NullPointerException("Está trantando de eliminar un observador de venta nulo.");
        observadores.remove(observador);
    }

    /**
     * Getter del identificador de venta
     * 
     * @return el identificador de venta
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Setter del identificador de venta
     * 
     * @param id el identificador de venta a ser asignado
     */
    @Override
    public void setId(long id) {
        this.id=id;
    }

    /**
     * @return el cliente quien inició la venta
     */
    public Cliente getCliente() {
        return cliente;
    }

    public long getRecibo_caja() {
        return recibo_caja;
    }

    public void setRecibo_caja(long recibo_caja) {
        this.recibo_caja = recibo_caja;
    }
    
    

    /**
     * Setter del cliente
     * 
     * @param cliente el cliente a ser asignado a la venta
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the pagos
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    
    public void adicionarPago(FormaDePago formaDePago, String serialTransaccion, CuentaBancaria cuenta, long montoPagado){
        Pago pago = new Pago();
        pago.setFormaDePago(formaDePago);
        pago.setSerialTransaccion(serialTransaccion);
        pago.setCuenta(cuenta);
        pago.setMontoPagado(montoPagado);
        pagos.add(pago);
        this.publicarAdicionPago(pago);
    }
    
    public void eliminarPago(int indice){
        pagos.remove(indice);
        this.publicarEliminarPago(indice);
    }

    /**
     * @return the estaPagada
     */
    public boolean isEstaPagada() {
        return estaPagada;
    }

    /**
     * @param estaPagada the estaPagada to set
     */
    public void setEstaPagada(boolean estaPagada) {
        this.estaPagada = estaPagada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getId_clie_sede() {
        return id_clie_sede;
    }

    public void setId_clie_sede(long id_clie_sede) {
        this.id_clie_sede = id_clie_sede;
    }

    public boolean isVenta_total() {
        return venta_total;
    }

    public void setVenta_total(boolean venta_total) {
        this.venta_total = venta_total;
    }

    public boolean isVenta_parcial() {
        return venta_parcial;
    }

    public void setVenta_parcial(boolean venta_parcial) {
        this.venta_parcial = venta_parcial;
    }

    public int getSobrante_afavor() {
        return sobrante_afavor;
    }

    public void setSobrante_afavor(int sobrante_afavor) {
        this.sobrante_afavor = sobrante_afavor;
    }

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    
    
    
    
    
    
    
}
