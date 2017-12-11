/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.List;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author james
 */
public class EstadoAdministracionTiposEjeAdicionalEliminando extends EstadoAdministracionTiposEjeAdicionalActivo{
    
    private static EstadoAdministracionTiposEjeAdicionalEliminando instance;
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionTiposEjeAdicionalEliminando();
        return instance;
    }
    
    private EstadoAdministracionTiposEjeAdicionalEliminando(){}
 
    public void confirmarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional)operacion.getElementoObjetivo();
        contraladorAdministracion.publishEliminacionConfirmada(tipoEjeAdicional);
    }
    
    public void cancelarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void seleccionarTipoEjeAdicional(int index, ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        List<TipoEjeAdicional> tiposEjeAdicionalActuales = contraladorAdministracion.getTiposEjeAdicionalActuales();
        TipoEjeAdicional tipoEjeAdicional = tiposEjeAdicionalActuales.get(index);
        operacion.setElementoObjetivo(tipoEjeAdicional);
    }
    
}
