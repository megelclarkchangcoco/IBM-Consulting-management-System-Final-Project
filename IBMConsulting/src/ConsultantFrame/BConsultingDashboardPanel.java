package ConsultantFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Connection;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;



public class BConsultingDashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel schedule1lb,totalclient1lbl,sign1lbl, completed1lbl,booked1lbl;
	private DefaultTableModel tableModel, model3;
	private JTable table;
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    private static String email;
    static String senderEmail;
	/**
	 * Create the panel.
	 */
	public BConsultingDashboardPanel(String email) {
		this.senderEmail = email;
		setBackground(new Color(0, 0, 0));
		setBounds(304, 77,  1573, 907);
		setLayout(null);
		setOpaque(false);
		
		JPanel bodypanel = new JPanel();
		bodypanel.setBackground(new Color(255, 255, 255));
		bodypanel.setBounds(15, 0,  1573, 907);
		add(bodypanel);
		bodypanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		lblNewLabel.setBounds(48, 11, 180, 47);
		bodypanel.add(lblNewLabel);
		
		JPanel scheduleappointmentPanel = new JPanel();
		scheduleappointmentPanel.setBackground(new Color(255, 255, 255));
		scheduleappointmentPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		scheduleappointmentPanel.setBounds(48, 81, 280, 129);
		bodypanel.add(scheduleappointmentPanel);
		scheduleappointmentPanel.setLayout(null);
		
		JLabel scheduleappointlbl = new JLabel("");
		scheduleappointlbl.setIcon(new ImageIcon(BConsultingDashboardPanel.class.getResource("/BdashboardpanelImg/scheduleicon.png")));
		scheduleappointlbl.setBounds(226, 11, 44, 40);
		scheduleappointmentPanel.add(scheduleappointlbl);
		//=== count appoint 
		schedule1lb = new JLabel("");
		schedule1lb.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		schedule1lb.setForeground(new Color(0, 0, 255));
		schedule1lb.setBounds(10, 11, 192, 62);
		countAppointment();
		scheduleappointmentPanel.add(schedule1lb);
		
		JLabel schedule2lbl = new JLabel("Schedule Appointment");
		schedule2lbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		schedule2lbl.setBounds(10, 90, 182, 21);
		scheduleappointmentPanel.add(schedule2lbl);
		
		JPanel signcontractPanel = new JPanel();
		signcontractPanel.setBackground(new Color(255, 255, 255));
		signcontractPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		signcontractPanel.setBounds(338, 81, 280, 129);
		bodypanel.add(signcontractPanel);
		signcontractPanel.setLayout(null);
		
		 sign1lbl = new JLabel("");
		sign1lbl.setForeground(Color.BLUE);
		sign1lbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		sign1lbl.setBounds(10, 11, 192, 62);
		signcontractPanel.add(sign1lbl);
		
		JLabel sign2lbl = new JLabel("Signed Contracts");
		sign2lbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		sign2lbl.setBounds(10, 90, 182, 21);
		signcontractPanel.add(sign2lbl);
		
		JLabel signicon = new JLabel("");
		signicon.setIcon(new ImageIcon(BConsultingDashboardPanel.class.getResource("/BdashboardpanelImg/signIcon.png")));
		signicon.setBounds(236, 11, 44, 40);
		signcontractPanel.add(signicon);
		
		JPanel totalclientPanel = new JPanel();
		totalclientPanel.setBackground(new Color(255, 255, 255));
		totalclientPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		totalclientPanel.setBounds(637, 81, 280, 129);
		bodypanel.add(totalclientPanel);
		totalclientPanel.setLayout(null);
		
		totalclient1lbl = new JLabel("");
		totalclient1lbl.setForeground(Color.BLUE);
		totalclient1lbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		totalclient1lbl.setBounds(10, 11, 192, 62);
		totalclientPanel.add(totalclient1lbl);
		
		JLabel totalclienticonlbl = new JLabel("");
		totalclienticonlbl.setIcon(new ImageIcon(BConsultingDashboardPanel.class.getResource("/BdashboardpanelImg/clientIcon.png")));
		totalclienticonlbl.setBounds(226, 11, 54, 40);
		totalclientPanel.add(totalclienticonlbl);
		
		JLabel totalclient2lbl = new JLabel("Total Clients");
		totalclient2lbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		totalclient2lbl.setBounds(10, 90, 182, 21);
		totalclientPanel.add(totalclient2lbl);
		
		JPanel completeprojectPanel = new JPanel();
		completeprojectPanel.setBackground(new Color(255, 255, 255));
		completeprojectPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		completeprojectPanel.setBounds(927, 81, 280, 129);
		bodypanel.add(completeprojectPanel);
		completeprojectPanel.setLayout(null);
		
		 completed1lbl = new JLabel("");
		completed1lbl.setForeground(Color.BLUE);
		completed1lbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		completed1lbl.setBounds(10, 11, 192, 62);
		completeprojectPanel.add(completed1lbl);
		
		JLabel completediconlbl = new JLabel("");
		completediconlbl.setIcon(new ImageIcon(BConsultingDashboardPanel.class.getResource("/BdashboardpanelImg/completedProjectIcon.png")));
		completediconlbl.setBounds(226, 11, 44, 40);
		completeprojectPanel.add(completediconlbl);
		
		JLabel completed2lbl = new JLabel("Total Completed Projects\r\n");
		completed2lbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		completed2lbl.setBounds(10, 90, 192, 21);
		completeprojectPanel.add(completed2lbl);
		
		JPanel bookedappointmentPanel = new JPanel();
		bookedappointmentPanel.setBackground(new Color(255, 255, 255));
		bookedappointmentPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		bookedappointmentPanel.setBounds(1229, 81, 280, 129);
		bodypanel.add(bookedappointmentPanel);
		bookedappointmentPanel.setLayout(null);
		
		 booked1lbl = new JLabel("");
		booked1lbl.setForeground(Color.BLUE);
		booked1lbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 48));
		booked1lbl.setBounds(10, 11, 192, 62);
		bookedappointmentPanel.add(booked1lbl);
		
		JLabel bookediconlbl = new JLabel("");
		bookediconlbl.setIcon(new ImageIcon(BConsultingDashboardPanel.class.getResource("/BdashboardpanelImg/bookedIcon.png")));
		bookediconlbl.setBounds(226, 11, 44, 40);
		bookedappointmentPanel.add(bookediconlbl);
		
		JLabel booked2lbl = new JLabel("Total booked appoinments");
		booked2lbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
		booked2lbl.setBounds(10, 90, 204, 21);
		bookedappointmentPanel.add(booked2lbl);
		
		JPanel topcapabalitiesPanel = new JPanel();
		topcapabalitiesPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		topcapabalitiesPanel.setBackground(new Color(255, 255, 255));
		topcapabalitiesPanel.setBounds(48, 237, 785, 289);
		bodypanel.add(topcapabalitiesPanel);
		topcapabalitiesPanel.setLayout(null);
		
		JLabel topcapabiliteslbl = new JLabel("Top Capabilities");
		topcapabiliteslbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		topcapabiliteslbl.setBounds(21, 11, 264, 57);
		topcapabalitiesPanel.add(topcapabiliteslbl);
		
		// Create the table capabilities panel
        JPanel tableCapabilitiespanel = new JPanel();
        tableCapabilitiespanel.setBackground(new Color(255, 255, 255));
        tableCapabilitiespanel.setLayout(null);
        tableCapabilitiespanel.setBounds(10, 64, 748, 214);
        topcapabalitiesPanel.add(tableCapabilitiespanel);

        String[] columnNames = {"Names", "Capabilities", "Category", "Booked"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                }
                return c;
            }
        };
        

        // Center table data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set the preferred row height to make the table show only 5 rows
        table.setRowHeight(40);  // Adjust the height as needed

        // Set the grid color to be transparent
        table.setShowGrid(true);
        table.setGridColor(new Color(0, 0, 0, 0)); // Fully transparent

        // Set the table bounds to fit the panel
        table.setBounds(0, 57, 748, 157);

        // Set the preferred size to ensure only 5 rows are visible
        table.setPreferredSize(new Dimension(748, table.getRowHeight() * 5));
        tableCapabilitiespanel.add(table);
