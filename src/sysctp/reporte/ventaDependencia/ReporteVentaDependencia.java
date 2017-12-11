
package sysctp.reporte.ventaDependencia;


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
public class ReporteVentaDependencia 

{
  private Conexion nueva=new Conexion();
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";
    
    public void ejecutarReporte(long ven_dep_id)
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reporte/ventaDependencia/reporte_ven_depen.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("ven_dep_id",ven_dep_id);
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("Recibo Venta Dependencia");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
 
}
