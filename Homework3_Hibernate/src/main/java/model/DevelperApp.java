package model;

import dao.DeveloperDAO;
import dao.SkillDAO;
import dao.hibernate.DeveloperDAOimpl;
import model.skill.Skill;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class DevelperApp {
    Scanner sc = new Scanner(System.in);

    public static void AddTask() {
        Scanner sc = new Scanner(System.in);
        out.println("Developers selected");
        System.out.println("Input action number: \n " +
                "1. Add new Dev \n " +
                "2. List all Dev \n " +
                "3. Delete Dev \n "  +
                "0. Go to the MainMenu");

        DeveloperDAO developerDAO = new DeveloperDAOimpl();

        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                out.print("Введите имя: ");
                String developer_name = sc.nextLine();
                System.out.print("Введите зарплату: ");
                String salary = sc.nextLine();
                Developer developer = new Developer();
                developer.setDeveloper_name(developer_name);
                developer.setSalary(salary);
                developerDAO.save(developer);
                out.println("Developer Added");
                out.println("===================================");


            }

            if (command.equals("2")) {
                List<Developer> developers = null;
                developers = developerDAO.getAll();

                for (Object developer : developers){
                    System.out.println(developer);
                }
                out.println("===================================");

            }

            if (command.equals("3")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Developer developer = new Developer();
                developer.setId(id);
                developerDAO.remove(id);
                out.println("Developer Remove");
                out.println("===================================");

            }



            if (command.equals("0")) {
                System.out.println("Choose your table: \n " +
                        "1. Skill \n " +
                        "2. Developer \n " +
                        "10. Exit");
                break;
            }


        }

    }

}
