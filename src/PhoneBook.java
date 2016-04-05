import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
	private TreeMap<String, Contact> contactList = new TreeMap<String, Contact>();
	
	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.initialisePhoneBook();
		phoneBook.addEntries();
		Utility.print("=============================================================");
		phoneBook.displayPhoneBook();
		Utility.print("=============================================================");
		phoneBook.executeUserChoice();
	}

	private void executeUserChoice() {
		Scanner scanner = new Scanner(System.in);
		List<Contact> sortedContactList = new ArrayList<Contact>( contactList.values());
		Utility.print("How do you want to sort your phone book?");
		Utility.print("1. First Name      2. Last Name       3. Email      4. Phone Number");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			Collections.sort(sortedContactList, Contact.FirstNameComparator);
			break;
			
		case 2:
			Collections.sort(sortedContactList, Contact.LastNameComparator);
			break;
			
		case 3:
			Collections.sort(sortedContactList, Contact.EmailComparator);
			break;
			
		case 4:
			Collections.sort(sortedContactList, Contact.PhoneNumberComparator);
			break;

		default:
			break;
		}
		PhoneBook.displaySortedContact(sortedContactList);
	}
	
	private static void displaySortedContact( List<Contact> sortedContactList ) {
		Utility.print("Below are the list of Contacts sorted as per your choice");
		Utility.print("-----------------------------------------------------------");
		for(Contact contact: sortedContactList ) {
			Utility.print( contact.getFirstName() + "  " + contact.getLastName() + "  " + contact.getEmail() + "  " + contact.getPhoneNumber() );
		}
	}

	private void displayPhoneBook() {
		Utility.print("Below are the list of Contacts : sorted by nickname(default)");
		Utility.print("-----------------------------------------------------------");
		Set<Entry<String, Contact>> contactSet = contactList.entrySet();
		Iterator iterator = contactSet.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry contactMap = (Map.Entry)iterator.next();
			System.out.println( contactMap );
		}
	}

	private void addEntries() {
		Scanner scanner = new Scanner(System.in);
		Utility.print("Want to add a new Contact? ");
		String flag = scanner.next();
		
		while( flag.toLowerCase().charAt(0) == 'y' ) {
			Utility.print("What is his/her nickname? ");
			String nickName = scanner.next();
			Utility.print("What is his/her first name? ");
			String firstName = scanner.next();
			Utility.print("What is his/her last name? ");
			String lastName = scanner.next();
			Utility.print("What is his/her email id? ");
			String email = scanner.next();
			Utility.print("What is his/her phone number? ");
			String phone = scanner.next();
			
			contactList.put(nickName, new Contact(nickName, firstName, lastName, phone, email ));
			
			Utility.print("Want to add a new Contact? ");
			flag = scanner.next();
		}
	}

	private void initialisePhoneBook() {
		contactList.put("Debo", new Contact("Debo", "Ramen", "Majumder", "9764360875", "dmajumder3@gmail.com"));
		contactList.put("Amit", new Contact("Amit", "Amitanjan", "Gupta", "7864360875", "amit@gmail.com"));
	}
}