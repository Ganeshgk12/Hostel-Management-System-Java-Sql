/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostelmanagementsystem;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmployeeDatabase {
    private static Connection connection;
     private static Connection connection1;
     private static Connection connection2;
   
    public static Connection connection(JavaBean user){
       
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "insert into employee values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(1,user.getEmpid());
            pst.setString(2,user.getName());
            pst.setString(3,user.getFathername());
            pst.setString(4,user.getMothername());
            pst.setString(5,user.getMobile());
            pst.setString(6,user.getEmail());
            pst.setString(9,user.getStatus());
            pst.setString(10,user.getGender());
            pst.setString(7,user.getAadhar());
            pst.setString(8,user.getDesignation());
            pst.executeUpdate();
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Employee added successfully");
        }
        catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"error in uploading details");
        }
        return connection;
    }   
    
    
    public static Connection connection1(JavaBean user){
        
        try{Class.forName("oracle.jdbc.driver.OracleDriver"); 
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "update employee set name=?,father=?,mother=?,mobile=?,email=?,status=?,gender=?,aadhar=?,designation=? where employee_id=?";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(10,user.getEmpid());
            pst.setString(1,user.getName());
            pst.setString(2,user.getFathername());
            pst.setString(3,user.getMothername());
            pst.setString(4,user.getMobile());
            pst.setString(5,user.getEmail());
            pst.setString(6,user.getStatus());
            pst.setString(7,user.getGender());
            pst.setString(8,user.getAadhar());
            pst.setString(9,user.getDesignation());
            pst.executeUpdate();
            
                    
                   
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Employee updated successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error in uploading details");
        }
        return connection;
    }  
    
     public static Connection connection2(JavaBean user){
        
        try{Class.forName("oracle.jdbc.driver.OracleDriver"); 
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "update employee set status=? where employee_id=?";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(2,user.getEmpid());
            pst.setString(1,user.getStatus() );
            pst.executeUpdate();
              
           
                    
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Employee Deleted successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error in deleting Student details");
        }
        return connection;
    }   
}
