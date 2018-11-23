#identify which database to use
use company;

#creates a table called 'office'
create table office (
	id int,
	office_name varchar(28)
);

#using 'ALTER' to add auto-increment to column id
ALTER TABLE office
MODIFY id int AUTO_INCREMENT;

#using 'ALTER' to add a new column 'office'
ALTER TABLE office
ADD COLUMN tele int AFTER office_name;

#inserts data into table 'office' - column 'id' auto increments
INSERT INTO office (address, tele)
VALUES 	('Sylvan', 12345678),
	('Føtex', 87654321),
        ('Netto', 72637848),
        ('XL Byg', 85736458);

#using 'UPDATE' to change id value to 5 where id is 2
UPDATE office SET id = 5
WHERE id = 2;

#delete the row with id 4 from table 'office'
DELETE FROM office
WHERE id = 4;

#changing the telephone # for row with id 1
UPDATE office 
SET tele = 87654521
WHERE id = 1;

#creates table 'employees' where column 'id_employees' auto increments and
#is the primary key
CREATE TABLE employees (
	id_employees INT NOT NULL AUTO_INCREMENT,
	f_name VARCHAR(45) NULL,
	l_name VARCHAR(45) NULL,
	address VARCHAR(45) NULL,
	telephone INT NULL,
	PRIMARY KEY (id_employees)
);

