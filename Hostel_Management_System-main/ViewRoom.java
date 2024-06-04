
package hostelmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewRoom extends JFrame{
    
    String[] columnNames = {"Room Number","Active Status","Room Status"};
    JButton close;
    public ViewRoom(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
     
     //Table
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
     String roomNo;
     String activeStatus;
     String roomStatus;

     
     
     try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
    	 	Statement st= connection.createStatement();
    	 	ResultSet rs = st.executeQuery("select * from room");
    	 	while(rs.next()) 
    	 	{
    	 	 roomNo = rs.getString("room_no");
                 activeStatus = rs.getString("active_status");
                 roomStatus = rs.getString("room_status");
        	 
        	 

             model.addRow(new Object[]{roomNo,activeStatus,roomStatus});
        }

     } catch (Exception ex) {

         JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

     }
     add(scroll);
     setUndecorated(true);
     setBackground(Color.white);
     setVisible(true);
    
     setBounds(400, 120, 820, 550);
     
     
	}
	public static void main(String args[])
	{
		new ViewRoom();
	}
	
}