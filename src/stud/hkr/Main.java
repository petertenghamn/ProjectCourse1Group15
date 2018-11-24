package stud.hkr;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main hotelApp = new Main();
        hotelApp.runProgram();
    }

    private void runProgram() {
        boolean running = true;
        HotelLogic logic = new HotelLogic();
      
        do {
            drawMenu();
            
            System.out.print("\nSelect Action: ");
            int choice = input.nextInt();

            boolean subMenu = true;
            int subChoice;
            switch (choice) {
                case 1:
                    //Draw a sub menu to specify what the user wants to do
                    do {
                        drawCustomerMenu();

                        System.out.print("\nSelect Action: ");
                        subChoice = input.nextInt();

                        switch (subChoice){
                            case 1:
                                //add a customer
                                System.out.println("Please enter the customers social security number: ");
                                String id = input.nextLine(); //this input needs to be checked to make sure its a unique key later

                                System.out.println("Please enter the customers name: ");
                                String name = input.nextLine();

                                System.out.println("Please enter the customers address");
                                String address = input.nextLine();

                                System.out.println("Please enter the customers telephone number: ");
                                String tele = input.nextLine();

                                logic.addCustomer(id, name, address, tele);
                                break;
                            case 2:
                                //view all customers
                                ArrayList<Customer> customers = logic.getCustomers();

                                //print all customers names?
                                for (int i = 0; i < customers.size(); i++){
                                    System.out.println("Customer [" + (i + 1) + "]: " + customers.get(i).getName());
                                }
                                break;
                            case 3:
                                //view specific customer
                                System.out.println("Please enter the name of the customer: ");
                                String cName = input.nextLine();

                                Customer c = logic.getCustomer(cName);

                                if (c != null){
                                    System.out.println("---Customer information---");
                                    System.out.println("Name: " + c.getName());
                                    System.out.println("Address: " + c.getAddress());
                                    System.out.println("Telephone Number: " + c.getTelephoneNumber());
                                }
                                else {
                                    System.out.println("Customer could not be found!");
                                }
                                break;
                            case 4:
                                //return to main menu
                                System.out.println("Returning you to main menu");
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                                break;
                        }
                    } while (subMenu);
                    break;

                case 2:
                    //Draw a sub menu to specify what the user wants to do
                    do {
                        drawRoomMenu();

                        System.out.print("\nSelect Action: ");
                        subChoice = input.nextInt();

                        switch (subChoice) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:
                                //return to main menu
                                System.out.println("Returning you to main menu");
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                                break;
                        }
                    } while (subMenu);
                    break;

                case 3:
                    //Draw a sub menu to specify what the user wants to do
                    do {
                        drawCheckInOutMenu();

                        System.out.print("\nSelect Action: ");
                        subChoice = input.nextInt();

                        switch (subChoice) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:
                                //return to main menu
                                System.out.println("Returning you to main menu");
                                subMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                                break;
                        }
                    } while (subMenu);
                    break;

                case 4:
                    //exit the program (for now this gets rid of all information stored as well)
                    System.out.println("Program is shutting down");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                    break;
            }
        } while (running);
    }

    private void drawMenu() {

        System.out.println("___________________________________");
        System.out.println("|   Welcome Dear Employee         |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Manage Customers           |");
        System.out.println("|  2.) Manage Rooms               |");
        System.out.println("|  3.) Manage Bookings            |");
        System.out.println("|  4.) Exit                       |");
        System.out.println("-----------------------------------");
    }

    //sub menu for certain options
    private void drawCustomerMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Customer options              |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Add customer               |");
        System.out.println("|  2.) View all customers         |");
        System.out.println("|  3.) View specific customer     |");
        System.out.println("|  4.) Return                     |");
        System.out.println("-----------------------------------");
    }

    private void drawRoomMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Room options                  |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Add room                   |");
        System.out.println("|  2.) View all rooms             |");
        System.out.println("|  3.) View available rooms       |");
        System.out.println("|  4.) Return                     |");
        System.out.println("-----------------------------------");
    }

    private void drawCheckInOutMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Room options                  |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Check In customer          |");
        System.out.println("|  2.) Check Out customer         |");
        System.out.println("|  3.) Change booking             |");
        System.out.println("|  4.) Return                     |");
        System.out.println("-----------------------------------");
    }
}
