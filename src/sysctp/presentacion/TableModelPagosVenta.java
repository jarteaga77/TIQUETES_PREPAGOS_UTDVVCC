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
public class TableModelPagosVenta extends AbstractTableModel implements IObservadorVenta {
        List<Pago> items=null;

        /**
         * 
         * @param venta
         */
        public void setVenta (Venta venta){
            items = venta.getPagos();
            venta.addObservador(this);
            super.fireTableDataChanged();
        }
        
        public int getRowCount() {
            if (items==null) return 0;
            return items.size();
        }

        public int getColumnCount() {
            return 4;

        }

        @Override
        public String getColumnName(int column){
            switch (column) {
                case 0:
                    return "Forma Pago";
                case 1:
                    return "Valor";
                case 2:
                    return "Cuenta";
                case 3:
                    return "Serial Trans";
            }
            return null;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setPerMill('.');
            java.text.DecimalFormat formato = new java.text.DecimalFormat("'$' #,##0.00",dfs);
            
            Pago item = items.get(rowIndex);
            
            if(item != null){
                switch (columnIndex) {
                   case 0:     
                       return item.getFormaDePago();
                   case 1:
                       return formato.format(item.getMontoPagado());  
                   case 2:                                
                       return item.getCuenta();
                   case 3:                                 
                       return item.getSerialTransaccion();
                }
            }
            
            return null;
        }

    public void onAddLineaVenta(Venta fuente, LineaDeVenta linea) {
        
    }

    /**
     * 
     * @param fuente
     * @param posicion
     */
    public void onDeleteLineaVenta(Venta fuente, int posicion) {
        
    }

    /**
     * 
     * @param fuente
     * @param posicion1
     * @param posicion2
     */
    public void onCambioPosicionLineaVenta(Venta fuente, int posicion1, int posicion2) {
        
    }

    /**
     * 
     * @param fuente
     * @param pago 
     */
    @Override
    public void onAdicionarPago(Venta fuente, Pago pago) {
        int posicion = items.indexOf(pago);
        super.fireTableRowsInserted(posicion, posicion);
    }

    @Override
    public void onEliminarPago(Venta fuente, int posicion) {
        super.fireTableRowsDeleted(posicion, posicion);
    }

}
