package Sort;

import Comparer.Comparer;
import List.PersonList;

public class BubbleSort implements Sort {

    private Comparer comparer;
    public BubbleSort(Comparer comparer){
        this.comparer = comparer;
    }

    /**
     * Bubble sort algorithm based on changing two objects' indexes depending on a condition
     * @param toSort PersonList to sort
     * @return Sorted copy of a list in params
     * @throws CloneNotSupportedException Tut tak nado
     */
    @Override
    public PersonList sorted(PersonList toSort) throws CloneNotSupportedException {
        PersonList list = toSort.Clone();
        for(int j = 0; j<list.Length(); j++){
            for(int i = 0; i < list.Length()-1; i++){
                if (list.FindById(i).getData().compare(comparer, list.FindById(i+1).getData()) < 0){
                    list.Insert(list.FindById(i+1).getData(), i);
                }
            }
        }
        return list;
    }
}
