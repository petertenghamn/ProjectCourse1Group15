package stud.hkr;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

    private ArrayList<Room> roomList;
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public Booking (ArrayList<Room> rooms, Date checkO, Date checkI) {
        roomList = rooms;
        checkInDate = checkI;
        checkOutDate = checkO;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void checkInCustomer(){
        for (Room r : roomList){
            if (!r.isBooked()) {
                r.setBooked(true);
            }
            else {
                System.out.println("Rooms are already booked!");
            }
        }
    }

    public void checkOutCustomer(){
        for (Room r : roomList){
            r.setBooked(false);
        }
    }
}
