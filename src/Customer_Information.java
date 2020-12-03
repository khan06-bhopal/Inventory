import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Customer_Information extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Information frame = new Customer_Information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JTextField Customer_ID;
	private JTextField Delete_Id;
	public Customer_Information() {
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(23, 10, 897, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("__________________________________________________________________________________________");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 63, 966, 13);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 125, 705, 403);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("FILTER");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(35, 152, 146, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop shop = new Shop();
				shop.setVisible(true);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(24, 499, 110, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String url = "jdbc:mysql://localhost:3306/inventory";
					String uname = "khan";
					String pwd = "Bhopal@06";
					String qury = "Select *  from  FrontPage";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,uname,pwd);
					PreparedStatement ps= con.prepareStatement(qury);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(816, 76, 111, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel(" Enter Customer ID-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(23, 207, 172, 29);
		contentPane.add(lblNewLabel_3);
		
		Customer_ID = new JTextField();
		Customer_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Customer_ID.setBounds(35, 242, 146, 29);
		contentPane.add(Customer_ID);
		Customer_ID.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "jdbc:mysql://localhost:3306/inventory";
				String uname = "khan";
				String pwd = "Bhopal@06";
				try{
					
					String query ="Select * from FrontPage where EmailId=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con  =DriverManager.getConnection(url,uname,pwd);
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, Customer_ID.getText());
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				//
				try{
					String query = "Delete from FrontPage  where EmailId=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,uname,pwd);
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, Delete_Id.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(35, 437, 99, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Delete ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(46, 331, 135, 29);
		contentPane.add(lblNewLabel_4);
		
		Delete_Id = new JTextField();
		Delete_Id.setBounds(24, 371, 146, 29);
		contentPane.add(Delete_Id);
		Delete_Id.setColumns(10);
	}
}