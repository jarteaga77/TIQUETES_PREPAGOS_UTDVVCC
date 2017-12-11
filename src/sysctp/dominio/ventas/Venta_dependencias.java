
package sysctp.dominio.ventas;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Venta_dependencias 
{
    private Date ven_dep_fecha;
    private int id_item_depen;
    private String ven_dep_obse;
    private int id_iusuario;

    public Date getVen_dep_fecha() {
        return ven_dep_fecha;
    }

    public void setVen_dep_fecha(Date ven_dep_fecha) {
        this.ven_dep_fecha = ven_dep_fecha;
    }

    public int getId_item_depen() {
        return id_item_depen;
    }

    public void setId_item_depen(int id_item_depen) {
        this.id_item_depen = id_item_depen;
    }

    public String getVen_dep_obse() {
        return ven_dep_obse;
    }

    public void setVen_dep_obse(String ven_dep_obse) {
        this.ven_dep_obse = ven_dep_obse;
    }

    public int getId_iusuario() {
        return id_iusuario;
    }

    public void setId_iusuario(int id_iusuario) {
        this.id_iusuario = id_iusuario;
    }
    
    
    
    
    
    
    
}
