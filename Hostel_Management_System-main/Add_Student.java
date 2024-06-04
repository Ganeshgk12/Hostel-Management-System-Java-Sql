package hostelmanagementsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import hostelmanagementsystem.*;

public class Add_Student extends JFrame implements ActionListener{
    Container d;
    private JLabel roll_no;
    private JTextField troll_no;
    private JLabel name;
    private JTextField tname;
    private JLabel gender;
    private JRadioButton male,female;
    private ButtonGroup gender1;
    private JLabel father_name;
    private JTextField father_tname;
    private JLabel mother_name;
    private JTextField mother_tname;
    private JLabel mobile;
    private JTextField tmobile;
    private JLabel parent_mobile;
    private JTextField parent_tmobile;
    private JLabel email;
    private JTextField temail;
    String room;
    private JLabel lroom_no;
    private JComboBox croom_no;
    private JButton close,save,clear;
    
    
    
    public Add_Student()
     {
         d=getContentPane();
        
        
        roll_no=new JLabel("ROLL NO");
        roll_no.setBounds(160,20 ,200,100);
        roll_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(roll_no);
        
        troll_no = new JTextField();
        troll_no.setBounds(350,53,300,25);  //300
        troll_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(troll_no);
        
        name=new JLabel("NAME");
        name.setBounds(160,60 ,200,100); //55
        name.setFont(new Font("Arial", Font.BOLD, 17));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(350,93,300,25);  //330
        tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tname);
        
