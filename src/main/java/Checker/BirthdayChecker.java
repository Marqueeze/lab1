package Checker;

import Person.Person;

public class BirthdayChecker implements Checker{

    /**
     *
     * @param p Person to check
     * @param value LocalDate Value to check
     * @return True if equals, false if not
     */
    @Override
    public boolean check(Person p, Object value){
        return p.getBirthday().equals(value);
    }
}
