package scratchName;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;

public class LoginFrames extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailField;
	private JComboBox comboBox;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	private String dbUrl ="jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=accTest;integratedSecurity=true;encrypt=false;";
	
	static final String[] choose = {"Client", "Consultant", "Admin"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrames frame = new LoginFrames();
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
	public LoginFrames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 413, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(64, 138, 295, 36);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = emailField.getText();
				
				authenticateUsername(username);
				AdminDashboardFrame ad = new AdminDashboardFrame(username);
				ad.setVisible(true);
				dispose();

			}


		});
		loginbtn.setBounds(147, 283, 89, 23);
		panel.add(loginbtn);
		
		
		
		 comboBox = new JComboBox(choose);
		comboBox.setBounds(65, 75, 295, 22);
		panel.add(comboBox);
	}
	
	private boolean authenticateUsername(String username) {
		
		try {
			connection = DriverManager.getConnection(dbUrl);
			String query = "SELECT * FROM Client WHERE Client_email = ?";
			statement =connection.prepareStatement(query);
			
			
			statement.setString(1, username);
			
			resultSet =statement.executeQuery();
			
			return resultSet.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	 private void authenticateAndOpenDashboard(String username) {
	        if (authenticateUsername(username)) {
	            AdminDashboardFrame adminDashboard = new AdminDashboardFrame(username);
	            adminDashboard.setVisible(true);
	            dispose(); // Close the login frame
	        } else {
	            // Handle invalid login (e.g., show an error message)
	        }
	    }
	
	
}
