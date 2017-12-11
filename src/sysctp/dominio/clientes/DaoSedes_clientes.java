
package sysctp.dominio.clientes;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoSedes_clientes 

{
    
    ConexionBD nueva=new ConexionBD();
    
    public void guardarDependencia(Sedes_clientes sedes)
    {
        nueva.executeUpdateQuery("INSERT INTO clientes.sedes_clientes(cli_nit,sede_descripcion,id_clie_ciudad,cli_direccion,cli_telefono_1,cli_telefono_2,cli_fax,cli_email)VALUES("+sedes.getNit_cliente()+", "
                + "'"+sedes.getDescripcion()+"', "+sedes.getId_ciudad()+", '"+sedes.getDir()+"', '"+sedes.getTel1()+"','"+sedes.getTel2()+"', '"+sedes.getFax()+"', '"+sedes.getMail()+"')");
        
        JOptionPane.showMessageDialog(null,"Se registro correctamente!");
        
        nueva.desconectar();
    }
    
    
//    public void eliminarDependencia(int iddenpendencia)
//    {
//        nueva.executeUpdateQuery("DELETE FROM clientes.sedes_clientes WHERE se_id="+iddenpendencia+"");
//    }
  
    public void actualizarDependencia(Sedes_clientes sedes, long id_sede )
    {
        nueva.executeUpdateQuery("UPDATE clientes.sedes_clientes SET sede_descripcion='"+sedes.getDescripcion()+"',id_clie_ciudad="+sedes.getId_ciudad()+", cli_direccion='"+sedes.getDir()+"',cli_telefono_1='"+sedes.getTel1()+"',cli_telefono_2='"+sedes.getTel2()+"',cli_fax='"+sedes.getFax()+"', cli_email='"+sedes.getMail()+"' WHERE id_cliente_sede="+id_sede+"");
                JOptionPane.showMessageDialog(null,"Se Actualizo correctamente!");

        nueva.desconectar();
    
    }
    
}
