
package hostelmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class StudentDatabase {
     private static Connection connection;
     private static Connection connection1;
     private static Connection connection2;
   
    public static Connection connection(JavaBean admin){
        String status="occupied";
        try{
             
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "insert into new_student values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(1,admin.getRollno());
            pst.setString(2,admin.getEmail());
            pst.setString(3,admin.getName());
            pst.setString(4,admin.getFathername());
            pst.setString(5,admin.getMothername());
            pst.setString(6,admin.getMobile());
            pst.setString(7,admin.getRoom());
            pst.setString(8,admin.getStatus());
            pst.setString(9,admin.getGender());
            pst.setString(10,admin.getParentmobile());
            pst.executeUpdate();
            
                    String query1="update room set room_status=? where room_no=?";
                    PreparedStatement pstmt=connection.prepareStatement(query1);
                    pstmt.setString(2,admin.getRoom());
                    pstmt.setString(1,status);
                    pstmt.executeUpdate();
                   
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Student added successfully");
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"error in uploading details");
        }
        return connection;
    }   
    
    
    public static Connection connection1(JavaBean admin){
        String status="occupied";
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "update new_student set name=?,father=?,mother=?,mobile=?,email=?,room_no=?,status=?,gender=?,parentmobile=? where roll_no=?";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(10,admin.getRollno());
            pst.setString(1,admin.getName());
            pst.setString(2,admin.getFathername());
            pst.setString(3,admin.getMothername());
            pst.setString(4,admin.getMobile());
            pst.setString(5,admin.getEmail());
            pst.setString(6,admin.getRoom());
            pst.setString(7,admin.getStatus());
            pst.setString(8,admin.getGender());
            pst.setString(9,admin.getParentmobile());
            pst.executeUpdate();
            
                    String query2="update room set room_status=? where room_no=?";
                    PreparedStatement pstmt=connection.prepareStatement(query2);
                    pstmt.setString(2,admin.getRoom());
                    pstmt.setString(1,status);
                    pstmt.executeUpdate();
                   
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Student updated successfully");
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"error in uploading details");
        }
        return connection;
    }  
    
     public static Connection connection2(JavaBean admin){
        String status="unoccupied";
        String stat="Vacated";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "update new_student set status=? where roll_no=?";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(2,admin.getRollno());
            pst.setString(1, stat);
            pst.executeUpdate();
              
            String query2="update room set room_status=? where room_no=?";
                    PreparedStatement pstmt=connection.prepareStatement(query2);
                    pstmt.setString(2,admin.getRoom());
                    pstmt.setString(1,status);
                    pstmt.executeUpdate();
                    
            connection.setAutoCommit(true);
            connection.close();
            System.out.println("Success!");
            JOptionPane.showMessageDialog(null,"Student Deleted successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error in deleting Student details");
        }
        return connection;
    }   
}
