
package sysctp.reporte.canExcedente;


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
public class Reporte_Excedentes 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String encabezado="/sysctp/presentacion/recursos/encabezado.png";//Ruta del logo de la empresa
  //private final String pie="/UTDVVCC/recursos/pie.png";
  
  
    public void ejecutarReporte(long  recibo)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sysctp/reporte/canExcedente/CancExcedente.jasper");//Ruta del reporte maestro
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
       
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("recibo",recibo);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         
         parametros.put("encabezado",this.getClass().getResourceAsStream(encabezado));//Carga la imagen encabezado en el reporte
        // parametros.put("pie",this.getClass().getResourceAsStream(pie));//Carga la imagen pie en el reporte
     
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("SYSCTP - Cancelación Excedentes ");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
