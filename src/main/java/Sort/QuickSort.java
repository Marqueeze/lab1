package Sort;

import Comparer.Comparer;
import List.PersonList;
import List.PersonListNode;

public class QuickSort implements Sort {

    private Comparer comparer;
    public QuickSort(Comparer comparer){
        this.comparer = comparer;
    }

    /**
     * QuickSort algorithm based on pivot and recursive call
     * @param toSort PersonList to sort
     * @return Sorted copy of a list in params
     * @throws CloneNotSupportedException Tut tak nado
     */
    @Override
    public PersonList sorted(PersonList toSort) throws CloneNotSupportedException {
        PersonList list = toSort.Clone();
        int startIndex = 0;
        int endIndex = list.Length() - 1;
        doSort(startIndex, endIndex, list);
        return list;
    }

    /**
     * Recursive part of the quick sort
     * @param start Index to start from
     * @param end Index to end at
     * @param list Person list that is sorting by now
     */
    private void doSort(int start, int end, PersonList list) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (comparer.compare(list.FindById(i).getData(), list.FindById(cur).getData()) <= 0)) {
                i++;
            }
            while (j > cur && (comparer.compare(list.FindById(cur).getData(), list.FindById(j).getData()) <= 0)) {
                j--;
            }
            if (i < j) {
                PersonListNode temp = list.FindById(i);
                list.SetById(i, list.FindById(j).getData());
                list.SetById(j,temp.getData());
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, list);
        doSort(cur+1, end, list);
    }

}