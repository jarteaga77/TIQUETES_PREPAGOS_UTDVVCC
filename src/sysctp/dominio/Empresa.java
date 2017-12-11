
package sysctp.dominio;

import sysctp.dominio.clientes.RegistroDeClientes;
import sysctp.dominio.inventario.CatalogoCategorias;
import sysctp.dominio.inventario.CatalogoTiposEjeAdicional;
import sysctp.dominio.inventario.CatalogoTiquetesPrepago;
import sysctp.dominio.inventario.ListaTiposTiquetesPrepagoPermitidos;
import sysctp.dominio.ventas.CatalogoCuentasBancarias;
import sysctp.dominio.ventas.CatalogoFormasDePago;
import sysctp.dominio.ventas.RegistroDeVentas;

/**
 * Clase que representa la empresa en su totalidad y se encarga de mantener referencia a todos los catalogos
 *
 * @author James Andres Payan Caicedo
 */
public class Empresa {
    private ListaTiposTiquetesPrepagoPermitidos listaTiposTiquetePrepagoPermitidos;
    private CatalogoTiquetesPrepago catalogoTiquetesPrepago;
    private RegistroDeVentas registroDeVentas;
    private CatalogoFormasDePago catalogoFormasDePago;
    private RegistroDeClientes registroDeClientes;
    private CatalogoCuentasBancarias catalogoCuentasBancarias;
    private CatalogoCategorias catalogoCategorias;
    private CatalogoTiposEjeAdicional catalogoTiposEjeAdicional;
    
    /**
     * Constructor por defecto. Crea todas las instancias de catalogos y registros disponibles.
     * 
     */
    public Empresa(){
        listaTiposTiquetePrepagoPermitidos = new ListaTiposTiquetesPrepagoPermitidos();
        catalogoTiquetesPrepago = new CatalogoTiquetesPrepago();
        registroDeVentas = new RegistroDeVentas();
        catalogoFormasDePago = new CatalogoFormasDePago();
        registroDeClientes = new RegistroDeClientes();
        catalogoCuentasBancarias = new CatalogoCuentasBancarias();
        catalogoCategorias = new CatalogoCategorias();
        catalogoTiposEjeAdicional = new CatalogoTiposEjeAdicional();
    }

    /**
     * Getter de la listaTiposTiquetePrepagoPermitidos
     * 
     * @return la listaTiposTiquetePrepagoPermitidos
     */
    public ListaTiposTiquetesPrepagoPermitidos getListaTiposTiquetePrepagoPermitidos() {
        return listaTiposTiquetePrepagoPermitidos;
    }

    /**
     * Setter de la listaTiposTiquetePrepagoPermitidos
     * 
     * @param listaTiposTiquetePrepagoPermitidos la listaTiposTiquetePrepagoPermitidos a ser asignada
     */
    public void setListaTiposTiquetePrepagoPermitidos(ListaTiposTiquetesPrepagoPermitidos listaTiposTiquetePrepagoPermitidos) {
        this.listaTiposTiquetePrepagoPermitidos = listaTiposTiquetePrepagoPermitidos;
    }

    /**
     * Geter del Catalogo de Tiquetes Prepago
     * 
     * @return el catalogoTiquetesPrepago
     */
    public CatalogoTiquetesPrepago getCatalogoTiquetesPrepago() {
        return catalogoTiquetesPrepago;
    }

    /**
     * 
     * @param catalogoTiquetesPrepago el catalogoTiquetesPrepago a ser asignado
     */
    public void setCatalogoTiquetesPrepago(CatalogoTiquetesPrepago catalogoTiquetesPrepago) {
        this.catalogoTiquetesPrepago = catalogoTiquetesPrepago;
    }

    /**
     * Getter del registro de ventas
     * 
     * @return el registroDeVentas
     */
    public RegistroDeVentas getRegistroDeVentas() {
        return registroDeVentas;
    }

    /**
     * Setter del registro de ventas
     * 
     * @param registroDeVentas el registroDeVentas a ser asignado
     */
    public void setRegistroDeVentas(RegistroDeVentas registroDeVentas) {
        this.registroDeVentas = registroDeVentas;
    }

    /**
     * Getter del catalogo de formas de pago
     * 
     * @return el catalogoFormasDePago
     */
    public CatalogoFormasDePago getCatalogoFormasDePago() {
        return catalogoFormasDePago;
    }

    /**
     * Setter del catalogo de formas de pago
     * 
     * @param catalogoFormasDePago el catalogoFormasDePago a ser asignado
     */
    public void setCatalogoFormasDePago(CatalogoFormasDePago catalogoFormasDePago) {
        this.catalogoFormasDePago = catalogoFormasDePago;
    }

    /**
     * Getter del registro de clientes
     * 
     * @return el registroDeClientes
     */
    public RegistroDeClientes getRegistroDeClientes() {
        return registroDeClientes;
    }

    /**
     * Setter del registro de clientes
     * 
     * @param registroDeClientes el registroDeClientes a ser asignado
     */
    public void setRegistroDeClientes(RegistroDeClientes registroDeClientes) {
        this.registroDeClientes = registroDeClientes;
    }

    /**
     * @return the catalogoCuentasBancarias
     */
    public CatalogoCuentasBancarias getCatalogoCuentasBancarias() {
        return catalogoCuentasBancarias;
    }

    /**
     * @param catalogoCuentasBancarias the catalogoCuentasBancarias to set
     */
    public void setCatalogoCuentasBancarias(CatalogoCuentasBancarias catalogoCuentasBancarias) {
        this.catalogoCuentasBancarias = catalogoCuentasBancarias;
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
     * @return the catalogoTiposEjeAdicional
     */
    public CatalogoTiposEjeAdicional getCatalogoTiposEjeAdicional() {
        return catalogoTiposEjeAdicional;
    }

    /**
     * @param catalogoTiposEjeAdicional the catalogoTiposEjeAdicional to set
     */
    public void setCatalogoTiposEjeAdicional(CatalogoTiposEjeAdicional catalogoTiposEjeAdicional) {
        this.catalogoTiposEjeAdicional = catalogoTiposEjeAdicional;
    }
}
