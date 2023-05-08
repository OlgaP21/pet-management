--liquibase formatted sql

--changeset admin:4
INSERT INTO pet_type (`type`) VALUES ('Cat');
INSERT INTO pet_type (`type`) VALUES ('Dog');
INSERT INTO pet_type (`type`) VALUES ('Horse');
INSERT INTO pet_type (`type`) VALUES ('Rabbit');
INSERT INTO pet_type (`type`) VALUES ('Parrot');