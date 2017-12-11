
package sysctp.servicios.gestion_persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Implementación de ICache, que representa una caché que administrá
 * los elementos de caché bajo un algoritmo LRU. 
 * 
 * La clase es abstracta, ya que no indica como se ni donde se mantienen los
 * elementos de caché exactamente. Por esta razon no se puede instaciar directamente;
 * se debe utilizar alguna de la subclases que implemente el resto de la funcionalidad.
 * 
 * Lo anterior nos da la libertad de reutilizar código e implementar diferentes tipos de caché
 * con algoritmo LRU, por ejemeplo: una caché que almacene los elementos en memoria, o tal vez
 * una que almacene los elementos en disco duro, ya sean serializados en xml o de algún otro modo, quizas
 * implementando una base de datos local.
 *
 * @author James Andrés Payan Caicedo
 */
public abstract class CacheElementosAbstractaLRU implements ICache {
    
    private int maximaCantidadElementos; // maxíma cantidad de elementos permitidos para almacenar en caché
    private List observadores = new ArrayList();
                       
    /**
     * Obtiene un elemento almacenado en la cache. Metodo abstracto que se debe definir en las subclases
     * 
     * @param id el identificador del elemento de cache que se desea recuperar
     * @return el elemento de cache solicitado
     */
    protected abstract ElementoEnCache obtener(long id);
    
    /**
     * Adiciona un elemento al almacen de la caché. Metodo abstracto que se debe implementar en las subclases.
     * 
     * @param enCache el elemento a ser almacenado en caché
     */
    protected abstract void adicionar(ElementoEnCache enCache);
    
    /**
     * Elimina un elemento del almacen de la caché. El metodo es abstracto, y se debe implementar en las subclases
     * 
     * @param enCache
     */
    protected abstract void eliminar(ElementoEnCache enCache);
    
    
    /**
     * Obtiene la cantidad de elementos almacenados en la caché. El metodo es abstracto y debe ser implementado en las subclases
     * 
     * @return la cantidad de elementos almacenados actualmente en la caché
     */
    public abstract int obtenerCantidadElementos();
    
    /**
     * Implementa el metodo buscarElemento de la interfaz ICache.
     * Aquí se usa como Metodo Plantilla, por que depende de los
     * metodos implementados en las subclases.
     * En está implementación básicamente se busca mantener la estrategia LRU
     * para la eliminación de elementos de caché.
     * 
     * @param id el identificador de elemento en caché solicitado
     * @return el elemento en caché correspondiente al identificador dado
     */
    public ElementoEnCache buscarElemento(long id){
        ElementoEnCache enCache = this.obtener(id); // obtiene el elemento del almacén de la caché
        if(enCache == null){ // si el elemento no extiste, retorna null
            return null;
        }else{ // Si el elemento existe en cache
            if (enCache != this.getMasRecientementeUsado()){ // y no es el elemento mas recientemente usado
                
                // *************** //
                ElementoEnCache previo = enCache.getAnterior();
                ElementoEnCache siguiente = enCache.getSiguiente();
                if (previo != null)
                    previo.setSiguiente(siguiente);
                if (siguiente != null)
                    siguiente.setAnterior(previo);
                enCache.setAnterior(null);
                ElementoEnCache masRecientementeUsado = this.getMasRecientementeUsado();
                masRecientementeUsado.setAnterior(enCache);
                enCache.setSiguiente(masRecientementeUsado);
                this.setMasRecientementeUsado(enCache);
                if(this.getMenosRecientementeUsado() == enCache && previo != null)
                    this.setMenosRecientementeUsado(previo);
                this.publicarConsulta();
                // *************** // Se marca como el elemento más recientemente usado!!
            }
            return enCache; // se retorna el elemento encontrado en el almacen de cache.
        }
    }
    
    /**
     * Implementa el metodo adicionarElemento de la interfaz ICache.
     * Aquí se usa como Metodo Plantilla, por que depende de los
     * metodos implementados en las subclases.
     * En está implementación básicamente se busca mantener la estrategia LRU
     * para la eliminación de elementos de caché.
     * 
     * @param enCache el elemento que se va adicionar a la caché
     */
    public void adicionarElemento(IElementoDeRegistro elemento){
        ElementoEnCache objeto = this.obtener(elemento.getId()); // se verifica si el objeto ya se tiene en el almacen de caché
        if (objeto == null){
            ElementoEnCache enCache = new ElementoEnCache(elemento);
            enCache.setFechaCreacionEnCache(new Date());
            // si el objeto no está en el almacen de cache
            if (this.obtenerCantidadElementos() == 0){ // y la caché no tiene ningun otro elemento
                // entonces se marca el objeto que se va a ingresar
                this.setMenosRecientementeUsado(enCache); // como el menos recientemente usado
                this.setMasRecientementeUsado(enCache); // y como el mas reciemente usado
                // ya que es el unico objeto
            }else {
                // si hay mas objetos en la caché
                if(this.obtenerCantidadElementos()>= this.getMaximaCantidadElementos()){ // y la cantidad de elementos actualmente es igual o sobrepasa la maxima cantidad de elementos en caché permitidas
                    //********************//
                    ElementoEnCache menosRecientementoUsado = this.getMenosRecientementeUsado();
                    ElementoEnCache anterior = menosRecientementoUsado.getAnterior();
                    menosRecientementoUsado.setAnterior(null);
                    anterior.setSiguiente(null);
                    this.setMenosRecientementeUsado(anterior);
                    this.eliminar(menosRecientementoUsado);
                    //*******************// Entonces se elimina el elementos menos recietemente usado en caché
                }
                // finalmente el objeto que se va a adicionar se marca como el mas reciemente usado
                ElementoEnCache masRecientementeUsado = this.getMasRecientementeUsado();
                masRecientementeUsado.setAnterior(enCache);
                enCache.setSiguiente(masRecientementeUsado);
                enCache.setAnterior(null);
                this.setMasRecientementeUsado(enCache);
            }
            // en cualquiera de los casos anteriores, si el objeto no esta en caché, simplemente se adiciona al almacen de elementos en caché.
            this.adicionar(enCache);
            this.publicarAdicion();
        } // el objeto ya está en el almacen de caché, entonces no se hace ninguna modificación
    }
    
