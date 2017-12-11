
package sysctp.servicios.persistencia;

import java.util.Iterator;
import java.util.List;

/**
 * A pesar de que esta clase implementa la interfaz IAdaptadorPersistencia, no es un
 * adaptador de persistencia propiamente. Implementa la interfaz IAdaptadorPersistencia
 * solo para mantener uniformidad en la forma en que se llaman los metodos.
 * El objetivo de esta clase es mantener una cola de objetos de forma local
 * e ir registrando uno a uno cada tarea pendiente, en la persistencia externa,
 * en la medida que ello sea posible.
 *
 * @author James Andres Payan Caicedo
 */
public class AdaptadorTareasPersistenciaPendientes implements IAdaptadorPersistencia, Runnable {
    
    private IAdaptadorPersistencia persistenciaLocal, persistenciaExterna;
    
    /**
     * Recibe como parametros en el constructor, instancias de IAdaptadorPersistencia, para usarlas
     * como almacenamiento local y almacenamiento remoto.
     * 
     * @param persistenciaExterna objeto que se supone almacena los objetos remotamente
     * @param persistenciaLocal objeto que se supone almacena los objetos en disco
     */
    public AdaptadorTareasPersistenciaPendientes(IAdaptadorPersistencia persistenciaExterna, IAdaptadorPersistencia persistenciaLocal){
        this.persistenciaLocal = persistenciaLocal;
        this.persistenciaExterna = persistenciaExterna;
    }

    /**
     * Crea una tarea de almacenamiento pendiente, y la almacena localmente, para porteriormente 
     * completarla y así poderla eliminar de la persistencia local.
     * 
     * @param elemento elemento a ser almacenado
     */
    @Override
    public void almacenarElemento(Object elemento) {
        AlmacenamientoPendiente tarea = new AlmacenamientoPendiente(elemento);
        getPersistenciaLocal().almacenarElemento(tarea);
    }

    /**
     * Lanza la excepcion UnsupportedOperationException, dado a que esta clase
     * no está diseñada para gestionar la recuperación de elementos.
     * 
     * @param clase
     * @param id
     * @return
     */
    @Override
    public Object recuperarElemento(Class clase, long id) {
        throw new UnsupportedOperationException("El Adaptador de Tareas Pendientes no soporta recuperacion de elementos");
    }

    /**
     * Lanza la excepcion UnsupportedOperationException, dado a que esta clase
     * no está diseñada para gestionar la recuperación de elementos.
     * 
     * @param clase
     * @return
     */
    @Override
    public List recuperarTodosLosElementos(Class clase) {
        throw new UnsupportedOperationException("El Adaptador de Tareas Pendientes no soporta recuperacion de elmentos");
    }

    /**
     * Crea una nueva tarea pendiente de eliminación y la almacena localmente, para posteriormente
     * completarla y así poderla eliminar de la persistencia local
     * 
     * @param elemento a ser eliminado
     */
    @Override
    public void eliminarElemento(Object elemento) {
        EliminacionPendiente tarea = new EliminacionPendiente(elemento);
        getPersistenciaLocal().almacenarElemento(tarea);
    }

    /**
     * Cuanto se inicia este hilo, corre infinitamente, buscando cada 5 minutos
     * tareas pendientes, para ser ejecutadas y así tratar de completarlas.
     * Cada que completa una tarea pendiente, ésta es eliminada de la cola persistente
     * de tareas pendientes.
     * 
     */
    @Override
        public void run() {
            while(true){
                List resultado = getPersistenciaLocal().recuperarTodosLosElementos(TareaPendiente.class);
                for (Iterator i = resultado.iterator(); i.hasNext();){
                    try{
                        TareaPendiente tarea = (TareaPendiente) i.next();
                        tarea.ejecutar(getPersistenciaExterna());
                        getPersistenciaLocal().eliminarElemento(tarea);
                    }catch(Exception ex){
                        System.err.println("FALLA ALMACENANDO UN ELEMENTO DE REGISTRO.\n\t" + ex);
                        break;
                    }
                }
                try {
                    Thread.sleep(300000); // dormir 5 minutos  = 5 * 60 segundos = 300 segundos = 300000 milisegundos
                } catch (InterruptedException ex) {
                }
            }
        }

    /**
     * Lanza la excepcion UnsupportedOperationException, dado a que esta clase
     * no está diseñada para gestionar la recuperación de elementos.
     * 
     * @param clase
     * @param atributo
     * @param valor
     * @return
     */
    @Override
    public List recuperarElementos(Class clase, String atributo, Object valor) {
        throw new UnsupportedOperationException("El Adaptador de Tareas Pendientes no soporta recuperacion de elmentos");
    }

    /**
     * Getter del adaptador de persistencia local
     * 
     * @return el adaptador persistenciaLocal
     */
    public IAdaptadorPersistencia getPersistenciaLocal() {
        return persistenciaLocal;
    }

    /**
     * Setter del adaptador de persistencia externa
     * 
     * @param persistenciaLocal el adaptador persistenciaLocal a ser asignado
     */
    public void setPersistenciaLocal(IAdaptadorPersistencia persistenciaLocal) {
        this.persistenciaLocal = persistenciaLocal;
    }

    /**
     * Getter del adaptador de persistencia externa
     * 
     * @return el adaptador persistenciaExterna
     */
    public IAdaptadorPersistencia getPersistenciaExterna() {
        return persistenciaExterna;
    }

    /**
     * Setter del adaptador de persistencia externa
     * 
     * @param persistenciaExterna el adaptador persistenciaExterna a ser asignado
     */
    public void setPersistenciaExterna(IAdaptadorPersistencia persistenciaExterna) {
        this.persistenciaExterna = persistenciaExterna;
    }
    
}
