package Sort;

import Comparer.Comparer;
import List.PersonList;

public interface Sort {
    PersonList sorted(PersonList list) throws CloneNotSupportedException;
}
