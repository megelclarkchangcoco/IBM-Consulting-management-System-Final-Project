				package LoginFrame;


import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.border.EtchedBorder;
import ClientFrame.AMainFrame;
import ConsultantFrame.AConsultantFrame;
import adminFrame.ADmainFrame;

public class loginSignUpFrame extends JFrame {


	private JPanel contentPane;
	private JPanel signUpPanel;
	private JPanel bodyPanel;
	private JPanel loginPanel;
	private JLabel loginButton;
	private JLabel companyLabel;
	private JLabel submit;
	private JLabel createAccountLabel;
	private JLabel continueLabel;
	private JTextField emailField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField residenceField;
	private JTextField stateField;
	private JTextField phoneField;
	private JTextField companyField;
	private JTextField loginEmailField;
	private JPasswordField passwordField;
	private JPasswordField signInpasswordField;
    private JComboBox comboBoxNum;
	JRadioButton yesChoice, noChoice;


	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
	public static String[] number = {"+93","+355","+213", "+1-264","+1-864","+376","+54","+63","+374","+244","+61","+43"};
	public static String[] chooseUser = {"Choose User", "Client", "Consultant", "Admin"};


	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginSignUpFrame frame = new loginSignUpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginSignUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1880, 980);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        

		
		bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 78, 1864, 864);
		bodyPanel.setLayout(null);
		contentPane.add(bodyPanel);
		
		//CardLayout for Login and Sign Up
		CardLayout cardlayout = new CardLayout();
		bodyPanel.setLayout(cardlayout);
		
		
		//Insert head panel
		JPanel IBMpanel = new JPanel();
		IBMpanel.setBorder(new LineBorder(new Color(224, 224, 244), 2));
		IBMpanel.setBackground(new Color(255, 255, 255));
		IBMpanel.setBounds(-11, -11, 1891, 89); 
		IBMpanel.setLayout(null);
		contentPane.add(IBMpanel);

		
		
		
		//loginPanel
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		loginPanel.setBounds(0, 78, 1864, 864);
		loginPanel.setLayout(null);
		bodyPanel.add(loginPanel);
		
		
		//IBM Logo image inserted
		JLabel ibmLogo = new JLabel("");
		ibmLogo.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/LoginFrameImg/ibm_logo.png")));
		ibmLogo.setBounds(155, 30, 81, 37);
//		ibmLogo.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/ibm_logo.png")));
		IBMpanel.add(ibmLogo);
		
		
		
		
		JLabel linegrayLabel_1 = new JLabel("");
//		linegrayLabel_1.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/linegray.png")));
		linegrayLabel_1.setBounds(144, 536, 455, 14);
		loginPanel.add(linegrayLabel_1);
		
		JLabel linegrayLabel = new JLabel("");
//		linegrayLabel.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/linegray.png")));
		linegrayLabel.setBounds(144, 133, 455, 14);
		loginPanel.add(linegrayLabel);
		
		JPanel createIBMAccPanelButton = new JPanel();
		createIBMAccPanelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				cardlayout.show(bodyPanel, "panelButton");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				createIBMAccPanelButton.setBackground(new Color(230, 230, 230));
				createIBMAccPanelButton.setBorder(new LineBorder(new Color(15, 98, 254)));
				createAccountLabel.setForeground(new Color(15, 98, 254));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				createIBMAccPanelButton.setBackground(new Color(255, 255, 255));
				createIBMAccPanelButton.setBorder(new LineBorder(new Color(15, 98, 254)));
				createAccountLabel.setForeground(new Color(15, 98, 254));


			}
		});
		
		
		createIBMAccPanelButton.setBorder(new LineBorder(new Color(15, 98, 254)));
		createIBMAccPanelButton.setLayout(null);
		createIBMAccPanelButton.setBackground(new Color(255, 255, 255));
		createIBMAccPanelButton.setBounds(144, 618, 455, 63);
		loginPanel.add(createIBMAccPanelButton);
		
		
		
		createAccountLabel = new JLabel("Create an IBM Account");
		createAccountLabel.setForeground(new Color(15, 98, 254));
		createAccountLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		createAccountLabel.setBounds(10, 11, 316, 27);
		createIBMAccPanelButton.add(createAccountLabel);
		
		JLabel blueArrowLabel = new JLabel("");
		blueArrowLabel.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/LoginFrameImg/arrowBlue.png")));
