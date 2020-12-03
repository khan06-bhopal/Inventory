import java.awt.EventQueue;
import java.awt.ActiveEvent.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Window;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.ImageIcon;
public class FrontPage {

	private JFrame frame;
	private JTextField validate_username;
	private JTextField firstname_field;
	private JTextField lastname_field;
	private JTextField phone_field;
	private JTextField email_field;
	private JTextField username_field;
	private 	JPanel panel;
	private JPasswordField password_field;
	private JPasswordField validate_password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage window = new FrontPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontPage() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
		 
	
	Connection connection=null; 
	
	private void initialize() {
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "khan", "Bhopal@06");
			// JOptionPane.showMessageDialog(null,"database connected");
			
			
		}  catch (Exception exception) {
            exception.printStackTrace();
        }
		
		
		
		
		frame = new JFrame();
		frame.setBounds(200, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Electronics Inventory System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setBounds(10, 28, 947, 91);
		frame.getContentPane().add(lblNewLabel);
		
		validate_username = new JTextField();
		validate_username.setBounds(690, 253, 227, 38);
		frame.getContentPane().add(validate_username);
		validate_username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(527, 289, 55, -23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(521, 253, 138, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(527, 324, 133, 38);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\Project Images\\Login-in-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//panel.setVisible(true);
				
				
				try {
					String validate = "Select * from FrontPage where UserName=? and Password=?";
					PreparedStatement statement= connection.prepareStatement(validate);
					
					statement.setString(1,validate_username.getText());
					statement.setString(2,validate_password.getText());
					ResultSet set= statement.executeQuery();
					
					if(set.next())
					{
					   
						JOptionPane.showMessageDialog(null,"Login successfull");
						frame.dispose();
						new Shop().setVisible(true);
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid username and password !!");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(690, 408, 119, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Already a User?");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_4.setBounds(687, 173, 237, 50);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New User");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_5.setBounds(152, 179, 221, 38);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("CREATE ACCOUNT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBounds(162, 227, 221, 30);
		frame.getContentPane().add(btnNewButton_1);
		
	    panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(10, 277, 552, 286);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		firstname_field = new JTextField();
		firstname_field.setBounds(110, 26, 137, 26);
		panel.add(firstname_field);
		firstname_field.setColumns(10);
		
		lastname_field = new JTextField();
		lastname_field.setColumns(10);
		lastname_field.setBounds(110, 78, 137, 26);
		panel.add(lastname_field);
		
		phone_field = new JTextField();
		phone_field.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyTyped(KeyEvent evt) {
				if(Character.isAlphabetic(evt.getKeyChar())){
					evt.consume();
					
				}
				
					
			}
		});
		phone_field.setColumns(10);
		phone_field.setBounds(110, 132, 137, 26);
		panel.add(phone_field);
		
		email_field = new JTextField();
		email_field.setColumns(10);
		email_field.setBounds(393, 26, 137, 26);
		panel.add(email_field);
		
		username_field = new JTextField();
		username_field.setColumns(10);
		username_field.setBounds(393, 78, 137, 26);
		panel.add(username_field);
		
		JLabel lblNewLabel_6 = new JLabel("FirstName");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 32, 90, 20);
		panel.add(lblNewLabel_6);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastname.setBounds(10, 84, 90, 20);
		panel.add(lblLastname);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNo.setBounds(10, 138, 90, 20);
		panel.add(lblPhoneNo);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setBounds(293, 32, 90, 20);
		panel.add(lblEmailId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(293, 84, 90, 20);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(293, 132, 90, 20);
		panel.add(lblPassword);
		
		JButton create_account = new JButton("Create Account");
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = firstname_field.getText();
		        String lastName = lastname_field.getText();
		        String emailId = email_field.getText();
		        String userName = username_field.getText();
		        String phoneNumber = phone_field.getText();
		        int len = phoneNumber.length();
		        String password = password_field.getText();
		       
		       
				 boolean status = Valdidation.email_validation(emailId);
				 
		        String msg = "" + firstName;
		        msg += " \n";
		        
		         
		        	if(firstName.isEmpty() ){
		        		JOptionPane.showMessageDialog(btnNewButton, "FirstName  Field Is Empty Fiel It");
		        	}
		        	else 
		        		if (lastName.isEmpty()){
		        			JOptionPane.showMessageDialog(btnNewButton, " LastName Field Is Empty Fiel It");
		        		} else 
		        			if(phoneNumber.isEmpty()){
		        				JOptionPane.showMessageDialog(btnNewButton, " PhoneNumberField Is Empty Fiel It");
		        		}  
		        			else
		        				if(len!=10){
	        				JOptionPane.showMessageDialog(btnNewButton, "PhoneNumber is 10 digit");
	        			}else 
		        			if(emailId.isEmpty()){
		        				
		        			}  else
		        				if(userName.isEmpty()){
		        					JOptionPane.showMessageDialog(btnNewButton, " UserName Field Is Empty Fiel It");	
		        				}
		        				else
		        					if(password.isEmpty()  ){
		        
		        	  JOptionPane.showMessageDialog(btnNewButton, " Password Field Is Empty Fiel It");
		        					}
		        	 
		        	else{
		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "khan", "Bhopal@06");
		        String query = "INSERT INTO FrontPage values('" + firstName + "','" + lastName + "','" +  phoneNumber + "','" +
		        		emailId + "','" + userName + "','" + password + "')";
		        	//String query1 = "Select * from FrontPage where PhoneNo='"+phoneNumber+"' and EmailId='"+emailId+"'";
		        	
		            Statement sta = connection.createStatement();
		           // ResultSet rs = sta.executeQuery(query1);
		          int x=sta.executeUpdate(query);
		            if (x==0) {
		            	JOptionPane.showMessageDialog(btnNewButton, "This already exists");
		            	
		                
		            } else {
		            	JOptionPane.showMessageDialog(btnNewButton,
			                    "Welcome, " + msg + "Your account is sucessfully created");
		            }
		            connection.close();
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        					}
			}
		});
		

		
		create_account.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		create_account.setBounds(197, 213, 148, 26);
		panel.add(create_account);
		
		password_field = new JPasswordField();
		password_field.setBounds(393, 132, 137, 26);
		panel.add(password_field);
		
		validate_password = new JPasswordField();
		validate_password.setBounds(690, 328, 228, 38);
		frame.getContentPane().add(validate_password);
	}
}