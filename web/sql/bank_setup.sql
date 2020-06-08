DROP DATABASE IF EXISTS bank_list;
CREATE DATABASE bank_list;
USE bank_list;

CREATE TABLE user (
  userid int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  surName varchar(45) NOT NULL,
  
  PRIMARY KEY (userid)
);

CREATE TABLE account (
  accountid int NOT NULL AUTO_INCREMENT,
  account int NOT NULL,
  userid int NOT NULL,
  
  PRIMARY KEY (accountid),
 
  FOREIGN KEY (userid) REFERENCES user(userid) ON DELETE CASCADE ON UPDATE CASCADE
);