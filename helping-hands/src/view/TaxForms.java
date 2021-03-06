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

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Donor;
import model.DonorContainer;
import model.Item;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

public class TaxForms extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable taxTable;
	private Donor myDonor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Donor d = new Donor("a","a","a","a","a","a","a","a","a","a","a", "a","a","a");
					//TaxForms frame = new TaxForms(d);
                    TaxForms frame = new TaxForms();

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
	//public TaxForms(Donor d) {
    public TaxForms() {
		//d = myDonor;


		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel printPanel = new JPanel();
		printPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		printPanel.setBackground(Color.WHITE);
		printPanel.setBounds(87, 85, 294, 269);
		contentPane.add(printPanel);
		printPanel.setLayout(null);
		
		JTextPane txtpnYourTaxDocumentation = new JTextPane();
		txtpnYourTaxDocumentation.setEditable(false);
		txtpnYourTaxDocumentation.setText("Your tax documentation is being\r\n             printed below. \r\n\r\n\r\n  Thank you for your donations!");
		txtpnYourTaxDocumentation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnYourTaxDocumentation.setBounds(10, 11, 274, 197);
		printPanel.add(txtpnYourTaxDocumentation);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//continue button code here
				printPanel.setVisible(false);
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(84, 219, 132, 23);
		printPanel.add(continueButton);
		//starting the print panel off invisible
		printPanel.setVisible(false);
		
		
		JLabel donorNameLabel = new JLabel("Donor\r\n"); //TODO this label needs to be dynamically filled with the donor's name
		donorNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		donorNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		donorNameLabel.setBackground(Color.WHITE);
		donorNameLabel.setBounds(95, 0, 71, 22);
		contentPane.add(donorNameLabel);
		
		taxTable = new JTable(); 				//TODO this table needs to be populated with the past 18 donations a donor has donated in descending chronological order
		taxTable.setEnabled(false);				//TODO meaning, most recent at the top, along with the sum of ALL of the values of that donors donations in a year in the
		taxTable.setFont(new Font("Tahoma", Font.PLAIN, 16));	//TODO bottom right, replace the text "Total Here" with the actual total.
		
		Object[][] tableModelData = new Object[20][3];
		int curLine = 0;
    	
    	tableModelData[curLine][0] = "Item";
    	tableModelData[curLine][1] = "Date";
    	tableModelData[curLine][2] = "Cost";
    	curLine++;
    	
    	int   count = 0;
        double totalCost = 0;
	    
    	DonorContainer      dc = DonorContainer.getInstance();
    	Donor cd = dc.getActiveDonor();
    	if(cd != null) {
            for (Item current : cd.donatedItems) {
	        	tableModelData[curLine][0] = current.name;
	        	tableModelData[curLine][1] = current.quantity;
	        	tableModelData[curLine][2] = current.price;
	        	
	            totalCost += (current.price * current.quantity);
	            count++;
	            curLine++;
	        }
    	}
        
        for(int i = count; i < 18; i++){
        	tableModelData[curLine][0] = null;
        	tableModelData[curLine][1] = null;
        	tableModelData[curLine][2] = null;
        	curLine++;
        }
        
    	tableModelData[curLine][0] = "Total Donated:";
    	tableModelData[curLine][1] = null;
    	tableModelData[curLine][2] = totalCost;
        
		taxTable.setModel(new DefaultTableModel(
			tableModelData,
			new String[] {
				"Item", "Date", "Cost"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		taxTable.getColumnModel().getColumn(0).setResizable(false);
		taxTable.getColumnModel().getColumn(0).setPreferredWidth(130);
		taxTable.getColumnModel().getColumn(1).setResizable(false);
		taxTable.getColumnModel().getColumn(1).setPreferredWidth(79);
		taxTable.getColumnModel().getColumn(2).setResizable(false);
		taxTable.setBounds(38, 70, 408, 320);
		contentPane.add(taxTable);
		
		JLabel lblNewLabel = new JLabel("Below is a brief list of your donations as well as the");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 26, 484, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalTaxDeductible = new JLabel("total tax deductible amount for this year.");
		lblTotalTaxDeductible.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTaxDeductible.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalTaxDeductible.setBounds(0, 41, 484, 17);
		contentPane.add(lblTotalTaxDeductible);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back button code here
				
				//creating previous window (donor home page)
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//DonorHomePage frame = new DonorHomePage(myDonor);
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
				
				//deleting current window
				TaxForms.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		JButton printButton = new JButton("Print");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//print button code here
				//TODO maybe we should make a real printer call here? If not I'll specify that it does not do that in our deliverable 3 document
				printPanel.setVisible(true);
			}
		});
		printButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		printButton.setBounds(186, 401, 89, 23);
		contentPane.add(printButton);
		
		JLabel lblsTaxDocumentation = new JLabel("'s Tax Documentation");
		lblsTaxDocumentation.setHorizontalAlignment(SwingConstants.LEFT);
		lblsTaxDocumentation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblsTaxDocumentation.setBackground(Color.WHITE);
		lblsTaxDocumentation.setBounds(161, 0, 294, 22);
		contentPane.add(lblsTaxDocumentation);
	}
    
    /*
    Object[][] getCurrentDonorDonations()
    {
    	ArrayList<Object[]> toRet = new ArrayList<Object[]>();
    	
    	DonorContainer      dc = DonorContainer.getInstance();
    	Donor cd = dc.getActiveDonor();
    	
        int                 index = 1;

        double totalCost = 0;
        for (Item current : cd.donatedItems) {
            toRet.add(new Object[] {current.name, current.quantity, current.price});
            totalCost += (current.price * current.quantity;
        }
    }
    */
}
