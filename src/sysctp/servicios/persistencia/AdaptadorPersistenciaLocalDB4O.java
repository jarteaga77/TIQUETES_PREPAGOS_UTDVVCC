
package sysctp.servicios.persistencia;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;
import java.util.List;

/**
 * Adaptador de persistencia local con DB4O.
 * Se encargar de almacenar elementos, localmente en disco duro.
 *
 * @author James Andres Payan Caicedo
 */
public class AdaptadorPersistenciaLocalDB4O implements IAdaptadorPersistencia {
    
    private String nombre;
    private ObjectContainer database;
    
    /**
     * Constructor de la clase. Recibe un nombre como parametro, para 
     * dar así mismo el nombre del archivo local de la base de datos.
     * Hace algunas otras configuraciones adicionales
     * 
     * @param nombre nombre del almacenamiento persistente local
     */
    public AdaptadorPersistenciaLocalDB4O(String nombre){
        this.nombre = nombre;
        EmbeddedConfiguration conf = Db4oEmbedded.newConfiguration(); // crea una configuracion de DB4O
//        conf.common().objectClass(ElementoEnCache.class).cascadeOnDelete(true); // Cuando se elimina un objeto, se elimina todos aquellos a los que hace referencia
//        conf.common().objectClass(TareaPendiente.class).cascadeOnDelete(true);
        database=Db4oEmbedded.openFile(conf,nombre + ".db4o"); // abre o crea el archivo de base de datos
        database.ext().configure().updateDepth(Integer.MAX_VALUE); // indica que utilice la maxima profundida posible de actualizacion recursiva
        database.ext().configure().activationDepth(Integer.MAX_VALUE); // indica que se utilice el maximo nivel de activación
    }

    /**
     * Almacena un objeto persistentemente
     * 
     * @param elemento objeto a ser persistido
     */
    @Override
    public void almacenarElemento(Object elemento) {
        database.store(elemento);
    }

    /**
     * Recupera un objeto del almacenamiento persistente
     * 
     * @param clase clase del objeto a recuperar
     * @param id identificador del objeto
     * @return el objeto correpondiente a la clase e identificador dados.
     */
    @Override
    public Object recuperarElemento(Class clase, long id) {
        Query query = database.query();
        query.constrain(clase);
        query.descend("id").constrain(id);
        ObjectSet result = query.execute();
        if (result.hasNext())
            return result.next();
        else return null;
    }

    /**
     * Recupera todas las instancias de objetos, de la clase dada.
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @return todas las instancias de objetos, de la clase dada.
     */
    @Override
    public List recuperarTodosLosElementos(Class clase) {
        Query query = database.query();
        query.constrain(clase);
        ObjectSet result = query.execute();
        return result;
    }

    /**
     * Elimina un objeto del almacenamiento persistente
     * 
     * @param elemento elemento a ser eliminado
     */
    @Override
    public void eliminarElemento(Object elemento) {
        database.delete(elemento);
    }

    /**
     * Getter del nombre
     * 
     * @return el nombre de la BD
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     * 
     * @param nombre el nombre de BD a ser asignado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Recupera todas las instancias de objetos de la clase dada,
     * cuyo atributo "atributo" es igual al valor dado.
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @param atributo el atributo señalado a ser inspeccionado
     * @param valor el valor que debe tener el atributo inspeccionado
     * @return todas las instancias de objetos de la clase dada, cuyo atributo "atributo" es igual al valor dado.
     */
    @Override
    public List recuperarElementos(Class clase, String atributo, Object valor) {
        Query query = database.query();
        query.constrain(clase);
        query.descend(atributo).constrain(valor);
        ObjectSet result = query.execute();
        return result;
    }
    
}
