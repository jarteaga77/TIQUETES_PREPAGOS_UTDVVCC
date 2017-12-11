/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

/**
 *
 * @author james
 */
public class EstadoAdministracionTiposEjeAdicionalActivo extends EstadoAdministracionTiposEjeAdicionalAbstracto {
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        return EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
    }
    
    @Override
    public void finalizarAdministracion(ControladorAdministracionTiposEjeAdicional controladorAdministracion){
        controladorAdministracion.setOperacionActual(null);
        controladorAdministracion.setTiposEjeAdicionalActuales(null);
        
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalInactivo.getInstance();
        controladorAdministracion.setEstado(estado);
    }
    
}
