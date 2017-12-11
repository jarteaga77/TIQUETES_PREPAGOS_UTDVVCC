/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.dominio.inventario;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 *
 * @author james
 */
public class CatalogoTiposEjeAdicional  extends Registro{
    
    public CatalogoTiposEjeAdicional(){
        super(TipoEjeAdicional.class);
    }
    
    public TipoEjeAdicional obtenerTipoEjeAdicional(long id){
        return (TipoEjeAdicional)super.obtenerElemento(id);
    }
    
}
