/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.List;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author james
 */
public class EstadoAdministracionCategoriasEliminando extends EstadoAdministracionCategoriasActivo{
    
    private static EstadoAdministracionCategoriasEliminando instance;
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionCategoriasEliminando();
        return instance;
    }
    
    private EstadoAdministracionCategoriasEliminando(){}
 
    public void confirmarOperacion(ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        Categoria categoria = (Categoria)operacion.getElementoObjetivo();
        contraladorAdministracion.publishEliminacionConfirmada(categoria);
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
    
}
