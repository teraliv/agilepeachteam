package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;

public class Dropoff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quantityField;
	private JTextField costField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public Dropoff() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel thankYouPanel = new JPanel();
		thankYouPanel.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		thankYouPanel.setBackground(SystemColor.textHighlightText);
		thankYouPanel.setBounds(81, 86, 300, 290);
		contentPane.add(thankYouPanel);
		thankYouPanel.setLayout(null);
		
		JLabel lblThankYouFor = new JLabel("Thank You For");
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblThankYouFor.setBounds(46, 11, 208, 29);
		thankYouPanel.add(lblThankYouFor);
		
		JLabel lblYourDonation = new JLabel("Your Donation!");
		lblYourDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourDonation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblYourDonation.setBounds(46, 51, 208, 29);
		thankYouPanel.add(lblYourDonation);
		
		JButton thankYouContinueButton = new JButton("Continue");
		thankYouContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thank you continue button code here 
				
				//creating previous window (the donor home page)
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

				//deleting current window)
				Dropoff.this.dispose();
			}
		});
		thankYouContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		thankYouContinueButton.setBounds(85, 225, 132, 23);
		thankYouPanel.add(thankYouContinueButton);
		
		//starting the thank you panel hidden
		thankYouPanel.setVisible(false);
		
		JLabel lblDonationDropoff = new JLabel("Donation Drop-off");
		lblDonationDropoff.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDonationDropoff.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonationDropoff.setBounds(131, 11, 208, 29);
		contentPane.add(lblDonationDropoff);
		
		JComboBox<Object> categoryPullDown = new JComboBox<Object>();							//TODO this pull down needs to be populated with the categories of the inventory
		categoryPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		categoryPullDown.setModel(new DefaultComboBoxModel<Object>(new String[] {"Insert categories here", "<inventory category types>"}));
		categoryPullDown.setBounds(131, 159, 208, 29);
		contentPane.add(categoryPullDown);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to drop off?");
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWhatWouldYou.setBounds(98, 102, 283, 29);
		contentPane.add(lblWhatWouldYou);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(12, 159, 112, 29);
		contentPane.add(lblCategory);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(12, 199, 112, 29);
		contentPane.add(lblQuantity);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCost.setBounds(12, 239, 112, 29);
		contentPane.add(lblCost);
		
		quantityField = new JTextField();				//TODO this field will contain the quantity of the donated item
		quantityField.setToolTipText("Please enter the amount in a whole number");
		quantityField.setBounds(131, 199, 208, 29);
		contentPane.add(quantityField);
		quantityField.setColumns(10);
		
		costField = new JTextField();					//TODO this field will contain the cost of the donated item
		costField.setToolTipText("Please omit the $ sign, and use numbers   EG)  5.53");
		costField.setColumns(10);
		costField.setBounds(131, 239, 208, 29);
		contentPane.add(costField);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (donor home page)
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
				
				//deleting current window
				Dropoff.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		JButton continueButton = new JButton("Continue");		//TODO when the continue button is pressed, the item described in the fields should be added to the inventory
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//continue button code here
				thankYouPanel.setVisible(true);
				continueButton.setVisible(false); //hiding the first continue button because otherwise it bleeds through the overlapping panel which says thank you
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(169, 340, 132, 23);
		contentPane.add(continueButton);
	}
}
