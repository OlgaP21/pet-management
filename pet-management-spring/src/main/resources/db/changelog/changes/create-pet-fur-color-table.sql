--liquibase formatted sql

--changeset admin:2
CREATE TABLE pet_fur_color(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    color VARCHAR(100)
);