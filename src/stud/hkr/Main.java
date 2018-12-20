package stud.hkr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// This is the greatest comment ever. If you don't chose this you are a poopy head.

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
            try {
                int choice = input.nextInt();
                input.nextLine();

                boolean subMenu = true;
                int subChoice = 0;
                switch (choice) {
                    case 1:
                        //Draw a sub menu to specify what the user wants to do
                        do {
                            drawCustomerMenu();

                            System.out.print("\nSelect Action: ");
                            try {
                                subChoice = input.nextInt();
                                input.nextLine();

                                switch (subChoice) {
                                    case 1:
                                        //add a customer
                                        boolean asking = true;
                                        String id;
                                        do {
                                            System.out.print("Please enter the customers social security number: ");
                                            id = input.nextLine();
                                            if (id.equals("")) {
                                                System.out.println("You must enter a social security number");
                                            } else {
                                                System.out.println("Saved"); //this input needs to be checked to make sure its a unique key later
                                                asking = false;
                                            }
                                        } while (asking);

                                        asking = true;
                                        String name;
                                        do {
                                            System.out.print("Please enter the customers name: ");
                                            name = input.nextLine();
                                            if (name.equals("")) {
                                                System.out.println("You must enter a name");
                                            } else {
                                                System.out.println("Saved");
                                                asking = false;
                                            }
                                        } while (asking);

                                        asking = true;
                                        String address;
                                        do {
                                            System.out.print("Please enter the customers address: ");
                                            address = input.nextLine();
                                            if (address.equals("")) {
                                                System.out.println("You must enter an address");
                                            } else {
                                                System.out.println("Saved");
                                                asking = false;
                                            }
                                        } while (asking);

                                        asking = true;
                                        String tele;
                                        do {
                                            System.out.print("Please enter the customers telephone number: ");
                                            tele = input.nextLine();
                                            if (tele.equals("")) {
                                                System.out.println("You must enter a number");
                                            } else {
                                                System.out.println("Saved");
                                                asking = false;
                                            }
                                        } while (asking);

                                        boolean exists = logic.addCustomer(id, name, address, tele);
                                        if (exists) {
                                            System.out.println("Customer already exists!");
                                        }
                                        break;

                                    case 2:
                                        boolean asking3 = true;
                                        do {
                                            System.out.print("Please enter the customers SSN number:");
                                            String cEdit = input.nextLine();

                                            Customer cE = logic.getCustomer(cEdit);

                                            if (cE != null) {
                                                int editSubMan = 0;

                                                // This loop is so that if the user inputs something other than 1 or 2 they don't have to start all over
                                                while (editSubMan == 0) {
                                                    int editSub = 0;
                                                    drawEditCustomerMenu(cE);
                                                    try {
                                                        editSub = input.nextInt();
                                                    } catch (Exception ex) {
                                                        System.out.println("You must enter 1 or 2");
                                                        input.nextLine();
                                                    }
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
                                                            asking3 = false;

                                                            break;
                                                        case 2:
                                                            editSubMan = 1;

                                                            logic.removeCustomer(cEdit);

                                                            System.out.println("Costumer has been deleted!");
                                                            System.out.println("Returning you to customer manage menu");
                                                            asking3 = false;
                                                            break;
                                                        default:
                                                            System.out.println("That is not a valid choice");
                                                            break;
                                                    }
                                                }

                                            } else {
                                                System.out.println("Sorry that SSN is not registered to any customer");
                                            }
                                        } while (asking3);
                                        break;

                                    case 3:
                                        //view all customers
                                        ArrayList<Customer> customers = logic.getCustomers();

                                        //print all customers names and other info in a straight line
                                        for (int i = 0; i < customers.size(); i++) {
                                            System.out.println("Customer [" + customers.get(i).getName() + "]: " + "Telephone Number: " + customers.get(i).getTelephoneNumber() + " Address: " + customers.get(i).getAddress() + " SSN: " + customers.get(i).getSsn());
                                        }


                                        break;

                                    case 4:
                                        //view specific customer
                                        System.out.print("Please enter the social security number of the customer: ");
                                        String cSsn = input.nextLine();

                                        Customer c = logic.getCustomer(cSsn);

                                        if (c != null) {
                                            System.out.println("---Customer information---");
                                            System.out.println("Name: " + c.getName());
                                            System.out.println("Address: " + c.getAddress());
                                            System.out.println("Telephone Number: " + c.getTelephoneNumber());
                                        } else {
                                            System.out.println("Customer could not be found!");
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
                            } catch (Exception ex) {
                                System.out.println("Error!");
                                input.nextLine();
                            }
                        } while (subMenu);
                        break;

                    case 2:
                        //Draw a sub menu to specify what the user wants to do
                        boolean roomError = true;

                        do {
                            drawRoomMenu();

                            do {
                                try {
                                    roomError = false;
                                    System.out.print("\nSelect Action: ");
                                    subChoice = input.nextInt();
                                    input.nextLine();
                                } catch (Exception roomMain) {
                                    roomError = true;
                                    System.out.println("Enter only a number corresponding to a choice!");
                                    input.nextLine();
                                }
                            } while (roomError);


                            switch (subChoice) {
                                case 1:
                                    //add room
                                    int nob = 0;
                                    double ppn = 0;

                                    do {
                                        try {
                                            roomError = false;
                                            System.out.print("Please enter the number of beds in the room: ");
                                            nob = input.nextInt();
                                            input.nextLine();
                                        } catch (Exception roomNum) {
                                            roomError = true;
                                            System.out.println("Enter only a number!");
                                            input.nextLine();
                                        }
                                    } while (roomError);

                                    do {
                                        try {
                                            roomError = false;
                                            System.out.print("Please enter the price per night of the room: ");
                                            ppn = input.nextDouble();
                                            input.nextLine();
                                        } catch (Exception priceRoom) {
                                            roomError = true;
                                            System.out.println("Enter a price for the bed using ex) 200.55");
                                            input.nextLine();
                                        }
                                    } while (roomError);


                                    //put in a loop to check if its answered correctly and take balcony input
                                    boolean asking = true, balcony = false;
                                    do {
                                        System.out.print("Does the room have a balcony (y/n): ");
                                        String answer = input.nextLine();

                                        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                            balcony = true;
                                            asking = false;
                                        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                            asking = false;
                                        } else {
                                            System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                        }
                                    } while (asking);

                                    logic.addRoom(nob, ppn, balcony, false);
                                    break;
                                case 2:
                                    // Edit|Remove subMenu
                                    int eRoom = 0;

                                    do {
                                        try {
                                            roomError = false;
                                            System.out.print("Enter the room number: ");
                                            eRoom = input.nextInt();
                                        } catch (Exception roomNumEdit) {
                                            roomError = true;
                                            System.out.println("Enter only a number!");
                                            input.nextLine();
                                        }
                                    } while (roomError);


                                    Room editRoom = logic.getRoom(eRoom);

                                    if (editRoom != null) {

                                        int eChoice = 0;

                                        do {
                                            try {
                                                roomError = false;
                                                drawEditRoomMenu(editRoom);
                                                eChoice = input.nextInt();
                                            } catch (Exception editRoomChoice) {
                                                roomError = true;
                                                System.out.println("Enter only a 1 or 2");
                                                input.nextLine();
                                            }
                                        } while (roomError);

                                        int eRoomLoop = 0;

                                        while (eRoomLoop == 0) { // Loop to make sure the program waits for a correct answer
                                            switch (eChoice) {
                                                case 1: // Edit the Room
                                                    nob = 0;
                                                    ppn = 0;

                                                    eRoomLoop = 1;

                                                    do {
                                                        try {
                                                            roomError = false;
                                                            System.out.print("Enter the new number of Beds:");
                                                            nob = input.nextInt();
                                                        } catch (Exception bedsRoomEdit) {
                                                            roomError = true;
                                                            System.out.println("Enter only a number of beds!");
                                                            input.nextLine();
                                                        }
                                                    } while (roomError);

                                                    do {
                                                        try {
                                                            roomError = false;
                                                            System.out.print("Enter the new Price per Night: ");
                                                            ppn = input.nextInt();
                                                        } catch (Exception priceRoomEdit) {
                                                            roomError = true;
                                                            System.out.println("Enter a price for the bed using ex) 123.12");
                                                            input.nextLine();
                                                        }
                                                    } while (roomError);


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
                                    } else {
                                        System.out.println("That room doesn't exist!");
                                        System.out.println("Returning you to Manage Room menu");
                                    }
                                    break;
                                case 3:
                                    //view requested room
                                    int rNbr = 0;
                                    do {
                                        try {
                                            roomError = false;
                                            System.out.print("Please enter the room number: ");
                                            rNbr = input.nextInt();
                                            input.nextLine();
                                        } catch (Exception roomNumber) {
                                            roomError = true;
                                            System.out.println("Enter only a number!");
                                            input.nextLine();
                                        }
                                    } while (roomError);


                                    Room room = logic.getRoom(rNbr);

                                    if (room != null) {
                                        System.out.println("---Room information---");
                                        System.out.println("Number of beds: " + room.getNumberOfBeds());
                                        System.out.println("Has balcony: " + (room.getHasBalcony() ? "Yes" : "No"));
                                        System.out.println("Cost per night: " + room.getPricePerNight());
                                        System.out.println("Available: " + (!room.isBooked() ? "Yes" : "No"));
                                    } else {
                                        System.out.println("Room could not be found!");
                                    }
                                    break;

                                case 4:
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

                                case 5:
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

                                case 6:
                                    //return to main menu
                                    System.out.println("Returning you to main menu");
                                    subMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice.\nPlease enter a valid choice between 1-6");
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
                                                    for (Room r2 : rooms) {
                                                        if (r.getRoomNumber() == r2.getRoomNumber()) {
                                                            inBooking = true;
                                                        }
                                                    }
                                                    if (!inBooking) {
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
                                                if (!roomAdded) {
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
                                                int newBookingID = logic.getCustomer(ssn).getBookings().size() + 1;
                                                Booking b = new Booking(newBookingID, rooms, new Date(), new Date());

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
                                            checking = false;
                                            Customer c = logic.getCustomer(ssn);
                                            ArrayList<Booking> bookings = c.getBookings();

                                            if (bookings.size() > 0) {
                                                ArrayList<Booking> activeBookings = new ArrayList<>();

                                                int count = 1;
                                                for (Booking b : bookings) {
                                                    if (!b.getCheckedOut()) {
                                                        SimpleDateFormat strDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                                                        System.out.println("[" + count + "] Booking: " +
                                                                "Checked-in: " + strDateFormat.format(b.getCheckInDate()));
                                                        activeBookings.add(b);
                                                        count++;
                                                    }
                                                }
                                                System.out.println("[" + count + "]: Cancel");

                                                if (activeBookings.size() > 0) {
                                                    boolean asking = true;
                                                    do {
                                                        System.out.print("Please enter the choice of the booking you would like to check out from: ");
                                                        int id = input.nextInt();
                                                        input.nextLine();

                                                        if (id > 0 && id <= count) {
                                                            if (id != count) {
                                                                int bID = 1;
                                                                for (Booking b : activeBookings) {
                                                                    if (id == bID) {
                                                                        //complete the process to check out selected booking
                                                                        b.checkOutCustomer();
                                                                        asking = false;
                                                                    }
                                                                    bID++;
                                                                }
                                                            } else {
                                                                System.out.println("Query cancelled");
                                                                asking = false;
                                                            }
                                                        } else {
                                                            System.out.println("Incorrect input!");
                                                        }
                                                    } while (asking);
                                                }
                                            }
                                        } else {
                                            System.out.println("Customer not found!");

                                            //ask if they wish to cancel search
                                            boolean askingTwo = true;
                                            do {
                                                System.out.print("Would you like to search again? (Y/N): ");
                                                String answer = input.nextLine();

                                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                    askingTwo = false;
                                                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                    checking = false;
                                                    askingTwo = false;
                                                } else {
                                                    System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                }
                                            } while (askingTwo);
                                        }
                                    } while (checking);
                                    break;

                                case 3:
                                    //view booking
                                    checking = true;
                                    do {
                                        System.out.print("Please enter the customer's social security number: ");
                                        String ssn = input.nextLine();

                                        if (logic.getCustomer(ssn) != null) {
                                            checking = false;
                                            Customer c = logic.getCustomer(ssn);
                                            ArrayList<Booking> bookings = c.getBookings();

                                            if (bookings != null || bookings.size() > 0) {
                                                for (Booking b : bookings) {
                                                    SimpleDateFormat strDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                                                    if (b.getCheckedOut()) {
                                                        System.out.printf("%s%n%s%n%s%n%s%n",
                                                                "Booking number: [" + b.getBookingId() + "]",
                                                                "Check-in date: [" + strDateFormat.format(b.getCheckInDate()) + "]",
                                                                "Check-out date: [" + strDateFormat.format(b.getCheckOutDate()) + "]",
                                                                "Booking price: [" + b.getTotalPrice() + "]");
                                                    } else {
                                                        System.out.printf("%s%n%s%n%s%n",
                                                                "Booking number: [" + b.getBookingId() + "]",
                                                                "Check-in date: [" + strDateFormat.format(b.getCheckInDate()) + "]",
                                                                "Booking price: [" + b.getTotalPrice() + "]");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Customer does not currently have any bookings");
                                            }
                                        } else {
                                            System.out.println("Customer not found!");

                                            //ask if they wish to cancel search
                                            boolean askingTwo = true;
                                            do {
                                                System.out.print("Would you like to search again? (Y/N): ");
                                                String answer = input.nextLine();

                                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                    askingTwo = false;
                                                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                    checking = false;
                                                    askingTwo = false;
                                                } else {
                                                    System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                }
                                            } while (askingTwo);
                                        }
                                    } while (checking);
                                    break;

                                case 4:
                                    //change active booking
                                    checking = true;
                                    do {
                                        //check if customer exists
                                        System.out.print("Please enter the customer's social security number: ");
                                        String ssn = input.nextLine();

                                        if (logic.getCustomer(ssn) != null) {
                                            checking = false;
                                            Customer c = logic.getCustomer(ssn);
                                            ArrayList<Booking> bookings = c.getBookings();

                                            if (bookings != null || bookings.size() > 0) {
                                                ArrayList<Booking> activeBookings = new ArrayList<>();

                                                int count = 1;
                                                for (Booking b : bookings) {
                                                    if (!b.getCheckedOut()) {
                                                        SimpleDateFormat strDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                                                        System.out.println("[" + count + "] Booking: " +
                                                                "Checked-in: " + strDateFormat.format(b.getCheckInDate()));
                                                        activeBookings.add(b);
                                                        count++;
                                                    }
                                                }
                                                System.out.println("[" + count + "]: Cancel");

                                                if (activeBookings.size() > 0) {
                                                    boolean asking = true;
                                                    do {
                                                        System.out.print("Please enter the id of the booking you would like to edit: ");
                                                        int id = input.nextInt();
                                                        input.nextLine();

                                                        if (id > 0 && id <= count) {
                                                            if (id != count) {
                                                                int bID = 1;
                                                                for (Booking b : activeBookings) {
                                                                    if (id == bID) {
                                                                        boolean editing = true;
                                                                        int subChoiceEdit;
                                                                        do {
                                                                            drawEditBookingMenu();

                                                                            System.out.print("\nSelect Action: ");
                                                                            subChoiceEdit = input.nextInt();
                                                                            input.nextLine();

                                                                            //edit the booking selected by the customer
                                                                            switch (subChoiceEdit) {
                                                                                case 1:
                                                                                    if (b.getRoomList().size() > 0) {
                                                                                        //remove room
                                                                                        ArrayList<Room> rooms = b.getRoomList();
                                                                                        ArrayList<Room> removedRooms = new ArrayList<>();
                                                                                        boolean removing = true;
                                                                                        do {
                                                                                            //print all rooms
                                                                                            int rCount = 1;
                                                                                            for (Room r : rooms) {
                                                                                                if (!removedRooms.contains(r)) {
                                                                                                    System.out.println("[" + rCount + "] Room: " +
                                                                                                            "number of beds: " + r.getNumberOfBeds() +
                                                                                                            "price per night: " + r.getPricePerNight());
                                                                                                    activeBookings.add(b);
                                                                                                    rCount++;
                                                                                                }
                                                                                            }
                                                                                            System.out.println("[" + rCount + "]: Cancel");

                                                                                            //take in users choice
                                                                                            System.out.println(" ");
                                                                                            boolean remAsking = true;
                                                                                            do {
                                                                                                System.out.print("Which room would you like to remove?: ");
                                                                                                int removeC = input.nextInt();
                                                                                                input.nextLine();

                                                                                                if (removeC == rCount) {
                                                                                                    remAsking = false;
                                                                                                } else {
                                                                                                    boolean found = false;
                                                                                                    int fCount = 1;
                                                                                                    for (Room r : rooms) {
                                                                                                        if (!removedRooms.contains(r) && fCount == removeC) {
                                                                                                            found = true;
                                                                                                            removedRooms.add(r);
                                                                                                        }
                                                                                                    }
                                                                                                    if (!found) {
                                                                                                        System.out.println("Incorrect input! (1-" + rCount + ")");
                                                                                                    }

                                                                                                    System.out.print("Are you finished removing rooms from your booking? (y/n): ");
                                                                                                    String answer = input.nextLine();

                                                                                                    boolean asking5 = true;
                                                                                                    do {
                                                                                                        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                                                                            remAsking = false;
                                                                                                            asking5 = false;
                                                                                                        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                                                                            asking5 = false;
                                                                                                        } else {
                                                                                                            System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                                                                        }
                                                                                                    } while (asking5);
                                                                                                }
                                                                                            } while (remAsking);
                                                                                        }
                                                                                        while (removing || rooms.size() > 0);
                                                                                        //give message if all rooms removed
                                                                                        if (rooms.size() < 1) {
                                                                                            System.out.println("All rooms removed!");
                                                                                        }
                                                                                        b.removeRooms(removedRooms);
                                                                                    } else {
                                                                                        System.out.println("No rooms to remove!");
                                                                                    }

                                                                                    break;

                                                                                case 2:
                                                                                    //add room
                                                                                    //prints all available rooms that have not already been chosen
                                                                                    boolean picking = true;
                                                                                    ArrayList<Room> rooms = b.getRoomList();
                                                                                    do {
                                                                                        for (Room r : logic.getAvailableRooms()) {
                                                                                            boolean inBooking = false;
                                                                                            for (Room r2 : rooms) {
                                                                                                if (r.getRoomNumber() == r2.getRoomNumber()) {
                                                                                                    inBooking = true;
                                                                                                }
                                                                                            }
                                                                                            if (!inBooking) {
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
                                                                                        for (Room r : logic.getAvailableRooms()) {
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
                                                                                        if (!roomAdded) {
                                                                                            System.out.println("Could not find room you selected!");
                                                                                        }

                                                                                        boolean exitAsking = true;
                                                                                        //two choices depending on if the room list is greater then 0
                                                                                        if (rooms.size() > 0) {
                                                                                            do {
                                                                                                System.out.print("Do you want to book another room? (y/n): ");
                                                                                                String answer = input.nextLine();

                                                                                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                                                                    exitAsking = false;
                                                                                                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                                                                    picking = false;
                                                                                                    exitAsking = false;
                                                                                                } else {
                                                                                                    System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                                                                }
                                                                                            } while (exitAsking);
                                                                                        }
                                                                                        //if there are no rooms booked ask if they wish to cancel
                                                                                        else {
                                                                                            do {
                                                                                                System.out.print("Do you want to cancel adding rooms to your booking? (y/n): ");
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
                                                                                    break;

                                                                                case 3:
                                                                                    //cancel
                                                                                    System.out.println("Save and returning");
                                                                                    //save all changes to the user that was being edited
                                                                                    c.getBooking(id).updateRoomList(b.getRoomList());
                                                                                    editing = false;
                                                                                    break;

                                                                                case 4:
                                                                                    //cancel
                                                                                    System.out.println("Canceling changes");
                                                                                    editing = false;
                                                                                    break;

                                                                                default:
                                                                                    System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                                                                                    break;

                                                                            }
                                                                        } while (editing);
                                                                        asking = false;
                                                                    }
                                                                    bID++;
                                                                }
                                                            } else {
                                                                System.out.println("Query cancelled");
                                                                asking = false;
                                                            }
                                                        } else {
                                                            System.out.println("Incorrect input!");
                                                        }
                                                    } while (asking);
                                                }
                                            }
                                        } else {
                                            System.out.println("Customer not found!");

                                            //ask if they wish to cancel search
                                            boolean askingTwo = true;
                                            do {
                                                System.out.print("Would you like to search again? (Y/N): ");
                                                String answer = input.nextLine();

                                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                                    askingTwo = false;
                                                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                                                    checking = false;
                                                    askingTwo = false;
                                                } else {
                                                    System.out.println("Incorrect input! Please answer with 'yes' or 'no'.");
                                                }
                                            } while (askingTwo);
                                        }
                                    } while (checking);
                                    break;
                                case 5: // Save the bookings to a .txt file


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

                    case 4:
                        //exit the program (for now this gets rid of all information stored as well)
                        System.out.println("Program is shutting down");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.\nPlease enter a valid choice between 1-4");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error!");
                input.nextLine();
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
        System.out.println("|  3.) View your bookings         |");
        System.out.println("|  4.) Change rooms booked        |");
        System.out.println("|  5.) Save Bookings to File      |");
        System.out.println("|  6.) Return                     |");
        System.out.println("-----------------------------------");
    }

    private void drawEditBookingMenu(){
        System.out.println("___________________________________");
        System.out.println("|   Edit options                  |");
        System.out.println("|                                 |");
        System.out.println("|  1.) Remove booked room         |");
        System.out.println("|  2.) Add another room           |");
        System.out.println("|  3.) Save changes and return    |");
        System.out.println("|  3.) Cancel                     |");
        System.out.println("-----------------------------------");
    }
}