    /**
     * Implementa el metodo eliminarElemento de la interfaz ICache.
     * Aquí se usa como Metodo Plantilla, por que depende de los
     * metodos implementados en las subclases.
     * En está implementación básicamente se busca mantener la estrategia LRU
     * para la eliminación de elementos de caché.
     * El objetivo de este metodo es eliminar explicitamente un elemento de caché
     * 
     * @param enCache el elemento a eleminar
     */
    public void eliminarElemento(IElementoDeRegistro enCache){
        ElementoEnCache enCache_ = this.obtener(enCache.getId()); //obtiene el elemento que se encuentra en caché
        if(enCache_ != null){ // si está el elemento en la caché
            
            // se obtiene la referencia al siguiente y al anterior objeto referenciado de la cola LRU
            ElementoEnCache anterior = enCache_.getAnterior(); 
            ElementoEnCache siguiente = enCache_.getSiguiente();
            
            if (enCache_.equals(this.getMasRecientementeUsado())) // si el objeto que se va eliminar es el objeto más recientemento usado
                this.setMasRecientementeUsado(siguiente); // entoces se marca como más reciemente usado el siguiente elemento de la cola LRU
            
            if (enCache_.equals(this.getMenosRecientementeUsado())) // si el objeto que se va eliminar es el objeto menos recientemente usado
                this.setMenosRecientementeUsado(anterior); // entonces se marca como menos recientemente usado el anterior elemento de la cola LRU
            
            if (anterior != null) // si la referencia al objeto anterior es diferente de nula
                anterior.setSiguiente(siguiente); // entonces se le indica al objeto anterior que el objeto siguiente es la referencia al elemento siguiente del elemento que se va a eliminar
            
            if (siguiente != null) // si la referencia al elemento siguiente es diferente de nula
                siguiente.setAnterior(anterior); // entonces se le indica al objeto siguiente que el objeto anterior es la referencia al elemento anterior del elemento que se va a eliminar
            
            this.eliminar(enCache_); // finalmente se elimina el elemento del almacen de la caché
            this.publicarEleminacion();
        } // si no está el elemento a eliminar, simplemente no se hace nada
    }

    /**
     * Obtiene una referencia al elemento menos recientemente usado
     * 
     * @return el elemento menosRecientementeUsado
     */
    public abstract ElementoEnCache getMenosRecientementeUsado(); 

    /**
     * Marca un elemento como el menos recientemente usado
     * 
     * @param menosRecientementeUsado el elemento a ser asignado como el menos recientemente usado
     */
    public abstract void setMenosRecientementeUsado(ElementoEnCache menosRecientementeUsado);

    /**
     * Obtiene el elemento mas recientementeo usado
     * 
     * @return el elemento masRecientementeUsado
     */
    public abstract ElementoEnCache getMasRecientementeUsado();

    /**
     * Marca un elemento como el mas usado recientemente
     * 
     * @param masRecientementeUsado el elemento a ser asignado como el mas recientemente usado
     */
    public abstract void setMasRecientementeUsado(ElementoEnCache masRecientementeUsado);

    /**
     * Obtiene la máxima cantidad de elementos que puede tener la caché
     * 
     * @return la maximaCantidadElementos que puede tener
     */
    public int getMaximaCantidadElementos() {
        return maximaCantidadElementos;
    }

    /**
     * Asigna a la caché la maxima cantidad elementos que puede mantener
     * 
     * @param maximaCantidadElementos la maximaCantidadElementos que puede tener la cache
     */
    public void setMaximaCantidadElementos(int maximaCantidadElementos) {
        this.maximaCantidadElementos = maximaCantidadElementos;
    }
    
    /**
     * Los siguiente metodos, son para dar soporte al patron Observador (GOF)
     */
    
    protected void publicarConsulta(){
        for (Iterator i= observadores.iterator(); i.hasNext();){
            IObservadorCacheLRU observador = (IObservadorCacheLRU) i.next();
            observador.onConsultarElemento(this);
        }
    }
    protected void publicarAdicion(){
        for (Iterator i= observadores.iterator(); i.hasNext();){
            IObservadorCacheLRU observador = (IObservadorCacheLRU) i.next();
            observador.onAdcionarElemento(this);
        }
    }
    protected void publicarEleminacion(){
        for (Iterator i= observadores.iterator(); i.hasNext();){
            IObservadorCacheLRU observador = (IObservadorCacheLRU) i.next();
            observador.onEliminarElemento(this);
        }
    }
    protected void publicarVarciar(){
        for (Iterator i= observadores.iterator(); i.hasNext();){
            IObservadorCacheLRU observador = (IObservadorCacheLRU) i.next();
            observador.onVaciarCahe(this);
        }
    }
    
    public void adicionarObservador(IObservadorCacheLRU observador){
        observadores.add(observador);
    }
    
    public void eliminarObservador(IObservadorCacheLRU observador){
        observadores.remove(observador);
    }
    
}
