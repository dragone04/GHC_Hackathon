CREATE DATABASE IF NOT EXISTS ghc_hack;
USE ghc_hack;

CREATE TABLE ghc_hack.category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);
 
CREATE TABLE ghc_hack.city (
    city_id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL
);
 
CREATE TABLE ghc_hack.job (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    job_name VARCHAR(100) NOT NULL
);
 
CREATE TABLE ghc_hack.customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL,
    gender CHAR(1) NOT NULL,
    dob DATE NOT NULL,
    city_id INT,
    job_id INT,
    FOREIGN KEY (city_id) REFERENCES city(city_id),
    FOREIGN KEY (job_id) REFERENCES job(job_id)
);
 
CREATE TABLE ghc_hack.transaction (
    trans_num VARCHAR(100) PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    trans_date DATE NOT NULL,
    trans_time TIME NOT NULL,
    category_id INT,
    customer_id INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
 