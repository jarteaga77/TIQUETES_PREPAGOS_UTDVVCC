/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.presentacion;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sysctp.aplicacion.administracion.administracion_categorias.ControladorAdministracionCategorias;
import sysctp.aplicacion.administracion.administracion_categorias.IObservadorAdministracionCategorias;
import sysctp.dominio.inventario.Categoria;

/**
 *
 * @author james
 */
public class TableModelCategorias extends AbstractTableModel implements IObservadorAdministracionCategorias {

    private List<Categoria> categorias;
    
    
    public void setControlador(ControladorAdministracionCategorias controlador){
        categorias = controlador.getCategoriasActuales();
        if (controlador!=null)
            controlador.adicionarObservador(this);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        if (categorias==null) return 0;
        return categorias.size();
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
        if (categorias!=null){
            Categoria categoria = categorias.get(rowIndex);
            switch(columnIndex){
                case 0:
                    long id = categoria.getId();
                    if (id == 0) 
                        return "sin asignar";
                    else
                        return categoria.getId();
                case 1:
                    return categoria.getNombre();
            }
        }
        return null;
    }

    @Override
    public void onInsertar(ControladorAdministracionCategorias controlado, Categoria categoria) {
        if (categorias!=null){
            int index = categorias.size();
            categorias.add(categoria);
            this.fireTableRowsInserted(index, index);
        }
    }

    @Override
    public void onEliminar(ControladorAdministracionCategorias controlado, Categoria categoria) {
        if (categorias!=null){
            int index = categorias.indexOf(categoria);
            categorias.remove(categoria);
            this.fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public void onModificar(ControladorAdministracionCategorias controlado, Categoria categoria) {
        if (categorias!=null){
            int index = categorias.indexOf(categoria);
            this.fireTableRowsUpdated(index, index);
        }
    }
    
}
