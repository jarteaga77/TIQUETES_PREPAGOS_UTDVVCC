
package sysctp.reporte.ActaCambio.Dependencias;


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
public class ReporteActasCambioDepe 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  private final String logo="/sysctp/presentacion/recursos/encabezado.png";//Ruta del logo de la empresa

    public void ejecutarReporte(Date fechaIni, Date fechaFin)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport
        JasperReport subreporteExcedentes;// varible de tipo JasperReport
        JasperReport subreporteEntregados;// varible de tipo JasperReport
        
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sysctp/reporte/ActaCambio/Dependencias/Reporte_ActaCambio_Depe.jasper");//Ruta del reporte maestro
        URL  in1 = this.getClass().getResource("/sysctp/reporte/ActaCambio/Dependencias/subreporte_recibidos_depe.jasper");//Ruta del subreporte
        URL  in2 = this.getClass().getResource("/sysctp/reporte/ActaCambio/Dependencias/sub_can_excedente_Depe.jasper");//Ruta del subreporte
       
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        subreporteEntregados = (JasperReport) JRLoader.loadObject( in1 ); 
        subreporteExcedentes = (JasperReport) JRLoader.loadObject( in2 ); 
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("fecha_ini", fechaIni);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("fecha_final", fechaFin);
         parametros.put("sub_entregados", subreporteEntregados);
         parametros.put("sub_excedentes", subreporteExcedentes);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("logo",this.getClass().getResourceAsStream(logo));//Carga la imagen logo en el reporte
      
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("SYSCTP- Reporte Actas de Cambio-Dependencias");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
