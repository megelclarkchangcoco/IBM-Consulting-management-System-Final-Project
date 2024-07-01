package adminFrame;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

class PieChartPanel extends JPanel {
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    String[] countryNames;
    int[] countryCounts;

    public PieChartPanel() {
        setPreferredSize(new Dimension(580, 336));
        loadCountryData();
        repaint(); // Call repaint to update the panel
    }

    private void loadCountryData() {
        try (Connection conn = DriverManager.getConnection(dbURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT client_country, COUNT(*) as count FROM Client GROUP BY client_country")) {

            ArrayList<String> countryNamesList = new ArrayList<>();
            ArrayList<Integer> countryCountsList = new ArrayList<>();

            while (rs.next()) {
                countryNamesList.add(rs.getString(1));
                countryCountsList.add(rs.getInt(2));
            }

            countryNames = countryNamesList.toArray(new String[0]);
            countryCounts = new int[countryCountsList.size()];
            for (int i = 0; i < countryCountsList.size(); i++) {
                countryCounts[i] = countryCountsList.get(i);
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

        double total = 0;
        for (int count : countryCounts) {
            total += count;
        }

        double startAngle = 0;
        for (int i = 0; i < countryCounts.length; i++) {
            double angle = (countryCounts[i] / total) * 360;
            g2d.setColor(getColor(i));
            g2d.fill(new Arc2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, angle, Arc2D.PIE));

            startAngle += angle;
        }

        // Draw the legend
        int legendX = 15;
        int legendY = 15;
        int legendWidth = 15;
        int legendHeight = 15;
        int legendGap = 10;

        for (int i = 0; i < countryCounts.length; i++) {
            g2d.setColor(getColor(i));
            g2d.fill(new Ellipse2D.Double(legendX, legendY, legendWidth, legendHeight));
            g2d.setColor(Color.BLACK);
            g2d.drawString(countryNames[i] + ": " + countryCounts[i], legendX + legendWidth + legendGap, legendY + 15);
            legendY += legendHeight + legendGap;
        }
    }

    private Color getColor(int index) {
        switch (index) {
            case 0:
                return new Color(134,174,249);
            case 1:
                return new Color(99,145,232);
            case 2:
                return new Color(15,98,254);
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.CYAN;
            case 5:
                return Color.MAGENTA;
            default:return Color.BLACK;
        }
    }
}