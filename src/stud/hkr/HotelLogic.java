package stud.hkr;
import java.util.ArrayList;

public class HotelLogic {

    Room[] rooms = new Room[100];
    ArrayList<Customer> customers = new ArrayList<>();

    public void getCustomer(String ssn){
        for (Customer c : customers){
            if (c.getSsn() == ssn){
                //return a customer? or error
            }
        }
    }

    public void getCustomers(){
        //get list of Customers
    }

    public void getRoom(int roomNbr){
        //get a Room
    }

    public void getRooms(){
        //get list of Rooms
    }

    public void getAvailableRooms(){
        //get list of Rooms not booked
    }

    public void addCustomer(Customer customer){
        //add a customer to all current customers
    }

    public void addRoom(Room room){
        //add a room to all current rooms
    }

    public void checkInCustomer(String ssn, int bookingnbr){
        //check in a customer to an available room
    }

    public void checkOutCustomer(String ssn, int bookingnbr){
        //check out a customer out of a room currently used
    }

    public void editBooking(String ssn, Booking booking){
        //get persons info first to check booking and create a new one
        //over-write booking info
    }
}
