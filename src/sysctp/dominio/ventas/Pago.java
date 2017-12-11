
package sysctp.dominio.ventas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author james
 */
@Entity
@Table(name="ventas.pago")
public class Pago{
    
    @Id
    @GeneratedValue(generator="gen_pa_id")
    @GenericGenerator(
            name="gen_pa_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="ventas.pago_pa_id_seq")
            }
     )
    @Column(name="pa_id")
    private int id;
    
    @Column(name="pa_serial")
    private String serialTransaccion;
    
    @Column(name="pa_monto")
    private long montoPagado;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="cban_id")
    private CuentaBancaria cuenta;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="fp_id")
    private FormaDePago formaDePago;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the serialTransaccion
     */
    public String getSerialTransaccion() {
        return serialTransaccion;
    }

    /**
     * @param serialTransaccion the serialTransaccion to set
     */
    public void setSerialTransaccion(String serialTransaccion) {
        this.serialTransaccion = serialTransaccion;
    }

    /**
     * @return the montoPagado
     */
    public long getMontoPagado() {
        return montoPagado;
    }

    /**
     * @param montoPagado the montoPagado to set
     */
    public void setMontoPagado(long montoPagado) {
        this.montoPagado = montoPagado;
    }

    /**
     * @return the cuenta
     */
    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the formaDePago
     */
    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    /**
     * @param formaDePago the formaDePago to set
     */
    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
}
