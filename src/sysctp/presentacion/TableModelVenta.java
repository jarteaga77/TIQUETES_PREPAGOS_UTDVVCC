/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sysctp.presentacion;

import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sysctp.dominio.ventas.IObservadorVenta;
import sysctp.dominio.ventas.LineaDeVenta;
import sysctp.dominio.ventas.Pago;
import sysctp.dominio.ventas.Venta;

/**
 *
 * @author UTDVVCC
 */
public class TableModelVenta extends AbstractTableModel implements IObservadorVenta {
        List<LineaDeVenta> items=null;

        /**
         * 
         * @param venta
         */
        public void setVenta (Venta venta){
            items = venta.getLineas();
            venta.addObservador(this);
            super.fireTableDataChanged();
        }
        
        public int getRowCount() {
            if (items==null) return 0;
            return items.size();
        }

        public int getColumnCount() {
            return 7;

        }

        @Override
        public String getColumnName(int column){
            switch (column) {
                case 0:
                    return "No";
                case 1:
                    return "Cantidad";
                case 2:
                    return "Descripcion";
                case 3:
                    return "Serial Inicial";
                case 4:
                    return "Serial Final";
                case 5:
                    return "Valor Unitario";
                case 6:
                    return "Total Parcial";
            }
            return null;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setPerMill('.');
            java.text.DecimalFormat formato = new java.text.DecimalFormat("'$' #,##0.00",dfs);
            
            LineaDeVenta item = items.get(rowIndex);
            
            switch (columnIndex) {
               case 0:     
                   return String.valueOf(items.indexOf(item)+1);
               case 1:
                   return String.valueOf(item.getCantidadTiquetesPrepago());
               case 2:                                
                   return item.getEspecificacion();
               case 3:                                 
                   return String.valueOf(item.getSerialInicial());
               case 4:
                   return String.valueOf(item.getSerialFinal());
               case 5:
                   return formato.format(item.obtenerValorUnitario());
               case 6:
                   return formato.format(item.obtenerTotalParcial());
            }
            return null;
        }

    public void onAddLineaVenta(Venta fuente, LineaDeVenta linea) {
        int posicion = items.indexOf(linea);
        super.fireTableRowsInserted(posicion, posicion);
    }

    /**
     * 
     * @param fuente
     * @param posicion
     */
    public void onDeleteLineaVenta(Venta fuente, int posicion) {
        super.fireTableRowsDeleted(posicion, posicion);
    }

    /**
     * 
     * @param fuente
     * @param posicion1
     * @param posicion2
     */
    public void onCambioPosicionLineaVenta(Venta fuente, int posicion1, int posicion2) {
        super.fireTableRowsUpdated(posicion1, posicion1);
        super.fireTableRowsUpdated(posicion2, posicion2);
    }

    @Override
    public void onAdicionarPago(Venta fuente, Pago pago) {
        
    }

    @Override
    public void onEliminarPago(Venta fuente, int posicion) {
        
    }

}
