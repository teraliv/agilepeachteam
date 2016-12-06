/**
 * @author Sean O'Donnell
 * @author Ahana Ghosh
 * @author Alex Terikov (teraliv@uw.edu)
 */

package view;

import model.FileWriter;
import model.Recipient;
import model.RecipientContainer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RecipientRegistration extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private final ButtonGroup maleOrFemale = new ButtonGroup();
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField emailField;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;

	// fields added by @teraliv
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
    private String     username;
    private String     password;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipientRegistration frame = new RecipientRegistration();
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
	public RecipientRegistration() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTellUsAbout = new JLabel("Tell us about yourself");
		lblTellUsAbout.setBounds(10, 11, 464, 37);
		lblTellUsAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTellUsAbout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTellUsAbout.setBackground(Color.WHITE);
		contentPane.add(lblTellUsAbout);
		
		firstNameField = new JTextField();				//TODO First firstName field
		firstNameField.setBounds(104, 77, 309, 20);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(18, 78, 76, 14);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblFirstName);
		
		lastNameField = new JTextField();				//TODO Last lastName field
		lastNameField.setBounds(104, 108, 309, 20);
		lastNameField.setColumns(10);
		contentPane.add(lastNameField);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(18, 109, 76, 14);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblLastName);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(18, 140, 76, 19);
		lblBirthday.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblBirthday);
		
		JList list = new JList();
		list.setBounds(104, 157, 76, -21);
		list.setBackground(Color.LIGHT_GRAY);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);

		// MONTH
		JComboBox monthPullDown = new JComboBox();			//TODO month pull down
        monthPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthPullDown.setBounds(104, 139, 95, 20);
		monthPullDown.setModel(new DefaultComboBoxModel(Month.values()));
		contentPane.add(monthPullDown);


        // DAY
		JComboBox dayPullDown = new JComboBox();			//TODO day pull down
		dayPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dayPullDown.setBounds(209, 139, 95, 20);
		dayPullDown.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		contentPane.add(dayPullDown);


		// YEAR
		JComboBox yearPullDown = new JComboBox();			//TODO year pull down
		yearPullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearPullDown.setBounds(318, 139, 95, 20);
		yearPullDown.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"}));
		contentPane.add(yearPullDown);

		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(18, 165, 76, 14);
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblGender);

		// GENDER
		JRadioButton maleButton = new JRadioButton("Male");	//TODO male button
		maleButton.setBounds(104, 163, 53, 23);
		maleButton.setHorizontalAlignment(SwingConstants.LEFT);
		maleOrFemale.add(maleButton);
		maleButton.setBackground(Color.WHITE);
		contentPane.add(maleButton);

		
		JRadioButton femaleButton = new JRadioButton("Female"); //TODO female button
		femaleButton.setBounds(159, 163, 66, 23);
		femaleButton.setHorizontalAlignment(SwingConstants.LEFT);
		maleOrFemale.add(femaleButton);
		femaleButton.setBackground(Color.WHITE);
		contentPane.add(femaleButton);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setBounds(18, 190, 76, 14);
		lblStreet.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblStreet);

		// STREET
		streetField = new JTextField();						//TODO Street field
		streetField.setBounds(104, 189, 309, 20);
		streetField.setColumns(10);
		contentPane.add(streetField);


		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(18, 218, 76, 20);
		lblCity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCity);

        // CITY
		cityField = new JTextField();						//TODO City field
		cityField.setBounds(104, 220, 95, 20);
		cityField.setColumns(10);
		contentPane.add(cityField);


		JLabel lblState = new JLabel("State:");
		lblState.setBounds(209, 220, 39, 20);
		lblState.setHorizontalAlignment(SwingConstants.TRAILING);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblState);

        // STATE
		JComboBox statePullDown = new JComboBox();			//TODO state pull down
		statePullDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statePullDown.setBounds(258, 220, 46, 20);
		statePullDown.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		contentPane.add(statePullDown);


        JLabel lblZip = new JLabel("Zip:");
		lblZip.setBounds(314, 218, 23, 20);
		lblZip.setHorizontalAlignment(SwingConstants.TRAILING);
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblZip);

        // ZIP
		zipField = new JTextField();						//TODO zip-code field known as zipField
		zipField.setBounds(341, 220, 72, 20);
		zipField.setColumns(10);
		contentPane.add(zipField);

		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(18, 252, 76, 14);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblEmail);

		// EMAIL
		emailField = new JTextField();						//TODO e-mail field
		emailField.setBounds(104, 251, 309, 20);
		emailField.setColumns(10);
		contentPane.add(emailField);


		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(10, 278, 84, 14);
		lblUserName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblUserName);

		// USERNAME
		userNameField = new JTextField();					//TODO user firstName field
		userNameField.setBounds(104, 277, 309, 20);
		userNameField.setColumns(10);
		contentPane.add(userNameField);

		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 303, 84, 14);
		contentPane.add(lblPassword);
		
															//TODO need to ensure the two pasword fields match
		passwordField = new JPasswordField();				//TODO password Field
		passwordField.setBounds(104, 302, 309, 20);
		contentPane.add(passwordField);
		
		repeatPasswordField = new JPasswordField();			//TODO repeat password field
		repeatPasswordField.setBounds(104, 329, 309, 20);
		contentPane.add(repeatPasswordField);

		
		JLabel repeatlbl = new JLabel("Repeat:");
		repeatlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		repeatlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		repeatlbl.setBounds(0, 328, 94, 19);
		contentPane.add(repeatlbl);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(10, 348, 84, 14);
		contentPane.add(lblPassword_1);



        JButton continueButton = new JButton("Continue");	//TODO continue button (if useful)
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//continue button code here
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
                username    = userNameField.getText();
                password    = String.valueOf(passwordField.getPassword());

                // create new recipient
                Recipient recipient = new Recipient(
                        firstName, lastName, DOBMonth, DOBDay, DOBYear, gender, street,
                        city, state, zip, email, username, password);

                // make recipient active
                recipient.activeUser = true;

                // add recipient to the list of all recipients
                RecipientContainer rc = RecipientContainer.getInstance();

                if(rc.isRecipient(username)){
                	// TODO: navigate to a user already exists page.
                	return;
                }
                
                rc.addRecipient(recipient);

                FileWriter fw = new FileWriter();
                fw.writeNewRecipient(recipient);


                // If we are here, then it's guaranteed that this user does not exist.
				//creating new window (recipient home page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RecipientHomePage frame = new RecipientHomePage();
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
				RecipientRegistration.this.dispose();
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(176, 389, 132, 23);
		contentPane.add(continueButton);
		
		JButton backButton = new JButton("Back");		//TODO back button (if useful)
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window
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
				RecipientRegistration.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
	}
}
