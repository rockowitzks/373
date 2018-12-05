package software;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.swing.*;


import reservables.hotels.Hotel;
import users.Account;
import users.Card;
import users.Reservation;
//import org.university.software.UniversityGUI.OutStream;



public class TravelGUI extends JFrame {

	private static final long serialVersionUID = 5074659735953050L;
	private Reservation reservation;
	private JMenuBar menuBar;
	private JMenu accountMenu;
	private JMenu fileMenu;
	private JMenu reservationMenu;
	private JMenu About;
	private Website web1;

	// File submenus
    
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	private JMenuItem fileExit;
	
	// Account
	
	private JMenuItem signIn;
	private JMenuItem createAccount;
	private JMenuItem LogOut;
	private JMenuItem AboutUs;
	
	
	// Reservations 
	
	private JMenuItem viewReservation;
	private JMenuItem newReservation;

    private ImageIcon univIcon = new ImageIcon("globe.png");
    private JLabel imageLabel1 = new JLabel(univIcon);
	private JComboBox<String> departureCities;
	private JComboBox<String> seatClasses;
	private JComboBox<String> carClasses;
	private JComboBox<String> hotelClasses;
	private JComboBox<String> arrivalCities;
	private JComboBox<String> hotelCities;
	private JComboBox<String> carCities;
	private JFormattedTextField adateTextField;
	private JFormattedTextField ddateTextField;
	private JFormattedTextField h1dateTextField;
	private JFormattedTextField h2dateTextField;
	private JFormattedTextField c1dateTextField;
	private JFormattedTextField c2dateTextField;
	private JButton ResOk;
	private JButton ResCancel;
	private JPanel carData;
	private JPanel airplaneData;
	private JPanel hotelData;
	private JCheckBox flightButton;
	private JCheckBox hotelButton;
	private JCheckBox carButton;
	private JTextField numPassengersTextField;
	public JPanel FlightSelection;
	public ScrollPane FlightScroller;
	public ButtonGroup dep;
	public boolean hotel;
	public boolean car;
	public boolean flight;
	private ButtonGroup ret;
	public boolean rflight;
	public boolean dflight;
	public boolean hotelfound;
	public boolean carfound;
	private ButtonGroup hotelButtons;
	private ButtonGroup carButtons;
	public JButton returnOk;
	private JButton departOk;
	private JButton hotelOk;
	private JButton carOk; 
	private JLabel titleText;
	private boolean amdone;
	private Account Guest = new Account("Guest","Guest@email.com", "GuestAccount", "asdf",web1,new Card());



	
	
