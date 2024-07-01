package ClientFrame;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.sql.*;
import java.util.*;
import javax.swing.*;

class PieChartPanel extends JPanel {
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    private Map<String, Integer> serviceData;
    private String clientFname = "Charles";
    private String clientLname = "Leclerc";

    public PieChartPanel() {
        setPreferredSize(new Dimension(580, 336));
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        serviceData = new HashMap<>();
        
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            // First, get the client_id from the Client table
            String clientIdQuery = "SELECT client_id FROM Client WHERE Client_fname = ? AND Client_Iname = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(clientIdQuery)) {
                pstmt.setString(1, clientFname);
                pstmt.setString(2, clientLname);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int clientId = rs.getInt("client_id");
                        
                        // Now, get the service_id from the Transaction table
                        String transactionQuery = "SELECT service_id FROM Transactions WHERE client_id = ?";
                        try (PreparedStatement transactionStmt = conn.prepareStatement(transactionQuery)) {
                            transactionStmt.setInt(1, clientId);
                            try (ResultSet transactionRs = transactionStmt.executeQuery()) {
                                while (transactionRs.next()) {
                                    int serviceId = transactionRs.getInt("service_id");
                                    
                                    // Finally, get the service_name from the Service table
                                    String serviceQuery = "SELECT service_name FROM Service WHERE service_id = ?";
                                    try (PreparedStatement serviceStmt = conn.prepareStatement(serviceQuery)) {
                                        serviceStmt.setInt(1, serviceId);
                                        try (ResultSet serviceRs = serviceStmt.executeQuery()) {
                                            if (serviceRs.next()) {
                                                String serviceName = serviceRs.getString("service_name");
                                                serviceData.put(serviceName, serviceData.getOrDefault(serviceName, 0) + 1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 20;

        double total = serviceData.values().stream().mapToInt(Integer::intValue).sum();

        double startAngle = 0;
        int colorIndex = 0;
        for (Map.Entry<String, Integer> entry : serviceData.entrySet()) {
            double angle = (entry.getValue() / total) * 360;
            g2d.setColor(getColor(colorIndex));
            g2d.fill(new Arc2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, angle, Arc2D.PIE));

            startAngle += angle;
            colorIndex++;
        }

        // Draw the legend
        int legendX = 500;
        int legendY = 35;
        int legendWidth = 15;
        int legendHeight = 15;
        int legendGap = 10;

        colorIndex = 0;
        for (Map.Entry<String, Integer> entry : serviceData.entrySet()) {
            g2d.setColor(getColor(colorIndex));
            g2d.fill(new Ellipse2D.Double(legendX, legendY, legendWidth, legendHeight));
            g2d.setColor(Color.BLACK);
            int percentage = (int) Math.round((entry.getValue() / total) * 100);
            g2d.drawString(entry.getKey() + ": " + percentage + "%", legendX + legendWidth + legendGap, legendY + 15);
            legendY += legendHeight + legendGap;
            colorIndex++;
        }
    }

    private Color getColor(int index) {
        Color[] colors = {
            Color.decode("#0099CC"),
            Color.decode("#1100CC"),
            Color.decode("#FF6600"),
            Color.decode("#FFCC00"),
            Color.decode("#33CC33")
        };
        return colors[index % colors.length];
    }
}