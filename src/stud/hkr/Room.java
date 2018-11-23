package stud.hkr;

public class Room {

    private int roomNumber;
    private int numberOfBeds;
    private double pricePerNight;
    private boolean hasBalcony;
    private boolean booked;

    public Room(int rn, int nob, double ppn, boolean hb, boolean ib) {
        roomNumber = rn;
        numberOfBeds = nob;
        pricePerNight = ppn;
        hasBalcony = hb;
        booked = ib;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean getHasBalcony() {
        return hasBalcony;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean b) {
        booked = b;
    }
}

/*
private

-room number int
-number of beds int
-has balcony boolean
-price per night
-is booked or not boolean

public
room (roomnr: int, numberOfBeds: int, hasBalcony: boolean, priceByNight: double)
 */
