
package sysctp.dominio.inventario;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 * Mantiene una referencia a las categorías de vehículos que pueden ser asignadas a los tiquetes prepagos.
 * Extiende la clase registro de la capa de servicios.gestion_persistencia.
 *
 * @author James Andrés Payan Caicedo
 */
public class CatalogoCategorias extends Registro{
    /**
     * Constructor por defecto
     */
    public CatalogoCategorias(){
        super(Categoria.class); // se indica que tipo de elementos va a almacenar esta implementación de registro
    }    
    
    
     /**
     * Obtiene un ejemplar de Categoria, dado un identificador
     *
     * @param id identificador de Categoria
     * @return ejemplar de categoría
     */
    public Categoria obtenerCategoria(long id){
        return (Categoria)super.obtenerElemento(id);
    }
    
}
