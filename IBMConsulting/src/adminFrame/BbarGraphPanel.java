package adminFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JPanel;

class BbarGraphPanel extends JPanel {
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    // Array to hold consulting values
    int[] consulting = new int[12]; // Only for January to June
    String[] month = {"January", "February", "March", "April", "May", "June","July","August","September","October","November","December"};

    public BbarGraphPanel() {
        // Load data from the database
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try (Connection conn = DriverManager.getConnection(dbURL)) {
            String query = "SELECT MONTH(contract_date) AS month, COUNT(*) AS count FROM Contract " +
                           "WHERE contract_date >= '2024-01-01' AND contract_date <= '2024-06-30' " +
                           "GROUP BY MONTH(contract_date)";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Arrays.fill(consulting, 0); // Initialize consulting array with 0

            while (rs.next()) {
                int monthIndex = rs.getInt("month") - 1; // Adjust month to zero-based index
                if (monthIndex >= 0 && monthIndex < 12) {
                    consulting[monthIndex] = rs.getInt("count");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Override the paintComponent method to draw the chart
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create a Graphics2D object for better rendering
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calculate the maximum consulting value
        int maxConsulting = getMax(consulting);

        // Set the bar width, gap, chart height, and width
        int barWidth = 30; // adjust bar width
        int barGap = 50; // adjust bar gap
        int chartHeight = getHeight() - 50;
        int chartWidth = getWidth() - 100;

        // Draw the title
        g2d.setColor(Color.BLACK);
        g2d.drawString("Consulting Values from January to June", 200, 30); // set title

        // Calculate the scale for the y-axis
        double scale = (chartHeight * 0.8) / maxConsulting;

        // Loop through the consulting values and draw the bars
        for (int i = 0; i < consulting.length; i++) {
            int barHeight = (int) (scale * consulting[i]);
            int x = (barWidth + barGap) * i + 30;
            int y = getHeight() - barHeight - 25;

            // Set the bar color and fill the bar
            g2d.setColor(new Color(15, 98, 254));
            g2d.fillRect(x, y, barWidth, barHeight);

            // Set the text color and draw the month name
            g2d.setColor(Color.BLACK);
            g2d.drawString(month[i], x, getHeight() - 5);
        }

        // Set the stroke for the gridlines
        g2d.setColor(Color.BLACK);
        Stroke stroke = new BasicStroke(2);
        g2d.setStroke(stroke);

        // Draw the vertical and horizontal gridlines
        g2d.drawLine(20, getHeight() - 25, 20, 20); // adjust the height of y-axis bar
        g2d.drawLine(20, getHeight() - 25, getWidth() - 25, getHeight() - 25); // adjust the width and height of x-axis bar

        // Reset the stroke for the y-axis labels
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        // Draw the y-axis labels
        for (int i = 0; i <= 10; i++) {
            int y = (int) (getHeight() - (i * (chartHeight / 10))); // adjust line height on the left side
            g2d.drawLine(15, y, 20, y); // adjust length of line on y-axis
            g2d.drawString(String.valueOf(i * 10), 5, y - 30); // adjust the consulting numbers on the left side
        }
    }

    // Method to calculate the maximum value in an array
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
