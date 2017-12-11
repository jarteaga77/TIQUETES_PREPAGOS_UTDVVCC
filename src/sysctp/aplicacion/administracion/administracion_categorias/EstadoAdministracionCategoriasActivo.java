/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_categorias;

/**
 *
 * @author james
 */
public class EstadoAdministracionCategoriasActivo extends EstadoAdministracionCategoriasAbstracto {
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        return EstadoAdministracionCategoriasPreparado.getInstance();
    }
    
    @Override
    public void finalizarAdministracion(ControladorAdministracionCategorias controladorAdministracion){
        controladorAdministracion.setOperacionActual(null);
        controladorAdministracion.setCategoriasActuales(null);
        
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasInactivo.getInstance();
        controladorAdministracion.setEstado(estado);
    }
    
}
