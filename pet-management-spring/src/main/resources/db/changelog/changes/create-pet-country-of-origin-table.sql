--liquibase formatted sql

--changeset admin:3
CREATE TABLE pet_country_of_origin(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    country VARCHAR(150)
);