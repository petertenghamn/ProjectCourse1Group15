package stud.hkr;
import java.text.SimpleDateFormat;
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
        logic.generateRooms();
      
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
                                    drawEditCustomerMenu(cE);

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

                                //print all customers names and other info in a straight line
                                for (int i = 0; i < customers.size(); i++){
                                    System.out.println("Customer ["  + customers.get(i).getName()  + "]: " + "Telephone Number: " + customers.get(i).getTelephoneNumber() + " Address: " + customers.get(i).getAddress() + " SSN: " + customers.get(i).getSsn());
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

                                //put in a loop to check if its answered correctly and take balcony input
                                boolean asking = true, balcony = false;
                                do {
                                    System.out.print("Does the room have a balcony (y/n): ");
                                    String answer = input.nextLine();

                                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
                                        balcony = true;
                                        asking = false;
                                    } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){
                                        asking = false;
                                    } else {
                                        System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                    }
                                } while (asking);
                                
                                logic.addRoom(nob, ppn, balcony, false);
                                break;
                            case 2:
                                // Edit|Remove subMenu
                                System.out.print("Enter the room number: ");
                                int eRoom = input.nextInt();

                                Room editRoom = logic.getRoom(eRoom);

                                if (editRoom != null){
                                    drawEditRoomMenu(editRoom);

                                    int eChoice = input.nextInt();
                                    int eRoomLoop = 0;

                                    while (eRoomLoop == 0) { // Loop to make sure the program waits for a correct answer
                                        switch (eChoice) {
                                            case 1: // Edit the Room
                                                eRoomLoop = 1;

                                                System.out.print("Enter the new number of Beds:");
                                                nob = input.nextInt();
                                                System.out.print("Enter the new Price per Night: ");
                                                ppn = input.nextInt();

                                                input.nextLine(); // Is here to fix bug DO NOT REMOVE!

                                                System.out.print("Does the room have a balcony (y/n): ");
                                                String answerBalcony = input.nextLine();

                                                boolean Ebalcony = false;
                                                int eRoomAskingA = 0;

                                                while (eRoomAskingA == 0) {
                                                    if (answerBalcony.equalsIgnoreCase("y") || answerBalcony.equalsIgnoreCase("yes")) {
                                                        Ebalcony = true;
                                                        eRoomAskingA = 1;
                                                    } else if (answerBalcony.equalsIgnoreCase("n") || answerBalcony.equalsIgnoreCase("no")) {
                                                        eRoomAskingA = 1;
                                                    } else {
                                                        System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                    }
                                                }

                                                int eRoomAskingB = 0; // Sets the value back to 0 so that the booking question can be sent
                                                System.out.print("Is the room Booked?");
                                                String eBooked = input.nextLine();

                                                boolean eRoomBook = false;

                                                while (eRoomAskingB == 0) {
                                                    if (eBooked.equalsIgnoreCase("y") || eBooked.equalsIgnoreCase("yes")) {
                                                        eRoomBook = true;
                                                        eRoomAskingB = 1;
                                                    } else if (eBooked.equalsIgnoreCase("n") || eBooked.equalsIgnoreCase("no")) {
                                                        eRoomAskingB = 1;
                                                    } else {
                                                        System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                    }
                                                }

                                                // Deletes the Room before adding it again
                                                logic.removeRoom(eRoom);

                                                logic.addRoom(nob, ppn, Ebalcony, eRoomBook);
                                                break;
                                            case 2: // Remove the Room
                                                eRoomLoop = 1;
                                                logic.removeRoom(eRoom);

                                                System.out.println("Room has been REMOVED!");
                                                System.out.println("Returning you to Manage Room Menu");
                                                break;
                                            default: // Mis input from the user
                                                System.out.println("That wasn't a choice. Either press 1 to EDIT the Room or 2 to REMOVE the Room");
                                        }
                                    }
                                }
                                else{
                                    System.out.println("That room doesn't exist!");
                                    System.out.println("Returning you to Manage Room menu");
                                }
                                break;
                            case 3:
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

                            case 4:
                                //view all rooms
                                for (Room r : logic.getRooms()) {
                                    System.out.printf("%s%s%s%s%n",
                                            "Room [" + r.getRoomNumber() + "]",
                                            ", Beds: " + r.getNumberOfBeds(),
                                            ", Has balcony: " + (r.getHasBalcony() ? "Yes" : "No"),
                                            ", Cost Per Night: " + r.getPricePerNight());
                                }
                                break;

                            case 5:
                                //view all available rooms
                                for (Room r : logic.getAvailableRooms()) {
                                    System.out.printf("%s%s%s%s%n",
                                            "Room [" + r.getRoomNumber() + "]",
                                            ", Beds: " + r.getNumberOfBeds(),
                                            ", Has balcony: " + (r.getHasBalcony() ? "Yes" : "No"),
                                            ", Cost Per Night: " + r.getPricePerNight());
                                }
                                break;

                            case 6:
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
                        input.nextLine();

                        boolean checking;
                        switch (subChoice) {
                            case 1:
                                //check in customer
                                checking = true;
                                do {
                                    //check if customer exists
                                    System.out.print("Please enter the customer's social security number: ");
                                    String ssn = input.nextLine();

                                    if (logic.getCustomer(ssn) != null) {
                                        //if customer exists then continue to next step
                                        ArrayList<Room> rooms = new ArrayList<>();
                                        ArrayList<Room> availableRooms = logic.getAvailableRooms();

                                        //prints all available rooms that have not already been chosen
                                        boolean picking = true;
                                        do {
                                            for (Room r : availableRooms) {
                                                boolean inBooking = false;
                                                for (Room r2 : rooms){
                                                    if (r.getRoomNumber() == r2.getRoomNumber()){
                                                        inBooking = true;
                                                    }
                                                }
                                                if (!inBooking){
                                                    System.out.printf("%s%s%s%s%n",
                                                            "Room [" + r.getRoomNumber() + "]",
                                                            ", Beds: " + r.getNumberOfBeds(),
                                                            ", Has balcony: " + (r.getHasBalcony() ? "Yes" : "No"),
                                                            ", Cost Per Night: " + r.getPricePerNight());
                                                }
                                            }
                                            System.out.printf("%n%s", "Please enter the room number you would like to book: ");
                                            int rn = input.nextInt();
                                            input.nextLine();

                                            //checks that the rn doesnt belong to a room already selected or that doesnt exist
                                            boolean roomAdded = false;
                                            for (Room r : availableRooms) {
                                                if (r.getRoomNumber() == rn) {
                                                    boolean inBooking = false;
                                                    for (Room r2 : rooms) {
                                                        if (r2.getRoomNumber() == rn) {
                                                            inBooking = true;
                                                        }
                                                    }
                                                    if (!inBooking) {
                                                        rooms.add(logic.getRoom(rn));
                                                        roomAdded = true;
                                                    }
                                                }
                                            }
                                            if (!roomAdded){
                                                System.out.println("Could not find room you selected!");
                                            }

                                            boolean asking = true;
                                            //two choices depending on if the room list is greater then 0
                                            if (rooms.size() > 0) {
                                                do {
                                                    System.out.print("Do you want to book another room? (y/n): ");
                                                    String answer = input.nextLine();

                                                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                        asking = false;
                                                    } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                        picking = false;
                                                        asking = false;
                                                    } else {
                                                        System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                    }
                                                } while (asking);
                                            }
                                            //if there are no rooms booked ask if they wish to cancel
                                            else {
                                                do {
                                                    System.out.print("Do you want to cancel your booking? (y/n): ");
                                                    String answer = input.nextLine();

                                                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                        picking = false;
                                                        asking = false;
                                                    } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                        asking = false;
                                                    } else {
                                                        System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                    }
                                                } while (asking);
                                            }
                                        } while (picking);

                                        //creates booking if there are rooms to book, otherwise unnecessary
                                        if (rooms.size() > 0) {
                                            //create a new booking for the customer
                                            Booking b = new Booking(1, rooms, new Date(), new Date());

                                            //complete the process
                                            logic.checkInCustomer(ssn, b);
                                        }
                                        checking = false;
                                    }
                                } while (checking);
                                break;

                            case 2:
                                //check out customer
                                checking = true;
                                do {
                                    //check if customer exists
                                    System.out.print("Please enter the customer's social security number: ");
                                    String ssn = input.nextLine();

                                    if (logic.getCustomer(ssn) != null) {
                                        //complete the process
                                        Booking b = logic.getCustomer(ssn).getBooking();
                                        logic.checkOutCustomer(ssn, b);
                                        checking = false;
                                    }
                                } while (checking);
                                break;

                            case 3:
                                //view booking
                                System.out.print("Please enter the customer's social security number: ");
                                String ssn = input.nextLine();

                                Booking b = logic.ViewBooking(ssn);
                                if (b != null){
                                    SimpleDateFormat strDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                                    System.out.printf("%s%n%s%n%s%n",
                                            "Booking number: [" + b.getBookingId() + "]",
                                            "Check-in date: [" + strDateFormat.format(b.getCheckInDate()) + "]",
                                            "Booking price: [" + b.getTotalPrice() + "]");
                                } else {
                                    System.out.println("Customer does not have a booking!");
                                }
                                break;

                            case 4:
                                //change booking
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
    // Sub Menu of Customer Menu
    private void drawEditCustomerMenu(Customer cE){
        System.out.println("___________________________________");
        System.out.println("|                                 |");
        System.out.println("|  Name: " + cE.getName());
        System.out.println("|  Address: " + cE.getAddress());
        System.out.println("|  Telephone: " + cE.getTelephoneNumber());
        System.out.println("|                                 |");
        System.out.println("|  1.) Edit Customer              |");
        System.out.println("|  2.) Remove Customer            |");
        System.out.println("-----------------------------------");
    }

    private void drawRoomMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Room options                  |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Add room                   |");
        System.out.println("|  2.) Edit / Remove Room         |");
        System.out.println("|  3.) View Specific room         |");
        System.out.println("|  4.) View all rooms             |");
        System.out.println("|  5.) View available rooms       |");
        System.out.println("|  6.) Return                     |");
        System.out.println("-----------------------------------");
    }
    // Sub Menu of Room Menu
    private void drawEditRoomMenu(Room eRoom){
        System.out.println("___________________________________");
        System.out.println("|                                 |");
        System.out.println("|  Room Number: " + eRoom.getRoomNumber());
        System.out.println("|  Number of Beds: " + eRoom.getNumberOfBeds());
        System.out.println("|  Has Balcony: " + eRoom.getHasBalcony());
        System.out.println("|  Cost per Night: " + eRoom.getPricePerNight());  // No formatting on the double might need to change later
        System.out.println("|                                 |");
        System.out.println("|  1.) Edit Room                  |");
        System.out.println("|  2.) Remove Room                |");
        System.out.println("-----------------------------------");
    }

    private void drawCheckInOutMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Booking options               |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Check In customer          |");
        System.out.println("|  2.) Check Out customer         |");
        System.out.println("|  3.) View booking               |");
        System.out.println("|  4.) Change booking             |");
        System.out.println("|  5.) Return                     |");
        System.out.println("-----------------------------------");
    }
}
