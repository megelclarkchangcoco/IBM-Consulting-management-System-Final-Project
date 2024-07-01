package ConsultantFrame;

import java.awt.*;
import javax.swing.JPanel;
import java.sql.*;
import java.util.*;

class BbPieChartPanel extends JPanel {
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    private Map<String, Integer> monthlyData;

    public BbPieChartPanel() {
        monthlyData = fetchDataFromDatabase();
    }

    private Map<String, Integer> fetchDataFromDatabase() {
        Map<String, Integer> data = new TreeMap<>();
        String query = "SELECT DATENAME(MONTH, schedule_date_time) AS Month, COUNT(*) AS Count " +
                       "FROM Schedule " +
                       "WHERE consultant_fname = 'Oscar' AND consultant_lname = 'Piastri' " +
                       "GROUP BY DATENAME(MONTH, schedule_date_time), MONTH(schedule_date_time) " +
                       "ORDER BY MONTH(schedule_date_time)";

        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String month = rs.getString("Month");
                int count = rs.getInt("Count");
                data.put(month, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int[] consulting = monthlyData.values().stream().mapToInt(Integer::intValue).toArray();
        String[] month = monthlyData.keySet().toArray(new String[0]);

        int maxConsulting = getMax(consulting);

        int barWidth = 25;
        int barGap = 50;
        int chartHeight = getHeight() - 50;
        int chartWidth = getWidth() - 50;

        g2d.setColor(Color.BLACK);

        double scale = (chartHeight * 0.8) / maxConsulting;

        for (int i = 0; i < consulting.length; i++) {
            int barHeight = (int) (scale * consulting[i]);
            int x = (barWidth + barGap) * i + 30;
            int y = getHeight() - barHeight - 25;

            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth, barHeight);

            g2d.setColor(Color.BLACK);
            g2d.drawString(month[i], x, getHeight() - 5);
            g2d.drawString(String.valueOf(consulting[i]), x, y - 5);
        }

        g2d.setColor(Color.BLACK);
        Stroke stroke = new BasicStroke(2);
        g2d.setStroke(stroke);

        g2d.drawLine(20, getHeight() - 25, 20, 20);
        g2d.drawLine(20, getHeight() - 25, getWidth() - 25, getHeight() - 25);

        g2d.setStroke(new BasicStroke(1));

        for (int i = 0; i <= 10; i++) {
            int y = (int) (getHeight() - (i * (chartHeight / 10)));
            g2d.drawLine(15, y, 20, y);
            g2d.drawString(String.valueOf(i * maxConsulting / 10), 5, y + 5);
        }
    }

    private int getMax(int[] array) {
        return Arrays.stream(array).max().orElse(0);
    }
}