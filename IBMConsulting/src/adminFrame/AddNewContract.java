package adminFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AddNewContract extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel_2_1;
	private JPanel contentPane;
	private JTextField clientfirstnameField;
	private JTextField clientlastnameField;
	private JTextField consultantFirstnamefield;
	private JTextField consultantLastnamefield;
	private JTextField agreementtypeField;
	private JTextField projectField;
	private JTextField statusField;
	private JComboBox chooseStatusBox,projectTypeComboBox, projectComboBox;
    private JFileChooser fileChooser;
    private File selectedFile;
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static final String[] chooseAgreemet = {"Choose Agreement", "Full-Time", "Part-TIme"};
    static final String[] chooseProjectType = {"Choose Project Type", "Recurring", "one time project"};
    static final String[] chooseStatus = {"Choose Status", "Signed", "Unsigned"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewContract frame = new AddNewContract();
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
	public AddNewContract() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 759);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel.setBounds(0, 0, 687, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(638, 11, 39, 21);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(AddNewContract.class.getResource("/CschedulepanelImg/window-minimize (1).png")));
		lblNewLabel_1_3.setBounds(10, 0, 29, 21);
		panel_2_1.add(lblNewLabel_1_3);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(255, 255, 255));
		bodyPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		bodyPanel.setBounds(0, 44, 687, 715);
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel lblAdd = new JLabel("Add new Contract");
		lblAdd.setFont(new Font("IBM Plex Sans", Font.PLAIN, 36));
		lblAdd.setBounds(10, 0, 312, 64);
		bodyPanel.add(lblAdd);
		
		clientfirstnameField = new JTextField();
		clientfirstnameField.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		clientfirstnameField.setBounds(10, 96, 306, 38);
		bodyPanel.add(clientfirstnameField);
		clientfirstnameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Client First name");
		lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 71, 187, 27);
		bodyPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Client Last name");
		lblNewLabel_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(349, 71, 187, 27);
		bodyPanel.add(lblNewLabel_1);
		
		clientlastnameField = new JTextField();
		clientlastnameField.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		clientlastnameField.setColumns(10);
		clientlastnameField.setBounds(349, 96, 306, 38);
		bodyPanel.add(clientlastnameField);
		
		JLabel lblNewLabel_2 = new JLabel("Consultant First name");
		lblNewLabel_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 169, 245, 27);
		bodyPanel.add(lblNewLabel_2);
		
		consultantFirstnamefield = new JTextField();
		consultantFirstnamefield.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		consultantFirstnamefield.setColumns(10);
		consultantFirstnamefield.setBounds(10, 194, 306, 38);
		bodyPanel.add(consultantFirstnamefield);
		
		JLabel lblConsultantLastName = new JLabel("Consultant Last name");
		lblConsultantLastName.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblConsultantLastName.setBounds(349, 169, 245, 27);
		bodyPanel.add(lblConsultantLastName);
		
		consultantLastnamefield = new JTextField();
		consultantLastnamefield.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		consultantLastnamefield.setColumns(10);
		consultantLastnamefield.setBounds(349, 194, 306, 38);
		bodyPanel.add(consultantLastnamefield);
		
		JLabel lblAgreementType = new JLabel("Agreement Type");
		lblAgreementType.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblAgreementType.setBounds(10, 259, 187, 27);
		bodyPanel.add(lblAgreementType);
		
//		agreementtypeField = new JTextField();
//		agreementtypeField.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
//		agreementtypeField.setColumns(10);
//		agreementtypeField.setBounds(10, 462, 306, 38);
//		bodyPanel.add(agreementtypeField);
//		
		JLabel lblProjectType = new JLabel("Project Type");
		lblProjectType.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblProjectType.setBounds(349, 259, 187, 27);
		bodyPanel.add(lblProjectType);
		
//		projectField = new JTextField();
//		projectField.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
//		projectField.setColumns(10);
//		projectField.setBounds(371, 546, 306, 38);
//		bodyPanel.add(projectField);
		
		JPanel openFIlePanel = new JPanel();
		openFIlePanel.setBorder(new LineBorder(new Color(15, 98, 254), 2));
		openFIlePanel.setLayout(null);
		openFIlePanel.setBackground(new Color(255, 255, 255));
		openFIlePanel.setBounds(10, 381, 294, 55);
		bodyPanel.add(openFIlePanel);
		
		
		 lblNewLabel_2_1 = new JLabel("Upload a file");
		lblNewLabel_2_1.setBackground(new Color(15, 98, 254));
		lblNewLabel_2_1.setForeground(new Color(15, 98, 254));
		lblNewLabel_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 11, 173, 22);
		openFIlePanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AddNewContract.class.getResource("/LoginFrameImg/Vector.png")));
		lblNewLabel_3.setBounds(244, 11, 40, 33);
		openFIlePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6_1 = new JLabel("Contract File");
		lblNewLabel_6_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(10, 354, 187, 27);
		bodyPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Status");
		lblNewLabel_6_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
		lblNewLabel_6_2.setBounds(349, 354, 187, 27);
		bodyPanel.add(lblNewLabel_6_2);
		
