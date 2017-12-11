
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author James Andres Payan Caicedo
 */
public interface IObservadorAdministracionCategorias {
    public void onInsertar(ControladorAdministracionCategorias controlador, Categoria categoria);
    public void onEliminar(ControladorAdministracionCategorias controlador, Categoria categoria);
    public void onModificar(ControladorAdministracionCategorias controlador, Categoria categoria);
}
