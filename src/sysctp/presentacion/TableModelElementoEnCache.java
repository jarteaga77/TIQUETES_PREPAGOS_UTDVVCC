/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.presentacion;

import javax.swing.table.AbstractTableModel;
import sysctp.dominio.inventario.EspecificacionTiquetePrepago;
import sysctp.servicios.gestion_persistencia.CacheElementosAbstractaLRU;
import sysctp.servicios.gestion_persistencia.ElementoEnCache;
import sysctp.servicios.gestion_persistencia.IObservadorCacheLRU;

/**
 *
 * @author james
 */
public class TableModelElementoEnCache extends AbstractTableModel implements IObservadorCacheLRU{
    
    private CacheElementosAbstractaLRU cache;

    @Override
    public int getRowCount() {
        if (cache == null) return 0;
        ElementoEnCache elementos = cache.getMasRecientementeUsado();
        if (elementos == null) return 0;
        int rows = 1;
        ElementoEnCache siguiente = elementos.getSiguiente();
        while(siguiente !=null){
            rows+=1;
            siguiente = siguiente.getSiguiente();
        }
        return rows;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Fecha Creacion Cache";
            case 1:
                return "Descripcion";
            case 2:
                return "Tiene Anterior";
            case 3:
                return "Tiene Siguiente";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ElementoEnCache elementos = cache.getMasRecientementeUsado();
        if (elementos == null) return null;
        ElementoEnCache solicitado = null;
        if (rowIndex == 0)
            solicitado = elementos;
        else{
            solicitado = elementos.getSiguiente();
            int row = 1;
            while(row != rowIndex){
                row++;
                solicitado = solicitado.getSiguiente();
            }
        }
        EspecificacionTiquetePrepago esp = (EspecificacionTiquetePrepago) solicitado.getElemento();
        switch (columnIndex) {
            case 0:
                return solicitado.getFechaCreacionEnCache();
            case 1:
                return esp.toString();
            case 2:
                return solicitado.getAnterior() != null;
            case 3:
                return solicitado.getSiguiente() != null;
        }
        return null;
    }

    @Override
    public void onAdcionarElemento(CacheElementosAbstractaLRU cacheLRU) {
        super.fireTableDataChanged();
    }

    @Override
    public void onEliminarElemento(CacheElementosAbstractaLRU cacheLRU) {
        super.fireTableDataChanged();
    }

    @Override
    public void onConsultarElemento(CacheElementosAbstractaLRU cacheLRU) {
        super.fireTableDataChanged();
    }

    @Override
    public void onVaciarCahe(CacheElementosAbstractaLRU cacheLRU) {
        super.fireTableDataChanged();
    }

    /**
     * @return the cache
     */
    public CacheElementosAbstractaLRU getCache() {
        return cache;
    }

    /**
     * @param cache the cache to set
     */
    public void setCache(CacheElementosAbstractaLRU cache) {
        this.cache = cache;
        if (cache != null)
            cache.adicionarObservador(this);
        else
            super.fireTableDataChanged();
    }
    
}
