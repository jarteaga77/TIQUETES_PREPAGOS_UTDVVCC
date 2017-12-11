
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.ArrayList;
import java.util.List;
import sysctp.dominio.Empresa;
import sysctp.dominio.inventario.CatalogoTiposEjeAdicional;
import sysctp.dominio.inventario.TipoEjeAdicional;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class ControladorAdministracionTiposEjeAdicional {
    
    private OperacionAdministracion operacionActual;
    private List<TipoEjeAdicional> tiposEjeAdicionalActuales;
    private EstadoAdministracionTiposEjeAdicionalAbstracto estado;
    private CatalogoTiposEjeAdicional catalogoTiposEjeAdicional;
    private List<IObservadorAdministracionTiposEjeAdicional> observadores;
    
    public ControladorAdministracionTiposEjeAdicional(Empresa empresa){
        estado = EstadoAdministracionTiposEjeAdicionalInactivo.getInstance();
        observadores = new ArrayList();
        catalogoTiposEjeAdicional = empresa.getCatalogoTiposEjeAdicional();
    }
    
    
    public void iniciarAdministracion(){estado.iniciarAdministracion(this);}
    public void finalizarAdministracion(){estado.finalizarAdministracion(this);}
    
    
    public void iniciarModificacion(){estado.iniciarModificacion(this);}
    public void iniciarEliminacion(){estado.iniciarEliminacion(this);}
    public void iniciarInsercion(){estado.iniciarInsercion(this);}
    
    public void cancelarOperacion(){estado.cancelarOperacion(this);}
    public void confirmarOperacion(){estado.confirmarOperacion(this);}
    
    
    public void seleccionarTipoEjeAdicional(int index){estado.seleccionarTipoEjeAdicional(index,this);}
    public void asignarNombre(String nombre){estado.asignarNombre(nombre,this);}
    
    
    
    
    void cargarElementos(){
        tiposEjeAdicionalActuales = (List<TipoEjeAdicional>) catalogoTiposEjeAdicional.obtenerTodosLosElementos();
    }
    
    void adicionarOperacionConfirmada(OperacionAdministracion operacion){
        operacion.ejecutar(catalogoTiposEjeAdicional);
    }
    

    
    void publishAdicionConfirmada(TipoEjeAdicional tipoEjeAdicional){
        for (IObservadorAdministracionTiposEjeAdicional observador : observadores){
            observador.onInsertar(this, tipoEjeAdicional);
        }
    }
    
    void publishEliminacionConfirmada(TipoEjeAdicional tipoEjeAdicional){
        for (IObservadorAdministracionTiposEjeAdicional observador : observadores){
            observador.onEliminar(this, tipoEjeAdicional);
        }
    }
    
    void publishModificacionConfirmada(TipoEjeAdicional tipoEjeAdicional){
        for (IObservadorAdministracionTiposEjeAdicional observador : observadores){
            observador.onModificar(this, tipoEjeAdicional);
        }
    }
    
    public void adicionarObservador (IObservadorAdministracionTiposEjeAdicional observador){
        observadores.add(observador);
    }
    
    public void eliminarObservador (IObservadorAdministracionTiposEjeAdicional observador){
        observadores.remove(observador);
    }

    /**
     * @return the operacionActual
     */
    public OperacionAdministracion getOperacionActual() {
        return operacionActual;
    }

    /**
     * @param operacionActual the operacionActual to set
     */
    void setOperacionActual(OperacionAdministracion operacionActual) {
        this.operacionActual = operacionActual;
    }

    /**
     * @return the estado
     */
    public EstadoAdministracionTiposEjeAdicionalAbstracto getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    void setEstado(EstadoAdministracionTiposEjeAdicionalAbstracto estado) {
        this.estado = estado;
    }

    /**
     * @return the catalogoCategorias
     */
    public CatalogoTiposEjeAdicional getCatalogoTiposEjeAdicional() {
        return catalogoTiposEjeAdicional;
    }

    /**
     * @param catalogoCategorias the catalogoCategorias to set
     */
    public void setCatalogoTiposEjeAdiciona(CatalogoTiposEjeAdicional catalogoTiposEjeAdicional) {
        this.catalogoTiposEjeAdicional = catalogoTiposEjeAdicional;
    }

    /**
     * @return the categoriasActuales
     */
    public List<TipoEjeAdicional> getTiposEjeAdicionalActuales() {
        return tiposEjeAdicionalActuales;
    }

    /**
     * @param categoriasActuales the categoriasActuales to set
     */
    void setTiposEjeAdicionalActuales(List<TipoEjeAdicional> tiposEjeAdicionalActuales) {
        this.tiposEjeAdicionalActuales = tiposEjeAdicionalActuales;
    }
    
    
    
    
}
