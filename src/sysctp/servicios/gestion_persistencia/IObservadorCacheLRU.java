/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.servicios.gestion_persistencia;

/**
 *
 * @author james
 */
public interface IObservadorCacheLRU {
    public void onAdcionarElemento(CacheElementosAbstractaLRU cacheLRU);
    public void onEliminarElemento(CacheElementosAbstractaLRU cacheLRU);
    public void onConsultarElemento(CacheElementosAbstractaLRU cacheLRU);
    public void onVaciarCahe(CacheElementosAbstractaLRU cacheLRU);
}
