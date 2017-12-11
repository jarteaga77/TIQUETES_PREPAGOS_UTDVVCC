
package sysctp.reporte.remisionPeaje;



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
public class ReporteRemisionTiqueteria 

{
  private Conexion nueva=new Conexion();
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";
    
    public void ejecutarReporte(Date fecha_ini, Date fecha_fin, int peaje)
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reporte/remisionPeaje/RemisionTiquetesPeaje.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("fecha_inicio",fecha_ini);
         parametros.put("fecha_fin", fecha_fin);
         parametros.put("peaje", peaje);
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("SYSCTP- Remisión a Peaje");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        
        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
    
    public void ejecutarReporteTodosPeajes()
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        JasperReport subreporte;
        
        URL  in = this.getClass().getResource("/sysctp/reporte/remisionPeaje/ReporteRemisionPeajesTodos.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        URL  in2 = this.getClass().getResource("/sysctp/reporte/remisionPeaje/peajes.jasper");//Ruta del subreporte
        subreporte = (JasperReport) JRLoader.loadObject( in2 ); 
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("subreporte",subreporte);
         
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("SYSCTP- Remisión a Peaje");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        
        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
    
    
    
 
}
