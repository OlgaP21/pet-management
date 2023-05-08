--liquibase formatted sql

--changeset admin:6
INSERT INTO pet_country_of_origin (country) VALUES ('Estonia');
INSERT INTO pet_country_of_origin (country) VALUES ('Latvia');
INSERT INTO pet_country_of_origin (country) VALUES ('Lithuania');
INSERT INTO pet_country_of_origin (country) VALUES ('Finland');
INSERT INTO pet_country_of_origin (country) VALUES ('Sweden');
INSERT INTO pet_country_of_origin (country) VALUES ('Norway');
