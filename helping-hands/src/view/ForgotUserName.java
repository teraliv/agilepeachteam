/**
 * Author Sean O'Donnell
 */
package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

public class ForgotUserName extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField addressField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotUserName frame = new ForgotUserName();
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
	public ForgotUserName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel userNamePanel = new JPanel();
		userNamePanel.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		userNamePanel.setBackground(Color.WHITE);
		userNamePanel.setBounds(89, 127, 301, 252);
		contentPane.add(userNamePanel);
		userNamePanel.setLayout(null);
		
		userNamePanel.setVisible(false); //starting the userName pop up panel to be invisible
		
		JLabel lblNewLabel_2 = new JLabel("Your User Name Is:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 11, 281, 37);
		userNamePanel.add(lblNewLabel_2);
		
		JLabel userNameLabel = new JLabel("[User Name]");							//TODO this needs to be populated with plain text of a user's user-name if they verified their information
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setBounds(10, 103, 281, 43);
		userNamePanel.add(userNameLabel);
		
		JButton userNameContinue = new JButton("Continue");
		userNameContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//user name continue button code here
				
				//creating previous window (login)
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
				ForgotUserName.this.dispose();
			}
		});
		userNameContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userNameContinue.setBounds(85, 200, 132, 23);
		userNamePanel.add(userNameContinue);
		
		JPanel errorPanel = new JPanel();
		errorPanel.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		errorPanel.setBackground(Color.WHITE);
		errorPanel.setBounds(89, 127, 301, 252);
		contentPane.add(errorPanel);
		errorPanel.setLayout(null);
		
		//starting the error panel invisible 
		errorPanel.setVisible(false);
		
		JLabel lblOops = new JLabel("oops!");
		lblOops.setHorizontalAlignment(SwingConstants.CENTER);
		lblOops.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblOops.setBounds(10, 11, 281, 53);
		errorPanel.add(lblOops);
		
		JTextPane errorTextPane = new JTextPane();
		errorTextPane.setEditable(false);
		errorTextPane.setText("The information you entered doesn't \r\n seem to match an existing account.");
		errorTextPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		errorTextPane.setBounds(10, 63, 281, 114);
		errorPanel.add(errorTextPane);
		
		JLabel lblNewLabel = new JLabel("Forgot User Name?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 464, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please fill out the following information to retrieve your user name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 61, 484, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(22, 167, 84, 25);
		contentPane.add(lblName);
		
		nameField = new JTextField();								//TODO name field
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameField.setBounds(116, 167, 264, 25);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(37, 203, 69, 25);
		contentPane.add(lblAddress);
		
		addressField = new JTextField();							//TODO address field
		addressField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressField.setColumns(10);
		addressField.setBounds(116, 203, 264, 25);
		contentPane.add(addressField);
		
		JButton continueButton = new JButton("Continue");			//TODO needs to take from the name field and address field and check database if valid if so display username, else say wrong info
		continueButton.addActionListener(new ActionListener() {		//TODO code for this is half implemented below
			public void actionPerformed(ActionEvent e) {
				//continue button code here
				continueButton.setVisible(false); //setting the main continue button temporarily invisible as to not bleed through the overlapping panel 
				nameField.setText(""); //emptying the fields
				addressField.setText("");
				addressField.setVisible(false);//temporarily setting the address field invisible to stop it from bleeding through the error panel
				nameField.setVisible(false);
				//if(valid)
				{
					//userNamePanel.setVisible(true);
				}
				//else
				{
					errorPanel.setVisible(true);
				}
				
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(176, 336, 132, 23);
		contentPane.add(continueButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (login)
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
				ForgotUserName.this.dispose();
				
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		JButton errorContinueButton = new JButton("Continue");
		errorContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//error button code here
				errorPanel.setVisible(false); //hiding the error pane pop up
				continueButton.setVisible(true);
				addressField.setVisible(true); //makeing re-visable the address field which was made invis to stop bleed through the error panel
				nameField.setVisible(true);
				
			}
		});
		errorContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		errorContinueButton.setBounds(86, 179, 132, 23);
		errorPanel.add(errorContinueButton);
		
		
	}
}
