DROP SCHEMA IF EXISTS users;
CREATE SCHEMA users DEFAULT CHARACTER SET utf8 ;
USE users;

CREATE TABLE contact(
  id_contact INT NOT NULL AUTO_INCREMENT,
  document_number int(12) NOT NULL,
  full_name VARCHAR(45) NOT NULL,
  position VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_contact));

INSERT INTO contact (document_number, full_name, position)
VALUES (78000000, 'contacto 1', 'gerente');

INSERT INTO contact (document_number, full_name, position)
VALUES (79000000, 'contacto 2', 'ejecutivo');

INSERT INTO contact (document_number, full_name, position)
VALUES (80000000, 'contacto 3', 'sistemas');