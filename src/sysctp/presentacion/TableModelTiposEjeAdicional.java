/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.presentacion;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sysctp.aplicacion.administracion.administracion_tipos_eje_adicional.ControladorAdministracionTiposEjeAdicional;
import sysctp.aplicacion.administracion.administracion_tipos_eje_adicional.IObservadorAdministracionTiposEjeAdicional;
import sysctp.dominio.inventario.TipoEjeAdicional;

/** 
 *
 * @author james
 */
public class TableModelTiposEjeAdicional extends AbstractTableModel implements IObservadorAdministracionTiposEjeAdicional {

    private List<TipoEjeAdicional> tiposEjeAdicional;
    
    
    public void setControlador(ControladorAdministracionTiposEjeAdicional controlador){
        tiposEjeAdicional = controlador.getTiposEjeAdicionalActuales();
        if (controlador!=null)
            controlador.adicionarObservador(this);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        if (tiposEjeAdicional==null) return 0;
        return tiposEjeAdicional.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Identificador";
            case 1:
                return "Nombre";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (tiposEjeAdicional!=null){
            TipoEjeAdicional tipoEjeAdicional = tiposEjeAdicional.get(rowIndex);
            switch(columnIndex){
                case 0:
                    long id = tipoEjeAdicional.getId();
                    if (id == 0) 
                        return "sin asignar";
                    else
                        return tipoEjeAdicional.getId();
                case 1:
                    return tipoEjeAdicional.getNombre();
            }
        }
        return null;
    }

    @Override
    public void onInsertar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional) {
        if (tiposEjeAdicional!=null){
            int index = tiposEjeAdicional.size();
            tiposEjeAdicional.add(tipoEjeAdicional);
            this.fireTableRowsInserted(index, index);
        }
    }

    @Override
    public void onEliminar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional) {
        if (tiposEjeAdicional!=null){
            int index = tiposEjeAdicional.indexOf(tipoEjeAdicional);
            tiposEjeAdicional.remove(tipoEjeAdicional);
            this.fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public void onModificar(ControladorAdministracionTiposEjeAdicional controlador, TipoEjeAdicional tipoEjeAdicional) {
        if (tiposEjeAdicional!=null){
            int index = tiposEjeAdicional.indexOf(tipoEjeAdicional);
            this.fireTableRowsUpdated(index, index);
        }
    }
    
}
