--liquibase formatted sql

--changeset admin:8
INSERT INTO pet (`name`, code, `type`, color, country) VALUES ('Mustikas', 202211151535, 'Cat', 'Black', 'Estonia');
INSERT INTO pet (`name`, code, `type`, color, country) VALUES ('Roy', 202211151536, 'Dog', 'Brown', 'Latvia');
INSERT INTO pet (`name`, code, `type`, color, country) VALUES ('Charles', 202211151536, 'Horse', 'White', 'Norway');