
package sysctp.servicios.gestion_persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import sysctp.servicios.persistencia.FallaConexionConBaseDeDatosException;
import sysctp.servicios.persistencia.IAdaptadorPersistencia;
import sysctp.servicios.util.PropiedadesDelSistema;


/**
 * Clase que se encarga de dar soporte de persistencia. Utiliza el patron Cache Manager
 * para la administración de caché.
 *
 * @author james
 */
public class Registro {
    
    private ICache cache;
    private ArrayList<IObservadorRegistro> misObservadores=new ArrayList();
    private IAdaptadorPersistencia persistencia;
    private Class classDeElementos;
    private long maximaAntiguedadElementos;
        
    /**
     * Contructor de la clase
     * 
     * @param classDeElementos clase de los elementos que va a persistir
     */
    public Registro(Class classDeElementos){ //metodo constructor
        this.classDeElementos=classDeElementos;
        FactoriaDeServicios instancia = FactoriaDeServicios.obtenerInstancia();
        persistencia = instancia.obtenerAdaptadorPersistencia();
        String nombre = this.getClassDeElementos().getSimpleName();
        try{
            long maxAntiguedad = Long.parseLong(PropiedadesDelSistema.obtenerInscancia().obtenerPropiedad(nombre + ".cache.max_antiguedad"));
            maximaAntiguedadElementos=maxAntiguedad;
        }catch(NumberFormatException err){
            maximaAntiguedadElementos = 0;
        }
        
        
        cache = instancia.obtenerCache(nombre);
    }
    
    /**
     * Carga impacientemente todos los elementos en caché
     * 
     */
    public void cargarImpacientementeLosElementos(){
        this.obtenerTodosLosElementos();
    }
    
    /**
     * registra persistentemente un elemento. Tambien lo adiciona en cache.
     * 
     * @param elemento elemento a ser registrado
     */
    public void registrarElemento(IElementoDeRegistro elemento){
        Class clase = this.getClassDeElementos();
        if (clase.isInstance(elemento)){// verifico que el elemento que se trata de adicionar sea del tipo de aquellos que mantiene este registro
            persistencia.almacenarElemento(elemento);
            if(elemento.getId()>0){// si el elemento no tiene un ID definido, no puede ser almacenado en caché
                // actualmente la caché no tiene soporte para elementos sin ID
                cache.adicionarElemento(elemento);
            }
                this.publicarAdicionElemento(elemento);

        }else{
            throw new ElementoDeRegistroInvalidoException("El elemento que se trato de almacenar no es un(a): "+ clase.getSimpleName() +".");
        }
    }
    
    /**
     * Elimina un elemento de los elementos persistentes y de la cache
     * 
     * @param elemento a ser eliminado
     */
    public void eliminarElemento(IElementoDeRegistro elemento){
        
        Class clase = this.getClassDeElementos();
        if (clase.isInstance(elemento)){ // verifico que el elemento que se trata de eliminar sea del tipo de aquellos que mantiene este registro
            persistencia.eliminarElemento(elemento);
            cache.eliminarElemento(elemento); // aseguro que el elemento no quede en cache
            this.publicarEliminacionElemento(elemento);
        }else{
            throw new ElementoDeRegistroInvalidoException("El elemento que se tra-to de almacenar no es un(a): "+ clase.getSimpleName() +".");
        }
        
    }
    
    /**
     * Obtiene todos los elementos almacenados persistentemente
     *  
     * @return todos los elementos almacenados persistentemente
     */
    public List obtenerTodosLosElementos(){
        Class clase = this.getClassDeElementos();

        // si no hay conexión con la BD, se dispara la excepción FallaConexionConBaseDeDatosException.
        // no manejamos ésta exception aquí, para permitir que capas mas altas decidan que hacer.
        List elementos = persistencia.recuperarTodosLosElementos(clase); 

        //las siguientes lineas solo se ejecutan si se logra conectar con la BD
        for(Iterator i = elementos.iterator();i.hasNext();){ // se adiciona los elementos recuperados en caché
            cache.adicionarElemento((IElementoDeRegistro)i.next()); // se adicionan todos los elementos recuperados en cache
        }

        return elementos;
    }
    
    /**
     * Obtiene un elemento dado un identificador. El elemento se recupera si es posible
     * de la cache. Si el objeto recuperado es mas antiguo de lo permitido, se procede a obtener el elemento
     * de la persistencia, y a la vez se actualiza el de cache.
     * 
     * @param id identificador del objeto solicitado
     * @return el elemento correspondiente al identificador dado.
     */
    public IElementoDeRegistro obtenerElemento(long id){
        IElementoDeRegistro elemento = null;
        ElementoEnCache enCache = cache.buscarElemento(id);
        
        long antiguedad = 0;
        if (enCache!=null)
            antiguedad = new Date().getTime() - enCache.getFechaCreacionEnCache().getTime();
        if(enCache==null || antiguedad >= this.maximaAntiguedadElementos){
            try{
                Class clase = this.getClassDeElementos();
                elemento = (IElementoDeRegistro) persistencia.recuperarElemento(clase, id); // aqui se puede generar la excepcion de falla de conexion con la BD
                
                // las lineas que siguen solo se ejecutan si hay comunicacion con la BD
                if (enCache != null){ // si el elemento ya existe en la cache
                    cache.eliminarElemento(enCache.getElemento()); // Elimino el elemento que hay en cache para luego insertar el elemento actualizado
                }
                if (elemento != null){ // si el elemento existe en la base de datos
                    cache.adicionarElemento(elemento); // adiciono en cache elemento traido de la BD
                }
            }catch(FallaConexionConBaseDeDatosException ex){
                if (enCache != null){
                    System.err.println("Falla en el acceso a la BD; Se trabaja con objeto local viejo.\n\t" + ex);
                    elemento = enCache.getElemento();
                }else{
                    throw ex;
                }
            }
        }else{
            elemento = enCache.getElemento();
        }
        return elemento;
    }
    
