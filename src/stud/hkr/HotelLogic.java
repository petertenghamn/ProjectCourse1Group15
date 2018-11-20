package stud.hkr;

public class HotelLogic {


    public void getCustomer(String ssn){
        //get a Customer
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
        //change current booking info
    }
}
