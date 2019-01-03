package stud.hkr;

import java.util.ArrayList;

public class Customer {

    private String ssn;
    private String name;
    private String address;
    private String telephoneNumber;
    private ArrayList<Booking> bookings;

    public Customer(String id, String n, String a, String tn) {
        ssn = id;
        name = n;
        address = a;
        telephoneNumber = tn;

        bookings = new ArrayList<>();
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void checkIn(Booking b){
        bookings.add(b);
        b.checkInCustomer();
    }

    public ArrayList<Booking> getBookings(){
        return bookings;
    }

    public void checkOut(int bID){
        Booking b = bookings.get(bID);
        if (b != null){
            b.checkOutCustomer();
        }
    }

    public Booking getBooking(int bID) {
        Booking b = bookings.get(bID - 1);
        if (b != null) {
            return b;
        }
        return null;
    }
}
