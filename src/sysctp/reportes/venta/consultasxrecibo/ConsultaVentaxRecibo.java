
package sysctp.reportes.venta.consultasxrecibo;

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

/**
 *
 * @author jarteaga
 */
public class ConsultaVentaxRecibo 
{
    
     private Conexion nueva=new Conexion();
     private final String logo="/sysctp/presentacion/recursos/Logo.png";
    
    public void ejecutarReporte(String recibo)
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reportes/venta/consultasxrecibo/ConsultaVentaxrecibo.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("recibo",recibo);
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("Recibo de Caja Tiquetes Prepagos UTDVVCC");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        
        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
    
}
