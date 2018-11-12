import Person.Person;
import PersonsRepo.*;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        PersonsRepo repo = new PersonsRepo();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(;;) {
            System.out.println("1: Add");
            System.out.println("2: Print");
            System.out.println("3: Delete");
            try {
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                        addPerson(repo, reader);
                        break;
                    case 2: System.out.println("Enter persons id (id in the list)");
                        getPerson(repo, Integer.parseInt(reader.readLine()));
                        break;
                    case 3: System.out.println("Enter persons id (id in the list)");
                        deletePerson(repo, Integer.parseInt(reader.readLine()));
                        break;
                    default:
                        System.out.println("Not a 1, 2 or 3 value");
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getPerson(PersonsRepo repo, int id){
        System.out.print(repo.Persons.Get(id).toString());
    }

    private static void deletePerson(PersonsRepo repo, int id){
        System.out.print("Deleted \n/*" + repo.Persons.Pop(id).toString() + "*/\n");
    }

    private static void addPerson(PersonsRepo repo, BufferedReader reader) throws Exception{
        System.out.println("Add a new person");
            repo.Persons.Add(getPersonFromConsole(reader));
    }
    private static Person getPersonFromConsole(BufferedReader reader) throws Exception {
            System.out.print("Name: ");
            String name = reader.readLine();
            System.out.print("Sex: ");
            String tmp = reader.readLine();
            boolean sex;
            if (tmp.toLowerCase().equals("male"))
                sex = true;
            else if (tmp.toLowerCase().equals("female"))
                sex = false;
            else
                throw new Exception();
            System.out.print("Birthday: ");
            LocalDateTime bd = LocalDateTime.parse(reader.readLine(), DateTimeFormat.forPattern("dd/mm/yyyy"));
            return new Person(name, sex, bd);
    }
}
