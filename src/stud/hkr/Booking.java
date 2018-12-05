package stud.hkr;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

    private ArrayList<Room> roomList;
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private boolean checkedOut;

    public Booking (int id, ArrayList<Room> rooms, Date checkI, Date checkO) {
        bookingId = id;

        roomList = rooms;
        checkInDate = checkI;
        checkOutDate = checkO;

        for (Room r : rooms){
            totalPrice += r.getPricePerNight();
        }

        checkedOut = false;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
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

        checkedOut = true;
    }
}
