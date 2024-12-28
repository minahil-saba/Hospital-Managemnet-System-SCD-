/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hospitalmanagementsystem;

import com.sun.jdi.connect.spi.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
   
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Get a single instance of the database connection
        connection = (Connection) DatabaseConnection.getInstance().getConnection();
        
        // Insert test data for validation
        String insertSQL = "INSERT INTO Signup (email, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertSQL)) {
            insertStmt.setString(1, "testuser@example.com");
            insertStmt.setString(2, "password123");
            insertStmt.setString(3, "Patient");
            insertStmt.executeUpdate();
        }
    }
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
     * Test of main method, of class Login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Login.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
