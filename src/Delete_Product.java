import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Delete_Product extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Product frame = new Delete_Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */Connection connection=null;
	private JTextField Product_ID;
	public Delete_Product() {
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "khan", "Bhopal@06");
			//JOptionPane.showMessageDialog(null,"database connected");
			
			
		}  catch (Exception exception) {
            exception.printStackTrace();
        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(378, 159, 551, 373);
		 contentPane.add(scrollPane);
		
	

		 table = new JTable();
		 scrollPane.setViewportView(table);

		 JSeparator separator = new JSeparator();
		 separator.setBounds(10, 67, 930, 2);
		 contentPane.add(separator);

		 JLabel lblNewLabel_2 = new JLabel("DELETE ITEM");
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_2.setBounds(229, 11, 494, 46);
		 contentPane.add(lblNewLabel_2);

		 JButton btnBack = new JButton("BACK");
		 btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnBack.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Stock back =  new Stock();
				 back.setVisible(true);
				 dispose();
			 }
		 });
		 btnBack.setBounds(53, 294, 103, 40);
		 contentPane.add(btnBack);
		 
		 Product_ID = new JTextField();
		 Product_ID.setBounds(184, 181, 137, 34);
		 contentPane.add(Product_ID);
		 Product_ID.setColumns(10);
		 
		 JLabel lblNewLabel = new JLabel("Product ID");
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setBounds(53, 180, 103, 35);
		 contentPane.add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("DELETE");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		try {


		 			 String query= "Delete from AddProduct where ProductId='"+Product_ID.getText()+"'  ";
		 			 PreparedStatement pst= connection.prepareStatement(query);
		 			 
		 			 pst.execute();
		 			 JOptionPane.showMessageDialog(null,"Deleted Successfully ");
		 			 pst.close();


		 		}  catch (Exception exception) {
		 			 exception.printStackTrace();
		 		}

		 	}
		 });
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnNewButton.setBounds(184, 294, 115, 40);
		 contentPane.add(btnNewButton);
		 
		 JButton Refresh_Button_1 = new JButton("Refresh");
		 Refresh_Button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						
						
						String query= "Select * from AddProduct";
						PreparedStatement pst= connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						
					}  catch (Exception exception) {
			            exception.printStackTrace();
			        }
					
				}
			});
		 Refresh_Button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 Refresh_Button_1.setBounds(778, 105, 120, 34);
		 contentPane.add(Refresh_Button_1);
		 this.setLocationRelativeTo(null);
	 }
}