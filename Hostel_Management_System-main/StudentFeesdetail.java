
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

public class StudentFeesdetail extends JFrame{
    String[] columnNames = {"Roll Number","Month","Amount"};
    JButton close;
    public StudentFeesdetail(){
        

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     setLayout(new BorderLayout());
     
     DefaultTableModel model = new DefaultTableModel();

     model.setColumnIdentifiers(columnNames);

     JTable t = new JTable();

     t.setModel(model);

     JScrollPane scroll = new JScrollPane(t);
     
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(768,0,50,20);
        add(close);
        close.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           setVisible(false);  
    }});

    //Getting Details
     String rollno;
     String month;
     String amount;
     
     
     
     try {
         
                Class.forName("oracle.jdbc.driver.OracleDriver");
    	 	Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
    	 	Statement st= connection.createStatement();
    	 	ResultSet rs = st.executeQuery("select * from studentfee");
    	 	while(rs.next()) 
    	 	{
    	 	 rollno = rs.getString("roll_no");
                 month = rs.getString("month");
                 amount = rs.getString("amount");
        	 
        	 

             model.addRow(new Object[]{rollno,month,amount});
        }

     } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

     }
     add(scroll);
     setUndecorated(true);
     setVisible(true);
     setBackground(Color.white);
     setBounds(400, 120, 820, 550);
     
     
	}
	public static void main(String args[])
	{
		new StudentFeesdetail();
	}
	
}
