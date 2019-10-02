/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculation.CheckComplexity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class ComplexityTests {
    
    public ComplexityTests() {
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
    
    @Test
    public void testarithmatic() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.arithmatic("+ - * / % ++ --");
        assertEquals(7,complexity);
    }
    
    @Test
    public void testrelational() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.relational("== != > < >= <= ");
        assertEquals(6,complexity);
    }
    
    @Test
    public void testlogical() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.logical("&& || ! ");
        assertEquals(3,complexity);
    }
    
    @Test
    public void testbitwise() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.bitwise("| ^ ~ << >> >>> <<< ");
        assertEquals(7,complexity);
    }
    
    @Test
    public void testmiscellanous() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.miscellanous(", -> . ::" );
        assertEquals(4,complexity);
    }
    
     @Test
    public void testassignment() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.assignment("+= -= *= /= = >>>= |= &= %= <<= >>= ^=" );
        assertEquals(12,complexity);
    }
    
     @Test
    public void testkeywords() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.keywords("void, double, int, float, string, printf, println, cout, cin, ‘if’, ‘for’, ‘while’, ‘do-while’, ‘switch’, ‘case’,'long'");
        assertEquals(15,complexity);
    }
    
//    @Test
//    public void testdoubleqoutes() throws FileNotFoundException, IOException {
//        CheckComplexity check = new CheckComplexity();
//        BufferedReader reader;
//         reader = new BufferedReader(new FileReader(
//                             "/Users/User/Desktop/3rd year 2nd sem/Software Project Mangement/project/doubleqoutes.txt"));
//         String line = reader.readLine();
//        int complexity = check.doubleqoutes(line);
//        assertEquals(3,complexity);
//    }
    
      @Test
    public void testnumeric() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.numeric("dasd51651sda121");
        assertEquals(8,complexity);
    }
    
    @Test
    public void ndtts() {
        CheckComplexity check = new CheckComplexity();
        int complexity = check.ndttskeywords("new delete throw throws");
        assertEquals(8,complexity);
    }
    
    @After
    public void tearDown() {
        System.out.println("test finished");
    }

}
