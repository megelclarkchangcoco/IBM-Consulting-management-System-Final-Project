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
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DClientsPanel extends JPanel {
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    private JTextField searchField;
    private DefaultTableModel model;

    /**
     * Create the panel.
     */
    public DClientsPanel() {
        setBounds(0, 0, 1560, 864);
        setLayout(null);
        setOpaque(false);
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(0, 0, 1865, 980);
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
        add(bodyPanel);
        bodyPanel.setLayout(null);
        
        JLabel clientLabel = new JLabel("Clients");
        clientLabel.setBounds(41, 44, 323, 58);
        clientLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        bodyPanel.add(clientLabel);
        
        searchField = new JTextField();
        searchField.setBounds(41, 113, 425, 39);
        searchField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
        searchField.setBackground(new Color(244, 244, 244));
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
        searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String search = searchField.getText();
        		searchAttendanceData(search);
        	}
        });
        searchButton.setBounds(476, 113, 112, 39);
        searchButton.setBackground(new Color(15, 98, 254));
        searchButton.setForeground(new Color(255, 255, 255));
        searchButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        bodyPanel.add(searchButton);
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {
            "Last Name", "First Name", "Email", "Contact", "Status", "Company"
        });
        fetchData();

        
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
        scrollPane.setBounds(41, 191, 1489, 641);
        bodyPanel.add(scrollPane);
    }
    
    private void fetchData() {
        try {
            Connection connection = DriverManager.getConnection(dbUrl);
            String query = "SELECT * FROM Client";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("Client_Iname"),
                    rs.getString("Client_fname"),
                    rs.getString("Client_email"),
                    rs.getString("client_contact"),
                    rs.getString("Client_Status"),
                    rs.getString("Company")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchAttendanceData(String searchText) {
        try {
            Connection connection = DriverManager.getConnection(dbUrl);
            String query = "SELECT * FROM Client WHERE Client_Iname LIKE ? OR Client_fname LIKE ? OR Client_email LIKE ? OR client_contact LIKE ? OR Client_Status LIKE ? OR Company LIKE ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            String searchPattern = "%" + searchText + "%";
            for (int i = 1; i <= 6; i++) {
                pstmt.setString(i, searchPattern);
            }
            ResultSet rs = pstmt.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("Client_Iname"),
                    rs.getString("Client_fname"),
                    rs.getString("Client_email"),
                    rs.getString("client_contact"),
                    rs.getString("Client_Status"),
                    rs.getString("Company")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
