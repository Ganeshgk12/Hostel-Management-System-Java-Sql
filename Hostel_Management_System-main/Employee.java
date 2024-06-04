
package hostelmanagementsystem;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Employee extends JFrame implements ActionListener{
    JButton add_emp,update_emp,employee_fee,employeefeedetail,working,left,logout;
    Container d;
    JLabel Nav;
    Employee()
    {
     d=getContentPane(); 
        
        
       setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Hostel_Management_System-main\\pic.jpg")));
       setLayout(new FlowLayout());
       
       Nav=new JLabel("NAVIGATION BAR");
        Nav.setBounds(20, 50, 250, 50);
        Nav.setFont(new Font("Arial", Font.BOLD, 25));
        Nav.setForeground(Color.LIGHT_GRAY);
        add(Nav);
        add_emp=new JButton("NEW EMPLOYEE");
        add_emp.setBounds(20, 120, 230, 30);
        add(add_emp);
        add_emp.addActionListener(this);
        
        update_emp=new JButton("UPDATE OR DELETE EMPLOYEE");
        update_emp.setBounds(20, 190, 230, 30);
        add(update_emp);
        update_emp.addActionListener(this);
        
        employee_fee=new JButton("SALARY PAYMENT");
        employee_fee.setBounds(20, 260, 230, 30);
        add(employee_fee);
        employee_fee.addActionListener(this);
        
        employeefeedetail=new JButton("FEES DETAILS");
        employeefeedetail.setBounds(20, 330, 230, 30);
        employeefeedetail.addActionListener(this);
        add(employeefeedetail); 
        
        working=new JButton("EMPLOYEE WORKING");
        working.setBounds(20, 400, 230, 30);
        add(working);
        working.addActionListener(this);
        
        left=new JButton("EMPLOYEE LEFT");
        left.setBounds(20, 470, 230, 30);
        add(left);
        left.addActionListener(this);
        
        logout = new JButton("LOGOUT");
        logout.setBounds(1260, 15,90, 35);
        logout.addActionListener(this);
        add(logout);
        
        
      setBounds(0, 0,1366,768); 
      setUndecorated(true);
      setLayout(null);    
      setVisible(true);    
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      public void actionPerformed(ActionEvent e) {
       if(e.getSource()== add_emp)
        {
          new Add_Employee().setVisible(true);
          color(add_emp);
          
        }
        if(e.getSource()== update_emp)
        {
          new Up_del_Employee().setVisible(true);
          color(update_emp);
        }
        
        if(e.getSource()== employee_fee)
        {
          new EmployeeSalary().setVisible(true);
          color(employee_fee);
        }
        
        if(e.getSource()== employeefeedetail)
        {
          new EmployeeFeesdetail().setVisible(true);
          color(employeefeedetail);
        }
        
        if(e.getSource()== working)
        {
          new EmployeeWorking();
          color(working);
        }
        
        if(e.getSource()== left)
        {
          new EmployeeLeft();
          color(left);
        }
        
      if(e.getSource()==logout)
      {
          int result=JOptionPane.showConfirmDialog(d, "Do you  really want to logout","confirmation",JOptionPane.YES_NO_OPTION);
          if(result == JOptionPane.YES_OPTION)
          {
              new Login();
              setVisible(false);
          }
      }
    }
      public void color(JButton obj)
    {
        JButton a[]={add_emp,update_emp,employee_fee,employeefeedetail,working,left,logout};
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            if(obj==a[i])
            {
                obj.setForeground(Color.blue);
                obj.setBackground(Color.white);
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
        Employee emp=new Employee();
    }
}
