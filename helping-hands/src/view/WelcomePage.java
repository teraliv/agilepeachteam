/**
 * @author Sean O'Donnell
 * @author Ahana Gnosh
 * @author Alex Terikov (teraliv@uw.edu)
 */

package view;

import model.FileReader;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public WelcomePage() {

        // @teraliv
	    FileReader fr = new FileReader();   // File reader to read data files
        fr.readDonorsFile();                // Read donors from a file
        fr.readRecipientsFile();            // Read recipients from a file
        fr.readDonatedItemsFile();          // Read donated items file
        fr.readInvetoryFile();              // Read inventory data file


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
		
		final JRadioButton yesButton = new JRadioButton("Yes");
		buttonGroup.add(yesButton);
		yesButton.setHorizontalAlignment(SwingConstants.CENTER);
		yesButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yesButton.setBackground(Color.WHITE);
		yesButton.setBounds(94, 268, 109, 23);
		contentPane.add(yesButton);
		
		final JRadioButton noButton = new JRadioButton("No");
		buttonGroup.add(noButton);
		noButton.setHorizontalAlignment(SwingConstants.CENTER);
		noButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noButton.setBackground(Color.WHITE);
		noButton.setBounds(252, 268, 109, 23);
		contentPane.add(noButton);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//continue button code here
				if(yesButton.isSelected())
				{
					//creating new login window
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
					WelcomePage.this.dispose();// deleting old window
				}
				else if (noButton.isSelected())//new account (recipient or donor)
				{
					//creating RecipientOrDonor page
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
					WelcomePage.this.dispose();// deleting old window
				}
				
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(162, 361, 132, 23);
		contentPane.add(continueButton);
		
		JLabel welcomeTitle = new JLabel("Welcome To Helping Hands!");
		welcomeTitle.setBackground(Color.WHITE);
		welcomeTitle.setFont(new Font("Lucida Sans Unicode", Font.ITALIC, 25));
		welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTitle.setBounds(50, 37, 355, 37);
		contentPane.add(welcomeTitle);
		
		JLabel haveAnAccountTitle = new JLabel("Do you have an account?");
		haveAnAccountTitle.setBackground(Color.WHITE);
		haveAnAccountTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		haveAnAccountTitle.setHorizontalAlignment(SwingConstants.CENTER);
		haveAnAccountTitle.setBounds(63, 189, 326, 37);
		contentPane.add(haveAnAccountTitle);
	}
	

	
	
}
