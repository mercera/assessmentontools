/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculation.CountInheritance;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RASINDU
 */
public class ciTesting {
    
    public ciTesting() {
    }
    
    @BeforeClass
    public static void setUpClass() {
                        System.out.println("All tests starting");

    }
    
    @AfterClass
    public static void tearDownClass() {
                        System.out.println("All tests finish");

    }
    
    @Before
    public void setUp() {
                        System.out.println("new test Starting");

    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void checkInheritanceComplxity() {
//        CountInheritance check = new CountInheritance();
//        int complexity = check.getTotal();
//        assertEquals(3, complexity);
    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
