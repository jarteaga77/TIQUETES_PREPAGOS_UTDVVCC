
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
public class ReporteArqueoGeneral_2 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";//Ruta del logo de la empresa

    public void ejecutarReporte(long id_arqueo)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport
  
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sysctp/reporte/arqueoGeneral/ReporteArqueoGeneral.jasper");//Ruta del reporte maestro
    
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
       
 
        Map parametros = new HashMap();// Mapeo de los parametros
        parametros.clear();//Limpia la varible parametros
        parametros.put("id_arqueo",id_arqueo);
       
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
