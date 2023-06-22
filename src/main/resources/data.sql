CREATE TABLE Client (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255),
  date_birth DATE,
  street VARCHAR(255),
  number VARCHAR(255),
  complement VARCHAR(255),
  neighborhood VARCHAR(255),
  city VARCHAR(255),
  state VARCHAR(255),
  postal_code VARCHAR(255),
  country VARCHAR(255)
);

INSERT INTO Client (name, phone_number, date_birth, street, number, complement, neighborhood, city, state, postal_code, country)
VALUES ('John Doe', '1234567890', '1990-01-15', 'Main Street', '123', '', 'Downtown', 'Cityville', 'Stateville', '12345', 'Countryland'),
       ('Jane Smith', '9876543210', '1985-05-20', 'Oak Avenue', '456', 'Apt 2B', 'Suburbia', 'Townsville', 'Stateville', '54321', 'Countryland'),
       ('Michael Johnson', '5551112222', '1998-12-03', 'Pine Street', '789', '', 'Hillsborough', 'Hillsville', 'Stateville', '67890', 'Countryland'),
       ('Emily Davis', '9998887777', '1992-07-08', 'Cedar Road', '321', 'Suite 10', 'Woodland', 'Villageville', 'Stateville', '98765', 'Countryland'),
       ('Robert Wilson', '4445556666', '1980-11-25', 'Elm Street', '987', '', 'Suburbia', 'Townsville', 'Stateville', '56789', 'Countryland'),
       ('Olivia Johnson', '7778889999', '1995-03-12', 'Maple Avenue', '654', '', 'Hillsborough', 'Hillsville', 'Stateville', '34567', 'Countryland'),
       ('James Anderson', '1112223333', '1997-09-30', 'Chestnut Lane', '234', 'Apt 5C', 'Downtown', 'Cityville', 'Stateville', '87654', 'Countryland'),
       ('Sophia Martinez', '6667778888', '1993-04-22', 'Walnut Drive', '876', '', 'Suburbia', 'Townsville', 'Stateville', '23456', 'Countryland'),
       ('William Johnson', '2223334444', '1988-06-05', 'Pine Street', '345', '', 'Hillsborough', 'Hillsville', 'Stateville', '76543', 'Countryland'),
       ('Ava Thompson', '8889990000', '1991-02-18', 'Spruce Avenue', '567', 'Apt 7D', 'Woodland', 'Villageville', 'Stateville', '43210', 'Countryland'),
       ('Josephine Wilson', '3334445555', '1987-08-10', 'Birch Road', '654', '', 'Suburbia', 'Townsville', 'Stateville', '87654', 'Countryland'),
       ('Benjamin Davis', '5556667777', '1994-01-25', 'Sycamore Lane', '789', '', 'Hillsborough', 'Hillsville', 'Stateville', '34567', 'Countryland'),
       ('Charlotte Rodriguez', '7778889999', '1989-05-13', 'Ash Street', '876', 'Suite 3A', 'Downtown', 'Cityville', 'Stateville', '65432', 'Countryland'),
       ('Daniel Garcia', '2223334444', '1996-10-07', 'Cedar Road', '987', '', 'Suburbia', 'Townsville', 'Stateville', '98765', 'Countryland'),
       ('Mia Johnson', '9998887777', '1992-03-01', 'Elm Street', '123', '', 'Hillsborough', 'Hillsville', 'Stateville', '56789', 'Countryland'),
       ('Ethan Moore', '4445556666', '1998-07-24', 'Maple Avenue', '654', 'Apt 4B', 'Woodland', 'Villageville', 'Stateville', '34567', 'Countryland'),
       ('Isabella Lee', '6667778888', '1995-12-17', 'Oak Avenue', '876', '', 'Suburbia', 'Townsville', 'Stateville', '87654', 'Countryland'),
       ('Liam Martinez', '1112223333', '1997-04-10', 'Pine Street', '345', '', 'Hillsborough', 'Hillsville', 'Stateville', '23456', 'Countryland'),
       ('Amelia Anderson', '8889990000', '1991-09-23', 'Maple Avenue', '567', 'Apt 6C', 'Downtown', 'Cityville', 'Stateville', '76543', 'Countryland'),
       ('Henry Thompson', '3334445555', '1987-02-06', 'Walnut Drive', '654', '', 'Suburbia', 'Townsville', 'Stateville', '32109', 'Countryland');

