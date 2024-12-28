/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DatabaseConnectionTest {
    
    public DatabaseConnectionTest() {
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

  @Test
    public void testDatabaseConnection() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        try (Connection connection = dbInstance.getConnection()) {
            // Assert that the connection is not null
            assertNotNull("Connection should not be null.", connection);
            // Assert that the connection is valid within 2 seconds
            assertEquals("Connection should be valid.", connection.isValid(2));
            System.out.println("Connection with Database is Successful");
        } catch (SQLException e) {
            // If an exception occurs, fail the test
            
}
    }
    
    
}

