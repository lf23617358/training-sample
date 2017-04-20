DROP TABLE USER IF EXISTS;
CREATE TABLE USER (id bigint not null auto_increment, name varchar(255), age number, country varchar(30), primary key (id));