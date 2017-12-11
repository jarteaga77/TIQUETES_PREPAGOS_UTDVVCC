
package sysctp.dominio.usuario;

/**
 *
 * @author jarteaga
 */


import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

public class DaoUsuario 
{
       ConexionBD nuevaCone = new ConexionBD();

    public DaoUsuario() {
    }
    
    //Metodo guardar que toma como parametro el objeto de usuario
    public void guardar(Usuario us)
     {
        try{
         
             nuevaCone.executeUpdateQuery("INSERT INTO tbusuario(nombre,apellido,cedula,usuario,clave)VALUES('"+us.getNombre()+"','"+us.getApellido()+"',"+us.getCedula()+",'"+us.getUsuario()+"',md5('"+us.getClave() +"'))");
             JOptionPane.showMessageDialog(null, "Se guardo con exito el usuario");
         
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
     }
    
    //Metodo eliminar que toma como parametro la cedula para poder realizar la eliminación del registro
    public void eliminar(int cedula)
    {
        try
        {
    
       nuevaCone.executeUpdateQuery("DELETE FROM tbusuario where cedula="+cedula+"");
       JOptionPane.showMessageDialog(null, "Se elimino con exito el usuario");
       nuevaCone.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                  
    }
    
    //Actualiza el registro de usuario
    public void actualizar(Usuario us, int cedula)
    {
       try
       {
           nuevaCone.executeUpdateQuery("UPDATE tbusuario SET usuario='"+us.getUsuario()+"',clave=md5('"+us.getClave()+"' )WHERE cedula="+cedula+" ");
           nuevaCone.desconectar();
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
                  
               
       
    }
    
   }
    
    
    
 
         
     
            
    