        gender = new JLabel("GENDER");
        gender.setFont(new Font("Arial", Font.BOLD, 17));
        gender.setBounds(160,95,200,100);
        add(gender);
  
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 17));
        male.setSelected(true);
        male.setBounds(350,133,80,20);
        add(male);
  
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 17));
        female.setSelected(false);
        female.setBounds(425,133,80,20);
        add(female);
  
        gender1 = new ButtonGroup();
        gender1.add(male);
        gender1.add(female);
        
        father_name=new JLabel("FATHER NAME");
        father_name.setBounds(160,130 ,200,100);
        father_name.setFont(new Font("Arial", Font.BOLD, 17));
        add(father_name);
        
        father_tname = new JTextField();
        father_tname.setBounds(350,165,300,25);  //300
        father_tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(father_tname);
        
        mother_name=new JLabel("MOTHER NAME");
        mother_name.setBounds(160,165 ,200,100);
        mother_name.setFont(new Font("Arial", Font.BOLD, 17));
        add(mother_name);
        
        mother_tname = new JTextField();
        mother_tname.setBounds(350,200,300,25);  //300
        mother_tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(mother_tname);
  
        mobile=new JLabel("MOBILE NO");
        mobile.setBounds(160,200 ,200,100);
        mobile.setFont(new Font("Arial", Font.BOLD, 17));
        add(mobile);
        
        tmobile = new JTextField();
        tmobile.setBounds(350,235,300,25);  //300
        tmobile.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tmobile);
        
        parent_mobile=new JLabel("PARENT MOBILE NO");
        parent_mobile.setBounds(160,235 ,200,100);
        parent_mobile.setFont(new Font("Arial", Font.BOLD, 17));
        add(parent_mobile);
        
        parent_tmobile = new JTextField();
        parent_tmobile.setBounds(350,270,300,25);  //300
        parent_tmobile.setFont(new Font("Arial", Font.PLAIN, 17));
        add(parent_tmobile);
        
        email=new JLabel("EMAIL");
        email.setBounds(160,270 ,200,100);
        email.setFont(new Font("Arial", Font.BOLD, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(350,305,300,25);  //300
        temail.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temail);
        
        lroom_no=new JLabel("ROOM NO");
        lroom_no.setBounds(160,305 ,200,100);
        lroom_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(lroom_no);
        
        croom_no = new JComboBox();
        croom_no.setBounds(350,345,200,25);  //300
        croom_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(croom_no);
        croom_no.addActionListener(this);
       
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
       close.addActionListener(this);//
       
       close.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           setVisible(false);  
    }  
    }); 
        
        save= new JButton("SAVE");
        save.setBounds(350,400,80,30);
        add(save);
        save.addActionListener(this);
       
       clear= new JButton("CLEAR");
       clear.setBounds(570,400,80,30);
       add(clear);
       clear.addActionListener(this);
       
        int a=0;
          try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String query1="select room_no from room where room_status='unoccupied' and active_status='active'";
                    PreparedStatement ps = connection.prepareStatement(query1);
                    ResultSet rs=ps.executeQuery();
                    
                    while(rs.next())
                    {
                        a=1;
                        croom_no.addItem(rs.getString("room_no"));   
                    }
                   if(a==0)
                    {
                        save.setVisible(false);
                        JOptionPane.showMessageDialog(null,"All rooms are already booked");
                        setVisible(false);
                         
                   }
                    //connection.setAutoCommit(true);
                   connection.close();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Error in searching rooms"); 
                }
                 
      setBounds(400,120,820,550);
      setUndecorated(true);
      setLayout(null);  
      setResizable(false);
      d.setBackground(Color.white);
      setVisible(true); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     }
     
     @Override
    public void actionPerformed(ActionEvent e) { 
     
     if(e.getSource()==clear)
     {
        clearit();
     //   new Student().add_stud.setBackground(new JButton().getBackground());
     }
     if(e.getSource()==save)
     {
     String rollno=troll_no.getText();
     String name=tname.getText();
     String gender;
     String fathername=father_tname.getText();
     String mothername=mother_tname.getText();     
     String mobile=tmobile.getText();
     String parentmobile=parent_tmobile.getText();
     String email=temail.getText();
     String room=(String)croom_no.getSelectedItem();
     String status="Living";
      
            if(validateRoll(rollno)==true)
            {
            if(validateName(name)==true && validateName(fathername)==true && validateName(mothername)==true)
            {
            if(validateNumber(mobile)==true && validateNumber(parentmobile)==true)
            {
            if(validateEmail(email)==true)
            {
                   if (male.isSelected())
                    gender = "Male";
                   else
                    gender = "Female";
                   
                
                JavaBean admin = new JavaBean(); 
                admin.setRollno(rollno);
                admin.setName(name);
                admin.setGender(gender);
                admin.setFathername(fathername);
                admin.setMothername(mothername);   
                admin.setMobile(mobile);
                admin.setParentmobile(parentmobile);
                admin.setEmail(email);
                admin.setRoom(room);
                admin.setStatus(status);
                
               StudentDatabase  datash = new StudentDatabase();
               datash.connection(admin);
               setVisible(false);
               new Add_Student();
              }
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter a valid email address");
            }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter a valid Mobile Number ");
            }
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null,"The name should not contain any numbers or special character ");
            }
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter a valid roll number");
            }
         }
     }
     public boolean validateName(String Names)
    {
        Pattern i = Pattern.compile("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
                Matcher j = i.matcher(Names);
                if(j.matches())
                return true;
                return false;
    }
    
    public boolean validateRoll(String roll)
    {
                return true;

    }
    
    public boolean validateNumber(String number)
    {
        Pattern i = Pattern.compile("[6789][0-9]{9}+");
                Matcher j = i.matcher(number);
                if(j.matches())
                return true;
                return false;
    }
    
    public boolean validateEmail(String email)
    {
        Pattern i = Pattern.compile("[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}");
                Matcher j = i.matcher(email);
                if(j.matches())
                return true;
                return false;
    }
    
    public void clearit()
    {
        String def = "";
            tname.setText(def);
            troll_no.setText(def);
            father_tname.setText(def);
            mother_tname.setText(def);
            tmobile.setText(def);
            parent_tmobile.setText(def);
            tmobile.setText(def);
            temail.setText(def);
           // croom_no.removeAllItems();
          //  RoomsInCombo();
     }
   public static void main(String aa[])
    {
      Add_Student ss=  new Add_Student();
    }

    
}
