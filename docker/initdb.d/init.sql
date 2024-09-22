CREATE TABLE IF NOT EXISTS student(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

INSERT INTO student(first_name , last_name) VALUES
('Ramesh' , 'Fadatare'),
('Umesh' , 'Fadatare'),
('John' , 'Doe');