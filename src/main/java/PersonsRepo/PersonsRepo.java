package PersonsRepo;

import List.PersonList;
import Person.Person;

public class PersonsRepo {
    /**
     * List of Person objects
     */
    public PersonList Persons;

    /**
     * Repositories Constructor
     */
    public PersonsRepo(){
        this.Persons = new PersonList();
    }
}
