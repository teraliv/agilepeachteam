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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ticket extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ticket() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseTakeThe = new JLabel("Please take the ticket to the front desk ");
		lblPleaseTakeThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseTakeThe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPleaseTakeThe.setBackground(Color.WHITE);
		lblPleaseTakeThe.setBounds(10, 175, 464, 51);
		contentPane.add(lblPleaseTakeThe);
		
		JLabel lblToReceiveYour = new JLabel("to receive your goods.");
		lblToReceiveYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblToReceiveYour.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblToReceiveYour.setBackground(Color.WHITE);
		lblToReceiveYour.setBounds(10, 218, 464, 45);
		contentPane.add(lblToReceiveYour);
		
		JLabel lblATicketIs = new JLabel("A ticket is being printed below with a list");
		lblATicketIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblATicketIs.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblATicketIs.setBackground(Color.WHITE);
		lblATicketIs.setBounds(10, 11, 464, 51);
		contentPane.add(lblATicketIs);
		
		JLabel lblOfItemsPersonalized = new JLabel(" of items personalized to your needs. ");
		lblOfItemsPersonalized.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfItemsPersonalized.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOfItemsPersonalized.setBackground(Color.WHITE);
		lblOfItemsPersonalized.setBounds(10, 57, 464, 45);
		contentPane.add(lblOfItemsPersonalized);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//continue button code here
				
				//creating previous window
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WelcomePage frame = new WelcomePage();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				//deleting current window
				Ticket.this.dispose();
				
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(170, 341, 132, 23);
		contentPane.add(continueButton);
	}

}
