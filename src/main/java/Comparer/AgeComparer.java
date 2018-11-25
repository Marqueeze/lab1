package Comparer;

import Person.Person;

public class AgeComparer implements Comparer{

    /**
     *
     * @param p1 First person
     * @param p2 Second person
     * @return Positive number if p1.Age > p2.Age (as int), negative if opposite, 0 if equals
     */
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
