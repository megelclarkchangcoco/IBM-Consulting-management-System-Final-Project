package sratch2;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Notifications1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Notificationstabs notificationPanel;
    private JLabel notificationIndicator;
    private int lastProcessedId = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Notifications1 frame = new Notifications1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Notifications1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 751, 658);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel Headpanel = new JPanel();
        Headpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        Headpanel.setBounds(0, 0, 735, 75);
        contentPane.add(Headpanel);
        Headpanel.setLayout(null);

        JPanel notificationButtons = new JPanel();
        notificationButtons.setBorder(new LineBorder(new Color(0, 0, 0)));
        notificationButtons.setBounds(594, 11, 56, 53);
        Headpanel.add(notificationButtons);
        notificationButtons.setLayout(null);

        notificationIndicator = new JLabel();
        notificationIndicator.setBounds(38, 0, 20, 20);
        notificationIndicator.setOpaque(true);
        notificationIndicator.setBackground(Color.RED);
        notificationIndicator.setVisible(false); // Initially hidden
        notificationButtons.add(notificationIndicator);

        // Initialize the notification panel but don't add it yet
        notificationPanel = new Notificationstabs();

        // Add mouse listener to the notification button
        notificationButtons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleNotificationPanel();
            }
        });

        // Check for new notifications periodically
        new Thread(() -> {
            while (true) {
                checkForNewNotifications();
                try {
                    Thread.sleep(5000); // Check every 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void toggleNotificationPanel() {
        if (notificationPanel.isShowing()) {
            contentPane.remove(notificationPanel);
        } else {
            notificationPanel.setBounds(485, 75, 250, 371);
            contentPane.add(notificationPanel);
            notificationPanel.fetchAndDisplayNotifications(); // Fetch notifications when panel is shown
        }
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void checkForNewNotifications() {
        try {
            String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false";
            Connection connection = DriverManager.getConnection(url);

            String query = "SELECT * FROM Notification";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int currentMaxId = rs.getInt("notificitaion_id");
                if (currentMaxId > lastProcessedId) {
                    notificationIndicator.setVisible(true);
                    lastProcessedId = currentMaxId;
                } else {
                    notificationIndicator.setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
