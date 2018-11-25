package Comparer;

import Person.Person;

public class FioComparer implements Comparer{

    /**
     *
     * @param p1 First person
     * @param p2 Second person
     * @return Positive number if p1.Name > p2.Name (as a string), negative if opposite, 0 if equals
     */
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
