select sum(salary)
from developers, skills, Dev_Skills
where (developers.ID = Dev_Skills.DEVELOPERS_ID and skills.ID = Dev_Skills.SKILLS_ID and Skill = 'Java');
