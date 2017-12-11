
package sysctp.servicios.persistencia;

import java.util.List;

/**
 * El proxy de persistencia se implementa para dar soporte a las fallas en almacenamiento persistente.
 * Se usa el patron proxy (GOF)
 *
 * @author James Andres Payan Caicedo
 */
public class ProxyPersistencia implements IAdaptadorPersistencia{
    
    private IAdaptadorPersistencia persistenciaExterna;
    private IAdaptadorPersistencia persistenciaTareasPendientes;
    
    /**
     * El Proxy se crea con una referencia al adaptador de persistencia externa
     * y una referencia al adaptador de tareas pendientes, en el caso que halla fallos
     * de almacenamiento persistente.
     * 
     * @param persistenciaExterna adaptador de persistencia externa
     * @param persistenciaTareasPendientes  adaptador de tareas pendientes de persistencia
     */
    public ProxyPersistencia(IAdaptadorPersistencia persistenciaExterna,
                             IAdaptadorPersistencia persistenciaTareasPendientes)
    {
        this.persistenciaExterna=persistenciaExterna;
        this.persistenciaTareasPendientes=persistenciaTareasPendientes;
    }

    /**
     * Almacena un elemento en el adaptador de persistencia externa.
     * Si ocurre algún fallo, almacena el elemento en el adaptador de
     * persistencia de tareas pendientes.
     * 
     * @param elemento elemento a ser almacenado
     */
    @Override
    public void almacenarElemento(Object elemento) {
        try{
            getPersistenciaExterna().almacenarElemento(elemento);
        }catch(FallaConexionConBaseDeDatosException falla){
            System.err.println("FALLA ALMACENANDO UN ELEMENTO DE REGISTRO, GUARDANDO LOCALMENTE TAREA PENDIENTE.\n\t" + falla);
            persistenciaTareasPendientes.almacenarElemento(elemento);
        }
    }

     /**
     * Recupera un objeto del almacenamiento persistente externo. 
     * Está clase no se diseño para proveer soporte ante fallos de recuperación de elementos
     * 
     * @param clase clase del objeto a recuperar
     * @param id identificador del objeto
     * @return el objeto correpondiente a la clase e identificador dados.
     */
    @Override
    public Object recuperarElemento(Class clase, long id) {
        return getPersistenciaExterna().recuperarElemento(clase, id);
    }

    /**
     * Recupera todas las instancias de objetos, de la clase dada.
     * Está clase no se diseño para proveer soporte ante fallos de recuperación de elementos
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @return todas las instancias de objetos, de la clase dada.
     */
    @Override
    public List recuperarTodosLosElementos(Class clase) {
        return getPersistenciaExterna().recuperarTodosLosElementos(clase);
    }

    /**
     * Elimina un elemento en el adaptador de persistencia externa.
     * Si ocurre algún fallo, elimina el elemento en el adaptador de
     * persistencia de tareas pendientes, el cual creara una tarea de eliminacion
     * pendiente, para posteriormente eliminar el elemento de persistencia externa.
     * 
     * @param elemento elemento a ser eliminado
     */
    @Override
    public void eliminarElemento(Object elemento) {
        try{
            getPersistenciaExterna().eliminarElemento(elemento);
        }catch(FallaConexionConBaseDeDatosException falla){
            getPersistenciaTareasPendientes().eliminarElemento(elemento);
        }
        
    }

    /**
     * Getter de persistencia Externa
     * 
     * @return el adaptador de persistenciaExterna
     */
    public IAdaptadorPersistencia getPersistenciaExterna() {
        return persistenciaExterna;
    }

    /**
     * Setter de persistencia externa
     * 
     * @param persistenciaExterna el adaptador de persistencia externa a ser asignado
     */
    public void setPersistenciaExterna(IAdaptadorPersistencia persistenciaExterna) {
        this.persistenciaExterna = persistenciaExterna;
    }

    /**
     * Getter del adapatador de persistencia de tareas pendientes
     * 
     * @return el adaptador de persistencia de tareas pendientes
     */
    public IAdaptadorPersistencia getPersistenciaTareasPendientes() {
        return persistenciaTareasPendientes;
    }

    /**
     * Setter del adaptador de persistencia de tareas pendientes
     * 
     * @param persistenciaTareasPendientes el adaptador de persistencia a ser asignado
     */
    public void setPersistenciaProvisional(IAdaptadorPersistencia persistenciaTareasPendientes) {
        this.persistenciaTareasPendientes = persistenciaTareasPendientes;
    }

    /**
     * Recupera todas las instancias de objetos de la clase dada,
     * cuyo atributo "atributo" es igual al valor dado.
     * Está clase no se diseño para proveer soporte ante fallos de recuperación de elementos
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @param atributo el atributo señalado a ser inspeccionado
     * @param valor el valor que debe tener el atributo inspeccionado
     * @return todas las instancias de objetos de la clase dada, cuyo atributo "atributo" es igual al valor dado.
     */
    @Override
    public List recuperarElementos(Class clase, String atributo, Object valor) {
        return this.persistenciaExterna.recuperarElementos(clase, atributo, valor);
    }
    
    
}
