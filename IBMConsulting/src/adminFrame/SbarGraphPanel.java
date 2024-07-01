package adminFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class SbarGraphPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int[] values = {600, 800, 300, 750, 900};
        String[] categories = {"Analytics", "E-comm", "Cust Exp", "Blockchain", "Cybersec"};

        int maxVal = getMax(values);
        int barWidth = 25;
        int barGap = 25;
        int chartHeight = getHeight() - 50;
        int chartWidth = getWidth() - 50;

        double scale = (chartHeight - 25) / (double) maxVal;

        for (int i = 0; i < values.length; i++) {
            int barHeight = (int) (scale * values[i]);
            int x = (barWidth + barGap) * i + 50;
            int y = getHeight() - barHeight - 50;

            g2d.setColor(new Color(74, 108, 170)); 
            g2d.fillRect(x, y, barWidth, barHeight);

            AffineTransform orig = g2d.getTransform();
            g2d.rotate(-Math.PI / 4, x + barWidth / 2, getHeight() - 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString(categories[i], x, getHeight() - 10);
            g2d.setTransform(orig);
        }

        for (int i = 0; i <= 10; i++) {
            int y = getHeight() - 50 - (int) (i * (chartHeight - 50) / 10.0);
            g2d.drawString(String.valueOf(i * 100), 20, y + 5);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, getHeight() - 50, 50, 50); 
        g2d.drawLine(50, getHeight() - 50, chartWidth + 50, getHeight() - 50);
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}

