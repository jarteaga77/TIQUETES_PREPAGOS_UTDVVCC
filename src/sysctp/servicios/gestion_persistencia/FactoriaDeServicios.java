
package sysctp.servicios.gestion_persistencia;

import sysctp.servicios.persistencia.AdaptadorPersistenciaHibernate;
import sysctp.servicios.persistencia.AdaptadorPersistenciaLocalDB4O;
import sysctp.servicios.persistencia.AdaptadorTareasPersistenciaPendientes;
import sysctp.servicios.persistencia.IAdaptadorPersistencia;
import sysctp.servicios.persistencia.ProxyPersistencia;
import sysctp.servicios.util.PropiedadesDelSistema;

/**
 * Factoria que oculta la complejidad de la creación de los servicios como 
 * caché y adaptadores de persistencia.
 * El acceso a una unica instancia de la clase, es global, a traves
 * del patron Singleton
 *
 * @author James Andres Payan Caicedo
 */
public class FactoriaDeServicios {
    
    
    //***********************************************
    private static FactoriaDeServicios instancia; // unica instancia de la factoria de servicios. Se almacena como atributo estatic de la clase
    
    /**
     * Obtiene la unica instancia de la factoría de servicios
     * 
     * @return instancia de la factoria de servicios
     */
    public static FactoriaDeServicios obtenerInstancia(){
        if(instancia == null)
            instancia = new FactoriaDeServicios();
        return instancia;
    }
    //************************************************
    // metodos y atributos estaticos que dan soporte al patron singleton
    
    private IAdaptadorPersistencia adaptadorPersistencia;
    
    // El contructor de la clase es privado, así que no se pude crear instancias de la clase desde otro objeto.
    // Esto es para dar soporte al patron singleton.
    private FactoriaDeServicios(){
        /* el contructor crea una instancia al un adaptador de persistencia
         * este en realiada es un proxie que utiliza por un lado un adaptador de persistencia externa con hibernate
         * y por el otro un adaptador de persistencia que almacena tareas pendientes, cuando ocurre algun falla en la persistencia externa.
         * El adaptador de persistencia de tareas pendientes, se configura para dar soporte persistente de las tareas pendientes
         * con un adaptador de persistencia local, implementado con DB4O.
         * Al adaptdor de persistencia de tareas pendientes tambien se le indica que el adaptador de persisntencia externa es el de hibernate
         * pasando la misma instancia que se le pasa al adaptador proxy, esto para que el se encargue de forma autonoma de completar las tareas
         * pendientes.
         */
        AdaptadorPersistenciaHibernate persistenciaExterna = new AdaptadorPersistenciaHibernate();
        AdaptadorPersistenciaLocalDB4O persistenciaLocal = new AdaptadorPersistenciaLocalDB4O("dbProvisional");
        AdaptadorTareasPersistenciaPendientes tareasPendientesPersistencia = new AdaptadorTareasPersistenciaPendientes(persistenciaExterna,persistenciaLocal);
        Thread demonioCompletarTareasPendientesPersistencia = new Thread(tareasPendientesPersistencia);
        demonioCompletarTareasPendientesPersistencia.start(); // Inicia un demonio que verifica que tareas están pendientes y las completa
        adaptadorPersistencia = new ProxyPersistencia(persistenciaExterna,tareasPendientesPersistencia); // se deja como referencia de campo el adaptador que se entregara a quien lo solicite
    }
    
    /**
     * Obtiene la instancia de adaptador de persistencia referenciada en el atributo
     * 
     * @return la instancia de adaptador de persistencia referenciada en el atributo
     */
    public IAdaptadorPersistencia obtenerAdaptadorPersistencia(){
        return adaptadorPersistencia;
    }
    
    /**
     * Obtiene una implementación de ICache, para dar servicio de caché a quien lo solicita.
     * 
     * @param nombre el nombre de la cache. Se utiliza para recuperar los posibles atributos almacenados en las propiedades del sistema, y para dar nombre a la base de datos local
     * @return una implementación de ICache, para dar servicio de caché a quien lo solicita.
     */
    public ICache obtenerCache(String nombre){
        
        /* la caché que se retorna, es una caché de dos niveles
         * la cual se configura para que en el nivel 1 utilice una cache en memoria
         * y en el segundo nivel una caché de elementos persistente, la cual a su 
         * vez se configura para que utilice un adaptador de persistencial local con DB4O
         */
        CacheDosNiveles chacheDosNiveles = new CacheDosNiveles();
        int maxElementosNivel_1 = 0;
        int maxElementosNivel_2 = 0;
        
        // en las propiedades del sistema, está registrado, el numero de elementos que pude contener la caché de nivel 1 y 2
        try{
            maxElementosNivel_1 = Integer.parseInt(PropiedadesDelSistema.obtenerInscancia().obtenerPropiedad(nombre + ".cache.nivel_1")); 
        }catch(Exception e){}
        try{
            maxElementosNivel_2 = Integer.parseInt(PropiedadesDelSistema.obtenerInscancia().obtenerPropiedad(nombre + ".cache.nivel_2"));
        }catch(Exception e){}
        
        // si la cantidad de elementos que puede mantener en la caché no es superior a ser, simplemento no se crea la caché
        if (maxElementosNivel_1>0){
            CacheEnMemoria cacheEnMemoria = new CacheEnMemoria();
            cacheEnMemoria.setMaximaCantidadElementos(maxElementosNivel_1);
            chacheDosNiveles.setNivel_1(cacheEnMemoria);
        }
        if (maxElementosNivel_2>0){
            AdaptadorPersistenciaLocalDB4O persistenciaLocal = new AdaptadorPersistenciaLocalDB4O(nombre);
            CacheEnDisco cacheEnDisco = new CacheEnDisco(persistenciaLocal);
            
            cacheEnDisco.setMaximaCantidadElementos(maxElementosNivel_2);
            chacheDosNiveles.setNivel_2(cacheEnDisco);
        }
        
        
        return chacheDosNiveles;
    }
    
}
