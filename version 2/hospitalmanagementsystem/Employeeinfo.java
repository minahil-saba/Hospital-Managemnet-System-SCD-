/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Employeeinfo extends javax.swing.JFrame {

    /**
     * Creates new form Employeeinfo
     */
    public Employeeinfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EMP_INFO = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Information");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        EMP_INFO.setAutoCreateRowSorter(true);
        EMP_INFO.setForeground(new java.awt.Color(0, 102, 102));
        EMP_INFO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Age", "Phone_no", "Gmail", "Salary", "CNIC_No", "Occupation"
            }
        ));
        EMP_INFO.setGridColor(new java.awt.Color(255, 255, 255));
        EMP_INFO.setRowSorter(null);
        EMP_INFO.setSelectionBackground(new java.awt.Color(255, 51, 153));
        jScrollPane1.setViewportView(EMP_INFO);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 690, 270));

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 100, -1));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
        // Step 1: Establish Database Connection
        java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            return;
        }

        // Step 2: Define the query to fetch employee data
        String query = "SELECT * FROM EMP_INFO";
        java.sql.PreparedStatement pstmt = con.prepareStatement(query);
        java.sql.ResultSet rs = pstmt.executeQuery();

        // Step 3: Create the DefaultTableModel with columns (Name, Age, etc.)
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Phone No");
        model.addColumn("Gmail");
        model.addColumn("Salary");
        model.addColumn("CNIC No");
        model.addColumn("Occupation");

        // Step 4: Loop through the result set and add rows to the model
        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("Age"),
                    rs.getString("Phone_no"),
                    rs.getString("Gmail"),
                    rs.getString("Salary"),
                    rs.getString("CNIC_No"),
                    rs.getString("Occupation")
            });
        }

        // Step 5: Set the table model to the JTable
        EMP_INFO.setModel(model); // Make sure "EMP_INFO" is your JTable
        // Close resources
        pstmt.close();
      

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
        // Step 1: Establish Database Connection
        java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            return;
        }

        // Step 2: Define the query to fetch employee data
        String searchQuery = search.getText(); // Assuming 'searchField' is the name of your text field
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name to search!");
            return;
        }

        // Step 3: Define the query to fetch employee data based on name (like a partial match)
        String query = "SELECT * FROM EMP_INFO WHERE Name LIKE ?";
        
        java.sql.PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, "%" + searchQuery + "%"); // Use % for partial matching

        // Step 4: Execute the query
        java.sql.ResultSet rs = pstmt.executeQuery();

        // Step 5: Create the DefaultTableModel with columns (Name, Age, etc.)
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Phone No");
        model.addColumn("Gmail");
        model.addColumn("Salary");
        model.addColumn("CNIC No");
        model.addColumn("Occupation");

        // Step 6: Check if data is found and populate the table
        boolean dataFound = false;
        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getString("Name"),
                    rs.getString("Age"),
                    rs.getString("Phone_no"),
                    rs.getString("Gmail"),
                    rs.getString("Salary"),
                    rs.getString("CNIC_No"),
                    rs.getString("Occupation")
            });
            dataFound = true;
        }

        // Step 7: Set the model to the JTable
        EMP_INFO.setModel(model); // Make sure EMP_INFO is your JTable name

        // Step 8: Show message if no data found
        if (!dataFound) {
            JOptionPane.showMessageDialog(this, "No records found!");
        }

        // Step 9: Close resources
        pstmt.close();
       

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Phone No");
        model.addColumn("Gmail");
        model.addColumn("Salary");
        model.addColumn("CNIC No");
        model.addColumn("Occupation");
        model.setRowCount(0);
        model.setRowCount(5);
         EMP_INFO.setModel(model);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   Admin a=new Admin();
   a.setVisible(true);
   a.pack();
   a.setLocationRelativeTo(null);
   this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employeeinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EMP_INFO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
