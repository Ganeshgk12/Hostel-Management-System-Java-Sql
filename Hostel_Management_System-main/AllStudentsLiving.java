
package hostelmanagementsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AllStudentsLiving {
        String[] columnNames = {"Roll Number","Name","Gender","Father Name","Mother Name","Mobile Number","Parent Mobile","Email","Room Number"};
	JButton close;
    AllStudentsLiving(){
	
	 JFrame f = new JFrame("Students Currently Living");

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
    
               String rollno=new String("");
               String name=new String("");
               String gender=new String("");
               String fathername=new String("");
               String mothername=new String("");     
               String mobile=new String("");
               String parentmobile=new String("");
               String email=new String("");
               String room=new String("");

     
     try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
    	 	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
    	 	Statement st= con.createStatement();
    	 	ResultSet rs = st.executeQuery("select * from new_student where status='Living'");
    	 	while(rs.next()) 
    	 	{
                        rollno=rs.getString("roll_no");
    	 	        name=rs.getString("name");
                        fathername=rs.getString("father");
                        mothername=rs.getString("mother");
                        mobile=rs.getString("mobile");
                        parentmobile=rs.getString("parentmobile");
                        gender=rs.getString("gender");
                        email=rs.getString("email");
                        room=rs.getString("room_no");
        	 

             model.addRow(new Object[]{rollno,name,gender,fathername,mothername,mobile,parentmobile,email,room});
        }

     } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

     }

     
     f.add(scroll);
     f.setUndecorated(true);
     f.setVisible(true);
     f.setBackground(Color.white);
     f.setSize(1050, 350);
     f.setBounds(350, 120, 1000, 550);
     
     
	}
	public static void main(String args[])
	{
		new AllStudentsLiving();
	}
}
