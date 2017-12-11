/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author james
 */
public class EstadoAdministracionCategoriasInsertando extends EstadoAdministracionCategoriasActivo{
    
    private static EstadoAdministracionCategoriasInsertando instance;
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionCategoriasInsertando();
        return instance;
    }
    
    private EstadoAdministracionCategoriasInsertando(){}
    
    public void confirmarOperacion(ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        contraladorAdministracion.adicionarOperacionConfirmada(operacion);
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
        Categoria categoria=(Categoria)operacion.getElementoObjetivo();
        contraladorAdministracion.publishAdicionConfirmada(categoria);
    }
    
    public void cancelarOperacion(ControladorAdministracionCategorias contraladorAdministracion) {
        contraladorAdministracion.setOperacionActual(null);
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasPreparado.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
    
    public void asignarNombre(String nombre, ControladorAdministracionCategorias contraladorAdministracion) {
        OperacionAdministracion operacion = contraladorAdministracion.getOperacionActual();
        Categoria categoria = (Categoria) operacion.getElementoObjetivo();
        categoria.setNombre(nombre);
    }
    
}