
package hostelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeLeft {
     String[] columnNames = {"Employee ID","Name","Gender","Father Name","Mother Name","Mobile Number","Aadhaar Number","Email","Designation"};
     JButton close;
    EmployeeLeft(){
	
	 JFrame f = new JFrame("Students Currently Leaved");

     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     f.setLayout(new BorderLayout());
     
     //Table
     JTable t = new JTable();
     DefaultTableModel model = new DefaultTableModel();
     model=(DefaultTableModel)t.getModel();
     model.setColumnIdentifiers(columnNames);
     t.getColumnModel().getColumn(7).setPreferredWidth(150);

     

     t.setModel(model);

     JScrollPane scroll = new JScrollPane(t);
     
        close = new JButton("Close");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(885,507,100,30);
        f.add(close);
        close.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           f.setVisible(false);  
    }});
   

    //Getting Details
               String empid;
               String name;
               String gender;
               String fathername;
               String mothername;     
               String mobile;
               String aadhar;
               String email;
               String designation;
               
               String status="Left";
                
     
     try {
    	 	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
    	 	String pql="select * from employee where status=?"; /*roll_no,name,father,mother,mobile,email,room_no,status,gender,parentmobile*/
                    PreparedStatement ps=con.prepareStatement(pql);
                    ps.setString(1,status);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next())
                    {
                        empid=rs.getString("employee_id");
                        name=rs.getString("name");
                        fathername=rs.getString("father");
                        mothername=rs.getString("mother");
                        mobile=rs.getString("mobile");
                        aadhar=rs.getString("aadhar");
                        gender=rs.getString("gender");
                        email=rs.getString("email");
                        designation=rs.getString("designation");
                    

             model.addRow(new Object[]{empid,name,gender,fathername,mothername,mobile,aadhar,email,designation});
        }

     } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

     }

     f.add(scroll);
     f.setUndecorated(true);
     f.setVisible(true);
     f.setBackground(Color.white);
     f.setSize(1050, 350);
    // f.setBounds(525, 175, 1000, 300);
     
     
    
     f.setBounds(350, 120, 1000, 550);
     
	}
	public static void main(String args[])
	{
		new EmployeeLeft();
	}
}
