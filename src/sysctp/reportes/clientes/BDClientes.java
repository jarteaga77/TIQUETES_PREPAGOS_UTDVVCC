
package sysctp.reportes.clientes;

/**
 *
 * @author jarteaga
 */

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sysctp.conexion.Conexion;

public class BDClientes 

{
     private Conexion nueva=new Conexion();
  private final String logo="/sysctp/presentacion/recursos/Logo.png";
 
    
    public void ejecutarReporte()
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reportes/clientes/BDClientes.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );    
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("logo",  this.getClass().getResourceAsStream(logo));
        
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("Consulta de Clientes UTDVVCC");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
    
    
    
}
