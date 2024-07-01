package adminFrame;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import ConsultantFrame.FBComposeFrame;
import ConsultantFrame.FDocumentationPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class IDocumentationPanel extends JPanel {
    private JLabel importlbl;
    private JLabel composetxtlbl;
    private JPanel displayPanel;   
    private JTextField textField;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBox;

    private JLabel fileNameLabel;
    private JLabel fileTypeLabel;
    private JLabel senderLabel;
    private JLabel recipientLabel;
    private JLabel dateLabel;
    private JLabel docIconLabel;
    
    private ImageIcon pdficons = new ImageIcon(
            new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png")
                .getImage().getScaledInstance(200, 213  , Image.SCALE_DEFAULT));

    // JDBC URL
    private static final String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String email;
    private static String senderEmail;

    /**
     * Create the panel.
     */
    public IDocumentationPanel(String email) {
    	this.senderEmail = email;
        setBackground(new Color(255, 255, 255));
        setBounds(304, 77, 1557, 907);
        setLayout(null); // Consider using a layout manager

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(192, 192, 192)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 0, 1573, 907);
        add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Documentation");
        lblNewLabel.setBounds(48, 11, 391, 47);
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        bodyPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(55, 80, 384, 41);
        bodyPanel.add(textField);
        textField.setColumns(10);

        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(449, 80, 100, 41);
        searchPanel.setBackground(new Color(18, 98, 254));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                performSearch();
            }
        });
        bodyPanel.add(searchPanel);
        searchPanel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Search");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(22, 11, 60, 20);
        searchPanel.add(lblNewLabel_1);

        comboBox = new JComboBox<>();
        comboBox.setBounds(559, 80, 142, 41);
        comboBox.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        comboBox.addActionListener(e -> performSearch());
        comboBox.setForeground(new Color(18, 98, 254));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"         Filter by", "Sender", "Recipient"}));
        comboBox.setOpaque(false);
        bodyPanel.add(comboBox);

        JLabel recentlbl = new JLabel("Recent");
        recentlbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        recentlbl.setBounds(55, 154, 81, 33);
        bodyPanel.add(recentlbl);

        JPanel composePanel = new JPanel();
        composePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                AddComposeFrame fbFrame = new AddComposeFrame(email);
                fbFrame.setLocation(1252, 422);
                fbFrame.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                composePanel.setBackground(new Color(15, 98, 254));
                composetxtlbl.setForeground(new Color(255, 255, 255));
                importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importwhiteiconm.png")));
            }

            public void mouseExited(MouseEvent e) {
                composePanel.setBackground(new Color(255, 255, 255));
                composetxtlbl.setForeground(new Color(15, 98, 254));
                importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importicon.png")));
            }
        });
        composePanel.setBorder(new LineBorder(new Color(15, 98, 254), 2));
        composePanel.setBackground(new Color(255, 255, 255));
        composePanel.setBounds(987, 136, 141, 42);
        bodyPanel.add(composePanel);
        composePanel.setLayout(null);

        composetxtlbl = new JLabel("Compose");
        composetxtlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 15));
        composetxtlbl.setForeground(new Color(15, 98, 254));
        composetxtlbl.setBounds(21, 11, 72, 20);
        composePanel.add(composetxtlbl);

        importlbl = new JLabel("");
        importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importicon.png")));
        importlbl.setBounds(90, 10, 22, 22);
        composePanel.add(importlbl);

        // Display panel for img and pdf file
        displayPanel = new JPanel();
        displayPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        displayPanel.setBackground(new Color(255, 255, 255));
        displayPanel.setLayout(new GridBagLayout());

        scrollPane = new JScrollPane(displayPanel);
        scrollPane.setBounds(48, 198, 1088, 642);
        bodyPanel.add(scrollPane);

        // Call method to display the pdf and img in display panel
        loadFilesFromDatabase();

        // Properties panel
        JPanel propertiesPanel = new JPanel();
        propertiesPanel.setBackground(new Color(255, 255, 255));
        propertiesPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
        propertiesPanel.setBounds(1158, 0, 402, 907);
        bodyPanel.add(propertiesPanel);
        propertiesPanel.setLayout(null);

        JLabel propertiesLabel = new JLabel("Properties");
        propertiesLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        propertiesLabel.setBounds(23, 27, 237, 35);
        propertiesPanel.add(propertiesLabel);

        docIconLabel = new JLabel("");
        docIconLabel.setBounds(93, 104, 200, 213);
        propertiesPanel.add(docIconLabel);

        fileNameLabel = new JLabel("");
        fileNameLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        fileNameLabel.setBounds(154, 308, 129, 35);
        propertiesPanel.add(fileNameLabel);

        JLabel lblFileName = new JLabel("File Name:");
        lblFileName.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblFileName.setBounds(23, 391, 106, 35);
        propertiesPanel.add(lblFileName);

        JLabel fileType = new JLabel("File Type:");
        fileType.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        fileType.setBounds(23, 428, 106, 35);
        propertiesPanel.add(fileType);

        JLabel sender = new JLabel("Sender:");
        sender.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        sender.setBounds(23, 467, 106, 35);
        propertiesPanel.add(sender);

        JLabel recipient = new JLabel("Recipient:");
        recipient.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        recipient.setBounds(23, 505, 106, 35);
        propertiesPanel.add(recipient);

        JLabel date = new JLabel("Date:");
        date.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        date.setBounds(23, 547, 106, 35);
        propertiesPanel.add(date);

        fileNameLabel = new JLabel("");
        fileNameLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        fileNameLabel.setBounds(154, 391, 220, 35);
        propertiesPanel.add(fileNameLabel);

        fileTypeLabel = new JLabel("");
        fileTypeLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        fileTypeLabel.setBounds(154, 428, 207, 35);
        propertiesPanel.add(fileTypeLabel);

        senderLabel = new JLabel("");
        senderLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        senderLabel.setBounds(154, 467, 248, 35);
        propertiesPanel.add(senderLabel);

        recipientLabel = new JLabel("");
        recipientLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        recipientLabel.setBounds(154, 505, 238, 35);
        propertiesPanel.add(recipientLabel);

        dateLabel = new JLabel("");
        dateLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        dateLabel.setBounds(154, 547, 129, 35);
        propertiesPanel.add(dateLabel);
    }

    private void performSearch() {
        String searchText = textField.getText().trim().toLowerCase();
        String filterOption = (String) comboBox.getSelectedItem();

        displayPanel.removeAll();

        try (Connection connection = DriverManager.getConnection(url)) {
            String query;
            if ("Sender".equals(filterOption)) {
                query = "SELECT docu_file, docu_filename, docu_sender_email, docu_date FROM Documentation WHERE docu_sender_email = ? AND LOWER(docu_filename) LIKE ?";
            } else if ("Recipient".equals(filterOption)) {
                query = "SELECT docu_file, docu_filename, docu_sender_email, docu_date FROM Documentation WHERE docu_recipient_email = ? AND LOWER(docu_filename) LIKE ?";
            } else {
                query = "SELECT docu_file, docu_filename, docu_sender_email, docu_date FROM Documentation WHERE (docu_sender_email = ? OR docu_recipient_email = ?) AND LOWER(docu_filename) LIKE ?";
            }

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if ("Sender".equals(filterOption) || "Recipient".equals(filterOption)) {
                    statement.setString(1, senderEmail);
                    statement.setString(2, "%" + searchText + "%");
                } else {
                    statement.setString(1, senderEmail);
                    statement.setString(2, senderEmail);
                    statement.setString(3, "%" + searchText + "%");
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        byte[] fileData = resultSet.getBytes("docu_file");
                        String fileName = resultSet.getString("docu_filename");
                        String senderEmail = resultSet.getString("docu_sender_email");
                        String date = resultSet.getString("docu_date");

                        JLabel fileLabel = createFileLabel(fileName, fileData, senderEmail, date);
                        displayPanel.add(fileLabel);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching files: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    private void loadFilesFromDatabase() {
        performSearch(); // This will load all files initially

        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT docu_file, docu_filename, docu_sender_email, docu_date FROM Documentation WHERE docu_sender_email = ? OR docu_recipient_email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, senderEmail);
            statement.setString(2, senderEmail);
            resultSet = statement.executeQuery();

            // Set FlowLayout for displayPanel
            displayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));

            while (resultSet.next()) {
                byte[] fileData = resultSet.getBytes("docu_file");
                String fileName = resultSet.getString("docu_filename");
                String senderEmail = resultSet.getString("docu_sender_email");
                String date = resultSet.getString("docu_date");

                if (fileData != null && fileName != null) {
                    JLabel fileLabel = createFileLabel(fileName, fileData, senderEmail, date);
                    displayPanel.add(fileLabel);
                }
            }
            displayPanel.revalidate();
            displayPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Method to create a file label with an icon
    private JLabel createFileLabel(String fileName, byte[] fileData, String senderEmail, String date) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png"));
        label.setText(fileName);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFile(fileName, fileData, senderEmail, date); // Call openFile with parameters
            }
        });
        return label;
    }

    // Method to open a file
    private void openFile(String fileName, byte[] fileData, String senderEmail, String date) {
        try {
            File tempFile = File.createTempFile("temp_file_", ".pdf");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(fileData);
            }
            Desktop.getDesktop().open(tempFile); 

            // Display properties after opening the file
            displayProperties(fileName, "PDF", senderEmail, this.senderEmail, date, fileData);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayProperties(String fileName, String fileType, String email, String senderEmail, String date, byte[] fileData) {
        fileNameLabel.setText(fileName);
        fileTypeLabel.setText(fileType);
        senderLabel.setText(email);
        recipientLabel.setText(senderEmail);
        dateLabel.setText(date);

        if (fileType.equals("pdf")) {
            docIconLabel.setIcon(pdficons);
        } else if (fileType.startsWith("image")) {
            docIconLabel.setIcon(new ImageIcon(fileData));
        } else {
            docIconLabel.setIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png"));
        }
    }
}