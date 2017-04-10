DROP TABLE USER IF EXISTS;
CREATE TABLE USER (id bigint not null, name varchar(255), age number, primary key (id));
INSERT INTO USER (id, name, age) values (1,'testuser1',18);
INSERT INTO USER (id, name, age) values (2,'testuser2',22);
