
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.List;
import sysctp.dominio.inventario.Categoria;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class EstadoAdministracionTiposEjeAdicionalEditando extends EstadoAdministracionTiposEjeAdicionalActivo{
    
    private static EstadoAdministracionTiposEjeAdicionalEditando instance;
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionTiposEjeAdicionalEditando();
        return instance;
    }
    
    private EstadoAdministracionTiposEjeAdicionalEditando(){}
    
    public void confirmarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional)operacion.getElementoObjetivo();
        contraladorAdministracion.publishModificacionConfirmada(tipoEjeAdicional);
    }
    
    public void cancelarOperacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void seleccionarTipoEjeAdicional(int index, ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        List<TipoEjeAdicional> tiposEjesAdicionalActuales = contraladorAdministracion.getTiposEjeAdicionalActuales();
        TipoEjeAdicional tipoEjeAdicional = tiposEjesAdicionalActuales.get(index);
        operacion.setElementoObjetivo(tipoEjeAdicional);
    }
    
    public void asignarNombre(String nombre, ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        TipoEjeAdicional tipoEjeAdicional = (TipoEjeAdicional) operacion.getElementoObjetivo();
        if (tipoEjeAdicional != null){
            tipoEjeAdicional.setNombre(nombre);
        }else{
            throw new NullPointerException("Primero debe seleccionar la categoría a ser modificada");
        }
    }
    
}
