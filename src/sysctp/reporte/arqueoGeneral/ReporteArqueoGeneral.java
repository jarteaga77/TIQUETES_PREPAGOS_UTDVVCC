
package sysctp.reporte.arqueoGeneral;


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
public class ReporteArqueoGeneral 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";//Ruta del logo de la empresa

    public void ejecutarReporte()
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport
        JasperReport subreporte_anulado;
        JasperReport subreporte_disponible;
        JasperReport subreporte_remision;
        JasperReport subreporte_totalVendido;
        
        
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sysctp/reporte/arqueoGeneral/ArqueoGeneral.jasper");//Ruta del reporte maestro
        URL  ini1=this.getClass().getResource("/sysctp/reporte/arqueoGeneral/subreporte_anulados.jasper");
        URL  ini2=this.getClass().getResource("/sysctp/reporte/arqueoGeneral/subreporte_disponibles.jasper");
        URL  ini3=this.getClass().getResource("/sysctp/reporte/arqueoGeneral/subreporte_remision.jasper");
        URL  ini4=this.getClass().getResource("/sysctp/reporte/arqueoGeneral/subreporte_tvend.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        subreporte_anulado = (JasperReport) JRLoader.loadObject( ini1 );
        subreporte_disponible = (JasperReport) JRLoader.loadObject( ini2 );
        subreporte_remision = (JasperReport) JRLoader.loadObject( ini3 );
        subreporte_totalVendido = (JasperReport) JRLoader.loadObject( ini4 );
 
        Map parametros = new HashMap();// Mapeo de los parametros
        parametros.clear();//Limpia la varible parametros
        parametros.put("vendidos", subreporte_totalVendido);
        parametros.put("anulados", subreporte_anulado);
        parametros.put("disponibles", subreporte_disponible);
        parametros.put("remision", subreporte_remision);
        parametros.put("logo",  this.getClass().getResourceAsStream(logo));//Carga la imagen logo en el reporte
      
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("SYSCTP- Arqueo General");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
