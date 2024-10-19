CREATE TABLE IF NOT EXISTS student(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

INSERT INTO student(first_name , last_name) VALUES
('Ramesh' , 'Fadatare'),
('Umesh' , 'Fadatare'),
('John' , 'Doe');


CREATE TABLE IF NOT EXISTS employee(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(32) NOT NULL UNIQUE KEY,
    department_id INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS department(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(32) NOT NULL UNIQUE KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);