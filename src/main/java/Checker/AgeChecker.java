package Checker;

import Person.Person;

public class AgeChecker implements Checker{

    /**
     *
     * @param p Person to check
     * @param value Int Value to check
     * @return True if equals, false if not
     */
    @Override
    public boolean check(Person p, Object value){
        return value.equals((Object)p.getAge());
    }
}
