alter table projects
add cost  decimal not null;

SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 25000 
WHERE id = 1;


SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 15500 
WHERE id = 2;

SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 12200 
WHERE id = 3;

SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 19000 
WHERE id = 4;

SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 82000 
WHERE id = 5;

SET SQL_SAFE_UPDATES=0;
UPDATE projects 
SET cost = 32000 
WHERE id = 6;