package model.project;

import dao.ProjectDAO;
import dao.hibernate.ProjectDAOImpl;

import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class ProjectApp {
    Scanner sc = new Scanner(System.in);

    public static void AddTask() {
        Scanner sc = new Scanner(System.in);
        out.println("Projects selected");
        System.out.println("Input action number: \n " +
                "1. Add new Dev \n " +
                "2. List all Dev \n " +
                "3. Delete Dev \n " +
                "0. Go to the MainMenu");

        ProjectDAO projectDAO = new ProjectDAOImpl();

        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                out.print("Введите имя: ");
                String project_name = sc.nextLine();
                System.out.print("Введите ID разработчика: ");
                Long developer_id = sc.nextLong();
                Project project = new Project();
                project.setProject_name(project_name);
                project.setDeveloper_id(developer_id);
                projectDAO.save(project);
                out.println("Project Added");
                out.println("===================================");


            }

            if (command.equals("2")) {
                List<Project> projects = null;
                projects = projectDAO.getAll();

                for (Object project : projects) {
                    System.out.println(project);
                }
                out.println("===================================");

            }

            if (command.equals("3")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Project project = new Project();
                project.setId(id);
                projectDAO.remove(id);
                out.println("Project Remove");
                out.println("===================================");

            }


            if (command.equals("0")) {
                System.out.println("Choose your table: \n " +
                        "1. Skill \n " +
                        "2. Developer \n " +
                        "3. Project \n " +
                        "10. Exit");
                break;
            }


        }
    }
}