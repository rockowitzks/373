package software;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.swing.*;
import users.Account;
import users.Card;
import users.Reservation;
//import org.university.software.UniversityGUI.OutStream;



public class TravelGUI extends JFrame {
	private Reservation reservation;
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
	public ArrayList<JButton> dep;
	public boolean hotel;
	public boolean car;
	public boolean flight;
	private ArrayList<JButton> ret; 



	
	
	public TravelGUI(String windowTitle, Website website) 
	{
		super(windowTitle);

		web1 = website;
		reservation = new Reservation();

		
		setLayout(new FlowLayout(FlowLayout.CENTER));

        add(imageLabel1, BorderLayout.CENTER);
		
		add(new JLabel("<HTML><center>Welcome to ExTraveLux" +
				"<BR>Suspiciously expensive travel to just about anywhere we have programmed</center><BR></HTML>"), BorderLayout.CENTER);
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
				//Employee.saveData(emp1);
				}
			}
//			else if (source.equals(adminLoad)) {
//				emp1 = Employee.loadData();
//			}
			else if (source.equals(newReservation)) {
				handleNewReservation();
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
		private void handleViewReservation() {
			JLabel title = new JLabel("<HTML><center>Your Reservation is displayed below</center></HTML>");
			web1.getCurrentAccount().getReservations().get(0).printReservation();
			//JScrollPane reservationPane = new JScrollPane("Reservation View");
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
	//pre user selects make reservation
	//post panel appears to take in reservation data for search
	public void handleNewReservation() {
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
		String[] sc = {"First Class", "Business", "Economy"};
		seatClasses = new JComboBox<>(sc);
		seatClasses.setEditable(false);
		String[] cc = {"Luxury", "Standard", "Economy"};
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
		ResOk = new JButton("ok");
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
	        	 if (flightButton.isSelected()) { // if flight button is selected populates fields
	        		 flight = true;
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
	        		 web1.SortRoute(web1.getDepartureRouteList(), true);
	        		 web1.SortRoute(web1.getReturnRouteList(), true);
	        		 FlightSelection = new JPanel();
	             	 FlightScroller = new ScrollPane();
	             	 FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
	             	 FlightSelection.setPreferredSize(new Dimension(475, 330));
	             	 FlightScroller.setPreferredSize(new Dimension(700, 350));
	             	 dep = new ArrayList<JButton>();
	             	 for (int i = 0; i < web1.getDepartureRouteList().size(); i++) {
	             		 dep.add(new JButton(web1.getDepartureRouteList().get(i).toString()));
	             		 dep.get(i).addActionListener(new SubmitButtonListener(frame));
	             		 FlightSelection.add(dep.get(i));
	             	 }
	             	 
	             	 
	             	 FlightScroller.add(FlightSelection);
	             	 frame.add(FlightScroller);
		        	 frame.setVisible(false);
		        	 frame.setVisible(true);
	        	 }
	        	 if (hotelButton.isSelected()) {
	        		 hotel = true;
	        		 entry.setCheckInDate(entry.convertDate(h1dateTextField.getText()));
	        		 entry.setCheckOutDate(entry.convertDate(h2dateTextField.getText()));
	        		 entry.assignRoomType((String)hotelClasses.getSelectedItem());
	        	 }
	        	 else 
	        		 hotel = false;
	        	 if (carButton.isSelected()) {
	        		 car = true;
	        		 entry.assignCarClass((String)carClasses.getSelectedItem());
	        		 entry.setTakeDate(entry.convertDate(c1dateTextField.getText()));
	        		 entry.setGiveBackDate(entry.convertDate(c2dateTextField.getText()));
	        		 web1.generateCars((String)carCities.getSelectedItem());
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
	         else {
	        	 for (int i = 0; i < dep.size(); i++) {
	        		 if( source.equals(dep.get(i)));
	        		 int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getDepartureRouteList().get(i) + "is this ok", "Confirm flight", dialogButton );
					if (dialogResult == JOptionPane.YES_OPTION)
					{
		        		 reservation.setDepartingRoute(web1.getDepartureRouteList().get(i));
		        		 selectReturnRoute();
		        		 return;
					} else return;

	        	}
	        	 for (int i = 0; i < ret.size(); i++) {
	        		 if( source.equals(ret.get(i)));
	        		 int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + web1.getReturnRouteList().get(i) + "is this ok", "Confirm flight", dialogButton );
					if (dialogResult == JOptionPane.YES_OPTION)
					{
		        		 reservation.setDepartingRoute(web1.getDepartureRouteList().get(i));
		        		 return;
					} else return;

	        	}
	         }
	      }
	  }
	public void selectReturnRoute() {
		FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
    	FlightSelection.setPreferredSize(new Dimension(475, 230));
    	 ret = new ArrayList<JButton>();
     	 for (int i = 0; i < web1.getReturnRouteList().size(); i++) {
     		 ret.add(new JButton(web1.getReturnRouteList().get(i).toString()));
     		 ret.get(i).addActionListener(new SubmitButtonListener(this));
     		 FlightSelection.add(ret.get(i));
     	 }
     	 this.setVisible(false);
     	 this.setVisible(true);

		
	}

}
