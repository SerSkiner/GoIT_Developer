CREATE TABLE skills
(id  bigint auto_increment primary key,
skill_name varchar(50) not null);

CREATE TABLE developers
(id  bigint auto_increment primary key,
developer_name varchar(100) not null,
skill_id bigint,
salary decimal not null,
FOREIGN KEY (skill_id) REFERENCES skills(id));

CREATE TABLE projects
(id  bigint auto_increment primary key,
project_name varchar(50) not null,
developer_id bigint,
FOREIGN KEY (developer_id) REFERENCES developers(id));
