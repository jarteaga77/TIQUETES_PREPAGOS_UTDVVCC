/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysctp.aplicacion.administracion.administracion_tipos_eje_adicional;

import java.io.IOException;
import java.util.Date;
import sysctp.dominio.Empresa;
import sysctp.servicios.util.PropiedadesDelSistema;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class ControladorAdministracionTiposEjeAdicionalTest {
    
    private static ControladorAdministracionTiposEjeAdicional instance;
    
    public ControladorAdministracionTiposEjeAdicionalTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            PropiedadesDelSistema.obtenerInscancia().cargarPropiedades();
            Empresa empresa = new Empresa();
            instance = new ControladorAdministracionTiposEjeAdicional(empresa);
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
        assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalPreparado.getInstance());
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
        
        
        
        List result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
        if(!result.isEmpty()){
            instance.iniciarAdministracion();
            instance.iniciarModificacion();
            assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalEditando.getInstance());
            int index = instance.getTiposEjeAdicionalActuales().size()-1;
            instance.seleccionarTipoEjeAdicional(index); // Toma la ultima categoria insertada
//            instance.getCategoriasActuales().get(index).setId(3000);
            instance.asignarNombre(prueba2);
            instance.confirmarOperacion();
            instance.finalizarAdministracion();
            result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
            assertTrue(result.isEmpty());
            result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba2);
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
        
        List result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
        if(!result.isEmpty()){
            instance.iniciarAdministracion();
            instance.iniciarEliminacion();
            assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalEliminando.getInstance());
            instance.seleccionarTipoEjeAdicional(instance.getTiposEjeAdicionalActuales().size()-1); // Toma la ultima categoria insertada
            instance.confirmarOperacion();
            instance.finalizarAdministracion();

            result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
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
        assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalInsertando.getInstance());
        String prueba = "nuevo_prueba:" + new Date();
        instance.asignarNombre(prueba);
        instance.confirmarOperacion();
        instance.finalizarAdministracion();
        
        assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalInactivo.getInstance());
        
        List result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
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
        assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalPreparado.getInstance());
        instance.finalizarAdministracion();
        
        assertEquals(instance.getEstado(),EstadoAdministracionTiposEjeAdicionalInactivo.getInstance());
        
        List result = instance.getCatalogoTiposEjeAdicional().buscarElementos("nombre", prueba);
        assertTrue(result.isEmpty());
    }
}
