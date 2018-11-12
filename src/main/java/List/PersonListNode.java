package List;

import Person.Person;

public class PersonListNode {

    /**
     * Reference to a Next node in the list
     */
    private PersonListNode Next;
    public PersonListNode getNext(){
        return this.Next;
    }
    void setNext(PersonListNode next){
        this.Next = next;
    }

    /**
     * Reference to a Previous node in the list
     */
    private PersonListNode Prev;
    public PersonListNode getPrev(){
        return this.Prev;
    }
    void setPrev(PersonListNode prev){
        this.Prev = prev;
    }

    /**
     * Data of the Node (Person object)
     */
    private Person Data;
    public Person getData(){
        return this.Data;
    }

    /**
     * Nodes constructor
     * @param data (Person) Person object
     * @param next (PersonListNode) Next node in the list
     * @param prev (PersonListNode) Previous node in the list
     */
    protected PersonListNode(Person data, PersonListNode next, PersonListNode prev){
        this.Data = data;
        this.Next = next;
        this.Prev = prev;
    }
}
