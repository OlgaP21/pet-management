--liquibase formatted sql

--changeset admin:5
INSERT INTO pet_fur_color (color) VALUES ('Black');
INSERT INTO pet_fur_color (color) VALUES ('White');
INSERT INTO pet_fur_color (color) VALUES ('Brown');
INSERT INTO pet_fur_color (color) VALUES ('Yellow');
INSERT INTO pet_fur_color (color) VALUES ('Blue');