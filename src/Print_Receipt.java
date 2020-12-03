import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class Print_Receipt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextArea txtrThankYou;
	private JTable table_1;
	// JTextComponent Customer_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print_Receipt frame = new Print_Receipt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public void DeleteProductCart(){
			String url = "jdbc:mysql://localhost:3306/inventory";
			String uname = "khan";
			String password = "Bhopal@06";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,password);
				String query = "Delete from PRODUCTCART";
				PreparedStatement pst = con.prepareStatement(query);
				pst.execute();
				pst.close();
				
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void DeletePurchase(){
			String url= "jdbc:mysql://localhost:3306/inventory";
			String uname = "khan";
			String password="Bhopal@06";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,password);
				String query = "Delete from Purchase";
				PreparedStatement ps = con.prepareStatement(query);
				ps.execute();
				ps.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	
	//String CustomerID;
	Connection connection=null;
	private JTable table_2;

	
	
	public Print_Receipt() {
		
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "khan", "Bhopal@06");
			//JOptionPane.showMessageDialog(null,"database connected");
			
			
		}  catch (Exception exception) {
            exception.printStackTrace();
        }
		
	
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 650, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrElectronicsShop = new JTextArea();
		txtrElectronicsShop.setText("                    ELECTRONICS SHOP\r\n************************************************************\r\n           Plot No-14-D, Sector-50A, Viman Nagar,\r\n              Bhopal, Madhya Pradesh, PIN-411015\r\n                     Ph No.- 070-9546783\r\n************************************************************");
		txtrElectronicsShop.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtrElectronicsShop.setBounds(10, 10, 616, 148);
		contentPane.add(txtrElectronicsShop);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 616, 52);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtrThankYou = new JTextArea();
		txtrThankYou.setText("***********************************************************\r\n                      Thank You Visit Again\r\n***********************************************************");
		txtrThankYou.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrThankYou.setBounds(10, 671, 616, 62);
		contentPane.add(txtrThankYou);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 233, 616, 328);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Total ( in Rs)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {


					 String query= "Select * from PRODUCTCART";
					 PreparedStatement pst= connection.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();

					 table_1.setModel(DbUtils.resultSetToTableModel(rs));

					



				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }
				
				try {


					 String query= "Select * from Purchase  ";
					 PreparedStatement pst= connection.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();

					 table.setModel(DbUtils.resultSetToTableModel(rs));

					



				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }
				
				try {


					 String query= "SELECT 	SUM(Total)  Amount FROM	PRODUCTCART ";
					 PreparedStatement pst= connection.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();

					 table_2.setModel(DbUtils.resultSetToTableModel(rs));

					



				 }  catch (Exception exception) {
					 exception.printStackTrace();
				 }
			
				DeleteProductCart();
				DeletePurchase();
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(287, 606, 140, 43);
		contentPane.add(btnNewButton);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		table_2.setShowVerticalLines(false);
		table_2.setShowHorizontalLines(false);
		table_2.setShowGrid(false);
		table_2.setBounds(441, 611, 163, 38);
		contentPane.add(table_2);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Purchase_Order order = new Purchase_Order();
				order.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(57, 606, 145, 43);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
