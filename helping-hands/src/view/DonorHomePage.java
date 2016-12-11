/**
 * @author Sean O'Donnell
 * @author Ahana Ghosh
 * @author Alex Terikov (teraliv@uw.edu)
 */

package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Donor;
import model.DonorContainer;
import model.Item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DonorHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField item1NameField;
	private JTextField item2NameField;
	private JTextField item3NameField;
	private JTextField item4NameField;
	private JTextField item5NameField;
	private JTextField item6NameField;
	private JTextField item1QuantityField;
	private JTextField item2QuantityField;
	private JTextField item3QuantityField;
	private JTextField item4QuantityField;
	private JTextField item5QuantityField;
	private JTextField item6QuantityField;
	private JTextPane txtpnThankYouFor;
	private JButton backButton;
	private JButton dropoffButton;
	private Donor myDonor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Donor d = new Donor("a","a","a","a","a","a","a","a","a","a","a", "a","a","a");
					//DonorHomePage frame = new DonorHomePage(d);
                    DonorHomePage frame = new DonorHomePage();
					frame.setVisible(true);
					//screen center
					final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//public DonorHomePage(Donor d) {
    public DonorHomePage() {

        DonorContainer dc = DonorContainer.getInstance();
        myDonor = dc.getActiveDonor();


        setResizable(false);
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

		String donorsName = null;
		if (myDonor != null)
		    donorsName = myDonor.firstName + " " + myDonor.lastName;
		else
		    donorsName = "Donor";

		JLabel donorNameLabel = new JLabel(donorsName); //TODO this label needs to be dynamically filled with the donor's firstName
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
							//Pickup frame = new Pickup(myDonor);
                            Pickup frame = new Pickup();

							frame.setVisible(true);
							//screen center
							final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
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
		pickupButton.setBounds(278, 96, 196, 57);
		contentPane.add(pickupButton);
		
		JButton taxFormsButton = new JButton("Tax Forms");
		taxFormsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  			//TODO tax forms button (if useful)
				//tax forms button code here
				
				//creating new window (tax forms)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//TaxForms frame = new TaxForms(myDonor);
                            TaxForms frame = new TaxForms();

                            frame.setVisible(true);
							//screen center
							final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
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
		taxFormsButton.setBounds(278, 284, 196, 57);
		contentPane.add(taxFormsButton);
		
		JTextPane dropOffLocationText = new JTextPane();
		dropOffLocationText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropOffLocationText.setText("Drop off location:\r\n3719, 64th Ave E.\r\nTacoma, WA 98444");
		dropOffLocationText.setBounds(289, 352, 175, 64);
		contentPane.add(dropOffLocationText);
		
		JLabel lblNewLabel = new JLabel("A List of Your Recent Donations:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 77, 240, 20);
		contentPane.add(lblNewLabel);
		
		JPanel pastDonationsPanel = new JPanel();
		pastDonationsPanel.setBounds(10, 96, 240, 245);
		contentPane.add(pastDonationsPanel);
		pastDonationsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		pastDonationsPanel.add(lblNewLabel_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(138, 8, 86, 20);
		pastDonationsPanel.add(lblQuantity);
		
		//TODO The 6 most recent donations need to be populated into the 12 fields below, 6 for the names and 6 for the dates
		item1NameField = new JTextField(); //TODO item 1 firstName field
		item1NameField.setEditable(false);
		item1NameField.setBounds(10, 36, 86, 20);
		pastDonationsPanel.add(item1NameField);
		item1NameField.setColumns(10);
		
		item1QuantityField = new JTextField(); //TODO item 1 date field
		item1QuantityField.setEditable(false);
		item1QuantityField.setColumns(10);
		item1QuantityField.setBounds(138, 36, 86, 20);
		pastDonationsPanel.add(item1QuantityField);


        Item localItem = null;

        if (myDonor != null) localItem = myDonor.getDonatedItem(0);

		if(localItem != null) {
			item1NameField.setText(localItem.name);
			item1QuantityField.setText(String.valueOf(localItem.quantity));
		}
		
		item2NameField = new JTextField(); //TODO item 2 firstName field
		item2NameField.setEditable(false);
		item2NameField.setColumns(10);
		item2NameField.setBounds(10, 64, 86, 20);
		pastDonationsPanel.add(item2NameField);
		
		item2QuantityField = new JTextField(); //TODO item 2 date field
		item2QuantityField.setEditable(false);
		item2QuantityField.setColumns(10);
		item2QuantityField.setBounds(138, 64, 86, 20);
		pastDonationsPanel.add(item2QuantityField);

        if (myDonor != null) localItem = myDonor.getDonatedItem(1);

		if(localItem != null) {
			item2NameField.setText(localItem.name);
			item2QuantityField.setText(String.valueOf(localItem.quantity));
		}

		item3NameField = new JTextField(); //TODO item 3 firstName field
		item3NameField.setEditable(false);
		item3NameField.setColumns(10);
		item3NameField.setBounds(10, 95, 86, 20);
		pastDonationsPanel.add(item3NameField);
		
		item3QuantityField = new JTextField(); //TODO item 3 date field
		item3QuantityField.setEditable(false);
		item3QuantityField.setColumns(10);
		item3QuantityField.setBounds(138, 95, 86, 20);
		pastDonationsPanel.add(item3QuantityField);

		if (myDonor != null) localItem = myDonor.getDonatedItem(2);

		if(localItem != null)
		{
			item3NameField.setText(localItem.name);
			item3QuantityField.setText(String.valueOf(localItem.quantity));
		}
		
		item4NameField = new JTextField(); //TODO item 4 firstName field
		item4NameField.setEditable(false);
		item4NameField.setColumns(10);
		item4NameField.setBounds(10, 126, 86, 20);
		pastDonationsPanel.add(item4NameField);
		
		item4QuantityField = new JTextField(); //TODO item 4 date field
		item4QuantityField.setEditable(false);
		item4QuantityField.setColumns(10);
		item4QuantityField.setBounds(138, 126, 86, 20);
		pastDonationsPanel.add(item4QuantityField);

		if (myDonor != null) localItem = myDonor.getDonatedItem(3);

        if(localItem != null) {
			item4NameField.setText(localItem.name);
			item4QuantityField.setText(String.valueOf(localItem.quantity));
		}
		
		item5NameField = new JTextField(); //TODO item 5 firstName field
		item5NameField.setEditable(false);
		item5NameField.setColumns(10);
		item5NameField.setBounds(10, 157, 86, 20);
		pastDonationsPanel.add(item5NameField);
		
		item5QuantityField = new JTextField(); //TODO item 5 date field
		item5QuantityField.setEditable(false);
		item5QuantityField.setColumns(10);
		item5QuantityField.setBounds(138, 157, 86, 20);
		pastDonationsPanel.add(item5QuantityField);


		if (myDonor != null) localItem = myDonor.getDonatedItem(4);

        if(localItem != null) {
			item5NameField.setText(localItem.name);
			item5QuantityField.setText(String.valueOf(localItem.quantity));
		}
		
		item6NameField = new JTextField(); //TODO item 6 firstName field
		item6NameField.setEditable(false);
		item6NameField.setColumns(10);
		item6NameField.setBounds(10, 188, 86, 20);
		pastDonationsPanel.add(item6NameField);

		item6QuantityField = new JTextField(); //TODO item 6 date field
		item6QuantityField.setEditable(false);
		item6QuantityField.setColumns(10);
		item6QuantityField.setBounds(138, 188, 86, 20);
		pastDonationsPanel.add(item6QuantityField);

		if (myDonor != null) localItem = myDonor.getDonatedItem(5);

		if(localItem != null) {
			item6NameField.setText(localItem.name);
			item6QuantityField.setText(String.valueOf(localItem.quantity));
		}


		txtpnThankYouFor = new JTextPane();
		txtpnThankYouFor.setText(" Thank You For\r\nYour Donations!");
		txtpnThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnThankYouFor.setBounds(58, 364, 156, 49);
		contentPane.add(txtpnThankYouFor);
		
		backButton = new JButton("Back");    				//TODO back button (if useful)
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here

                //myDonor.activeUser = false;
                myDonor.deactivateCurrentDonor();
				
				//creating previous window (login page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogIn frame = new LogIn();
							frame.setVisible(true);
							//screen center
							final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
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
		
		dropoffButton = new JButton("Drop-off A Donation");
		dropoffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//drop-off button code here
				
				//creating new window (drop off)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dropoff frame = new Dropoff();
							frame.setVisible(true);
							//screen center
							final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current window
				DonorHomePage.this.dispose();
			}
		});
		dropoffButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dropoffButton.setBounds(278, 188, 196, 57);
		contentPane.add(dropoffButton);
	}
}