//		blueArrowLabel.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/arrowBlue.png")));
		blueArrowLabel.setBounds(410, 22, 35, 14);
		createIBMAccPanelButton.add(blueArrowLabel);
		
		JLabel frontpageLabel = new JLabel("Don't have an account?");
		frontpageLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		frontpageLabel.setBounds(144, 593, 244, 14);
		loginPanel.add(frontpageLabel);
		
		JComboBox<String>userDropbox = new JComboBox(chooseUser);
		userDropbox.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN,18));
		userDropbox.setBackground(new Color(244,244,244));
		userDropbox.setBorder(BorderFactory.createMatteBorder(0,0,2,0, new Color(22,22,22)));
		userDropbox.setBounds(144, 183, 455, 43);
		loginPanel.add(userDropbox);
		


		JPanel continuePanelButton = new JPanel();
		continuePanelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		continuePanelButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        String chooseFrame = (String) userDropbox.getSelectedItem();
		        String username = loginEmailField.getText();
		        String password = new String(signInpasswordField.getPassword());

		        System.out.println("Selected user type: " + chooseFrame);
		        System.out.println("Entered email: " + username);
		        // Do not print passwords in production code. This is for debugging only.
		        System.out.println("Entered password: " + password);

		        // Check which user type is selected
		        if (chooseFrame.equals("Client")) {
		            int authResult = authenticateClient(username, password);
		            if (authResult == 0) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Login successful!");		                
		                AMainFrame af = new AMainFrame(username);
		                af.setVisible(true);
		                dispose();
		            } else if (authResult == 1) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else if (chooseFrame.equals("Consultant")) {
		            int authResult = authenticateConsultant(username, password);
		            if (authResult == 0) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Login successful!");
		                AConsultantFrame acf = new AConsultantFrame(username);
		                acf.setVisible(true);
		                dispose();
		            } else if (authResult == 1) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else if (chooseFrame.equals("Admin")) {
		            int authResult = authenticateAdmin(username, password);
		            if (authResult == 0) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Login successful!");
		                ADmainFrame amf = new ADmainFrame(username);
		                amf.setVisible(true);
		                dispose();
		            } else if (authResult == 1) {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(loginSignUpFrame.this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a valid user type", "Selection Error", JOptionPane.ERROR_MESSAGE);
		        }
		  }
		    private int authenticateClient(String username, String password) {
		        try (Connection conn = DriverManager.getConnection(dbUrl)) {
		            // Check if the username and password match in the Client table
		            PreparedStatement checkCredentialsStmt = conn.prepareStatement("SELECT * FROM Client WHERE Client_email = ? AND Client_password = ?");
		            checkCredentialsStmt.setString(1, username);
		            checkCredentialsStmt.setString(2, password);
		            ResultSet credentialsResult = checkCredentialsStmt.executeQuery();
		            if (credentialsResult.next()) {
		                return 0; // Authentication successful
		            } else {
		                return 1; // Invalid email or password
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            return 2; // Database error
		        }
		    }
		    
		    private int authenticateConsultant(String username, String password) {
		    	 try (Connection conn = DriverManager.getConnection(dbUrl)) {
			            // Check if the username and password match in the Client table
			            PreparedStatement checkCredentialsStmt = conn.prepareStatement("SELECT * FROM Consultant WHERE Consultant_email = ? AND Consultant_password = ?");
			            checkCredentialsStmt.setString(1, username);
			            checkCredentialsStmt.setString(2, password);
			            ResultSet credentialsResult = checkCredentialsStmt.executeQuery();
			            if (credentialsResult.next()) {
			                return 0; // Authentication successful
			            } else {
			                return 1; // Invalid email or password
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            return 2; // Database error
			        }
		    }
		    private int authenticateAdmin(String username, String password) {
		    	 try (Connection conn = DriverManager.getConnection(dbUrl)) {
			            // Check if the username and password match in the Client table
			            PreparedStatement checkCredentialsStmt = conn.prepareStatement("SELECT * FROM Admin WHERE admin_email = ? AND admin_password = ?");
			            checkCredentialsStmt.setString(1, username);
			            checkCredentialsStmt.setString(2, password);
			            ResultSet credentialsResult = checkCredentialsStmt.executeQuery();
			            if (credentialsResult.next()) {
			                return 0; // Authentication successful
			            } else {
			                return 1; // Invalid email or password
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            return 2; // Database error
			        }
		    }
			@Override
			public void mouseEntered(MouseEvent e) {
				continuePanelButton.setBackground(new Color(230,230,230));
				continuePanelButton.setBorder(new LineBorder(new Color(15, 98, 254)));
				continueLabel.setForeground(new Color(15, 98, 254));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				continuePanelButton.setBackground(new Color(15, 98, 254));
				continuePanelButton.setBorder(new LineBorder(new Color(190, 190, 190)));
				continueLabel.setForeground(new Color(255, 255, 255));

			}
		});


		continuePanelButton.setBackground(new Color(15, 98, 254));
		continuePanelButton.setBounds(144, 447, 455, 63);
		loginPanel.add(continuePanelButton);
		continuePanelButton.setLayout(null);
		
		continueLabel = new JLabel("Continue");
		continueLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		continueLabel.setForeground(new Color(255, 255, 255));
		continueLabel.setBounds(10, 11, 112, 27);
		continuePanelButton.add(continueLabel);
		
		JLabel arrowLabel = new JLabel("");
		arrowLabel.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/LoginFrameImg/arrowButton.png")));
//		arrowLabel.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/arrowButton.png")));
		arrowLabel.setBounds(410, 25, 35, 14);
		continuePanelButton.add(arrowLabel);
		
		signInpasswordField = new JPasswordField();
		signInpasswordField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		signInpasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		signInpasswordField.setBackground(new Color(244, 244, 244));
		signInpasswordField.setBounds(144, 371, 455, 45);
		loginPanel.add(signInpasswordField);
		
		JLabel signInLabelUser = new JLabel("User");
		signInLabelUser.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signInLabelUser.setBounds(144, 158, 244, 14);
		loginPanel.add(signInLabelUser);
		
	
		

		
		JLabel signInLabelPassword = new JLabel("Password");
		signInLabelPassword.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signInLabelPassword.setBounds(144, 346, 244, 14);
		loginPanel.add(signInLabelPassword);
		
		JLabel signInLabelEmail = new JLabel("Email");
		signInLabelEmail.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signInLabelEmail.setBounds(144, 247, 244, 14);
		loginPanel.add(signInLabelEmail);
		
		loginEmailField = new JTextField();
		loginEmailField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		loginEmailField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		loginEmailField.setBackground(new Color(244, 244, 244));
		loginEmailField.setBounds(144, 272, 455, 43);
		loginPanel.add(loginEmailField);
		
		
		
		JLabel loginLabel = new JLabel("Log in to IBM");
		loginLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 32));
		loginLabel.setBounds(144, 85, 329, 58);
		loginPanel.add(loginLabel);
		
		
		JLabel signInBG = new JLabel("");
		signInBG.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/LoginFrameImg/sign_in_bg.png")));
