INSERT INTO sites(id, name, host, username, password, log_path, log_type, connection_type) VALUES (1, 'SFR', '127.0.0.1', 'admin', 'ad1npassw0rd', 'c:\\temp_db\\sfrlogs.csv', 'CSV', 'SSH');
INSERT INTO sites(id, name, host, username, password, log_path, log_type, connection_type) VALUES (2, 'ORANGE', '127.0.0.1', 'admin', 'ad1npassw0rd', 'c:\mysites_db\orange.csv', 'CSV', 'SSH');


INSERT INTO logs(site_id, service, status, attempt, status_info, event_date) VALUES(1, 'FTP', 'OK', '1/4', 'FTP OK - 0,005 second response time on port 21 [220 Welcome to FTP service.]', '2014-05-18 09:05:43.00014');
INSERT INTO logs(site_id, service, status, attempt, status_info, event_date) VALUES(1, 'SSH', 'KO', '3/4', 'ssh connection error - Openssh 5.3', '2014-05-18 09:05:43.00114');
