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
            if (r.getIsBooked()){
                output.add(r);
            }
        }
        return output;
    }

    public void addCustomer(Customer c){
        //add a customer to all current customers
        customers.add(c);
    }

    public void addRoom(Room r){
        //add a room to all current rooms
        rooms.add(r);
    }

    public void checkInCustomer(String ssn, int bookingnbr){
        //check in a customer to an available room
        //get person, from person get booking, from booking get rooms to change to being booked = true

    }

    public void checkOutCustomer(String ssn, int bookingnbr){
        //check out a customer out of a room currently used

    }

    public void editBooking(String ssn, Booking booking){
        //get persons info first to check booking and create a new one
        //over-write booking info
    }
}
