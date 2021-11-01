package phonebookProject;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        StoredData directory = new StoredData();
        Person newPerson = new Person();
     

        Address a1 = new Address("Market St", "St. Louis", "MO", "63403");
        Person p1 = new Person("John Doe", "636-643-5698", a1);
       
        directory.addPerson(p1); // groomer; directory.addDog(d1)

       
        Address a2 = new Address("324 Main St", "St. Louis", "MO", "63303");
        Person p2 = new Person("John Doe", "847-539-0126", a2);
       
        directory.addPerson(p2);

        
        Address a3 = new Address("574 Pole ave", "St. Peters", "MO", "63333");
        Person p3 = new Person("John Michael West Doe", "562-859-2375", a3);

        directory.addPerson(p3);

       
        int choice = 0;
        do {
            try {

                choice = mainMenu();
                switch (choice) {

                    case 1:
                        // add new entry
                        System.out.println("Please enter your new listing in the following format: ");
                        System.out.println("FULL NAME, PHONE NUMBER, STREET ADDRESS, CITY, STATE, ZIPCODE");
                        System.out.println("eg: John M Doe, 555-555-5555, 123 Shady Lane, Long Beach, CA, 90210");
                        String newEntryInput = in.nextLine(); // user enters long string w/commas,,,,
                        String[] newEntryArray; // need to break down user input to workable array
                        newEntryArray = newEntryInput.split(",");
                        String fullName = newEntryArray[0]; //
                        String phoneNumber = newEntryArray[1];
                        String street = newEntryArray[2]; //
                        String city = newEntryArray[3];
                        String state = newEntryArray[4];
                        String zip = newEntryArray[5];
                        newPerson = new Person(fullName, phoneNumber, new Address(street, city, state, zip));
                        directory.addPerson(newPerson);
                        System.out.println("\nSUCCESS! The following entry has been stored.\n");
                        newPerson.printPerson();
                        break;
                    case 2:
                        System.out.println("Enter a first name to search: ");
                        String firstName = in.nextLine();
                        directory.searchByFirstName(firstName);
                        break;
                    case 3:
                        System.out.println("Enter a last name to search: ");
                        String lastName = in.nextLine();
                        directory.searchByLastName(lastName);
                        break;
                    case 4:
                        System.out.println("Enter a full name to search: ");
                        fullName = in.nextLine();
                        directory.searchByFullName(fullName);
                        break;
                    case 5:
                        System.out.println("Enter a telephone number to search by:");
                        phoneNumber = in.nextLine(); // already used this variable in case 1, is this a problem??
                        directory.searchByPhoneNumber(phoneNumber);
                        break;
                    case 6:
                        System.out.println("To update a record, enter a phone number to search: ");
                        phoneNumber = in.nextLine(); // already used this variable in case 1, is this a problem??
                        directory.searchByPhoneNumber(phoneNumber);
                        System.out.println("If this number is correct, please add your updates. Be sure to include the entire listing, eg:");
                        System.out.println("full name, phone number, street, city, state, zipcode");
                        directory.updateByPhoneNumber(phoneNumber);
                        newEntryInput = in.nextLine();
                        newEntryArray = newEntryInput.split(",");
                        fullName = newEntryArray[0]; 
                        street = newEntryArray[2]; 
                        city = newEntryArray[3];
                        state = newEntryArray[4];
                        zip = newEntryArray[5];
                        int listingToUpdate = 0;
                        Person updatedPerson = new Person(fullName, phoneNumber, new Address(street, city, state, zip));
                        directory.phoneBook[listingToUpdate] = updatedPerson;
                        System.out.println("\nSUCCESS! The following entry has been updated.\n");
                        updatedPerson.printPerson();
                        break;
                    case 7:
                        Person deletePerson = new Person();
                        System.out.println("To delete a record, enter a phone number to search using the following format: eg 555-555-5555 ");
                        String numberToDelete = in.nextLine(); //555-555-5555
                        directory.searchByPhoneNumber(numberToDelete);
                        directory.deleteEntry(numberToDelete);
                        System.out.println("POOF! This person has now been cancelled from existence.");
                        System.out.println("\n\n--------------------------------------------------------------------------------");
                        break;
                    case 8:
                        directory.alphabetizePhoneBook();
                        directory.printPhoneBook();
                        break;
                    case 9:
                        System.out.println("Please enter a city or state: ");
                        String cityOrState = in.nextLine();
                        directory.searchByCityOrState(cityOrState);
                        break;
                    case 10:
                        System.out.println("\nCiao! Thanks for using Margot's neat phonebook!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid entry, please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nINVALID entry, please try again or press 10 to EXIT");
            }
        } while (choice != 10);
    }

    public static int mainMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nWELCOME TO MARGOT'S OLD-SCHOOL TELECOMMUNICATIONS NETWORK!");
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nPlease choose from one of the many options: ");
        System.out.println("\n1 - Add new entry ");
        System.out.println("2 - Search by first name");
        System.out.println("3 - Search by last name ");
        System.out.println("4 - Search by full name ");
        System.out.println("5 - Search by telephone number");
        System.out.println("6 - Update a record for a given telephone number");
        System.out.println("7 - Delete a record for a given telephone number");
        System.out.println("8 - To print all records");
        System.out.println("9 - To search by city or state");
        System.out.println("10 - To Exit");
        System.out.println("____________________________________________________________________\n");

        int choice = in.nextInt();
        System.out.println();
        return choice;
    }


}







































