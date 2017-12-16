package net.home2.app;

import net.home2.app.dao.*;
import net.home2.app.model.GenericDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import java.util.StringJoiner;

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
                System.out.println("\nLIST PROJECTS");
                System.out.println("ID | NAME | DEVELOPER");
                for (Project project : projects) {
                    StringJoiner sj = new StringJoiner(" | ");
                      sj.add(project.getId_project().toString());
                      sj.add(project.getProject_name());
                      sj.add(project.getDeveloper_name());
                    System.out.println(sj);
                }
                System.out.println();


            }
            if (command.equals("Quit") || command.equals("quit")) {
                break;
            } else if (command.equals("add_project")) {
                System.out.print("Введите имя: ");
                String project_name = sc.nextLine();
                Project project = new Project();
                project.setProject_name(project_name);
                try {
                    genericDAO.save(project);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Project created");
            } else if (command.equals("delete_project")) {
                System.out.print("Введите ID: ");
                long id_project = sc.nextLong();
                Project project = genericDAO.deleteProject(id_project);
                System.out.println("Project deleted");
            } else if (command.equals("upd_project")) {
                System.out.print("Введите имя: ");
                String project_name = sc.nextLine();
                System.out.print("Введите ID: ");
                long id_project = sc.nextLong();
                Project project = new Project();
                project.setProject_name(project_name);
                project.setId_project(id_project);
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
                System.out.println("\nLIST SKILL");
                System.out.println("ID | NAME");
                for (Skill skill : skills) {
                    StringJoiner sj = new StringJoiner(" | ");
                    sj.add(skill.getId_skill().toString());
                    sj.add(skill.getSkill_name());
                    System.out.println(sj);
                }
                System.out.println();


            }
            if (command.equals("add_skill")) {
                System.out.print("Введите имя: ");
                String skill_name = sc.nextLine();
                Skill skill = new Skill();
                skill.setSkill_name(skill_name);
                try {
                    genericDAO.save(skill);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Skill created");
            } else if (command.equals("skill_delete")) {
                System.out.print("Введите ID: ");
                long id_skill = sc.nextLong();
                Skill skill = genericDAO.deleteSkill(id_skill);
                System.out.println("Skill deleted");

            } else if (command.equals("upd_skill")) {
                System.out.print("Введите имя: ");
                String name = sc.nextLine();
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Skill skill = new Skill();
                skill.setSkill_name(name);
                skill.setId_skill(id);
                genericDAO.updateSkill(skill);
                System.out.println("Skill updated");

            }
            if (command.equals("add_dev")) {
                System.out.print("Введите имя: ");
                String developer_name = sc.nextLine();
                System.out.print("Введите зарплату: ");
                String salary = sc.nextLine();
                Developer developer = new Developer();
                developer.setDeveloper_name(developer_name);
                developer.setSalary(salary);
                try {
                    genericDAO.save(developer);
                    System.out.println("Developer created");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("upd_dev")) {
                System.out.print("Введите имя: ");
                String developer_name = sc.nextLine();
                System.out.print("Введите зарплату: ");
                String salary = sc.nextLine();
                System.out.print("Введите ID: ");
                long id_developer = sc.nextLong();
                Developer developer = new Developer();
                developer.setDeveloper_name(developer_name);
                developer.setSalary(salary);
                developer.setId_developer(id_developer);
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
                System.out.println("\nLIST DEVELOPERS");
                System.out.println("ID | NAME | SKILLS | SALARY");
                for (Developer developer : developers) {
                    StringJoiner sj = new StringJoiner(" | ");
                    sj.add(developer.getId_developer().toString());
                    sj.add(developer.getDeveloper_name());
                    sj.add(developer.getSkill_name());
                    sj.add(developer.getSalary());
                    System.out.println(sj);

                }
                System.out.println();


            } else if (command.equals("dev_delete")) {
                System.out.print("Введите ID: ");
                long id_developer = sc.nextLong();
                Developer developer = genericDAO.deleteDeveloper(id_developer);
                System.out.println("Developer deleted");
            }
            if (command.equals("add_skill_dev")) {
                System.out.print("Введите ID разработчика: ");
                long id_developer = sc.nextLong();
                System.out.print("Введите ID скила: ");
                long id_skill = sc.nextLong();
                Developer developer = new Developer();
                developer.setId_developer(id_developer);
                developer.setId_skill(id_skill);
                try {
                    genericDAO.addSkill(developer);
                    System.out.println("Developer updated");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (command.equals("add_pro_dev")) {
                System.out.print("Введите ID проекта: ");
                long id_project = sc.nextLong();
                System.out.print("Введите ID разработчика: ");
                long id_developer = sc.nextLong();
                Project project = new Project();
                project.setId_project(id_project);
                project.setId_developer(id_developer);
                try {
                    genericDAO.addDev(project);
                    System.out.println("Project updated");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}