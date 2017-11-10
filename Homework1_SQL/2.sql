select projects.NAME,  sum(salary)
from developers, projects, pro_dev
where (projects.ID = Pro_Dev.PROJECTS_ID and developers.ID = Pro_Dev.DEVELOPERS_ID)
group by projects.NAME
ORDER BY sum(salary) DESC
LIMIT 1;