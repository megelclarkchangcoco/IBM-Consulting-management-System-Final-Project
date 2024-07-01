package sratch;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=accTest;integratedSecurity=true;encrypt=false;";
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(52, 93, 329, 58);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email ");
		lblNewLabel.setBounds(52, 53, 158, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 175, 158, 29);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(52, 239, 329, 58);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = textField.getText();
				String password = (String) passwordField.getText();
				
				
				if(authenticateUser(username, password)) {
					JOptionPane.showMessageDialog(contentPane, "Login Succesfully");
				}else {
					JOptionPane.showMessageDialog(contentPane, "Login Faileds");

				}
			}

			private boolean authenticateUser(String username, String password) {
				
				try(Connection conn = DriverManager.getConnection(dbURL)){
					String query = "SELECT * FROM students WHERE student_id = ? AND student_password = ?";
					
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					
					ResultSet result = pstmt.executeQuery();
					
					return result.next();
				}catch(SQLException e){
					e.printStackTrace();
					return false;
					
				}
				
				
			}
		});
		btnNewButton.setBounds(174, 357, 89, 23);
		contentPane.add(btnNewButton);
	}
}
