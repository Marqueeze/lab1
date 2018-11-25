package Person;

import Checker.Checker;
import Comparer.Comparer;
import org.joda.time.LocalDateTime;

public class Person {
    /**
     * Static property which contains id of the last person added
     * Is needed to autoincremently set new Persons id
     */
    private static int lastId=0;

    private int Id;
    public int getId(){
        return this.Id;
    }

    private String Name;
    public String getName(){
        return this.Name;
    }

    private boolean Sex;
    public String getSex(){
        if(this.Sex)
            return "Male";
        return "Female";
    }

    private LocalDateTime Birthday;
    public LocalDateTime getBirthday(){
        return this.Birthday;
    }

    /**
     * Calculates persons age, basing on year, month and day of birthday
     * @return (int) Person's full age
     */
    public int getAge(){
        LocalDateTime _now = LocalDateTime.now();
        int opt = 0;
        if ((_now.getMonthOfYear() - this.Birthday.getMonthOfYear() < 0) ||
                ((_now.getMonthOfYear() - this.Birthday.getMonthOfYear() == 0) && (_now.getDayOfMonth() - this.Birthday.getDayOfMonth() < 0)))
            opt=-1;
        return _now.getYear() - this.Birthday.getYear() + opt;
    }

    /**
     *  Persons Constructor.
     *  Id gets as id of a last person added +1
     * @param name (String) Persons Name
     * @param sex (boolean) Persons Sex (True - Male, False - Female)
     * @param bd (LocalDateTime) Persons Birthday
     */
    public Person(String name, boolean sex, LocalDateTime bd){
        this.Id = ++lastId;
        this.Sex = sex;
        this.Name = name;
        this.Birthday = bd;
    }

    /**
     * String representation of a Person object
     * @return (String) Person base properties
     */
    @Override
    public String toString(){
        return "ID: " + String.valueOf(this.getId()) +"\nName: " +  String.valueOf(this.getName()) + "\n" +
                "Age: " + String.valueOf(this.getAge()) + "\nSex: " + this.getSex() + "\n";
    }

    public boolean check(Checker c, Object value){
        return c.check(this, value);
    }

    public int compare(Comparer comparer, Person value) { return comparer.compare(this, value); }
}
