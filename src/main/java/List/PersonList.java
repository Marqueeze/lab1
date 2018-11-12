package List;

import Person.Person;

public class PersonList {
    /**
     * PersonLists Constructor
     */
    public PersonList(){
        this.First = null;
        this.Last = null;
        this.Length = 0;
    }

    /**
     * The first node of the PersonsList
     */
    private PersonListNode First;
    public PersonListNode First(){
        return this.First;
    }

    /**
     * The last node of the PersonsList
     */
    private PersonListNode Last;
    public PersonListNode Last(){
        return this.Last;
    }


    /**
     * The length of the PersonsList (count of objects included)
     */
    private int Length;
    public int Length(){
        return this.Length;
    }

    /**
     * Method to add a PersonNode into a PersonNodeList
     * Increases Length of a List
     * @param person (Person) Data to store in a Node that will be added
     */
    public void Add(Person person){
        if(this.First == null && this.Last == null) {
            this.First = this.Last = new PersonListNode(person, null, null);
        }
        else {
            PersonListNode  node = new PersonListNode(person, null, this.Last);
            this.Last.setNext(node);
            this.Last = node;
        }
        this.Length++;
    }

    /**
     * Method to get PersonListNode by its id in the List
     * @param id (int) Id of an element
     * @return (PersonListNode) Node with a required id
     */
    private PersonListNode Find(int id){
        if(id >= this.Length){
            throw new ArrayIndexOutOfBoundsException("Index out of list bounds");
        }
        PersonListNode tmp = this.First;
        for(int i = 0; i<id; i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }

    /**
     * Method to get data of a PersonListNode with required id
     * @param id (int) Id of a node
     * @return (Person) Data of a PersonListNode with required id
     */
    public Person Get(int id){
        PersonListNode tmp = this.Find(id);
        return tmp.getData();
    }

    /**
     * Method to get data of a PersonListNode with required id
     * Deletes Node from the List
     * Decreases length
     * @param id (int) Id of a node
     * @return (Person) Data of a PersonListNode with required id
     */
    public Person Pop(int id) {
        PersonListNode tmp = Find(id);
        if (!tmp.equals(this.First)) {
            tmp.getPrev().setNext(tmp.getNext());
        } else {
            this.First = tmp.getNext();
        }
        if (!tmp.equals(this.Last)) {
            tmp.getNext().setPrev(tmp.getPrev());
        } else {
            this.Last = tmp.getPrev();
        }
        Person ret = tmp.getData();
        this.Length--;
        return ret;
    }
}
