/*
CREATE DATABASE IBMDatabase

USE IBMDatabase

CREATE TABLE Client (
  client_id INT IDENTITY(1,1) PRIMARY KEY,
  client_contact VARCHAR(255),
  Client_Iname VARCHAR(255),
  Client_fname VARCHAR(255),
  Client_password VARCHAR(255),
  Client_email VARCHAR(255),
  Client_Status VARCHAR(255),
  Company VARCHAR(255),
  Client_residence VARCHAR(255),
  Client_state VARCHAR(255),
  total_Appointment INT,
  total_service_avail INT,
  client_country VARCHAR(255)
);

CREATE TABLE Inquiry (
  inquiry_id INT IDENTITY(1,1) PRIMARY KEY,
  problem TEXT,
  client_fname VARCHAR(255),
  client_lname VARCHAR(255),
  date DATE
  client_email VARCHAR(255)
);


CREATE TABLE Service(
service_id INT,
service_category VARCHAR(255),
service_name VARCHAR(255),
service_capabilities VARCHAR(255),
service_description VARCHAR(255),
);

CREATE TABLE Consultant(
Consultant_id INT PRIMARY KEY,
consultant_fname VARCHAR(255),
consultant_lname VARCHAR(255),
consultant_email VARCHAR(255),
consultant_password VARCHAR(255),
consultant_status VARCHAR(255),
signed_contract VARCHAR(255),
completed_Project INT
service_description VARCHAR(MAX);
);


CREATE TABLE Documentation(
docu_id INT IDENTITY(1,1),
docu_sender_email VARCHAR(255),
docu_recipient_email VARCHAR(255),
docu_filename VARCHAR(255),
docu_file VARBINARY(MAX),
docu_date DATE
docu_text VARCHAR(255); /* new added */
);

CREATE TABLE Schedule(
schedule_id INT IDENTITY(1,1),
client_fname VARCHAR(255),
client_lname VARCHAR(255),
consultant_fname VARCHAR(255),
consultant_lname VARCHAR(255),
schedule_meetlink VARCHAR(255),
schedule_date_time DATETIME
);

CREATE TABLE Notification(
notificitaion_id INT IDENTITY(1,1),
notification_content VARCHAR(255)
);

CREATE TABLE Admin(
admin_id INT,
admin_email VARCHAR(255),
admin_password VARCHAR(255),
admin_fname VARCHAR(255),
admin_lname VARCHAR(255)
);


CREATE TABLE Contract(
  contract_id INT IDENTITY(1,1) PRIMARY KEY,
  consultant_id INT,
  client_id INT,
  contract_file VARBINARY(MAX),
  contract_status VARCHAR(255),
  FOREIGN KEY (consultant_id) REFERENCES Consultant(Consultant_id),
  FOREIGN KEY (client_id) REFERENCES Client(client_id),
   Contract_name VARCHAR(255) , // pdf file name
   Agreement_type VARCHAR(255) ,
   Project_type VARCHAR(255);
   Contract_Date DATE

);

CREATE TABLE Transactions(
  transaction_id  INT IDENTITY(1,1) PRIMARY KEY,
  service_id INT,
  contract_id INT,
  client_id INT,
  consultant_id INT,
  billing INT,
  transaction_status VARCHAR(255),
  FOREIGN KEY (service_id) REFERENCES Service(service_id),
  FOREIGN KEY (contract_id) REFERENCES Contract(contract_id),
  FOREIGN KEY (client_id) REFERENCES Client(client_id),
  FOREIGN KEY (consultant_id) REFERENCES Consultant(Consultant_id)
);
--------------------------------------------------------- INSERTING DATA------------------------------------------

SET IDENTITY_INSERT Client ON;

INSERT INTO Client(client_id, client_contact, client_Iname, client_fname, Client_password, Client_email, Client_Status, Company)
VALUES
(2024010,'+63 29552810', 'Charles', 'Leclerc', 'ScuderiaFerrari', 'CLeclerc@gmail.com', 'Employee', 'Scuderia Ferrari'),
(20240111,'+63 98787677', 'Sainz', 'Carlos', 'ScuderiaFerrari', 'CSspanyol@gmail.com', 'Employee', 'Scuderia Ferrari'),
(20240115,'+63 12345678', 'Verstappen', 'Max', 'RedBull', 'SuperMax@gmail.com', 'Employee', 'Red Bull Racing'),
(20240116,'+63 23231414', 'Bianca', 'Suamali', 'Mclaren', 'bianca@gmail.com', 'Employee', 'McLarren');

SET IDENTITY_INSERT Client OFF;



INSERT INTO Consultant(Consultant_id, consultant_fname, consultant_lname, consultant_email, consultant_password, consultant_status, signed_contract)
VALUES
    (20241122, 'John', 'Doe', 'john.doe@example.com', 'password123', 'Active', 1),
    (20242211, 'Jane', 'Smith', 'jane.smith@example.com', 'secret456', 'Active', 0),
    (20243322, 'Michael', 'Johnson', 'michael.johnson@example.com', 'qwerty', 'Inactive', 1),
    (20243344, 'Emily', 'Brown', 'emily.brown@example.com', 'abc123', 'Active', 0),
    (20244455, 'David', 'Wilson', 'david.wilson@example.com', 'pass123', 'Active', 1),
    (20245566, 'Sarah', 'Miller', 'sarah.miller@example.com', 'hello123', 'Inactive', 0),
    (20246677, 'Matthew', 'Davis', 'matthew.davis@example.com', 'ilovejava', 'Active', 1),
    (20247788, 'Emma', 'Garcia', 'emma.garcia@example.com', 'java123', 'Active', 0),
    (20248899, 'Christopher', 'Martinez', 'christopher.martinez@example.com', 'martinez456', 'Inactive', 1),
    (20241010, 'Olivia', 'Lopez', 'olivia.lopez@example.com', 'p@ssw0rd', 'Active', 0);
    (20241112, 'Oscar', 'Piastri', 'oscar.piastri@example.com', 'password123', 'Active', 1);


