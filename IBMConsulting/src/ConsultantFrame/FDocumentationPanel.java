package ConsultantFrame;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FDocumentationPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel importlbl;
    private JLabel composetxtlbl;
    private JPanel displayPanel;   
    private JTextField textField;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBox;


    // JDBC URL
    private static final String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static String email;
    private static String senderEmail;

    public FDocumentationPanel(String email) {
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
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"         Filter by"}));
        comboBox.setOpaque(false);
        bodyPanel.add(comboBox);

        JLabel recentlbl = new JLabel("Recent");
        recentlbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        recentlbl.setBounds(55, 154, 81, 33);
        bodyPanel.add(recentlbl);

        JPanel composePanel = new JPanel();
        composePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                FBComposeFrame fbFrame = new FBComposeFrame(email);
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
        composePanel.setBounds(1334, 142, 141, 42);
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
        scrollPane.setBounds(48, 198, 1427, 210);
        bodyPanel.add(scrollPane);

        // Call method to display the pdf and img in display panel
        loadFilesFromDatabase();
        loadFilesFromDatabase2();
    }

    // Method to display data in display panel
    private void loadFilesFromDatabase() {
        performSearch(); // This will load all files initially

        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT docu_file, docu_filename FROM Documentation WHERE docu_sender_email = ? OR docu_recipient_email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, senderEmail);
            statement.setString(2, senderEmail);
            resultSet = statement.executeQuery();

            // Set FlowLayout for displayPanel
            displayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));

            while (resultSet.next()) {
                byte[] fileData = resultSet.getBytes("docu_file");
                String fileName = resultSet.getString("docu_filename");

                if (fileData != null && fileName != null) {
                    JLabel fileLabel = createFileLabel(fileName);
                    displayPanel.add(fileLabel);
                }
                if (fileData != null && fileName != null) {
                    JLabel fileLabel2 = createFileLabel2(fileName);
                    displayPanel.add(fileLabel2);
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
    
    private void performSearch() {
        String searchText = textField.getText().trim().toLowerCase();
        String filterOption = (String) comboBox.getSelectedItem();

        displayPanel.removeAll();

        try (Connection connection = DriverManager.getConnection(url)) {
            String query;
            if ("Sender".equals(filterOption)) {
                query = "SELECT docu_file, docu_filename FROM Documentation WHERE docu_sender_email = ? AND LOWER(docu_filename) LIKE ?";
            } else if ("Recipient".equals(filterOption)) {
                query = "SELECT docu_file, docu_filename FROM Documentation WHERE docu_recipient_email = ? AND LOWER(docu_filename) LIKE ?";
            } else {
                query = "SELECT docu_file, docu_filename FROM Documentation WHERE (docu_sender_email = ? OR docu_recipient_email = ?) AND LOWER(docu_filename) LIKE ?";
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

                        if (fileData != null && fileName != null) {
                            JLabel fileLabel = createFileLabel(fileName);
                            displayPanel.add(fileLabel);
                        }
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

    // Method to create a file label with an icon
    private JLabel createFileLabel(String fileName) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png"));
        label.setText(fileName);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFile(fileName);
            }
        });
        return label;
    }

    // Method to open a file
    private void openFile(String fileName) {
        byte[] fileContent = retrieveFileContentFromDatabase(fileName);
        if (fileContent != null) {
            try {
                File tempFile = File.createTempFile("temp_file_", ".pdf");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(fileContent);
                }
                Desktop.getDesktop().open(tempFile);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "File not found: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // retrieve file content from database
    private byte[] retrieveFileContentFromDatabase(String fileName) {
        byte[] fileContent = null;
        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT docu_file FROM Documentation WHERE docu_filename = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, fileName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                fileContent = resultSet.getBytes("docu_file");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileContent;
    }
    
 // Method to display data in display panel
    private void loadFilesFromDatabase2() {
        performSearch(); // This will load all files initially

        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT con.Consultant_id " +
                    "FROM Consultant con " +
                    "WHERE con.consultant_email =?";
            statement = connection.prepareStatement(query);
            statement.setString(1, senderEmail);
            resultSet = statement.executeQuery();

            int consultantId = 0;
            if (resultSet.next()) {
                consultantId = resultSet.getInt("Consultant_id");
            }

            query = "SELECT contract_file, Contract_name " +
                    "FROM Contract " +
                    "WHERE consultant_id =?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, consultantId);
            resultSet = statement.executeQuery();

            // Set FlowLayout for displayPanel
            displayPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));

            while (resultSet.next()) {
                byte[] fileData = resultSet.getBytes("contract_file");
                String fileName = resultSet.getString("Contract_name");

                if (fileData!= null && fileName!= null) {
                    JLabel fileLabel = createFileLabel(fileName);
                    displayPanel.add(fileLabel);
                }
            }
            displayPanel.revalidate();
            displayPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet!= null) resultSet.close();
                if (statement!= null) statement.close();
                if (connection!= null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    // Method to create a file label with an icon
    private JLabel createFileLabel2(String fileName) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png"));
        label.setText(fileName);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	openFile2(fileName);
            }
        });
        return label;
    }

    // Method to open a file
    private void openFile2(String fileName) {
        byte[] fileContent = retrieveFileContentFromDatabase2(fileName);
        if (fileContent!= null) {
            try {
                File tempFile = File.createTempFile("temp_file_", ".pdf");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(fileContent);
                }
                Desktop.getDesktop().open(tempFile);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "File not found: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // retrieve file content from database
    private byte[] retrieveFileContentFromDatabase2(String fileName) {
        byte[] fileContent = null;
        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT contract_file FROM Contract WHERE Contract_name =?";
            statement = connection.prepareStatement(query);
            statement.setString(1, fileName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                fileContent = resultSet.getBytes("contract_file");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileContent;
    }
    
   
}
