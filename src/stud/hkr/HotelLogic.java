package stud.hkr;

import java.util.ArrayList;

public class HotelLogic {

    //should be array later
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public Customer getCustomer(String ssn) {
        //return a customer when asked for
        for (Customer c : customers) {
            if (c.getSsn().equals(ssn)) {
                return c;
            }
        }
        return null;
    }

    public void removeCustomer(String customerSSN) {
        // Searches through the array customers for the specific customer using the SSN

        for (int i = 0; i < customers.size(); i++) {
            if (customerSSN.equals(customers.get(i).getSsn())) {
                customers.remove(i);
            }
        }
    }

    public ArrayList<Customer> getCustomers() {
        //get list of all Customers
        return customers;
    }

    public Room getRoom(int roomNbr) {
        //get a Room
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNbr) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Room> getRooms() {
        //get list of Rooms
        return rooms;
    }

    public ArrayList<Room> getAvailableRooms() {
        //get list of Rooms not booked
        ArrayList<Room> output = new ArrayList<>();
        for (Room r : rooms) {
            if (!r.isBooked()) {
                output.add(r);
            }
        }
        return output;
    }

    public boolean addCustomer(String id, String n, String a, String tn) {
        //add a customer to all current customers
        boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getSsn().equalsIgnoreCase(id)) {
                exists = true;
            }
        }
        if (!exists) {
            Customer c = new Customer(id, n, a, tn);
            customers.add(c);
        }
        return exists;
    }

    public void addRoom(int nob, double ppn, boolean hb, boolean ib) {
        //add a room to all current rooms
        int rn = 0;
        boolean exists;
        do {
            rn++;
            exists = false;
            for (Room r : rooms) {
                if (r.getRoomNumber() == rn) {
                    exists = true;
                }
            }
        } while (exists);

        Room r = new Room(rn, nob, ppn, hb, ib);
        rooms.add(r);
    }

    public void removeRoom(int roomNumber) {
        // Searches through the rooms array using the room number

        for (int i = 0; i < rooms.size(); i++) {
            if (roomNumber == rooms.get(i).getRoomNumber()) {
                rooms.remove(i);
            }
        }
    }

    public boolean checkInCustomer(String ssn, Booking b) {
        //check in a customer to an available room
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getSsn().equals(ssn)) {
                customer = c;
            }
        }

        if (customer != null) {
            //attach booking to the user and check them in
            customer.checkIn(b);

            return true;
        } else {
            return false;
        }
    }

    public boolean checkOutCustomer(String ssn, int bID) {
        //check out a customer out of a room currently used
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getSsn().equals(ssn)) {
                customer = c;
            }
        }

        if (customer != null) {
            //remove booking from customer after checkout
            customer.checkOut(bID);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Booking> ViewAllBookings(String ssn){
        ArrayList<Booking> b = new ArrayList<>();
        for (Customer c : customers){
            if (c.getSsn().equals(ssn)){
                b.addAll(c.getBookings());
            }
        }

        return b; //can return empty
    }

    public Booking ViewBooking(String ssn, int bID){
        Booking b = null;
        for (Customer c : customers){
            if (c.getSsn().equals(ssn)){
                b = c.getBooking(bID);
            }
        }

        return b; //can return null
    }

    public void editBooking(String ssn, Booking booking) {
        //get persons info first to check booking and create a new one
        //over-write booking info
    }

    // generates a foundation of rooms
    public void generateRooms() {

        rooms.add(new Room(1, 2, 499, false, false));
        rooms.add(new Room(2, 2, 699, true, false));
        rooms.add(new Room(3, 2, 549, false, false));
        rooms.add(new Room(4, 3, 799, true, false));
        rooms.add(new Room(5, 1, 599, true, false));
        rooms.add(new Room(6, 1, 399, false, false));
        rooms.add(new Room(7, 5, 899, true, false));
        rooms.add(new Room(8, 2, 699, false, false));
        rooms.add(new Room(9, 1, 549, true, false));
        rooms.add(new Room(10, 2, 699, true, false));

    }

    public void generateCustomers() {

        customers.add(new Customer("0000000000", "Nicole", "Streetway 0", "0700000000"));
        customers.add(new Customer("0000000001", "Linus", "Streetway 1", "0700000001"));
        customers.add(new Customer("0000000002", "Stephen", "Streetway 2", "0700000002"));
        customers.add(new Customer("0000000003", "Peter", "Streetway 3", "0700000003"));
        customers.add(new Customer("0000000004", "Öjvind", "Streetway 4", "0700000004"));
        customers.add(new Customer("0000000005", "Alex", "Streetway 5", "0700000005"));
        customers.add(new Customer("0000000006", "Jonas", "Streetway 6", "0700000006"));
        customers.add(new Customer("0000000007", "Carl", "Streetway 7", "0700000007"));
        customers.add(new Customer("0000000008", "Tobjörn", "Streetway 8", "070000008"));
        customers.add(new Customer("0000000009", "India", "Streetway 9", "0700000009"));
    }

}

//generate a basic list of rooms to use, a few of each type.
