package adminFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class HTransactionsPanel extends JPanel {
	private JTextField clientFNameField;
	private JTextField clientLastNameField;
	private JTextField consultantFirstNameField;
	private JTextField consultantLastNameField;
	private JTextField contractIDField;
	private DefaultTableModel model ;
	private JComboBox transactionStatus,service;
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

	public static String[] serviceList = {"Operations","Customer Experience","Marketing","Finance","Talent Management","Supply Chain","Data strategy","Artificial Intelligence","Blockchain","Cloud Computing","Hybrid Cloud","Application Services","Cybersecurity","IT Infrastructure","Analytics","E-commerce"};
	public static String[] statusList = {"Completed", "Ongoing"};
	/**
	 * Create the panel.
	 */
	public HTransactionsPanel() {
		setBounds(0, 0, 1560, 864);
		setLayout(null);
		setOpaque(false);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 0, 1560, 864);
		bodyPanel.setBackground(new Color (255,255,255));
		bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		bodyPanel.setLayout(null);
		add(bodyPanel);
		
		JLabel transactionsLabel = new JLabel("Transactions");
		transactionsLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		transactionsLabel.setBounds(41, 44, 323, 58);
		bodyPanel.add(transactionsLabel);
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		addPanel.setBackground(new Color(255, 255, 255));
		addPanel.setBounds(1144, 0, 416, 864);
		addPanel.setLayout(null);
		bodyPanel.add(addPanel);
		
		JLabel addLabel = new JLabel("Add new transaction");
		addLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		addLabel.setBounds(27, 34, 259, 38);
		addPanel.add(addLabel);
		
		JLabel clientNameLabel = new JLabel("Client First Name");
		clientNameLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		clientNameLabel.setBounds(27, 105, 330, 22);
		addPanel.add(clientNameLabel);
		
		JLabel ClientLastNameLabel = new JLabel("Client Last Name");
		ClientLastNameLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		ClientLastNameLabel.setBounds(27, 196, 330, 22);
		addPanel.add(ClientLastNameLabel);
		
		clientFNameField = new JTextField();
		clientFNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		clientFNameField.setBounds(27, 138, 353, 31);
		clientFNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		clientFNameField.setBackground(new Color(244, 244, 244));
		addPanel.add(clientFNameField);
		clientFNameField.setColumns(10);
		
		clientLastNameField =new JTextField();
		clientLastNameField.setColumns(10);
		clientLastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		clientLastNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		clientLastNameField.setBackground(new Color(244, 244, 244));
		clientLastNameField.setBounds(27, 221, 353, 31);
		addPanel.add(clientLastNameField);
		
		JLabel consultantFirstNameLabel = new JLabel("Consultant First Name");
		consultantFirstNameLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		consultantFirstNameLabel.setBounds(27, 278, 330, 22);
		addPanel.add(consultantFirstNameLabel);
		
		consultantFirstNameField = new JTextField();
		consultantFirstNameField.setColumns(10);
		consultantFirstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		consultantFirstNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		consultantFirstNameField.setBackground(new Color(244, 244, 244));
		consultantFirstNameField.setBounds(27, 304, 353, 31);
		addPanel.add(consultantFirstNameField);
		
		JLabel consultantLastNameLabel = new JLabel("Consultant Last Name");
		consultantLastNameLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		consultantLastNameLabel.setBounds(27, 358, 330, 22);
		addPanel.add(consultantLastNameLabel);
		
		consultantLastNameField = new JTextField();
		consultantLastNameField.setColumns(10);
		consultantLastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		consultantLastNameField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
		consultantLastNameField.setBackground(new Color(244, 244, 244));
		consultantLastNameField.setBounds(27, 391, 353, 31);
		addPanel.add(consultantLastNameField);
		
		JLabel serviceLabel = new JLabel("Service");
		serviceLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		serviceLabel.setBounds(27, 528, 330, 22);
		addPanel.add(serviceLabel);
		
		JLabel lblTransactionStatus = new JLabel("Transaction Status");
		lblTransactionStatus.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
		lblTransactionStatus.setBounds(27, 626, 330, 22);
		addPanel.add(lblTransactionStatus);
		
		service = new JComboBox(serviceList);
		service.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN,18));
		service.setBackground(new Color(244,244,244));
		service.setBorder(BorderFactory.createMatteBorder(0,0,2,0, new Color(22,22,22)));
		service.setBounds(27, 555, 353, 43);
		addPanel.add(service);
		
		 service.addItem("Finance");
		 service.addItem("Data Strategy");
		 service.addItem("Data Architecture");
		 
		 transactionStatus = new JComboBox(statusList);
			transactionStatus.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN,18));
			transactionStatus.setBackground(new Color(244,244,244));
			transactionStatus.setBorder(BorderFactory.createMatteBorder(0,0,2,0, new Color(22,22,22)));
			transactionStatus.setBounds(27, 659, 353, 43);
			addPanel.add(transactionStatus);
			
			JTextField searchField = new JTextField();
			searchField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
			searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
			searchField.setBackground(new Color(244, 244, 244));
			searchField.setBounds(41, 113, 425, 39);
			bodyPanel.add(searchField);
			searchField.setColumns(10);
			
			JButton searchButton = new JButton("Search");
			searchButton.setBackground(new Color(15, 98, 254));
			searchButton.setForeground(new Color(255, 255, 255));
			searchButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
			searchButton.setBounds(476, 113, 112, 39);
			bodyPanel.add(searchButton);
			
			JLabel contractLabel = new JLabel("Contract ID");
			contractLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
			contractLabel.setBounds(27, 444, 330, 22);
			addPanel.add(contractLabel);
			
			contractIDField = new JTextField();
			contractIDField.setColumns(10);
			contractIDField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
			contractIDField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 18));
			contractIDField.setBackground(new Color(244, 244, 244));
			contractIDField.addKeyListener(new KeyAdapter() {
			    @Override
			    public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();
			        if (!Character.isDigit(c) || contractIDField.getText().length() >= 8) {
			            e.consume();
			        }
			    }
			});
			contractIDField.setBounds(27, 472, 353, 31);
			addPanel.add(contractIDField);
			
			JButton addButton = new JButton("Add transaction");
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addTransaction();
				}
			});
			addButton.setBackground(new Color(15, 98, 254));
			addButton.setForeground(new Color(255, 255, 255));
			addButton.setFont(new Font("IBM Plex Sans", Font.PLAIN, 18));
			addButton.setBounds(27, 771, 353, 43);
			addPanel.add(addButton);
			
			 model = new DefaultTableModel();
			 model.setColumnIdentifiers(new String[] {"Employee number", "First Name", "Last name", "Signed Contract", "Status"});

	        JTable table = new JTable(model);
	        table.setRowHeight(52);
	        
	        // Custom renderer for alternating row colors
	        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	            private static final Color COLOR1 = new Color(244, 244, 244);
	            private static final Color COLOR2 = new Color(255, 255, 255);

	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                if (!isSelected) {
	                    c.setBackground(row % 2 == 0 ? COLOR1 : COLOR2);
	                }
	                return c;
	            }
	        });
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(41, 182, 1079, 660);
	        bodyPanel.add(scrollPane);
	}
	private void addTransaction() {
	    String clientFirstName = clientFNameField.getText();
	    String clientLastName = clientLastNameField.getText();
	    String consultantFirstName = consultantFirstNameField.getText();
	    String consultantLastName = consultantLastNameField.getText();
	    String contractID = contractIDField.getText();
	    String serviceName = (String) service.getSelectedItem();
	    String status = (String) transactionStatus.getSelectedItem();

	    if (clientFirstName.isEmpty() || clientLastName.isEmpty() || consultantFirstName.isEmpty() || consultantLastName.isEmpty() || contractID.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        Connection conn = DriverManager.getConnection(dbUrl);
	        Statement stmt = conn.createStatement();

	        // Retrieve the service ID based on the selected service name
	        String serviceSql = "SELECT service_id FROM Service WHERE service_name = ?";
	        PreparedStatement pstmt = conn.prepareStatement(serviceSql);
	        pstmt.setString(1, serviceName);
	        ResultSet rs = pstmt.executeQuery();
	        if (!rs.next()) {
	            JOptionPane.showMessageDialog(null, "Service not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        int serviceID = rs.getInt("service_id");

	        // Retrieve the client ID based on the client first and last names
	        String clientSql = "SELECT client_id FROM Client WHERE Client_fname = ? AND Client_Iname = ?";
	        pstmt = conn.prepareStatement(clientSql);
	        pstmt.setString(1, clientFirstName);
	        pstmt.setString(2, clientLastName);
	        rs = pstmt.executeQuery();
	        if (!rs.next()) {
	            JOptionPane.showMessageDialog(null, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        int clientID = rs.getInt("client_id");

	        // Retrieve the consultant ID based on the consultant first and last names
	        String consultantSql = "SELECT consultant_id FROM Consultant WHERE consultant_fname = ? AND consultant_lname = ?";
	        pstmt = conn.prepareStatement(consultantSql);
	        pstmt.setString(1, consultantFirstName);
	        pstmt.setString(2, consultantLastName);
	        rs = pstmt.executeQuery();
	        if (!rs.next()) {
	            JOptionPane.showMessageDialog(null, "Consultant not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        int consultantID = rs.getInt("consultant_id");

	        // Check if the contract ID exists in the Contract table
	        String contractSql = "SELECT contract_id FROM Contract WHERE contract_id = ?";
	        pstmt = conn.prepareStatement(contractSql);
	        pstmt.setString(1, contractID);
	        rs = pstmt.executeQuery();
	        if (!rs.next()) {
	            JOptionPane.showMessageDialog(null, "Contract not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Insert the new transaction without specifying the transaction ID
	        String insertSql = "INSERT INTO Transactions (service_id, contract_id, client_id, consultant_id, transaction_status) VALUES (?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
	        pstmt.setInt(1, serviceID);
	        pstmt.setString(2, contractID);
	        pstmt.setInt(3, clientID);
	        pstmt.setInt(4, consultantID);
	        pstmt.setString(5, status);
	        pstmt.executeUpdate();

	        // Get the generated transaction ID
	        rs = pstmt.getGeneratedKeys();
	        int transactionID = 0;
	        if (rs.next()) {
	            transactionID = rs.getInt(1); // Assuming transaction_id is an auto-generated key
	        }

	        JOptionPane.showMessageDialog(null, "Transaction added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

	        // Add the new transaction to the table
	        model.addRow(new Object[]{transactionID, serviceID, contractID, clientID, consultantID, status});

	        // Clear the input fields
	        clientFNameField.setText("");
	        clientLastNameField.setText("");
	        consultantFirstNameField.setText("");
	        consultantLastNameField.setText("");
	        contractIDField.setText("");

	        rs.close();
	        pstmt.close();
	        stmt.close();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}

//	private void addTransaction() {
//        String clientFirstName = clientFNameField.getText();
//        String clientLastName = clientLastNameField.getText();
//        String consultantFirstName = consultantFirstNameField.getText();
//        String consultantLastName = consultantLastNameField.getText();
//        String contractID = contractIDField.getText();
//        String serviceName = (String) service.getSelectedItem();
//        String status = (String) transactionStatus.getSelectedItem();
//
//        if (clientFirstName.isEmpty() || clientLastName.isEmpty() || consultantFirstName.isEmpty() || consultantLastName.isEmpty() || contractID.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        try {
//            Connection conn = DriverManager.getConnection(dbUrl);
//            Statement stmt = conn.createStatement();
//
//            // Generate a random 8-digit number for the transaction ID
//            int transactionID = (int) (Math.random() * 90000000) + 10000000;
//
//            // Retrieve the service ID based on the selected service name
//            String serviceSql = "SELECT service_id FROM Service WHERE service_name = ?";
//            PreparedStatement pstmt = conn.prepareStatement(serviceSql);
//            pstmt.setString(1, serviceName);
//            ResultSet rs = pstmt.executeQuery();
//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(null, "Service not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int serviceID = rs.getInt("service_id");
//
//            // Retrieve the client ID based on the client first and last names
//            String clientSql = "SELECT client_id FROM Client WHERE Client_fname = ? AND Client_Iname = ?";
//            pstmt = conn.prepareStatement(clientSql);
//            pstmt.setString(1, clientFirstName);
//            pstmt.setString(2, clientLastName);
//            rs = pstmt.executeQuery();
//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(null, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int clientID = rs.getInt("client_id");
//
//            // Retrieve the consultant ID based on the consultant first and last names
//            String consultantSql = "SELECT consultant_id FROM Consultant WHERE consultant_fname = ? AND consultant_lname = ?";
//            pstmt = conn.prepareStatement(consultantSql);
//            pstmt.setString(1, consultantFirstName);
//            pstmt.setString(2, consultantLastName);
//            rs = pstmt.executeQuery();
//            if (!rs.next()) {
//                JOptionPane.showMessageDialog(null, "Consultant not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int consultantID = rs.getInt("consultant_id");
//
//            // Insert the new transaction
//            String insertSql = "INSERT INTO Transactions (transaction_id, service_id, contract_id, client_id, consultant_id, transaction_status) VALUES (?, ?, ?, ?, ?, ?)";
//            pstmt = conn.prepareStatement(insertSql);
//            pstmt.setInt(1, transactionID);
//            pstmt.setInt(2, serviceID);
//            pstmt.setString(3, contractID);
//            pstmt.setInt(4, clientID);
//            pstmt.setInt(5, consultantID);
//            pstmt.setString(6, status);
//            pstmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Transaction added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//
//            // Add the new transaction to the table
//            model.addRow(new Object[]{transactionID, serviceID, contractID, clientID, consultantID, status});
//
//            // Clear the input fields
//            clientFNameField.setText("");
//            clientLastNameField.setText("");
//            consultantFirstNameField.setText("");
//            consultantLastNameField.setText("");
//            contractIDField.setText("");
//
//            rs.close();
//            pstmt.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}
