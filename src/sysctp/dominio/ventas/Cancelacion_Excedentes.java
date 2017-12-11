
package sysctp.dominio.ventas;



/**
 *
 * @author jarteaga
 */
public class Cancelacion_Excedentes 

{
    private long recibo_caja;
    private long idActaCambio;
    private int id_formPago;
    private int ctaBan;
    private long pa_monto;

    public long getRecibo_caja() {
        return recibo_caja;
    }

    public void setRecibo_caja(long recibo_caja) {
        this.recibo_caja = recibo_caja;
    }

    public long getIdActaCambio() {
        return idActaCambio;
    }

    public void setIdActaCambio(long idActaCambio) {
        this.idActaCambio = idActaCambio;
    }

    public int getId_formPago() {
        return id_formPago;
    }

    public void setId_formPago(int id_formPago) {
        this.id_formPago = id_formPago;
    }

    public int getCtaBan() {
        return ctaBan;
    }

    public void setCtaBan(int ctaBan) {
        this.ctaBan = ctaBan;
    }

    public long getPa_monto() {
        return pa_monto;
    }

    public void setPa_monto(long pa_monto) {
        this.pa_monto = pa_monto;
    }
    
    
//    public void registroCancelacionExcedente(Cancelacion_Excedentes canExce)
//    { 
//        try
//        {
// 
//        ResultSet obj=nueva.executeQuery("SELECT ven_recibo_caja FROM ventas.venta WHERE ven_recibo_caja="+canExce.getIdCanceExce()+"");
//        ResultSet obj2=nueva.executeQuery("SELECT numero_recibo FROM ventas.anulacion_recibo_caja WHERE numero_recibo="+canExce.getIdCanceExce()+"");
//        ResultSet obj3=nueva.executeQuery("SELECT id_can_exce FROM ventas.cancelacion_excedentes WHERE id_can_exce="+canExce.getIdCanceExce()+"");
//        
//        if(obj.next()==true)
//        {
//            JOptionPane.showMessageDialog(null,"El recibo de caja se ha utilizado en una Venta.!");
//        }else
//            if(obj2.next()==true)
//            {
//              JOptionPane.showMessageDialog(null,"El recibo de caja se ha anulado con anterioridad.!");
//            }
//            else 
//                if(obj3.next()==true)
//                {
//                  JOptionPane.showMessageDialog(null,"El recibo de caja se ha utilizado en la cancelación de excedentes.!");
//
//                }
//                    else
//                {
//                    nueva.executeUpdateQuery("INSERT INTO ventas.cancelacion_excedentes (id_can_exce,id_actaCambio,id_fp,cban_id,pa_monto)VALUES("+canExce.getIdCanceExce()+", "+canExce.getIdActaCambio()+","+canExce.getId_formPago()+", "+canExce.getCtaBan()+","+canExce.getPa_monto()+")");
//                    JOptionPane.showMessageDialog(null,"Se registro con exito!");
//                    nueva.desconectar();
//                }
//
//        }catch(SQLException e)
//        {
//            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    
}
