
package sysctp.dominio.vendedor;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoEmpleado 
{

    ConexionBD nueva=new ConexionBD();

    public DaoEmpleado() {
    }
    
  public void guardar(Empleado oemple)
  {
      try
      {
          nueva.executeUpdateQuery("INSERT INTO tbempleado(emple_cedula,emple_nombre,emple_apellido,emple_apellido2,emple_idcargo,emple_idseccion)"
                  + "VALUES("+oemple.getCedula()+",'"+oemple.getNombre()+"', '"+oemple.getApellido2()+"',"
                  + ""+oemple.getCargo()+", "+oemple.getSeccion()+")");
          
          nueva.desconectar();
          JOptionPane.showMessageDialog(null, "Se registro con exito el empleado");
         
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
      }
      
  }
  public void eliminar(int id)
  {
      try
      {
          nueva.executeUpdateQuery("DELETE FROM tbempleado where emple_cedula="+id+"");
          JOptionPane.showMessageDialog(null, "Se elimino con exito el empleado");
          nueva.desconectar();
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
      }
      
  }
  
  public void actualizar(Empleado emple, int id)
  {
      try
      {
          nueva.executeUpdateQuery("UPDATE tbempleado SET emple_nombre='"+emple.getNombre()+"', emple_apellido='"+emple.getApellido()+"', emple_apellido2='"+emple.getApellido2()+"',"
                  + "emple_id_cargo='"+emple.getCargo()+"', emple_idseccion='"+emple.getSeccion()+"'");
          
          nueva.desconectar();
          JOptionPane.showMessageDialog(null, "Se actualizo con exito el empleado");
          
          
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e,"Error", JOptionPane.ERROR_MESSAGE);
      }
      
  }
  
  
    
}
