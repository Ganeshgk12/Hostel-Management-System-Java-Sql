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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Up_del_Employee extends JFrame implements ActionListener {
    Container d;
    private JLabel emp_id;
    private JTextField temp_id;
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
    private JLabel aadhar_no;
    private JTextField taadhar_no;
    private JButton search,close,update,delete,clear;
    String designation[]={"Warden","Maintenance","Housekeeping","Cook","Accounting and Budgeting","Quality Control"};
    private JTextField cdesignation;
    private JLabel ldesignation;
    
    
    
     Up_del_Employee()
     {
         d=getContentPane();
        
        
        emp_id=new JLabel("EMPLOYEE ID");
        emp_id.setBounds(160,20 ,200,100);
        emp_id.setFont(new Font("Arial", Font.BOLD, 17));
        add(emp_id);
        
        temp_id = new JTextField();
        temp_id.setBounds(350,53,180,25);  //300
        temp_id.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temp_id);
        
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
        
        aadhar_no=new JLabel("AADHAR NO");
        aadhar_no.setBounds(160,238 ,200,100);
        aadhar_no.setFont(new Font("Arial", Font.BOLD, 17));
        add(aadhar_no);
        
        taadhar_no = new JTextField();
        taadhar_no.setBounds(350,270,300,25);  //300
        taadhar_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(taadhar_no);
        
        email=new JLabel("EMAIL");
        email.setBounds(160,273 ,200,100);
        email.setFont(new Font("Arial", Font.BOLD, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(350,305,300,25);  //300
        temail.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temail);
        
        ldesignation=new JLabel("DESIGNATION");
        ldesignation.setBounds(160,310 ,200,100);
        ldesignation.setFont(new Font("Arial", Font.BOLD, 17));
        add(ldesignation);
        
        cdesignation = new JTextField();
        cdesignation.setBounds(350,345,300,25);  //300
        cdesignation.setFont(new Font("Arial", Font.PLAIN, 17));
        add(cdesignation);
        
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
        update.setBounds(350,400,80,30);
        add(update);
        update.addActionListener(this);
        
        delete= new JButton("DELETE");
        delete.setBounds(460,400,80,30);
        add(delete);
        delete.addActionListener(this);
       
       clear= new JButton("CLEAR");
       clear.setBounds(570,400,80,30);
       add(clear);
       clear.addActionListener(this);
       
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
        if(e.getSource()==search)
        {
         String empid=temp_id.getText();
            try
            {
               String name=new String("");
               String gender=new String("");
               String fathername=new String("");
               String mothername=new String("");     
               String mobile=new String("");
               String aadhar=new String("");
               String email=new String("");
               String designation=new String("");
               String status=new String(""); 
               
  
               
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                    String pql="select name,father,mother,mobile,email,aadhar,designation,status,gender from employee where employee_id=?";
                    PreparedStatement ps=con.prepareStatement(pql);
                    ps.setString(1,empid);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        name=rs.getString("name");
                        fathername=rs.getString("father");
                        mothername=rs.getString("mother");
                        mobile=rs.getString("mobile");
                        aadhar=rs.getString("aadhar");
                        gender=rs.getString("gender");
                        email=rs.getString("email");
                        designation=rs.getString("designation");
                        status=rs.getString("status");
                    }
                    
                tname.setText(name);
                father_tname.setText(fathername);
                mother_tname.setText(mothername);
                tmobile.setText(mobile);
                taadhar_no.setText(aadhar);
                temail.setText(email);
                cdesignation.setText(designation);
                cdesignation.setEditable(false);
            
                if(gender.equals("Male"))
                    male.setSelected(true);
                if(gender.equals("Female"))
                    female.setSelected(true);
            
                if(tname.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Employee does not exist");
                }
            }
            catch(Exception expe)
            {
                System.out.print("error");
            }
        }
        
        if(e.getSource()==update)
     {
         
               String empid=temp_id.getText();
               String name=tname.getText();
               String gender;
               String fathername=father_tname.getText();
               String mothername=mother_tname.getText();    
               String mobile=tmobile.getText();
               String aadhar=taadhar_no.getText();
               String email=temail.getText();
               String designation=cdesignation.getText();
               String status="Working"; 
     
            if(validateRoll(empid)==true)
            {
            if(validateName(name)==true && validateName(fathername)==true && validateName(mothername)== true )
            {
            if(validateNumber(mobile)==true )
            {
            if(validateaadhar(aadhar)==true )
            {
            if(validateEmail(email)==true)
            {
                   if (male.isSelected())
                    gender = "Male";
                             
                else
                    gender = "Female";
                   
                
                JavaBean user = new JavaBean(); 
                user.setEmpid(empid);
                user.setName(name);
                user.setGender(gender);
                user.setFathername(fathername);
                user.setMothername(mothername);   
                user.setMobile(mobile);
                user.setAadhar(aadhar);
                user.setEmail(email);
                user.setStatus(status);
                user.setDesignation(designation);
                
               EmployeeDatabase  datas = new EmployeeDatabase();
               datas.connection1(user);
               setVisible(false);
               new Up_del_Employee();
                
                 
              }
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter a valid email address");
            }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Enter a valid Aadhar Number ");
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
        
        if(e.getSource() == delete)
        {
            String emp=temp_id.getText();
            String status="Left";
            
            JavaBean user = new JavaBean();
            user.setEmpid(emp);
            user.setStatus(status);
            
            EmployeeDatabase  datas = new EmployeeDatabase();
            datas.connection2(user);
            clearit(); 
            
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
        Pattern i = Pattern.compile("[0-9]{2}[a-z]{4}[0-9]{3}");
                Matcher j = i.matcher(roll);
                if(j.matches())
                return true;
                return false;
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
    
    public boolean validateaadhar(String aadhar)
    {
        Pattern i = Pattern.compile("[0-9]{12}+");
                Matcher j = i.matcher(aadhar);
                if(j.matches())
                return true;
                return false;
    }
    public void clearit()
    {
            String def = "";
            tname.setText(def);
            temp_id.setText(def);
            father_tname.setText(def);
            mother_tname.setText(def);
            tmobile.setText(def);
            taadhar_no.setText(def);
            tmobile.setText(def);
            temail.setText(def);
            cdesignation.setText(def);
            
    }
     public static void main(String aa[])
    {
        new Up_del_Employee();
    }
}