	public TravelGUI(String windowTitle, Website website) 
	{
		super(windowTitle);
		amdone = true;
		this.FlightScroller = new ScrollPane();
		JFrame kkk = new JFrame();
		kkk.add(FlightScroller);
		this.FlightSelection = new JPanel();
     	this.FlightScroller.setPreferredSize(new Dimension(700, 350));
		this.web1 = website;
		this.web1.setCurrentAccount(Guest);
		this.reservation = new Reservation();
		this.reservation.setAccount(this.web1.getCurrentAccount());
		this.rflight = true;
		this.dflight = true;
		this.hotelfound = true;
		this.carfound = true;
		
		setLayout(new FlowLayout(FlowLayout.CENTER));

        add(imageLabel1, BorderLayout.CENTER);
        titleText = new JLabel("<HTML><center>Welcome to ExTraveLux" +
				"<BR>Suspiciously expensive travel to just about anywhere we have programmed</center><BR></HTML>");
		add(titleText, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPreferredSize(new Dimension(760,550));
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
		About = new JMenu("About");
		accountMenu = new JMenu("Account");
		reservationMenu = new JMenu("Reservations");

		// menu items
		fileSave = new JMenuItem("Save");
		fileLoad = new JMenuItem("Load");
		signIn = new JMenuItem("Sign In");
		createAccount = new JMenuItem("Create an Account");
		viewReservation = new JMenuItem("View Reservations");
		fileExit = new JMenuItem("Exit");
		newReservation = new JMenuItem("Create a new Reservation");
		LogOut = new JMenuItem("LogOut");
		AboutUs = new JMenuItem("About Us");

		// listeners
		signIn.addActionListener(new MenuListener());		
		fileSave.addActionListener(new MenuListener());	
		fileLoad.addActionListener(new MenuListener());
		createAccount.addActionListener(new MenuListener());
		viewReservation.addActionListener(new MenuListener());
		fileExit.addActionListener(new MenuListener());
		newReservation.addActionListener(new MenuListener());
		LogOut.addActionListener(new MenuListener());
		AboutUs.addActionListener(new MenuListener());
		
		// add items to menu
		fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
		
		accountMenu.add(signIn);
		accountMenu.add(createAccount);
		accountMenu.add(LogOut);
		
		reservationMenu.add(viewReservation);
		reservationMenu.add(newReservation);
		About.add(AboutUs);
		//adminMenu.add(adminPrintAll);
		
		// add menus to menu bar
		menuBar.add(About);
	    menuBar.add(fileMenu);
	    menuBar.add(accountMenu);
	    menuBar.add(reservationMenu);
	    menuBar.add(About);

		setJMenuBar(menuBar);
	}
	protected class MenuListener implements ActionListener {
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
			else if (source.equals(fileSave)){
				Website.saveData(web1);
			}
			else if (source.equals(fileLoad)) {
				web1.setUserData(Website.loadData().getUserData());
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
					handleViewReservation();
				}
			}
			else if (source.equals(LogOut)) {
				if(!web1.getCurrentAccount().equals(Guest)) {
					web1.setCurrentAccount(Guest);
					JOptionPane.showMessageDialog(null,
							"You have successfully logged out",
							"Log Out Successful",
							JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Cannot Log Out of Guest Account",
							"Guest Account",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
			else if (source.equals(newReservation) && amdone) {
				handleNewReservation();
//				if(web1.getCurrentAccount().getAccountName().equalsIgnoreCase("GuestAccount")) {
//					Reservation tempRes = web1.getCurrentAccount().getReservations().get(0);
//					handleCreateAccount();
//					handleSignIn();
//					web1.getCurrentAccount().addRerservation(tempRes);
//					
//					JOptionPane.showMessageDialog(null,
//							"Thanks for signing in! Your reservation has been added.",
//							"Account Creation and Sign In Complete",
//							JOptionPane.OK_OPTION);
//				}
			}
			else if (source.equals(fileExit)) {
				System.exit(0);
			}
			else if (source.equals(AboutUs)) {
				JTextArea output = new JTextArea();
		        output.setEditable (false);
		        PrintStream stdout = System.out;
		        PrintStream printStream = new PrintStream(new OutStream(output));
		        System.setOut(printStream);
		        System.setErr(printStream);
		        System.out.println("ExTraveLux was created by Bill Brooks, Bader Jeragh, and Kris Rockowitz");
		        System.out.println("Our Proprietary Software is capable of generating hundreds of flights to many\n"
		        		+ "destinations and coordinatiing them with popular hotels and cars");
		        System.out.println("Current Version : 3.73");
		        System.setOut(stdout);
		        System.setErr(stdout);
				JOptionPane.showMessageDialog(null,
						output,
						"About Us",
						JOptionPane.PLAIN_MESSAGE);
			}
				
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
					ArrayList<Reservation> temp = new ArrayList<Reservation>();
					if(web1.getCurrentAccount().getAccountName().equalsIgnoreCase("GuestAccount") && !(web1.getCurrentAccount().getReservations().isEmpty())) {
						
						for(Reservation r: web1.getCurrentAccount().getReservations()) {
							temp.add(r);
						}
					}
					web1.setCurrentAccount(web1.getUserData().get(username.getText()));
					if(!temp.isEmpty()) {
						for(Reservation r: temp) {
							r.setAccount(web1.getCurrentAccount());
							web1.getCurrentAccount().addRerservation(r);
						}
						
					}
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
		protected void handleCreateAccount(){
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
				if(cardType.getText().equals("") || (!(cardType.getText().equalsIgnoreCase("Debit")) && !(cardType.getText().equalsIgnoreCase("Credit")))) {
					JOptionPane.showMessageDialog(null,
							"Please enter either Debit or Credit " +cardType.getText(),
							"Error : Card Type Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardBank.getText().equals("") || (!(cardBank.getText().equalsIgnoreCase("Visa")) && !(cardBank.getText().equalsIgnoreCase("Mastercard")) && !(cardBank.getText().equalsIgnoreCase("American Express")) && !(cardBank.getText().equalsIgnoreCase("Discover")))) {
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
		private void handleViewReservation() {
			//JLabel title = new JLabel("<HTML><center>Your Reservations are displayed below</center></HTML>");
			//web1.getCurrentAccount().getReservations().get(0).printReservation();
			JTextArea outputReservation = new JTextArea(25, 80);
	        outputReservation.setEditable(false);
	        PrintStream printStream4 = new PrintStream(new OutStream(outputReservation));
	        PrintStream stdout = System.out;
	        System.setOut(printStream4);
	        System.setErr(printStream4);
	        for(Reservation r : web1.getCurrentAccount().getReservations()) {
	        	System.out.println(r.toString());
	        	System.out.println("\n");
	        }
			
			JFrame frame = new JFrame("Reservation");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        

		    JScrollPane jScrollPane = new JScrollPane(outputReservation);

		    jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    
		    //frame.add(title);
		    
//		    frame.add(jScrollPane, BorderLayout.CENTER);
//		    frame.setPreferredSize(new Dimension(500, 600));
//		    frame.pack();
//	        frame.setLocationRelativeTo(null);
//		    frame.setVisible(true);
	        System.setOut(stdout);
	        System.setErr(stdout);
	        ImageIcon icon = new ImageIcon("printIcon.png");
	        int option = JOptionPane.showConfirmDialog(null, jScrollPane, "Viewing Reservations", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon);
			if (option == JOptionPane.OK_OPTION) {
			}
			else {
				int option2 = JOptionPane.showConfirmDialog(null, "Would you like to Cancel Reservation?", "Viewing Reservations", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon);
				if (option2 == JOptionPane.OK_OPTION) {
					ArrayList<Reservation> empty = new ArrayList<Reservation>();
					web1.getCurrentAccount().setReservations(empty);
					JOptionPane.showMessageDialog(null,
							"Your Reservation has been successfully Canceled.",
							"Reservation Canceled",
							JOptionPane.OK_CANCEL_OPTION);
						return;
				}
			}
		
			//JScrollPane reservationPane = new JScrollPane("Reservation View");
		}
	}
	
	//pre user selects make reservation
	//post panel appears to take in reservation data for search
	public void handleNewReservation() {
		amdone = false;
		this.remove(this.imageLabel1);
		this.titleText.setText("Please enter data, for flight, hotel, and/or car search. Thank you for choosing us!");
		airplaneData = new JPanel();
		carData = new JPanel();
		hotelData = new JPanel();		
		airplaneData.setSize(250,400);
		carData.setSize(250,400);
		hotelData.setSize(250,400);
		this.setLayout(new FlowLayout());
		//GroupLayout Layout = new GroupLayout(airplaneData);
		//BoxLayout Layout = new BoxLayout(airplaneData, BoxLayout.X_AXIS);
		airplaneData.setLayout( new WrapLayout(FlowLayout.LEFT));
		carData.setLayout( new WrapLayout(FlowLayout.LEFT));
		hotelData.setLayout(new WrapLayout(FlowLayout.LEFT));
		
		flightButton = new JCheckBox("Flight");
		flightButton.setSelected(true);
		hotelButton = new JCheckBox("Hotel");
		hotelButton.setSelected(true);
		carButton = new JCheckBox("Car");
		carButton.setSelected(true);
		
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < web1.getAirportList().size(); i++) {
			temp.add(web1.getAirportList().get(i).getCity());
		}
		String[] cityNames = temp.toArray(new String[temp.size()]);
		departureCities = new JComboBox<>(cityNames);
		departureCities.setEditable(false);
		String[] sc = { "Economy", "Business", "First Class"};
		seatClasses = new JComboBox<>(sc);
		seatClasses.setEditable(false);
		String[] cc = {"Economy", "Standard", "Luxury"};
		carClasses = new JComboBox<>(cc);
		carClasses.setEditable(false);
		//String[] hc = {"First Class", "Business", "Economy"};
		hotelClasses = new JComboBox<>(cc);
		hotelClasses.setEditable(false);
		arrivalCities = new JComboBox<>(cityNames);
		arrivalCities.setEditable(false);
		hotelCities = new JComboBox<>(cityNames);
		hotelCities.setEditable(false);
		carCities = new JComboBox<>(cityNames);
		carCities.setEditable(false);
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		adateTextField = new JFormattedTextField(format);
		adateTextField.setColumns(10);
		adateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		ddateTextField = new JFormattedTextField(format);
		ddateTextField.setColumns(10);
		ddateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		h1dateTextField = new JFormattedTextField(format);
		h1dateTextField.setColumns(10);
		h1dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		h2dateTextField = new JFormattedTextField(format);
		h2dateTextField.setColumns(10);
		h2dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		c1dateTextField = new JFormattedTextField(format);
		c1dateTextField.setColumns(10);
		c1dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		c2dateTextField = new JFormattedTextField(format);
		c2dateTextField.setColumns(10);
		c2dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getYear());
		numPassengersTextField = new JTextField("1");
		numPassengersTextField.setColumns(3);
		//airplane block
		airplaneData.add(new JLabel("Do you want a flight"));
		airplaneData.add(flightButton);
		airplaneData.add(new JLabel("Departing: "));
		airplaneData.add(departureCities);
		airplaneData.add(new JLabel("Arriving: "));
		airplaneData.add(arrivalCities);
		airplaneData.add(new JLabel("Departure date"));
		airplaneData.add(ddateTextField);
		airplaneData.add(new JLabel("Returning date"));
		airplaneData.add(adateTextField);
		airplaneData.add(seatClasses);
		airplaneData.add(new JLabel("Number of Passengers"));
		airplaneData.add(numPassengersTextField);
		

		//hotel block
		//new BoxLayout(BoxLayout.Y_AXIS);
		hotelData.add(new JLabel("Do you want a hotel?"));
		hotelData.add(hotelButton);
		hotelData.add(new JLabel("For City:"));
		hotelData.add(hotelCities);
		hotelData.add(new JLabel("Check-in Date"));
		hotelData.add(h1dateTextField);
		hotelData.add(new JLabel("Check-Out Date"));
		hotelData.add(h2dateTextField);
		hotelData.add(hotelClasses);
		
		//car block	
		carData.add(new JLabel("Do you want a rental car?"));
		carData.add(carButton);
		carData.add(new JLabel("For City:"));
		carData.add(carCities);
		carData.add(new JLabel("Rental Date:"));
		carData.add(c1dateTextField);
		carData.add(new JLabel("Return Date:"));
		carData.add(c2dateTextField);
		carData.add(carClasses);

		
				

//		add(hotelData);
//		add(carData);
//		hotelData.setBorder(BorderFactory.createLineBorder(Color.black));
//		carData.setBorder(BorderFactory.createLineBorder(Color.black));
//		airplaneData.setBorder(BorderFactory.createLineBorder(Color.black));
		//airplaneData.setBo

		add(airplaneData);
		add(hotelData);
		add(carData);
		ResOk = new JButton("OK");
		ResOk.addActionListener(new SubmitButtonListener(this));
		this.add(ResOk);
		
		ResCancel = new JButton("cancel");
		add(ResCancel);
//		pack();
		setVisible(true);
		
	}
	
	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	// pre: nothing
	// post: handles confirmReservation
	public void handleConfirmReservation() {
		JTextArea jTextArea = new JTextArea(25,50);
		jTextArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(jTextArea);
		scroll.setSize(300,300);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		PrintStream printStream = new PrintStream(new OutStream(jTextArea));
		PrintStream stdout = System.out;
		System.setOut(printStream);
		System.setErr(printStream);
		System.out.println("\t\tIs this resrvation satisfactory?\n\n");
		System.out.println(this.reservation);
		System.setOut(stdout);
		System.setErr(stdout);
		int yes = JOptionPane.showConfirmDialog(null, scroll, "Confirm Reservation", JOptionPane.OK_CANCEL_OPTION);
		if(yes == 0) {
			System.out.println(web1.getCurrentAccount().getAccountName());
			if(web1.getCurrentAccount().getAccountName().equalsIgnoreCase("GuestAccount")){
				web1.getCurrentAccount().addRerservation(reservation);
				JOptionPane.showMessageDialog(null,
						"To Confirm your reservation, please create an Account and Sign In",
						"Guest Account",
						JOptionPane.PLAIN_MESSAGE);
				this.titleText.setText("Thank you for using Extravelux!");
				this.add(this.imageLabel1);
				amdone = true;
				return;
			}
			
				
			// You can add card functionality above this comment
			JOptionPane.showMessageDialog(null, "Reservation added!", "Confirmed", JOptionPane.PLAIN_MESSAGE);
			this.titleText.setText("Thank you for using Extravelux!");
			this.add(this.imageLabel1);
			// account.addRerservation(reservation);
			 web1.getCurrentAccount().addRerservation(reservation);
			 amdone = true;
		} else if (yes == 2) {
			// Actions you want to do if user selects cancel
			amdone = true;
		} else {
			System.out.println("Something wrong happened in handleConfirmReservation");
			System.exit(-1);
		}

	}
	
	
	
	// pre: nothing
	// post: creates outstream functionality
	private class OutStream extends OutputStream {
	    private JTextArea textArea;

	    public OutStream(JTextArea textArea) {
	        this.textArea = textArea;
	    }

	    public void write(int b) throws IOException {
	        this.textArea.append(String.valueOf((char)b));
	        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
	        this.textArea.update(this.textArea.getGraphics());
	    }
	}
	
	private class SubmitButtonListener implements ActionListener
	{
	        
		private TravelGUI frame;

		public SubmitButtonListener(TravelGUI travelGUI) {
			frame = travelGUI;
		}

		public void actionPerformed(ActionEvent e)
	      {
			if (flightButton.isSelected()) {
   		 try { //makes sure numpassenegers is int
					Integer.parseInt(numPassengersTextField.getText());
				} catch (NumberFormatException | NullPointerException nfe) {
					JPanel panel1 = new JPanel();
					JOptionPane.showMessageDialog(panel1, "number of passengers must be integer");
					return;
				}
			}
			JButton source = (JButton)e.getSource();
	         if(source.equals(ResOk)) {
	        	 
	        	 Entry entry = web1.getEntry();
	        	 frame.remove(ResOk);
	        	 frame.remove(ResCancel);
	        	 frame.remove(airplaneData);
	        	 frame.remove(hotelData);
	        	 frame.remove(carData);
//	        	 frame.setVisible(false);
//	        	 frame.setVisible(true);	
	        	 if (!flightButton.isSelected() && !hotelButton.isSelected() && !hotelButton.isSelected()) {
	        		 amdone = true;
	        		 return;
	        	 }
	        	 if (flightButton.isSelected()) { // if flight button is selected populates fields
	        		 flight = true;
	        		 dflight = false;
	        		 rflight = false;
	        		 entry.setDepartingCity((String) departureCities.getSelectedItem());
	        		 entry.setDestinationCity((String)arrivalCities.getSelectedItem());
	        		 entry.setDepartureDate(entry.convertDate(ddateTextField.getText()));
	        		 entry.setReturnDate(entry.convertDate(adateTextField.getText()));
	        		 entry.setPassengers(Integer.parseInt(numPassengersTextField.getText()));
	        		 entry.assignSeatPriority((String)seatClasses.getSelectedItem());
	        		 entry.findAirportFromCity(web1);
	        		 web1.generateFlights(entry.getDepartureDate().atStartOfDay(), entry.getDepartureAirport());
	        		 web1.generateFlights(entry.getReturnDate().atStartOfDay(), entry.getReturnAirport());
	        		 web1.calculateRoutes(entry);
	        		 web1.setDepartureRouteList(web1.SortRoute(web1.getDepartureRouteList(), true));
	        		 web1.setReturnRouteList(web1.SortRoute(web1.getReturnRouteList(), true)); // Changed
	        	 }
	        	 if (hotelButton.isSelected()) {
	        		 hotelfound = false;
	        		 hotel = true;
	        		 entry.setCheckInDate(entry.convertDate(h1dateTextField.getText()));
	        		 entry.setCheckOutDate(entry.convertDate(h2dateTextField.getText()));
	        		 entry.assignRoomType((String)hotelClasses.getSelectedItem());
	        		 web1.generateHotels();
	        		 web1.setHotelList(web1.SortHotel(web1.getHotelList()));
	        		 
	        	 }
	        	 else 
	        		 hotel = false;
	        	 if (carButton.isSelected()) {
	        		 car = true;
	        		 carfound = false;
	        		 entry.assignCarClass((String)carClasses.getSelectedItem());
	        		 entry.setTakeDate(entry.convertDate(c1dateTextField.getText()));
	        		 entry.setGiveBackDate(entry.convertDate(c2dateTextField.getText()));
	        		 entry.setCarCity((String)carCities.getSelectedItem());
	        		 web1.generateCars(entry.getCarCity());
	        		 web1.populateCarList(entry);
	        		 web1.setCarList(web1.SortCar(web1.getCarList()));
	        	 }
	        	 else 
	        		 car = false;
	        	 frame.remove(ResOk);
	        	 frame.remove(ResCancel);
	        	 frame.remove(airplaneData);
	        	 frame.remove(hotelData);
	        	 frame.remove(carData);
	        	 frame.setVisible(false);
	        	 frame.setVisible(true);
	        	 if (car || flight || hotel) {
	        		 displayOptions();
	        	 }
	         }
	         else if (source.equals(ResCancel)) {
	        	 frame.remove(ResOk);
	        	 frame.remove(ResCancel);
	        	 frame.remove(airplaneData);
	        	 frame.remove(hotelData);
	        	 frame.remove(carData);
	        	 frame.setVisible(false);
	        	 frame.setVisible(true);

	         }
	         
	         else if (source.equals(returnOk)){
	        	 Enumeration<AbstractButton> elements = ret.getElements();
	        	 AbstractButton button = (AbstractButton)elements.nextElement();
	        	 int i = 0;
	        	 while (elements.hasMoreElements()) {
	        		if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getReturnRouteList().get(i).toString() + "Is this ok?", "Confirm departing route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(returnOk);
			        		 reservation.setReturningRoute(web1.getReturnRouteList().get(i));
			        		 rflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        		button = elements.nextElement();
	        		i++;
	        	}
	        		if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getReturnRouteList().get(i).toString() + "Is this ok", "Confirm departing route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(returnOk);
			        		 reservation.setReturningRoute(web1.getReturnRouteList().get(i));
			        		 rflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        	 
	         } 
	         else if (source.equals(departOk)){
	        	 Enumeration<AbstractButton> elements = dep.getElements();
	        	 AbstractButton button = (AbstractButton)elements.nextElement();
	        	 int i = 0;
	        	 while (elements.hasMoreElements()) {
	        		if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getDepartureRouteList().get(i).toString() + "Is this ok?", "Confirm return route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(departOk);
			        		 reservation.setDepartingRoute(web1.getDepartureRouteList().get(i));
			        		 dflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        		button = elements.nextElement();
	        		i++;
	        	}
	        	 if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getDepartureRouteList().get(i).toString() + "Is this ok?", "Confirm return route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(departOk);
			        		 reservation.setDepartingRoute(web1.getDepartureRouteList().get(i));
			        		 dflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	         }
	      }
	  }
	
	//pre route list populated user is searching flight
	//post list of return routes shows
	public void selectReturnRoute() {
		this.titleText.setText("Please select a return flight");
		FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
    	FlightSelection.setPreferredSize(new Dimension(475, 230));
    	 ret = new ButtonGroup();
     	 for (int i = 0; i < web1.getReturnRouteList().size(); i++) {
     		 JRadioButton button = new JRadioButton(web1.getReturnRouteList().get(i).truncString());
     		 ret.add(button);
     		 FlightSelection.add(button);
     	 }
     	 returnOk = new JButton("Select Return Route");
     	 returnOk.addActionListener(new SubmitButtonListener(this));
     	 this.add(returnOk);
     	 FlightScroller.add(FlightSelection);
     	 this.setVisible(false);
     	 this.setVisible(true);
	}

	//pre route list populated
	//user wants to view flights
	private void selectDepartRoute() {
		
     	 this.titleText.setText("Please select a departing flight");
     	 FlightSelection = new JPanel();
     	 FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
     	 FlightSelection.setPreferredSize(new Dimension(475, 330));
     	 dep = new ButtonGroup();
     	 for (int i = 0; i < web1.getDepartureRouteList().size(); i++) {
     		 JRadioButton button = new JRadioButton(web1.getDepartureRouteList().get(i).truncString());
     		 dep.add(button);
     		 FlightSelection.add(button);
     	 }
     	 departOk = new JButton("Confirm Departure Route");
     	 departOk.addActionListener(new SubmitButtonListener(this));
     	 FlightScroller.add(FlightSelection);
     	 this.add(FlightScroller);
     	 this.add(departOk);
    	 this.setVisible(false);
    	 this.setVisible(true);
		
	}
	
	
	//pre user wants car
	//bader gets his car

	private void selectCar() {
		this.titleText.setText("Please select a Car");
		if (FlightSelection.getParent() == FlightScroller) 
			FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
		FlightSelection.setPreferredSize(new Dimension(475, 330));
		carButtons = new ButtonGroup();
     	 for (int i = 0; i < web1.getCarList().size(); i++) {
     		 JRadioButton button = new JRadioButton(web1.getCarList().get(i).toString());
     		 carButtons.add(button);
     		 FlightSelection.add(button);
     	 }
    	 carOk = new JButton("Select Car");
    	 if (!this.FlightScroller.getParent().equals(this)) {
    		 this.add(FlightScroller);
    	 }
     	 carOk.addActionListener(new carHotelListener(this));
     	 this.add(carOk);
     	 FlightScroller.add(FlightSelection);
     	 this.setVisible(false);
     	 this.setVisible(true);
		
	}

	
	//user watns a hotel, hotel list populated
	//user selects hotel handled by buttons
	private void selectHotel() {
		this.titleText.setText("Please select a hotel");
		if (FlightSelection.getParent() == FlightScroller) 
			FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
		FlightSelection.setPreferredSize(new Dimension(475, 330));
		hotelButtons = new ButtonGroup();
     	 for (int i = 0; i < web1.getHotelList().size(); i++) {
     		 web1.getHotelList().get(i).calculateHotelPrice(web1.getEntry());
     		 JRadioButton button = new JRadioButton(web1.getHotelList().get(i).toString());
     		 hotelButtons.add(button);
     		 FlightSelection.add(button);
     	 }
    	 hotelOk = new JButton("Select Hotel");
     	 hotelOk.addActionListener(new carHotelListener(this));
     	
     	 FlightScroller.add(FlightSelection);
     	 
    	 if (!this.FlightScroller.getParent().equals(this)) {
    		 this.add(FlightScroller);
    	 }
    	 this.add(hotelOk);
     	 this.setVisible(false);
     	 this.setVisible(true);
	}

	
	private class carHotelListener implements ActionListener
	{
		 private TravelGUI frame;
		public carHotelListener(TravelGUI travelGUI) {
			frame = travelGUI;
		}

		public void actionPerformed(ActionEvent e)
	      {
			JButton source = (JButton)e.getSource();
			  if (source.equals(hotelOk)){
	        	 Enumeration<AbstractButton> elements = hotelButtons.getElements();
	        	 AbstractButton button = (AbstractButton)elements.nextElement();
	        	 int i = 0;
	        	 while (elements.hasMoreElements()) {
	        		if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getHotelList().get(i).toString() + "\nIs this ok?", "Confirm Hotel", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(hotelOk);
			        		 reservation.setHotel(web1.getHotelList().get(i));
			        		 hotelfound = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        		button = elements.nextElement();
	        		i++;
	        	}
	        	 if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getHotelList().get(i).toString() + "\nIs this ok?", "Confirm Hotel", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
							 frame.remove(hotelOk);
			        		 reservation.setHotel(web1.getHotelList().get(i));
			        		 hotelfound = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	         }
			  else if (source.equals(carOk)){
		        	 Enumeration<AbstractButton> elements = carButtons.getElements();
		        	 AbstractButton button = (AbstractButton)elements.nextElement();
		        	 int i = 0;
		        	 while (elements.hasMoreElements()) {
		        		if (button.isSelected()) {
			        		int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getCarList().get(i).toString() + "\nIs this ok?", "Confirm Car", dialogButton );
							if (dialogResult == JOptionPane.YES_OPTION)
							{
								 frame.remove(carOk);
				        		 reservation.setCar(web1.getCarList().get(i));
				        		 carfound = true;
				        		 displayOptions();
				        		 return;
							} else return;
						}
		        		button = elements.nextElement();
		        		i++;
		        	}
		        	 if (button.isSelected()) {
			        		int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getCarList().get(i).toString() + "\nIs this ok?", "Confirm return route", dialogButton );
							if (dialogResult == JOptionPane.YES_OPTION)
							{
								 frame.remove(carOk);
								 FlightScroller.remove(FlightSelection);
				        		 reservation.setCar(web1.getCarList().get(i));
				        		 carfound = true;
				        		 displayOptions();
				        		 return;
							} else return;
						}
		         }		
	      }
	}
	//pre user has selected things to reserve
	//post one at a time user is displayed selections
	
	public void displayOptions() {
		if (flight && !dflight) {
			selectDepartRoute();
		}else if (flight && !rflight) {
			selectReturnRoute();
		}else if (!hotelfound && hotel) {
			selectHotel();
		}else if (car && !carfound) {
			selectCar(); //display car panel
		} else if (carfound && dflight && rflight && hotelfound) {
			handleConfirmReservation();
			FlightScroller.remove(FlightSelection);
			this.remove(FlightScroller);
			this.setVisible(false);
			this.setVisible(true);
		}
		
	}



}
