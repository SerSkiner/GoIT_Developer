CREATE TABLE developers(
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   EXPERIENCE  INT        NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE skills(
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE projects   (
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE companies    (
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE customers     (
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   PRIMARY KEY (ID)
);

