package Checker;

import Person.Person;

public class SexChecker implements Checker{

    /**
     *
     * @param p Person to check
     * @param value boolean Value to check
     * @return True if equals, false if not
     */
    @Override
    public boolean check(Person p, Object value){
        return p.getSex().equals(value);
    }
}
