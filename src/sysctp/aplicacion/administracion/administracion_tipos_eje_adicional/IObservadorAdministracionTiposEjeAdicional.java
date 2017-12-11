
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author James Andres Payan Caicedo
 */
public interface IObservadorAdministracionTiposEjeAdicional {
    public void onInsertar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional);
    public void onEliminar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional);
    public void onModificar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional);
}
