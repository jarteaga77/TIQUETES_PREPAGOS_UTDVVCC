
package sysctp.dominio.ventas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;

/**
 *
 * @author james
 */
@Entity
@Table(name="ventas.cuenta_bancaria")
public class CuentaBancaria implements IElementoDeRegistro {
    
    
    @Id
    @GeneratedValue(generator="gen_cban_id")
    @GenericGenerator(
            name="gen_cban_id", 
            strategy="native", 
            parameters={
                @Parameter(name="sequence",value="ventas.cuenta_bancaria_cban_id_seq")
            }
     )
    @Column(name="cban_id")
    private long id;
    
    @Column(name="cban_numero")
    private String numeroCuenta;
    
    @Column(name="cban_banco")
    private String nombreBanco;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }
    
    public String toString(){
        return nombreBanco + ", cuenta: " + numeroCuenta;
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the nombreBanco
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    /**
     * @param nombreBanco the nombreBanco to set
     */
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    
}
