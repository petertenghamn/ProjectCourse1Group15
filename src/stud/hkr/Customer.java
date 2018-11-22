package stud.hkr;

public class Customer {

    private String ssn;
    private String name;
    private String address;
    private String telephoneNumber;

    public Customer(String ssn, String name, String address, String telephoneNumber) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }
}
