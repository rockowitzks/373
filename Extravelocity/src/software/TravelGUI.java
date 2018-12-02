package software;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.*;

import javax.swing.*;

import users.Account;
import users.Card;
import users.Reservation;


//import org.university.software.UniversityGUI.OutStream;



public class TravelGUI extends JFrame {
	private JMenuBar menuBar;
	private JMenu accountMenu;
	private JMenu fileMenu;
	private JMenu reservationMenu;
	private Website web1;

	// File submenus
    
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	private JMenuItem fileExit;
	
	// Account
	
	private JMenuItem signIn;
	private JMenuItem createAccount;
	
	
	// Reservations 
	
	private JMenuItem viewReservation;
	private JMenuItem newReservation;

    private ImageIcon univIcon = new ImageIcon("univIcon.png");
    private JLabel imageLabel1 = new JLabel(univIcon); 



	
	
	public TravelGUI(String windowTitle, Website website) 
	{
		super(windowTitle);

		web1 = website;


		
		setLayout(new FlowLayout(FlowLayout.CENTER));

        add(imageLabel1, BorderLayout.CENTER);
		
		add(new JLabel("<HTML><center>Welcome to ExTraveLux" +
				"<BR>Suspiciously expensive travel to just about anywhere we have programmed</center><BR></HTML>"), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(600,400));
        pack();
        setLocationRelativeTo(null);
		buildGUI();	
		setVisible(true);
	}
	
	
	public void buildGUI() 
	{
		//menu bar
		menuBar = new JMenuBar();
     	
		// menus
		fileMenu = new JMenu("File");
		accountMenu = new JMenu("Account");
		reservationMenu = new JMenu("Reservations");

		// menu items
		fileSave = new JMenuItem("Save");
		fileLoad = new JMenuItem("Load");
		signIn = new JMenuItem("Sign In");
		createAccount = new JMenuItem("Create an Account");
		viewReservation = new JMenuItem("View Reservation");
		fileExit = new JMenuItem("Exit");
		newReservation = new JMenuItem("Create a new Reservation");

		// listeners
		signIn.addActionListener(new MenuListener());		
		fileSave.addActionListener(new MenuListener());	
		fileLoad.addActionListener(new MenuListener());
		createAccount.addActionListener(new MenuListener());
		viewReservation.addActionListener(new MenuListener());
		fileExit.addActionListener(new MenuListener());
		newReservation.addActionListener(new MenuListener());
		
		// add items to menu
		fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
		accountMenu.add(signIn);
		accountMenu.add(createAccount);
		
		reservationMenu.add(viewReservation);
		reservationMenu.add(newReservation);
		//adminMenu.add(adminPrintAll);
		
		// add menus to menu bar
	    menuBar.add(fileMenu);
	    menuBar.add(accountMenu);
	    menuBar.add(reservationMenu);

		setJMenuBar(menuBar);
	}
	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(signIn))
			{
				handleSignIn();
			}
			else if(source.equals(createAccount))
			{
				handleCreateAccount();
			}
			else if (source.equals(viewReservation)){
				if(web1.getCurrentAccount() == null || web1.getCurrentAccount().getReservations().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"No Reservations Found",
							"Error : No Reservation",
							JOptionPane.ERROR_MESSAGE);
					return;	
				}
				else { 
					//handleNewReservation();
				}
				//Employee.saveData(emp1);
			}
