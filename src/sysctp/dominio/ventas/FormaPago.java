
package sysctp.dominio.ventas;

/**
 *
 * @author jarteaga
 */

//Clase de encapsulamiento

public class FormaPago 
{

    public String getDescri() 
    {
        
        return descri;
    }

    public void setDescri(String descri) 
    {
        this.descri = descri;
    }

    public int getId_fpago() 
    {
        return id_fpago;
    }

    public void setId_fpago(int id_fpago) 
    {
        this.id_fpago = id_fpago;
    }
    private int id_fpago;
    private String descri;
    
}
