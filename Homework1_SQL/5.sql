DROP TABLE IF EXISTS TEMP_TABLE1;
DROP TABLE IF EXISTS TEMP_TABLE2;
DROP TABLE IF EXISTS TEMP_TABLE3;

CREATE TEMPORARY TABLE TEMP_TABLE1 AS (
      SELECT projects.name AS project_name, projects.cost AS project_income, sum(salary) AS project_spending, projects.cost - sum(salary) AS project_profit
      FROM projects, developers, pro_dev
      WHERE projects.id = pro_dev.projects_id AND developers.id = pro_dev.developers_id
      GROUP BY projects.id);
      
      CREATE TEMPORARY TABLE TEMP_TABLE2 AS (
      SELECT companies.name AS company_name, customers.name AS customer_name,
            sum(TEMP_TABLE1.project_income) AS income_per_customer,
            sum(TEMP_TABLE1.project_spending) AS spending_per_customer,
            sum(TEMP_TABLE1.project_profit) AS profit_per_customer
      FROM companies, projects, customers, works, zakaz, TEMP_TABLE1
      WHERE companies.id = works.companies_id
            AND projects.id = works.projects_id
            AND projects.id = works.projects_id
            AND customers.id = zakaz.customers_id
            AND projects.name = TEMP_TABLE1.project_name
      GROUP BY companies.name, customers.name);

CREATE TEMPORARY TABLE TEMP_TABLE3 AS (
SELECT company_name AS company, min(profit_per_customer) AS min_profit_per_company
FROM TEMP_TABLE2
GROUP BY company_name);

SELECT company_name, customer_name AS customer_with_min_profit, income_per_customer, spending_per_customer, profit_per_customer
FROM TEMP_TABLE2, TEMP_TABLE3
WHERE TEMP_TABLE2.company_name = TEMP_TABLE3.company AND TEMP_TABLE2.profit_per_customer = TEMP_TABLE3.min_profit_per_company
ORDER BY company_name;












DROP TABLE IF EXISTS TEMP_TABLE1;
DROP TABLE IF EXISTS TEMP_TABLE2;
DROP TABLE IF EXISTS TEMP_TABLE3;