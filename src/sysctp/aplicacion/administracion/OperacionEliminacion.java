/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion;

import sysctp.servicios.gestion_persistencia.Registro;

/**
 *
 * @author james
 */
public class OperacionEliminacion extends OperacionAdministracion{

    @Override
    public void ejecutar(Registro registro) {
        registro.eliminarElemento(this.getElementoObjetivo());
    }
    
}
