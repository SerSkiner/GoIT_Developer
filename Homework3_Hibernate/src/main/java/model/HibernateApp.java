package model;

import dao.GenericDAO;
import dao.SkillDAO;
import dao.hibernate.Storage;
import model.Skill;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class HibernateApp {
    Scanner sc = new Scanner(System.in);

    public static void AddTask() {
        Scanner sc = new Scanner(System.in);
        out.println("Skills selected");

        SkillDAO skillDAO = new Storage();

        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                out.print("Введите имя: ");
                String skill_name = sc.nextLine();
                Skill skill = new Skill();
                skill.setSkill_name(skill_name);
                skillDAO.save(skill);
                out.println("Skill Added");
                out.println("===================================");


            }

            if (command.equals("2")) {
                List<Skill> skills = null;
                skills = skillDAO.getAll();

                for (Object skill : skills){
                    System.out.println(skill);
                }
                out.println("===================================");

            }

            if (command.equals("10")) {
                System.out.println("Select new task");
                break;
            }


            }

        }

    }