//		signInBG.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/sign_in_bg.png")));
		signInBG.setBounds(-8, 5, 1880, 859);
		loginPanel.add(signInBG);
		
		//sign up panel
		signUpPanel = new JPanel();
		signUpPanel.setBackground(new Color(255, 255, 255));
		signUpPanel.setBounds(0, 78, 1864, 864);
		signUpPanel.setLayout(null);
		bodyPanel.add(signUpPanel);
		
		
		//label for the title in sign up page 
		JLabel consultingLabel = new JLabel("our consulting services.");
		consultingLabel.setBounds(147, 182, 342, 42);
		consultingLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 32));
		signUpPanel.add(consultingLabel);
		
		//label for the title in sign up page 
		JLabel createLabel = new JLabel("Create an account to access");
		createLabel.setBounds(147, 138, 416, 47);
		createLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 32));
		signUpPanel.add(createLabel);
		
		
		//label for the title in sign up page 
		JLabel welcomeText = new JLabel("Welcome to IBM");
		welcomeText.setBounds(147, 51, 254, 42);
		welcomeText.setFont(new Font("IBM Plex Sans", Font.PLAIN, 32));
		signUpPanel.add(welcomeText);
		
		//main background for sign up panel
		JLabel signupBackground = new JLabel("");
		signupBackground.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/LoginFrameImg/signup_background.png")));
		signupBackground.setBounds(0, 0, 960, 864);
