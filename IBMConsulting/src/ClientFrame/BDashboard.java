package ClientFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class BDashboard extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table, table_2;
    private JLabel comQueryLabel,serQueryLabel,totQueryLabel;
    private JTextArea inquiryTextArea;
    private DefaultTableModel model,model2;
    
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String senderEmail;

    /**
     * Create the panel.
     */
    public BDashboard(String email) {
    	this.senderEmail=email;
        setBounds(0, 0, 1570, 877);
        setLayout(null);
        setOpaque(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(1, 0, 1570, 877);
        panel.setLayout(null);
        add(panel);
        
        JLabel dashboardLabel = new JLabel("Dashboard");
        dashboardLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        dashboardLabel.setBounds(56, 25, 256, 47);
        panel.add(dashboardLabel);
        
//===================================================================  
        
        JPanel completedPanel = new JPanel();
        completedPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        completedPanel.setBackground(new Color(255, 255, 255));
        completedPanel.setBounds(56, 96, 333, 164);
        completedPanel.setLayout(null);
        panel.add(completedPanel);
        
        JLabel comProjectLabel = new JLabel("Completed projects");
        comProjectLabel.setLocation(30, 112);
        comProjectLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 20));
        comProjectLabel.setSize(194, 26);
        completedPanel.add(comProjectLabel);
        
        comQueryLabel = new JLabel();
        comQueryLabel.setForeground(new Color(15, 98, 254));
        comQueryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 56));
        comQueryLabel.setBounds(30, 25, 250, 73);
        completedPanel.add(comQueryLabel);

        JLabel iconLabel1 = new JLabel();
        iconLabel1.setIcon(new ImageIcon(BDashboard.class.getResource("/MykieImga/octicon_project-24.png")));
//        iconLabel1.setIcon(new ImageIcon(BDashboard.class.getResource("octicon_project-24.png"))); 
        iconLabel1.setBounds(250, 35, 50, 50);
        completedPanel.add(iconLabel1);
        
//===================================================================  
        
        JPanel servicesPanel = new JPanel();
        servicesPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        servicesPanel.setBackground(Color.WHITE);
        servicesPanel.setBounds(429, 96, 333, 164);
        servicesPanel.setLayout(null);
        panel.add(servicesPanel);
        
        JLabel serLabel = new JLabel("Availed services");
        serLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 20));
        serLabel.setBounds(30, 112, 177, 26);
        servicesPanel.add(serLabel);
        
        serQueryLabel = new JLabel("");
        serQueryLabel.setForeground(new Color(15, 98, 254));
        serQueryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 56));
        serQueryLabel.setBounds(30, 25, 132, 73);
        servicesPanel.add(serQueryLabel);
        
        JLabel iconLabel2 = new JLabel();
        iconLabel2.setIcon(new ImageIcon(BDashboard.class.getResource("/MykieImga/eos-icons_service-outlined.png")));
//        iconLabel2.setIcon(new ImageIcon(BDashboard.class.getResource("eos-icons_service-outlined.png"))); 
        iconLabel2.setBounds(250, 30, 50, 50);
        servicesPanel.add(iconLabel2);
        
//===================================================================  
        
        JPanel totalPanel = new JPanel();
        totalPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        totalPanel.setBackground(Color.WHITE);
        totalPanel.setBounds(801, 96, 333, 164);
        totalPanel.setLayout(null);
        panel.add(totalPanel);
        
        JLabel totLabel = new JLabel("Total signed contracts");
        totLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 20));
        totLabel.setBounds(30, 112, 214, 26);
        totalPanel.add(totLabel);
        
         totQueryLabel = new JLabel("");
        totQueryLabel.setForeground(new Color(15, 98, 254));
        totQueryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 56));
        totQueryLabel.setBounds(30, 25, 132, 73);
        totalPanel.add(totQueryLabel);
        
        JLabel iconLabel3 = new JLabel();
        iconLabel3.setIcon(new ImageIcon(BDashboard.class.getResource("/MykieImga/material-symbols-light_contract-outline.png")));
//        iconLabel3.setIcon(new ImageIcon(BDashboard.class.getResource("material-symbols-light_contract-outline.png"))); 
        iconLabel3.setBounds(250, 30, 50, 50);
        totalPanel.add(iconLabel3);
        
//===================================================================  
        
        JPanel ongoingPanel = new JPanel();
        ongoingPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        ongoingPanel.setBackground(Color.WHITE);
        ongoingPanel.setBounds(1174, 96, 333, 164);
        ongoingPanel.setLayout(null);
        panel.add(ongoingPanel);
        
        JLabel ongLabel = new JLabel("Ongoing projects");
        ongLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 20));
        ongLabel.setBounds(30, 112, 177, 26);
        ongoingPanel.add(ongLabel);
        
        JLabel ongQueryLabel = new JLabel("11");
        ongQueryLabel.setForeground(new Color(15, 98, 254));
        ongQueryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 56));
        ongQueryLabel.setBounds(30, 25, 132, 73);
        ongoingPanel.add(ongQueryLabel);
        
        JLabel iconLabel4 = new JLabel();
        iconLabel4.setIcon(new ImageIcon(BDashboard.class.getResource("/MykieImga/octicon_project-symlink-16.png")));
