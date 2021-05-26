/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.Cita;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eliana Julieth
 */
public class OperVisitaIT {
    
    public OperVisitaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of agendar method, of class OperVisita.
     */
    @Test
    public void testAgendar() {
        System.out.println("agendar");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        boolean expResult = false;
        boolean result = instance.agendar(cita);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of eliminarCita method, of class OperVisita.
     */
    @Test
    public void testEliminarCita() {
        System.out.println("eliminarCita");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.eliminarCita(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAgenda method, of class OperVisita.
     */
    @Test
    public void testEliminarAgenda() {
        System.out.println("eliminarAgenda");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        instance.eliminarAgenda(cita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCita method, of class OperVisita.
     */
    @Test
    public void testActualizarCita() {
        System.out.println("actualizarCita");
        Cita dato = null;
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.actualizarCita(dato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaID method, of class OperVisita.
     */
    @Test
    public void testConsultaID() {
        System.out.println("consultaID");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        String expResult = "";
        String result = instance.consultaID(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultar method, of class OperVisita.
     */
    @Test
    public void testConsultar_0args() {
        System.out.println("consultar");
        OperVisita instance = new OperVisita();
        List<Cita> expResult = null;
        List<Cita> result = instance.consultar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultar method, of class OperVisita.
     */
    @Test
    public void testConsultar_int() {
        System.out.println("consultar");
        int IdC = 0;
        OperVisita instance = new OperVisita();
        List<Cita> expResult = null;
        List<Cita> result = instance.consultar(IdC);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaTecnicos method, of class OperVisita.
     */
    @Test
    public void testListaTecnicos() {
        System.out.println("listaTecnicos");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        List expResult = null;
        List result = instance.listaTecnicos(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaHora method, of class OperVisita.
     */
    @Test
    public void testListaHora() {
        System.out.println("listaHora");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        List expResult = null;
        List result = instance.listaHora(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaDia method, of class OperVisita.
     */
    @Test
    public void testListaDia() {
        System.out.println("listaDia");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        List expResult = null;
        List result = instance.listaDia(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarCita method, of class OperVisita.
     */
    @Test
    public void testConsultarCita() {
        System.out.println("consultarCita");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        Cita expResult = null;
        Cita result = instance.consultarCita(cita);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
