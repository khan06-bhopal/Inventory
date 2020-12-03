import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

public class Edit_Product extends JFrame 
{
	private JPanel contentPane;
	private JTextField Product_ID;
	private JTextField Product_Model;
	private JTextField Product_Category;
	private JTextField Product_Brand;
	private JTextField Product_Quantity;
	private JTextField Product_Price;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Product frame = new Edit_Product();
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
	public Edit_Product() {
		
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 107, 93, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT MODEL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(103, 195, 124, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT BRAND");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(117, 250, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT PRICE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(114, 353, 113, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRODUCT CATEGORY");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(93, 157, 133, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("PRODUCT QUANTITY");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(103, 300, 137, 18);
		contentPane.add(lblNewLabel_6);
		
		Product_ID = new JTextField();
		Product_ID.setBounds(264, 105, 124, 23);
		contentPane.add(Product_ID);
		Product_ID.setColumns(10);
		
		Product_Category = new JTextField();
		Product_Category.setBounds(264, 155, 124, 20);
		contentPane.add(Product_Category);
		Product_Category.setColumns(10);
		
		Product_Model = new JTextField();
		Product_Model.setColumns(10);
		Product_Model.setBounds(264, 197, 124, 20);
		contentPane.add(Product_Model);
		
		
		
		Product_Brand = new JTextField();
		Product_Brand.setBounds(264, 248, 124, 20);
		contentPane.add(Product_Brand);
		Product_Brand.setColumns(10);
		
		Product_Quantity = new JTextField();
		Product_Quantity.setBounds(264, 300, 124, 20);
		contentPane.add(Product_Quantity);
		Product_Quantity.setColumns(10);
		
		Product_Price = new JTextField();
		Product_Price.setColumns(10);
		Product_Price.setBounds(267, 351, 118, 20);
		contentPane.add(Product_Price);
		
		
	
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				 String query= "Update AddProduct set ProductCategory=?,ProductModal=?,ProductBrand=?,ProductQuantity=?,ProductPrice=? where ProductId=?  " ;
		 			 PreparedStatement pst= connection.prepareStatement(query);
		 			 
		 			 pst.setString(1, Product_Category.getText());
		 			 pst.setString(2, Product_Model.getText());
		 			 pst.setString(3,Product_Brand.getText());
		 			 pst.setString(4, Product_Quantity.getText());
		 			 pst.setString(5, Product_Price.getText());
		 			pst.setString(6, Product_ID.getText());
		 			 pst.executeUpdate();
		 			 JOptionPane.showMessageDialog(null,"Updated Successfully ");
		 			 pst.close();


		 		}  catch (Exception exception) {
		 			 exception.printStackTrace();
		 		}

				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit.setBounds(227, 433, 113, 41);
		contentPane.add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 133, 536, 354);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(19, 62, 946, 32);
		contentPane.add(separator);
		
		JLabel lblInvontory = new JLabel("UPDATE ITEM");
		lblInvontory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvontory.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInvontory.setBounds(284, 22, 482, 30);
		contentPane.add(lblInvontory);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock back = new Stock();
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(54, 433, 104, 41);
		contentPane.add(btnBack);
		
		JButton Refresh_Button_2 = new JButton("Refresh");
		Refresh_Button_2.addActionListener(new ActionListener() {
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
		Refresh_Button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Refresh_Button_2.setBounds(841, 89, 104, 32);
		contentPane.add(Refresh_Button_2);
		this.setLocationRelativeTo(null);
	}

}