
package sysctp.dominio.banco;

import javax.swing.JOptionPane;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoBanco 

{

    ConexionBD nueva=new ConexionBD();
   
    
    public DaoBanco() {
    }
    
    
    
    public void guardar(CuentaBanco cbanco)
    {
        try
        {
            nueva.executeUpdateQuery("INSERT INTO ventas.cuenta_bancaria (cban_numero,cban_banco)VALUES('"+cbanco.getCta_numero()+"','"+cbanco.getCta_banco()+"')");
            JOptionPane.showMessageDialog(null, "Se guardo con exito la cuenta bancaria");
            nueva.desconectar();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void eliminar(String num_cuenta)
    {
        try
        {
            nueva.executeUpdateQuery("DELETE FROM ventas.cuenta_bancaria WHERE cta_numero='"+num_cuenta+"'");
            JOptionPane.showMessageDialog(null,"Se elimino correctamente la cuenta bancaria");
            nueva.desconectar();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
   
    
    
    
}
