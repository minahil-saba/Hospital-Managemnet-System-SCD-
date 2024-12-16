/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hospitalmanagementsystem;

import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Lenovo
 */
public class SignUpTest {
      private SignUp signupPage;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleField;
    private JLabel ulabel;
    private JLabel elabel;
    private JLabel plabel;
      private Connection connection;
    public SignUpTest() {
    }
    
     @Before
    public void setUp() {
        // Initialize Signup page and its components
   signupPage = new SignUp();

    // Access components via getters
    usernameField = signupPage.getEditUsername();
    emailField = signupPage.getEmail();
    passwordField = signupPage.getEditPassword();
    roleField = signupPage.getRole();
    ulabel = signupPage.getUlabel();
    elabel = signupPage.getElabel();
    plabel = signupPage.getPlabel();
    }
//   @Before
//    public void setUp() throws SQLException {
//        // Get a connection to the test database
//        connection = (Connection) DatabaseConnection.getInstance().getConnection();
//
//        // Create the Signup table for testing
//        String createTableSQL = "CREATE TABLE IF NOT EXISTS Signup (" +
//                "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                "username VARCHAR(25), " +
//                "email VARCHAR(255), " +
//                "password VARCHAR(255), " +
//                "role VARCHAR(50), " +
//                "signup_date DATE)";
//        connection.createStatement().executeUpdate(createTableSQL);
//    }
//    
//    @After
//    public void tearDown() throws SQLException {
//        // Clean up the database after tests
//        String dropTableSQL = "DROP TABLE IF EXISTS Signup";
//        connection.createStatement().executeUpdate(dropTableSQL);
//
//        if (connection != null && !connection.isClosed()) {
//            connection.close();
//        }
//    }
    
    
    
   
    /**
     * Test of main method, of class SignUp.
     */
     @Test
  
    public void testEmptyUsername() {
        // Set fields using NetBeans-generated accessors
        signupPage.getEditUsername().setText("");
        signupPage.getEmail().setText("test@example.com");
        signupPage.getEditPassword().setText("Password1!");

      signupPage.triggerSignupAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Signup"));


        assertEquals("<html><b style='color:red;'>Username must be between 3 and 25 characters.</b></html>", signupPage.getUlabel().getText());
    }
@Test
    public void testWeakPassword() {
        signupPage.getEditUsername().setText("validUser");
        signupPage.getEmail().setText("test@example.com");
        signupPage.getEditPassword().setText("password");

signupPage.triggerSignupAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Signup"));


        assertEquals("<html><b style='color:red;'>Password must contain at least one uppercase letter.</b></html>", signupPage.getPlabel().getText());
    }
//        @Test
//    public void testValidSignup() {
//        signupPage.getEditUsername().setText("validUser");
//        signupPage.getEmail().setText("test@example.com");
//        signupPage.getEditPassword().setText("Password1!");
//        signupPage.getRole().setSelectedIndex(0);
//
//       Mockito.when(mockDbConnection.getConnection()).thenReturn(Mockito.mock(java.sql.Connection.class));
//
//        signupPage.triggerSignupAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Signup"));
//
//        assertEquals("", signupPage.getUlabel().getText());
//        assertEquals("", signupPage.getElabel().getText());
//        assertEquals("", signupPage.getPlabel().getText());
//        assertEquals("", signupPage.getEditUsername().getText());
//        assertEquals("", signupPage.getEmail().getText());
//        assertEquals("", signupPage.getEditPassword().getText());
//        assertEquals(0, signupPage.getRole().getSelectedIndex());
//    }


    }