
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.aplicacion.administracion.OperacionInsercion;
import sysctp.aplicacion.administracion.OperacionEdicion;
import sysctp.aplicacion.administracion.OperacionEliminacion;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class EstadoAdministracionTiposEjeAdicionalPreparado extends EstadoAdministracionTiposEjeAdicionalActivo{
    
    private static EstadoAdministracionTiposEjeAdicionalPreparado instance;
    
    public static EstadoAdministracionTiposEjeAdicionalAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionTiposEjeAdicionalPreparado();
        return instance;
    }
    
    private EstadoAdministracionTiposEjeAdicionalPreparado(){}
    
    public void iniciarEliminacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionEliminacion operacion = new OperacionEliminacion();
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalEliminando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void iniciarInsercion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        TipoEjeAdicional elemento = new TipoEjeAdicional();
        OperacionInsercion operacion = new OperacionInsercion();
        operacion.setElementoObjetivo(elemento);
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalInsertando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void iniciarModificacion(ControladorAdministracionTiposEjeAdicional contraladorAdministracion) {
        OperacionEdicion operacion = new OperacionEdicion();
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionTiposEjeAdicionalAbstracto estado = EstadoAdministracionTiposEjeAdicionalEditando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
}
