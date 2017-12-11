/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

/**
 *
 * @author james
 */
public class EstadoAdministracionTiposEjeAdicionalInactivo extends EstadoAdministracionTiposEjeAdicionalAbstracto{
    
    private static EstadoAdministracionTiposEjeAdicionalInactivo instance;
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionTiposEjeAdicionalInactivo();
        return instance;
    }
    
    private EstadoAdministracionTiposEjeAdicionalInactivo(){}
    
    @Override
    public void iniciarAdministracion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion){
        contraladorAdministracion.cargarElementos();
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalActivo.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
}
