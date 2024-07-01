package sratch2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.*;

public class Notificationstabs extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel notificationsContainer;
    private JPanel schedulePanel;
    private JPanel documentPanel;
    private JLabel scheduleLabel;
    private JLabel documentLabel;

    public Notificationstabs() {
        setLayout(null);
        setOpaque(false);

        JPanel tabpanel = new JPanel();
        tabpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        tabpanel.setBackground(new Color(255, 255, 255));
        tabpanel.setBounds(0, 0, 250, 371);
        add(tabpanel);
        tabpanel.setLayout(null);

        notificationsContainer = new JPanel();
        notificationsContainer.setBounds(10, 11, 219, 349);
        tabpanel.add(notificationsContainer);
        notificationsContainer.setLayout(null);

        schedulePanel = new JPanel();
        schedulePanel.setVisible(false);
        schedulePanel.setBounds(10, 27, 199, 66);
        notificationsContainer.add(schedulePanel);
        schedulePanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Date Today : ");
        lblNewLabel.setBounds(0, 11, 94, 23);
        schedulePanel.add(lblNewLabel);

        scheduleLabel = new JLabel();
        scheduleLabel.setBounds(95, 32, 94, 23);
        schedulePanel.add(scheduleLabel);

        documentPanel = new JPanel();
        documentPanel.setVisible(false);
        documentPanel.setLayout(null);
        documentPanel.setBounds(0, 0, 199, 66);
        notificationsContainer.add(documentPanel);

        JLabel lblNewLabel_1 = new JLabel("Date Today : ");
        lblNewLabel_1.setBounds(0, 11, 94, 23);
        documentPanel.add(lblNewLabel_1);

        documentLabel = new JLabel();
        documentLabel.setBounds(95, 32, 94, 23);
        documentPanel.add(documentLabel);
    }

    public void fetchAndDisplayNotifications() {
        try {
            String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false";
            Connection connection = DriverManager.getConnection(url);

            String query = "SELECT * FROM Notification";
            PreparedStatement pstmt = connection.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int notificationId = rs.getInt("notificitaion_id");
                String notificationContent = rs.getString("notification_content");

                // For demonstration, let's assume notification_id 1 is for schedule and 2 is for document
                if (notificationId == 1) {
                    schedulePanel.setVisible(true);
                    scheduleLabel.setText(notificationContent);
                } else if (notificationId == 2) {
                    documentPanel.setVisible(true);
                    documentLabel.setText(notificationContent);
                }
            }

            rs.close();
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Notificationstabs notificationsPanel = new Notificationstabs();
        notificationsPanel.setBounds(0, 0, 250, 371);
        frame.add(notificationsPanel);

        frame.setVisible(true);

        // Example usage to fetch and display notifications
        notificationsPanel.fetchAndDisplayNotifications();
    }
}
