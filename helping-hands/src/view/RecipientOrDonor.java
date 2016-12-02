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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RecipientOrDonor extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup recipientOrDonorButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public RecipientOrDonor() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhichAreYou = new JLabel("Which are you?");
		lblWhichAreYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhichAreYou.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWhichAreYou.setBackground(Color.WHITE);
		lblWhichAreYou.setBounds(26, 37, 407, 37);
		contentPane.add(lblWhichAreYou);
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Back Button Code Here
				
				//Creating the Previous Window
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
				//Deleting the current
				RecipientOrDonor.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		JRadioButton recipientButton = new JRadioButton("Recipient");
		recipientOrDonorButtonGroup.add(recipientButton);
		recipientButton.setBackground(Color.WHITE);
		recipientButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		recipientButton.setBounds(79, 230, 109, 23);
		contentPane.add(recipientButton);
		
		JRadioButton donorButton = new JRadioButton("Donor");
		recipientOrDonorButtonGroup.add(donorButton);
		donorButton.setBackground(Color.WHITE);
		donorButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		donorButton.setBounds(288, 230, 109, 23);
		contentPane.add(donorButton);
		
		JLabel orLabel = new JLabel("OR");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orLabel.setBounds(223, 235, 46, 14);
		contentPane.add(orLabel);
		
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Continue Button Code Here
				if(recipientButton.isSelected()) //launch recipient registration page
				{
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
				else //launch donor registration page
				{
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
				RecipientOrDonor.this.dispose(); //delete current window
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(171, 359, 132, 23);
		contentPane.add(continueButton);
	}

}
