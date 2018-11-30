package stud.hkr;
import java.util.ArrayList;
import java.util.Date;
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
            input.nextLine();

            boolean subMenu = true;
            int subChoice;
            switch (choice) {
                case 1:
                    //Draw a sub menu to specify what the user wants to do
                    do {
                        drawCustomerMenu();

                        System.out.print("\nSelect Action: ");
                        subChoice = input.nextInt();
                        input.nextLine();

                        switch (subChoice){
                            case 1:
                                //add a customer
                                System.out.print("Please enter the customers social security number: ");
                                String id = input.nextLine(); //this input needs to be checked to make sure its a unique key later

                                System.out.print("Please enter the customers name: ");
                                String name = input.nextLine();

                                System.out.print("Please enter the customers address: ");
                                String address = input.nextLine();

                                System.out.print("Please enter the customers telephone number: ");
                                String tele = input.nextLine();

                                boolean exists = logic.addCustomer(id, name, address, tele);
                                if (exists) {
                                    System.out.println("Customer already exists!");
                                }
                                break;

                            case 2:
                                System.out.print("Please enter the customers SSN number:");
                                String cEdit = input.nextLine();

                                Customer cE = logic.getCustomer(cEdit);

                                if (cE != null){
                                    System.out.println("___________________________________");
                                    System.out.println("|                                 |");
                                    System.out.println("|  Name: " + cE.getName());
                                    System.out.println("|  Address: " + cE.getAddress());
                                    System.out.println("|  Telephone: " + cE.getTelephoneNumber());
                                    System.out.println("|                                 |");
                                    System.out.println("|  1.) Edit Customer              |");
                                    System.out.println("|  2.) Remove Customer            |");
                                    System.out.println("-----------------------------------");

                                    int editSub = input.nextInt();
                                    int editSubMan = 0;

                                    // This loop is so that if the user inputs something other than 1 or 2 they don't have to start all over
                                    while (editSubMan == 0) {
                                        switch (editSub) {
                                            case 1: // This checks to see if the user wants to edit the customer
                                                editSubMan = 1;

                                                input.nextLine(); // Fixes a  bug DO NOT DELETE
                                                // It currently runs through all the customers info change later into a submenu switch to change individual things
                                                System.out.print("Enter the customers new SSN: ");
                                                id = input.nextLine();
                                                System.out.print("Enter the customers new name: ");
                                                name = input.nextLine();
                                                System.out.print("Enter the customers new address: ");
                                                address = input.nextLine();
                                                System.out.print("Please enter the customers new telephone number: ");
                                                tele = input.nextLine();
                                                System.out.println();

                                                logic.removeCustomer(cEdit); // Currently deletes the customer and makes it again
                                                logic.addCustomer(id, name, address, tele);

                                                System.out.println("The Customer has been updated!");
                                                System.out.println("Returning you to customer manage menu");

                                                break;
                                            case 2:
                                                editSubMan =1;

                                                logic.removeCustomer(cEdit);

                                                System.out.println("Costumer has been deleted!");
                                                System.out.println("Returning you to customer manage menu");
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Sorry that SSN is not registered to any customer");
                                    System.out.println("Returning you to the customer manage menu");
                                }
                                break;

                            case 3:
                                //view all customers
                                ArrayList<Customer> customers = logic.getCustomers();

                                //print all customers names?
                                for (int i = 0; i < customers.size(); i++){
                                    System.out.println("Customer [" + (i + 1) + "]: " + customers.get(i).getName());
                                }
                                break;

                            case 4:
                                //view specific customer
                                System.out.print("Please enter the social security number of the customer: ");
                                String cSsn = input.nextLine();

                                Customer c = logic.getCustomer(cSsn);

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

                            case 5:
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
                        input.nextLine();

                        switch (subChoice) {
                            case 1:
                                //add room
                                System.out.print("Please enter the number of beds in the room: ");
                                int nob = input.nextInt();
                                input.nextLine();

                                System.out.print("Please enter the price per night of the room: ");
                                double ppn = input.nextDouble();
                                input.nextLine();

                                //ask if the room has a balcony or not (for now just no)
                                
                                logic.addRoom(nob, ppn, false, false);
                                break;

                            case 2:
                                //view requested room
                                System.out.print("Please enter the room number: ");
                                int rNbr = input.nextInt();
                                input.nextLine();

                                Room room = logic.getRoom(rNbr);

                                if (room != null){
                                    System.out.println("---Room information---");
                                    System.out.println("Number of beds: " + room.getNumberOfBeds());
                                    System.out.println("Has balcony: " + (room.getHasBalcony() ? "Yes" : "No"));
                                    System.out.println("Cost per night: " + room.getPricePerNight());
                                    System.out.println("Available: " + (!room.isBooked() ? "Yes" : "No"));
                                }
                                else {
                                    System.out.println("Room could not be found!");
                                }
                                break;

                            case 3:
                                //view all rooms
                                ArrayList<Room> rooms = logic.getRooms();

                                //print all rooms
                                for (Room r : rooms) {
                                    System.out.printf("%s%s%s%s%n",
                                            "Room [" + r.getRoomNumber() + "]",
                                            ", Beds: " + r.getNumberOfBeds(),
                                            ", Has balcony: " + (r.getHasBalcony() ? "Yes" : "No"),
                                            ", Cost Per Night: " + r.getPricePerNight());
                                }
                                break;

                            case 4:
                                //view all available rooms
                                ArrayList<Room> aRooms = logic.getAvailableRooms();

                                //print all rooms
                                for (Room r : aRooms) {
                                    System.out.printf("%s%s%s%s%n",
                                            "Room [" + r.getRoomNumber() + "]",
                                            ", Beds: " + r.getNumberOfBeds(),
                                            ", Has balcony: " + (r.getHasBalcony() ? "Yes" : "No"),
                                            ", Cost Per Night: " + r.getPricePerNight());
                                }
                                break;

                            case 5:
                                //return to main menu
                                System.out.println("Returning you to main menu");
                                subMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice.\nPlease enter a valid choice between 1-5");
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
                                //check in customer
                                boolean checking = true, processing = true;
                                do {
                                    if (processing) { //work in progress, doesn't work right now <-------------------------------------------------------------------
                                        System.out.print("Please enter the customers social security number: ");
                                        String ssn = input.nextLine();
                                        //check to see if the ssn matches a customer in the system


                                        //if customer exists then continue to next step
                                        ArrayList<Room> rooms = new ArrayList<>();

                                        //create a new booking for the customer
                                        Booking b = new Booking(rooms, new Date(), new Date());

                                        //complete the process
                                        logic.checkInCustomer(ssn, b);
                                        checking = false;
                                    }
                                } while (checking);
                                break;

                            case 2:
                                //check out customer
                                break;

                            case 3:
                                //change booking
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
        System.out.println("|  2.) Edit / Remove customer     |");
        System.out.println("|  3.) View all customers         |");
        System.out.println("|  4.) View specific customer     |");
        System.out.println("|  5.) Return                     |");
        System.out.println("-----------------------------------");
    }

    private void drawRoomMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Room options                  |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Add room                   |");
        System.out.println("|  2.) View Specific room         |");
        System.out.println("|  3.) View all rooms             |");
        System.out.println("|  4.) View available rooms       |");
        System.out.println("|  5.) Return                     |");
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
