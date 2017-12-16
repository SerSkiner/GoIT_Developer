CREATE TABLE skills
(id_skill int auto_increment primary key,
skill_name varchar(50) not null);

CREATE TABLE developers
(id_developer int auto_increment primary key,
developer_name varchar(100) not null,
id_skill int,
salary decimal not null,
FOREIGN KEY (id_skill) REFERENCES skills(id_skill));

CREATE TABLE projects
(id_project int auto_increment primary key,
project_name varchar(50) not null,
id_developer int,
FOREIGN KEY (id_developer) REFERENCES developers(id_developer));
