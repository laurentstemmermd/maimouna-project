DROP TABLE sites IF EXISTS;
DROP TABLE vets IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE visits IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;


CREATE TABLE sites (
  id         INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
  host VARCHAR(30),
  username VARCHAR(30),
  password VARCHAR(30),
  log_path VARCHAR(500),
  log_type  VARCHAR(30),
  connection_type  VARCHAR(30)
);
CREATE INDEX sites_name ON sites (name);

CREATE TABLE logs (
  id         INTEGER IDENTITY PRIMARY KEY,
 	site_id		 INTEGER,
 	service VARCHAR(30),
 	event_date TIMESTAMP,
  status VARCHAR(30),
  attempt  VARCHAR(30),
  status_info VARCHAR(500)
);
CREATE INDEX logs_site_id ON logs (site_id);

