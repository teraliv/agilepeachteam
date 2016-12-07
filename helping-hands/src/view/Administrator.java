/**
 * @author Sean O'Donnell
 * @author Alex Terikov (teraliv@uw.edu)
 */

package view;

import model.*;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextPane displayPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
	public Administrator() {
		setTitle("\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdministrator = new JLabel("Welcome Administrator");
		lblWelcomeAdministrator.setBounds(10, 11, 474, 34);
		lblWelcomeAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblWelcomeAdministrator);

        //TODO this button should load the recipients (in text form) into the display pane
		JButton vewRecipientsButton = new JButton("View Recipients");
		vewRecipientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    //view recipient code here
                RecipientContainer  rc = RecipientContainer.getInstance();
                StringBuilder       sb = new StringBuilder();
                int                 index = 1;

                for (Recipient current : rc.recipients.values()) {
                    sb.append(index++ + ": " + current.firstName + ", " + current.lastName + "\r\n");
                }

                scrollPane = new JScrollPane();
                scrollPane.setBounds(186, 56, 298, 404);
                contentPane.add(scrollPane);

                displayPane = new JTextPane();
                displayPane.setBackground(SystemColor.menu);
                displayPane.setText(sb.toString());
                scrollPane.setViewportView(displayPane);
			}
		});
		vewRecipientsButton.setBounds(10, 68, 166, 34);
		vewRecipientsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(vewRecipientsButton);

        //TODO this button should load the donors (in text form) into the display pane
		JButton viewDonorsButton = new JButton("View Donors");
        //IE just throw the toString of all donors into the display pane when this button is clicked
		viewDonorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view donor code here
                DonorContainer      dc = DonorContainer.getInstance();
                StringBuilder       sb = new StringBuilder();
                int                 index = 1;

                for (Donor current : dc.donors.values()) {
                    sb.append(index++ + ": " + current.firstName + ", " + current.lastName + "\r\n");
                }

                scrollPane = new JScrollPane();
                scrollPane.setBounds(186, 56, 298, 404);
                contentPane.add(scrollPane);

                displayPane = new JTextPane();
                displayPane.setBackground(SystemColor.menu);
                displayPane.setText(sb.toString());
                scrollPane.setViewportView(displayPane);
			}
		});
		viewDonorsButton.setBounds(10, 113, 166, 34);
		viewDonorsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(viewDonorsButton);

        //TODO this button should load the various compiled stats (in text form) into the display pane
		JButton viewStatisticsButton = new JButton("View Statistics");
		viewStatisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view statistics code here
			}
		});
		viewStatisticsButton.setBounds(10, 158, 166, 34);
		viewStatisticsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(viewStatisticsButton);

        //TODO this button should load the inventory (in text form) into the display pane
		JButton viewInvnetoryButton = new JButton("View Inventory");
		viewInvnetoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view inventory code here
                Inventory           inventory = Inventory.getInstance();
                StringBuilder       sb = new StringBuilder();
                int                 index = 1;

                for (Item current : inventory.availableItems) {
                    sb.append(index++ + ": " + current.name + ", " + current.category + ", " +
                              current.quantity + ", " + current.price + "\r\n");
                }

                scrollPane = new JScrollPane();
                scrollPane.setBounds(186, 56, 298, 404);
                contentPane.add(scrollPane);

                displayPane = new JTextPane();
                displayPane.setBackground(SystemColor.menu);
                displayPane.setText(sb.toString());
                scrollPane.setViewportView(displayPane);
			}
		});
		viewInvnetoryButton.setBounds(10, 203, 166, 34);
		viewInvnetoryButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(viewInvnetoryButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (login screen)
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
				Administrator.this.dispose();
			}
		});
		backButton.setBounds(10, 426, 166, 34);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(backButton);
		
		JLabel fraudLabel = new JLabel("FRAUD");					//TODO magic fraud detector here
		fraudLabel.setBounds(50, 302, 87, 24);
		fraudLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fraudLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		fraudLabel.setForeground(Color.GREEN);
		contentPane.add(fraudLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 324, 166, 11);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 302, 166, 11);
		contentPane.add(separator_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 56, 298, 404);
		contentPane.add(scrollPane);
		
		displayPane = new JTextPane();
		displayPane.setBackground(SystemColor.menu);
		displayPane.setText("\r\n");
		scrollPane.setViewportView(displayPane);
	}
}
