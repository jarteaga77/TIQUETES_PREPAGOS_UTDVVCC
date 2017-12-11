/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author james
 */
public class EstadoAdministracionTiposEjeAdicionalInsertando extends EstadoAdministracionTiposEjeAdicionalActivo{
    
    private static EstadoAdministracionTiposEjeAdicionalInsertando instance;
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionTiposEjeAdicionalInsertando();
        return instance;
    }
    
    private EstadoAdministracionTiposEjeAdicionalInsertando(){}
    
    public void confirmarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        TipoEjeAdicional tipoEjeAdicional=(TipoEjeAdicional)operacion.getElementoObjetivo();
        contraladorAdministracion.publishAdicionConfirmada(tipoEjeAdicional);
    }
    
    public void cancelarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void asignarNombre(String nombre, ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional) operacion.getElementoObjetivo();
        tipoEjeAdicional.setNombre(nombre);
    }
    
}