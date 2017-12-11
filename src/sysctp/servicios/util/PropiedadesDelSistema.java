
package sysctp.servicios.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Clase que encapsula el acceso a las propiedades del sistema.
 * Usa el patron singleton para ser accedida a su unica instancia, globalmente
 *
 * @author James Andres Payan Caicedo
 */
public class PropiedadesDelSistema {

    private static PropiedadesDelSistema instancia;

    private Properties misPropiedades;

    /**
     * Obtiene la instancia unica de la clase PropiedadesDelSistema
     * 
     * @return la instancia unica de la clase PropiedadesDelSistema
     */
    public static PropiedadesDelSistema obtenerInscancia(){
        if (instancia==null){
            instancia=new PropiedadesDelSistema();
        }
        return instancia;
    }

    // constructo privado de la clase propiedades del sistema
    private PropiedadesDelSistema(){
        misPropiedades = new Properties();
    }

    /**
     * Carga las propiedades del sistema desde el archivo system.properties
     * 
     * @throws java.io.IOException se dispara si ocurre algún problema de Entrada/Salida en la operación
     */
    public void cargarPropiedades() throws IOException {
        misPropiedades.load(new java.io.FileInputStream("system.properties"));
    }
    
    /**
     * Obtiene el valor de la propiedad solicitada
     * 
     * @param propiedad nombre de la propiedad solicitada
     * @return
     */
    public String obtenerPropiedad(String propiedad){
        return misPropiedades.getProperty(propiedad);
    }
    
    /**
     * asigna el valor a la propiedad indicada
     * 
     * @param propiedad el nombre la propiedad indicada
     * @param valor el valor a ser asignado a dicha propiedad
     * @throws java.io.IOException se dispara si ocurre algún problema de Entrada/Salida en la operación
     */
    public void asignarPropiedad(String propiedad, String valor) throws IOException{
        misPropiedades.setProperty(propiedad,valor);
        salvarPropiedades();
    }

    /**
     * Guarda las propiedades del sistema en el archivo system.properties
     * 
     * @throws java.io.IOException se dispara si ocurre algún problema de Entrada/Salida en la operación
     */
    public void salvarPropiedades() throws java.io.IOException {
            misPropiedades.store(new java.io.FileOutputStream("system.properties"),"Propiedades del Sistema Control De Tiquetes Prepago");
    }

    

    
        
}
