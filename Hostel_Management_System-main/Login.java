package hostelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import hostelmanagementsystem.*;


class Login extends JFrame implements ActionListener{
     Container d;
    JButton b,exit;

    JTextField t;
    JPasswordField p;
    JLabel l1,l2,l3;
    JCheckBox show;
    ButtonGroup major;
    JRadioButton student,employee;
    
    static String u;
    Login()
    {
  
       d=getContentPane();
       setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon("J:\\Bootathon 1\\project img\\bg_adobespark1.jpg")));
       setLayout(new FlowLayout());
       
        
     
      l1=new JLabel("Log In ");
      l1.setFont(new Font("Arial", Font.BOLD, 28));
      l1.setBounds(633, 210, 300,40 );
      
      l2=new JLabel("Username");
      l2.setFont(new Font("Arial", Font.BOLD, 15));
      l2.setBounds(540,270,100,20);
       
      l3=new JLabel("Password");
      l3.setFont(new Font("Arial", Font.BOLD, 15));
      l3.setBounds(540,350,100,20);
      
      t=new JTextField();
      t.setBounds(540, 292,200, 30);
      t.setFont(new Font("Arial", Font.BOLD, 15));
      
      p=new JPasswordField();
      p.setBounds(540, 372,200, 30);
      p.setFont(new Font("Arial", Font.BOLD, 15));
      
      show = new JCheckBox("Show password");
      show.setFont(new Font("Arial", Font.BOLD, 15));
      show.setBackground(Color.white);
      show.setBounds(765, 370,150, 30);
      show.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               if(show.isSelected())
                    {
                        p.setEchoChar((char)0);
                    }
                    else
                        p.setEchoChar('*');
           }
       });
      
       student = new JRadioButton("Student Section");
        student.setFont(new Font("Arial", Font.BOLD, 13));
        student.setBackground(Color.white);
        student.setSelected(true);
        student.setSize(130, 20);
        student.setLocation(540, 425);
        add(student);
        
//        employee = new JRadioButton("Employee Section");
//        employee.setFont(new Font("Arial", Font.BOLD, 13));
//        employee.setBackground(Color.white);
//        employee.setSelected(false);
//        employee.setSize(160, 20);
//        employee.setLocation(690, 425);
//        add(employee);
        
//        major=new  ButtonGroup();
//        major.add(student);
//        major.add(employee);
        
        exit = new JButton("EXIT");
        exit.setBounds(1260, 15,90, 35);
        exit.addActionListener(this);
        add(exit);
        
      b= new JButton("Log In");
      b.setBounds(630,475,100,30);
      b.setFont(new Font("Arial", Font.BOLD, 13));
      b.addActionListener(this);
      add(l1);
      add(l2);
      add(l3);
      add(t);
      add(p);
      add(b);
      add(show);
      setBounds(0, 0,1366,768);
        setUndecorated(true);
      setLayout(null);    
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      public void actionPerformed(ActionEvent e){
                
                  if(e.getSource()==b)
                  {
                      u=t.getText();
                    String pa=p.getText();
                    String select;
                    String username =new String("username");
                    String password = new String("password");
                    
                    if(u.equals(username)&&pa.equals(password))
                    {
                        setVisible(false);
                    if (student.isSelected())
                    select = "student";
                    else
                    select = "employee";
                    
                    if(select=="student")
                    {
                        new Student();
                    }
                    else
                    {
                        new Employee();
                    }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect username or password ");
                    }
           } 
                  if(e.getSource()==exit)
                  {
                      int result=JOptionPane.showConfirmDialog(d, "Do you  really want to Exit","confirmation",JOptionPane.YES_NO_OPTION);
                      if(result == JOptionPane.YES_OPTION)
                        {
                            System.exit(0); 
                        } 
                  }
    }
    public static void main(String aa[])
    {
        new Login();
    }
}
