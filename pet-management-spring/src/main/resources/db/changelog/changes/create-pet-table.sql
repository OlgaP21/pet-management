--liquibase formatted sql

--changeset admin:7
CREATE TABLE pet(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    `name` VARCHAR(100) NOT NULL CHECK(LENGTH(`name`) >= 3), 
    code BIGINT NOT NULL CHECK(code > 0), 
    `type` VARCHAR(100) NOT NULL CHECK(LENGTH(`type`) >= 2), 
    color VARCHAR(100) NOT NULL CHECK(LENGTH(color) >= 3), 
    country VARCHAR(100) NOT NULL CHECK(LENGTH(country) >= 2)
);