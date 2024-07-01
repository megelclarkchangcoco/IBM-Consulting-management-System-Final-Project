package scratchName;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AdminDashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel firstlbl, lastlbl;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	static  String email;
	static  String senderEmail;
	static  String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=acctest;integratedSecurity=true;encrypt=false";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboardFrame frame = new AdminDashboardFrame(email);
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
	public AdminDashboardFrame(String email) {
		this.senderEmail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 370);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lastlbl = new JLabel("");
		lastlbl.setBounds(34, 110, 104, 37);
		panel.add(lastlbl);
		
		 firstlbl = new JLabel("");
		firstlbl.setBounds(168, 110, 104, 37);
		panel.add(firstlbl);
	}

	private void fetchData(String email) {
			String username = email;
		try {
			connection = DriverManager.getConnection(dbURL);
			String query = "SELECT * FROM Client WHERE Client_email ='" + username + "'";
			statement.executeQuery(query);
	        // Assuming you have JLabels named firstlbl and lastlbl
	        if (resultSet.next()) {
	            String clientFirstName = resultSet.getString("Client_fname");
	            String clientLastName = resultSet.getString("Client_Iname");

	            // Set the text of JLabels
	            firstlbl.setText(clientFirstName);
	            lastlbl.setText(clientLastName);
	        } else {
	            // Handle the case when no data is found for the given email
	            // You can display an error message or take appropriate action
	        };
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
