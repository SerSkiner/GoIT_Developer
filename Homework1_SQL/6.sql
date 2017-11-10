SELECT table1.project_name, table1.project_profit, table1.average_salary
FROM (
       SELECT projects.name AS project_name, projects.cost - sum(salary) AS project_profit, AVG(salary) AS average_salary
       FROM projects
       JOIN pro_dev ON projects.id = pro_dev.projects_id
       JOIN developers ON developers.id = pro_dev.developers_id
       GROUP BY projects.name, projects.cost
     ) AS table1
WHERE table1.project_profit = (
      SELECT 	min(table2.project_profit)
      FROM (
             SELECT projects.cost - sum(salary) AS project_profit
             FROM projects
             JOIN pro_dev ON projects.id = pro_dev.projects_id
             JOIN developers ON developers.id = pro_dev.developers_id
             GROUP BY projects.name, projects.cost
           ) AS table2)