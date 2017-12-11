
package sysctp.dominio.devolucion;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Consignacion 
{
    
    private String cta_cliente,banco_cliente, tipo_cta;
    private Date fecha_cons;
    private long vlorconsignado, id_devolucion;

    public String getCta_cliente() {
        return cta_cliente;
    }

    public void setCta_cliente(String cta_cliente) {
        this.cta_cliente = cta_cliente;
    }

    public String getBanco_cliente() {
        return banco_cliente;
    }

    public void setBanco_cliente(String banco_cliente) {
        this.banco_cliente = banco_cliente;
    }

    public String getTipo_cta() {
        return tipo_cta;
    }

    public void setTipo_cta(String tipo_cta) {
        this.tipo_cta = tipo_cta;
    }

    public Date getFecha_cons() {
        return fecha_cons;
    }

    public void setFecha_cons(Date fecha_cons) {
        this.fecha_cons = fecha_cons;
    }

    public long getVlorconsignado() {
        return vlorconsignado;
    }

    public void setVlorconsignado(long vlorconsignado) {
        this.vlorconsignado = vlorconsignado;
    }

    public long getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(long id_devolucion) {
        this.id_devolucion = id_devolucion;
    }
    
    
    
    
    
}
