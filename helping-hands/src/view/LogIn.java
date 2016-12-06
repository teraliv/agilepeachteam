/**
 * Author: Sean O'Donnell, Ahana Ghosh
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
import model.RecipientContainer;
import model.Donor;
import model.DonorContainer;
import model.Recipient;

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
					//frame.pack();
				    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//frame.setLocationRelativeTo(null);
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
		setResizable(true);
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

		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(177, 263, 132, 23);
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
		userNameText.setBounds(49, 130, 105, 37);
		contentPane.add(userNameText);

		JLabel passwordText = new JLabel("Password:");
		passwordText.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordText.setBackground(Color.WHITE);
		passwordText.setBounds(49, 190, 105, 37);
		contentPane.add(passwordText);

		userNameField = new JTextField();
		userNameField.setBounds(164, 142, 157, 20);
		contentPane.add(userNameField);

		userNameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 202, 157, 20);
		contentPane.add(passwordField);

		RecipientContainer  rc = RecipientContainer.getInstance();
        DonorContainer      dc = DonorContainer.getInstance();

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    //continue button code here

				//TODO if account valid use account type to load the appropriate home page
				String userNameText1 = userNameField.getText();                         // login
				String passwordText = String.valueOf(passwordField.getPassword());      // password


				//creating new window based upon log-in account type
				if(rc.isRecipient(userNameText1)) {

					Recipient r = rc.getRecipient(userNameText1);
					r.activeUser = true;

					if(!r.password.equals(passwordText)) {

						// TODO: Navigate to password mismatch error page.
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
					else
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
					}
				}
				else if(dc.isDonor(userNameText1)) {

					Donor d = dc.getDonor(userNameText1);
					d.activeUser = true;

					if(!d.password.equals(passwordText)) {

						// TODO: Navigate to password mismatch error page.
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
					else
					{
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
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
				}
				//deleting current window
				LogIn.this.dispose();
			}
		});

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

		JButton forgotPasswordButton = new JButton("Forgot Password?");
		forgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//forgot password button code here

				//creating new window (forgot password)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ForgotPassword frame = new ForgotPassword();
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
		forgotPasswordButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		forgotPasswordButton.setBounds(10, 427, 175, 23);
		contentPane.add(forgotPasswordButton);

		forgotPasswordButton.setVisible(false); //starting forgot-password button to invisible

		JButton forgotUserNameButton = new JButton("Forgot User Name?");
		forgotUserNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//forgot password button code here

				//creating new window (forgot user name)
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

				//deleting current window
				LogIn.this.dispose();
			}
		});
		forgotUserNameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		forgotUserNameButton.setBounds(10, 393, 175, 23);
		contentPane.add(forgotUserNameButton);

		forgotUserNameButton.setVisible(false); //starting forgot-user-name button to invisible

		JButton helpButton = new JButton("HELP");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//help button code here
				helpButton.setVisible(false); //hiding itself
				forgotUserNameButton.setVisible(true); //revealing forgot user name button
				forgotPasswordButton.setVisible(true); //revealing forgot password button
			}
		});
		helpButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		helpButton.setBounds(10, 427, 77, 23);
		contentPane.add(helpButton);

	}
}
