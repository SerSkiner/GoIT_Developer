CREATE TABLE Developers
(ID int auto_increment primary key,
NAME varchar(50));

CREATE TABLE Skills
(ID int auto_increment primary key,
NAME varchar(50));

CREATE TABLE Dev_Skills
(Developers_ID int,Skills_ID int);

alter table Dev_Skills add constraint PK_Dev_S primary key(DEVELOPERS_ID, SKILLS_ID);

insert into Dev_Skills (developers_id, skills_id) values
(1,2),
(1,1),
(2,3),
(3,8),
(4,1),
(5,5),
(6,5),
(7,2);


CREATE TABLE Projects
(ID int auto_increment primary key,
NAME varchar(50));

CREATE TABLE Companies 
(ID int auto_increment primary key,
NAME varchar(50));

CREATE TABLE Customers  
(ID int auto_increment primary key,
NAME varchar(50));

CREATE TABLE Pro_Dev
(Projects_ID int, Developers_ID int);

alter table Pro_Dev add constraint PK_Pro_D primary key(PROJECTS_ID, DEVELOPERS_ID);

insert into Pro_Dev (projects_id, developers_id) values
(1,1),
(1,4),
(1,3),
(2,3),
(2,2),
(3,5),
(3,1),
(4,3),
(5,2),
(5,6),
(5,1),
(6,2),
(6,6);

CREATE TABLE Corp
(Companies_ID int, Developers_ID int);

alter table Corp add constraint PK_Corp primary key(COMPANIES_ID, DEVELOPERS_ID);

insert into Corp (companies_id, developers_id) values
(1,1),
(1,4),
(1,3),
(2,3),
(2,2),
(3,1),
(3,6),
(3,7),
(4,2),
(4,6),
(4,1),
(2,5),
(2,4);

CREATE TABLE Works
(Companies_ID int, Projects_ID int);

alter table Works add constraint PK_Works primary key(COMPANIES_ID, PROJECTS_ID);

insert into Works (companies_id, projects_id) values
(1,1),
(1,6),
(2,2),
(2,4),
(3,3),
(3,1),
(4,5),
(4,6);

CREATE TABLE Zakaz
(Customers_ID int, Projects_ID int);

alter table Zakaz add constraint PK_Zakaz primary key(CUSTOMERS_ID, PROJECTS_ID);

insert into Zakaz (customers_id, projects_id) values
(1,2),
(1,6),
(2,3),
(2,4),
(3,5),
(3,6),
(4,5),
(4,6),
(5,1),
(5,5);




