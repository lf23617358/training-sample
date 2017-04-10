DROP TABLE USER IF EXISTS;
CREATE TABLE USER (id bigint not null, name varchar(255), age number, country varchar(30), primary key (id));
INSERT INTO USER (id, name, age, country) values (1,'testuser1',18, '台灣');
INSERT INTO USER (id, name, age, country) values (2,'testuser2',22, '美國');