//        iconLabel4.setIcon(new ImageIcon(BDashboard.class.getResource("octicon_project-symlink-16.png"))); 
        iconLabel4.setBounds(255, 30, 50, 50);
        ongoingPanel.add(iconLabel4);
        
//===================================================================  
        
        JPanel preferredPanel = new JPanel();
        preferredPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        preferredPanel.setBackground(Color.WHITE);
        preferredPanel.setBounds(56, 296, 666, 289);
        preferredPanel.setLayout(null);
        panel.add(preferredPanel);
        
        JLabel prefLabel = new JLabel("Preferred Consultants");
        prefLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        prefLabel.setBounds(30, 25, 305, 32);
        preferredPanel.add(prefLabel);
        
		 model = new DefaultTableModel();
		 model.setColumnIdentifiers(new String[] {"Name", "Total Appointments", "Total Services Availed"});

        
        table = new JTable(model);
        table.setGridColor(new Color(255, 255, 255));
        table.setBorder(null);
        
        populateTable();
        // Set row height and renderer
        setUpTable(table);
        table.setBounds(2, 68, 663, 199);
        preferredPanel.add(table);
        
//===================================================================  
        
        JPanel inquiryPanel = new JPanel();
        inquiryPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        inquiryPanel.setBackground(Color.WHITE);
        inquiryPanel.setBounds(56, 612, 666, 216);
        inquiryPanel.setLayout(null);
        panel.add(inquiryPanel);
        
        JLabel inqLabel = new JLabel("Current Inquiry");
        inqLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        inqLabel.setBounds(30, 25, 305, 32);
        inquiryPanel.add(inqLabel);
        
         inquiryTextArea = new JTextArea();
        inquiryTextArea.setColumns(1);
        inquiryTextArea.setEditable(false);
        inquiryTextArea.setForeground(new Color(0, 0, 0));
        inquiryTextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        inquiryTextArea.setEnabled(false);
        inquiryTextArea.setBounds(30, 71, 608, 119);
        inquiryPanel.add(inquiryTextArea);
        loadInquiryData();