    public List buscarElementos(String atributo, Object valor){
        Class clase = this.getClassDeElementos();
        
        // si no hay conexión con la BD, se dispara la excepción FallaConexionConBaseDeDatosException.
        // no manejamos ésta exception aquí, para permitir que capas mas altas decidan que hacer.
        List elementos = persistencia.recuperarElementos(clase, atributo, valor);
        
        //las siguientes lineas solo se ejecutan si se logra conectar con la BD
        for(Iterator i = elementos.iterator();i.hasNext();){ // se adiciona los elementos recuperados en caché
            cache.adicionarElemento((IElementoDeRegistro)i.next()); // se adicionan todos los elementos recuperados en cache
        }
        
        return elementos;
    }
    
    /**
     * public la adicion de un elemento
     * 
     */
    private void publicarAdicionElemento(IElementoDeRegistro elemento){
        for(Iterator<IObservadorRegistro> i = misObservadores.iterator(); i.hasNext();){
            i.next().onAdicionElemento(this, elemento);
        }
    }
    
    /*
     * publica la eliminación de un elemento
     */
    private void publicarEliminacionElemento(IElementoDeRegistro elemento){
        for(Iterator<IObservadorRegistro> i = misObservadores.iterator(); i.hasNext();){
            i.next().onEliminacionElemento(this, elemento);
        }
    }
    
    /**
     * adiciona un observador del registro
     * 
     * @param observador elemento que requiere ser notificado de los eventos del registro
     */
    public void adicionarObservador(IObservadorRegistro observador){
        misObservadores.add(observador);
    }
    
    /**
     * Elimina un observador del registro
     * 
     * @param observador objeto que se requiere eliminar de los observadores
     */
    public void eliminarObservador(IObservadorRegistro observador){
        misObservadores.remove(observador);
    }

    /**
     * Obtiene la cache de elementos
     * 
     * @return la cache, que es una implementación de ICache
     */
    public ICache getCache() {
        return cache;
    }

    /**
     * Setter de la cache
     * 
     * @param cache la implementación de ICache a ser utilizada
     */
    public void setCache(ICache cache) {
        this.cache = cache;
    }

    /**
     * Getter de misObservadores, objetos que son notificados de los cambios ocurridos
     * en el registro
     * 
     * @return los observadores del registro
     */
    public ArrayList<IObservadorRegistro> getMisObservadores() {
        return misObservadores;
    }

    /**
     * Asigna una lista de observadores
     * 
     * @param misObservadores lista de observadores de registro a ser asignada.
     */
    public void setMisObservadores(ArrayList<IObservadorRegistro> misObservadores) {
        this.misObservadores = misObservadores;
    }

    /**
     * Getter del adaptador de persistencia
     * 
     * @return el adaptador de persistencia
     */
    public IAdaptadorPersistencia getPersistencia() {
        return persistencia;
    }

    /**
     * Setter del adaptador persistencia
     * 
     * @param persistencia el adaptador de persistencia a ser asignado
     */
    public void setPersistencia(IAdaptadorPersistencia persistencia) {
        this.persistencia = persistencia;
    }

    /**
     * Obtiene la clase de elementos que mantiene el registro
     * 
     * @return la clase de elementos
     */
    public final Class getClassDeElementos() {
        return classDeElementos;
    }

    /**
     * Asigna la clase de elementos que mantiene el registro
     * 
     * @param classDeElementos la clase de elementos a aser asignada
     */
    public void setClassDeElementos(Class classDeElementos) {
        this.classDeElementos = classDeElementos;
    }



    /**
     * Obtiene la maxima cantidad de tiempo valida, para tener un objeto en caché.
     * Este tiempo está dado en milisegundos.
     * 
     * @return the maximaAntiguedadElementos
     */
    public long getMaximaAntiguedadElementos() {
        return maximaAntiguedadElementos;
    }

    /**
     * Asigna la maxima cantida de tiempo valida, para tener un objeto en caché.
     * Este tiempo está dado en milisegundos.
     * 
     * @param maximaAntiguedadElementos la maximaAntiguedadElementos a ser asignada
     */
    public void setMaximaAntiguedadElementos(long maximaAntiguedadElementos) {
        this.maximaAntiguedadElementos = maximaAntiguedadElementos;
    }
    
}
