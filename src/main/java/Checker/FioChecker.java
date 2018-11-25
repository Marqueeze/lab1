package Checker;

import Person.Person;

public class FioChecker implements Checker{

    /**
     *
     * @param p Person to check
     * @param value String value to check
     * @return True if equals, false if not
     */
    @Override
    public boolean check(Person p, Object value){
        return p.getName().equals(value);
    }
}
