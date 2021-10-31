package phonebookProject;


public class Person {
    // instance variables of person listing
    private String firstName;
    private String fullName;
    private String lastName;
    private String phoneNumber;
    private Address address;


    // Person constructor w/o parameters
    public Person() {

    }

    // constructor w/parameters
    public Person(String fullName, String phoneNumber, Address address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }
    public void getFullName(String fullName) {
        this.fullName = fullName;

    }

    // set address to person
    public void addAddress(String street, String city, String state, String zip) {
        Address tempAddress = new Address(street, city, state, zip);
        this.address = tempAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    // returns person and address entry
    public void printPerson() {
        System.out.println(fullName + ", " + phoneNumber);
        address.printAddress();
    }

    // getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;

    }
    // need to split fullName into array to search by first name
    public String getFirstName() {
        String[] arr = fullName.split(" ");
        return firstName = arr[0];
    }
    public String getLastName() {
        String[] arr = fullName.split(" ");
        return lastName = arr[arr.length -1];
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAddress() {
    }

}

