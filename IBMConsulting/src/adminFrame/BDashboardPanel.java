package adminFrame;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class BDashboardPanel extends JPanel {
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

	private JLabel clientNumberLabel,activeClientNum,signedContractsNum,schedulesNum;
	private DefaultTableModel model;
	static String senderEmail;
	/**
	 * Create the panel.
	 */
	public BDashboardPanel(String email) {
		this.senderEmail = email;
		setBounds(0, 0, 1560, 864);
		setLayout(null);
		setOpaque(false);
		

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 0, 1865, 980);
		bodyPanel.setBackground(new Color (255,255,255));
		bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel dashboardLabel = new JLabel("Dashboard");
		dashboardLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		dashboardLabel.setBounds(41, 44, 194, 58);
		bodyPanel.add(dashboardLabel);
		
		JPanel totalClientPanel = new JPanel();
		totalClientPanel.setBackground(new Color(255, 255, 255));
		totalClientPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		totalClientPanel.setBounds(41, 113, 290, 129);
		bodyPanel.add(totalClientPanel);
		totalClientPanel.setLayout(null);
		
		JLabel totalClientLabel = new JLabel("Total Client\r\n");
		totalClientLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		totalClientLabel.setBounds(10, 96, 90, 22);
		totalClientPanel.add(totalClientLabel);
		
		 clientNumberLabel = new JLabel("");
		clientNumberLabel.setForeground(new Color(15, 98, 254));
		clientNumberLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		clientNumberLabel.setBounds(10, 21, 191, 64);
		totalClientPanel.add(clientNumberLabel);
		
		JLabel totalClientIcon = new JLabel("");
		totalClientIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/LoginFrameImg/totalClient_icon.png")));
//		totalClientIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/assets/totalClient_icon.png")));
		totalClientIcon.setBounds(232, 11, 48, 35);
		totalClientPanel.add(totalClientIcon);
		
		JPanel activeClientPanel = new JPanel();
		activeClientPanel.setLayout(null);
		activeClientPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		activeClientPanel.setBackground(Color.WHITE);
		activeClientPanel.setBounds(341, 113, 290, 129);
		bodyPanel.add(activeClientPanel);
		
		JLabel activeClientLabel = new JLabel("Active Client");
		activeClientLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		activeClientLabel.setBounds(10, 96, 149, 22);
		activeClientPanel.add(activeClientLabel);
		
		 activeClientNum = new JLabel("");
		activeClientNum.setForeground(new Color(15, 98, 254));
		activeClientNum.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		activeClientNum.setBounds(10, 21, 191, 64);
		activeClientPanel.add(activeClientNum);
		
		JLabel activeClientIcon = new JLabel("");
		activeClientIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/LoginFrameImg/activeClients_icon.png")));
//		activeClientIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/assets/activeClients_icon.png")));
		activeClientIcon.setBounds(232, 11, 48, 35);
		activeClientPanel.add(activeClientIcon);
		
		JPanel signedContractPanel = new JPanel();
		signedContractPanel.setLayout(null);
		signedContractPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		signedContractPanel.setBackground(Color.WHITE);
		signedContractPanel.setBounds(641, 113, 290, 129);
		bodyPanel.add(signedContractPanel);
		
		JLabel signedContractLabel = new JLabel("Signed Contracts");
		signedContractLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		signedContractLabel.setBounds(10, 96, 144, 22);
		signedContractPanel.add(signedContractLabel);
		
		 signedContractsNum = new JLabel("");
		signedContractsNum.setForeground(new Color(15, 98, 254));
		signedContractsNum.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		signedContractsNum.setBounds(10, 21, 191, 64);
		signedContractPanel.add(signedContractsNum);
		
		JLabel signedContractsIcon = new JLabel("");
		signedContractsIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/LoginFrameImg/signedContracts_icon.png")));
//		signedContractsIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/assets/signedContracts_icon.png")));
		signedContractsIcon.setBounds(234, 11, 34, 35);
		signedContractPanel.add(signedContractsIcon);
		
		JPanel fullyBookedPanel = new JPanel();
		fullyBookedPanel.setLayout(null);
		fullyBookedPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		fullyBookedPanel.setBackground(Color.WHITE);
		fullyBookedPanel.setBounds(941, 113, 290, 129);
		bodyPanel.add(fullyBookedPanel);
		
		JLabel fullyBookedLabel = new JLabel("Fully booked Consultants");
		fullyBookedLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		fullyBookedLabel.setBounds(10, 96, 204, 22);
		fullyBookedPanel.add(fullyBookedLabel);
		
		JLabel fullyBookedNum = new JLabel("17");
		fullyBookedNum.setForeground(new Color(15, 98, 254));
		fullyBookedNum.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		fullyBookedNum.setBounds(10, 21, 191, 64);
		fullyBookedPanel.add(fullyBookedNum);
		
		JLabel fullyBookedIcon = new JLabel("");
		fullyBookedIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/LoginFrameImg/fullybookedConsultants_icon.png")));
//		fullyBookedIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/assets/fullybookedConsultants_icon.png")));
		fullyBookedIcon.setBounds(232, 11, 48, 35);
		fullyBookedPanel.add(fullyBookedIcon);
		
		JPanel scheduledPanel = new JPanel();
		scheduledPanel.setLayout(null);
		scheduledPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		scheduledPanel.setBackground(Color.WHITE);
		scheduledPanel.setBounds(1241, 113, 290, 129);
		bodyPanel.add(scheduledPanel);
		
		JLabel schedulesLabel = new JLabel("Scheduled Appointments");
		schedulesLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		schedulesLabel.setBounds(10, 96, 191, 22);
		scheduledPanel.add(schedulesLabel);
		
		 schedulesNum = new JLabel("");
		schedulesNum.setForeground(new Color(15, 98, 254));
		schedulesNum.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		schedulesNum.setBounds(10, 21, 191, 64);
		scheduledPanel.add(schedulesNum);
		
		JLabel scheduleIcon = new JLabel("");
		scheduleIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/LoginFrameImg/calendar_icon.png")));
//		scheduleIcon.setIcon(new ImageIcon(BDashboardPanel.class.getResource("/assets/calendar_icon.png")));
		scheduleIcon.setBounds(232, 11, 48, 35);
		scheduledPanel.add(scheduleIcon);
		
		JPanel barGraphPanel = new JPanel();
		barGraphPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		barGraphPanel.setBackground(new Color(255, 255, 255));
		barGraphPanel.setBounds(41, 260, 1043, 378);
		bodyPanel.add(barGraphPanel);
		barGraphPanel.setLayout(null);
		
		JLabel graphTitle = new JLabel("Number of services during the year 2024");
		graphTitle.setBounds(20, 11, 494, 43);
		graphTitle.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		barGraphPanel.add(graphTitle);
		
		//BIG GRAPH ############################
		BbarGraphPanel graphPanel = new BbarGraphPanel();
		graphPanel.setBackground(new Color(255, 255, 255));
		graphPanel.setBounds(20, 65, 1001, 281);
		barGraphPanel.add(graphPanel);
		
		JPanel topCountriesPanel = new JPanel();
		topCountriesPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		topCountriesPanel.setBackground(new Color(255, 255, 255));
		topCountriesPanel.setBounds(1094, 260, 437, 234);
		bodyPanel.add(topCountriesPanel);
		topCountriesPanel.setLayout(null);
		
		JLabel topCountriesLabel = new JLabel("Top Countries Availing Services");
		topCountriesLabel.setBounds(20, 11, 369, 40);
		topCountriesLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		topCountriesPanel.add(topCountriesLabel);
		
		
		//PIE CGRAPJ
		
		PieChartPanel piePanel = new PieChartPanel();
		piePanel.setBackground(new Color(255, 255, 255));
		piePanel.setBounds(20, 64, 395, 159);
		topCountriesPanel.add(piePanel);
		
		JPanel servicePopPanel = new JPanel();
		servicePopPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		servicePopPanel.setBackground(Color.WHITE);
		servicePopPanel.setBounds(1094, 508, 437, 338);
		bodyPanel.add(servicePopPanel);
		servicePopPanel.setLayout(null);
		
		JLabel servicePopLabel = new JLabel("Service Popularity");
		servicePopLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		servicePopLabel.setBounds(20, 11, 369, 40);
		servicePopPanel.add(servicePopLabel);
		
		//SMALL GRAPH ##############
		SbarGraphPanel serviceBarGraph = new SbarGraphPanel();
		serviceBarGraph.setBackground(new Color(255, 255, 255));
		serviceBarGraph.setBounds(20, 62, 393, 253);
		servicePopPanel.add(serviceBarGraph);
		
		JPanel topCompaniesPanel = new JPanel();
		topCompaniesPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		topCompaniesPanel.setBackground(Color.WHITE);
		topCompaniesPanel.setBounds(41, 649, 1043, 197);
		bodyPanel.add(topCompaniesPanel);
		topCompaniesPanel.setLayout(null);
		
		JLabel topCompaniesLabel = new JLabel("Top Companies Availing Services");
		topCompaniesLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		topCompaniesLabel.setBounds(20, 11, 369, 40);
		topCompaniesPanel.add(topCompaniesLabel);
		
		 model = new DefaultTableModel();
		 model.setColumnIdentifiers(new String[] {"Company", "Total Services Avail", "Total Appointment "});
        
        
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
        scrollPane.setBounds(20, 62, 999, 124);
        topCompaniesPanel.add(scrollPane);
		
		
        countClient();
        countSigneContract();
        countAppointment();
        fetchDataAndUpdateTable();

	}
	private void countClient() {
		String query = "SELECT COUNT(*) AS total FROM Client";
		
		try(Connection connection = DriverManager.getConnection(dbURL);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query)){
				
			if(resultSet.next()) {
				int totalClient = resultSet.getInt("total");
				clientNumberLabel.setText("" + totalClient);
				activeClientNum.setText("" + totalClient);
			}
			
			}catch(Exception e) {
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
                signedContractsNum.setText("" + totalCompleted);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String[] getConsultantName() {
        String[] names = new String[2];
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement("SELECT consultant_fname, consultant_lname FROM Consultant WHERE consultant_email = ?")) {
            pstmt.setString(1, senderEmail);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                names[0] = rs.getString("consultant_fname");
                names[1] = rs.getString("consultant_lname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    private void fetchDataAndUpdateTable() {
        // Database connection parameters
        String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

        try (Connection conn = DriverManager.getConnection(dbURL);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT TOP 3 client_country, SUM(total_service_avail) AS total_services_available, SUM(total_Appointment) AS total_appointments " +
                           "FROM Client " +
                           "GROUP BY client_country " +
                           "ORDER BY total_services_available DESC, total_appointments DESC";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String country = rs.getString("client_country");
                int totalServicesAvailable = rs.getInt("total_services_available");
                int totalAppointments = rs.getInt("total_appointments");

                model.addRow(new Object[]{country, totalServicesAvailable, totalAppointments});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String[] getAdminName() {
        String[] names = new String[2];
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement("SELECT admin_fname, admin_lname FROM Admin WHERE admin_email = ?")) {
            pstmt.setString(1, senderEmail);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                names[0] = rs.getString("admin_fname");
                names[1] = rs.getString("admin_lname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
    // method show count of schedule appointmnet;
    private void countAppointment() {
        String[] adminName = getAdminName();
        String adminFname = adminName[0];
        String adminLname = adminName[1];

        String query = "SELECT COUNT(*) AS total FROM Schedule WHERE consultant_fname = ? AND consultant_lname = ?";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            pstmt.setString(1, adminFname);
            pstmt.setString(2, adminLname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalAppointments = rs.getInt("total");
                schedulesNum.setText("" + totalAppointments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

