create database TODOAPP;
use TODOAPP;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30),
  password varchar(20),
  email varchar(30),
  last_login datetime,
  PRIMARY KEY(id)
);

CREATE TABLE project(
  id int(11) NOT NULL AUTO_INCREMENT,
  intro tinyblob,
  create_time datetime,
  deadline datetime,
  user_id int(11),
  PRIMARY KEY (id),
  KEY `foreign_user_id` (user_id),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE step (
  id int(11) NOT NULL AUTO_INCREMENT,
  intro tinyblob,
  create_time datetime,
  deadline datetime,
  project_id int(11),
  PRIMARY KEY (`id`),
  KEY `foreign_project_id` (project_id),
  CONSTRAINT `step_ibfk_1` FOREIGN KEY (project_id) REFERENCES project(id)
);