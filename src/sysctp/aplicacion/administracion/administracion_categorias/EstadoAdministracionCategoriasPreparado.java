
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.aplicacion.administracion.OperacionInsercion;
import sysctp.aplicacion.administracion.OperacionEdicion;
import sysctp.aplicacion.administracion.OperacionEliminacion;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class EstadoAdministracionCategoriasPreparado extends EstadoAdministracionCategoriasActivo{
    
    private static EstadoAdministracionCategoriasPreparado instance;
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionCategoriasPreparado();
        return instance;
    }
    
    private EstadoAdministracionCategoriasPreparado(){}
    
    public void iniciarEliminacion(ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionEliminacion operacion = new OperacionEliminacion();
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasEliminando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void iniciarInsercion(ControladorAdministracionCategorias contraladorAdministracion) {
        Categoria elemento = new Categoria();
        OperacionInsercion operacion = new OperacionInsercion();
        operacion.setElementoObjetivo(elemento);
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasInsertando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void iniciarModificacion(ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionEdicion operacion = new OperacionEdicion();
        contraladorAdministracion.setOperacionActual(operacion);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasEditando.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
}
