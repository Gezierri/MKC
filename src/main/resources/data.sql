CREATE TABLE client (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255),
  email VARCHAR(255),
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

INSERT INTO client (name, phone_number, date_birth, email, street, number, complement, neighborhood, city, state, postal_code, country)
VALUES
  ('John Doe', '1234567890', '1990-01-15', 'john.doe@example.com', 'Main Street', '123', '', 'Downtown', 'Cityville', 'Stateville', '12345', 'Countryland'),
  ('Jane Smith', '9876543210', '1985-05-20', 'jane.smith@example.com', 'Oak Avenue', '456', 'Apt 2B', 'Suburbia', 'Townsville', 'Stateville', '54321', 'Countryland'),
  ('Michael Johnson', '5551112222', '1998-12-03', 'michael.johnson@example.com', 'Pine Street', '789', '', 'Hillsborough', 'Hillsville', 'Stateville', '67890', 'Countryland'),
  ('Emily Davis', '9998887777', '1992-07-08', 'emily.davis@example.com', 'Cedar Road', '321', 'Suite 10', 'Woodland', 'Villageville', 'Stateville', '98765', 'Countryland'),
  ('Robert Wilson', '4445556666', '1980-11-25', 'robert.wilson@example.com', 'Elm Street', '987', '', 'Suburbia', 'Townsville', 'Stateville', '56789', 'Countryland'),
  ('Olivia Johnson', '7778889999', '1995-03-12', 'olivia.johnson@example.com', 'Maple Avenue', '654', '', 'Hillsborough', 'Hillsville', 'Stateville', '34567', 'Countryland'),
  ('James Anderson', '1112223333', '1997-09-30', 'james.anderson@example.com', 'Chestnut Lane', '234', 'Apt 5C', 'Downtown', 'Cityville', 'Stateville', '87654', 'Countryland'),
  ('Sophia Martinez', '6667778888', '1993-04-22', 'sophia.martinez@example.com', 'Walnut Drive', '876', '', 'Suburbia', 'Townsville', 'Stateville', '23456', 'Countryland'),
  ('William Johnson', '2223334444', '1988-06-05', 'william.johnson@example.com', 'Pine Street', '345', '', 'Hillsborough', 'Hillsville', 'Stateville', '76543', 'Countryland'),
  ('Ava Thompson', '8889990000', '1991-02-18', 'ava.thompson@example.com', 'Spruce Avenue', '567', 'Apt 7D', 'Woodland', 'Villageville', 'Stateville', '43210', 'Countryland'),
  ('Josephine Wilson', '3334445555', '1987-08-10', 'josephine.wilson@example.com', 'Birch Road', '654', '', 'Suburbia', 'Townsville', 'Stateville', '87654', 'Countryland'),
  ('Benjamin Davis', '5556667777', '1994-01-25', 'benjamin.davis@example.com', 'Sycamore Lane', '789', '', 'Hillsborough', 'Hillsville', 'Stateville', '34567', 'Countryland'),
  ('Charlotte Rodriguez', '7778889999', '1989-05-13', 'charlotte.rodriguez@example.com', 'Ash Street', '876', 'Suite 3A', 'Downtown', 'Cityville', 'Stateville', '65432', 'Countryland'),
  ('Daniel Garcia', '2223334444', '1996-10-07', 'daniel.garcia@example.com', 'Cedar Road', '987', '', 'Suburbia', 'Townsville', 'Stateville', '98765', 'Countryland'),
  ('Mia Johnson', '9998887777', '1992-03-01', 'mia.johnson@example.com', 'Elm Street', '123', '', 'Hillsborough', 'Hillsville', 'Stateville', '56789', 'Countryland'),
  ('Ethan Moore', '4445556666', '1998-07-24', 'ethan.moore@example.com', 'Maple Avenue', '654', 'Apt 4B', 'Woodland', 'Villageville', 'Stateville', '34567', 'Countryland'),
  ('Isabella Lee', '6667778888', '1995-12-17', 'isabella.lee@example.com', 'Oak Avenue', '876', '', 'Suburbia', 'Townsville', 'Stateville', '87654', 'Countryland'),
  ('Liam Martinez', '1112223333', '1997-04-10', 'liam.martinez@example.com', 'Pine Street', '345', '', 'Hillsborough', 'Hillsville', 'Stateville', '23456', 'Countryland'),
  ('Amelia Anderson', '8889990000', '1991-09-23', 'amelia.anderson@example.com', 'Maple Avenue', '567', 'Apt 6C', 'Downtown', 'Cityville', 'Stateville', '76543', 'Countryland'),
  ('Henry Thompson', '3334445555', '1987-02-06', 'henry.thompson@example.com', 'Walnut Drive', '654', '', 'Suburbia', 'Townsville', 'Stateville', '32109', 'Countrland'),
  ('Nara', '77 9 9999-9999', '1994-11-26', 'henry.thompson@example.com', 'Walnut Drive', '654', '', 'Suburbia', 'Townsville', 'Stateville', '32109', 'Countryland');



CREATE TABLE product (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  price DECIMAL(10, 2) NOT NULL,
  stock INT NOT NULL    
);

INSERT INTO product (name, description, price, stock) VALUES
  ('Product 7', 'Description 7', 9.99, 50),
  ('Product 8', 'Description 8', 14.99, 100),
  ('Product 9', 'Description 9', 7.49, 200),
  ('Product 10', 'Description 10', 11.99, 75),
  ('Product 11', 'Description 11', 6.99, 150),
  ('Product 12', 'Description 12', 8.99, 300),
  ('Product 13', 'Description 13', 12.99, 90),
  ('Product 14', 'Description 14', 5.99, 180),
  ('Product 15', 'Description 15', 7.99, 250),
  ('Product 16', 'Description 16', 10.99, 120),
  ('Product 17', 'Description 17', 9.49, 220),
  ('Product 18', 'Description 18', 6.49, 160),
  ('Product 19', 'Description 19', 11.49, 80),
  ('Product 20', 'Description 20', 8.49, 190),
  ('Product 21', 'Description 21', 5.49, 270),
  ('Product 22', 'Description 22', 13.49, 110),
  ('Product 23', 'Description 23', 9.99, 210),
  ('Product 24', 'Description 24', 7.99, 140),
  ('Product 25', 'Description 25', 12.99, 95);

CREATE TABLE users ( id BIGINT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255) NOT NULL, password VARCHAR(255))
