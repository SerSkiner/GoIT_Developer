import model.HibernateApp;
import model.DevelperApp;

import java.util.Scanner;
import static java.lang.System.out;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.println("Welcome to Hibernate App.For Avalible command see help");
        System.out.println("Choose your table: \n " +
                "1. Skill \n " +
                "2. Developer \n " +
                "10. Exit");

        //HibernateApp hibernateApp = new HibernateApp();


        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                HibernateApp.AddTask();
            }

            if (command.equals("2")) {
                DevelperApp.AddTask();
            }

            if (command.equals("10")) {
                System.exit(0);
            }
        }
    }
}