//		statusField = new JTextField();
//		statusField.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
//		statusField.setColumns(10);
//		statusField.setBounds(80, 574, 306, 38);
//		bodyPanel.add(statusField);
		
		JPanel submitPanel = new JPanel();
		submitPanel.setBackground(new Color(15, 98, 254));
		submitPanel.setBounds(494, 462, 160, 38);
		bodyPanel.add(submitPanel);
		submitPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Submit");
		lblNewLabel_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 0, 78, 27);
		submitPanel.add(lblNewLabel_4);
		
		 // Add file chooser functionality
        fileChooser = new JFileChooser();
        openFIlePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = fileChooser.showOpenDialog(AddNewContract.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    lblNewLabel_2_1.setText(selectedFile.getName());
                }
            }
        });

         submitPanel = new JPanel();
        submitPanel.setBackground(new Color(15, 98, 254));
        submitPanel.setBounds(494, 462, 160, 38);
        bodyPanel.add(submitPanel);
        submitPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitContract();
            }
        });
        submitPanel.setLayout(null);

         lblNewLabel_4 = new JLabel("Submit");
        lblNewLabel_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setBounds(10, 0, 78, 27);
        submitPanel.add(lblNewLabel_4);
        
        chooseStatusBox = new JComboBox(chooseStatus);
        chooseStatusBox.setBounds(349, 379, 306, 38);
        bodyPanel.add(chooseStatusBox);
        
        projectTypeComboBox = new JComboBox(chooseAgreemet);
        projectTypeComboBox.setBounds(10, 284, 306, 38);
        bodyPanel.add(projectTypeComboBox);
        
         projectComboBox = new JComboBox(chooseProjectType);
        projectComboBox.setBounds(349, 284, 306, 38);
        bodyPanel.add(projectComboBox);

        // Add submit functionality
        
	}     

	private void submitContract() {
	    // Check if all fields are filled
		 if (areAllFieldsFilled() && selectedFile != null && !chooseStatusBox.getSelectedItem().equals("Choose Status") && !projectComboBox.getSelectedItem().equals("Choose Project Type") && !projectTypeComboBox.getSelectedItem().equals("Choose Agreement")) {
		        try {
	            // Get current date
	            java.time.LocalDate currentDate = java.time.LocalDate.now();

	            // Database connection (replace with your actual connection details)
	            Connection conn = DriverManager.getConnection(dbUrl);

	            // Get client_id
	            int clientId = getClientId(conn);

	            // Get consultant_id
	            int consultantId = getConsultantId(conn);

	            // Insert into Contract table
	            String sql = "INSERT INTO Contract (consultant_id, client_id, contract_file, contract_status, Project_type, Agreement_type, Contract_name, Contract_Date) VALUES (?,?,?,?,?,?,?,?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, consultantId);
	            pstmt.setInt(2, clientId);
	            pstmt.setBinaryStream(3, new FileInputStream(selectedFile), (int) selectedFile.length());
	            pstmt.setString(4, (String) chooseStatusBox.getSelectedItem());
	            pstmt.setString(5, (String) projectComboBox.getSelectedItem());  // Save projectField text in Project_type column
	            pstmt.setString(6, (String) projectTypeComboBox.getSelectedItem());  // Save agreementtypeField text in Agreement_type column
	            pstmt.setString(7, selectedFile.getName());  // Save file name in Contract_name column
	            pstmt.setDate(8, java.sql.Date.valueOf(currentDate));  // Set current date in Contract_Date column
	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(this, "Contract added successfully!");
	                clearFields();
	            } else {
	                JOptionPane.showMessageDialog(this, "Failed to add contract.");
	            }

	            conn.close();
	        } catch (SQLException | FileNotFoundException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	        }
	    } else if (!chooseStatusBox.getSelectedItem().equals("Choose")) {
	        JOptionPane.showMessageDialog(this, "Please select 'Choose' in the status box.");
	    } else {
	        JOptionPane.showMessageDialog(this, "Please fill all fields and select a file.");
	    }
	}

	private boolean areAllFieldsFilled() {
	    return !clientfirstnameField.getText().isEmpty() &&
	           !clientlastnameField.getText().isEmpty() &&
	           !consultantFirstnamefield.getText().isEmpty() &&
	           !consultantLastnamefield.getText().isEmpty() &&
	           !chooseStatusBox.getSelectedItem().equals("Choose Status") &&
	           !projectTypeComboBox.getSelectedItem().equals("Choose Agreement") &&
	           !projectComboBox.getSelectedItem().equals("Choose Project Type");
	}

    private int getClientId(Connection conn) throws SQLException {
        String sql = "SELECT client_id FROM Client WHERE Client_fname = ? AND Client_Iname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, clientfirstnameField.getText());
        pstmt.setString(2, clientlastnameField.getText());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("client_id");
        } else {
            // Client not found, you can choose to:
            // 1. Throw a custom exception
            // throw new ClientNotFoundException("Client not found");
            
            // 2. Return a special value (e.g., -1) to indicate client not found
            // return -1;
            
            // 3. Automatically insert the new client and return the new id
            return insertNewClient(conn);
        }
    }

    private int insertNewClient(Connection conn) throws SQLException {
        String sql = "INSERT INTO Client (Client_fname, Client_Iname) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, clientfirstnameField.getText());
        pstmt.setString(2, clientlastnameField.getText());
        pstmt.executeUpdate();
        
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("Failed to insert new client");
        }
    }

    private int getConsultantId(Connection conn) throws SQLException {
        String sql = "SELECT Consultant_id FROM Consultant WHERE consultant_fname = ? AND consultant_lname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, consultantFirstnamefield.getText());
        pstmt.setString(2, consultantLastnamefield.getText());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("Consultant_id");
        }
        throw new SQLException("Consultant not found");
    }

    private void clearFields() {
        clientfirstnameField.setText("");
        clientlastnameField.setText("");
        consultantFirstnamefield.setText("");
        consultantLastnamefield.setText("");
        chooseStatusBox.setSelectedItem("Choose Status");
        projectTypeComboBox.setSelectedItem("Choose Agreement");
        projectComboBox.setSelectedItem("Choose Project Type");
        selectedFile = null;
        lblNewLabel_2_1.setText("Upload a file");

    }
}
