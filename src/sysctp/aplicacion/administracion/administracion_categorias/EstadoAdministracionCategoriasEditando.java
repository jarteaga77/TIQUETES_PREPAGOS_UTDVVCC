
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.List;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class EstadoAdministracionCategoriasEditando extends EstadoAdministracionCategoriasActivo{
    
    private static EstadoAdministracionCategoriasEditando instance;
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionCategoriasEditando();
        return instance;
    }
    
    private EstadoAdministracionCategoriasEditando(){}
    
    public void confirmarOperacion(ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        Categoria categoria = (Categoria)operacion.getElementoObjetivo();
        contraladorAdministracion.publishModificacionConfirmada(categoria);
    }
    
    public void cancelarOperacion(ControladorAdministracionCategorias contraladorAdministracion) {
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void seleccionarCategoria(int index, ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        List<Categoria> categoriasActuales = contraladorAdministracion.getCategoriasActuales();
        Categoria categoria = categoriasActuales.get(index);
        operacion.setElementoObjetivo(categoria);
    }
    
    public void asignarNombre(String nombre, ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        Categoria categoria = (Categoria) operacion.getElementoObjetivo();
        if (categoria != null){
            categoria.setNombre(nombre);
        }else{
            throw new NullPointerException("Primero debe seleccionar la categoría a ser modificada");
        }
    }
    
}
