package ConsultantFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DClientsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
    private DefaultTableModel tableModel, searchModel;
    private JTable table;
    private JComboBox filterby;
    private Connection connection;
    static String email;
    static String senderEmail;
    

    
    
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String[] filterbys = {"Filter by", "Signed", "Not Signed"};
    /**
	 * Create the panel.
	 */
	public DClientsPanel(String email) {
        this.senderEmail = email;

		setBackground(new Color(255, 255, 255));
        setBounds(304, 77,  1557, 907);
        setLayout(null); // Consider using a layout manager
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(192, 192, 192)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 0, 1573, 907);
        add(bodyPanel);
        bodyPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Clients");
        lblNewLabel.setBounds(48, 11, 180, 47);
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        bodyPanel.add(lblNewLabel);
        
        searchField = new JTextField();
        searchField.setBounds(55, 80, 384, 41);
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String searchText = searchField.getText().trim();
                    search(searchText);
                }
            }
        });

        searchField.setColumns(10);
        bodyPanel.add(searchField);
        
        JPanel searchPanel = new JPanel();
        searchPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                String searchText = searchField.getText().trim();
                search(searchText);

        	}
        });
        searchPanel.setBackground(new Color(18, 98, 254));
        searchPanel.setBounds(449, 80, 100, 41);
        bodyPanel.add(searchPanel); 
        searchPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Search");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(22, 11, 60, 20);
        searchPanel.add(lblNewLabel_1);
        
        filterby = new JComboBox<>(filterbys);
        filterby.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        filterby.setForeground(new Color(18, 98, 254));
        filterby.setBounds(559, 80, 142, 41);
        filterby.setOpaque(false);
        filterby.addActionListener(e -> fetchTableData()); // Add action listener to filter data
        bodyPanel.add(filterby);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(new Color(255, 255, 255));
        tablePanel.setBounds(55, 146, 1398, 681);
        bodyPanel.add(tablePanel);
        tablePanel.setLayout(null);
        
        tableModel = new DefaultTableModel(
        		new Object[][]{},
        		new String[] {"First Name", "Last Name", "Email", "Contract", "Signed", "Employment Status", "Company"}
        		);
        table = new JTable(tableModel) {
        	@Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                }
                return c;
            }
        };
        // Set row height to 10
        table.setRowHeight(50);

        // Remove table grid lines
        table.setShowGrid(false);
        
        // Center text in the columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 11, 1398, 670);
        scrollPane.setBackground(new Color(255,255,255));
        tablePanel.add(scrollPane);
        fetchTableData(); // fetch data table here
    
    

	}
	private void fetchTableData() {
	    try {
	        connection = DriverManager.getConnection(dbUrl);
	        Statement stmt = connection.createStatement();
	        String query = "SELECT * FROM Client";
	        ResultSet rs = stmt.executeQuery(query);
	        tableModel.setRowCount(0); // clear existing rows

	        while (rs.next()) {
	            String firstname = rs.getString("Client_Iname");
	            String lastname = rs.getString("Client_fname");
	            String email = rs.getString("Client_email");
	            String contact = rs.getString("client_contact");
	            String signedContract = ""; // Assume empty string for now
	            String status = rs.getString("Client_Status");
	            String company = rs.getString("Company");

	            Object[] row = {firstname, lastname, email, contact, signedContract, status, company};
	            tableModel.addRow(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void search(String searchText) {
	    DefaultTableModel searchModel = new DefaultTableModel();
	    searchModel.addColumn("First Name");
	    searchModel.addColumn("Last Name");
	    searchModel.addColumn("Email");
	    searchModel.addColumn("Contact");
	    searchModel.addColumn("Signed Contract");
	    searchModel.addColumn("Employment Status");
	    searchModel.addColumn("Company");

	    try {
	        connection = DriverManager.getConnection(dbUrl);
	        Statement stmt = connection.createStatement();

	        // Construct the SQL query to search for records based on searchText
	        String query = "SELECT * FROM Client WHERE "
	                + "Client_Iname LIKE '%" + searchText + "%' OR "
	                + "Client_fname LIKE '%" + searchText + "%' OR "
	                + "Client_email LIKE '%" + searchText + "%' OR "
	                + "client_contact LIKE '%" + searchText + "%' OR "
	                + "Client_Status LIKE '%" + searchText + "%' OR "
	                + "Company LIKE '%" + searchText + "%'";

	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            String firstname = rs.getString("Client_Iname");
	            String lastname = rs.getString("Client_fname");
	            String email = rs.getString("Client_email");
	            String contact = rs.getString("client_contact");
	            String signedContract = ""; // Assume empty string for now
	            String status = rs.getString("Client_Status");
	            String company = rs.getString("Company");

	            Object[] row = {firstname, lastname, email, contact, signedContract, status, company};
	            searchModel.addRow(row);
	        }

	        table.setModel(searchModel); // Update table with search results

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
