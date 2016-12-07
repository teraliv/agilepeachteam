/**
 * @author Sean O'Donnell
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
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class Ticket extends JFrame {

	private static final long serialVersionUID = 1L;
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
	public Ticket() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseTakeThe = new JLabel("Please take the ticket to the front desk ");
		lblPleaseTakeThe.setBounds(10, 358, 464, 39);
		lblPleaseTakeThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseTakeThe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPleaseTakeThe.setBackground(Color.WHITE);
		contentPane.add(lblPleaseTakeThe);
		
		JLabel lblToReceiveYour = new JLabel("to receive your goods.");
		lblToReceiveYour.setBounds(10, 388, 464, 39);
		lblToReceiveYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblToReceiveYour.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblToReceiveYour.setBackground(Color.WHITE);
		contentPane.add(lblToReceiveYour);
		
		JLabel lblATicketIs = new JLabel("A ticket is being printed below with a list");
		lblATicketIs.setBounds(10, 0, 464, 30);
		lblATicketIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblATicketIs.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblATicketIs.setBackground(Color.WHITE);
		contentPane.add(lblATicketIs);
		
		JLabel lblOfItemsPersonalized = new JLabel(" of items personalized to your needs. ");
		lblOfItemsPersonalized.setVerticalAlignment(SwingConstants.TOP);
		lblOfItemsPersonalized.setBounds(10, 31, 464, 30);
		lblOfItemsPersonalized.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfItemsPersonalized.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOfItemsPersonalized.setBackground(Color.WHITE);
		contentPane.add(lblOfItemsPersonalized);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(171, 437, 132, 23);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//continue button code here
				
				//creating previous window
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
				
				//deleting current window
				Ticket.this.dispose();
				
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(continueButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 116, 389, 244);
		contentPane.add(scrollPane);
		
		JTextPane itemListTextPane = new JTextPane(); 						//TODO this text pane needs to be populated with the list of items that the recipient is receiving.
		itemListTextPane.setEditable(false);
		itemListTextPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(itemListTextPane);
		
		JLabel lblYourListIncludes = new JLabel("Your List Includes the Following Items:");
		lblYourListIncludes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblYourListIncludes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourListIncludes.setBounds(43, 90, 389, 22);
		contentPane.add(lblYourListIncludes);
	}
}
