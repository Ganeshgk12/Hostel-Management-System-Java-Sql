package hostelmanagementsystem;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.regex.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicSliderUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class EmployeeSalary extends JFrame implements ActionListener {
    Container d;
    private JLabel roll_no;
    private JTextField troll_no;
    private JLabel name;
    private JTextField tname;
    private JLabel mobile;
    private JTextField tmobile;
    private JLabel email;
    private JTextField temail;
    private JLabel Designation;
    private JTextField tDesignation;
    private JLabel lmonth;
    private JComboBox month;
    private JButton search,close,clear,save;
    private String months[]
        = { "January", "Jebruary", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December" };
    private JLabel amount;
    private JTextField tamount;
    EmployeeSalary()
    {
        d=getContentPane();
        
        
        roll_no=new JLabel("EMPLOYEE ID");
        roll_no.setBounds(160,60 ,200,100);
        roll_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(roll_no);
        
        troll_no = new JTextField();
        troll_no.setBounds(350,93,180,25);  //300
        troll_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(troll_no);
        
        name=new JLabel("NAME");
        name.setBounds(160,100 ,200,100); //55
        name.setFont(new Font("Arial", Font.BOLD, 17));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(350,133,300,25);  //330
        tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tname);
        tname.setEditable(false);
         
        mobile=new JLabel("MOBILE NO");
        mobile.setBounds(160,140 ,200,100);
        mobile.setFont(new Font("Arial", Font.BOLD, 17));
        add(mobile);
        
        
        tmobile = new JTextField();
        tmobile.setBounds(350,173,300,25);  //300
        tmobile.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tmobile);
        tmobile.setEditable(false);
        
        email=new JLabel("EMAIL");
        email.setBounds(160,180 ,200,100);
        email.setFont(new Font("Arial", Font.BOLD, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(350,213,300,25);  //300
        temail.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temail);
        temail.setEditable(false);
        
        Designation=new JLabel("DESIGNATION");
        Designation.setBounds(160,220 ,200,100);
        Designation.setFont(new Font("Arial", Font.BOLD, 17));
        add(Designation);
        
        tDesignation = new JTextField();
        tDesignation.setBounds(350,253,200,25);  //300
        tDesignation.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tDesignation);
        tDesignation.setEditable(false);
        
        lmonth=new JLabel("Month");
        lmonth.setBounds(160,260 ,200,100);
        lmonth.setFont(new Font("Arial", Font.BOLD, 17));
        add(lmonth);
        
        month= new JComboBox(months);
        month.setBounds(350,293,200,25);  //300
        month.setFont(new Font("Arial", Font.PLAIN, 17));
        add(month);
        
        amount=new JLabel("Enter Amount");
        amount.setBounds(160,300 ,200,100);
        amount.setFont(new Font("Arial", Font.BOLD, 17));
        add(amount);
        
        tamount = new JTextField();
        tamount.setBounds(350,333,200,25);  //300
        tamount.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tamount);
         
        search = new JButton("SEARCH");
        search.setBounds(560,92,90,25);
        add(search);
        search.addActionListener(this);
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
        close.addActionListener(this);
        
        clear= new JButton("CLEAR");
        clear.setBounds(570,380,80,30);
        add(clear);
        clear.addActionListener(this);
        
        save= new JButton("SAVE");
        save.setBounds(350,380,80,30);
        add(save);
        save.addActionListener(this);
        
         setBounds(400,120,820,550);
         setUndecorated(false);
      
         setLayout(null); 
         setUndecorated(true);
         setResizable(false);
         d.setBackground(Color.white);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== close)
        {
            setVisible(false);
             
        }
        if(e.getSource()== search)
        {
            String roll=troll_no.getText();
            try
            {
               String name=new String("");
               String Designation=new String(""); 
               String mobile=new String(""); 
               String email=new String(""); 
  
               
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String pql="select name,designation,mobile,email from employee where employee_id=?";
                    PreparedStatement ps=con.prepareStatement(pql);
                    ps.setString(1,roll);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        name=rs.getString("name");
                        Designation=rs.getString("designation");
                        mobile=rs.getString("mobile");
                        email=rs.getString("email");
                        
                    }
                    
                tname.setText(name);
                tDesignation.setText(Designation);
                tmobile.setText(mobile);
                temail.setText(email);
                
            }
            catch(Exception expe)
            {
                System.out.print("error");
            }
            if(tname.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"No Employee Available");
           }
        } 
        if(e.getSource()==save)
        {
            String roll=troll_no.getText();
            String months=(String)month.getSelectedItem();
            String amount=tamount.getText();
            
           try
           {
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
            
            String query = "insert into employeefee values(?,?,?)";
            PreparedStatement  pst = connection.prepareStatement(query);
            pst.setString(1,roll);
            pst.setString(2,months);
            pst.setString(3,amount);
            pst.executeUpdate();
            connection.setAutoCommit(true);
            connection.close();
            JOptionPane.showMessageDialog(null,"Successfully paid");
            clearit();
            
           }
           catch(Exception exect)
           {
               JOptionPane.showMessageDialog(null,"Error in fees payment");
           }
           
        }
    }
    public void clearit()
    {
        String def="";
        troll_no.setText(def);
        tname.setText(def);
        tamount.setText(def);
        tmobile.setText(def);
        temail.setText(def);
        tDesignation.setText(def);
        month.removeAllItems();
    }
    public static void main(String[] args) {

     EmployeeSalary s=new EmployeeSalary();
     
    }
}
