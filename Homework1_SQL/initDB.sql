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


