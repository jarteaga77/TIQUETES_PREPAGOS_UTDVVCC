
package sysctp.aplicacion.administracion.administracion_categorias;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import sysctp.dominio.Empresa;
import sysctp.servicios.util.PropiedadesDelSistema;

/**
 *
 * @author James Andres Payan Caicedo
 */
public class ControladorAdministracionCategoriasTest {
    
    private static ControladorAdministracionCategorias instance;
    
    public ControladorAdministracionCategoriasTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            PropiedadesDelSistema.obtenerInscancia().cargarPropiedades();
            Empresa empresa = new Empresa();
            instance = new ControladorAdministracionCategorias(empresa);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of iniciarAdministracion method, of class ControladorAdministracionCategorias.
     */
    @Test
    public void testIniciarAdministracion() {
        System.out.println("iniciarAdministracion");
        instance.iniciarAdministracion();
        assertEquals(instance.getEstado(),EstadoAdministracionCategoriasPreparado.getInstance());
        instance.finalizarAdministracion();
    }

    /**
     * Test of iniciarModificacion method, of class ControladorAdministracionCategorias.
     */
    @Test
    public void testIniciarModificacion() {
        System.out.println("iniciarModificacion");
        
        instance.iniciarAdministracion();
        instance.iniciarInsercion();
        String prueba = "modificacion_viejo_prueba:" + new Date();
        String prueba2 = "modificacion_prueba:" + new Date();
        instance.asignarNombre(prueba);
        instance.confirmarOperacion();
        instance.finalizarAdministracion();
        
        
        
        List result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
        if(!result.isEmpty()){
            instance.iniciarAdministracion();
            instance.iniciarModificacion();
            assertEquals(instance.getEstado(),EstadoAdministracionCategoriasEditando.getInstance());
            int index = instance.getCategoriasActuales().size()-1;
            instance.seleccionarCategoria(index); // Toma la ultima categoria insertada
//            instance.getCategoriasActuales().get(index).setId(3000);
            instance.asignarNombre(prueba2);
            instance.confirmarOperacion();
            instance.finalizarAdministracion();
            result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
            assertTrue(result.isEmpty());
            result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba2);
            assertTrue(result.size()==1);
        }else{
            fail("No se logra insertar el objeto a ser modificado");
        }
    }

    /**
     * Test of iniciarEliminacion method, of class ControladorAdministracionCategorias.
     */
    @Test
    public void testIniciarEliminacion() {
        System.out.println("iniciarEliminacion");
        
        instance.iniciarAdministracion();
        instance.iniciarInsercion();
        String prueba = "eliminacion_prueba:" + new Date();
        instance.asignarNombre(prueba);
        instance.confirmarOperacion();
        instance.finalizarAdministracion();
        
        List result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
        if(!result.isEmpty()){
            instance.iniciarAdministracion();
            instance.iniciarEliminacion();
            assertEquals(instance.getEstado(),EstadoAdministracionCategoriasEliminando.getInstance());
            instance.seleccionarCategoria(instance.getCategoriasActuales().size()-1); // Toma la ultima categoria insertada
            instance.confirmarOperacion();
            instance.finalizarAdministracion();

            result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
            assertTrue(result.isEmpty());
        }else{
            fail("No se logra insertar el objeto a ser eliminado");
        }
    }

    /**
     * Test of iniciarInsercion method, of class ControladorAdministracionCategorias.
     */
    @Test
    
    public void testIniciarInsercion() {
        System.out.println("iniciarInsercion");
        
        instance.iniciarAdministracion();
        instance.iniciarInsercion();
        assertEquals(instance.getEstado(),EstadoAdministracionCategoriasInsertando.getInstance());
        String prueba = "nuevo_prueba:" + new Date();
        instance.asignarNombre(prueba);
        instance.confirmarOperacion();
        instance.finalizarAdministracion();
        
        assertEquals(instance.getEstado(),EstadoAdministracionCategoriasInactivo.getInstance());
        
        List result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
        assertTrue(result.size()==1);
    }

    /**
     * Test of cancelarOperacion method, of class ControladorAdministracionCategorias.
     */
    @Test
    public void testCancelarOperacion() {
        System.out.println("cancelarOperacion");
        
        instance.iniciarAdministracion();
        instance.iniciarInsercion();
        String prueba = "cancelar_prueba:" + new Date();
        instance.asignarNombre(prueba);
        instance.cancelarOperacion();
        assertEquals(instance.getEstado(),EstadoAdministracionCategoriasPreparado.getInstance());
        instance.finalizarAdministracion();
        
        assertEquals(instance.getEstado(),EstadoAdministracionCategoriasInactivo.getInstance());
        
        List result = instance.getCatalogoCategorias().buscarElementos("nombre", prueba);
        assertTrue(result.isEmpty());
    }

}
