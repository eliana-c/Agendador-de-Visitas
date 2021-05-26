/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
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
public class ConexionesIT {
    
    public ConexionesIT() {
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
     * Test of conectarse method, of class Conexiones.
     */
    @Test
    public void testConectarse() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        assertNotNull(cActiva);
    }

    /**
     * Test of desconectarse method, of class Conexiones.
     */
    @Test
    public void testDesconectarse() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        c.desconectarse(cActiva);
        assertNotNull(c);
    }

}
