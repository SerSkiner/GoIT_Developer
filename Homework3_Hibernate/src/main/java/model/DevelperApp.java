package model;

import dao.DeveloperDAO;
import dao.SkillDAO;
import dao.hibernate.DeveloperDAOimpl;
import dao.hibernate.Storage;

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
                "3 Delete Dev \n "  +
                "0. Go to the MainMenu");

        DeveloperDAO developerDAO = new DeveloperDAOimpl();

        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                out.print("Введите имя: ");
                String skill_name = sc.nextLine();
                Skill skill = new Skill();
                skill.setSkill_name(skill_name);
                //skillDAO.save(skill);
                out.println("Skill Added");
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

            if (command.equals("0")) {
                System.out.println("Choose your table: \n " +
                        "1. Skill \n " +
                        "10. Exit");
                break;
            }


        }

    }

}
