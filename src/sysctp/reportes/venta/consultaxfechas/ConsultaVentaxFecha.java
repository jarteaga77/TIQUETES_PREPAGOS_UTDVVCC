
package sysctp.reportes.venta.consultaxfechas;

import java.net.URL;
import java.util.Date;
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
public class ConsultaVentaxFecha 
{
    
     private Conexion nueva=new Conexion();
     private final String logo="/sysctp/presentacion/recursos/Logo.png";
    
    public void ejecutarReporte(Date inicio, Date fin)
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reportes/venta/consultaxfechas/ConsultaVentaxFecha.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("inicio",inicio);
         parametros.put("fin",fin);
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("Consolidado Venta X Rango de Fechas Prepagos UTDVVCC");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        
        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
    
}
