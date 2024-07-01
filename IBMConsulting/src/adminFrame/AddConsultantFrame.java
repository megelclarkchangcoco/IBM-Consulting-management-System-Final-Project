package adminFrame;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class AddConsultantFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField statusField;
	private JComboBox<String> expertiseComboBox;
	public static String[] serviceList = {"Operations","Customer Experience","Marketing","Finance","Talent Management","Supply Chain","Data strategy","Artificial Intelligence","Blockchain","Cloud Computing","Hybrid Cloud","Application Services","Cybersecurity","IT Infrastructure","Analytics","E-commerce"};
	private static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConsultantFrame frame = new AddConsultantFrame();
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
	public AddConsultantFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1219, 605);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel.setBounds(0, 65, 1219, 540);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Consultant");
		lblNewLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 36));
		lblNewLabel.setBounds(31, 11, 312, 64);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setFont(new Font("IBM Plex Sans", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(31, 101, 225, 44);
		panel.add(lblNewLabel_1_1);

		firstnameField = new JTextField();
		firstnameField.setBounds(31, 144, 312, 49);
		panel.add(firstnameField);
		firstnameField.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1.setFont(new Font("IBM Plex Sans", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(411, 101, 225, 44);
		panel.add(lblNewLabel_1_1_1);

		lastnameField = new JTextField();
		lastnameField.setColumns(10);
		lastnameField.setBounds(411, 144, 312, 49);
		panel.add(lastnameField);

		JLabel lblNewLabel_1_1_2 = new JLabel("Status");
		lblNewLabel_1_1_2.setFont(new Font("IBM Plex Sans", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(802, 101, 225, 44);
		panel.add(lblNewLabel_1_1_2);

		statusField = new JTextField();
		statusField.setColumns(10);
		statusField.setBounds(802, 144, 312, 49);
		panel.add(statusField);

		JLabel lblNewLabel_1_2 = new JLabel("Add Expertise");
		lblNewLabel_1_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(31, 218, 225, 44);
		panel.add(lblNewLabel_1_2);

		expertiseComboBox = new JComboBox<>(serviceList);
		expertiseComboBox.setBounds(31, 285, 312, 44);
		panel.add(expertiseComboBox);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertConsultantData();
			}
		});
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(863, 421, 251, 44);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Submit");
		lblNewLabel_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(74, 11, 107, 22);
		panel_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_1.setBounds(0, 0, 1219, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("IBM Consulting");
		lblNewLabel_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 225, 44);
		panel_1.add(lblNewLabel_1);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(AddConsultantFrame.class.getResource("/LoginFrameImg/ibm_logo.png")));
		logo.setBounds(1028, 11, 74, 34);
		panel_1.add(logo);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(1170, 13, 39, 32);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(AddConsultantFrame.class.getResource("/CschedulepanelImg/window-minimize (1).png")));
		lblNewLabel_1_3.setBounds(10, 0, 29, 32);
		panel_2_1.add(lblNewLabel_1_3);
	}

	private void insertConsultantData() {
		String firstName = firstnameField.getText();
		String lastName = lastnameField.getText();
		String status = statusField.getText();
		String expertise = (String) expertiseComboBox.getSelectedItem();
		int consultantId = generateConsultantId();

		if (firstName.isEmpty() || lastName.isEmpty() || status.isEmpty() || expertise.equals("Choose Expertise")) {
			// Show error message
			System.out.println("Please fill in all fields and select an expertise.");
			return;
		}

		try {
			Connection connection = DriverManager.getConnection(dbUrl);
			String query = "INSERT INTO Consultant (Consultant_id, consultant_fname, consultant_Lname, consultant_status, Expertise_consultant) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, consultantId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, status);
			pstmt.setString(5, expertise);
			pstmt.executeUpdate();
			System.out.println("Data inserted successfully.");
            JOptionPane.showMessageDialog(this, "Service saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int generateConsultantId() {
		Random rand = new Random();
		return 20260000 + rand.nextInt(10000000);
	}
}
