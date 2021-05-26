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

    /**
     * Test of agendar method, of class OperVisita.
     */
    @Test
    public void testAgendarNull() {
        System.out.println("agendar");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        boolean expResult = false;
        boolean result = instance.agendar(cita);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAgendarVacio() {
        System.out.println("agendar");
        Cita cita = new Cita();
        cita.setInconveniente("");
        cita.setIdT("");
        cita.setDia("");
        cita.setHora("");
        cita.setCliente("");
        cita.setTelefono(0);
        cita.setDireccion("");
        cita.setVivienda("");
        OperVisita instance = new OperVisita();
        boolean expResult = false;
        boolean result = instance.agendar(cita);
        assertEquals(expResult, result);
    }

   
    @Test
    public void testEliminarCita() {
        System.out.println("eliminarCita");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.eliminarCita(cita);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEliminarCitaId0() {
        System.out.println("eliminarCita");
        Cita cita = new Cita();
        cita.setIdC(0);
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.eliminarCita(cita);
        assertEquals(expResult, result);
    }

   
    @Test
    public void testActualizarCita() {
        System.out.println("actualizarCita");
        Cita dato = null;
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.actualizarCita(dato);
        assertEquals(expResult, result);
    }
    @Test
    public void testActualizarCitaVacio() {
        System.out.println("actualizarCita");
        Cita dato = new Cita();
        dato.setInconveniente("");
        dato.setIdT("");
        dato.setDia("");
        dato.setHora("");
        dato.setCliente("");
        dato.setTelefono(0);
        dato.setDireccion("");
        dato.setVivienda("");
        OperVisita instance = new OperVisita();
        int expResult = 0;
        int result = instance.actualizarCita(dato);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsultaID() {
        System.out.println("consultaID");
        Cita cita = null;
        OperVisita instance = new OperVisita();
        String expResult = "";
        String result = instance.consultaID(cita);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultar method, of class OperVisita.
     */
    @Test
    public void testConsultarTablaVacia() {
        System.out.println("consultar");
        OperVisita instance = new OperVisita();
        int expResult = 0;
        List<Cita> result = instance.consultar();
        assertEquals(expResult, result.size());
    }


    /**
     * Test of consultar method, of class OperVisita.
     */
    @Test
    public void testConsultar_int() {
        System.out.println("consultar");
        int IdC = 0;
        OperVisita instance = new OperVisita();
        Cita expResult = new Cita();
        expResult = null;
        Cita result = instance.consultar(IdC);
        assertEquals(expResult, result);
        
    }

  
}
