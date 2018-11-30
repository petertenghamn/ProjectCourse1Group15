package stud.hkr;

public class Customer {

    private String ssn;
    private String name;
    private String address;
    private String telephoneNumber;
    private Booking booking;

    public Customer(String id, String n, String a, String tn) {
        ssn = id;
        name = n;
        address = a;
        telephoneNumber = tn;
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
        if (booking != null){ checkOut(booking); } // temporary fix so a person doesn't permanently lock a room as booked
        booking = b;
        booking.checkInCustomer();
    }

    public void checkOut(Booking b){
        booking = null;
        b.checkOutCustomer();
    }

    public Booking getBooking() {
        return booking;
    }
}
