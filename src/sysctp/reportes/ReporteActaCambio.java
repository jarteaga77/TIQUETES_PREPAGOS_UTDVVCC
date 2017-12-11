
package sysctp.reportes;


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
public class ReporteActaCambio 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";//Ruta del logo de la empresa

    public void ejecutarReporte(long consecutivo)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport
        //JasperReport subreporteRecibidos;// varible de tipo JasperReport
        JasperReport subreporteEntregados;// varible de tipo JasperReport
        
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sysctp/reportes/ActaCambio.jasper");//Ruta del reporte maestro
        //URL  in1 = this.getClass().getResource("/sysctp/reportes/ActaCambio_TablaRecibidos.jasper");//Ruta del subreporte
        URL  in2 = this.getClass().getResource("/sysctp/reportes/Acta_Cambio_Entregados.jasper");//Ruta del subreporte
       
        
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        //subreporteRecibidos = (JasperReport) JRLoader.loadObject( in1 ); 
        subreporteEntregados = (JasperReport) JRLoader.loadObject( in2 ); 
   
        

         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("acta", consecutivo);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
        // parametros.put("recibidos", subreporteRecibidos);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("entregados", subreporteEntregados);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("logo",  this.getClass().getResourceAsStream(logo));//Carga la imagen logo en el reporte
        
      
         
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Acta de Cambio Boleteria Prepagada UTDVVCC");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
