
package sysctp.aplicacion.administracion.administracion_categorias;

import sysctp.aplicacion.administracion.OperacionAdministracion;
import java.util.ArrayList;
import java.util.List;
import sysctp.dominio.Empresa;
import sysctp.dominio.inventario.CatalogoCategorias;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class ControladorAdministracionCategorias {
    
    private OperacionAdministracion operacionActual;
    private List<Categoria> categoriasActuales;
    private EstadoAdministracionCategoriasAbstracto estado;
    private CatalogoCategorias catalogoCategorias;
    private List<IObservadorAdministracionCategorias> observadores;
    
    public ControladorAdministracionCategorias(Empresa empresa){
        estado = EstadoAdministracionCategoriasInactivo.getInstance();
        observadores = new ArrayList();
        catalogoCategorias = empresa.getCatalogoCategorias();
    }
    
    
    public void iniciarAdministracion(){estado.iniciarAdministracion(this);}
    public void finalizarAdministracion(){estado.finalizarAdministracion(this);}
    
    
    public void iniciarModificacion(){estado.iniciarModificacion(this);}
    public void iniciarEliminacion(){estado.iniciarEliminacion(this);}
    public void iniciarInsercion(){estado.iniciarInsercion(this);}
    
    public void cancelarOperacion(){estado.cancelarOperacion(this);}
    public void confirmarOperacion(){estado.confirmarOperacion(this);}
    
    
    public void seleccionarCategoria(int index){estado.seleccionarCategoria(index,this);}
    public void asignarNombre(String nombre){estado.asignarNombre(nombre,this);}
    
    
    
    
    void cargarElementos(){
        categoriasActuales = (List<Categoria>) catalogoCategorias.obtenerTodosLosElementos();
    }
    
    void adicionarOperacionConfirmada(OperacionAdministracion operacion){
        operacion.ejecutar(catalogoCategorias);
    }
    

    
    void publishAdicionConfirmada(Categoria categoria){
        for (IObservadorAdministracionCategorias observador : observadores){
            observador.onInsertar(this, categoria);
        }
    }
    
    void publishEliminacionConfirmada(Categoria categoria){
        for (IObservadorAdministracionCategorias observador : observadores){
            observador.onEliminar(this, categoria);
        }
    }
    
    void publishModificacionConfirmada(Categoria categoria){
        for (IObservadorAdministracionCategorias observador : observadores){
            observador.onModificar(this, categoria);
        }
    }
    
    public void adicionarObservador (IObservadorAdministracionCategorias observador){
        observadores.add(observador);
    }
    
    public void eliminarObservador (IObservadorAdministracionCategorias observador){
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
    public EstadoAdministracionCategoriasAbstracto getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    void setEstado(EstadoAdministracionCategoriasAbstracto estado) {
        this.estado = estado;
    }

    /**
     * @return the catalogoCategorias
     */
    public CatalogoCategorias getCatalogoCategorias() {
        return catalogoCategorias;
    }

    /**
     * @param catalogoCategorias the catalogoCategorias to set
     */
    public void setCatalogoCategorias(CatalogoCategorias catalogoCategorias) {
        this.catalogoCategorias = catalogoCategorias;
    }

    /**
     * @return the categoriasActuales
     */
    public List<Categoria> getCategoriasActuales() {
        return categoriasActuales;
    }

    /**
     * @param categoriasActuales the categoriasActuales to set
     */
    void setCategoriasActuales(List<Categoria> categoriasActuales) {
        this.categoriasActuales = categoriasActuales;
    }
    
    
    
    
}
