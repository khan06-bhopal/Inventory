import java.awt.BorderLayout;
import java.sql.Types;

import java.util.Date;
import java.sql.*;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Purchase_Order extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField Purchase_Date;
	private JTextField Customer_ID;
	private JTextField Customer_Name;
	private JTable table;
	private JTable table_1;
	private JTextField Product_ID;
	private JTextField Product_Quantity;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase_Order frame = new Purchase_Order();
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
	private JTextField Update_Quant;
	private JTextField Mobile_No;
	 public Purchase_Order() {
		 try {
			 //Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "khan", "Bhopal@06");
			 //JOptionPane.showMessageDialog(null,"database connected");


		 }  catch (Exception exception) {
			 exception.printStackTrace();
		 }

		
			
			



		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(200, 100, 1261, 678);
		 contentPane = new JPanel();
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setContentPane(contentPane);
		 contentPane.setLayout(null);

		 JButton btnPrintRecipt = new JButton("PRINT INVOICE");
		// btnPrintRecipt.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\Project Images\\Printer-icon.png"));
		 btnPrintRecipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnPrintRecipt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				 String insert_to_purchaseinfo= "insert into Purchase values(?,?,?,?)";
					
					try {
						PreparedStatement statement= connection.prepareStatement(insert_to_purchaseinfo);
					
						
						statement.setString(1, Purchase_Date.getText());
						statement.setString(2,Customer_ID.getText());
						
						statement.setString(3,Customer_Name.getText());
						
						statement.setString(4,Mobile_No.getText());
						
						
						statement.executeUpdate();
						
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				 
				 
				// String ID=Customer_ID.getText();
				
				
				 Print_Receipt receipt = new Print_Receipt();
			    receipt.setVisible(true);
				 dispose();
			 }
		 });
		 btnPrintRecipt.setBounds(1013, 597, 200, 34);
		 contentPane.add(btnPrintRecipt);

		 btnBack = new JButton("Back");
		 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnBack.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Shop back = new Shop();
				 back.setVisible(true);
				 dispose();
			 }
		 });
		 btnBack.setBounds(10, 597, 97, 34);
		 contentPane.add(btnBack);

		 JLabel lblDate = new JLabel("Date");
		 lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblDate.setBounds(20, 86, 81, 18);
		 contentPane.add(lblDate);

		 Purchase_Date = new JTextField();
		 Purchase_Date.setBounds(111, 86, 123, 23);
		 contentPane.add(Purchase_Date);
		 Purchase_Date.setColumns(10);

		 JLabel lblNewLabel = new JLabel("Customer Name");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel.setBounds(576, 86, 120, 18);
		 contentPane.add(lblNewLabel);

		 Customer_ID = new JTextField();
		 Customer_ID.setBounds(421, 86, 120, 23);
		 contentPane.add(Customer_ID);
		 Customer_ID.setColumns(10);

		 JLabel lblNewLabel_1 = new JLabel("Customer ID");
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_1.setBounds(288, 86, 123, 18);
		 contentPane.add(lblNewLabel_1);

		 Customer_Name = new JTextField();
		 Customer_Name.setBounds(706, 86, 145, 23);
		 contentPane.add(Customer_Name);
		 Customer_Name.setColumns(10);

		 JButton btnNewButton = new JButton("Add to Cart");
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0)
			 {
             try {


					 String query= "Insert into PRODUCTCART(ProductId,ProductCategory,ProductModal,ProductBrand,ProductQuantity,ProductPrice) select * from AddProduct  where ProductId='"+Product_ID.getText()+"'  ";
					 PreparedStatement pst= connection.prepareStatement(query);
					 pst.execute();
					 pst.close();
					
					 
					 String query_2= "Update PRODUCTCART set ProductQuantity='"+Product_Quantity.getText()+"' where ProductId='"+Product_ID.getText()+"' ";
					 PreparedStatement pst_2= connection.prepareStatement(query_2);
					 pst_2.execute();
					 pst_2.close();
					 String query_4= "UPDATE PRODUCTCART SET Total = ProductQuantity * ProductPrice  ";
					 PreparedStatement pst_4= connection.prepareStatement(query_4);
					 pst_4.execute();
					 pst_4.close();
					
					 JOptionPane.showMessageDialog(null,"Added to cart successfully");


				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }




			 }
		 });
		 btnNewButton.setBounds(548, 476, 145, 34);
		 contentPane.add(btnNewButton);

		 JButton btnNewButton_1 = new JButton("Delete Item");
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				 try {


		 			 String query= "Delete from PRODUCTCART where ProductId='"+Product_ID.getText()+"'  ";
		 			 PreparedStatement pst= connection.prepareStatement(query);
		 			 
		 			 pst.execute();
		 			 JOptionPane.showMessageDialog(null,"Deleted from cart ");
		 			 pst.close();


		 		}  catch (Exception exception) {
		 			 exception.printStackTrace();
		 		}
				 
				 
				 
				 
			 }
		 });
		 btnNewButton_1.setBounds(548, 524, 148, 34);
		 contentPane.add(btnNewButton_1);

		 JSeparator separator = new JSeparator();
		 separator.setBounds(10, 57, 672, -4);
		 contentPane.add(separator);

		 JSeparator separator_1 = new JSeparator();
		 separator_1.setBounds(10, 57, 1227, 14);
		 contentPane.add(separator_1);

		 JLabel lblNewLabel_2 = new JLabel("BILLING OPERATION");
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		 lblNewLabel_2.setBounds(26, 11, 1187, 34);
		 contentPane.add(lblNewLabel_2);

		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 208, 518, 338);
		 contentPane.add(scrollPane);

		 table = new JTable();
		 scrollPane.setViewportView(table);

		 JButton btnNewButton_2 = new JButton("Refresh Current Stock");
		 btnNewButton_2.addActionListener(new ActionListener() {
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
		 btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnNewButton_2.setBounds(10, 160, 194, 29);
		 contentPane.add(btnNewButton_2);

		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(725, 207, 512, 332);
		 contentPane.add(scrollPane_1);

		 table_1 = new JTable();
		 scrollPane_1.setViewportView(table_1);

		 Product_ID = new JTextField();
		 Product_ID.setBounds(562, 283, 131, 34);
		 contentPane.add(Product_ID);
		 Product_ID.setColumns(10);

		 Product_Quantity = new JTextField();
		 Product_Quantity.setBounds(562, 387, 131, 34);
		 contentPane.add(Product_Quantity);
		 Product_Quantity.setColumns(10);

		 JLabel lblNewLabel_3 = new JLabel("Product ID");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_3.setBounds(562, 239, 131, 34);
		 contentPane.add(lblNewLabel_3);



		 JButton Refresh_Cart = new JButton("Refresh Cart");
		 Refresh_Cart.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {



					 String query= "Select * from PRODUCTCART";
					 PreparedStatement pst= connection.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();

					 table_1.setModel(DbUtils.resultSetToTableModel(rs));



				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }

			 }
		 });
		 Refresh_Cart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 Refresh_Cart.setBounds(1060, 160, 161, 27);
		 contentPane.add(Refresh_Cart);
		 
		 JLabel lblNewLabel_4 = new JLabel("Product_Quantity");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_4.setBounds(562, 354, 131, 23);
		 contentPane.add(lblNewLabel_4);
		 
		 JButton btnNewButton_3 = new JButton("Delete Cart");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		try {


		 			 String query= "Delete from PRODUCTCART   ";
		 			 PreparedStatement pst= connection.prepareStatement(query);
		 			 
		 			 pst.execute();
		 			 JOptionPane.showMessageDialog(null,"Deleted Successfully ");
		 			 pst.close();


		 		}  catch (Exception exception) {
		 			 exception.printStackTrace();
		 		}

		 		
		 		
		 	}
		 });
		 btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnNewButton_3.setBounds(547, 579, 146, 34);
		 contentPane.add(btnNewButton_3);
		 
		 Update_Quant = new JTextField();
		 Update_Quant.setBounds(376, 161, 137, 29);
		 contentPane.add(Update_Quant);
		 Update_Quant.setColumns(10);
		 
		 JLabel lblNewLabel_5 = new JLabel("Update_Quantity");
		 lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_5.setBounds(229, 160, 137, 29);
		 contentPane.add(lblNewLabel_5);
		 
		 JButton btnNewButton_4 = new JButton("Update");
		 btnNewButton_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		 try {


					
					 
					 String query_3= "Update AddProduct set ProductQuantity='"+Update_Quant.getText()+"' where ProductId='"+Product_ID.getText()+"' ";
					 PreparedStatement pst_3= connection.prepareStatement(query_3);
					 pst_3.execute();
					 pst_3.close();
					
					 JOptionPane.showMessageDialog(null,"Quantity updated in Stock ");


				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }
		 		
		 		
		 		
		 	}
		 });
		 btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 btnNewButton_4.setBounds(523, 166, 85, 21);
		 contentPane.add(btnNewButton_4);
		 
		 Mobile_No = new JTextField();
		 Mobile_No.setBounds(1035, 86, 186, 23);
		 contentPane.add(Mobile_No);
		 Mobile_No.setColumns(10);
		 
		 JLabel lblNewLabel_6 = new JLabel("Mobile No.");
		 lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_6.setBounds(895, 91, 120, 18);
		 contentPane.add(lblNewLabel_6);
		 this.setLocationRelativeTo(null);
	 }
}