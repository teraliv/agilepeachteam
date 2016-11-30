import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonorHomePage extends JFrame {

	private JPanel contentPane;
	private JTextField item1NameField;
	private JTextField item2NameField;
	private JTextField item3NameField;
	private JTextField item4NameField;
	private JTextField item5NameField;
	private JTextField item1DateField;
	private JTextField item2DateField;
	private JTextField item3DateField;
	private JTextField item4DateField;
	private JTextField item5DateField;
	private JTextField item6NameField;
	private JTextField item6DateField;
	private JTextPane txtpnThankYouFor;
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorHomePage frame = new DonorHomePage();
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
	public DonorHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome ");
		welcomeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		welcomeLabel.setBackground(Color.WHITE);
		welcomeLabel.setBounds(113, 11, 137, 37);
		contentPane.add(welcomeLabel);
		
		JLabel donorNameLabel = new JLabel("Donor"); //TODO this label needs to be dynamically filled with the donor's name
		donorNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		donorNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		donorNameLabel.setBackground(Color.WHITE);
		donorNameLabel.setBounds(260, 11, 137, 37);
		contentPane.add(donorNameLabel);
		
		JButton pickupButton = new JButton("Schedule a Pickup");  //TODO pickup button (if useful)
		pickupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pickup button code here
				
				//creating new window (pickup)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Pickup frame = new Pickup();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current window
				DonorHomePage.this.dispose();
			}
		});
		pickupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pickupButton.setBounds(289, 123, 185, 57);
		contentPane.add(pickupButton);
		
		JButton taxFormsButton = new JButton("Tax Forms");
		taxFormsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  			//TODO tax forms button (if useful)
				//tax forms button code here
				
				//creating new window (tax forms)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TaxForms frame = new TaxForms();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current window
				DonorHomePage.this.dispose();
				
			}
		});
		taxFormsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taxFormsButton.setBounds(289, 219, 185, 57);
		contentPane.add(taxFormsButton);
		
		JTextPane dropOffLocationText = new JTextPane();
		dropOffLocationText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropOffLocationText.setText("Drop off location:\r\n3719, 64th Ave E.\r\nTacoma, WA 98444");
		dropOffLocationText.setBounds(289, 304, 175, 64);
		contentPane.add(dropOffLocationText);
		
		JLabel lblNewLabel = new JLabel("A List of Your Recent Donations:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 104, 240, 20);
		contentPane.add(lblNewLabel);
		
		JPanel pastDonationsPanel = new JPanel();
		pastDonationsPanel.setBounds(10, 123, 240, 245);
		contentPane.add(pastDonationsPanel);
		pastDonationsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		pastDonationsPanel.add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(138, 11, 46, 14);
		pastDonationsPanel.add(lblDate);
		
		//TODO The 6 most recent donations need to be populated into the 12 fields below, 6 for the names and 6 for the dates
		item1NameField = new JTextField(); //TODO item 1 name field
		item1NameField.setEditable(false);
		item1NameField.setBounds(10, 36, 86, 20);
		pastDonationsPanel.add(item1NameField);
		item1NameField.setColumns(10);
		
		item2NameField = new JTextField(); //TODO item 2 name field
		item2NameField.setEditable(false);
		item2NameField.setColumns(10);
		item2NameField.setBounds(10, 64, 86, 20);
		pastDonationsPanel.add(item2NameField);
		
		item3NameField = new JTextField(); //TODO item 3 name field
		item3NameField.setEditable(false);
		item3NameField.setColumns(10);
		item3NameField.setBounds(10, 95, 86, 20);
		pastDonationsPanel.add(item3NameField);
		
		item4NameField = new JTextField(); //TODO item 4 name field
		item4NameField.setEditable(false);
		item4NameField.setColumns(10);
		item4NameField.setBounds(10, 126, 86, 20);
		pastDonationsPanel.add(item4NameField);
		
		item5NameField = new JTextField(); //TODO item 5 name field
		item5NameField.setEditable(false);
		item5NameField.setColumns(10);
		item5NameField.setBounds(10, 157, 86, 20);
		pastDonationsPanel.add(item5NameField);
		
		item6NameField = new JTextField(); //TODO item 6 name field
		item6NameField.setEditable(false);
		item6NameField.setColumns(10);
		item6NameField.setBounds(10, 188, 86, 20);
		pastDonationsPanel.add(item6NameField);
		
		item1DateField = new JTextField(); //TODO item 1 date field
		item1DateField.setEditable(false);
		item1DateField.setColumns(10);
		item1DateField.setBounds(138, 36, 86, 20);
		pastDonationsPanel.add(item1DateField);
		
		item2DateField = new JTextField(); //TODO item 2 date field
		item2DateField.setEditable(false);
		item2DateField.setColumns(10);
		item2DateField.setBounds(138, 64, 86, 20);
		pastDonationsPanel.add(item2DateField);
		
		item3DateField = new JTextField(); //TODO item 3 date field
		item3DateField.setEditable(false);
		item3DateField.setColumns(10);
		item3DateField.setBounds(138, 95, 86, 20);
		pastDonationsPanel.add(item3DateField);
		
		item4DateField = new JTextField(); //TODO item 4 date field
		item4DateField.setEditable(false);
		item4DateField.setColumns(10);
		item4DateField.setBounds(138, 126, 86, 20);
		pastDonationsPanel.add(item4DateField);
		
		item5DateField = new JTextField(); //TODO item 5 date field
		item5DateField.setEditable(false);
		item5DateField.setColumns(10);
		item5DateField.setBounds(138, 157, 86, 20);
		pastDonationsPanel.add(item5DateField);
		
		item6DateField = new JTextField(); //TODO item 6 date field
		item6DateField.setEditable(false);
		item6DateField.setColumns(10);
		item6DateField.setBounds(138, 188, 86, 20);
		pastDonationsPanel.add(item6DateField);
		
		txtpnThankYouFor = new JTextPane();
		txtpnThankYouFor.setText(" Thank You For\r\nYour Donations!");
		txtpnThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnThankYouFor.setBounds(57, 379, 156, 64);
		contentPane.add(txtpnThankYouFor);
		
		backButton = new JButton("Back");    				//TODO back button (if useful)
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (login page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogIn frame = new LogIn();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current window
				DonorHomePage.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
	}
}
