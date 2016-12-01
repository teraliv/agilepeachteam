/**
 * Author: Sean O'Donnell
 */

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

public class Pickup extends JFrame {

	private JPanel contentPane;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField quantityField;
	private JTextField costField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	}

	/**
	 * Create the frame.
	 */
	public Pickup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel confirmationPanel = new JPanel();
		confirmationPanel.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		confirmationPanel.setBackground(Color.WHITE);
		confirmationPanel.setBounds(95, 76, 293, 350);
		contentPane.add(confirmationPanel);
		confirmationPanel.setLayout(null);
		
		confirmationPanel.setVisible(false); //starting the confirmation panel hidden
		
		JButton verificationContinue = new JButton("Continue");
		verificationContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verification continue button code here
				
				//creating previous window (donor home page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
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
				
				//deleting current window
				Pickup.this.dispose();
			}
		});
		verificationContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		verificationContinue.setBounds(82, 295, 132, 23);
		confirmationPanel.add(verificationContinue);
		
		JTextPane txtpnYourPickupHas = new JTextPane();
		txtpnYourPickupHas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnYourPickupHas.setText("      Your pickup has been \r\n               scheduled\r\n\r\n\r\n\r\n Thank you for you donation!");
		txtpnYourPickupHas.setBounds(10, 11, 273, 273);
		confirmationPanel.add(txtpnYourPickupHas);
		
		JLabel lblNewLabel = new JLabel("Note: This service is only available for goods with greater than $200 in value.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 48, 494, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Schedule a Pickup");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 474, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setBounds(59, 87, 46, 14);
		contentPane.add(lblDate);
		
		JComboBox monthPullDown = new JComboBox();										//TODO month pull down
		monthPullDown.setModel(new DefaultComboBoxModel(Month.values()));
		monthPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthPullDown.setBounds(115, 86, 100, 20);
		contentPane.add(monthPullDown);
		
		JComboBox dayPullDown = new JComboBox();										//TODO day pull down
		dayPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dayPullDown.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayPullDown.setBounds(225, 86, 46, 20);
		contentPane.add(dayPullDown);
		
		JComboBox yearPullDown = new JComboBox();										//TODO year pull down
		yearPullDown.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017"}));
		yearPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearPullDown.setBounds(281, 86, 88, 20);
		contentPane.add(yearPullDown);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(59, 113, 46, 14);
		contentPane.add(lblTime);
		
		JComboBox hourPullDown = new JComboBox();										//TODO hour pull down
		hourPullDown.setModel(new DefaultComboBoxModel(new String[] {"Hour", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		hourPullDown.setToolTipText("Hour");
		hourPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hourPullDown.setBounds(114, 110, 58, 20);
		contentPane.add(hourPullDown);
		
		JComboBox minPullDown = new JComboBox();										//TODO min pull down
		minPullDown.setModel(new DefaultComboBoxModel(new String[] {"Min", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		minPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minPullDown.setBounds(182, 110, 58, 20);
		contentPane.add(minPullDown);
		
		JComboBox ampmPullDown = new JComboBox();										//TODO am/pm pull down
		ampmPullDown.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		ampmPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ampmPullDown.setBounds(250, 110, 58, 20);
		contentPane.add(ampmPullDown);
		
		JLabel lblPickupAddress = new JLabel("Pickup Address");
		lblPickupAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickupAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickupAddress.setBounds(56, 150, 249, 28);
		contentPane.add(lblPickupAddress);
		
		JLabel label = new JLabel("Street:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(49, 188, 56, 14);
		contentPane.add(label);
		
		streetField = new JTextField();													//TODO street field
		streetField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		streetField.setColumns(10);
		streetField.setBounds(115, 187, 309, 20);
		contentPane.add(streetField);
		
		cityField = new JTextField();													//TODO city field
		cityField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityField.setColumns(10);
		cityField.setBounds(115, 218, 95, 20);
		contentPane.add(cityField);
		
		JLabel label_1 = new JLabel("City:");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(69, 216, 36, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("State:");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(220, 218, 39, 20);
		contentPane.add(label_2);
		
		JComboBox statePullDown = new JComboBox();										//TODO state pull down
		statePullDown.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		statePullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statePullDown.setBounds(269, 218, 46, 20);
		contentPane.add(statePullDown);
		
		zipField = new JTextField();													//TODO zip field
		zipField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		zipField.setColumns(10);
		zipField.setBounds(352, 218, 72, 20);
		contentPane.add(zipField);
		
		JLabel label_3 = new JLabel("Zip:");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(325, 216, 23, 20);
		contentPane.add(label_3);
		
		JLabel lblWhatAreYou = new JLabel("What are you donating?");
		lblWhatAreYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatAreYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWhatAreYou.setBounds(99, 260, 249, 28);
		contentPane.add(lblWhatAreYou);
		
		JComboBox<Object> categoryPullDown = new JComboBox<Object>();					//TODO fill this pull down with the categories of the inventory
		categoryPullDown.setModel(new DefaultComboBoxModel(new String[] {"Inventory categories here", "<category>", "<category>"}));
		categoryPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		categoryPullDown.setBounds(119, 299, 208, 20);
		contentPane.add(categoryPullDown);
		
		JLabel label_4 = new JLabel("Category:");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(0, 292, 112, 29);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Quantity:");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(0, 332, 112, 29);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Cost:");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(0, 372, 112, 29);
		contentPane.add(label_6);
		
		quantityField = new JTextField();												//TODO Quantity field, verify is a number
		quantityField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantityField.setToolTipText("Please enter the amount in a whole number");
		quantityField.setColumns(10);
		quantityField.setBounds(119, 332, 208, 20);
		contentPane.add(quantityField);
		
		costField = new JTextField();													//TODO cost field, verify is a number
		costField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		costField.setToolTipText("Please omit the $ sign, and use numbers   EG)  5.53");
		costField.setColumns(10);
		costField.setBounds(119, 372, 208, 20);
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
							//screen center
							final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current page
				Pickup.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(395, 437, 89, 23);
		contentPane.add(backButton);
		
		JButton continueButton = new JButton("Continue");								//TODO create a new item (in the future?) and add to inventory when continue is pressed
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//continue button code here
				confirmationPanel.setVisible(true);
				continueButton.setVisible(false); //hiding the first continue button so it doesn't bleed through the confirmation panel
				backButton.setEnabled(false); //you can't press back, you have to press continue
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(163, 403, 132, 23);
		contentPane.add(continueButton);
	}

}
