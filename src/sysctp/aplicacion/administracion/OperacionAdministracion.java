
package sysctp.aplicacion.administracion;

import sysctp.servicios.gestion_persistencia.IElementoDeRegistro;
import sysctp.servicios.gestion_persistencia.Registro;

/**
 *
 * @author james
 */
public abstract class OperacionAdministracion {
    private IElementoDeRegistro elementoObjetivo;

    /**
     * @return the elementoObjetivo
     */
    public IElementoDeRegistro getElementoObjetivo() {
        return elementoObjetivo;
    }

    /**
     * @param elementoObjetivo the elementoObjetivo to set
     */
    public void setElementoObjetivo(IElementoDeRegistro elementoObjetivo) {
        this.elementoObjetivo = elementoObjetivo;
    }
    
    public abstract void ejecutar(Registro registro);
}
