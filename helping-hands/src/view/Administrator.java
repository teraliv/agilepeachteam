/**
 * Author: Sean O'Donnell
 */

package view;

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
		
		JButton vewRecipientsButton = new JButton("View Recipients");				//TODO this button should load the recipients (in text form) into the display pane
		vewRecipientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view recipient code here
			}
		});
		vewRecipientsButton.setBounds(10, 68, 166, 34);
		vewRecipientsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(vewRecipientsButton);
		
		JButton viewDonorsButton = new JButton("View Donors");						//TODO this button should load the donors (in text form) into the display pane
		viewDonorsButton.addActionListener(new ActionListener() {					//IE just throw the toString of all donors into the display pane when this button is clicked
			public void actionPerformed(ActionEvent e) {
				//view donor code here
			}
		});
		viewDonorsButton.setBounds(10, 113, 166, 34);
		viewDonorsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(viewDonorsButton);
		
		JButton viewStatisticsButton = new JButton("View Statistics");				//TODO this button should load the various compiled stats (in text form) into the display pane
		viewStatisticsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view statistics code here
			}
		});
		viewStatisticsButton.setBounds(10, 158, 166, 34);
		viewStatisticsButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(viewStatisticsButton);
		
		JButton viewInvnetoryButton = new JButton("View Inventory");				//TODO this button should load the inventory (in text form) into the display pane
		viewInvnetoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view inventory code here
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 56, 298, 404);
		contentPane.add(scrollPane);
		
		JTextPane displayPane = new JTextPane();
		displayPane.setBackground(SystemColor.menu);
		displayPane.setText("1900\r\n1901\r\n1902\r\n1903\r\n1904\r\n1905\r\n1906\r\n1907\r\n1908\r\n1909\r\n1910\r\n1911\r\n1912\r\n1913\r\n1914\r\n1915\r\n1916\r\n1917\r\n1918\r\n1919\r\n1920\r\n1921\r\n1922\r\n1923\r\n1924\r\n1925\r\n1926\r\n1927\r\n1928\r\n1929\r\n1930\r\n1931\r\n1932\r\n1933\r\n1934\r\n1935\r\n1936\r\n1937\r\n1938\r\n1939\r\n1940\r\n1941\r\n1942\r\n1943\r\n1944\r\n1945\r\n1946\r\n1947\r\n1948\r\n1949\r\n1950\r\n1951\r\n1952\r\n1953\r\n1954\r\n1955\r\n1956\r\n1957\r\n1958\r\n1959\r\n1960\r\n1961\r\n1962\r\n1963\r\n1964\r\n1965\r\n1966\r\n1967\r\n1968\r\n1969\r\n1970\r\n1971\r\n1972\r\n1973\r\n1974\r\n1975\r\n1976\r\n1977\r\n1978\r\n1979\r\n1980\r\n1981\r\n1982\r\n1983\r\n1984\r\n1985\r\n1986\r\n1987\r\n1988\r\n1989\r\n1990\r\n1991\r\n1992\r\n1993\r\n1994\r\n1995\r\n1996\r\n1997\r\n1998\r\n1999\r\n2000\r\n2001\r\n2002\r\n2003\r\n2004\r\n2005\r\n2006\r\n2007\r\n2008\r\n2009\r\n2010\r\n2011\r\n2012\r\n2013\r\n2014\r\n2015\r\n2016\r\n\r\n\r\nAL\r\nAK\r\nAZ\r\nAR\r\nCA\r\nCO\r\nCT\r\nDE\r\nFL\r\nGA\r\nHI\r\nID\r\nIL\r\nIN\r\nIA\r\nKS\r\nKY\r\nLA\r\nME\r\nMD\r\nMA\r\nMI\r\nMN\r\nMS\r\nMO\r\nMT\r\nNE\r\nNV\r\nNH\r\nNJ\r\nNM\r\nNY\r\nNC\r\nND\r\nOH\r\nOK\r\nOR\r\nPA\r\nRI\r\nSC\r\nSD\r\nTN\r\nTX\r\nUT\r\nVT\r\nVA\r\nWA\r\nWV\r\nWI\r\nWY\r\n\r\n\r\n\r\n1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n16\r\n17\r\n18\r\n19\r\n20\r\n21\r\n22\r\n23\r\n24\r\n25\r\n26\r\n27\r\n28\r\n29\r\n30\r\n31\r\n32\r\n33\r\n34\r\n35\r\n36\r\n37\r\n38\r\n39\r\n40\r\n41\r\n42\r\n43\r\n44\r\n45\r\n46\r\n47\r\n48\r\n49\r\n50\r\n51\r\n52\r\n53\r\n54\r\n55\r\n56\r\n57\r\n58\r\n59\r\n");
		scrollPane.setViewportView(displayPane);
	}
}
