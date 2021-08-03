DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              occupation VARCHAR(250) DEFAULT NULL
);

INSERT INTO customers (name, occupation) VALUES
('Aliko', 'Billionaire Industrialist'),
('Bill', 'Billionaire Tech Entrepreneur'),
('Folrunsho', 'Billionaire Oil Magnate');
