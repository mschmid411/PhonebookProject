package phonebookProject;

//import java.util.InputMismatchException;

public class StoredData {

    // create array of all Person listings in directory
    Person[] phoneBook = new Person[0];


    // CASE 1 - add a new person to directory
    public void addPerson(Person newPerson) {
        
        // create temporary array that is 1 larger than current array
        Person temp[] = new Person[phoneBook.length + 1];

        // add the Person in the original array to the temporary one
        for (int i = 0; i < phoneBook.length; i++) {
            temp[i] = phoneBook[i];
        }
        // adds the new person to the end of the temp array
        temp[temp.length - 1] = newPerson;

        // reassign the original array to the new one
        phoneBook = temp;
    }

    // CASE 2 - search directory by firstname
    public void searchByFirstName(String firstName) {

        //for loop to generate phonebook to find first name equal to scanner input
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
                phoneBook[i].printPerson();

            }
        }
    }

    // CASE 3 Search by Last Name
    public void searchByLastName(String lastName) {

        //for loop to generate phonebook to find last name equal to scanner input
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                phoneBook[i].printPerson();
            }

        }

    }

    // CASE 4 Search by full name
    public void searchByFullName(String fullName) {

        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getFullName().toLowerCase().equals(fullName.toLowerCase())) {
                phoneBook[i].printPerson();
            }
        }
    }

    // CASE 5 Search by Phone Number
    public void searchByPhoneNumber(String phoneNumber) {

        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getPhoneNumber().equals(phoneNumber)) {
                phoneBook[i].printPerson();
            }
        }
    }

    // CASE 6 - Update listing by entering phone number
    public int updateByPhoneNumber(String phoneNumber) {

        int listingToUpdate = 0;
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getPhoneNumber().equals(phoneNumber)) {
                listingToUpdate = i;
            }
        }
        return listingToUpdate;
    }

    // CASE 7 - delete entry
    public void deleteEntry(String numberToDelete) {

        // create temp array 1 smaller than person
        Person temp[] = new Person[phoneBook.length - 1];
        int k = 0;

        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getPhoneNumber().equals(numberToDelete)) {
                continue;
            }
            temp[k++] = phoneBook[i];
        }
        phoneBook = temp;
    }


    // CASE 8 print phonebook alphabetically by LastName
    public void alphabetizePhoneBook() {

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[i].getLastName().compareTo(phoneBook[j].getLastName()) > 0) {
                    Person temp = phoneBook[i];
                    phoneBook[i] = phoneBook[j];
                    phoneBook[j] = temp;

                }
            }
        }
    }
        public void printPhoneBook() {
            for (int i = 0; i < phoneBook.length; i++) {
               phoneBook[i].printPerson();
            }
        }

    // CASE 9 search by city OR state
    public void searchByCityOrState(String cityOrState) {

        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i].getAddress().getCity().equals(cityOrState) || (phoneBook[i].getAddress().getState().equals(cityOrState))) {
                phoneBook[i].printPerson();

            }
        }
    }

}
