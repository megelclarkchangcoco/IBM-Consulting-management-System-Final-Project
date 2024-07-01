package ClientFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EAvailsServicesFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea descriptionTextArea, capabilitiesTextArea;
    private JComboBox<String> categoryComboBox, technologyComboBox, businessComboBox;

    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    static String[] chooseCategory = {"Choose Category", "Technology", "Business"};

    static String[] chooseTechnology = {"Choose Technology", "Artificial Intelligence", "Blockchain", "Cloud Computing", "Hybrid Cloud", "Application Services", "Cybersecurity", "IT Infrastructure", "Analytics", "E-commerce"};

    static String[] chooseBusiness = {"Choose Business", "Operations", "Customer Experience", "Marketing", "Finance", "Talent Management", "Supply Chain"};
    
    static  String email;
    static String senderEmail;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EAvailsServicesFrame frame = new EAvailsServicesFrame(email);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public EAvailsServicesFrame(String email) {
    	this.senderEmail = email;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 732, 739);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new LineBorder(new Color(190, 190, 190), 2));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 54, 731, 684);
        contentPane.add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel lblServiceCategory = new JLabel("Service Category");
        lblServiceCategory.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblServiceCategory.setBounds(70, 11, 161, 32);
        bodyPanel.add(lblServiceCategory);

        categoryComboBox = new JComboBox<>(chooseCategory);
        categoryComboBox.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        categoryComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                switch (selectedCategory) {
                    case "Technology":
                        technologyComboBox.setVisible(true);
                        businessComboBox.setVisible(false);
                        descriptionTextArea.setText("");
                        capabilitiesTextArea.setText("");
                        break;
                    case "Business":
                        businessComboBox.setVisible(true);
                        technologyComboBox.setVisible(false);
                        descriptionTextArea.setText("");
                        capabilitiesTextArea.setText("");
                        break;
                    default:
                        technologyComboBox.setVisible(false);
                        businessComboBox.setVisible(false);
                        descriptionTextArea.setText("");
                        capabilitiesTextArea.setText("");
                        break;
                }
            }
        });
        categoryComboBox.setBounds(39, 49, 277, 32);
        bodyPanel.add(categoryComboBox);

        JLabel lblServiceName = new JLabel("Service Name");
        lblServiceName.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblServiceName.setBounds(471, 11, 151, 32);
        bodyPanel.add(lblServiceName);

        technologyComboBox = new JComboBox<>(chooseTechnology);
        technologyComboBox.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        technologyComboBox.setBounds(419, 49, 277, 32);
        technologyComboBox.setVisible(false);
        technologyComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = technologyComboBox.getSelectedIndex();
                if (selectedIndex > 0) {
                    fetchAndDisplayServiceInfo("Technology", chooseTechnology[selectedIndex]);
                } else {
                    capabilitiesTextArea.setText("");
                    descriptionTextArea.setText("");
                }
            }
        });
        bodyPanel.add(technologyComboBox);

        capabilitiesTextArea = new JTextArea();
        capabilitiesTextArea.setFont(new Font("IBM Plex Sans", Font.PLAIN, 25));
        capabilitiesTextArea.setBounds(16, 153, 680, 195);
        capabilitiesTextArea.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        capabilitiesTextArea.setLineWrap(true);
        capabilitiesTextArea.setWrapStyleWord(true);
        bodyPanel.add(capabilitiesTextArea);

        JLabel lblServiceCapabilities = new JLabel("Service Capabilities");
        lblServiceCapabilities.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblServiceCapabilities.setBounds(267, 110, 180, 32);
        bodyPanel.add(lblServiceCapabilities);

        JLabel lblServiceDescription = new JLabel("Service Description");
        lblServiceDescription.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblServiceDescription.setBounds(279, 359, 206, 32);
        bodyPanel.add(lblServiceDescription);

        descriptionTextArea = new JTextArea();
        descriptionTextArea.setFont(new Font("IBM Plex Sans", Font.PLAIN, 25));
        descriptionTextArea.setBounds(16, 402, 680, 195);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        bodyPanel.add(descriptionTextArea);

        businessComboBox = new JComboBox<>(chooseBusiness);
        businessComboBox.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        businessComboBox.setBounds(419, 49, 277, 32);
        businessComboBox.setVisible(false);
        businessComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = businessComboBox.getSelectedIndex();
                if (selectedIndex > 0) {
                    fetchAndDisplayServiceInfo("Business", chooseBusiness[selectedIndex]);
                } else {
                    capabilitiesTextArea.setText("");
                    descriptionTextArea.setText("");
                }
            }
        });
        bodyPanel.add(businessComboBox);

        JPanel submitBtnPanel = new JPanel();
        submitBtnPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		saveService();
        	}
        });
        submitBtnPanel.setLayout(null);
        submitBtnPanel.setBackground(Color.BLUE);
        submitBtnPanel.setBounds(294, 608, 141, 43);
        bodyPanel.add(submitBtnPanel);

        JLabel lblAvailService = new JLabel("Avail Service");
        lblAvailService.setForeground(Color.WHITE);
        lblAvailService.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 20));
        lblAvailService.setBounds(10, 11, 121, 21);
        submitBtnPanel.add(lblAvailService);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(190, 190, 190), 2));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 0, 731, 54);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Avail Services");
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
        lblNewLabel.setBounds(270, 11, 192, 32);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.addMouseListener(new PanelButtonMouseAdapter(panel_2) {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(682, 11, 39, 32);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(EAvailsServicesFrame.class.getResource("/CschedulepanelImg/window-minimize.png")));
        lblNewLabel_1.setBounds(10, 0, 29, 32);
        panel_2.add(lblNewLabel_1);
    }

    // Method to fetch service information from the database based on category and service name
    private void fetchAndDisplayServiceInfo(String category, String serviceName) {
        String sql = "SELECT service_capabilities, service_description FROM serviceInfo WHERE service_category = ? AND service_name = ?";
        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category);
            stmt.setString(2, serviceName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                capabilitiesTextArea.setText(rs.getString("service_capabilities"));
                descriptionTextArea.setText(rs.getString("service_description"));
            } else {
                capabilitiesTextArea.setText("");
                descriptionTextArea.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Method to save service information to the Service table
    private void saveService() {
        String category = (String) categoryComboBox.getSelectedItem();
        String serviceName = "";
        if (category.equals("Technology")) {
            serviceName = (String) technologyComboBox.getSelectedItem();
        } else if (category.equals("Business")) {
            serviceName = (String) businessComboBox.getSelectedItem();
        }

        if (category.equals("Choose Category") || serviceName.equals("Choose Technology") || serviceName.equals("Choose Business")) {
        	return;
        }

        String capabilities = capabilitiesTextArea.getText();
        String description = descriptionTextArea.getText();
        String email = senderEmail;

        String sql = "INSERT INTO Service (service_category, service_name, service_capabilities, service_description, service_email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category);
            stmt.setString(2, serviceName);
            stmt.setString(3, capabilities);
            stmt.setString(4, description);
            stmt.setString(5, email);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                // Success message or further action upon successful insertion
                System.out.println("Service saved successfully!");
                JOptionPane.showMessageDialog(this, "Service saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                // Handle insertion failure
                System.out.println("Failed to save service.");
                JOptionPane.showMessageDialog(this, "Failed to save service.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
 // Method to clear fields after successful save
    private void clearFields() {
        categoryComboBox.setSelectedIndex(0);
        technologyComboBox.setSelectedIndex(0);
        businessComboBox.setSelectedIndex(0);
        capabilitiesTextArea.setText("");
        descriptionTextArea.setText("");
    }
    private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(192, 192, 192));

		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
		}
	}
}
           
