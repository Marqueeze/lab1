package Sort;

import Comparer.Comparer;
import List.PersonList;
import List.PersonListNode;
import Person.Person;

public class InsertionSort implements Sort {

    private Comparer comparer;
    public InsertionSort(Comparer comparer){
        this.comparer = comparer;
    }

    /**
     * Insertion sort algorithm based insertions on place where object should be
     * @param toSort PersonList to sort
     * @return Sorted copy of a list in params
     * @throws CloneNotSupportedException Tut tak nado
     */
    @Override
    public PersonList sorted(PersonList toSort) throws CloneNotSupportedException {
        PersonList list = toSort.Clone();
        PersonListNode key;
        for (int i = 1; i < list.Length(); i++) {
            key = list.FindById(i);
            int j = i - 1;
            while (j >= 0 && comparer.compare(list.FindById(j).getData(), key.getData()) < 0) {
                list.SetById(j+1, list.FindById(j).getData());
                j = j - 1;
            }
            list.SetById(j+1, key.getData());
        }
        return list;
    }
}
