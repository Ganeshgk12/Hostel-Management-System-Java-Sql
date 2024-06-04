
package hostelmanagementsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Add_Employee extends JFrame implements ActionListener {
    Container d;
    private JLabel emp_id;
    private JTextField temp_no;
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
    private JLabel email;
    private JTextField temail;
    private JLabel aadhar;
    private JTextField taadhar;
    String designation[]={"Warden","Maintenance","Housekeeping","Cook","Accounting and Budgeting","Quality Control"};
    private JLabel ldesignation;
    private JComboBox cdesignation;
    private JButton close,save,clear;
    Add_Employee()
    {
         d=getContentPane();
        
        
        emp_id=new JLabel("EMPLOYEE ID");
        emp_id.setBounds(160,20 ,200,100);
        emp_id.setFont(new Font("Arial", Font.BOLD, 17));
        add(emp_id);
        
        temp_no = new JTextField();
        temp_no.setBounds(350,53,300,25);  //300
        temp_no.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temp_no);
        
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
        
        aadhar=new JLabel("AADHAR NO");
        aadhar.setBounds(160,235 ,200,100);
        aadhar.setFont(new Font("Arial", Font.BOLD, 17));
        add(aadhar);
        
        taadhar = new JTextField();
        taadhar.setBounds(350,270,300,25);  //300
        taadhar.setFont(new Font("Arial", Font.PLAIN, 17));
        add(taadhar);
        
        email=new JLabel("EMAIL");
        email.setBounds(160,270 ,200,100);
        email.setFont(new Font("Arial", Font.BOLD, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(350,305,300,25);  //300
        temail.setFont(new Font("Arial", Font.PLAIN, 17));
        add(temail);
        
        ldesignation=new JLabel("DESIGNATION");
        ldesignation.setBounds(160,305 ,200,100);
        ldesignation.setFont(new Font("Arial", Font.BOLD, 17));
        add(ldesignation);
        
        cdesignation = new JComboBox(designation);
        cdesignation.setBounds(350,345,300,25);  //300
        cdesignation.setFont(new Font("Arial", Font.PLAIN, 17));
        add(cdesignation);
        cdesignation.addActionListener(this);
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
        close.addActionListener(this);
        
        save= new JButton("SAVE");
        save.setBounds(350,400,80,30);
        add(save);
       save.addActionListener(this);
       
       clear= new JButton("CLEAR");
       clear.setBounds(570,400,80,30);
       add(clear);
                 
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
        if(e.getSource()==clear)
        {
            clearit();
        }
     if(e.getSource()==save)
     {
     String emp_id=temp_no.getText();
     String name=tname.getText();
     String gender;
     String fathername=father_tname.getText();
     String mothername=mother_tname.getText();     //rollno,name,gender, fathername, mothername, mobile,parentmobile,email, room;
     String mobile=tmobile.getText();
     String aadhar=taadhar.getText();
     String email=temail.getText();
     String designation=(String)cdesignation.getSelectedItem();
     String status="Working";
            if(validateRoll(emp_id)==true)
            {
            if(validateName(name)==true && validateName(fathername)==true && validateName(mothername)==true )
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
                user.setEmpid(emp_id);
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
               datas.connection(user);
               setVisible(false);
               new Add_Employee();
                
                 
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
        Pattern i = Pattern.compile("[0-9]{3}");
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
            temp_no.setText(def);
            father_tname.setText(def);
            mother_tname.setText(def);
            tmobile.setText(def);
            taadhar.setText(def);
            tmobile.setText(def);
            temail.setText(def);
            cdesignation.removeAllItems();
            
    }
    
    public static void main(String aa[])
    {
        new Add_Employee();
    }
    
}
