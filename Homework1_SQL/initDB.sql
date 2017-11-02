CREATE TABLE developers(
   ID   INT               NOT NULL,
   NAME VARCHAR (100)     NOT NULL,
   EXPERIENCE  INT        NOT NULL,
   SKILL varchar(100)    not null,
   SKILLSE varchar(100),
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

ALTER TABLE `developers`
ADD CONSTRAINT `<SKILL>` FOREIGN KEY (`id`) REFERENCES `skills` (`id`),
ADD CONSTRAINT `<SKILLSE>` FOREIGN KEY (`id`) REFERENCES `skills` (`id`)

  
  

