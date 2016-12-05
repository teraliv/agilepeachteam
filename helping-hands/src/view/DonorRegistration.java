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

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.ButtonGroup;

public class DonorRegistration extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField emailField;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;
	private final ButtonGroup maleOrFemale = new ButtonGroup();
	private JTextField businessNameField;
	private final ButtonGroup yesOrNo = new ButtonGroup();
	
    private String     firstName;
    private String     lastName;
    private String     DOBMonth;
    private String     DOBDay;
    private String     DOBYear;
    private String     gender;
    private String     street;
    private String     city;
    private String     state;
    private String     zip;
    private String     email;
    private String     business;
    private String     username;
    private String     password;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorRegistration frame = new DonorRegistration();
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
	public DonorRegistration() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDonorRegistration = new JLabel("Donor Registration");
		lblDonorRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonorRegistration.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDonorRegistration.setBackground(Color.WHITE);
		lblDonorRegistration.setBounds(10, 0, 464, 37);
		contentPane.add(lblDonorRegistration);
		
		firstNameField = new JTextField();						//TODO first firstName field
		firstNameField.setColumns(10);
		firstNameField.setBounds(114, 48, 309, 20);
		contentPane.add(firstNameField);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(28, 49, 76, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(28, 80, 76, 14);
		contentPane.add(label_2);
		
		lastNameField = new JTextField();						//TODO last firstName field
		lastNameField.setColumns(10);
		lastNameField.setBounds(114, 79, 309, 20);
		contentPane.add(lastNameField);
		
		JLabel label_3 = new JLabel("Birthday:");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(28, 111, 76, 19);
		contentPane.add(label_3);
		
		JComboBox<Object> monthPullDown = new JComboBox<Object>();		//TODO month pull down
		monthPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthPullDown.setModel(new DefaultComboBoxModel(Month.values()));
		monthPullDown.setBounds(114, 110, 95, 20);
		contentPane.add(monthPullDown);
		
		JComboBox dayPullDown = new JComboBox();						//TODO day pull down
		dayPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dayPullDown.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayPullDown.setBounds(219, 110, 95, 20);
		contentPane.add(dayPullDown);
		
		JComboBox yearPullDown = new JComboBox();						//TODO year pull down
		yearPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearPullDown.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"}));
		yearPullDown.setBounds(328, 110, 95, 20);
		contentPane.add(yearPullDown);
		
		JLabel label_4 = new JLabel("Gender:");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(28, 136, 76, 14);
		contentPane.add(label_4);
		
		JRadioButton maleButton = new JRadioButton("Male");				//TODO male button
		maleOrFemale.add(maleButton);
		maleButton.setHorizontalAlignment(SwingConstants.LEFT);
		maleButton.setBackground(Color.WHITE);
		maleButton.setBounds(114, 134, 53, 23);
		contentPane.add(maleButton);
		
		JRadioButton femaleButton = new JRadioButton("Female");			//TODO female button
		maleOrFemale.add(femaleButton);
		femaleButton.setHorizontalAlignment(SwingConstants.LEFT);
		femaleButton.setBackground(Color.WHITE);
		femaleButton.setBounds(169, 134, 66, 23);
		contentPane.add(femaleButton);
		
		streetField = new JTextField();									//TODO street field
		streetField.setColumns(10);
		streetField.setBounds(114, 160, 309, 20);
		contentPane.add(streetField);
		
		JLabel label_5 = new JLabel("Street:");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(28, 161, 76, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("City:");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(28, 189, 76, 20);
		contentPane.add(label_6);
		
		cityField = new JTextField();									//TODO cityField
		cityField.setColumns(10);
		cityField.setBounds(114, 191, 95, 20);
		contentPane.add(cityField);
		
		JLabel label_7 = new JLabel("State:");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(219, 191, 39, 20);
		contentPane.add(label_7);
		
		JComboBox statePullDown = new JComboBox();						//TODO state pull down
		statePullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statePullDown.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		statePullDown.setBounds(268, 191, 46, 20);
		contentPane.add(statePullDown);
		
		zipField = new JTextField();									//TODO zipcode field
		zipField.setColumns(10);
		zipField.setBounds(351, 191, 72, 20);
		contentPane.add(zipField);
		
		JLabel label_8 = new JLabel("Zip:");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(324, 189, 23, 20);
		contentPane.add(label_8);
		
		emailField = new JTextField();									//TODO e-mail field
		emailField.setColumns(10);
		emailField.setBounds(114, 222, 309, 20);
		contentPane.add(emailField);
		
		JLabel label_9 = new JLabel("E-Mail:");
		label_9.setHorizontalAlignment(SwingConstants.TRAILING);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(28, 223, 76, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("User Name:");
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(20, 249, 84, 14);
		contentPane.add(label_10);
		
		userNameField = new JTextField();								//TODO username field
		userNameField.setColumns(10);
		userNameField.setBounds(114, 248, 309, 20);
		contentPane.add(userNameField);
		
		JLabel label_11 = new JLabel("Password:");
		label_11.setHorizontalAlignment(SwingConstants.TRAILING);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBounds(20, 274, 84, 14);
		contentPane.add(label_11);
		
		passwordField = new JPasswordField();							//TODO password field (verify this matches the repeat password field below before accepting the password)
		passwordField.setBounds(114, 273, 309, 20);
		contentPane.add(passwordField);
		
		JLabel label_12 = new JLabel("Repeat:");
		label_12.setHorizontalAlignment(SwingConstants.TRAILING);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(10, 299, 94, 19);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Password");
		label_13.setHorizontalAlignment(SwingConstants.TRAILING);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBounds(20, 319, 84, 14);
		contentPane.add(label_13);
		
		repeatPasswordField = new JPasswordField();						//TODO repeat password field
		repeatPasswordField.setBounds(114, 300, 309, 20);
		contentPane.add(repeatPasswordField);
		
		JButton continueButton = new JButton("Continue");				//TODO continue button location, should grab all fields and create a new donor at this point
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//continue button code her
				firstName   = firstNameField.getText();
                lastName    = lastNameField.getText();
                DOBMonth    = monthPullDown.getSelectedItem().toString();
                DOBDay      = dayPullDown.getSelectedItem().toString();
                DOBYear     = yearPullDown.getSelectedItem().toString();
                gender      = "U";
                street      = streetField.getText();
                city        = cityField.getText();
                state       = statePullDown.getSelectedItem().toString();
                zip         = zipField.getText();
                email       = emailField.getText();
                business    = businessNameField.getText();
                username    = userNameField.getText();
                password    = String.valueOf(passwordField.getPassword());
                
                Donor donor = new Donor(
                        firstName, lastName, DOBMonth, DOBDay, DOBYear, gender, street,
                        city, state, zip, email, business, username, password);
                
                DonorContainer donorInstance = DonorContainer.getInstance();
                if(donorInstance.isDonor(username)){
                	// TODO: navigate to a user already exists page.
                	return;
                }
                
                donorInstance.addDonor(donor);

				//creating next window (donor home page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//DonorHomePage frame = new DonorHomePage(donor);
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
				DonorRegistration.this.dispose();
				
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(169, 427, 132, 23);
		contentPane.add(continueButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (recipient or donor)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RecipientOrDonor frame = new RecipientOrDonor();
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
				DonorRegistration.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		JLabel lblAreYouA = new JLabel("Are you a buisness owner?");
		lblAreYouA.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAreYouA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreYouA.setBounds(137, 328, 189, 20);
		contentPane.add(lblAreYouA);
		
		businessNameField = new JTextField();						//TODO business firstName field
		businessNameField.setBounds(114, 385, 309, 20);
		contentPane.add(businessNameField);
		
		JLabel lblBusinessName = new JLabel("Business:");
		lblBusinessName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBusinessName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBusinessName.setBounds(10, 386, 94, 14);
		contentPane.add(lblBusinessName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(20, 402, 84, 14);
		contentPane.add(lblName);
		
		//starting these elements hidden
		lblName.setVisible(false);
		lblBusinessName.setVisible(false);
		businessNameField.setVisible(false);
		
		JRadioButton yesButton = new JRadioButton("Yes");				//TODO if this is selected add buisness firstName from buisness firstName field above
		yesOrNo.add(yesButton);
		yesButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//yes button button code here
			boolean selected=yesButton.isSelected();
			lblName.setVisible(selected);
			lblBusinessName.setVisible(selected);
			businessNameField.setVisible(selected);
			}
		});
		yesButton.setHorizontalAlignment(SwingConstants.CENTER);
		yesButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yesButton.setBackground(Color.WHITE);
		yesButton.setBounds(169, 355, 66, 23);
		contentPane.add(yesButton);
		
		
		JRadioButton noButton = new JRadioButton("No");
		noButton.setSelected(true);
		yesOrNo.add(noButton);
		noButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//no button button code here
			boolean selected=!noButton.isSelected();
			lblName.setVisible(selected);
			lblBusinessName.setVisible(selected);
			businessNameField.setVisible(selected);
			}
		});
		noButton.setHorizontalAlignment(SwingConstants.CENTER);
		noButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noButton.setBackground(Color.WHITE);
		noButton.setBounds(248, 355, 53, 23);
		contentPane.add(noButton);
		

	}
}
