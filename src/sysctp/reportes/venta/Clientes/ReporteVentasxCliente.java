
package sysctp.reportes.venta.Clientes;

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
public class ReporteVentasxCliente 
{
    private Conexion nueva=new Conexion();
    private final String logo="/sysctp/presentacion/recursos/encabezado.png";
    
    public void ejecutarReporte(Date fechaIni,Date fechaFin,Long nit)
    {
        try
        {
        JasperReport reporte;
        JasperPrint reporte_view;
        
        URL  in = this.getClass().getResource("/sysctp/reportes/venta/Clientes/Consultarxclientes.jasper");
        reporte = (JasperReport) JRLoader.loadObject( in );
        
         Map parametros = new HashMap();
         parametros.clear();
         parametros.put("nit",nit);
         parametros.put("fechaIni", fechaIni);
         parametros.put("fechaFin", fechaFin);
         parametros.put("logo", this.getClass().getResourceAsStream(logo));
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);
         jviewer.setTitle("SYSCTP - Reporte Venta por Cliente");
         jviewer.setVisible(true);
         
         nueva.desconectar();

        
        }catch(JRException e)
        {
            System.out.println(e);
        }
    }
    
}
