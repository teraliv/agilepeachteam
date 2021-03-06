/**
 * @author Sean O'Donnell
 * @author Ahana Ghosh
 * @author Alex Terikov (teraliv@uw.edu)
 */

package view;

import model.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipientHomePage extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup regularOrVegetarian = new ButtonGroup();
	private final ButtonGroup yesOrNo = new ButtonGroup();
	private JTextField otherAllergiesField;

    private RecipientContainer  rc;
    private Recipient           recipient;
    private Inventory           inventory;

    //private String              specialRequest = null;
    //private List<String>        clothesSelections;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public RecipientHomePage() {

        rc          = RecipientContainer.getInstance();
        recipient   = rc.getActiveRecipient();
        inventory   = Inventory.getInstance();



		setResizable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\itfiles3.insttech.washington.edu\\_profile\\" +
                "sean3740\\Desktop\\TCSS 360\\peach.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setBounds(90, 11, 137, 37);
		contentPane.add(lblWelcome);

        //TODO this field needs to be dynamically populated with the recipients firstName
		final JLabel recipientNameLabel = new JLabel("Recipient");
		
		recipientNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		recipientNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		recipientNameLabel.setBackground(Color.WHITE);
		recipientNameLabel.setBounds(237, 11, 137, 37);
		contentPane.add(recipientNameLabel);
		
		final JLabel lblYourNeeds = new JLabel("Tell us about your needs");
		lblYourNeeds.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourNeeds.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourNeeds.setBackground(Color.WHITE);
		lblYourNeeds.setBounds(100, 48, 263, 37);
		contentPane.add(lblYourNeeds);
		
		final JLabel allergiesLabel = new JLabel("Allergies?");
		allergiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allergiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		allergiesLabel.setBounds(188, 96, 81, 23);
		contentPane.add(allergiesLabel);
		
		
		final JCheckBox peanutsCheckBox = new JCheckBox("Peanuts");
		peanutsCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		peanutsCheckBox.setEnabled(false);
		peanutsCheckBox.setBounds(165, 156, 137, 23);
		contentPane.add(peanutsCheckBox);
		
		final JCheckBox glutenCheckBox = new JCheckBox("Gluten");
		glutenCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		glutenCheckBox.setEnabled(false);
		glutenCheckBox.setBounds(165, 182, 137, 23);
		contentPane.add(glutenCheckBox);
		
		final JCheckBox shellfishCheckBox = new JCheckBox("Shellfish");
		shellfishCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shellfishCheckBox.setEnabled(false);
		shellfishCheckBox.setBounds(165, 208, 137, 23);
		contentPane.add(shellfishCheckBox);
		
		final JCheckBox fishCheckBox = new JCheckBox("Fish");
		fishCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fishCheckBox.setEnabled(false);
		fishCheckBox.setBounds(165, 234, 137, 23);
		contentPane.add(fishCheckBox);
		
		final JCheckBox milkCheckBox = new JCheckBox("Milk");
		milkCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		milkCheckBox.setEnabled(false);
		milkCheckBox.setBounds(165, 260, 137, 23);
		contentPane.add(milkCheckBox);
		
		final JCheckBox eggsCheckBox = new JCheckBox("Eggs");
		eggsCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eggsCheckBox.setEnabled(false);
		eggsCheckBox.setBounds(165, 286, 137, 23);
		contentPane.add(eggsCheckBox);
		
		final JCheckBox soyCheckBox = new JCheckBox("Soy");
		soyCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		soyCheckBox.setEnabled(false);
		soyCheckBox.setBounds(165, 312, 137, 23);
		contentPane.add(soyCheckBox);
		
		final JLabel otherAllergiesLabel = new JLabel("Other Allergies:");
		otherAllergiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		otherAllergiesLabel.setBounds(165, 342, 124, 17);
		contentPane.add(otherAllergiesLabel);
		
		otherAllergiesField = new JTextField();
		otherAllergiesField.setEnabled(false);
		otherAllergiesField.setBounds(165, 366, 137, 20);
		contentPane.add(otherAllergiesField);
		otherAllergiesField.setColumns(10);
		
		final JRadioButton yesButton = new JRadioButton("Yes");
		yesButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//yes button button code here
			boolean selected=yesButton.isSelected();
			allergiesLabel.setEnabled(selected);
			peanutsCheckBox.setEnabled(selected);
			glutenCheckBox.setEnabled(selected);
			shellfishCheckBox.setEnabled(selected);
			fishCheckBox.setEnabled(selected);
			milkCheckBox.setEnabled(selected);
			eggsCheckBox.setEnabled(selected);
			soyCheckBox.setEnabled(selected);
			otherAllergiesLabel.setEnabled(selected);
			otherAllergiesField.setEnabled(selected);
			}
		});
		yesOrNo.add(yesButton);
		yesButton.setHorizontalAlignment(SwingConstants.CENTER);
		yesButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yesButton.setBackground(Color.WHITE);
		yesButton.setBounds(165, 126, 57, 23);
		contentPane.add(yesButton);
		
		final JRadioButton noButton = new JRadioButton("No");
		noButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//no button button code here
			boolean selected=!noButton.isSelected();
			peanutsCheckBox.setEnabled(selected);
			glutenCheckBox.setEnabled(selected);
			shellfishCheckBox.setEnabled(selected);
			fishCheckBox.setEnabled(selected);
			milkCheckBox.setEnabled(selected);
			eggsCheckBox.setEnabled(selected);
			soyCheckBox.setEnabled(selected);
			otherAllergiesLabel.setEnabled(selected);
			otherAllergiesField.setEnabled(selected);
			}
		});
		yesOrNo.add(noButton);
		noButton.setHorizontalAlignment(SwingConstants.CENTER);
		noButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noButton.setBackground(Color.WHITE);
		noButton.setBounds(247, 126, 57, 23);
		contentPane.add(noButton);
		
		
		//starting these elements hidden
		yesButton.setVisible(false);
		noButton.setVisible(false);
		allergiesLabel.setVisible(false);
		peanutsCheckBox.setVisible(false);
		glutenCheckBox.setVisible(false);
		shellfishCheckBox.setVisible(false);
		fishCheckBox.setVisible(false);
		milkCheckBox.setVisible(false);
		eggsCheckBox.setVisible(false);
		soyCheckBox.setVisible(false);
		otherAllergiesLabel.setVisible(false);
		otherAllergiesField.setVisible(false);
		
		final JCheckBox regularCheckBox = new JCheckBox("Regular");
		regularOrVegetarian.add(regularCheckBox);
		regularCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		regularCheckBox.setEnabled(false);
		regularCheckBox.setBounds(10, 126, 137, 23);
		contentPane.add(regularCheckBox);
		
		final JCheckBox vegetarianCheckBox = new JCheckBox("Vegetarian");
		regularOrVegetarian.add(vegetarianCheckBox);
		vegetarianCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vegetarianCheckBox.setEnabled(false);
		vegetarianCheckBox.setBounds(10, 152, 137, 23);
		contentPane.add(vegetarianCheckBox);
		
		final JCheckBox babyCheckBox = new JCheckBox("Baby");
		babyCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		babyCheckBox.setEnabled(false);
		babyCheckBox.setBounds(10, 178, 137, 23);
		contentPane.add(babyCheckBox);
		
		final JComboBox foodRequestPullDown = new JComboBox();
		foodRequestPullDown.setEnabled(false);
        //TODO connect the pull-down to the appropriate inventory
		foodRequestPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		foodRequestPullDown.setModel(new DefaultComboBoxModel(getSpecialRequestsItemNames("Food")));
		foodRequestPullDown.setBounds(10, 203, 137, 23);
		contentPane.add(foodRequestPullDown);
		

		final JToggleButton foodButton = new JToggleButton("Food");
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//food toggle button code here
				boolean selected = foodButton.isSelected();


                // SPECIAL REQUEST Action Listener
                foodRequestPullDown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String specialRequest = String.valueOf(foodRequestPullDown.getSelectedItem());
                        receivedItemFromInventory(specialRequest.toLowerCase());

                    }
                });


                regularCheckBox.setEnabled(selected);
				vegetarianCheckBox.setEnabled(selected);
				babyCheckBox.setEnabled(selected);
				foodRequestPullDown.setEnabled(selected);

                // REGULAR FOOD
                regularCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (regularCheckBox.isSelected()) {
                            receivedItemFromInventory("food");
                        }
                    }
                });

                // VEGETARIAN FOOD
                vegetarianCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (vegetarianCheckBox.isSelected()) {
                            receivedItemFromInventory("vegetarian");
                        }
                    }
                });

                // BABY FOOD
                babyCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (babyCheckBox.isSelected()) {
                            receivedItemFromInventory("baby");
                        }
                    }
                });

				
				yesButton.setVisible(selected);
				noButton.setVisible(selected);
				allergiesLabel.setVisible(selected);
				yesButton.setVisible(selected);
				noButton.setVisible(selected);
				allergiesLabel.setVisible(selected);
				peanutsCheckBox.setVisible(selected);
				glutenCheckBox.setVisible(selected);
				shellfishCheckBox.setVisible(selected);
				fishCheckBox.setVisible(selected);
				milkCheckBox.setVisible(selected);
				eggsCheckBox.setVisible(selected);
				soyCheckBox.setVisible(selected);
				otherAllergiesLabel.setVisible(selected);
				otherAllergiesField.setVisible(selected);
			}
		});
		foodButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		foodButton.setBounds(10, 96, 137, 23);
		contentPane.add(foodButton);
		
		
		final JCheckBox shirtsCheckBox = new JCheckBox("Shirts");
		shirtsCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shirtsCheckBox.setEnabled(false);
		shirtsCheckBox.setBounds(10, 274, 137, 23);
		contentPane.add(shirtsCheckBox);
		
		final JCheckBox pantsCheckBox = new JCheckBox("Pants");
		pantsCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pantsCheckBox.setEnabled(false);
		pantsCheckBox.setBounds(10, 300, 137, 23);
		contentPane.add(pantsCheckBox);
		
		final JCheckBox shoesCheckBox = new JCheckBox("Shoes");
		shoesCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shoesCheckBox.setEnabled(false);
		shoesCheckBox.setBounds(10, 326, 137, 23);
		contentPane.add(shoesCheckBox);

        //TODO connect the pull-down to the appropriate inventory

		final JComboBox clothesRequestPullDown = new JComboBox();
		//clothesRequestPullDown.setModel(new DefaultComboBoxModel(new String[] {"Special Request", "<Display Clothes Inventory>"}));
        clothesRequestPullDown.setModel(new DefaultComboBoxModel(getSpecialRequestsItemNames("Clothes")));
		clothesRequestPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clothesRequestPullDown.setEnabled(false);
		clothesRequestPullDown.setBounds(10, 351, 137, 23);
		contentPane.add(clothesRequestPullDown);


        //List<String> checkedCategories = new ArrayList<>();


		final JToggleButton clothesButton = new JToggleButton("Clothes");
		clothesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//food toggle button code here
				boolean selected = clothesButton.isSelected();


				// SPECIAL REQUEST Action Listener
				clothesRequestPullDown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String specialRequest = String.valueOf(clothesRequestPullDown.getSelectedItem());
                        receivedItemFromInventory(specialRequest.toLowerCase());

                    }
				});


				shirtsCheckBox.setEnabled(selected);
				pantsCheckBox.setEnabled(selected);
				shoesCheckBox.setEnabled(selected);
				clothesRequestPullDown.setEnabled(selected);


				// SHIRT
				shirtsCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (shirtsCheckBox.isSelected()) {
                            receivedItemFromInventory("shirt");
                        }
                        else {
                            //System.out.println("deselected");
                        }
                    }
                });

                // PANTS
                pantsCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pantsCheckBox.isSelected()) {
                            receivedItemFromInventory("pant");
                        }
                    }
                });

                // SHOES
                shoesCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (shoesCheckBox.isSelected()) {
                            receivedItemFromInventory("shoe");
                        }
                    }
                });



			}
		});

		clothesButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clothesButton.setBounds(10, 244, 137, 23);
		contentPane.add(clothesButton);
		
	
		
		final JCheckBox deoderantCheckBox = new JCheckBox("Deoderant");
		deoderantCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deoderantCheckBox.setEnabled(false);
		deoderantCheckBox.setBounds(325, 178, 137, 23);
		contentPane.add(deoderantCheckBox);
		
		final JCheckBox toothCheckBox = new JCheckBox("Tooth Care");
		toothCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toothCheckBox.setEnabled(false);
		toothCheckBox.setBounds(325, 152, 137, 23);
		contentPane.add(toothCheckBox);
		
		final JCheckBox soapCheckBox = new JCheckBox("Soap/Shampoo");
		soapCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		soapCheckBox.setEnabled(false);
		soapCheckBox.setBounds(325, 126, 137, 23);
		contentPane.add(soapCheckBox);
		
		final JCheckBox shavingCheckBox = new JCheckBox("Shaving");
		shavingCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shavingCheckBox.setEnabled(false);
		shavingCheckBox.setBounds(325, 203, 137, 23);
		contentPane.add(shavingCheckBox);

        //TODO connect the pull-down to the appropriate inventory
		final JComboBox toiletriesRequestPullDown = new JComboBox();
		//toiletriesRequestPullDown.setModel(new DefaultComboBoxModel(new String[] {"Special Request", "<Toiletries Inventory>"}));

        toiletriesRequestPullDown.setModel(new DefaultComboBoxModel(getSpecialRequestsItemNames("Toiletries")));
		toiletriesRequestPullDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toiletriesRequestPullDown.setEnabled(false);
		toiletriesRequestPullDown.setBounds(325, 229, 137, 23);
		contentPane.add(toiletriesRequestPullDown);
		
		final JToggleButton toiletriesButton = new JToggleButton("Toiletries");
		toiletriesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//toiletries toggle button code here
				boolean selected = toiletriesButton.isSelected();


                // SPECIAL REQUEST Action Listener
                toiletriesRequestPullDown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String specialRequest = String.valueOf(toiletriesRequestPullDown.getSelectedItem());
                        receivedItemFromInventory(specialRequest.toLowerCase());

                    }
                });


				soapCheckBox.setEnabled(selected);
				toothCheckBox.setEnabled(selected);
				shavingCheckBox.setEnabled(selected);
				deoderantCheckBox.setEnabled(selected);
				toiletriesRequestPullDown.setEnabled(selected);


                // SOAP
                soapCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (soapCheckBox.isSelected()) {
                            receivedItemFromInventory("soap");
                            receivedItemFromInventory("shampoo");
                        }
                    }
                });

                // TOOTH
                toothCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (toothCheckBox.isSelected()) {
                            receivedItemFromInventory("tooth");
                        }
                    }
                });

                // DEODORANT
                deoderantCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (deoderantCheckBox.isSelected()) {
                            receivedItemFromInventory("deodorant");
                        }
                    }
                });

                // SHAVING
                shavingCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (shavingCheckBox.isSelected()) {
                            receivedItemFromInventory("shaving");
                        }
                    }
                });

			}
		});
		toiletriesButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		toiletriesButton.setBounds(325, 96, 137, 23);
		contentPane.add(toiletriesButton);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//continue button code here


                // @teraliv
                // UPDATE INVENTORY FILE
                writeUpdateInventoryToFile();




                //creating next window (ticket)
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
				//deleting current window
				RecipientHomePage.this.dispose();
			}
		});
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		continueButton.setBounds(165, 427, 132, 23);
		contentPane.add(continueButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for back button here

                recipient.deactivateCurrentRecipient();
				
				//creating previous window
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
				RecipientHomePage.this.dispose();
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setBounds(385, 427, 89, 23);
		contentPane.add(backButton);
		
		final JTextPane vehicleText = new JTextPane();
		vehicleText.setEditable(false);
		vehicleText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		vehicleText.setText("Request to speak with an administrator at the front desk.");
		vehicleText.setBounds(325, 289, 137, 70);
		contentPane.add(vehicleText);
		
		vehicleText.setVisible(false);
		
		final JToggleButton vehicleButton = new JToggleButton("Vehicle");
		vehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//vehicle toggle button code here
				vehicleText.setVisible(vehicleButton.isSelected());
			}
		});
		vehicleButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vehicleButton.setBounds(325, 262, 137, 23);
		contentPane.add(vehicleButton);

	}


    private void receivedItemFromInventory(String name) {

        for (Item current : inventory.availableItems) {
            if (current.name.toLowerCase().contains(name)) {

                Item newItem = new Item(current.name, current.category, 1, current.price);
                if (recipient != null) {
                    recipient.getDonation(newItem);
                    inventory.updateInventory(current.name, 1);
                }
            }
        }
    }

    private void writeUpdateInventoryToFile() {
        FileWriter fw = new FileWriter();
        fw.writeInventoryData();
    }


    private String[] getSpecialRequestsItemNames(String category) {

	    List<String> clothes = new ArrayList<>();
        clothes.add("Special Request");

        for (Item current : inventory.availableItems) {
            if (current.category.equals(category)) {
                clothes.add(current.name);
            }
        }

        return clothes.toArray(new String[0]);
    }

}
