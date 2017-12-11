
package sysctp.dominio.clientes;

/**
 *
 * @author jarteaga
 */
public class Sedes_clientes 
{
    
    private long nit_cliente;
    private String descripcion;
    private int id_ciudad;
    private String dir;
    private String tel1;
    private String tel2;
    private String fax;
    private String mail;
   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(long nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
    
}
