import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class Shop extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
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
	public Shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnNewButton_1 = new JButton("PURCHASE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Purchase_Order purchase = new Purchase_Order();
				purchase.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		btnNewButton_1.setBounds(33, 255, 195, 90);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CUSTOMER INFORMATION");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer_Information information = new Customer_Information();
				information.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		btnNewButton_2.setBounds(33, 393, 266, 85);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOG OUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int a = JOptionPane.showConfirmDialog( btnNewButton_3, "Are you sure");
				if(a==JOptionPane.YES_OPTION){
					dispose();
					FrontPage front = new FrontPage();
				
					
				}
				else{
					
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton_3.setBounds(840, 518, 107, 35);
		contentPane.add(btnNewButton_3);
		
		JLabel lblElectronicShop = new JLabel("ELECTRONICS INVENTORY");
		lblElectronicShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectronicShop.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblElectronicShop.setBounds(231, 10, 562, 74);
		contentPane.add(lblElectronicShop);
		
		JButton btnNewButton = new JButton("STOCK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Stock stock = new Stock();
				stock.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		btnNewButton.setBounds(33, 131, 195, 79);
		contentPane.add(btnNewButton);
		
	    lblNewLabel = new JLabel("");
	    Image img = new ImageIcon(this.getClass().getResource("image1-.jpg")).getImage();
	    lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(326, 72, 621, 437);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(488, 148, 115, 223);
		contentPane.add(lblNewLabel_1);
		
	}
}