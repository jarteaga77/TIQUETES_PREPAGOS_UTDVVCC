/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_categorias;

/**
 *
 * @author james
 */
public class EstadoAdministracionCategoriasInactivo extends EstadoAdministracionCategoriasAbstracto{
    
    private static EstadoAdministracionCategoriasInactivo instance;
    
    public static EstadoAdministracionCategoriasAbstracto getInstance(){
        if (instance==null) instance=new EstadoAdministracionCategoriasInactivo();
        return instance;
    }
    
    private EstadoAdministracionCategoriasInactivo(){}
    
    @Override
    public void iniciarAdministracion(ControladorAdministracionCategorias contraladorAdministracion){
        contraladorAdministracion.cargarElementos();
        EstadoAdministracionCategoriasAbstracto estado = EstadoAdministracionCategoriasActivo.getInstance();
        contraladorAdministracion.setEstado(estado);
    }
}
