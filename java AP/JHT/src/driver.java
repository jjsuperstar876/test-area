import java.io.IOException;
import java.util.Scanner;

public class driver {

    public static void main(String[] args) throws IOException {
        Staff staff = new Staff();
        Customer custom = new Customer();
        Order order = new Order();
        Salaries salary = new Salaries();
        Scanner in = new Scanner(System.in);

        String user, pass;
        int access, tries = 0;

        staff.addStaff(in, 1);

        System.out.println("Hello Welcome please enter \n 1 if you are a Staff \n 2 if you are ...");
        access = in.nextInt();

        if (access == 1) {
            System.out.println("Please enter your username");
            user = in.nextLine();// system ignoring this into be resolved
            user = in.nextLine();
            System.out.println("Please enter your password");
            pass = in.nextLine();

            access = staff.login(user, pass);

            while (access != 2) {
                tries++;
                if (tries == 3) {
                    System.out.println("You have exceeded the amount of attempts try again later");
                    break;
                }
                System.out.println("Incorrect Credientials Please try again");
                user = in.nextLine();
                pass = in.nextLine();

                access = staff.login(user, pass);
            }

            if (access == 2) {
                while (access!=7) 
                {
                    System.out.println("Welcome " + user + " Please select what you would like to do from the list below");
                    System.out.println(
                            "1 - add New Staff \n2-add a New Customer \n3-View all Customers \n4-add a New Order \n5-View All Orders \n6 - View Salaries \n7 -End");
                    access = in.nextInt();

                    switch (access) {
                        case 1:
                            staff.addStaff(in, 2);
                            break;
                        case 2:
                            custom.custFile(in);
                            break;
                        case 3:
                            // custom.viewAll();//add it
                            break;
                        case 4:
                            order.addOrder(in);
                            break;
                        case 5:
                            order.allOrders();
                            break;
                        case 6:
                            salary.salary(in);
                            break;
                    }
                        
                } 

            }

        }

        in.close();

    }

}
