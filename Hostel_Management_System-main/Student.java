package hostelmanagementsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Student extends JFrame implements ActionListener
   {
     JButton manage,view,add_stud,update_std,student_fee,studentfeedetail,living,sendmail,vacate,logout;
     JLabel Nav;
    Container d;
    Student()
    {
     d=getContentPane();
     
       setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Hostel_Management_System-main\\akcas.png")));
       setLayout(new FlowLayout());
        
        Nav=new JLabel("MENU");
        Nav.setBounds(25, 50, 250, 50);
        Nav.setFont(new Font("Arial", Font.BOLD, 25));
        Nav.setForeground(Color.LIGHT_GRAY);
        add(Nav);
        
        manage=new JButton("MANAGE ROOMS");
        manage.setBounds(20, 120, 230, 30);
        manage.addActionListener(this);
        
        view= new JButton("VIEW ROOMS");
        view.setBounds(20, 190, 230, 30);
        view.addActionListener(this);
        
        add_stud=new JButton("NEW STUDENT");
        add_stud.setBounds(20, 260, 230, 30);
        add_stud.addActionListener(this);
        
        update_std=new JButton("UPDATE OR DELETE STUDENT");
        update_std.setBounds(20, 330, 230, 30);
        update_std.addActionListener(this);
        
        student_fee=new JButton("FEES PAYMENT");
        student_fee.setBounds(20, 400, 230, 30);
        student_fee.addActionListener(this);
        
        studentfeedetail=new JButton("FEES DETAILS");
        studentfeedetail.setBounds(20, 470, 230, 30);
        studentfeedetail.addActionListener(this);
        
        living=new JButton("STUDENT LIVING");
        living.setBounds(20, 540, 230, 30);
        living.addActionListener(this);
        
        vacate=new JButton("VACATED STUDENTS");
        vacate.setBounds(20, 610, 230, 30);
        vacate.addActionListener(this);
        
        sendmail= new JButton("SEND ANNOUNNCEMENT");
        sendmail.setBounds(20, 680, 230, 30);
        sendmail.addActionListener(this);
        add(sendmail);
        
        logout = new JButton("LOGOUT");
        logout.setBounds(1260, 15,90, 35);
        logout.addActionListener(this);
        
        add(manage);
        add(view);
        add(add_stud);
        add(update_std);
        add(student_fee);
        add(studentfeedetail);
        add(living);
        add(vacate);
        add(logout);
        
      setBounds(0, 0,1366,768);// 
      setUndecorated(true);
      setLayout(null);    
      setVisible(true);    
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== logout)
      {
          int result=JOptionPane.showConfirmDialog(d, "Do you  really want to logout","confirmation",JOptionPane.YES_NO_OPTION);
          if(result == JOptionPane.YES_OPTION)
          {
              new Login();
              setVisible(false);
          }
      }
      if(e.getSource()== add_stud)
      {
          new Add_Student().setVisible(true);
          color(add_stud);
      }
      
      if(e.getSource()== sendmail)
      {
          new Frame();
          color(sendmail);
      }
      
      if(e.getSource()== update_std)
      {
          new Up_Del_Student().setVisible(true);  
          color(update_std);
      }
      if(e.getSource()== manage)
      {
          new ManageRooms().setVisible(true);
          color(manage);
          
      }
      if(e.getSource()== view)
      {
           new ViewRoom().setVisible(true);
           color(view);
          
      }
      if(e.getSource()== student_fee)
      {
           new StudentsFees().setVisible(true);
           color(student_fee);
          
      }
      if(e.getSource()== studentfeedetail)
      {
           new StudentFeesdetail().setVisible(true);
           color(studentfeedetail);
          
      }
      if(e.getSource()== living)
      {
           new AllStudentsLiving();
           color(living);
          
      }
      if(e.getSource()== vacate)
      {
           new AllStudentLeaved().setVisible(true);
           color(vacate);
          
      }
      }
    public void color(JButton obj)
    {
        JButton a[]={manage,view,add_stud,update_std,student_fee,studentfeedetail,living,vacate,sendmail,logout};
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            if(obj==a[i])
            {
                obj.setForeground(Color.red);
                obj.setBackground(Color.LIGHT_GRAY);
            }
            else
            {
            a[i].setBackground(new JButton().getBackground());
            a[i].setForeground(Color.black);
            }
        }
    }
  public static void main(String aa[])
  {
     Student Studen=new Student();
  }
 
}