INSERT INTO Schedule(schedule_id,client_fname,client_lname,consultant_fname,consultant_lname,schedule_meetlink,schedule_date_time)
VALUES
	(20240101,'Bianca','Suamali','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-24 15:00:00');
	(20240102,'Verstappen','Max','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-24 15:00:00');
	(20240103,'Charles','Leclerc','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-17 15:00:00');
	(20240103,'Carlos','Sainz','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-17 17:00:00');
	(20240101,'Bianca','Suamali','Olivia','Lopez','https://zoom.us/client-presentation','2024-06-25 15:00:00'),
	(20240102,'Verstappen','Max','Olivia','Olivia','https://zoom.us/client-presentation','2024-06-26 15:00:00'),
	(20240103,'Charles','Leclerc','Olivia','Olivia','https://zoom.us/client-presentation','2024-06-17 15:00:00'),
	(20240103,'Carlos','Sainz','Olivia','Olivia','https://zoom.us/client-presentation','2024-06-17 17:00:00');

SELECT * FROM Client;

UPDATE Client
SET total_Appointment = 10
WHERE client_id = 2024010;

UPDATE Client
SET total_Appointment = 5
WHERE client_id = 20240115;

UPDATE Client
SET total_Appointment = 6
WHERE client_id = 20240111;

