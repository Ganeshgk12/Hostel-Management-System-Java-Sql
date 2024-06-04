package hostelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import hostelmanagementsystem.*;
import oracle.jdbc.driver.OracleDriver;


public class ManageRooms extends JFrame implements ActionListener {
    
    private Container c;
    private JLabel title1;
    private JLabel title2;
    private JLabel roomno;
    private JLabel roomno1;
    private JTextField troomno;
    private JTextField troomno1;
    private JLabel activeStatus;
    private ButtonGroup tactiveStatus;
    private ButtonGroup tactiveStatus1;
    private JRadioButton active;
    private JRadioButton inactive;
    private JLabel activeStatus1;
    private JRadioButton active1;
    private JRadioButton inactive1;
    private JButton add;
    private JButton update;
    private JButton delete,view,close;
    
    
    public ManageRooms(){
        c = getContentPane();
        setTitle("Manage Rooms");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setBackground(Color.white);
        setResizable(false);
        c.setLayout(null);
        setBounds(400, 73, 820, 550);
        
        title1 = new JLabel("Add a New Room");
        title1.setFont(new Font("Arial", Font.PLAIN, 30));
        title1.setSize(300, 30);
        title1.setLocation(300, 30);
        c.add(title1);
        
        roomno = new JLabel("Enter New Room Number");
        roomno.setSize(200, 20);
        roomno.setLocation(100, 100);
        c.add(roomno);
        
        troomno = new JTextField();
        troomno.setSize(190, 20);
        troomno.setLocation(250, 100);
        c.add(troomno);
        
        activeStatus = new JLabel("Select Room Status");
        activeStatus.setSize(200, 20);
        activeStatus.setLocation(100, 150);
        c.add(activeStatus);
        
        active = new JRadioButton("active");
        active.setSize(75, 20);
        active.setLocation(250, 150);
        active.setSelected(true);
        c.add(active);
        
        inactive = new JRadioButton("inactive");
        inactive.setSize(75, 20);
        inactive.setLocation(350, 150);
        c.add(inactive);
        
        tactiveStatus = new ButtonGroup();
        tactiveStatus.add(active);
        tactiveStatus.add(inactive);
        
        add = new JButton("Add");
        add.setSize(100, 20);
        add.setLocation(275, 200);
        c.add(add);
        add.addActionListener(this);
        
        title2 = new JLabel("Update or Delete Rooms");
        title2.setFont(new Font("Arial", Font.PLAIN, 30));
        title2.setSize(350, 30);
        title2.setLocation(300, 250);
        c.add(title2);
        
        roomno1 = new JLabel("Enter Room Number");
        roomno1.setSize(200, 20);
        roomno1.setLocation(100, 300);
        c.add(roomno1);
        
        troomno1 = new JTextField();
        troomno1.setSize(190, 20);
        troomno1.setLocation(250, 300);
        c.add(troomno1);
        
        activeStatus1 = new JLabel("Update Room Status");
        activeStatus1.setSize(230, 20);
        activeStatus1.setLocation(100, 350);
        c.add(activeStatus1);
        
        active1 = new JRadioButton("active");
        active1.setSize(75, 20);
        active1.setLocation(250, 350);
        c.add(active1);
        
        inactive1 = new JRadioButton("inactive");
        inactive1.setSize(75, 20);
        inactive1.setLocation(350, 350);
        c.add(inactive1);
        
        tactiveStatus1 = new ButtonGroup();
        tactiveStatus1.add(active1);
        tactiveStatus1.add(inactive1);
        
        update = new JButton("Update");
        update.setSize(100, 20);
        update.setLocation(275, 400);
        c.add(update);
        update.addActionListener(this);
        
        delete = new JButton("Delete");
        delete.setSize(100, 20);
        delete.setLocation(400, 400);
        c.add(delete);
        delete.addActionListener(this);
        
        view = new JButton("View Rooms");
        view.setSize(120, 20);
        view.setLocation(525, 400);
        c.add(view);
        view.addActionListener(this);
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
        
        setUndecorated(true);
        setVisible(true);
        
         
       close.addActionListener(this);
       close.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           setVisible(false);  
    } });
    }
    
    public void actionPerformed(ActionEvent e){
        String activeStatus;
        String roomNo;
        String roomNo1;
        String roomStatus;
        if(e.getSource()== view)
        {
            new ViewRoom().setVisible(true);
            setVisible(false);
        }
        if (e.getSource() == add){
            roomNo = troomno.getText();
            if (validateRoomNo(roomNo)==true){
                
                roomStatus = "unoccupied";
                if (active.isSelected())
                    activeStatus = "active";
                else
                    activeStatus = "inactive";
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver"); 
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    Statement  st = connection.createStatement();
                    String query="insert into room values('" + roomNo + "','" + activeStatus + "','" + roomStatus + "')";
                    st.executeUpdate(query);
                    connection.setAutoCommit(true);
                    connection.close();
                    System.out.println("Success!");
                    JOptionPane.showMessageDialog(null,"The entered room is added successfully!");
                    troomno.setText("");
                }
                catch(Exception i){
                    System.out.println("Error!");
                }    
            
            
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter a proper room number"); 
            }
            
        }
        if (e.getSource() == update){
            roomNo1 = troomno1.getText();
            if (validateRoomNo(roomNo1)==true){
                
                if (active1.isSelected())
                    activeStatus = "active";
                else
                    activeStatus = "inactive";
                
                try
                  {
            
                    Connection connection1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String query1="update room set active_status=? where room_no=?";
                    PreparedStatement pstmt=connection1.prepareStatement(query1);
                    pstmt.setString(2,roomNo1);
                    pstmt.setString(1,activeStatus);
                    pstmt.executeUpdate();
                    connection1.setAutoCommit(true);
                    JOptionPane.showMessageDialog(null,"Updated successfully!");
                    troomno1.setText("");
                  }
                catch(Exception i)
                        {
                          JOptionPane.showMessageDialog(null,"Failed to update!"); 
                        }
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter a proper room number!"); 
            }
            
        }
        if (e.getSource() == delete){
            roomNo = troomno1.getText();
            if (validateRoomNo(roomNo)){
                
                try{ 
                    
                    Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String sql="delete from room where room_no='"+roomNo+"'";
                    PreparedStatement ps=connection.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"The entered room is deleted successfully!");
                        troomno1.setText("");  
                    }
           }
            catch(Exception i)
                        {
                          JOptionPane.showMessageDialog(null,"Failed to delete!"); 
                        }
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter a proper room number"); 
            }
            
        }
        
        
    }
    
    public boolean validateRoomNo(String roomNo){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(roomNo);
        if (m.matches())
            return true;
        return false;
                
    }
    
    public static void main(String[] args) {
       
         new ManageRooms();
         
}
    
}
