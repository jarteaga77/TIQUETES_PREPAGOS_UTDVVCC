
package sysctp.dominio.arqueo.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class TotalArqueoGeneral 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    
    
    public long totalVendidos()
    {
        long total_vendidos = 0;
        ResultSet obj=conexion.executeQuery("SELECT COUNT(conse_estado)AS vendidos FROM inventario.consecutivos WHERE conse_estado=false");
        try {
            if(obj.next()==true)
            {
              total_vendidos= obj.getLong("vendidos");
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
        return total_vendidos;
    }
    
    
    public long totalRemision()
    {
        
        long total_remision=0;
        ResultSet obj=conexion.executeQuery("SELECT SUM(dr_serial2-dr_serial1 +1)AS total_remision FROM ventas.detalle_remision");
        try {
            if(obj.next()==true)
            {
                total_remision= obj.getLong("total_remision");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_remision;
    }
    
    public long totaDisponibles()
    {
        
        long total_disponible=0;
        ResultSet obj=conexion.executeQuery("SELECT COUNT(conse_estado)AS disponibles FROM inventario.consecutivos WHERE conse_estado=true");
        
        try {
            if(obj.next()==true)
            {
                total_disponible= obj.getLong("disponibles");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_disponible;
    }
    
    public long totalAnulados()
    {
        long total_anulados=0;
        ResultSet obj=conexion.executeQuery("SELECT SUM((da_serial2 - da_serial1)+1) as total FROM inventario.detalle_anulacion_tiquetes");
         try {
            if(obj.next()==true)
            {
                total_anulados= obj.getLong("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
         conexion.desconectar();
        return total_anulados;
    }
    
    public long totalSistema()
    {
        long total_Sistema=0;
        ResultSet obj=conexion.executeQuery("SELECT COUNT(conse_estado)AS disponibles FROM inventario.consecutivos");
    
        try {
            if(obj.next()==true)
            {
                total_Sistema= obj.getLong("disponibles");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_Sistema;
    }
    
    public long total_perforacion()
    {
        long total_perforacion=0;
        ResultSet obj=conexion.executeQuery("SELECT SUM((da_serial2 - da_serial1)+1) as total FROM inventario.detalle_anulacion_tiquetes where id_tipo=1");
    
        try {
            if(obj.next()==true)
            {
                total_perforacion= obj.getLong("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_perforacion;
    }
    
     public long total_proveedor()
    {
        long total_proveedor=0;
        ResultSet obj=conexion.executeQuery("SELECT SUM((da_serial2 - da_serial1)+1) as total FROM inventario.detalle_anulacion_tiquetes where id_tipo=2");
    
        try {
            if(obj.next()==true)
            {
                total_proveedor= obj.getLong("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_proveedor;
    }
     
         public long total_clientes()
    {
        long total_clientes=0;
        ResultSet obj=conexion.executeQuery("SELECT SUM((da_serial2 - da_serial1)+1) as total FROM inventario.detalle_anulacion_tiquetes where id_tipo=3");
    
        try {
            if(obj.next()==true)
            {
                total_clientes= obj.getLong("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalArqueoGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return total_clientes;
    }
    
    
}