INSERT INTO Service(service_id, service_category, service_name, service_capabilities, service_description, service_totalBooked)
VALUES(1,'Technology', 'Artificial Intelligence ', 'Conversantional AI','AI, Machine Learning + analytics', 15),
      (2,'Technology', 'Blockchain ', 'Technology Design','Fovernance Design', 10),
	  (3,'Technology', 'Cloud Computing  ', 'Strategy and application','Application management services', 13);


	==== LOGIN FRAME ==================================


	==== CONSULTANT FRAME =============================
	=== query for dashboard panel ======
	SELECT COUNT(*) AS total FROM Schedule WHERE consultant_fname = 'Oscar' AND consultant_lname = 'Piastri'
	SELECT COUNT(*) AS total FROM Client

	=== query for Schedule panel =====
	SELECT COUNT(*) AS total FROM Schedule WHERE consultant_fname = 'Oscar' AND consultant_lname = 'Piastri'
	SELECT CONVERT(VARCHAR(8), schedule_date_time, 108) AS time, client_fname, client_lname, schedule_meetlink FROM Schedule WHERE CONVERT(DATE, schedule_date_time) = CONVERT(DATE, ' todayDate'

	=== query for CCreateScheduleFrame =====
	INSERT INTO Schedule (client_fname, client_lname, consultant_fname, consultant_lname, schedule_meetlink, schedule_date_time) VALUES (?, ?, ?, ?, ?, ?)


	=== query for client panel =====
	SELECT * FROM Client WHERE Client_Iname LIKE 'searchText + ' OR  "Client_fname LIKE 'searchText '"Client_email LIKE ' searchText ' OR "client_contact LIKE ' searchText'Client_Status LIKE ' searchText ' OR Company LIKE '%" + searchText + "%'

	=== query for documentation Panel =====
	SELECT docu_file FROM Documentation WHERE docu_filename = ?

	=== query for Compose frame =====
	INSERT INTO Documentation (docu_sender_email, docu_recipient_email, docu_filename, docu_file, docu_date, docu_text) VALUES (?, ?, ?, ?, ?,?)

	
INSERT INTO Service(service_id, service_category, service_name, service_capabilities, services_description)
VALUES

SET IDENTITY_INSERT Schedule ON;

INSERT INTO Schedule(schedule_id,client_fname,client_lname,consultant_fname,consultant_lname,schedule_meetlink,schedule_date_time)
VALUES
	(20240111,'Bianca','Suamali','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-25 15:00:00'),
	(20240144,'Verstappen','Max','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-25 15:00:00'),
	(20240155,'Charles','Leclerc','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-26 15:00:00');
		(20240125,'Mykie','Patosa','Oscar','Piastri','https://zoom.us/client-presentation','2024-06-26 15:00:00');

SET IDENTITY_INSERT Schedule OFF;

UPDATE Documentation
SET docu_sender_email = 'CLeclerc@gmail.com'
WHERE docu_id = 3

SELECT 
    fk.name AS ForeignKey,
    tp.name AS TableName
FROM 
    sys.foreign_keys AS fk
INNER JOIN 
    sys.tables AS tp ON fk.parent_object_id = tp.object_id
WHERE 
    fk.referenced_object_id = OBJECT_ID('Service');

ALTER TABLE Transactions DROP CONSTRAINT ForeignKey;
ALTER TABLE Transactions DROP CONSTRAINT FK__Transacti__servi__60A75C0F;

DROP TABLE Service;

CREATE TABLE serviceInfo (
    service_info INT IDENTITY PRIMARY KEY,
    service_category VARCHAR(255),
    service_name VARCHAR(255),
    service_capabilities TEXT,
    service_description TEXT
);
 SET IDENTITY_INSERT Service ON;

INSERT INTO Service (service_id, service_category, service_name, service_capabilities, service_description) 
VALUES
-- Technology Services
('Technology', 'Artificial Intelligence', 'AI-powered analytics, natural language processing, machine learning models, computer vision capabilities', 
 'Automates tasks via machine learning, analyzes data for insights, enhances decision-making processes, and provides predictive modeling to anticipate future trends.'),
('Technology', 'Blockchain', 'Decentralized ledger technology, smart contracts, asset tokenization, permissioned networks', 
 'Enables secure, transparent transactions with immutable records, reduces fraud, enhances supply chain traceability, and ensures compliance across complex ecosystems.'),
('Technology', 'Cloud Computing', 'Virtual machines, containers, serverless computing, hybrid cloud solutions', 
 'Provides scalable computing resources over the internet, optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),
('Technology', 'Hybrid Cloud', 'Integration of private and public cloud environments, workload portability, hybrid multi-cloud management', 
 'Combines the flexibility of public cloud with the control of private cloud, enhances data security through multi-layered protection, and improves operational efficiency by optimizing workload distribution.'),
('Technology', 'Application Services', 'Custom application development, legacy system integration, API management, microservices architecture', 
 'Delivers tailored software solutions aligned with business objectives, enhances scalability and agility through modular design, and ensures seamless integration with existing IT infrastructure.'),
('Technology', 'Cybersecurity', 'Threat detection, incident response, data protection, identity and access management (IAM)', 
 'Secures networks, systems, and data from evolving cyber threats, ensures regulatory compliance, and safeguards business continuity with proactive threat intelligence and real-time monitoring.'),
('Technology', 'IT Infrastructure', 'Network architecture, server management, storage solutions, virtualization technologies', 
 'Provides robust hardware and software infrastructure, ensures high availability and scalability of IT resources, and optimizes operational efficiency through advanced virtualization and automation technologies.'),
('Technology', 'Analytics', 'Predictive analytics, data visualization, business intelligence, real-time analytics', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),
('Technology', 'E-commerce', 'Online retail platforms, payment gateways, customer relationship management (CRM), omnichannel solutions', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.'),
  SET IDENTITY_INSERT Service ON;

-- Business Services
('Business', 'Operations', 'Process optimization, workflow management, efficiency metrics, lean methodologies', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),
('Business', 'Customer Experience', 'Personalization strategies, omni-channel engagement, customer feedback analysis, sentiment analysis', 
 'Delivers seamless and personalized customer experiences across all touchpoints, improves customer satisfaction and loyalty, and optimizes marketing strategies based on real-time customer feedback and sentiment analysis.'),
('Business', 'Marketing', 'Digital marketing campaigns, SEO, social media analytics, content management systems (CMS)', 
 'Drives brand awareness and customer acquisition through targeted digital campaigns, improves search engine visibility and engagement on social media platforms, and enhances content management and distribution strategies.'),
('Business', 'Finance', 'Financial planning, risk management, budgeting, compliance management', 
 'Manages financial resources effectively to support strategic goals, mitigates financial risks through comprehensive risk management strategies, ensures regulatory compliance, and optimizes budget allocation for sustainable growth.'),
('Business', 'Talent Management', 'Recruitment strategies, employee training, performance management, workforce analytics', 
 'Attracts, develops, and retains top talent through innovative recruitment strategies and personalized employee development programs, improves workforce productivity and engagement, and drives business success with data-driven workforce analytics.'),
('Business', 'Supply Chain', 'Inventory management, logistics optimization, supplier collaboration, demand forecasting', 
 'Optimizes supply chain operations by reducing costs and improving efficiency in inventory management and logistics, enhances collaboration with suppliers to ensure timely delivery, and achieves operational excellence with accurate demand forecasting and inventory planning.');


 SET IDENTITY_INSERT Service ON;

INSERT INTO Service (service_id, service_category, service_name, service_capabilities, service_description) 
VALUES
-- Technology Services
(66778899,'Technology', 'Artificial Intelligence', '•Conversational AI •CAI, machine learning + analytics •AI for driving Customer Experience
 •AI-powered Data Transformation', 
 'Automates tasks via machine learning, analyzes data for insights, enhances decision-making processes, and provides predictive modeling to anticipate future trends.'),
(67678989,'Technology', 'Blockchain', '•Governance design •Business value design •Technology design •Why design matters', 
 'Enables secure, transparent transactions with immutable records, reduces fraud, enhances supply chain traceability, and ensures compliance across complex ecosystems.'),
(76769898,'Technology', 'Cloud Computing', '•Hybrid cloud strategy and architecture consulting •Application migration and mondenation •Cloud application development consulitng •Application managemenet services for hybrid cloud', 
 'Provides scalable computing resources over the internet, optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),
(89896767,'Technology', 'Hybrid Cloud', '•Maximize the value of hybrid cloud in the generative AI era •Build and deploy app with an open, interoperable platform •Leverage data seamlessly and securely wherever it resides', 
 'Combines the flexibility of public cloud with the control of private cloud, enhances data security through multi-layered protection, and improves operational efficiency by optimizing workload distribution.'),
(98987676,'Technology', 'Application Services', '•Custom and data-managed services •Enterprise application management services
 •Platform services', 
 'Delivers tailored software solutions aligned with business objectives, enhances scalability and agility through modular design, and ensures seamless integration with existing IT infrastructure.'),
(67896789,'Technology', 'Cybersecurity', '•X-Force •Threat Detection and Response services', 
 'Secures networks, systems, and data from evolving cyber threats, ensures regulatory compliance, and safeguards business continuity with proactive threat intelligence and real-time monitoring.'),
(68976897,'Technology', 'IT Infrastructure', '•Accelerate hybrid cloud •Optimize operations •Maximize value', 
 'Provides robust hardware and software infrastructure, ensures high availability and scalability of IT resources, and optimizes operational efficiency through advanced virtualization and automation technologies.'),
(67986798,'Technology', 'Analytics', '•Data strategy •Data architecture  •Data modernization   •AI & advanced analytics', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),
(78967896,'Technology', 'E-commerce', '•Commerce experience •Commerce modernization
 •Personalization and engagement •Order and inventory intelligence', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.');

(22334455,'Business', 'Operations', '•Finance operations •Supply chain operations •Business process outsourcing •Talent operations', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),
(23234545,'Business', 'Customer Experience', '•Experience, product and service design •Digital commerce consulting •Modernize B2B and B2C marketing', 
 'Delivers seamless and personalized customer experiences across all touchpoints, improves customer satisfaction and loyalty, and optimizes marketing strategies based on real-time customer feedback and sentiment analysis.'),
(32325454,'Business', 'Marketing', '•Marketing operations •Customer insights and data strategy •Experience innovation', 
 'Drives brand awareness and customer acquisition through targeted digital campaigns, improves search engine visibility and engagement on social media platforms, and enhances content management and distribution strategies.');
 (33225544,'Business', 'Finance', '•A modern approach to business process operations •Infuse finance workflows with insights and automation •Accurate insights at your fingertips•Drive growth with AI', 
 'Manages financial resources effectively to support strategic goals, mitigates financial risks through comprehensive risk management strategies, ensures regulatory compliance, and optimizes budget allocation for sustainable growth.'),
(55223344,'Business', 'Talent Management', '•Talent acquisition and skills development •HR operations and outsourcing •Employee experience •HR technology transformation', 
 'Attracts, develops, and retains top talent through innovative recruitment strategies and personalized employee development programs, improves workforce productivity and engagement, and drives business success with data-driven workforce analytics.'),
(33553344,'Business', 'Supply Chain', '•Meet rising consumer expectations with a sustainable supply chain • Deliver a differentiated customer experience •Improve agility and visibility', 
 'Optimizes supply chain operations by reducing costs and improving efficiency in inventory management and logistics, enhances collaboration with suppliers to ensure timely delivery, and achieves operational excellence with accurate demand forecasting and inventory planning.');

SET IDENTITY_INSERT Service OFF;

 UPDATE Service
SET service_email = 'mykie123@gmail.com'
WHERE service_id = 2;


SELECT TOP 3 
    s.service_name, 
    s.service_capabilities, 
    s.service_category, 
    COUNT(c.client_id) AS user_count, 
    CONCAT(c.Client_fname, ' ', c.Client_Iname) AS client_fullname
FROM 
    Service s
LEFT JOIN 
    Client c ON s.service_email = c.Client_email
GROUP BY 
    s.service_name, 
    s.service_capabilities, 
    s.service_category, 
    c.Client_fname, 
    c.Client_Iname
ORDER BY 
    user_count DESC;

	SELECT * FROM Admin;
	INSERT INTO Admin(admin_id,admin_email,admin_password, admin_fname,admin_lname)
VALUES(20211101,'fourandseeks@example.com','fourandseeks','Coco','Martin')

SET IDENTITY_INSERT Schedule ON;


INSERT INTO Schedule(schedule_id, client_fname, client_lname, consultant_fname, consultant_lname, schedule_meetlink, schedule_date_time)
VALUES
    (20260201,'Verstappen','Max','Coco','Martin','https://zoom.us/Admin-meeting','2024-06-24 15:00:00'),
    (20240101,'Bianca','Suamali','Coco','Martin','https://zoom.us/Admin-meeting','2024-06-24 15:00:00'),
    (20240201,'Verstappen','Max','Coco','Martin','https://zoom.us/Admin-presentation','2024-06-24 15:00:00'),
    (20240123,'Charles','Leclerc','Coco','Martin','https://zoom.us/Admin-presentation','2024-06-17 15:00:00'),
    (20240133,'Carlos','Sainz','Coco','Martin','https://zoom.us/dmin-meeting','2024-06-17 17:00:00'),
    (20240151,'Bianca','Suamali','Coco','Martin','https://zoom.us/dmin-meeting','2024-06-25 15:00:00'),
    (20240112,'Verstappen','Max','Coco','Martin','https://zoom.us/dmin-meeting','2024-06-26 15:00:00'),
    (20240113,'Charles','Leclerc','Coco','Martin','https://zoom.us/cdmin-meeting','2024-06-27 15:00:00'),
    (20240123,'Carlos','Sainz','Coco','Martin','https://zoom.us/admin-meeting','2024-06-11 05:00:00'),
    (20240201,'Bianca','Suamali','Coco','Martin','https://zoom.us/dmin-meeting','2024-06-12 15:00:00');

SET IDENTITY_INSERT Schedule OFF;


SELECT * FROM Consultant;

UPDATE  Consultant
SET completed_Project = 10
WHERE Consultant_id = 20241112

UPDATE  Consultant
SET expertise_Consultant = 'Backend'
WHERE Consultant_id = 20241112


UPDATE Consultant 
SET signed_contract = 10
WHERE Consultant_id = 20241112;

ALTER TABLE Service
ALTER COLUMN service_description VARCHAR(MAX);



INSERT INTO Service (service_id, service_category, service_name, service_capabilities, service_description) 
VALUES
-- Technology Services
(66778899,'Technology', 'Artificial Intelligence', 'Conversational AI', 
 'Automates tasks via machine learning, analyzes data for insights, enhances decision-making processes, and provides predictive modeling to anticipate future trends.'),
(66778899,'Technology', 'Artificial Intelligence', 'CAI, machine learning + analytics', 
 'Analyzes data for insights, enhances decision-making processes, and provides predictive modeling to anticipate future trends.'),
(66778899,'Technology', 'Artificial Intelligence', 'AI for driving Customer Experience', 
 'Enhances customer experience through personalized interactions and predictive analytics.'),
(66778899,'Technology', 'Artificial Intelligence', 'AI-powered Data Transformation', 
 'Transforms data into actionable insights, enhances decision-making processes, and provides predictive modeling to anticipate future trends.'),

(67678989,'Technology', 'Blockchain', 'Governance design', 
 'Enables secure, transparent transactions with immutable records, reduces fraud, enhances supply chain traceability, and ensures compliance across complex ecosystems.'),
(67678989,'Technology', 'Blockchain', 'Business value design', 
 'Enhances business value through secure, transparent transactions with immutable records, reduces fraud, and ensures compliance across complex ecosystems.'),
(67678989,'Technology', 'Blockchain', 'Technology design', 
 'Designs and implements secure, transparent transactions with immutable records, reduces fraud, and ensures compliance across complex ecosystems.'),
(67678989,'Technology', 'Blockchain', 'Why design matters', 
 'Ensures compliance across complex ecosystems through secure, transparent transactions with immutable records, reduces fraud, and enhances supply chain traceability.'),

(76769898,'Technology', 'Cloud Computing', 'Hybrid cloud strategy and architecture consulting', 
 'Provides scalable computing resources over the internet, optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),
(76769898,'Technology', 'Cloud Computing', 'Application migration and modernization', 
 'Optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),
(76769898,'Technology', 'Cloud Computing', 'Cloud application development consulting', 
 'Provides scalable computing resources over the internet, optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),
(76769898,'Technology', 'Cloud Computing', 'Application management services for hybrid cloud', 
 'Optimizes performance, reduces costs through efficient resource allocation, and ensures seamless integration across hybrid environments.'),

(89896767,'Technology', 'Hybrid Cloud', 'Maximize the value of hybrid cloud in the generative AI era', 
 'Combines the flexibility of public cloud with the control of private cloud, enhances data security through multi-layered protection, and improves operational efficiency by optimizing workload distribution.'),
(89896767,'Technology', 'Hybrid Cloud', 'Build and deploy app with an open, interoperable platform', 
 'Combines the flexibility of public cloud with the control of private cloud, enhances data security through multi-layered protection, and improves operational efficiency by optimizing workload distribution.'),
(89896767,'Technology', 'Hybrid Cloud', 'Leverage data seamlessly and securely wherever it resides', 
 'Combines the flexibility of public cloud with the control of private cloud, enhances data security through multi-layered protection, and improves operational efficiency by optimizing workload distribution.'),

(98987676,'Technology', 'Application Services', 'Custom and data-managed services', 
 'Delivers tailored software solutions aligned with business objectives, enhances scalability and agility through modular design, and ensures seamless integration with existing IT infrastructure.'),
(98987676,'Technology', 'Application Services', 'Enterprise application management services', 
 'Delivers tailored software solutions aligned with business objectives, enhances scalability and agility through modular design, and ensures seamless integration with existing IT infrastructure.'),
(98987676,'Technology', 'Application Services', 'Platform services', 
 'Delivers tailored software solutions aligned with business objectives, enhances scalability and agility through modular design, and ensures seamless integration with existing IT infrastructure.'),

(67896789,'Technology', 'Cybersecurity', 'X-Force', 
 'Secures networks, systems, and data from evolving cyber threats, ensures regulatory compliance, and safeguards business continuity with proactive threat intelligence and real-time monitoring.'),
(67896789,'Technology', 'Cybersecurity', 'Threat Detection and Response services', 
 'Secures networks, systems, and data from evolving cyber threats, ensures regulatory compliance, and safeguards business continuity with proactive threat intelligence and real-time monitoring.'),

(68976897,'Technology', 'IT Infrastructure', 'Optimize operations', 
 'Provides robust hardware and software infrastructure, ensures high availability and scalability of IT resources, and optimizes operational efficiency through advanced virtualization and automation technologies.'),
(68976897,'Technology', 'IT Infrastructure', 'Maximize value', 
 'Provides robust hardware and software infrastructure, ensures high availability and scalability of IT resources, and optimizes operational efficiency through advanced virtualization and automation technologies.'),

(67986798,'Technology', 'Analytics', 'Data strategy', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),
(67986798,'Technology', 'Analytics', 'Data architecture', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),
(67986798,'Technology', 'Analytics', 'Data modernization', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),
(67986798,'Technology', 'Analytics', 'AI & advanced analytics', 
 'Extracts actionable insights from vast and complex datasets, enables data-driven decision-making, enhances operational efficiency, and drives innovation through advanced analytics and visualization tools.'),

(78967896,'Technology', 'E-commerce', 'Commerce experience', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.'),
(78967896,'Technology', 'E-commerce', 'Commerce modernization', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.'),
(78967896,'Technology', 'E-commerce', 'Personalization and engagement', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.'),
(78967896,'Technology', 'E-commerce', 'Order and inventory intelligence', 
 'Facilitates online buying and selling of goods and services, enhances customer engagement and loyalty through personalized experiences, and optimizes sales and marketing strategies across multiple channels.'),

-- Business Services
(22334455,'Business', 'Operations', 'Finance operations', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),
(22334455,'Business', 'Operations', 'Supply chain operations', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),
(22334455,'Business', 'Operations', 'Business process outsourcing', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),
(22334455,'Business', 'Operations', 'Talent operations', 
 'Enhances operational efficiency by streamlining processes, improves productivity with automated workflows, and achieves continuous improvement through data-driven insights and lean practices.'),

(23234545,'Business', 'Customer Experience', 'Experience, product and service design', 
 'Delivers seamless and personalized customer experiences across all touchpoints, improves customer satisfaction and loyalty, and optimizes marketing strategies based on real-time customer feedback and sentiment analysis.'),
(23234545,'Business', 'Customer Experience', 'Digital commerce consulting', 
 'Delivers seamless and personalized customer experiences across all touchpoints, improves customer satisfaction and loyalty, and optimizes marketing strategies based on real-time customer feedback and sentiment analysis.'),
(23234545,'Business', 'Customer Experience', 'Modernize B2B and B2C marketing', 
 'Delivers seamless and personalized customer experiences across all touchpoints, improves customer satisfaction and loyalty, and optimizes marketing strategies based on real-time customer feedback and sentiment analysis.'),

(32325454,'Business', 'Marketing', 'Marketing operations', 
 'Drives brand awareness and customer acquisition through targeted digital campaigns, improves search engine visibility and engagement on social media platforms, and enhances content management and distribution strategies.'),
(32325454,'Business', 'Marketing', 'Customer insights and data strategy', 
 'Drives brand awareness and customer acquisition through targeted digital campaigns, improves search engine visibility and engagement on social media platforms, and enhances content management and distribution strategies.'),
(32325454,'Business', 'Marketing', 'Experience innovation', 
 'Drives brand awareness and customer acquisition through targeted digital campaigns, improves search engine visibility and engagement on social media platforms, and enhances content management and distribution strategies.'),
(33225544,'Business', 'Finance', 'A modern approach to business process operations', 
 'Manages financial resources effectively to support strategic goals, mitigates financial risks through comprehensive risk management, and optimizes financial performance through data-driven insights and advanced analytics.'),
(33225544,'Business', 'Finance', 'Transform finance operations', 
 'Manages financial resources effectively to support strategic goals, mitigates financial risks through comprehensive risk management, and optimizes financial performance through data-driven insights and advanced analytics.'),
(33225544,'Business', 'Finance', 'Financial planning and analysis', 
 'Manages financial resources effectively to support strategic goals, mitigates financial risks through comprehensive risk management, and optimizes financial performance through data-driven insights and advanced analytics.'),

(34325643,'Business', 'Human Resources', 'HR transformation', 
 'Enhances employee experience and engagement through digital HR platforms, optimizes HR processes and operations, and develops strategic workforce planning and talent management strategies.'),
(34325643,'Business', 'Human Resources', 'Talent and organization', 
 'Enhances employee experience and engagement through digital HR platforms, optimizes HR processes and operations, and develops strategic workforce planning and talent management strategies.'),
(34325643,'Business', 'Human Resources', 'Workforce experience', 
 'Enhances employee experience and engagement through digital HR platforms, optimizes HR processes and operations, and develops strategic workforce planning and talent management strategies.'),

(35325742,'Business', 'Procurement', 'Procurement transformation', 
 'Optimizes procurement processes and operations, enhances supplier relationships and collaboration, and achieves cost savings and improved quality through strategic sourcing and category management.'),
(35325742,'Business', 'Procurement', 'Source-to-pay', 
 'Optimizes procurement processes and operations, enhances supplier relationships and collaboration, and achieves cost savings and improved quality through strategic sourcing and category management.'),
(35325742,'Business', 'Procurement', 'Supply chain resilience', 
 'Optimizes procurement processes and operations, enhances supplier relationships and collaboration, and achieves cost savings and improved quality through strategic sourcing and category management.');

 -- Drop the primary key constraint
ALTER TABLE Transactions
DROP CONSTRAINT PK__Transact__85C600AF8DDB626C;

-- Alter the column
ALTER TABLE Transactions
ALTER COLUMN transaction_id BIGINT;

-- Re-create the primary key constraint
ALTER TABLE Transactions
ADD CONSTRAINT PK__Transact__85C600AF8DDB626C PRIMARY KEY (transaction_id);

SELECT * FROM Transactions

ALTER TABLE Transactions
DROP COLUMN transaction_id;

ALTER TABLE Transactions
ADD transaction_id int;


Select * FROM Contract
SELECT * FROM Transactions
SELECT * FROM Service
SELECT * FROM Schedule
SELECT * FROM Client
SELECT * FROM Consultant;


SET IDENTITY_INSERT Schedule ON;


INSERT INTO Schedule(schedule_id, client_fname, client_lname, consultant_fname, consultant_lname, schedule_meetlink, schedule_date_time)
VALUES
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/Admin-meeting', '2024-01-05 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/Admin-meeting', '2024-01-12 15:00:00'),
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/Admin-presentation', '2024-01-19 15:00:00'),
    (RAND(), 'Charles', 'Leclerc', 'Oscar', 'Piastri', 'https://zoom.us/Admin-presentation', '2024-01-26 15:00:00'),
    (RAND(), 'Carlos', 'Sainz', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-02-02 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-02-09 15:00:00'),
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-02-16 15:00:00'),
    (RAND(), 'Charles', 'Leclerc', 'Oscar', 'Piastri', 'https://zoom.us/cdmin-meeting', '2024-02-23 15:00:00'),
    (RAND(), 'Carlos', 'Sainz', 'Oscar', 'Piastri', 'https://zoom.us/admin-meeting', '2024-03-01 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-03-08 15:00:00'),
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-03-15 15:00:00'),
    (RAND(), 'Charles', 'Leclerc', 'Oscar', 'Piastri', 'https://zoom.us/cdmin-meeting', '2024-03-22 15:00:00'),
    (RAND(), 'Carlos', 'Sainz', 'Oscar', 'Piastri', 'https://zoom.us/admin-meeting', '2024-04-05 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-04-12 15:00:00'),
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-04-19 15:00:00'),
    (RAND(), 'Charles', 'Leclerc', 'Oscar', 'Piastri', 'https://zoom.us/cdmin-meeting', '2024-04-26 15:00:00'),
    (RAND(), 'Carlos', 'Sainz', 'Oscar', 'Piastri', 'https://zoom.us/admin-meeting', '2024-05-03 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-05-10 15:00:00'),
    (RAND(), 'Verstappen', 'Max', 'Oscar', 'Piastri', 'https://zoom.us/dmin-meeting', '2024-05-17 15:00:00'),
    (RAND(), 'Charles', 'Leclerc', 'Oscar', 'Piastri', 'https://zoom.us/cdmin-meeting', '2024-05-24 15:00:00'),
    (RAND(), 'Carlos', 'Sainz', 'Oscar', 'Piastri', 'https://zoom.us/admin-meeting', '2024-06-01 15:00:00'),
    (RAND(), 'Bianca', 'Suamali', 'Oscar', 'Piastri', 'https://zoom.us/admin-meeting', '2024-06-01 15:00:00');

	SET IDENTITY_INSERT Schedule OFF;
	SELECT * FROM Contract
SELECT * FROM Client
SELECT * FROM Consultant;

	SELECT * FROM Contract
SELECT * FROM Client
SELECT * FROM Consultant;

UPDATE Contract
SET Contract_name = 'kitazawa2020.pdf'
WHERE contract_id = 1;

UPDATE Contract
SET Contract_name = 'kitazawa2020.pdf'
WHERE contract_id = 1;

UPDATE Contract
SET Agreement_type = 'Full-Time'
WHERE contract_id = 1;

20240119

UPDATE Client
SET Client_fname = 'Ferrar'
WHERE client_id = 2024010

UPDATE Client
SET Client_email = 'princemonaco@gmail.com'
WHERE client_id = 2024010

SET IDENTITY_INSERT Client ON;

INSERT INTO Client (client_id, client_contact, Client_Iname, Client_fname, Client_password, Client_email, Client_Status, Company, Client_residence, Client_state, total_Appointment, total_service_avail, client_country)
VALUES
(20251231, '09171234567', 'Doe', 'John', 'password123', 'johndoe@example.com', 'Active', 'ABC Corp', '123 Main St', 'CA', 5, 10, 'USA'),
(20251232, '09281234567', 'Tanaka', 'Yui', 'password456', 'yui.tanaka@example.com', 'Inactive', 'XYZ Inc', '456 Elm St', 'NY', 3, 8, 'Japan'),
(20251233, '09351234567', 'Santos', 'Maria', 'password789', 'aria.santos@example.com', 'Active', 'DEF Ltd', '789 Oak St', 'TX', 2, 6, 'PH'),
(20251234, '09421234567', 'Lee', 'Jin', 'passwordabc', 'jin.lee@example.com', 'Active', 'GHI Corp', '321 Pine St', 'FL', 4, 9, 'USA'),
(20251235, '09501234567', 'Watanabe', 'Kenji', 'passworddef', 'kenji.watanabe@example.com', 'Inactive', 'JKL Inc', '901 Maple St', 'IL', 1, 5, 'Japan'),
(20251236, '09581234567', 'Garcia', 'Carlos', 'passwordghi', 'carlos.garcia@example.com', 'Active', 'MNO Ltd', '234 Cedar St', 'GA', 3, 7, 'PH'),
(20251237, '09651234567', 'Kim', 'Ji-Hoon', 'passwordjkl', 'jihoon.kim@example.com', 'Active', 'PQR Corp', '567 Spruce St', 'WA', 2, 6, 'USA'),
(20251238, '09721234567', 'Sato', 'Yuka', 'passwordmno', 'yuka.sato@example.com', 'Inactive', 'STU Inc', '890 Fir St', 'OR', 1, 4, 'Japan'),
(20251239, '09791234567', 'Rivera', 'Luis', 'passwordpqr', 'luis.rivera@example.com', 'Active', 'VWX Ltd', '345 Cypress St', 'NC', 3, 8, 'PH'),
(20251240, '09861234567', 'Patel', 'Rahul', 'passwordstu', 'rahul.patel@example.com', 'Active', 'YZA Corp', '678 Elm St', 'NJ', 2, 5, 'USA'),
(20251241, '09921234567', 'Nakamura', 'Koji', 'passwordvwx', 'koji.nakamura@example.com', 'Inactive', 'BCD Inc', '901 Oak St', 'MI', 1, 4, 'Japan'),
(20251242, '09991234567', 'Torres', 'Ana', 'passwordxyz', 'ana.torres@example.com', 'Active', 'EFG Ltd', '234 Pine St', 'OH', 3, 7, 'PH'),
(20251243, '20251234', 'Chen', 'Wei', 'password123', 'wei.chen@example.com', 'Active', 'HIJ Corp', '567 Maple St', 'PA', 2, 6, 'USA'),
(20251244, '20251235', 'Mori', 'Takashi', 'password456', 'takashi.mori@example.com', 'Inactive', 'KLM Inc', '890 Cedar St', 'WI', 1, 5, 'Japan'),
(20251245, '20251236', 'Diaz', 'Juan', 'password789', 'juan.diaz@example.com', 'Active', 'NOP Ltd', '321 Spruce St', 'IN', 3, 8, 'PH'),
(20251246, '20251237', 'Wang', 'Jing', 'passwordabc', 'jing.wang@example.com', 'Active', 'QRS Corp', '901 Fir St', 'TN', 2, 6, 'USA'),
(20251247, '20251238', 'Ito', 'Hiroshi', 'passworddef', 'hiroshi.ito@example.com', 'Inactive', 'TUV Inc', '234 Elm St', 'KY', 1, 4, 'Japan'),
(20251248, '20251239', 'Gomez', 'Maria', 'passwordghi', 'aria.gomez@example.com', 'Active', 'VWX Ltd', '567 Oak St', 'MO', 3, 7, 'PH'),
(20251249, '20251240', 'Kumar', 'Raj', 'passwordjkl', 'raj.kumar@example.com', 'Active', 'YZA Corp', '890 Pine St', 'IA', 2, 5, 'USA'),
(20251250, '20251241', 'Saito', 'Yoshi', 'passwordmno', 'yoshi.saito@example.com', 'Inactive', 'BCD Inc', '345 Maple St', 'KS', 1, 4, 'Japan'),
(20251251, '20251242', 'Hernandez', 'Carlos', 'passwordpqr', 'carlos.hernandez@example.com', 'Active', 'EFG Ltd', '678 Spruce St', 'NE', 3, 8, 'PH'),
(20251252, '20251243', 'Sharma', 'Rohan', 'passwordstu', 'rohan.sharma@example.com', 'Active', 'HIJ Corp', '901 Cedar St', 'ND', 2, 6, 'USA'),
(20251253, '20251244', 'Matsumoto', 'Ken', 'passwordvwx', 'ken.matsumoto@example.com', 'Inactive', 'KLM Inc', '234 Fir St', 'SD', 1, 5, 'Japan'),
(20251254, '20251245', 'Rodriguez', 'Luis', 'passwordxyz', 'luis.rodriguez@example.com', 'Active', 'NOP Ltd', '567 Elm St', 'MT', 3, 7, 'PH'),
(20251255, '20251246', 'Li', 'Wei', 'password123', 'wei.li@example.com', 'Active', 'QRS Corp', '890 Oak St', 'WY', 2, 6, 'USA'),
(20251256, '20251247', 'Nishimura', 'Taro', 'password456', 'taro.nishimura@example.com', 'Inactive', 'TUV Inc', '321 Pine St', 'VT', 1, 4, 'Japan'),
(20251257, '20251248', 'Gonzalez', 'Ana', 'password789', 'ana.gonzalez@example.com', 'Active', 'VWX Ltd', '901 Spruce St', 'NM', 3, 8, 'PH'),
(20251258, '20251249', 'Zhang', 'Jing', 'passwordabc', 'jing.zhang@example.com', 'Active', 'YZA Corp', '234 Maple St', 'NH', 2, 5, 'USA'),
(20251259, '20251250', 'Takahashi', 'Yuka', 'passworddef', 'yuka.takahashi@example.com', 'Inactive', 'BCD Inc', '567 Cedar St', 'NV', 1, 4, 'Japan'),
(20251260, '20251251', 'Martinez', 'Juan', 'passwordghi', 'juan.martinez@example.com', 'Active', 'EFG Ltd', '890 Fir St', 'UT', 3, 7, 'PH');
SET IDENTITY_INSERT Client OFF;

-- Enable identity insert for Contract table
SET IDENTITY_INSERT Contract ON;

-- Insert data into Contract table
INSERT INTO Contract (contract_id, consultant_id, client_id, contract_file, contract_status, Contract_name, Agreement_type, Project_type, Contract_Date)
VALUES 
    (8, 20241122, 20251231, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-01'),
    (9, 20242211, 20251232, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-02'),
    (10, 20243322, 20251233, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-03'),
    (11, 20243344, 20251234, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-04'),
    (12, 20244455, 20251235, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-05'),
    (13, 20245566, 20251236, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-06'),
    (14, 20246677, 20251237, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-07'),
    (15, 20247788, 20251238, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-08'),
    (16, 20248899, 20251239, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-09'),
    (17, 20241010, 20251240, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-10'),
    (18, 20241122, 20251241, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-11'),
    (19, 20242211, 20251242, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-12'),
    (20, 20243322, 20251243, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-13'),
    (21, 20243344, 20251244, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-14'),
    (22, 20244455, 20251245, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-15'),
    (23, 20245566, 20251246, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-16'),
    (24, 20246677, 20251247, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-17'),
    (25, 20247788, 20251248, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-18'),
    (26, 20248899, 20251249, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-01-19'),
    (27, 20241010, 20251250, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-01-20');

-- Disable identity insert for Contract table
SET IDENTITY_INSERT Contract OFF;

-- Enable identity insert for Contract table
SET IDENTITY_INSERT Contract ON;

INSERT INTO Contract (contract_id, consultant_id, client_id, contract_file, contract_status, Contract_name, Agreement_type, Project_type, Contract_Date)
VALUES 
    (28, 20241122, 20251251, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-04-01'),
    (29, 20242211, 20251252, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-04-02'),
    (30, 20243322, 20251253, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-04-03'),
    (31, 20243344, 20251254, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-04-04'),
    (32, 20244455, 20251255, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-04-05'),
    (33, 20245566, 20251256, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-04-06'),
    (34, 20246677, 20251257, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-04-07'),
    (35, 20247788, 20251258, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-04-08'),
    (36, 20248899, 20251259, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-04-09'),
    (37, 20241010, 20251260, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-04-10'),
    (38, 20241122, 20251261, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-05-01'),
    (39, 20242211, 20251262, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-05-02'),
    (40, 20243322, 20251263, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-05-03'),
    (41, 20243344, 20251264, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-05-04'),
    (42, 20244455, 20251265, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-05-05'),
    (43, 20245566, 20251266, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-05-06'),
    (44, 20246677, 20251267, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-05-07'),
    (45, 20247788, 20251268, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-05-08'),
    (46, 20248899, 20251269, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-05-09'),
    (47, 20241010, 20251270, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-05-10'),
    (48, 20241122, 20251271, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-06-01'),
    (49, 20242211, 20251272, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-06-02'),
    (50, 20243322, 20251273, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-06-03'),
    (51, 20243344, 20251274, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-06-04'),
    (52, 20244455, 20251275, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-06-05'),
    (53, 20245566, 20251276, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-06-06'),
    (54, 20246677, 20251277, NULL, 'Not-Signed', NULL, 'full-time', 'one-time project', '2024-06-07'),
    (55, 20247788, 20251278, NULL, 'Signed', NULL, 'part-time', 'recurring project', '2024-06-08');

-- Disable identity insert for Contract table
SET IDENTITY_INSERT Contract OFF;

CREATE PROCEDURE UpdateLoop
AS
BEGIN
    DECLARE @i INT = 8;
    DECLARE @fileContent VARBINARY(MAX);

    -- Replace the string conversion with actual file reading logic
    -- This is a placeholder. In practice, you'd use a method to read file content into @fileContent
    -- For example, using OPENROWSET (BULK...) or a similar approach.

    -- Example using OPENROWSET to read file content:
    SET @fileContent = (
        SELECT BulkColumn
        FROM OPENROWSET(BULK 'C:\\Documents\\Consultation-Agreement.pdf', SINGLE_BLOB) AS FileContent
    );

    WHILE @i <= 100
    BEGIN
        UPDATE Contract
        SET contract_file = @fileContent
        WHERE contract_id = @i;
        
        SET @i = @i + 1;
    END
END;

-- Drop the existing procedure if it exists
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'P' AND name = 'UpdateLoop')
BEGIN
    DROP PROCEDURE UpdateLoop;
END
GO

CREATE PROCEDURE UpdateLoop
AS
BEGIN
    DECLARE @i INT = 8;
    DECLARE @fileContent VARBINARY(MAX);

    -- Replace the string conversion with actual file reading logic
    -- This is a placeholder. In practice, you'd use a method to read file content into @fileContent
    -- For example, using OPENROWSET (BULK...) or a similar approach.

    -- Example using OPENROWSET to read file content:
    SET @fileContent = (
        SELECT BulkColumn
        FROM OPENROWSET(BULK 'C:\\Documents\\Consultation-Agreement.pdf', SINGLE_BLOB) AS FileContent
    );

    WHILE @i <= 100
    BEGIN
        UPDATE Contract
        SET contract_file = @fileContent
        WHERE contract_id = @i;
        
        SET @i = @i + 1;
    END
END;
GO

BEGIN
    DECLARE @i INT = 8;
    DECLARE @fileContent VARBINARY(MAX);

    -- Replace the string conversion with actual file reading logic
    -- This is a placeholder. In practice, you'd use a method to read file content into @fileContent
    -- For example, using OPENROWSET (BULK...) or a similar approach.

    -- Example using OPENROWSET to read file content:
    SET @fileContent = (
        SELECT BulkColumn
        FROM OPENROWSET(BULK 'C:\Users\MOMSIE BETSKIE\Documents\Miguel Documentation\Project-Agreement.pdf', SINGLE_BLOB) AS FileContent
    );

    WHILE @i <= 100
    BEGIN
        UPDATE Contract
        SET contract_file = @fileContent
        WHERE contract_id = @i;
        
        SET @i = @i + 1;
    END
END;


BEGIN
    DECLARE @i INT = 8;

    WHILE @i <= 100
    BEGIN
        UPDATE Contract
        SET Contract_name = 'Project-Agreement.pdf'
        WHERE contract_id = @i;
        
        SET @i = @i + 1;
    END
END;
*/



SELECT * FROM Contract