//		signupBackground.setIcon(new ImageIcon(loginSignUpFrame.class.getResource("/assets/signup_background.png")));
		signUpPanel.add(signupBackground);
		
		//header for the sign up page
		JLabel contactLabel = new JLabel("Contact your IBM Representative");
		contactLabel.setBounds(1058, 51, 485, 46);
		contactLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 32));
		signUpPanel.add(contactLabel);
		
		//label to login page
		JLabel questionLabel = new JLabel("Have an account?");
		questionLabel.setBounds(1058, 104, 125, 23);
		questionLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(questionLabel);
		
		
		//panel button to go to login page
		JPanel panelButton = new JPanel();
		panelButton.setBounds(1185, 104, 69, 23);
		panelButton.setBackground(new Color(255, 255, 255));
		panelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			cardlayout.show(bodyPanel, "createIBMAccPanelButton");
				
			}
			
			public void mouseEntered(MouseEvent e) {
				panelButton.setBackground(new Color(15,98,254));
				loginButton.setForeground(new Color(255,255,255));
			}
			
			public void mouseExited(MouseEvent e) {
				panelButton.setBackground(new Color(255, 255, 255));
				loginButton.setForeground(new Color(0,0,0));
			}
			
		
			
		});
		signUpPanel.add(panelButton);
		panelButton.setLayout(null);
		
		
		//login label inside the login panel button
		loginButton = new JLabel("Login");
		loginButton.setForeground(new Color(15, 98, 254));
		loginButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		loginButton.setBounds(0, 0, 37, 23);
		panelButton.add(loginButton);
		
		//business email label for its field
		JLabel emailLabel = new JLabel("Business Email");
		emailLabel.setBounds(1058, 150, 184, 23);
		emailLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(emailLabel);
		
		//insert email field
		emailField = new JTextField();
		emailField.setBounds(1058, 175, 690, 43);
		emailField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		emailField.setBackground(new Color(244, 244, 244));
		emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		signUpPanel.add(emailField);
		
		//password label for its field
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(1058, 243, 76, 23);
		passwordLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(passwordLabel);
		
		//insert password field
		passwordField = new JPasswordField();
		passwordField.setBounds(1058, 275, 690, 45);
		passwordField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		passwordField.setBackground(new Color(244, 244, 244));
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		signUpPanel.add(passwordField);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(1058, 347, 76, 23);
		firstNameLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(firstNameLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(1058, 378, 319, 43);
		firstNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		firstNameField.setBackground(new Color(244, 244, 244));
		signUpPanel.add(firstNameField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(1429, 347, 76, 23);
		lastNameLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(lastNameLabel);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(1429, 378, 319, 43);
		lastNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		lastNameField.setBackground(new Color(244, 244, 244));
		signUpPanel.add(lastNameField);
		
		JLabel countryLabel = new JLabel("Country or region of residence");
		countryLabel.setBounds(1058, 451, 293, 23);
		countryLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(countryLabel);
		
		residenceField = new JTextField();
		residenceField.setBounds(1058, 478, 319, 43);
		residenceField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		residenceField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		residenceField.setBackground(new Color(244, 244, 244));
		signUpPanel.add(residenceField);
		
		JLabel stateLabel = new JLabel("State or province");
		stateLabel.setBounds(1429, 451, 293, 23);
		stateLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(stateLabel);
		
		stateField = new JTextField();
		stateField.setBounds(1429, 478, 319, 43);
		stateField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		stateField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		stateField.setBackground(new Color(244, 244, 244));
		signUpPanel.add(stateField);
		
		JLabel squestionLabel = new JLabel("Are you a student?");
		squestionLabel.setBounds(1058, 635, 293, 23);
		squestionLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(squestionLabel);
		
		yesChoice = new JRadioButton("Yes");
		yesChoice.setBounds(1058, 665, 69, 30);
		yesChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				companyLabel.setVisible(false);
				companyField.setVisible(false);
			}
		});
		buttonGroup.add(yesChoice);
		yesChoice.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		yesChoice.setOpaque(false);
		signUpPanel.add(yesChoice);
		

		 noChoice = new JRadioButton("No");
		noChoice.setBounds(1129, 665, 69, 30);
		noChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				companyLabel.setVisible(true);
				companyField.setVisible(true);
				
			}
		});
		noChoice.setOpaque(false);
		noChoice.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		signUpPanel.add(noChoice);
		
		buttonGroup.add(noChoice);
		buttonGroup.add(yesChoice);
		
		JLabel numberLabel = new JLabel("Phone");
		numberLabel.setBounds(1058, 531, 293, 23);
		numberLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		signUpPanel.add(numberLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(1154, 565, 217, 43);
		phoneField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		phoneField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		phoneField.setBackground(new Color(244, 244, 244));
		signUpPanel.add(phoneField);
		
		comboBoxNum = new JComboBox(number);
		comboBoxNum.setBounds(1058, 565, 95, 43);
		comboBoxNum.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		comboBoxNum.setBackground(new Color(244, 244, 244));
		comboBoxNum.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		signUpPanel.add(comboBoxNum);
		
		companyLabel = new JLabel("Company");
		companyLabel.setBounds(1429, 635, 293, 23);
		companyLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		companyLabel.setVisible(false);
		signUpPanel.add(companyLabel);
		
		companyField = new JTextField();
		companyField.setBounds(1429, 665, 319, 43);
		companyField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		companyField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		companyField.setBackground(new Color(244, 244, 244));
		companyField.setVisible(false);
		signUpPanel.add(companyField);
		
		JPanel submitButton = new JPanel();		
		submitButton.setBounds(1058, 773, 186, 44);
		submitButton.setLayout(null);
		submitButton.setBackground(new Color(15, 98, 254));
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                handleSubmitButtonClick();
				
			}
			public void mouseEntered(MouseEvent e) {
				submitButton.setBackground(new Color(230,230,230));
				submitButton.setBorder(new LineBorder(new Color(15, 98, 254)));
				submit.setForeground(new Color(15, 98, 254));
				
			}
			
			public void mouseExited(MouseEvent e) {
				submitButton.setBackground(new Color(15, 98, 254));
				submitButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(0, 0, 0)));
				submit.setForeground(new Color(255, 255, 255));

				
			}
		
			
		});
		signUpPanel.add(submitButton);
		
		 submit = new JLabel("Submit");
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		submit.setBounds(10, 11, 72, 23);
		submitButton.add(submit);
		bodyPanel.add(signUpPanel, "panelButton");
		bodyPanel.add(loginPanel, "createIBMAccPanelButton");
		
		//show the initial panel
		cardlayout.show(bodyPanel, "createIBMAccPanelButton");

		
	}
	
	private void handleSubmitButtonClick() {
	    String email = emailField.getText();
	    String password = new String(passwordField.getPassword());
	    String firstName = firstNameField.getText();
	    String lastName = lastNameField.getText();
	    String phone = comboBoxNum.getSelectedItem() + phoneField.getText();
	    String status = yesChoice.isSelected() ? "Student" : "Employee";
	    String company = noChoice.isSelected() ? companyField.getText() : null;
	    String residence = residenceField.getText();
	    String state = stateField.getText();

	    try (Connection conn = DriverManager.getConnection(dbUrl)) {
	        String sql = "INSERT INTO Client (Client_email, Client_password, Client_fname, Client_Iname, Client_contact, Client_Status, Company, Client_residence, Client_state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);
	            pstmt.setString(3, firstName);
	            pstmt.setString(4, lastName);
	            pstmt.setString(5, phone);
	            pstmt.setString(6, status);
	            if (company != null) {
	                pstmt.setString(7, company);
	            } else {
	                pstmt.setNull(7, Types.VARCHAR);
	            }
	            pstmt.setString(8, residence);
	            pstmt.setString(9, state);
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Sign-up successful!");

	            // Clear all input fields
	            emailField.setText("");
	            passwordField.setText("");
	            firstNameField.setText("");
	            lastNameField.setText("");
	            phoneField.setText("");
	            comboBoxNum.setSelectedIndex(0);
	            residenceField.setText("");
	            stateField.setText("");
	            buttonGroup.clearSelection();
	            companyField.setText("");
	            companyField.setVisible(false);
	            companyLabel.setVisible(false);

	            // Switch to loginPanel
	            CardLayout cardLayout = (CardLayout) bodyPanel.getLayout();
	            cardLayout.show(bodyPanel, "createIBMAccPanelButton");
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}




}
