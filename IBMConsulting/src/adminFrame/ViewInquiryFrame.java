package adminFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class ViewInquiryFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // This should ideally not be used for actual application launch in production.
        // Instead, instantiate ViewInquiryFrame directly where needed.
    }

    /**
     * Create the frame.
     */
    public ViewInquiryFrame(String problem, String fullName, String date) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Changed to DISPOSE_ON_CLOSE
        setBounds(100, 100, 732, 662);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new LineBorder(new Color(190, 190, 190), 2));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 55, 712, 605);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel fullnamelbl = new JLabel(fullName);
        fullnamelbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 15));
        fullnamelbl.setBounds(10, 42, 115, 22);
        panel.add(fullnamelbl);


        JLabel datelbl = new JLabel(date);
        datelbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        datelbl.setBounds(600, 11, 115, 28);
        panel.add(datelbl);

        textArea = new JTextArea();
        textArea.setBounds(10, 79, 692, 426);
        textArea.setBorder(new LineBorder(new Color(190, 190, 190), 2));
        textArea.setText(problem);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AdminCreateScheduleFrame acf = new AdminCreateScheduleFrame();
        		acf.setVisible(true);
        	}
        });
        buttonPanel.setLayout(null);
        buttonPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
        buttonPanel.setBackground(new Color(15, 98, 254));
        buttonPanel.setBounds(490, 525, 210, 57);
        panel.add(buttonPanel);
        
        JLabel scheduletxtlbl = new JLabel("Schedule a call");
        scheduletxtlbl.setForeground(Color.WHITE);
        scheduletxtlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 18));
        scheduletxtlbl.setBackground(Color.WHITE);
        scheduletxtlbl.setBounds(10, 11, 129, 24);
        buttonPanel.add(scheduletxtlbl);

        JPanel panel_1 = new JPanel();
        panel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        panel_1.setBorder(new LineBorder(new Color(0, 0, 255)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(10, 11, 85, 33);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Back");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.ITALIC, 15));
        lblNewLabel.setBounds(23, 0, 52, 33);
        panel_1.add(lblNewLabel);
    }
}
