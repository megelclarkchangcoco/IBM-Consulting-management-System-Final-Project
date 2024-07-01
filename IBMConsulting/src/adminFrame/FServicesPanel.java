package adminFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FServicesPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    /**
     * Create the panel.
     */
    public FServicesPanel() {
        setBounds(0, 0, 1560, 864);
        setLayout(null);
        setOpaque(false);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(0, 0, 1560, 864);
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
        add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel servicesLabel = new JLabel("Services");
        servicesLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        servicesLabel.setBounds(41, 44, 323, 58);
        bodyPanel.add(servicesLabel);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
        searchField.setBackground(new Color(244, 244, 244));
        searchField.setBounds(41, 113, 425, 39);
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchField.getText();
                searchAttendanceData(searchText);
            }
        });
        bodyPanel.add(searchField);
        searchField.setColumns(10);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(15, 98, 254));
        searchButton.setForeground(new Color(255, 255, 255));
        searchButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        searchButton.setBounds(476, 113, 112, 39);
        bodyPanel.add(searchButton);

        // Initialize the table with an empty model
         model = new DefaultTableModel();
        table = new JTable(model);
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
        scrollPane.setBounds(41, 191, 1489, 641);
        bodyPanel.add(scrollPane);

        // Fetch data from database and populate the table
        try {
            Connection conn = DriverManager.getConnection(dbURL);
            String query = "SELECT service_category, service_name, service_capabilities, service_description FROM Service";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add columns dynamically
            model.addColumn("Category");
            model.addColumn("Name");
            model.addColumn("Capabilities");
            model.addColumn("Description");

            // Populate rows from ResultSet
            while (rs.next()) {
                Object[] row = {
                    rs.getString("service_category"),
                    rs.getString("service_name"),
                    rs.getString("service_capabilities"),
                    rs.getString("service_description")
                };
                model.addRow(row);
            }
            table.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
            table.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any SQL errors as needed
        }
    }
	 private void searchAttendanceData(String searchText) {
	        try {
	            Connection connection = DriverManager.getConnection(dbURL);
	            String query = "SELECT * FROM Service WHERE service_category LIKE ? OR service_name LIKE ? OR service_capabilities LIKE ? OR services_description LIKE ?";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            String searchPattern = "%" + searchText + "%";
	            for (int i = 1; i <= 2; i++) {
	                pstmt.setString(i, searchPattern);
	            }
	            ResultSet rs = pstmt.executeQuery();
	            model.setRowCount(0);
	            while (rs.next()) {
	                model.addRow(new Object[] {
	                		rs.getString("service_category"),
	                        rs.getString("service_name"),
	                });
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 class TextAreaRenderer extends JTextArea implements TableCellRenderer {
		    public TextAreaRenderer() {
		        setLineWrap(true);
		        setWrapStyleWord(true);
		    }

		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        setText((String) value);
		        return this;
		    }
		}
}
