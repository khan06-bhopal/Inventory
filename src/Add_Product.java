import java.awt.EventQueue;






import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class Add_Product extends JFrame {

	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField Product_ID;
	private JTable table;
	private JTextField Product_Model;
	private JTextField Product_Brand;
	private JTextField Product_Quantity;
	private JTextField Product_Price;
	JComboBox Product_Category = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product frame = new Add_Product();
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
	Connection connection=null;
	public Add_Product() {
		
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
		
		JLabel lblNewLabel = new JLabel("PRODUCT ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 132, 167, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT CATEGORY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 180, 176, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT MODEL");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 225, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT BRAND");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 268, 177, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRODUCT QUANTITY");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 317, 177, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PRODUCT PRICE");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 371, 160, 14);
		contentPane.add(lblNewLabel_5);
		
		Product_ID = new JTextField();
		Product_ID.setBounds(217, 128, 137, 23);
		contentPane.add(Product_ID);
		Product_ID.setColumns(10);
		
		JButton btnAdd = new JButton("SUBMIT");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String insert_to_products= "insert into AddProduct values(?,?,?,?,?,?)";
				
				try {
					PreparedStatement statement= connection.prepareStatement(insert_to_products);
					statement.setString(1,Product_ID.getText());
					statement.setString(2,Product_Category.getSelectedItem().toString());
					statement.setString(3,Product_Model.getText());
					statement.setString(4,Product_Brand.getText());
					statement.setString(5,Product_Quantity.getText());
					statement.setString(6,Product_Price.getText());
					
					int data_inserted=statement.executeUpdate();
					if(data_inserted>0)
					{
						JOptionPane.showMessageDialog(null,"Data inserted to Database successfully");
						Product_ID.setText("");
						Product_Model.setText("");
						Product_Brand.setText("");
						Product_Quantity.setText("");
						Product_Price.setText("");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Data insertion error !");
					}
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAdd.setBounds(217, 446, 137, 34);
		contentPane.add(btnAdd);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 966, 2);
		contentPane.add(separator);
		
		JLabel lblInvontory = new JLabel("ADD ITEM ");
		lblInvontory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvontory.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInvontory.setBounds(276, 10, 398, 41);
		contentPane.add(lblInvontory);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(21, 446, 122, 34);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock back = new Stock();
				back.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 155, 562, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Product_Model = new JTextField();
		Product_Model.setColumns(10);
		Product_Model.setBounds(217, 223, 137, 23);
		contentPane.add(Product_Model);
		
		Product_Brand = new JTextField();
		Product_Brand.setColumns(10);
		Product_Brand.setBounds(217, 266, 137, 23);
		contentPane.add(Product_Brand);
		
		Product_Quantity = new JTextField();
		Product_Quantity.setColumns(10);
		Product_Quantity.setBounds(217, 315, 137, 23);
		contentPane.add(Product_Quantity);
		
		Product_Price = new JTextField();
		Product_Price.setColumns(10);
		Product_Price.setBounds(217, 369, 137, 23);
		contentPane.add(Product_Price);
		
	
		Product_Category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Product_Category.setModel(new DefaultComboBoxModel(new String[] {"TV", "Refrigerator", "Mobile"}));
		Product_Category.setBounds(217, 179, 137, 21);
		contentPane.add(Product_Category);
		
		JLabel lblNewLabel_6 = new JLabel("Stock Table");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(470, 95, 431, 50);
		contentPane.add(lblNewLabel_6);
		
		JButton Refresh_Button = new JButton("Refresh");
		Refresh_Button.addActionListener(new ActionListener() {
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
		
		Refresh_Button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Refresh_Button.setBounds(834, 112, 122, 33);
		contentPane.add(Refresh_Button);
		this.setLocationRelativeTo(null);
	}
}