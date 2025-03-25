package src_Restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BCL_Restaurant_UI {

	private static JFrame frmBclRestaurant;
	private JTextField textFieldTicketNo;
	private JTextField textFieldName;
	
	//List of stock initialised to be usable within action listeners
	public static int stockPorridge = 100;
	public static int stockSausageEggs = 100;
	public static int stockCereal = 100;
	public static int stockSandwich = 100;
	public static int stockSushi = 100;
	public static int stockSalad = 100;
	public static int stockRisotto = 100;
	public static int stockPizza = 100;
	public static int stockLasagna = 100;
	public static int stockIceCream = 100;
	public static int stockCake = 100;
	public static int stockPancake = 100;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new BCL_Restaurant_UI();
					frmBclRestaurant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BCL_Restaurant_UI() {
		initialize();
	}

	// Method for retrieving a list of valid names and ticket numbers and putting them into an array
	public static String[][] getCustomerList(){
		String[][] arr = {{"Aaron Samuels", "83746578"}, {"Regina George", "27475839"}, {"Cady Heron", "95738494"}};
		return arr;
	}
	
	//Method for retrieving flights and storing them in an array
	public static String[][] getFlightList(){
		String[][] arr = {{"08/03/2022", "06:20", "11:57", "05:37", "7021.04", "179", "HND",
				"Tokyo", "SYD", "Sydney", "TS4977", "Easyplane"}};
		return arr;
	}
	
	// Method for checking a string for whether or not it contains just numbers
	public static boolean numCheck(String s) {
	    try { // try to parse int
	        int intCheck = Integer.parseInt(s); // if this does not throw an exception then it is an integer
	        return true;
	    } catch (NumberFormatException e) { //look for exception
	    	return false; // if an exception is thrown then it is not an integer
	    }
	}
	
	//method for checking if a string contains only letters
	public static boolean charCheck(String s) {
	    return s.matches("^[ A-Za-z]+$"); // matches one or more occurrences of spaces and A-Z in both lower and upper case ONLY
	}
	
	public static int stockCheck(JSpinner basket, int stock, Timer timer) { // method for checking and updating stock
		if (stock < (int) basket.getValue()) { // if there is more in the basket than stock available
			JOptionPane.showMessageDialog(frmBclRestaurant, "Not enough stock for this item.");// keep spinner enabled but show an error message 
			System.out.println(stock + "still enabled");
			timer.start(); //start timer for restock
		} 
		if (stock >= (int) basket.getValue() && stock > 0) { //if there is enough stock compared to the basket
			stock -= (int) basket.getValue(); //take away the current value in spinner from curretn stock levels
			System.out.println(stock);
			if (stock < 1){ // if stock is now zero
				basket.setValue(0); //set value in spinner to 0
				basket.setEnabled(false); //disable spinner
				JOptionPane.showMessageDialog(frmBclRestaurant, "No stock for this item.");
				System.out.println(stock + "disabled");
				timer.start(); // start restock timer
			}
		}
		return stock;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBclRestaurant = new JFrame();
		frmBclRestaurant.setResizable(false);
		frmBclRestaurant.setTitle("BCL Restaurant\r\n");
		frmBclRestaurant.setBounds(100, 100, 720, 480);
		frmBclRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBclRestaurant.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//import list of customers
		String customerList[][] = getCustomerList();
		System.out.println(customerList[0][0]);
		System.out.println(customerList[0][1]);
		
		//Import list of flights
		String flightList[][] = getFlightList();
		
		int delay = 10000; // 180000 3 minute delay in milliseconds for timers
		
		
		JPanel panel = new JPanel();
		frmBclRestaurant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRestock = new JLabel("Menu Items will restock 3 minutes after running out, or if not enough stock is available.");
		lblRestock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblRestock.setBounds(321, 392, 375, 40);
		panel.add(lblRestock);
		
		JLabel lblTicketNo = new JLabel("Ticket No.");
		lblTicketNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTicketNo.setBounds(30, 65, 74, 14);
		panel.add(lblTicketNo);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFullName.setBounds(30, 30, 60, 14);
		panel.add(lblFullName);
		
		JLabel lblNewLabel_2 = new JLabel("Sushi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(200, 230, 49, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sandwich");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(200, 160, 79, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Porridge");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(30, 160, 89, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Caesar Salad\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(200, 300, 79, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sausage & Eggs");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(30, 230, 89, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cereal");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(30, 300, 49, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Lasagna");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(370, 300, 49, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Pizza");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9.setBounds(370, 230, 49, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Ice Cream");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10.setBounds(540, 160, 79, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Pancakes");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_11.setBounds(540, 300, 79, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Chocolate Cake");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_12.setBounds(540, 230, 95, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Mushroom Risotto");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13.setBounds(370, 160, 108, 14);
		panel.add(lblNewLabel_13);
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBreakfast.setBounds(30, 125, 74, 14);
		panel.add(lblBreakfast);
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLunch.setBounds(200, 125, 49, 14);
		panel.add(lblLunch);
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDinner.setBounds(370, 125, 49, 14);
		panel.add(lblDinner);
		
		JLabel lblNewLabel_17 = new JLabel("Dessert");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(540, 125, 79, 14);
		panel.add(lblNewLabel_17);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(BCL_Restaurant_UI.class.getResource("/src_Restaurant/Brunel Logo.png")));
		lblLogo.setBounds(420, 0, 286, 114);
		panel.add(lblLogo);
		
		JSpinner spinnerRisotto = new JSpinner();
		spinnerRisotto.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerRisotto.setBounds(490, 185, 40, 20);
		panel.add(spinnerRisotto);
		
		
		JSpinner spinnerPizza = new JSpinner();
		spinnerPizza.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerPizza.setBounds(490, 255, 40, 20);
		panel.add(spinnerPizza);
		
		JSpinner spinnerLasagna = new JSpinner();
		spinnerLasagna.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerLasagna.setBounds(490, 325, 40, 20);
		panel.add(spinnerLasagna);
		
		JSpinner spinnerPorridge = new JSpinner();
		spinnerPorridge.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerPorridge.setBounds(150, 185, 40, 20);
		panel.add(spinnerPorridge);
		
		JSpinner spinnerSausageEggs = new JSpinner();
		spinnerSausageEggs.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerSausageEggs.setBounds(150, 255, 40, 20);
		panel.add(spinnerSausageEggs);
		
		JSpinner spinnerCereal = new JSpinner();
		spinnerCereal.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerCereal.setBounds(150, 325, 40, 20);
		panel.add(spinnerCereal);
		
		JSpinner spinnerSandwich = new JSpinner();
		spinnerSandwich.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerSandwich.setBounds(320, 185, 40, 20);
		panel.add(spinnerSandwich);
		
		JSpinner spinnerSushi = new JSpinner();
		spinnerSushi.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerSushi.setBounds(320, 255, 40, 20);
		panel.add(spinnerSushi);
		
		JSpinner spinnerSalad = new JSpinner();
		spinnerSalad.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerSalad.setBounds(320, 325, 40, 20);
		panel.add(spinnerSalad);
		
		textFieldTicketNo = new JTextField();
		textFieldTicketNo.setBounds(100, 60, 95, 20);
		panel.add(textFieldTicketNo);
		textFieldTicketNo.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(100, 25, 95, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JSpinner spinnerIceCream = new JSpinner();
		spinnerIceCream.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerIceCream.setBounds(647, 185, 40, 20);
		panel.add(spinnerIceCream);
		
		JSpinner spinnerCake = new JSpinner();
		spinnerCake.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerCake.setBounds(647, 255, 40, 20);
		panel.add(spinnerCake);
		
		JSpinner spinnerPancake = new JSpinner();
		spinnerPancake.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerPancake.setBounds(647, 325, 40, 20);
		panel.add(spinnerPancake);
		
		JTextArea txtrDeliciousBlueberryFlavoured = new JTextArea();
		txtrDeliciousBlueberryFlavoured.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured.setText("Delicious blueberry flavoured \r\ngolden oat porridge.\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured.setBackground(UIManager.getColor("Button.background"));
		txtrDeliciousBlueberryFlavoured.setBounds(30, 175, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured);
		
		JTextArea txtrDeliciousBlueberryFlavoured_1 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_1.setText("Cumberland sausages with\r\nfried eggs and toast. yum!\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_1.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_1.setBounds(30, 245, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_1);
		
		JTextArea txtrDeliciousBlueberryFlavoured_3 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_3.setText("Ham + Cheese, Tuna, Egg,\r\nBLT, Cheese Ploughmans.\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_3.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_3.setBounds(200, 175, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_3);
		
		JTextArea txtrDeliciousBlueberryFlavoured_2 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_2.setText("Choose from a selection\r\nof all your favourite cereals!\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_2.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_2.setBounds(30, 315, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_2);
		
		JTextArea txtrDeliciousBlueberryFlavoured_4 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_4.setText("Avacado and Salmon Maki rolls, \r\nPrawn Nigiri with Soy sauce.\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_4.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_4.setBounds(200, 245, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_4);
		
		JTextArea txtrDeliciousBlueberryFlavoured_5 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_5.setText("Classic Caesar salad with \r\na Light Vinaigrette\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_5.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_5.setBounds(200, 315, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_5);
		
		JTextArea txtrDeliciousBlueberryFlavoured_6 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_6.setText("Pizza margherita,\r\nItalian style.\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_6.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_6.setBounds(370, 245, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_6);
		
		JTextArea txtrDeliciousBlueberryFlavoured_7 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_7.setText("Vanilla, Strawberry,\r\nChocolate, Mint chip.\r\n");
		txtrDeliciousBlueberryFlavoured_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_7.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_7.setBounds(540, 175, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_7);
		
		JTextArea txtrDeliciousBlueberryFlavoured_8 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_8.setText("Signature Chanterelle Risotto. \r\nfresh and delicious!\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_8.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_8.setBounds(370, 175, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_8);
		
		JTextArea txtrDeliciousBlueberryFlavoured_9 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_9.setText("Layered pasta, fresh\r\nsauce, beef mince.\r\n(includes a drink).");
		txtrDeliciousBlueberryFlavoured_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_9.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_9.setBounds(370, 315, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_9);
		
		JTextArea txtrDeliciousBlueberryFlavoured_10 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_10.setText("Moist, Delicious Chocolate\r\ncake with cream");
		txtrDeliciousBlueberryFlavoured_10.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_10.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_10.setBounds(540, 245, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_10);
		
		JTextArea txtrDeliciousBlueberryFlavoured_11 = new JTextArea();
		txtrDeliciousBlueberryFlavoured_11.setText("Fluffy pancakes topped\r\nwith butter and syrup");
		txtrDeliciousBlueberryFlavoured_11.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtrDeliciousBlueberryFlavoured_11.setBackground(SystemColor.menu);
		txtrDeliciousBlueberryFlavoured_11.setBounds(540, 315, 110, 50);
		panel.add(txtrDeliciousBlueberryFlavoured_11);
		
		// Create timers for each menu item which resets their stock levels and reenables them after a specified delay (3 minutes)
		ActionListener restockPorridge = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		        spinnerPorridge.setEnabled(true);
		        stockPorridge = 100;
			}
		};
		Timer timerPorridge = new Timer(delay, restockPorridge);
		timerPorridge.setRepeats(false); //we only want this to happen once when we start the timer
		
		ActionListener restockSausageEggs = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerSausageEggs.setEnabled(true);
		        stockSausageEggs = 100;
			}
		};
		Timer timerSausageEggs = new Timer(delay, restockSausageEggs);
		timerSausageEggs.setRepeats(false);
		        
		ActionListener restockCereal = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerCereal.setEnabled(true);
		        stockCereal = 100;
			}
		};
		Timer timerCereal = new Timer(delay, restockCereal);
		timerCereal.setRepeats(false);
		
		ActionListener restockSandwich = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerSandwich.setEnabled(true);
		        stockSandwich = 100;
			}
		};
		Timer timerSandwich = new Timer(delay, restockSandwich);
		timerSandwich.setRepeats(false);
		
		ActionListener restockSushi = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerSushi.setEnabled(true);
		        stockSushi = 100;
			}
		};
		Timer timerSushi = new Timer(delay, restockSushi);
		timerSushi.setRepeats(false);
		
		ActionListener restockSalad = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerSalad.setEnabled(true);
		        stockSalad = 100;
			}
		};
		Timer timerSalad = new Timer(delay, restockSalad);
		timerSalad.setRepeats(false);
		
		ActionListener restockRisotto = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerRisotto.setEnabled(true);
		        stockRisotto = 100;
			}
		};
		Timer timerRisotto = new Timer(delay, restockRisotto);
		timerRisotto.setRepeats(false);
		
		ActionListener restockPizza = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerPizza.setEnabled(true);
		        stockPizza = 100;
			}
		};
		Timer timerPizza = new Timer(delay, restockPizza);
		timerPizza.setRepeats(false);
		
		ActionListener restockLasagna = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerLasagna.setEnabled(true);
		        stockLasagna = 100;
			}
		};
		Timer timerLasagna = new Timer(delay, restockLasagna);
		timerLasagna.setRepeats(false);
		
		ActionListener restockIceCream = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerIceCream.setEnabled(true);
		        stockIceCream = 100;
			}
		};
		Timer timerIceCream = new Timer(delay, restockIceCream);
		timerIceCream.setRepeats(false);
		
		ActionListener restockCake = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerCake.setEnabled(true);
		        stockCake = 100;
			}
		};
		Timer timerCake = new Timer(delay, restockCake);
		timerCake.setRepeats(false);
		
		ActionListener restockPancake = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {      
		        spinnerPancake.setEnabled(true);
		        stockPancake = 100;
			}
		};
		Timer timerPancake = new Timer(delay, restockPancake);
		timerPancake.setRepeats(false);
	
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((textFieldTicketNo.getText().isEmpty()) || (textFieldName.getText().isEmpty()) == true ) {
					JOptionPane.showMessageDialog(frmBclRestaurant, "Please enter full name and ticket number.");
				}
				
				if ((!numCheck(textFieldTicketNo.getText())) || (!charCheck(textFieldName.getText())) ){
					JOptionPane.showMessageDialog(frmBclRestaurant, "Name cannot contain numbers, ticket number cannot contain letters!");
				} 
				
				if ((textFieldTicketNo.getText().isEmpty() == false) && (textFieldName.getText().isEmpty() == false)){
					for (int row = 0; row < customerList.length; row++){
						if (customerList[row][0].equals(textFieldName.getText()) == true) {
							if (customerList[row][1].equals(textFieldTicketNo.getText()) == true) {
								JOptionPane.showMessageDialog(frmBclRestaurant, "Purchase Successful!");
								
						    	//for each spinner, check if its corresponding stock is available,
								//if there is no stock left disable the spinner and start timer, 
								//if there is some stock but less than current value in spinner, display message and start timer
								//if there is enough stock reduce stock number by the current value in the related spinner
								
								stockPorridge = stockCheck(spinnerPorridge, stockPorridge, timerPorridge);
								stockSausageEggs = stockCheck(spinnerSausageEggs, stockSausageEggs, timerSausageEggs);
								stockCereal = stockCheck(spinnerCereal, stockCereal, timerCereal);
								stockSandwich = stockCheck(spinnerSandwich, stockSandwich, timerSandwich);
								stockSushi = stockCheck(spinnerSushi, stockSushi, timerSushi);
								stockSalad = stockCheck(spinnerSalad, stockSalad, timerSalad);
								stockRisotto = stockCheck(spinnerRisotto, stockRisotto, timerRisotto);
								stockPizza = stockCheck(spinnerPizza, stockPizza, timerPizza);
								stockLasagna = stockCheck(spinnerLasagna, stockLasagna, timerLasagna);
								stockIceCream = stockCheck(spinnerIceCream, stockIceCream, timerIceCream);
								stockCake = stockCheck(spinnerCake, stockCake, timerCake);
								stockPancake = stockCheck(spinnerPancake, stockPancake, timerPancake);
									
							}
								
						}
							
					} 
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuy.setBounds(205, 60, 70, 20);
		panel.add(btnBuy);
		
		JLabel lblNewLabel = new JLabel("\u00A32.50");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(141, 160, 49, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A35.00");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(141, 230, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_14 = new JLabel("\u00A32.50");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_14.setBounds(141, 300, 49, 14);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("\u00A36.00");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_15.setBounds(311, 300, 49, 14);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("\u00A33.50");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_16.setBounds(311, 160, 49, 14);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_18 = new JLabel("\u00A37.50");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_18.setBounds(311, 230, 49, 14);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("\u00A35.00");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_19.setBounds(647, 300, 49, 14);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("\u00A33.50");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_20.setBounds(647, 230, 49, 14);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("\u00A32.00");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_21.setBounds(647, 160, 49, 14);
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("\u00A312.50");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_22.setBounds(481, 300, 49, 14);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("\u00A311.00");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_23.setBounds(481, 230, 49, 14);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("\u00A313.50");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_24.setBounds(481, 160, 49, 14);
		panel.add(lblNewLabel_24);
	
	}
}
