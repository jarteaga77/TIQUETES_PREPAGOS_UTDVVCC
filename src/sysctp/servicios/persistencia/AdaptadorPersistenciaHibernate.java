
package sysctp.servicios.persistencia;

import java.util.List;
import org.hibernate.Session;

/**
 * Adaptador de persistencia basado en el framework de hibernate
 *
 * @author James Andres Payan Caicedo
 */
public class AdaptadorPersistenciaHibernate implements IAdaptadorPersistencia {

    /**
     * Almacena un objeto persistentemente, en utilizando una sesion de hibernate
     * 
     * @param elemento objeto a ser persistido
     */
    @Override
    public void almacenarElemento(Object elemento) {
        try{
            Session session = FactoriaDeSesionesHibernate.obtenerInstancia().obtenerSesionActual(); //Obtiene la session actual
            session.beginTransaction(); // inicia una nueva transacción
                session.saveOrUpdate(elemento); // Almacena elemento en la BD
            session.getTransaction().commit(); // finaliza la transaccion actual
        }catch(Exception e){
            throw new FallaConexionConBaseDeDatosException(e.getMessage());
        }
    }

    /**
     * Recupera un objeto del almacenamiento persistente, haciendo el ORM con Hibernate
     * 
     * @param clase clase del objeto a recuperar
     * @param id identificador del objeto
     * @return el objeto correpondiente a la clase e identificador dados.
     */
    @Override
    public Object recuperarElemento(Class clase, long id) {
        try{
            Session session = FactoriaDeSesionesHibernate.obtenerInstancia().obtenerSesionActual(); //Obtiene la session actual
            session.beginTransaction(); // inicia una nueva transacción
                List result = session.createQuery("from " + clase.getSimpleName() + " where id = " + id).list();
            session.getTransaction().commit(); // finaliza la transaccion actual
            if (result.size()>0)
                return result.get(0);
            else
                return null;
        }catch(Exception e){
            throw new FallaConexionConBaseDeDatosException("No se logra recuperar el elemento: " + clase.getSimpleName() + ", id = " + id + ".\n\t" + e);
        }
    }

    /**
     * Recupera todas las instancias de objetos, de la clase dada.
     * 
     * @param clase la clase de la cual deben ser todos los objetos a recuperar
     * @return todas las instancias de objetos, de la clase dada.
     */
    @Override
    public List recuperarTodosLosElementos(Class clase) {
        try{
            Session session = FactoriaDeSesionesHibernate.obtenerInstancia().obtenerSesionActual(); //Obtiene la session actual
            session.beginTransaction(); // inicia una nueva transacción
                List result = session.createQuery("from " + clase.getSimpleName()).list(); // Obtiene todos los elementos de la clase dada
            session.getTransaction().commit(); // finaliza la transaccion actual
            return result;
        }catch(Exception e){
            throw new FallaConexionConBaseDeDatosException(e.getMessage());
        }
    }

    /**
     * Elimina un objeto del almacenamiento persistente
     * 
     * @param elemento elemento a ser eliminado
     */
    @Override
    public void eliminarElemento(Object elemento) {
        try{
            Session session = FactoriaDeSesionesHibernate.obtenerInstancia().obtenerSesionActual(); //Obtiene la session actual
            session.beginTransaction(); // inicia una nueva transacción
                session.delete(elemento); // Elimina elemento en la BD
            session.getTransaction().commit(); // finaliza la transaccion actual
        }catch(Exception e){
            throw new FallaConexionConBaseDeDatosException(e.getMessage());
        }
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
        try{
            Session session = FactoriaDeSesionesHibernate.obtenerInstancia().obtenerSesionActual(); //Obtiene la session actual
            session.beginTransaction(); // inicia una nueva transacción
                List result = session.createQuery("from " + clase.getSimpleName() + " where " + atributo + " = '" + valor +"'").list(); // Obtiene todos los elementos de la clase dada
            session.getTransaction().commit(); // finaliza la transaccion actual
            return result;
        }catch(Exception e){
            throw new FallaConexionConBaseDeDatosException(e.getMessage());
        }
    }
    
}
