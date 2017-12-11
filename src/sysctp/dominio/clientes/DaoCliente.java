
package sysctp.dominio.clientes;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoCliente 

{
   
    ConexionBD nueva=new ConexionBD();
    
    public DaoCliente() 
    {
        
    }
    public void guardar(Cliente clie)
    {
        try
        {
            nueva.executeUpdateQuery("INSERT INTO clientes.cliente (cli_nit, cli_razon_social)VALUES("+clie.getId()+",'"+clie.getRazonSocial()+"')");
                    
            nueva.desconectar();
            
            JOptionPane.showMessageDialog(null,"Se registro con exito el Cliente");
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//    public void eliminar(long nit)
//    {
//        
//       try
//       {
//           nueva.executeUpdateQuery("DELETE FROM clientes.cliente WHERE cli_nit="+nit+"");
//           nueva.desconectar();
//           
//           JOptionPane.showMessageDialog(null, "Se elimino con exito el cliente");
//           
//       }catch(Exception e)
//       {
//           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
//       }
//            
//    }
    public void actualizar(Cliente clie)
    {
        try
        {
            nueva.executeUpdateQuery("UPDATE clientes.cliente SET cli_razon_social='"+clie.getRazonSocial()+"' WHERE cli_nit="+clie.getId()+" ");
            nueva.desconectar();
            
        }catch(Exception e)
                {
                   JOptionPane.showMessageDialog(null, e,"Error", JOptionPane.ERROR_MESSAGE);

                }
        
    }
    
   
        
    }
    
    
    

