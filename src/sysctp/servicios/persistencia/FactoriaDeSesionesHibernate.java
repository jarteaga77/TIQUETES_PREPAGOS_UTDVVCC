
package sysctp.servicios.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import sysctp.servicios.util.PropiedadesDelSistema;

/**
 * Factoria que encapsula la complejidad de la creacion de sesiones de hibernate.
 * El objetivo de ésta clase dar acceso a las instancias de la actual sesion en hibernate.
 * Se usa el patron singleton para obtener acceso a la unica instancia de la clase.
 *
 * @author James Andres Payan Caicedo
 */
public class FactoriaDeSesionesHibernate {
    
    private SessionFactory factoriaSesionHibernate;
    
    private static FactoriaDeSesionesHibernate instancia;
    
    /**
     * Obtiene la unica instancia de la FactoriaDeSesionesHibernate
     * 
     * @return la unica instancia de la FactoriaDeSesionesHibernate
     * @throws InstantiationException se dispara si hubo algún problema en la creación de la instancia de la Factoría
     */
    public static FactoriaDeSesionesHibernate obtenerInstancia() throws InstantiationException{
        if (instancia == null)
            instancia = new FactoriaDeSesionesHibernate();
        return instancia;
    }
    
    private FactoriaDeSesionesHibernate() throws InstantiationException{
        try{
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            String xmlConfiguracionConexionHibernate = PropiedadesDelSistema.obtenerInscancia().obtenerPropiedad("xmlConfiguracionHibernate");
            cfg = cfg.configure(xmlConfiguracionConexionHibernate);
            factoriaSesionHibernate = cfg.buildSessionFactory();
        }catch(Exception ex){
            throw new InstantiationException("Falla la iniciación de la factoríaDeSesionesHibernate.\n\t" + ex);
        }
    }
    
    /**
     * Obtiene la actual sesion de hibernate
     * 
     * @return la actual sesion de hibernate
     */
    public Session obtenerSesionActual(){
        return factoriaSesionHibernate.getCurrentSession();
    }
    
}
