/**
 * Author: Sean O'Donnell
 */

package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the LogIn frame.
	 */
	public LogIn() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{//continue button code here
				//TODO if account valid use account type to load the appropriate home page
				
				//creating new window based upon log-in account type
				/*if(Recipient)
				{
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
				}*/
				
				/*if(Donor)
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								RecipientHomePage frame = new DonorHomePage();
								frame.setVisible(true);
								//screen center
								final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
								frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}*/
				
				/*if(Administrator)
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								RecipientHomePage frame = new AdministratorHomePage();
								frame.setVisible(true);
								//screen center
								final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
								frame.setLocation(dim.width/2 - frame.getSize().width/2 , dim.height/2 - frame.getSize().height/2);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}*/
				
				//temp code for demonstration
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
				LogIn.this.dispose();
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(162, 361, 132, 23);
		contentPane.add(continueButton);
		
		JLabel enterAccountText = new JLabel("Please Enter Your Account Information");
		enterAccountText.setBackground(Color.WHITE);
		enterAccountText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		enterAccountText.setHorizontalAlignment(SwingConstants.CENTER);
		enterAccountText.setBounds(10, 37, 464, 37);
		contentPane.add(enterAccountText);
		
		JLabel userNameText = new JLabel("User Name:");
		userNameText.setBackground(Color.WHITE);
		userNameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userNameText.setHorizontalAlignment(SwingConstants.RIGHT);
		userNameText.setBounds(50, 194, 105, 37);
		contentPane.add(userNameText);
		
		JLabel passwordText = new JLabel("Password:");
		passwordText.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordText.setBackground(Color.WHITE);
		passwordText.setBounds(50, 254, 105, 37);
		contentPane.add(passwordText);
		
		userNameField = new JTextField();
		userNameField.setBounds(165, 206, 157, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 266, 157, 20);
		contentPane.add(passwordField);
		
		/**back button hides the login screen and makes visible the welcome screen*/
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//back button code
				
				LogIn.this.dispose(); //deleting current login frame
				
				//launching new welcome (to go back)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WelcomePage frame = new WelcomePage();
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
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
	}
}
