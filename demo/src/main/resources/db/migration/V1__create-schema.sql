--drop table if exists customers;
--drop customers if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
CREATE TABLE customers (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(30), last_name VARCHAR(30));