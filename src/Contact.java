import java.util.Comparator;

public class Contact{
	private String nickName;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	public Contact( String nickName, String firstName, String lastName, String phoneNumber, String email) {
		this.nickName 	 = nickName;
		this.firstName   = firstName;
		this.lastName 	 = lastName;
		this.phoneNumber = phoneNumber;
		this.email 		 = email;
	}
	
	public String nickName() {
		return this.nickName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String toString() {
		return this.nickName + "  " + this.firstName + "  " + this.lastName + "  " + this.email + "  " + this.phoneNumber;
	}
	
	
	// Comparators
	public static Comparator<Contact> FirstNameComparator = new Comparator<Contact>(){
		public int compare(Contact contact1, Contact contact2) {
			return contact1.getFirstName().toLowerCase().compareTo(contact2.getFirstName().toLowerCase());
		}
	};
	
	public static Comparator<Contact> LastNameComparator = new Comparator<Contact>(){
		public int compare(Contact contact1, Contact contact2) {
			return contact1.getLastName().toLowerCase().compareTo(contact2.getLastName().toLowerCase());
		}
	};
	
	public static Comparator<Contact> EmailComparator = new Comparator<Contact>(){
		public int compare(Contact contact1, Contact contact2) {
			return contact1.getEmail().toLowerCase().compareTo(contact2.getEmail().toLowerCase());
		}
	};
	
	public static Comparator<Contact> PhoneNumberComparator = new Comparator<Contact>(){
		public int compare(Contact contact1, Contact contact2) {
			return contact1.getFirstName().toLowerCase().compareTo(contact2.getFirstName().toLowerCase());
		}
	};
}