package ClientFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;

public class CAInquiryFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JPanel contentPane;
    private String clientEmail;
    private JTextPane problemTextPane;
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String email;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CAInquiryFrame frame = new CAInquiryFrame(email);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CAInquiryFrame(String email) {
        this.clientEmail = email;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 385);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 3));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 888, 385);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JPanel submitBtnPanel = new JPanel();
        submitBtnPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitInquiry();
            }
        });
        submitBtnPanel.setBackground(new Color(0, 0, 255));
        submitBtnPanel.setBounds(707, 323, 141, 43);
        panel.add(submitBtnPanel);
        submitBtnPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Inquire");
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(33, 11, 98, 21);
        submitBtnPanel.add(lblNewLabel);
        
        problemTextPane = new JTextPane();
        problemTextPane.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        problemTextPane.setBounds(21, 11, 827, 299);
        panel.add(problemTextPane);
        
        JPanel panel_2 = new JPanel();
        panel_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	dispose();
        	}
        });
        panel_2.setLayout(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(849, 11, 39, 32);
        panel.add(panel_2);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(CAInquiryFrame.class.getResource("/CschedulepanelImg/window-minimize.png")));
        lblNewLabel_1.setBounds(10, 0, 29, 32);
        panel_2.add(lblNewLabel_1);
    }

    private void submitInquiry() {
        String problem = problemTextPane.getText();
        LocalDate currentDate = LocalDate.now();


        try (Connection conn = DriverManager.getConnection(dbURL)) {
            // First, get the client's first name and last name
            String clientQuery = "SELECT Client_fname, Client_Iname FROM Client WHERE Client_email = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(clientQuery)) {
                pstmt.setString(1, clientEmail);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String firstName = rs.getString("Client_fname");
                        String lastName = rs.getString("Client_Iname");

                        // Now insert the inquiry
                        String insertQuery = "INSERT INTO Inquiry (problem, client_fname, client_lname, date, client_email) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                            insertStmt.setString(1, problem);
                            insertStmt.setString(2, firstName);
                            insertStmt.setString(3, lastName);
                            insertStmt.setDate(4, java.sql.Date.valueOf(currentDate));
                            insertStmt.setString(5, clientEmail);

                            int affectedRows = insertStmt.executeUpdate();
                            if (affectedRows > 0) {
                                JOptionPane.showMessageDialog(this, "Inquiry submitted successfully!");
                                dispose(); // Close the frame after successful submission
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to submit inquiry. Please try again.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Client not found in the database.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error submitting inquiry: " + e.getMessage());
        }
    }
}