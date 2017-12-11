/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_categorias;

/**
 *
 * @author james
 */
public abstract class EstadoAdministracionCategoriasAbstracto {
    
    public void iniciarInsercion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void confirmarOperacion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void cancelarOperacion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void iniciarEliminacion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void iniciarModificacion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void seleccionarCategoria(int index, ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void finalizarAdministracion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void iniciarAdministracion(ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
    public void asignarNombre(String nombre, ControladorAdministracionCategorias controladorAdministracion) {
        throw new UnsupportedOperationException("El actual estado no permite ejecutar esta operación.");
    }
    
}