//===================================================================  
        
        JPanel unsignedPanel = new JPanel();
        unsignedPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        unsignedPanel.setBackground(Color.WHITE);
        unsignedPanel.setBounds(760, 296, 747, 289);
        unsignedPanel.setLayout(null);
        panel.add(unsignedPanel);
        
        JLabel unsPanel = new JLabel("Unsigned contracts");
        unsPanel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        unsPanel.setBounds(30, 25, 293, 32);
        unsignedPanel.add(unsPanel);
        
        model2 = new DefaultTableModel();
	   model2.setColumnIdentifiers(new String[] {"Name", "Consultant", "Date Uploaded", "Agreement Type"});

        
        table_2 = new JTable(model2);
        table_2.setRowHeight(50);
        table_2.setGridColor(new Color(255, 255, 255));
        displayData(email);
        
        // Set up table
        setUpTable(table_2);
        table_2.setBounds(2, 68, 735, 199);
        unsignedPanel.add(table_2);

        
        PieChartPanel availedPanel = new PieChartPanel();
        availedPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        availedPanel.setBackground(Color.WHITE);
        availedPanel.setBounds(760, 612, 747, 216);
        availedPanel.setLayout(null);
        panel.add(availedPanel);
        
        JLabel avaLabel = new JLabel("Availed Services");
        avaLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        avaLabel.setBounds(30, 25, 305, 32);
        availedPanel.add(avaLabel);
        countCompletedTransactions();
        countSigneContract();
        countOnGoin();
    }
    
    private void setUpTable(JTable table) {
        table.setRowHeight(50);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            private final Color COLOR1 = new Color(244, 244, 244);
            private final Color COLOR2 = new Color(255, 255, 255);

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? COLOR1 : COLOR2);
                }
                setHorizontalAlignment(CENTER);  // Center alignment
                
                Font font = c.getFont();
                if (row == 0) { 
                    c.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
                } else { 
                    c.setFont(new Font("IBM Plex Sans Regular", Font.PLAIN, 15)); 
                }
                
                return c;
            }
        };
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    private void loadInquiryData() {
    	try (Connection conn = DriverManager.getConnection(dbURL)) {
    		 String query = "SELECT TOP 3 problem, date FROM Inquiry WHERE client_email = ? ORDER BY inquiry_id DESC";
    		 try (PreparedStatement pstmt = conn.prepareStatement(query)) {
    		      pstmt.setString(1, senderEmail);
    		        try (ResultSet rs = pstmt.executeQuery()) {
    		             int count = 0;
    		             while (rs.next() && count < 3) {
    		                String problem = rs.getString("problem");
    		                Date date = rs.getDate("date");
    		                String dateString = (date != null) ? date.toString() : "";

    		               switch (count) {
    		                  case 0:
    		                    // Current inquiry
    		                	  inquiryTextArea.setLineWrap(true);
    		                	  inquiryTextArea.setWrapStyleWord(true);
    		                	  inquiryTextArea.setText(problem);
    		                  // dateField.setText(dateString);
    		                       break;              
    		                 }
    		               count++;
    		            }
    		        }
    		 }
    	   } catch (SQLException e) {
    		   e.printStackTrace();
    		  JOptionPane.showMessageDialog(this, "Error loading inquiry data: " + e.getMessage());
    	   }
    	}
    public void populateTable() {
        try (Connection conn = DriverManager.getConnection(dbURL)) {
            String query = "SELECT c.consultant_fname, ca.agreement_type, ca.contract_status " +
                    "FROM Contract ca " +
                    "JOIN Consultant c ON ca.consultant_id = c.consultant_id";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {

                    while (rs.next()) {
                        String consultantName = rs.getString("consultant_fname");
                        String agreementType = rs.getString("agreement_type");
                        String contractStatus = rs.getString("contract_status");

                        // count total of agreement_type and contract_status
                        int totalAppointments = countAgreementType(agreementType, conn);
                        int totalServices = countContractStatus(contractStatus, conn);

                        model.addRow(new Object[] {consultantName, totalAppointments, totalServices});
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    private int countAgreementType(String agreementType, Connection conn) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM Contract WHERE agreement_type = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, agreementType);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                return rs.getInt("count");
            }
        }
    }

    private int countContractStatus(String contractStatus, Connection conn) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM Contract WHERE contract_status = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, contractStatus);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                return rs.getInt("count");
            }
        }
    }
    public void displayData(String inheritedEmail) {
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt1 = conn.prepareStatement("SELECT Client_ID FROM Client WHERE Client_email = ?");
             PreparedStatement pstmt2 = conn.prepareStatement("SELECT Contract_Name, consultant_id, Contract_Date, Agreement_Type FROM Contract WHERE client_id = ?")) {

            pstmt1.setString(1, inheritedEmail);
            try (ResultSet rs1 = pstmt1.executeQuery()) {
                if (rs1.next()) {
                    int clientId = rs1.getInt("client_id");

                    pstmt2.setInt(1, clientId);
                    try (ResultSet rs2 = pstmt2.executeQuery()) {
                    	while (rs2.next()) {
                    	    String contractName = rs2.getString("Contract_Name");
                    	    int consultant = rs2.getInt("consultant_id");
                    	    Date dateUploaded = rs2.getDate("Contract_Date");
                    	    String agreementType = rs2.getString("Agreement_Type");

                    	    String dateUploadedString = dateUploaded == null ? "" : dateUploaded.toString();

                    	    model2.addRow(new Object[] {contractName, consultant, dateUploadedString, agreementType});
                    	}
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String[] getClientName() {
        String[] names = new String[2];
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement("SELECT Client_fname, Client_Iname FROM Client WHERE Client_email = ?")) {
            pstmt.setString(1, senderEmail);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                names[0] = rs.getString("Client_fname");
                names[1] = rs.getString("Client_Iname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    private void countCompleted() {
        String[] consultantName = getClientName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        // Get the client ID based on the consultant's name
        int clientId = getClientId(consultantFname, consultantLname);

        String query = "SELECT COUNT(*) FROM Transactions WHERE client_id =?";
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, clientId); // Set the client ID as an integer
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalAppointments = rs.getInt(1); // Get the count from the first column
                comQueryLabel.setText("" + totalAppointments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getClientId(String fname, String lname) {
        int clientId = 0;
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement("SELECT client_id FROM Client WHERE Client_fname = ? AND Client_Iname = ?")) {
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                clientId = rs.getInt("client_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientId;
    }
   
    private void countCompletedTransactions() {
        String query = "SELECT COUNT(*) AS total FROM Transactions WHERE transaction_status = 'Completed'";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalCompleted = rs.getInt("total");
                comQueryLabel.setText("" + totalCompleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void countSigneContract() {
        String query = "SELECT COUNT(*) AS total FROM Contract WHERE contract_status = 'Signed'";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalCompleted = rs.getInt("total");
                serQueryLabel.setText("" + totalCompleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void countOnGoin() {
        String query = "SELECT COUNT(*) AS total FROM Contract WHERE contract_status = 'On-Going'";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalCompleted = rs.getInt("total");
                totQueryLabel.setText("" + totalCompleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
