package software;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private static final long serialVersionUID = 4410435175681737L;
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
	public ButtonGroup dep;
	public boolean hotel;
	public boolean car;
	public boolean flight;
	private ButtonGroup ret;
	public boolean rflight;
	public boolean dflight;
	public boolean hotelfound;
	public boolean carfound;
	private ArrayList<JButton> hotelButtons;
	private ArrayList<JButton> carButtons;
	public JButton returnOk;
	private JButton departOk; 



	
	
	public TravelGUI(String windowTitle, Website website) 
	{
		super(windowTitle);

		this.web1 = website;
		this.reservation = new Reservation();
		this.rflight = true;
		this.dflight = true;
		this.hotelfound = true;
		this.carfound = true;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(imageLabel1, BorderLayout.CENTER);
		
		this.add(new JLabel("<HTML><center>Welcome to ExTraveLux" +
				"<BR>Suspiciously expensive travel to just about anywhere we have programmed</center><BR></HTML>"),
				BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setPreferredSize(new Dimension(760,550));
        this.pack();
        this.setLocationRelativeTo(null);
		this.buildGUI();	
		this.setVisible(true);
	}
	
	
	public void buildGUI() 
	{
		//menu bar
		this.menuBar = new JMenuBar();
     	
		// menus
		this.fileMenu = new JMenu("File");
		this.accountMenu = new JMenu("Account");
		this.reservationMenu = new JMenu("Reservations");

		// menu items
		this.fileSave = new JMenuItem("Save");
		this.fileLoad = new JMenuItem("Load");
		this.signIn = new JMenuItem("Sign In");
		this.createAccount = new JMenuItem("Create an Account");
		this.viewReservation = new JMenuItem("View Reservation");
		this.fileExit = new JMenuItem("Exit");
		this.newReservation = new JMenuItem("Create a new Reservation");

		// listeners
		this.signIn.addActionListener(new MenuListener());		
		this.fileSave.addActionListener(new MenuListener());	
		this.fileLoad.addActionListener(new MenuListener());
		this.createAccount.addActionListener(new MenuListener());
		this.viewReservation.addActionListener(new MenuListener());
		this.fileExit.addActionListener(new MenuListener());
		this.newReservation.addActionListener(new MenuListener());
		
		// add items to menu
		this.fileMenu.add(fileSave);
		this.fileMenu.add(fileLoad);
		this.fileMenu.add(fileExit);
		this.accountMenu.add(signIn);
		this.accountMenu.add(createAccount);
		
		this.reservationMenu.add(viewReservation);
		this.reservationMenu.add(newReservation);
		//adminMenu.add(adminPrintAll);
		
		// add menus to menu bar
		this.menuBar.add(this.fileMenu);
	    this.menuBar.add(this.accountMenu);
	    this.menuBar.add(this.reservationMenu);

		this.setJMenuBar(this.menuBar);
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
			int option = JOptionPane.showConfirmDialog(null, loginFields,
					"Sign In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon3);
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
			int option = JOptionPane.showConfirmDialog(null, accountFields, "Create an Account",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION,icon3);
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
				if(cardType.getText().equals("") || !(cardType.getText().equalsIgnoreCase("Debit")) || 
						!(cardType.getText().equalsIgnoreCase("Credit"))) {
					JOptionPane.showMessageDialog(null,
							"Please enter either Debit or Credit " +cardType.getText(),
							"Error : Card Type Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardBank.getText().equals("") || !(cardBank.getText().equalsIgnoreCase("Visa")) ||
						!(cardBank.getText().equalsIgnoreCase("Mastercard")) ||
						!(cardBank.getText().equalsIgnoreCase("American Express")) ||
						!(cardBank.getText().equalsIgnoreCase("Discover"))) {
					JOptionPane.showMessageDialog(null,
							"Please enter either Visa, Mastercard, American Express, or Discover",
							"Error : Card Institution Entry",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cardNumber.getText().equals("") || (cardNumber.getText().length() < 15) ||
						(cardNumber.getText().length() > 19)) {
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
				Card c1 = new Card(cardType.getText(), cardBank.getText(), cardSecurityCode.getText(),
						cardNumber.getText(), cardExpiration.getText());
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
		this.airplaneData = new JPanel();
		this.carData = new JPanel();
		this.hotelData = new JPanel();		
		this.airplaneData.setSize(250,400);
		this.carData.setSize(250,400);
		this.hotelData.setSize(250,400);
		this.setLayout(new FlowLayout());
		//GroupLayout Layout = new GroupLayout(airplaneData);
		//BoxLayout Layout = new BoxLayout(airplaneData, BoxLayout.X_AXIS);
		this.airplaneData.setLayout( new WrapLayout(FlowLayout.LEFT));
		this.carData.setLayout( new WrapLayout(FlowLayout.LEFT));
		this.hotelData.setLayout(new WrapLayout(FlowLayout.LEFT));
		
		this.flightButton = new JCheckBox("Flight");
		this.flightButton.setSelected(true);
		this.hotelButton = new JCheckBox("Hotel");
		this.hotelButton.setSelected(true);
		this.carButton = new JCheckBox("Car");
		this.carButton.setSelected(true);
		
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < web1.getAirportList().size(); i++) {
			temp.add(web1.getAirportList().get(i).getCity());
		}
		String[] cityNames = temp.toArray(new String[temp.size()]);
		this.departureCities = new JComboBox<>(cityNames);
		this.departureCities.setEditable(false);
		String[] sc = {"First Class", "Business", "Economy"};
		this.seatClasses = new JComboBox<>(sc);
		this.seatClasses.setEditable(false);
		String[] cc = {"Luxury", "Standard", "Economy"};
		this.carClasses = new JComboBox<>(cc);
		this.carClasses.setEditable(false);
		//String[] hc = {"First Class", "Business", "Economy"};
		this.hotelClasses = new JComboBox<>(cc);
		this.hotelClasses.setEditable(false);
		this.arrivalCities = new JComboBox<>(cityNames);
		this.arrivalCities.setEditable(false);
		this.hotelCities = new JComboBox<>(cityNames);
		this.hotelCities.setEditable(false);
		this.carCities = new JComboBox<>(cityNames);
		this.carCities.setEditable(false);
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		this.adateTextField = new JFormattedTextField(format);
		this.adateTextField.setColumns(10);
		this.adateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() 
				+ "/" + LocalDateTime.now().getYear());
		this.ddateTextField = new JFormattedTextField(format);
		this.ddateTextField.setColumns(10);
		this.ddateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth()
				+ "/" + LocalDateTime.now().getYear());
		this.h1dateTextField = new JFormattedTextField(format);
		this.h1dateTextField.setColumns(10);
		this.h1dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() 
				+ "/" + LocalDateTime.now().getYear());
		this.h2dateTextField = new JFormattedTextField(format);
		this.h2dateTextField.setColumns(10);
		this.h2dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth()
				+ "/" + LocalDateTime.now().getYear());
		this.c1dateTextField = new JFormattedTextField(format);
		this.c1dateTextField.setColumns(10);
		this.c1dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth() 
				+ "/" + LocalDateTime.now().getYear());
		this.c2dateTextField = new JFormattedTextField(format);
		this.c2dateTextField.setColumns(10);
		this.c2dateTextField.setText(LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getDayOfMonth()
				+ "/" + LocalDateTime.now().getYear());
		this.numPassengersTextField = new JTextField("1");
		this.numPassengersTextField.setColumns(3);
		//airplane block
		this.airplaneData.add(new JLabel("Do you want a flight"));
		this.airplaneData.add(this.flightButton);
		this.airplaneData.add(new JLabel("Departing: "));
		this.airplaneData.add(this.departureCities);
		this.airplaneData.add(new JLabel("Arriving: "));
		this.airplaneData.add(this.arrivalCities);
		this.airplaneData.add(new JLabel("Departure date"));
		this.airplaneData.add(this.ddateTextField);
		this.airplaneData.add(new JLabel("Returning date"));
		this.airplaneData.add(this.adateTextField);
		this.airplaneData.add(this.seatClasses);
		this.airplaneData.add(new JLabel("Number of Passengers"));
		this.airplaneData.add(this.numPassengersTextField);
		

		//hotel block
		//new BoxLayout(BoxLayout.Y_AXIS);
		this.hotelData.add(new JLabel("Do you want a hotel?"));
		this.hotelData.add(this.hotelButton);
		this.hotelData.add(new JLabel("For City:"));
		this.hotelData.add(this.hotelCities);
		this.hotelData.add(new JLabel("Check-in Date"));
		this.hotelData.add(this.h1dateTextField);
		this.hotelData.add(new JLabel("Check-Out Date"));
		this.hotelData.add(this.h2dateTextField);
		this.hotelData.add(this.hotelClasses);
		
		//car block	
		this.carData.add(new JLabel("Do you want a rental car?"));
		this.carData.add(this.carButton);
		this.carData.add(new JLabel("For City:"));
		this.carData.add(this.carCities);
		this.carData.add(new JLabel("Rental Date:"));
		this.carData.add(this.c1dateTextField);
		this.carData.add(new JLabel("Return Date:"));
		this.carData.add(this.c2dateTextField);
		this.carData.add(this.carClasses);

		
				

