package domain;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Manages CRUD operations for People in lieu of database for now. 
 * @author Mitch
 *
 */
public class PersonManager {
	private static PeopleList list = new PeopleList();
	
	static {
		list.add(new Member("1", "Mitch", "McEwen", "H", LocalDate.of(1980, 12, 11), null, null));
		list.add(new Member("1.1", "Sara", "Smith", "Jones", LocalDate.of(1965, 9, 23), null, null));
		list.add(new Member("1.2", "John", "Bob", "Matilda", LocalDate.of(2005, 4, 1), null, null));
	}
	
	/**
	 * Get all people
	 * 
	 * @return people list
	 */
	public static PeopleList getAllPeople() {
		return list;
	}
	
	/**
	 * Find a person in the list.
	 * @param firstName
	 * 				 person to find
	 * @return person or null
	 */
	public static Person find(String familyID) {
		final Optional<Person> foundPerson = list.stream()
				.filter(person -> person.getFamilyID()
				.equals(familyID))
				.findFirst();
		return foundPerson.orElse(null);
		
	}
	
	/**
	 * Add a new person to the list
	 * @param person
	 * 				person to add
	 */
	public static void add(Person person) {
			list.add(person);
	}
	
	public static void delete(String familyID) {
		Person person = find(familyID);
		list.remove(person);
	}

}
