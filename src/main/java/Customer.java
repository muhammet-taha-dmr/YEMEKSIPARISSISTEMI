

public class Customer extends User {
    private String address;

    public Customer(int userId, String name, String phoneNumber, String address) {
        super(userId, name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
// customer  class  reviewed