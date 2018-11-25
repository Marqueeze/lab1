package List;

import Checker.*;
import Comparer.*;
import Person.Person;
import Sort.*;

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
    public PersonListNode FindById(int id){
        if(id >= this.Length){
            throw new ArrayIndexOutOfBoundsException("Index out of list bounds");
        }
        PersonListNode tmp = this.First;
        for(int i = 0; i<id; i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void SetById(int id, Person p){
        if(id >= this.Length){
            throw new ArrayIndexOutOfBoundsException("Index out of list bounds");
        }
        PersonListNode tmp = this.First;
        for(int i = 0; i<id; i++){
            tmp = tmp.getNext();
        }
        PersonListNode pn = new PersonListNode(p, tmp.getNext().getNext(), tmp);
        tmp.getNext().setPrev(pn);
        tmp.setNext(pn);
    }

    /**
     * Method to get data of a PersonListNode with required id
     * @param id (int) Id of a node
     * @return (Person) Data of a PersonListNode with required id
     */
    public Person Get(int id){
        PersonListNode tmp = this.FindById(id);
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
        PersonListNode tmp = FindById(id);
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

    /**
     * Inserts Node on a certain place
     * @param p (Person) Person to insert
     * @param id (int) Id which person will get in a list
     */
    public void Insert(Person p, int id){
        PersonListNode place = FindById(id);
        PersonListNode node = new PersonListNode(p, place, place.getPrev());
        place.getPrev().setNext(node);
        place.setPrev(node);
    }

    public PersonList Clone() throws CloneNotSupportedException {
        return (PersonList)this.clone();
    }

    PersonList FindAll(char checkType, Object value) throws Exception{
        PersonList outp = new PersonList();
        Checker c;
        switch (checkType) {
            case 'f':
                c = new FioChecker();
                break;
            case 's':
                c = new SexChecker();
                break;
            case 'b':
                c = new BirthdayChecker();
                break;
            case 'a':
                c = new AgeChecker();
                break;
            default:
                throw new Exception("Wrong sort type");
        }
        for (int i = 0; i < this.Length; i++) {
            if (FindById(i).getData().check(c, value)){
                outp.Add(FindById(i).getData());
            }
        }
        return outp;
    }

    public PersonList sorted(char type, char comparer) throws Exception {
        Comparer c;
        switch (comparer) {
            case 'f':
                c = new FioComparer();
                break;
            case 'b':
                c = new BirthdayComparer();
                break;
            case 'a':
                c = new AgeComparer();
                break;
            default:
                throw new Exception("Wrong sort type");
        }

        Sort s;
        switch (type) {
            case 'b':
                s = new BubbleSort(c);
                break;
            case 'i':
                s = new InsertionSort(c);
                break;
            case 'n':
                s = new QuickSort(c);
                break;
            default:
                throw new Exception("Wrong sort type");
        }

        return s.sorted(this);
    }

}