//			else if (source.equals(adminLoad)) {
//				emp1 = Employee.loadData();
//			}
			//if you want more items, more if elses for them
		}
		private void handleSignIn(){
		
			JTextField username = new JTextField();
			JTextField password = new JTextField();
			Object[] loginFields = {
			    "Username:", username,
			    "Password:", password
			};
			ImageIcon icon3 = new ImageIcon("studentIcon.png");
//			Department departMatch3 = new Department();
//			Person studentMatch3 = new Student();
//			Course courseMatch3 = new Course();
			int option = JOptionPane.showConfirmDialog(null, loginFields, "Sign In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon3);
			if (option == JOptionPane.OK_OPTION) {
				System.out.println("Sign In");
				if(username.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please Enter a username",
							"Error : Username Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(password.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please Enter a password",
							"Error : Password Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!web1.validateUsername(username.getText())) {
					JOptionPane.showMessageDialog(null,
							"Username not found",
							"Error : Username Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!web1.validatePassword(username.getText(), password.getText())) {
					JOptionPane.showMessageDialog(null,
							"Password Incorrect",
							"Error : Password Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(web1.validateUsername(username.getText()) && web1.validatePassword(username.getText(), password.getText())) {
					web1.setCurrentAccount(web1.getUserData().get(username.getText()));
					JOptionPane.showMessageDialog(null,
							"Welcome back "+username.getText(),
							"Sign In Successful",
							JOptionPane.PLAIN_MESSAGE);
				}
				
				
			}
			else {
			    System.out.println("Cancelling Sign In");
			}
			
		}
		private void handleCreateAccount(){
//			private String name;
//			private String email;
//			private String accountName;
//			private String password;
//			private Card card;
//			private ArrayList<Reservation> reservations;
//			private Website website;
//			
//			private String type;
//			private double bankMultiplier;
//			private String securityCode;
//			private String cardNumber;
//			private String expirationDate;
//			private String bank;
			
			JTextField name = new JTextField();
			JTextField email = new JTextField();
			JTextField username = new JTextField();
			JTextField password = new JTextField();
			JTextField cardType = new JTextField();
			JTextField cardBank = new JTextField();
			JTextField cardNumber = new JTextField();
			JTextField cardExpiration = new JTextField();
			JTextField cardSecurityCode = new JTextField();
			
			Object[] accountFields = {
				"Name:", name,
				"Email Address:", email,
			    "Username:", username,
			    "Password:", password,
			    "Debit or Credit ?:", cardType,
			    "Visa, Mastercard, American Express, Discover ?:", cardBank,
			    "Card Number:", cardNumber,
			    "Expiration date (MMYY):", cardExpiration,
			    "Security Code", cardSecurityCode,
			};
			ImageIcon icon3 = new ImageIcon("studentIcon.png");
//			Department departMatch3 = new Department();
//			Person studentMatch3 = new Student();
//			Course courseMatch3 = new Course();
			int option = JOptionPane.showConfirmDialog(null, accountFields, "Create an Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon3);
			if (option == JOptionPane.OK_OPTION) {
				System.out.println("Account Creation");
				if(name.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter your name",
							"Error : Name Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(email.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter your email",
							"Error : Email Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(username.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter a username",
							"Error : Username Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(password.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter a password",
							"Error : Password Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardType.getText().equals("") || !(cardType.getText().equalsIgnoreCase("Debit")) || !(cardType.getText().equalsIgnoreCase("Credit"))) {
					JOptionPane.showMessageDialog(null,
							"Please enter either Debit or Credit " +cardType.getText(),
							"Error : Card Type Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardBank.getText().equals("") || !(cardBank.getText().equalsIgnoreCase("Visa")) || !(cardBank.getText().equalsIgnoreCase("Mastercard")) || !(cardBank.getText().equalsIgnoreCase("American Express")) || !(cardBank.getText().equalsIgnoreCase("Discover"))) {
					JOptionPane.showMessageDialog(null,
							"Please enter either Visa, Mastercard, American Express, or Discover",
							"Error : Card Institution Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardNumber.getText().equals("") || (cardNumber.getText().length() < 15) || (cardNumber.getText().length() > 19)) {
					JOptionPane.showMessageDialog(null,
							"Please enter a card number",
							"Error : Card Number Entry Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardExpiration.getText().equals("") || !(Website.isNumeric(cardExpiration.getText()))) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid expiration date",
							"Error : Expiration Date Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardExpiration.getText().equals("") || !(Website.isNumeric(cardExpiration.getText()))) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid security code",
							"Error : Security Code Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(web1.validateUsername(username.getText())) {
					JOptionPane.showMessageDialog(null,
							"Username already exists",
							"Error : Username Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Card c1 = new Card(cardType.getText(), cardBank.getText(), cardSecurityCode.getText(), cardNumber.getText(), cardExpiration.getText());
				Account a1 = new Account(name.getText(), email.getText(), username.getText(), password.getText(), web1, c1);
				web1.addNewUser(a1);
				web1.setCurrentAccount(a1);
				JOptionPane.showMessageDialog(null,
						"Welcome " +username.getText() + ", your account has been created",
						"Account Creation Successful",
						JOptionPane.PLAIN_MESSAGE);
			
				
				
			}
			else {
			    System.out.println("Cancelling Account Creation");
			}
			
		}
		
//		private void handleAdminPrint() 
//		{
//			if( emp1!=null)
//			{
//				emp1.Print();
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null, 
//						"No Employee", 
//						"Error", 
//						JOptionPane.PLAIN_MESSAGE);
//			}
//		}
//		
//		public boolean containsEmployee(String name)
//		{		
//			for(int n = 0; n < empList.size(); n++) 
//			{
//				if ((empList.get(n).getName().equals( name)))
//				{
//					return true;
//				}
//			}
//			return false;	
//	    }
//		
//	}
	}

}
