/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostelmanagementsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Up_Del_Student extends JFrame implements ActionListener {
     Container d;
    private JLabel roll_no;
    private JTextField troll_no;
    private JLabel name;
    private JTextField tname;
    private JLabel gender;
    private JRadioButton male,female,living,leaved;
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
    private JLabel room_no;
    private JTextField troom_no;
    private JLabel chroom_no;
    private JComboBox croom_no;
    private JButton search,close,update,delete,clear,ok;
    private JCheckBox show;
    private JComboBox cstatus;
    private JLabel lstatus;
    private JLabel Send ,via;
    private JTextField tsend;
    
     Up_Del_Student()
     {
         d=getContentPane();
        
        
        roll_no=new JLabel("ROLL NO");
        roll_no.setBounds(160,20 ,200,100);
        roll_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(roll_no);
        
        troll_no = new JTextField();
        troll_no.setBounds(350,53,180,25);  //300
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
        father_name.setBounds(160,133 ,200,100);
        father_name.setFont(new Font("Arial", Font.BOLD, 17));
        add(father_name);
        
        father_tname = new JTextField();
        father_tname.setBounds(350,165,300,25);  //300
        father_tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(father_tname);
        
        mother_name=new JLabel("MOTHER NAME");
        mother_name.setBounds(160,168 ,200,100);
        mother_name.setFont(new Font("Arial", Font.BOLD, 17));
        add(mother_name);
        
        mother_tname = new JTextField();
        mother_tname.setBounds(350,200,300,25);  //300
        mother_tname.setFont(new Font("Arial", Font.PLAIN, 17));
        add(mother_tname);
  
        mobile=new JLabel("MOBILE NO");
        mobile.setBounds(160,203 ,200,100);
        mobile.setFont(new Font("Arial", Font.BOLD, 17));
        add(mobile);
        
        tmobile = new JTextField();
        tmobile.setBounds(350,235,300,25);  //300
        tmobile.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tmobile);
        
        parent_mobile=new JLabel("PARENT MOBILE NO");
        parent_mobile.setBounds(160,238 ,200,100);
        parent_mobile.setFont(new Font("Arial", Font.BOLD, 17));
        add(parent_mobile);
        
        parent_tmobile = new JTextField();
        parent_tmobile.setBounds(350,270,300,25);  //300
        parent_tmobile.setFont(new Font("Arial", Font.PLAIN, 17));
        add(parent_tmobile);
        
        email=new JLabel("EMAIL");
        email.setBounds(160,273 ,200,100);
        email.setFont(new Font("Arial", Font.BOLD, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(350,305,300,25);  //300
        temail.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temail);
        
        room_no=new JLabel("ROOM NO");
        room_no.setBounds(160,310 ,200,100);
        room_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(room_no);
        
        troom_no = new JTextField();
        troom_no.setBounds(350,345,200,25);  //300
        troom_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(troom_no);
        
        chroom_no=new JLabel("CHANGE ROOM");
        chroom_no.setBounds(160,345 ,200,100);
        chroom_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(chroom_no);
        
        croom_no = new JComboBox();
        croom_no.setBounds(350,380,200,25);  //300
        croom_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(croom_no);
        croom_no.setEditable(false);
        croom_no.setEnabled(false);
        croom_no.addActionListener(this);
        
        Send=new JLabel("via Gmail");
        Send.setBounds(161,450 ,300,100);
        Send.setFont(new Font("Arial", Font.BOLD, 17));
        add(Send);
        
        via=new JLabel("Send Updated details");
        via.setBounds(160,450 ,300,50);
        via.setFont(new Font("Arial", Font.BOLD, 17));
        add(via);
        
        tsend = new JTextField();
        tsend.setBounds(350,485,200,25);  //300
        tsend.setFont(new Font("Arial", Font.PLAIN, 17));
        add(tsend);
        
        show = new JCheckBox("Click here to select rooms");
        show.setFont(new Font("Arial", Font.BOLD, 15));
        show.setBounds(570,380,220,25);
        add(show);
        show.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               if(show.isSelected())
                    {
                        croom_no.setEditable(true);
                        croom_no.setEnabled(true);
                    }
               else
                    {
                        croom_no.setEditable(false);
                        croom_no.setEnabled(false);
                    }
           }
       });
        
        
        search = new JButton("SEARCH");
        search.setBounds(560,52,90,25);
        add(search);
        search.addActionListener(this);
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
        close.addActionListener(this);
        
        update= new JButton("UPDATE");
        update.setBounds(350,425,80,30);
        add(update);
        update.addActionListener(this);
        
        delete= new JButton("DELETE");
        delete.setBounds(460,425,80,30);
        add(delete);
        delete.addActionListener(this);
       
       clear= new JButton("CLEAR");
       clear.setBounds(570,425,80,30);
       add(clear);
       clear.addActionListener(this);
       
       ok= new JButton("OK");
       ok.setBounds(570,485,70,25);
       add(ok);
       ok.addActionListener(this);
       
          try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String query1="select room_no from room where room_status='unoccupied' and active_status='active'";
                    PreparedStatement ps = connection.prepareStatement(query1);
                    ResultSet rs=ps.executeQuery();
                    
                    while(rs.next())
                    {
                        
                        croom_no.addItem(rs.getString("room_no"));   
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
               String gender=new String("");
               String fathername=new String("");
               String mothername=new String("");     
               String mobile=new String("");
               String parentmobile=new String("");
               String email=new String("");
               String room=new String("");
               String status=new String("");


                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String pql="select name,father,mother,mobile,email,room_no,status,gender,parentmobile from new_student where roll_no=?";
                    PreparedStatement ps=con.prepareStatement(pql);
                    ps.setString(1,roll);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        name=rs.getString("name");
                        fathername=rs.getString("father");
                        mothername=rs.getString("mother");
                        mobile=rs.getString("mobile");
                        parentmobile=rs.getString("parentmobile");
                        gender=rs.getString("gender");
                        email=rs.getString("email");
                        room=rs.getString("room_no");
                        status=rs.getString("status");
                    }
                    
                tname.setText(name);
                father_tname.setText(fathername);
                mother_tname.setText(mothername);
                tmobile.setText(mobile); 
                parent_tmobile.setText(parentmobile);
                temail.setText(email);
                tsend.setText(email);
            
                if(gender.equals("Male"))
                    male.setSelected(true);
                if(gender.equals("Female"))
                    female.setSelected(true);
            
                troom_no.setText(room);
                if(tname.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Student does not exist");
                }
            }
            catch(Exception expe)
            {
                System.out.print("error");
            }
            
        }
        
        
     if(e.getSource()==update)
     {
     String rollno=troll_no.getText();
     String name=tname.getText();
     String gender;
     String fathername=father_tname.getText();
     String mothername=mother_tname.getText();     //rollno,name,gender, fathername, mothername, mobile,parentmobile,email, room;
     String mobile=tmobile.getText();
     String parentmobile=parent_tmobile.getText();
     String email=temail.getText();
     String room=troom_no.getText();
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
            
            if(croom_no.getSelectedIndex()!= -1)
            {
                String croom=(String)croom_no.getSelectedItem();
                //room=troom_no.getText();
                String stat="unoccupied";
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                        String query1="update room set room_status=? where room_no=?";
                        PreparedStatement pstmt=connection2.prepareStatement(query1);
                        pstmt.setString(2,room);
                        pstmt.setString(1,stat);
                        pstmt.executeUpdate();
                        connection2.setAutoCommit(true);
                        connection2.close();
                    }
                catch(Exception expec)
                    {
                        System.out.print("error");
                    }
                JavaBean admin = new JavaBean(); 
                admin.setRollno(rollno);
                admin.setName(name);
                admin.setGender(gender);
                admin.setFathername(fathername);
                admin.setMothername(mothername);   
                admin.setMobile(mobile);
                admin.setParentmobile(parentmobile);
                admin.setEmail(email);
                admin.setRoom(croom);
                admin.setStatus(status);
                
               StudentDatabase  datas1 = new StudentDatabase();
               datas1.connection1(admin); 
               edit();
            
            }
            else
            {
                
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
                
               StudentDatabase  datashY = new StudentDatabase();
               System.out.println("here");
               datashY.connection1(admin);
               edit();
            }    
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
     if(e.getSource()== delete)
     {
         String rollno=troll_no.getText();
         String room=troom_no.getText();
          
                JavaBean admin = new JavaBean(); 
                admin.setRollno(rollno);
                admin.setRoom(room);
                
                StudentDatabase  datas1 = new StudentDatabase();
                datas1.connection2(admin);
                new Up_Del_Student();
      }
     
     if(e.getSource()==ok)
     {
         String roll=troll_no.getText();
         String name=tname.getText();
         String gender;
         if (male.isSelected())
                    gender = "Male";
                   else
                    gender = "Female";
         String fathername=father_tname.getText();
         String mothername=mother_tname.getText();     //rollno,name,gender, fathername, mothername, mobile,parentmobile,email, room;
         String mobile=tmobile.getText();
         String parentmobile=parent_tmobile.getText();
         String email=temail.getText();
         String room;
         if(croom_no.getSelectedIndex()==-1)
         {
            room=troom_no.getText();
         }
         else
            room =(String)croom_no.getSelectedItem();
         
         String reciever=tsend.getText();
         
                final String username = "jd.donateblood@gmail.com";
		final String password = "jeyagraha";

                final String from = "jd.donateblood@gmail.com";
                final String to = reciever;
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



                
                Authenticator a =new Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        
                        return new PasswordAuthentication(username, password);
                        
                    }
                    
                };

                Session session = Session.getInstance(props, a);
                
		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(roll+"Details");
			message.setText("Name-"+name+"\n Gender-"+gender+"\nFathername-"+fathername+"\nMothername-"+mothername+"\nMobile Number-"+mobile+"\nParent Mobile No-"+parentmobile+"\nRoom Number-"+room+"\nEmail-"+email);

			Transport.send(message);

			System.out.println("Done");

		} 
                catch (MessagingException ex){
                    System.out.println(e);
		} 
                setVisible(false);
                new Up_Del_Student();
     
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
            troom_no.setText(def);
            croom_no.removeAllItems();
            tsend.setText(def);
          
     }
    public void edit()
    {
        
            tname.setEditable(false);
            troll_no.setEditable(false);
            father_tname.setEditable(false);
            mother_tname.setEditable(false);
            tmobile.setEditable(false);
            parent_tmobile.setEditable(false);
            tmobile.setEditable(false);
            temail.setEditable(false);
            troom_no.setEditable(false);
            croom_no.setEditable(false);
            croom_no.setEditable(false);
            croom_no.setEnabled(false);
          
     }
    public static void main(String aa[])
    {
        new Up_Del_Student();
    }
}
