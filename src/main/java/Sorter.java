import java.util.Comparator;

public abstract class Sorter {
    Comparator comparator;

    abstract Object[] sort(Object[] arr);

    public void setAscendingOrder() {
        comparator = Comparator.reverseOrder();
    }

    public void setDescendingOrder() {
        comparator = Comparator.naturalOrder();
    }
}
