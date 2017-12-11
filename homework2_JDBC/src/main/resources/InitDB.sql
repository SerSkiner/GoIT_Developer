CREATE TABLE skills
(ID int auto_increment primary key,
name varchar(50) not null);

CREATE TABLE developers
(ID int auto_increment primary key,
name varchar(50) not null,
salary decimal not null);

CREATE TABLE projects
(ID int auto_increment primary key,
name varchar(50) not null);

CREATE TABLE Dev_Skills
(Developers_ID int,Skills_ID int);

alter table Dev_Skills add constraint PK_Dev_S primary key(DEVELOPERS_ID, SKILLS_ID);

insert into Dev_Skills (developers_id, skills_id) values
(1,1);


CREATE TABLE Pro_DEV
(Project_id int, Developers_ID int);

alter table Pro_DEV add constraint PK_PRO_D primary key(PROJECTS_ID, DEVELOPERS_ID);

insert into Pro_DEV (projects_id, developers_id) values
(1,1);
