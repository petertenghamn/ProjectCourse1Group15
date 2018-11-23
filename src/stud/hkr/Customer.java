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
        booking = b;
        booking.checkInCustomer();
    }

    public Booking getBooking() {
        return booking;
    }
}
