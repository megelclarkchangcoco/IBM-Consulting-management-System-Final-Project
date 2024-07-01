package adminFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CInquiryPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    private JPanel inquiryPanel;
    private List<JPanel> inquiryPanels = new ArrayList<>(); // Store inquiry panels

    /**
     * Create the panel.
     */
    public CInquiryPanel() {
        setBounds(0, 0, 1560, 864);
        setLayout(null);
        setOpaque(false);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(0, 0, 1865, 980);
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
        add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel inquiryLabel = new JLabel("Inquiry");
        inquiryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        inquiryLabel.setBounds(41, 44, 323, 58);
        bodyPanel.add(inquiryLabel);

        // Create the main inquiry panel
        inquiryPanel = new JPanel();
        inquiryPanel.setBackground(new Color(255, 255, 255));
        inquiryPanel.setBounds(37, 112, 1488, 725);
        bodyPanel.add(inquiryPanel);
        inquiryPanel.setLayout(null);

        // Fetch and display inquiries
        fetchData();
    }

    private void fetchData() {
        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Inquiry")) {

            // Clear existing inquiry panels
            inquiryPanel.removeAll();
            inquiryPanels.clear();

            List<InquiryData> inquiryDataList = new ArrayList<>();
            int y = 0;
            while (rs.next()) {
                InquiryData inquiryData = new InquiryData(
                        rs.getString("problem"),
                        rs.getString("client_fname") + " " + rs.getString("client_lname"),
                        rs.getString("date")
                );
                inquiryDataList.add(inquiryData);

                // Create a new panel for each inquiry
                JPanel inquiryItemPanel = createInquiryPanel(inquiryData, y);
                inquiryPanels.add(inquiryItemPanel);
                inquiryPanel.add(inquiryItemPanel);
                y += 150; // Adjust vertical spacing as needed

                // Add mouse listener to each inquiry panel
                int index = inquiryPanels.size() - 1;
                inquiryItemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        InquiryData inquiryData = inquiryDataList.get(index);
                        // Open ViewInquiryFrame with details
                        ViewInquiryFrame viewInquiryFrame = new ViewInquiryFrame(inquiryData.getProblem(), inquiryData.getFullName(), inquiryData.getDate());
                        viewInquiryFrame.setVisible(true);
                    }
                });
            }
            inquiryPanel.revalidate();
            inquiryPanel.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JPanel createInquiryPanel(InquiryData inquiryData, int y) {
        JPanel inquiryItemPanel = new JPanel();
        inquiryItemPanel.setBackground(new Color(255, 255, 255));
        inquiryItemPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        inquiryItemPanel.setBounds(57, y, 1405, 154); // Adjust y-coordinate for vertical spacing
        inquiryItemPanel.setLayout(null);

        JTextArea problemTextArea = new JTextArea();
        problemTextArea.setColumns(1);
        problemTextArea.setDisabledTextColor(new Color(0, 0, 0));
        problemTextArea.setEditable(false);
        problemTextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
        problemTextArea.setBounds(25, 59, 1355, 70);
        problemTextArea.setLineWrap(true);
        problemTextArea.setWrapStyleWord(true);
        problemTextArea.setText(inquiryData.getProblem()); // Set problem text
        inquiryItemPanel.add(problemTextArea);

        JTextField dateField = new JTextField();
        dateField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
        dateField.setEditable(false);
        dateField.setColumns(1);
        dateField.setBorder(null);
        dateField.setBounds(25, 25, 333, 21);
        dateField.setText(inquiryData.getFullName() + " | " + inquiryData.getDate()); // Set date text
        inquiryItemPanel.add(dateField);

        return inquiryItemPanel;
    }
}