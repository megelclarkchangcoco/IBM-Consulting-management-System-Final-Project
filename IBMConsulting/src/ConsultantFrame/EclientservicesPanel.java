package ConsultantFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class EclientservicesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
    static String email;
    static String senderEmail;

	/**
	 * Create the panel.
	 */
	public EclientservicesPanel(String email) {
        this.senderEmail = email;

		setBackground(new Color(255, 255, 255));
		setBounds(304, 77,  1557, 907);
		setLayout(null);
		setOpaque(false);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 0, 1573, 907);
		add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1566, 907);
	    scrollPane.setBackground(new Color(225, 254, 253));
	    bodyPanel.add(scrollPane);
	    
	    JPanel scrollContent = new JPanel();
	    scrollContent.setBackground(new Color(255, 255, 255));
	    scrollContent.setPreferredSize(new Dimension(1001, 1400)); // increase the size of the panel to fit all 9 labels
	    scrollPane.setViewportView(scrollContent);
	    scrollContent.setLayout(null);
	    
	    JPanel head1panel = new JPanel();
	    head1panel.setBackground(new Color(255, 255, 255));
	    head1panel.setBounds(0, 0, 1537, 71);
	    scrollContent.add(head1panel);
	    head1panel.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Services");
		lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		lblNewLabel.setBounds(48, 11, 180, 47);
		head1panel.add(lblNewLabel);
		
		JPanel body1panel = new JPanel();
		body1panel.setBackground(new Color(255, 255, 255));
		body1panel.setBounds(0, 72, 1537, 760);
		scrollContent.add(body1panel);
		body1panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Technology");
		lblNewLabel_1.setForeground(new Color(15, 98, 254));
		lblNewLabel_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(51, 11, 176, 33);
		body1panel.add(lblNewLabel_1);
		
		JPanel aipanel = new JPanel();
		aipanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		aipanel.setBackground(new Color(255, 255, 255));
		aipanel.setBounds(51, 55, 350, 210);
		body1panel.add(aipanel);
		aipanel.setLayout(null);
		
		JLabel aiIcon = new JLabel("");
		aiIcon.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/aiicon.png")));
		aiIcon.setBounds(289, 25, 40, 40);
		aipanel.add(aiIcon);
		
		JLabel artificiallbl = new JLabel("Artifical");
		artificiallbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		artificiallbl.setBounds(10, 11, 249, 40);
		aipanel.add(artificiallbl);
		
		JLabel intelegencelbl = new JLabel("Intellingence");
		intelegencelbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		intelegencelbl.setBounds(10, 51, 249, 40);
		aipanel.add(intelegencelbl);
		
		JLabel lblNewLabel_4 = new JLabel("• Conversational AI");
		lblNewLabel_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(15, 99, 302, 23);
		aipanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("• AI, machine learning + analytics\r\n");
		lblNewLabel_4_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(15, 122, 302, 23);
		aipanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("• Customer Experience transformation");
		lblNewLabel_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(15, 150, 302, 23);
		aipanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("• Data-led transformation");
		lblNewLabel_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(15, 176, 302, 23);
		aipanel.add(lblNewLabel_4_2_1);
		
		JPanel blockchainpanel = new JPanel();
		blockchainpanel.setLayout(null);
		blockchainpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		blockchainpanel.setBackground(Color.WHITE);
		blockchainpanel.setBounds(411, 55, 350, 210);
		body1panel.add(blockchainpanel);
		
		JLabel blockchainIcon = new JLabel("");
		blockchainIcon.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/blockchainicon.png")));
		blockchainIcon.setBounds(300, 34, 40, 40);
		blockchainpanel.add(blockchainIcon);
		
		JLabel blockchainlbl = new JLabel("Blockchain");
		blockchainlbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		blockchainlbl.setBounds(10, 35, 249, 39);
		blockchainpanel.add(blockchainlbl);
		
		JLabel lblNewLabel_4_3 = new JLabel("• Pillar phases of design-based principles");
		lblNewLabel_4_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(15, 99, 302, 23);
		blockchainpanel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("• Governance design\r\n");
		lblNewLabel_4_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(15, 122, 302, 23);
		blockchainpanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("• Business value design");
		lblNewLabel_4_2_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2.setBounds(15, 150, 302, 23);
		blockchainpanel.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("• Technology design");
		lblNewLabel_4_2_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_1.setBounds(15, 176, 302, 23);
		blockchainpanel.add(lblNewLabel_4_2_1_1);
		
		JPanel cloudcomputingpanel = new JPanel();
		cloudcomputingpanel.setLayout(null);
		cloudcomputingpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		cloudcomputingpanel.setBackground(Color.WHITE);
		cloudcomputingpanel.setBounds(771, 55, 350, 210);
		body1panel.add(cloudcomputingpanel);
		
		JLabel cloudcomputingicon = new JLabel("");
		cloudcomputingicon.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/cloudcomputingicon.png")));
		cloudcomputingicon.setBounds(289, 31, 40, 40);
		cloudcomputingpanel.add(cloudcomputingicon);
		
		JLabel cloudlbl = new JLabel("Cloud");
		cloudlbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		cloudlbl.setBounds(10, 11, 249, 40);
		cloudcomputingpanel.add(cloudlbl);
		
		JLabel computingll = new JLabel("Computing");
		computingll.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		computingll.setBounds(10, 51, 249, 40);
		cloudcomputingpanel.add(computingll);
		
		JLabel lblNewLabel_4_4 = new JLabel("• Strategy and application");
		lblNewLabel_4_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_4.setBounds(15, 99, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("• Application migration and modernization\r\n");
		lblNewLabel_4_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2.setBounds(15, 122, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("• Development consulting services");
		lblNewLabel_4_2_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3.setBounds(15, 150, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("• Application management services");
		lblNewLabel_4_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2.setBounds(15, 176, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_2_1_2);
		
		JPanel hybridcloudPanel = new JPanel();
		hybridcloudPanel.setLayout(null);
		hybridcloudPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		hybridcloudPanel.setBackground(Color.WHITE);
		hybridcloudPanel.setBounds(1131, 55, 350, 210);
		body1panel.add(hybridcloudPanel);
		
		JLabel hybridcloudicon = new JLabel("");
		hybridcloudicon.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/hybridcloudicon.png")));
		hybridcloudicon.setBounds(300, 34, 40, 40);
		hybridcloudPanel.add(hybridcloudicon);
		
		JLabel lblNewLabel_4_5 = new JLabel("• Modernize applications");
		lblNewLabel_4_5.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(25, 109, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("• Manage and secure data\r\n\r\n");
		lblNewLabel_4_1_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3.setBounds(25, 132, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_2_4 = new JLabel("• Optimize IT Solutions");
		lblNewLabel_4_2_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4.setBounds(25, 160, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_2_4);
		
		JLabel hybridcloudlb = new JLabel("Hybrid Cloud");
		hybridcloudlb.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb.setBounds(10, 35, 249, 39);
		hybridcloudPanel.add(hybridcloudlb);
		
		JPanel appservicepanel = new JPanel();
		appservicepanel.setLayout(null);
		appservicepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		appservicepanel.setBackground(Color.WHITE);
		appservicepanel.setBounds(51, 301, 350, 210);
		body1panel.add(appservicepanel);
		
		JLabel aiIcon_1 = new JLabel("");
		aiIcon_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/appservicon.png")));
		aiIcon_1.setBounds(294, 11, 40, 40);
		appservicepanel.add(aiIcon_1);
		
		JLabel lblApplication = new JLabel("Application");
		lblApplication.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		lblApplication.setBounds(10, 11, 249, 40);
		appservicepanel.add(lblApplication);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		lblServices.setBounds(10, 51, 249, 40);
		appservicepanel.add(lblServices);
		
		JLabel lblNewLabel_4_6 = new JLabel("• Custom and data-managed services");
		lblNewLabel_4_6.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_6.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_6.setBounds(15, 99, 302, 23);
		appservicepanel.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_1_4 = new JLabel("• Enterprise application managemen");
		lblNewLabel_4_1_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_4.setBounds(15, 122, 302, 23);
		appservicepanel.add(lblNewLabel_4_1_4);
		
		JLabel lblNewLabel_4_2_5 = new JLabel("  services");
		lblNewLabel_4_2_5.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_5.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_5.setBounds(15, 150, 302, 23);
		appservicepanel.add(lblNewLabel_4_2_5);
		
		JLabel lblNewLabel_4_2_1_3 = new JLabel("• Platform services");
		lblNewLabel_4_2_1_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_3.setBounds(15, 176, 302, 23);
		appservicepanel.add(lblNewLabel_4_2_1_3);
		
		JPanel cybersecpanel = new JPanel();
		cybersecpanel.setLayout(null);
		cybersecpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		cybersecpanel.setBackground(Color.WHITE);
		cybersecpanel.setBounds(411, 301, 350, 210);
		body1panel.add(cybersecpanel);
		
		JLabel blockchainIcon_1 = new JLabel("");
		blockchainIcon_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/cybericon.png")));
		blockchainIcon_1.setBounds(294, 11, 40, 40);
		cybersecpanel.add(blockchainIcon_1);
		
		JLabel lblCybersecurity = new JLabel("Cybersecurity");
		lblCybersecurity.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		lblCybersecurity.setBounds(10, 35, 249, 39);
		cybersecpanel.add(lblCybersecurity);
		
		JLabel lblNewLabel_4_5_2 = new JLabel("• Cyber threat management");
		lblNewLabel_4_5_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5_2.setBounds(32, 103, 302, 23);
		cybersecpanel.add(lblNewLabel_4_5_2);
		
		JLabel lblNewLabel_4_1_3_2 = new JLabel("• Cyber Trust\r\n\r\n");
		lblNewLabel_4_1_3_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3_2.setBounds(32, 126, 302, 23);
		cybersecpanel.add(lblNewLabel_4_1_3_2);
		
		JLabel lblNewLabel_4_2_4_2 = new JLabel("• Cyber Strategy and Risk");
		lblNewLabel_4_2_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2.setBounds(32, 154, 302, 23);
		cybersecpanel.add(lblNewLabel_4_2_4_2);
		
		JPanel itstructurepanel = new JPanel();
		itstructurepanel.setLayout(null);
		itstructurepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		itstructurepanel.setBackground(Color.WHITE);
		itstructurepanel.setBounds(771, 301, 350, 210);
		body1panel.add(itstructurepanel);
		
		JLabel cloudcomputingicon_1 = new JLabel("");
		cloudcomputingicon_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/iticon.png")));
		cloudcomputingicon_1.setBounds(294, 11, 40, 40);
		itstructurepanel.add(cloudcomputingicon_1);
		
		JLabel hybridcloudlb_1_2 = new JLabel("IT Infrastructure");
		hybridcloudlb_1_2.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1_2.setBounds(15, 36, 249, 39);
		itstructurepanel.add(hybridcloudlb_1_2);
		
		JLabel lblNewLabel_4_1_3_2_1 = new JLabel("• Optimize operations\r\n\r\n");
		lblNewLabel_4_1_3_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3_2_1.setBounds(32, 123, 302, 23);
		itstructurepanel.add(lblNewLabel_4_1_3_2_1);
		
		JLabel lblNewLabel_4_5_2_1 = new JLabel("• Accelerate hybrid cloud");
		lblNewLabel_4_5_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5_2_1.setBounds(32, 100, 302, 23);
		itstructurepanel.add(lblNewLabel_4_5_2_1);
		
		JLabel lblNewLabel_4_2_4_2_1 = new JLabel("• Maximize value");
		lblNewLabel_4_2_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2_1.setBounds(32, 151, 302, 23);
		itstructurepanel.add(lblNewLabel_4_2_4_2_1);
		
		JPanel analysispanel = new JPanel();
		analysispanel.setLayout(null);
		analysispanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		analysispanel.setBackground(Color.WHITE);
		analysispanel.setBounds(1131, 301, 350, 210);
		body1panel.add(analysispanel);
		
		JLabel hybridcloudicon_1 = new JLabel("");
		hybridcloudicon_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/analysisicon.png")));
		hybridcloudicon_1.setBounds(294, 11, 40, 40);
		analysispanel.add(hybridcloudicon_1);
		
		JLabel lblAnalytics = new JLabel("Analytics");
		lblAnalytics.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		lblAnalytics.setBounds(10, 35, 249, 39);
		analysispanel.add(lblAnalytics);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("• Data strategy ");
		lblNewLabel_4_4_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_4_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_4_1.setBounds(20, 75, 302, 23);
		analysispanel.add(lblNewLabel_4_4_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("• Data architecture \r\n");
		lblNewLabel_4_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2_1.setBounds(20, 98, 302, 23);
		analysispanel.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_4_2_3_1 = new JLabel("• Data modernization  ");
		lblNewLabel_4_2_3_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3_1.setBounds(20, 126, 302, 23);
		analysispanel.add(lblNewLabel_4_2_3_1);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("• AI & advanced analytics");
		lblNewLabel_4_2_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1.setBounds(20, 152, 302, 23);
		analysispanel.add(lblNewLabel_4_2_1_2_1);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("• AI governance");
		lblNewLabel_4_2_1_2_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1_1.setBounds(20, 176, 302, 23);
		analysispanel.add(lblNewLabel_4_2_1_2_1_1);
		
		JPanel ecommpanel = new JPanel();
		ecommpanel.setLayout(null);
		ecommpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		ecommpanel.setBackground(Color.WHITE);
		ecommpanel.setBounds(51, 541, 350, 210);
		body1panel.add(ecommpanel);
		
		JLabel hybridcloudicon_1_1 = new JLabel("");
		hybridcloudicon_1_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/ecomicon.png")));
		hybridcloudicon_1_1.setBounds(294, 11, 40, 40);
		ecommpanel.add(hybridcloudicon_1_1);
		
		JLabel hybridcloudlb_1_1 = new JLabel("E-commerce");
		hybridcloudlb_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1_1.setBounds(10, 35, 249, 39);
		ecommpanel.add(hybridcloudlb_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1 = new JLabel("• Order and inventory intelligence");
		lblNewLabel_4_2_3_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3_1_1.setBounds(20, 126, 302, 23);
		ecommpanel.add(lblNewLabel_4_2_3_1_1);
		
		JLabel lblNewLabel_4_2_1_2_1_2 = new JLabel("• Business model expansion");
		lblNewLabel_4_2_1_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1_2.setBounds(20, 152, 302, 23);
		ecommpanel.add(lblNewLabel_4_2_1_2_1_2);
		
		JLabel lblNewLabel_4_2_1_2_1_1_1 = new JLabel("• Sustainable commerce");
		lblNewLabel_4_2_1_2_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1_1_1.setBounds(20, 176, 302, 23);
		ecommpanel.add(lblNewLabel_4_2_1_2_1_1_1);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("• Personalization and engagement");
		lblNewLabel_4_1_2_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2_1_1.setBounds(20, 98, 302, 23);
		ecommpanel.add(lblNewLabel_4_1_2_1_1);
		
		JLabel lblNewLabel_4_4_1_1 = new JLabel("• Commerce experience & modernization");
		lblNewLabel_4_4_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_4_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_4_1_1.setBounds(20, 75, 302, 23);
		ecommpanel.add(lblNewLabel_4_4_1_1);
		
		JPanel body2panel = new JPanel();
		body2panel.setBackground(new Color(255, 255, 255));
		body2panel.setBounds(0, 830, 1537, 526);
		scrollContent.add(body2panel);
		body2panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Business Needs");
		lblNewLabel_1_1.setForeground(new Color(15, 98, 254));
		lblNewLabel_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(52, 11, 264, 33);
		body2panel.add(lblNewLabel_1_1);
		
		JPanel operationpanel = new JPanel();
		operationpanel.setLayout(null);
		operationpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		operationpanel.setBackground(Color.WHITE);
		operationpanel.setBounds(49, 55, 350, 210);
		body2panel.add(operationpanel);
		
		JLabel operationiconlbl = new JLabel("");
		operationiconlbl.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/operationicon.png")));
		operationiconlbl.setBounds(294, 11, 40, 40);
		operationpanel.add(operationiconlbl);
		
		JLabel lblNewLabel_4_7 = new JLabel("• Finance and Supply Chain");
		lblNewLabel_4_7.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_7.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_7.setBounds(20, 77, 302, 23);
		operationpanel.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_1_5 = new JLabel("• Business process outsourcing\r\n");
		lblNewLabel_4_1_5.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_5.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_5.setBounds(20, 100, 302, 23);
		operationpanel.add(lblNewLabel_4_1_5);
		
		JLabel lblNewLabel_4_2_6 = new JLabel("• Talent");
		lblNewLabel_4_2_6.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6.setBounds(20, 128, 302, 23);
		operationpanel.add(lblNewLabel_4_2_6);
		
		JLabel lblNewLabel_4_2_1_4 = new JLabel("• Hybrid cloud management");
		lblNewLabel_4_2_1_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4.setBounds(20, 154, 302, 23);
		operationpanel.add(lblNewLabel_4_2_1_4);
		
		JLabel operatioblbl = new JLabel("Operations");
		operatioblbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		operatioblbl.setBounds(10, 27, 249, 39);
		operationpanel.add(operatioblbl);
		
		JLabel lblNewLabel_4_2_1_4_2 = new JLabel("• Procurement services");
		lblNewLabel_4_2_1_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_2.setBounds(20, 176, 302, 23);
		operationpanel.add(lblNewLabel_4_2_1_4_2);
		
		JPanel marketingpanel = new JPanel();
		marketingpanel.setLayout(null);
		marketingpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		marketingpanel.setBackground(Color.WHITE);
		marketingpanel.setBounds(769, 55, 350, 210);
		body2panel.add(marketingpanel);
		
		JLabel marketingiconlbl = new JLabel("");
		marketingiconlbl.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/marketingicon.png")));
		marketingiconlbl.setBounds(300, 11, 40, 40);
		marketingpanel.add(marketingiconlbl);
		
		JLabel hybridcloudlb_1_3 = new JLabel("Marketing");
		hybridcloudlb_1_3.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1_3.setBounds(10, 37, 249, 39);
		marketingpanel.add(hybridcloudlb_1_3);
		
		JLabel lblNewLabel_4_3_1_2 = new JLabel("• Marketing operations");
		lblNewLabel_4_3_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1_2.setBounds(10, 101, 302, 23);
		marketingpanel.add(lblNewLabel_4_3_1_2);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("• Customer insights and data strategy");
		lblNewLabel_4_1_1_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1_2.setBounds(10, 124, 302, 23);
		marketingpanel.add(lblNewLabel_4_1_1_1_2);
		
		JLabel lblNewLabel_4_2_2_1_2 = new JLabel("• Experience innovation");
		lblNewLabel_4_2_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1_2.setBounds(10, 152, 302, 23);
		marketingpanel.add(lblNewLabel_4_2_2_1_2);
		
		JPanel financepanel = new JPanel();
		financepanel.setLayout(null);
		financepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		financepanel.setBackground(Color.WHITE);
		financepanel.setBounds(1129, 55, 350, 210);
		body2panel.add(financepanel);
		
		JLabel financeiconlbl = new JLabel("");
		financeiconlbl.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/financeicon.png")));
		financeiconlbl.setBounds(300, 11, 40, 40);
		financepanel.add(financeiconlbl);
		
		JLabel hybridcloudlb_1 = new JLabel("Finance");
		hybridcloudlb_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1.setBounds(10, 35, 249, 39);
		financepanel.add(hybridcloudlb_1);
		
		JLabel lblNewLabel_4_3_1_1_1 = new JLabel("• Modern business process");
		lblNewLabel_4_3_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1_1_1.setBounds(20, 91, 302, 23);
		financepanel.add(lblNewLabel_4_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("• Finance workflows\r\n");
		lblNewLabel_4_1_1_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1_1_1.setBounds(20, 114, 302, 23);
		financepanel.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_4_2_2_1_1_1 = new JLabel("• Insights");
		lblNewLabel_4_2_2_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1_1_1.setBounds(20, 142, 302, 23);
		financepanel.add(lblNewLabel_4_2_2_1_1_1);
		
		JLabel lblGrowthWith = new JLabel("• Growth with AI");
		lblGrowthWith.setForeground(new Color(125, 125, 125));
		lblGrowthWith.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblGrowthWith.setBounds(20, 164, 302, 23);
		financepanel.add(lblGrowthWith);
		
		JPanel customerpanel = new JPanel();
		customerpanel.setLayout(null);
		customerpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		customerpanel.setBackground(Color.WHITE);
		customerpanel.setBounds(409, 55, 350, 210);
		body2panel.add(customerpanel);
		
		JLabel marketiconlbl = new JLabel("");
		marketiconlbl.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/customerexperince.png")));
		marketiconlbl.setBounds(294, 11, 40, 40);
		customerpanel.add(marketiconlbl);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("• Local resources, global scale  ");
		lblNewLabel_4_3_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1.setBounds(15, 99, 302, 23);
		customerpanel.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("• End-to-end capabilities  ");
		lblNewLabel_4_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(15, 122, 302, 23);
		customerpanel.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("• World-class strategic partnerships ");
		lblNewLabel_4_2_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1.setBounds(15, 150, 302, 23);
		customerpanel.add(lblNewLabel_4_2_2_1);
		
		JLabel artificiallbl_1_1_1 = new JLabel("Customer");
		artificiallbl_1_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		artificiallbl_1_1_1.setBounds(10, 8, 249, 40);
		customerpanel.add(artificiallbl_1_1_1);
		
		JLabel intelegencelbl_1_1_1 = new JLabel("Experience");
		intelegencelbl_1_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		intelegencelbl_1_1_1.setBounds(10, 48, 249, 40);
		customerpanel.add(intelegencelbl_1_1_1);
		
		JPanel supplypanel = new JPanel();
		supplypanel.setLayout(null);
		supplypanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		supplypanel.setBackground(Color.WHITE);
		supplypanel.setBounds(412, 283, 350, 210);
		body2panel.add(supplypanel);
		
		JLabel blockchainIcon_2_1 = new JLabel("");
		blockchainIcon_2_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/supplychainicon.png")));
		blockchainIcon_2_1.setBounds(300, 11, 40, 40);
		supplypanel.add(blockchainIcon_2_1);
		
		JLabel blockchainlbl_1_1 = new JLabel("Supply Chain");
		blockchainlbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		blockchainlbl_1_1.setBounds(10, 27, 249, 39);
		supplypanel.add(blockchainlbl_1_1);
		
		JLabel lblNewLabel_4_7_2 = new JLabel("• Sustainable supply chain");
		lblNewLabel_4_7_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_7_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_7_2.setBounds(10, 77, 302, 23);
		supplypanel.add(lblNewLabel_4_7_2);
		
		JLabel lblNewLabel_4_1_5_2 = new JLabel("• Customer experience");
		lblNewLabel_4_1_5_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_5_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_5_2.setBounds(10, 100, 302, 23);
		supplypanel.add(lblNewLabel_4_1_5_2);
		
		JLabel lblNewLabel_4_2_6_2 = new JLabel("• Agility and visibility");
		lblNewLabel_4_2_6_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6_2.setBounds(10, 128, 302, 23);
		supplypanel.add(lblNewLabel_4_2_6_2);
		
		JLabel lblNewLabel_4_2_1_4_3 = new JLabel("• Predict potential risks");
		lblNewLabel_4_2_1_4_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_3.setBounds(10, 154, 302, 23);
		supplypanel.add(lblNewLabel_4_2_1_4_3);
		
		JLabel lblNewLabel_4_2_1_4_2_1 = new JLabel("• Efficiency with data and automation");
		lblNewLabel_4_2_1_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_2_1.setBounds(10, 176, 302, 23);
		supplypanel.add(lblNewLabel_4_2_1_4_2_1);
		
		JPanel talentmangmentpanel = new JPanel();
		talentmangmentpanel.setLayout(null);
		talentmangmentpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		talentmangmentpanel.setBackground(Color.WHITE);
		talentmangmentpanel.setBounds(52, 283, 350, 210);
		body2panel.add(talentmangmentpanel);
		
		JLabel aiIcon_2_1 = new JLabel("");
		aiIcon_2_1.setIcon(new ImageIcon(EclientservicesPanel.class.getResource("/DservicespanelImg/talenticon.png")));
		aiIcon_2_1.setBounds(294, 11, 40, 40);
		talentmangmentpanel.add(aiIcon_2_1);
		
		JLabel artificiallbl_1_1 = new JLabel("Talent");
		artificiallbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		artificiallbl_1_1.setBounds(10, 11, 249, 40);
		talentmangmentpanel.add(artificiallbl_1_1);
		
		JLabel intelegencelbl_1_1 = new JLabel("Managment");
		intelegencelbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		intelegencelbl_1_1.setBounds(10, 51, 249, 40);
		talentmangmentpanel.add(intelegencelbl_1_1);
		
		JLabel lblNewLabel_4_7_1 = new JLabel("• Talent acquisition and skills development");
		lblNewLabel_4_7_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_7_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_7_1.setBounds(15, 99, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_7_1);
		
		JLabel lblNewLabel_4_1_5_1 = new JLabel("• Employee experience");
		lblNewLabel_4_1_5_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_5_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_5_1.setBounds(15, 122, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_1_5_1);
		
		JLabel lblNewLabel_4_2_6_1 = new JLabel("• HR operations and technology ");
		lblNewLabel_4_2_6_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6_1.setBounds(15, 150, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_2_6_1);
		
		JLabel lblNewLabel_4_2_1_4_1 = new JLabel("  transformation");
		lblNewLabel_4_2_1_4_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_1.setBounds(15, 176, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_2_1_4_1);
		

	}
}
