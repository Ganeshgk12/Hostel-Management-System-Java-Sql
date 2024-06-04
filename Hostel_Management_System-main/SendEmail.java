
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
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author deva
 */

class Frame extends JFrame implements ActionListener{
    
    private JLabel title;
    private JLabel textArea;
    private JTextArea ttextArea;
    private JButton send,close;
    Container c;
    Frame(){
        
        c = getContentPane();
        setTitle("Send Information to Everyone");
        setBackground(Color.white);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(400, 73, 820, 550);
        setLayout(null);
        
        title = new JLabel("Send Information to All");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(250, 30);
        c.add(title);
        
        textArea = new JLabel("Enter Information");
        textArea.setFont(new Font("Arial", Font.PLAIN,20));
        textArea.setSize(500, 50);
        textArea.setLocation(100, 170);
        c.add(textArea);
        
        ttextArea = new JTextArea();
        ttextArea.setSize(400, 130);
        ttextArea.setLocation(300, 150);
        c.add(ttextArea);
        
        send = new JButton("Send");
        send.setSize(100,30);
        send.setLocation(300,285);
        c.add(send);
        send.addActionListener(this);
        
        close = new JButton("X");
        close.setFont(new Font("Arial", Font.PLAIN, 20));
        close.setBounds(770,0,50,25);
        add(close);
        close.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           setVisible(false);  
    } });
        
        setVisible(true);
        

        
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == send){
            String info = ttextArea.getText();
             String email1=new String("");
            try{
                
                Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","muthu");
                String query="select email from new_student where status=?";
                PreparedStatement pstmt=connection.prepareStatement(query);
                pstmt.setString(1,"Living");
                ResultSet rs=pstmt.executeQuery();
                while(rs.next())
                {
                    email1 = rs.getString("email");
                    mail(email1,info);
                }
                JOptionPane.showMessageDialog(null,"Message sent successfully");
                ttextArea.setText("");
            }
            catch(Exception ex){
                System.out.print(ex.getMessage());
            }

        }
        
    }
    public void mail(String email,String text)
    {
        
        final String username = "rameshvlp2001@gmail.com";
		final String password = "8778540642";

                final String from = "rameshvlp2001@gmail.com";
                final String to = email;
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
			message.setSubject("Announcement from Hostel management:");
			message.setText(text);

			Transport.send(message);

			System.out.println("Done");

		} 
                catch (MessagingException exvus){
                    System.out.println(exvus);
		} 
                
     
     }
    }




public class SendEmail {
    
    public static void main(String[] args) {
        // TODO code application logic here
         Frame f = new Frame();
         
    }
}

