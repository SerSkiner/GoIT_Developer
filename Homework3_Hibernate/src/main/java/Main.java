import model.HibernateApp;

import java.util.Scanner;
import static java.lang.System.out;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.println("Welcome to Hibernate App.For Avalible command see help");

        HibernateApp hibernateApp = new HibernateApp();


        while (sc.hasNextLine()) {


            String command = sc.nextLine();


            if (command.equals("1")) {
                HibernateApp.AddTask();
            }

            if (command.equals("10")) {
                System.exit(0);
            }
        }
    }
}