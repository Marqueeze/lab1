package Comparer;

import Person.Person;

public class BirthdayComparer implements Comparer{

    /**
     *
     * @param p1 First person
     * @param p2 Second person
     * @return Positive number if p1.Birthday > p2.Birthday (as LocalDate), negative if opposite, 0 if equals
     */
    @Override
    public int compare(Person p1, Person p2){
        return p1.getBirthday().compareTo(p2.getBirthday());
    }
}