//        fetchServiceData(model);

        JPanel panel_3_2 = new JPanel();
        panel_3_2.setLayout(null);
        panel_3_2.setBackground(Color.WHITE);
        panel_3_2.setBounds(0, 11, 748, 35);
        tableCapabilitiespanel.add(panel_3_2);
        
        JLabel lblNewLabel_1_2_2 = new JLabel("Names");
        lblNewLabel_1_2_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_2_2.setBounds(74, 0, 97, 35);
        panel_3_2.add(lblNewLabel_1_2_2);
        
        JLabel lblNewLabel_1_2_2_1 = new JLabel("Capabilities");
        lblNewLabel_1_2_2_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_2_2_1.setBounds(275, 0, 97, 35);
        panel_3_2.add(lblNewLabel_1_2_2_1);
        
        JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Category");
        lblNewLabel_1_2_2_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_2_2_1_1.setBounds(468, 0, 97, 35);
        panel_3_2.add(lblNewLabel_1_2_2_1_1);
        
        JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel("Booked");
        lblNewLabel_1_2_2_1_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_2_2_1_1_1.setBounds(638, 0, 87, 35);
        panel_3_2.add(lblNewLabel_1_2_2_1_1_1);
        // Add the scroll pane to the panel
        

		
		JPanel topclientPanel = new JPanel();
		topclientPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		topclientPanel.setBackground(new Color(255, 255, 255));
		topclientPanel.setBounds(843, 237, 666, 289);
		bodypanel.add(topclientPanel);
		topclientPanel.setLayout(null);
		
		JLabel lblTopClient = new JLabel("Top Clients");
		lblTopClient.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		lblTopClient.setBounds(20, 11, 264, 57);
		topclientPanel.add(lblTopClient);
		
		JPanel topclienttablePanel = new JPanel();
		topclienttablePanel.setBackground(new Color(255, 255, 255));
		topclienttablePanel.setBounds(10, 67, 646, 211);
		topclientPanel.add(topclienttablePanel);
		
		 // Create a table model without initial data
	       DefaultTableModel model2 = new DefaultTableModel(
	                new Object[][]{},
	                new String[]{"Names", "Total appointment", "Total Services Availed"}
	        );
        JTable table2 = new JTable(model2) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                }
                return c;
            }
        };
        // Center table data
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        centerRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table2.getColumnCount(); i++) {
            table2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer2);
        }
        topclienttablePanel.setLayout(null);

        

        // Set the preferred row height to make the table show only 5 rows
        table2.setRowHeight(50);  // Adjust the height as needed

        // Set the grid color to be transparent
        table2.setShowGrid(true);
        table2.setGridColor(new Color(0, 0, 0, 0)); // Fully transparent

        // Set the table bounds to fit the panel
        table2.setBounds(0, 61, 646, 150);

        // Set the preferred size to ensure only 5 rows are visible
        table2.setPreferredSize(new Dimension(646, table2.getRowHeight() * 3));

        // Add the table directly to the panel
        topclienttablePanel.add(table2);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 171, 35);
        topclienttablePanel.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(74, 0, 97, 35);
        panel.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(238, 11, 193, 35);
        topclienttablePanel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1_1 = new JLabel("Total Services");
        lblNewLabel_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(74, 0, 97, 35);
        panel_1.add(lblNewLabel_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(465, 11, 171, 35);
        topclienttablePanel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Total Appointment");
        lblNewLabel_1_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(37, 0, 134, 35);
        panel_2.add(lblNewLabel_1_1_1);
        fetchTopClients(model2);

		       
		
		JPanel bookedAppointmentsPanel = new JPanel();
		bookedAppointmentsPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		bookedAppointmentsPanel.setBackground(new Color(255, 255, 255));
		bookedAppointmentsPanel.setBounds(48, 543, 785, 289);
		bodypanel.add(bookedAppointmentsPanel);
		bookedAppointmentsPanel.setLayout(null);
		
		JLabel lblBookedAppointments = new JLabel("Booked Appointments");
		lblBookedAppointments.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		lblBookedAppointments.setBounds(26, 11, 264, 57);
		bookedAppointmentsPanel.add(lblBookedAppointments);
		
		BbPieChartPanel graphbarPanel = new BbPieChartPanel();
		graphbarPanel.setBackground(new Color(255, 255, 255));
		graphbarPanel.setBounds(26, 70, 726, 208);
		graphbarPanel.setLayout(null);
		graphbarPanel.setBackground(new Color(255, 255, 255));

		bookedAppointmentsPanel.add(graphbarPanel);
		
		
		JPanel appointmentsPanel = new JPanel();
		appointmentsPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		appointmentsPanel.setBackground(new Color(255, 255, 255));
		appointmentsPanel.setBounds(843, 543, 666, 289);
		bodypanel.add(appointmentsPanel);
		appointmentsPanel.setLayout(null);
		
		JLabel lblUpcomingAppointments = new JLabel("Upcoming Appointments");
		lblUpcomingAppointments.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
		lblUpcomingAppointments.setBounds(20, 11, 316, 57);
		appointmentsPanel.add(lblUpcomingAppointments);
		
		JPanel upcomingtablePanel = new JPanel();
		upcomingtablePanel.setBackground(new Color(255, 255, 255));
		upcomingtablePanel.setBounds(10, 67, 646, 211);
		appointmentsPanel.add(upcomingtablePanel);
		

		// Create a table model without initial data
		DefaultTableModel model3 = new DefaultTableModel(
		    new Object[][]{},
		    new String[]{"Names", "Date and Time"}
		);

		JTable table23 = new JTable(model3) {
		    @Override
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		        Component c = super.prepareRenderer(renderer, row, column);
		        if (!isRowSelected(row)) {
		            c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
		        }
		        return c;
		    }
		};

		// Center table data
		DefaultTableCellRenderer centerRenderer23 = new DefaultTableCellRenderer();
		centerRenderer23.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table23.getColumnCount(); i++) {
		    table23.getColumnModel().getColumn(i).setCellRenderer(centerRenderer23);
		}
		topclienttablePanel.setLayout(null);
		upcomingtablePanel.setLayout(null);

		// Set the preferred row height to make the table show only 5 rows
		table23.setRowHeight(50);  // Adjust the height as needed

		// Set the grid color to be transparent
		table23.setShowGrid(true);
		table23.setGridColor(new Color(0, 0, 0, 0)); // Fully transparent

		// Set the table bounds to fit the panel
		table23.setBounds(0, 50, 646, 150);

		// Set the preferred size to ensure only 5 rows are visible
		table23.setPreferredSize(new Dimension(646, table23.getRowHeight() * 3));

		upcomingtablePanel.add(table23);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(48, 11, 171, 35);
		upcomingtablePanel.add(panel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(74, 0, 97, 35);
		panel_3.add(lblNewLabel_1_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(390, 4, 232, 35);
		upcomingtablePanel.add(panel_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Date & Time");
		lblNewLabel_1_2_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(74, 0, 97, 35);
		panel_3_1.add(lblNewLabel_1_2_1);

		// Fetch data from the database and populate the table
		fetchScheduleData(model3);
		fetchServiceData(model);
        countAppointment();
        countClient();
        countData();
        countData2();
        countAppointment2();

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

    // method show count of schedule appointmnet;
    private void countAppointment() {
        String[] consultantName = getConsultantName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        String query = "SELECT COUNT(*) AS total FROM Schedule WHERE consultant_fname = ? AND consultant_lname = ?";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            pstmt.setString(1, consultantFname);
            pstmt.setString(2, consultantLname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalAppointments = rs.getInt("total");
                schedule1lb.setText("" + totalAppointments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	private void countClient() {
		String query = "SELECT COUNT(*) AS total FROM Client";
		
		try(Connection connection = DriverManager.getConnection(dbURL);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query)){
				
			if(resultSet.next()) {
				int totalClient = resultSet.getInt("total");
				totalclient1lbl.setText("" + totalClient);
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	 // Assuming you have a method to fetch top 3 clients from database
	private void fetchTopClients(DefaultTableModel model2) {


		
	    try {
	        // Establish database connection (example assuming JDBC)
	        Connection conn = DriverManager.getConnection(dbURL);
	        
	        // Prepare SQL query to fetch top 3 clients based on appointment and service availability
	        String sql = "SELECT TOP 3 Client_Iname, total_Appointment, total_service_avail " +
	                     "FROM Client " +
	                     "ORDER BY total_Appointment DESC, total_service_avail DESC";
	        
	        // Execute query
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        // Clear existing data in table model
	        model2.setRowCount(0);
	        
	        // Iterate through result set and add data to table model
	        while (rs.next()) {
	            String name = rs.getString("Client_Iname");
	            int appointments = rs.getInt("total_Appointment");
	            int servicesAvailed = rs.getInt("total_service_avail");
	            model2.addRow(new Object[]{name, appointments, servicesAvailed});
	        }
	        
	        // Close resources
	        rs.close();
	        stmt.close();
	        conn.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Method to fetch data from Schedule table and populate the table model
	private void fetchScheduleData(DefaultTableModel model3) {
	    try (Connection conn = DriverManager.getConnection(dbURL)) {
	        String sql = "SELECT client_fname, client_lname, schedule_date_time, schedule_meetlink FROM Schedule";
	        try (Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            // Clear existing data in table model
	            model3.setRowCount(0);

	            // Iterate through result set and add data to table model
	            while (rs.next()) {
	                String clientFirstName = rs.getString("client_fname");
	                String clientLastName = rs.getString("client_lname");
	                Timestamp dateTime = rs.getTimestamp("schedule_date_time");

	                // Format date time as needed
	                String formattedDateTime = dateTime.toString(); // Example, adjust formatting as per your needs

	                // Add row to table model
	                model3.addRow(new Object[]{clientFirstName + " " + clientLastName, formattedDateTime});
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void fetchServiceData(DefaultTableModel model) {
	    String email = senderEmail; // assume this method is defined in the parent class
	    int consultantId = getConsultantIdFromEmail(email);
	    if (consultantId > 0) {
	        String sql = "SELECT " +
	                     "    s.service_name, " +
	                     "    s.service_category, " +
	                     "    COUNT(t.transaction_id) AS transaction_count, " +
	                     "    c.client_fname " +
	                     "FROM " +
	                     "    Transactions t " +
	                     "INNER JOIN " +
	                     "    Service s ON t.service_id = s.service_id " +
	                     "INNER JOIN " +
	                     "    Client c ON t.client_id = c.client_id " +
	                     "WHERE " +
	                     "    t.consultant_id = ? " +
	                     "GROUP BY " +
	                     "    s.service_name, " +
	                     "    s.service_category, " +
	                     "    c.client_fname " +
	                     "ORDER BY " +
	                     "    transaction_count DESC";

	        try (Connection conn = DriverManager.getConnection(dbURL);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, consultantId);

	            try (ResultSet rs = pstmt.executeQuery()) {

	                // Clear existing data in table model
	                model.setRowCount(0);

	                // Iterate through result set and add data to table model
	                while (rs.next()) {
	                    String serviceName = rs.getString("service_name");
	                    String serviceCategory = rs.getString("service_category");
	                    int transactionCount = rs.getInt("transaction_count");
	                    String clientFname = rs.getString("client_fname");

	                    model.addRow(new Object[]{serviceName, serviceCategory, transactionCount, clientFname});
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	private int getConsultantIdFromEmail(String email) {
	    String query = "SELECT consultant_id FROM Consultant WHERE consultant_email = ?";
	    int consultantId = 0;

	    try (Connection conn = DriverManager.getConnection(dbURL);
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setString(1, email);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                consultantId = rs.getInt("consultant_id");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return consultantId;
	}


	private void countData() {
		// Initialize the email variable based on username
		String username = senderEmail; // Example email, replace with actual value

		
	    try (Connection connection = DriverManager.getConnection(dbURL)) {
	        // Define SQL query to get signed_contract based on consultant_email
	        String sqlemp = "SELECT signed_contract FROM Consultant WHERE consultant_email = ?";

	        try (PreparedStatement stmt = connection.prepareStatement(sqlemp)) {
	            stmt.setString(1, username); // Set the email parameter in the query

	            // Debugging: Print the email being used in the query
	            System.out.println("Email: " + username);

	            try (ResultSet rs = stmt.executeQuery()) {
	                // Retrieve and display the signed_contract value
	                if (rs.next()) {
	                    int signedContract = rs.getInt("signed_contract");
	                    // Debugging: Print the value of signed_contract
	                    System.out.println("Signed Contract: " + signedContract);

	                    sign1lbl.setText(String.valueOf(signedContract)); // Convert int to String
	                } else {
	                    // Debugging: Print if no data was found
	                    System.out.println("No data found for email: " + username);
	                    sign1lbl.setText("No Data"); // Handle case where no data is found
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle any SQL exceptions
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle any other exceptions
	    }
	}

	private void countData2() {
		// Initialize the email variable based on username
		String username = senderEmail; // Example email, replace with actual value

		
	    try (Connection connection = DriverManager.getConnection(dbURL)) {
	        // Define SQL query to get signed_contract based on consultant_email
	        String sqlemp = "SELECT completed_project FROM Consultant WHERE consultant_email = ?";

	        try (PreparedStatement stmt = connection.prepareStatement(sqlemp)) {
	            stmt.setString(1, username); // Set the email parameter in the query

	            // Debugging: Print the email being used in the query
	            System.out.println("Email: " + username);

	            try (ResultSet rs = stmt.executeQuery()) {
	                // Retrieve and display the signed_contract value
	                if (rs.next()) {
	                    int signedContract = rs.getInt("completed_project");
	                    // Debugging: Print the value of signed_contract
	                    System.out.println("completed_project: " + signedContract);

	                    completed1lbl.setText(String.valueOf(signedContract)); // Convert int to String
	                } else {
	                    // Debugging: Print if no data was found
	                    System.out.println("No data found for email: " + username);
	                    completed1lbl.setText("No Data"); // Handle case where no data is found
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle any SQL exceptions
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle any other exceptions
	    }
	}
	// method show count of schedule appointmnet;
    private void countAppointment2() {
        String[] consultantName = getConsultantName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        String query = "SELECT COUNT(*) AS total FROM Schedule WHERE consultant_fname = ? AND consultant_lname = ?";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            pstmt.setString(1, consultantFname);
            pstmt.setString(2, consultantLname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalAppointments = rs.getInt("total");
                booked1lbl.setText("" + totalAppointments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}