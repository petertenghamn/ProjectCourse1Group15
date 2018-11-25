package stud.hkr;
import java.util.ArrayList;

public class HotelLogic {

    //should be array later
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public Customer getCustomer(String ssn){
        //return a customer when asked for
        for (Customer c : customers){
            if (c.getSsn().equals(ssn)){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers(){
        //get list of all Customers
        return customers;
    }

    public Room getRoom(int roomNbr){
        //get a Room
        for (Room r : rooms){
            if (r.getRoomNumber() == roomNbr){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Room> getRooms(){
        //get list of Rooms
        return rooms;
    }

    public ArrayList<Room> getAvailableRooms(){
        //get list of Rooms not booked
        ArrayList<Room> output = new ArrayList<>();
        for (Room r : rooms){
            if (!r.isBooked()){
                output.add(r);
            }
        }
        return output;
    }

    public void addCustomer(String id, String n, String a, String tn){
        //add a customer to all current customers
        Customer c = new Customer(id, n, a, tn);
        customers.add(c);
    }

    public void addRoom(int rn, int nob, double ppn, boolean hb, boolean ib){
        //add a room to all current rooms
        Room r = new Room(rn, nob, ppn, hb, ib);
        rooms.add(r);
    }

    public boolean checkInCustomer(String ssn, Booking b){
        //check in a customer to an available room
        Customer customer = null;
        for (Customer c : customers){
            if (c.getSsn().equals(ssn)){
                customer = c;
            }
        }

        if (customer != null){
            //attach booking to the user and check them in
            customer.checkIn(b);

            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkOutCustomer(String ssn, Booking b){
        //check out a customer out of a room currently used
        Customer customer = null;
        for (Customer c : customers){
            if (c.getSsn().equals(ssn)){
                customer = c;
            }
        }

        if (customer != null){
            //remove booking from customer after checkout
            customer.checkOut(b);

            return true;
        }
        else {
            return false;
        }
    }

    public void editBooking(String ssn, Booking booking){
        //get persons info first to check booking and create a new one
        //over-write booking info
    }
}
