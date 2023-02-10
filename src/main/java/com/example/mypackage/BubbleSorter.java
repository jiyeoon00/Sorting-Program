public class BubbleSorter extends Sorter {
    public Object[] sort(Object[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (comparator.compare(array[j], array[j+1]) < 0) {
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }

    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

