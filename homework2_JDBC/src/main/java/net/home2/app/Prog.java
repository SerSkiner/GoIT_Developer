package net.home2.app;

import net.home2.app.dao.*;
import net.home2.app.model.GenericDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Prog {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to JDBC App.For Avalible command see help");


        GenericDAO genericDAO = new Storage();
        while (sc.hasNextLine()) {

            String command = sc.nextLine();


            if (command.equals("project_list")) {
                List<Project> projects = null;
                try {
                    projects = genericDAO.listProject();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    projects = genericDAO.listProject();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println();
                System.out.println("LIST PROJECTS");
                System.out.println("ID   |   NAME");
                for (Project project : projects) {
                    System.out.println(project.getId() + "   |    " + project.getName());
                }
                System.out.println();


            }
            if (command.equals("exit") || command.equals("quit")) {
                break;
            } else if (command.equals("add_project")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                Project project = new Project();
                project.setName(name);
                try {
                    genericDAO.save(project);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Project created");
            } else if (command.equals("delete_project")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Project project = genericDAO.deleteProject(id);
                System.out.println("Project deleted");
            } else if (command.equals("upd_project")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Project project = new Project();
                project.setName(name);
                project.setId(id);
                genericDAO.updateProject(project);
                System.out.println("Project updated");

            }

            if (command.equals("skill_list")) {
                List<Skill> skills = null;
                try {
                    skills = genericDAO.listSkill();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    skills = genericDAO.listSkill();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println();
                System.out.println("LIST SKILL");
                System.out.println("ID   |   NAME");
                for (Skill skill : skills) {
                    System.out.println(skill.getId() + "   |    " + skill.getName());
                }
                System.out.println();


            }
            if (command.equals("add_skill")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                Skill skill = new Skill();
                skill.setName(name);
                try {
                    genericDAO.save(skill);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Skill created");
            } else if (command.equals("skill_delete")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Skill skill = genericDAO.deleteSkill(id);
                System.out.println("Skill deleted");

            } else if (command.equals("upd_skill")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Skill skill = new Skill();
                skill.setName(name);
                skill.setId(id);
                genericDAO.updateSkill(skill);
                System.out.println("Skill updated");

            }
            if (command.equals("add_dev")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                System.out.print("Введите зарплату: ");
                String salary = sc.nextLine();
                Developer developer = new Developer();
                developer.setName(name);
                developer.setSalary(salary);
                try {
                    genericDAO.save(developer);
                    System.out.println("Developer created");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("upd_dev")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                System.out.print("Введите зарплату: ");
                String salary = sc.nextLine();
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Developer developer = new Developer();
                developer.setName(name);
                developer.setSalary(salary);
                developer.setId(id);
                genericDAO.updateDeveloper(developer);
                System.out.println("Developer updated");

            }
            if (command.equals("dev_list")) {
                List<Developer> developers = null;
                try {
                    developers = genericDAO.listDeveloper();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    developers = genericDAO.listDeveloper();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();
                System.out.println();
                System.out.println("LIST DEVELOPERS");
                System.out.println("ID   |   NAME   |     SALARY");
                for (Developer developer : developers) {
                    System.out.println(developer.getId() + "   |    " + developer.getName() + "  |   " + developer.getSalary());

                }
                System.out.println();


            } else if (command.equals("dev_delete")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Developer developer = genericDAO.deleteDeveloper(id);
                System.out.println("Developer deleted");
            } else if (command.equals("info_dev")) {
                try {
                    Developer developer = genericDAO.getDev();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (command.equals("add_skill_dev")) {
                System.out.print("Введите ID разработчика: ");
                long id = sc.nextLong();
                System.out.print("Введите ID скила: ");
                long id1 = sc.nextLong();
                Dev_Skills dev_skills = new Dev_Skills();
                dev_skills.setDevelopers_id(id);
                dev_skills.setSkills_id(id1);
                try {
                    genericDAO.addSkil(dev_skills);
                    System.out.println("Developer updated");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if (command.equals("info_project")) {
                try {
                    Project project = genericDAO.getPro();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (command.equals("add_pro_dev")) {
                System.out.print("Введите ID проекта: ");
                long id = sc.nextLong();
                System.out.print("Введите ID разработчика: ");
                long id1 = sc.nextLong();
                Pro_Dev pro_dev = new Pro_Dev();
                pro_dev.setProjects_id(id);
                pro_dev.setDevelopers_id(id1);
                try {
                    genericDAO.adddev(pro_dev);
                    System.out.println("Project updated");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}