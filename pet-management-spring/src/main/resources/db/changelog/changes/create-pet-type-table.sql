--liquibase formatted sql

--changeset admin:1
CREATE TABLE pet_type(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    `type` VARCHAR(100)
);