//		add(hotelData);
//		add(carData);
//		hotelData.setBorder(BorderFactory.createLineBorder(Color.black));
//		carData.setBorder(BorderFactory.createLineBorder(Color.black));
//		airplaneData.setBorder(BorderFactory.createLineBorder(Color.black));
		//airplaneData.setBo

		this.add(this.airplaneData);
		this.add(this.hotelData);
		this.add(this.carData);
		this.ResOk = new JButton("ok");
		this.ResOk.addActionListener(new SubmitButtonListener(this));
		this.add(this.ResOk);
		
		this.ResCancel = new JButton("cancel");
		this.add(this.ResCancel);
//		pack();
		this.setVisible(true);
		
	}
	
	public Reservation getReservation() {
		return this.reservation;
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
	        		 web1.SortRoute(web1.getDepartureRouteList(), true);
	        		 web1.SortRoute(web1.getReturnRouteList(), true);
	        	 }
	        	 if (hotelButton.isSelected()) {
	        		 hotelfound = false;
	        		 hotel = true;
	        		 entry.setCheckInDate(entry.convertDate(h1dateTextField.getText()));
	        		 entry.setCheckOutDate(entry.convertDate(h2dateTextField.getText()));
	        		 entry.assignRoomType((String)hotelClasses.getSelectedItem());
	        		 web1.generateHotels();
	        	 }
	        	 else 
	        		 hotel = false;
	        	 if (carButton.isSelected()) {
	        		 car = true;
	        		 carfound = false;
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
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + 
		        		web1.getReturnRouteList().get(i).toString() + "is this ok", "Confirm return route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
			        		 reservation.setReturningRoute(web1.getReturnRouteList().get(i));
			        		 rflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        		button = elements.nextElement();
	        		i++;
	        	}
	         } 
	         else if (source.equals(departOk)){
	        	 Enumeration<AbstractButton> elements = dep.getElements();
	        	 AbstractButton button = (AbstractButton)elements.nextElement();
	        	 int i = 0;
	        	 while (elements.hasMoreElements()) {
	        		if (button.isSelected()) {
		        		int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + 
		        		web1.getDepartureRouteList().get(i).toString() + "is this ok", "Confirm return route", dialogButton );
						if (dialogResult == JOptionPane.YES_OPTION)
						{
			        		 reservation.setDepartingRoute(web1.getDepartureRouteList().get(i));
			        		 dflight = true;
			        		 displayOptions();
			        		 return;
						} else return;
					}
	        		button = elements.nextElement();
	        		i++;
	        	}
	         }
	      }
	  }
	
	//pre route list populated user is searching flight
	//post list of return routes shows
	public void selectReturnRoute() {
		FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
    	FlightSelection.setPreferredSize(new Dimension(475, 230));
    	 ret = new ButtonGroup();
     	 for (int i = 0; i < web1.getReturnRouteList().size(); i++) {
     		 JRadioButton button = new JRadioButton(web1.getReturnRouteList().get(i).toString());
     		 ret.add(button);
     		 FlightSelection.add(button);
     	 }
     	 returnOk = new JButton("Select Return Route");
     	 returnOk.addActionListener(new SubmitButtonListener(this));
     	 FlightSelection.add(returnOk);
     	 FlightScroller.add(FlightSelection);
     	 this.setVisible(false);
     	 this.setVisible(true);
	}

	//pre route list populated
	//user wants to view flights
	private void selectDepartRoute() {
		 FlightSelection = new JPanel();
     	 FlightScroller = new ScrollPane();
     	 FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
     	 FlightSelection.setPreferredSize(new Dimension(475, 330));
     	 FlightScroller.setPreferredSize(new Dimension(700, 350));
     	 dep = new ButtonGroup();
     	 for (int i = 0; i < web1.getDepartureRouteList().size(); i++) {
     		 JRadioButton button = new JRadioButton(web1.getReturnRouteList().get(i).toString());
     		 dep.add(button);
     		 FlightSelection.add(button);
     	 }
     	 departOk = new JButton("Confirm Departure Route");
     	 departOk.addActionListener(new SubmitButtonListener(this));
     	 //FlightSelection.add(departOk);
//     	 FlightScroller.add(FlightSelection);
//     	 this.setVisible(false);
//     	 this.setVisible(true);
     	 FlightScroller.add(FlightSelection);
     	 this.add(FlightScroller);
     	 this.add(departOk);
    	 this.setVisible(false);
    	 this.setVisible(true);
		
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
			//TODO user has found reservation confirm now
		}
		
	}


	private void selectCar() {
		if (FlightSelection.getParent() == FlightScroller) 
			FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
		FlightSelection.setPreferredSize(new Dimension(475, 330));
		carButtons = new ArrayList<JButton>();
		for (int i = 0; i < web1.getCarList().size(); i++) {
			carButtons.add(new JButton(web1.getCarList().get(i).toString()));
			carButtons.get(i).addActionListener(new carHotelListener());
			FlightSelection.add(carButtons.get(i));
		}
	}
	
	//user watns a hotel, hotel list populated
	//user selects hotel handled by buttons
	private void selectHotel() {
		if (FlightSelection.getParent() == FlightScroller) 
			FlightScroller.remove(FlightSelection);
		FlightSelection = new JPanel();
		FlightSelection.setLayout(new BoxLayout(FlightSelection, BoxLayout.Y_AXIS));
		FlightSelection.setPreferredSize(new Dimension(475, 330));
		hotelButtons = new ArrayList<JButton>();
		for (int i = 0; i < web1.getHotelList().size(); i++) {
			hotelButtons.add(new JButton(web1.getHotelList().get(i).toString()));
			hotelButtons.get(i).addActionListener(new carHotelListener());
			FlightSelection.add(hotelButtons.get(i));
		}
	}

	
	private class carHotelListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
	      {
			JButton source = (JButton)e.getSource();
	        for(int i = 0; i < hotelButtons.size(); i++) {
	        	if (source.equals(hotelButtons.get(i))) {
	        		int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + 
	        		web1.getHotelList().get(i).toString() + "is this ok", "Confirm hotel", dialogButton );
					if (dialogResult == JOptionPane.YES_OPTION)
					{
		        		 reservation.setHotel(web1.getHotelList().get(i));
		        		 hotelfound = true;
		        		 displayOptions();
		        		 return;
					} else return;

	        		
	        	}
	        	
	        }
	        for(int i = 0; i < carButtons.size(); i++) {
	        	if (source.equals(carButtons.get(i))) {
	        		int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "You've selected " + 
	        		web1.getCarList().get(i).toString() + "is this ok", "Confirm car", dialogButton );
					if (dialogResult == JOptionPane.YES_OPTION)
					{
		        		 reservation.setCar(web1.getCarList().get(i));
		        		 carfound = true;
		        		 displayOptions();
		        		 return;
					} else return;

	        		
	        	}
	        	
	        }
	      }
	}

}
