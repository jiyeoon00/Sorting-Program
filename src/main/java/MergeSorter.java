import java.util.Comparator;

public class MergeSorter extends Sorter {
    public Object[] sort(Object[] arr) {
        mergeSort(arr, 0, arr.length, comparator);
        return arr;
    }

    private static void mergeSort(Object[] arr, int low, int high, Comparator comparator) {
        if (high - low < 2) {
            return;
        }

        int mid = (high + low)/2;
        mergeSort(arr, 0, mid, comparator);
        mergeSort(arr, mid, high, comparator);
        merge(arr, low, mid, high, comparator);
    }

    private static void merge(Object[] arr, int low, int mid, int high, Comparator comparator) {
        Object[] tempSortedArray = new Object[high - low];
        int currentIndex = 0;
        int leftArrayIndex = low;
        int rightArrayIndex = mid;

        while (leftArrayIndex < mid && rightArrayIndex < high) {
            if (comparator.compare(arr[leftArrayIndex], arr[rightArrayIndex]) > 0) {
                tempSortedArray[currentIndex++] = arr[leftArrayIndex++];
            } else {
                tempSortedArray[currentIndex++] = arr[rightArrayIndex++];
            }
        }

        while(leftArrayIndex < mid) {
            tempSortedArray[currentIndex++] = arr[leftArrayIndex++];
        }

        while(rightArrayIndex < high) {
            tempSortedArray[currentIndex++] = arr[rightArrayIndex++];
        }

        copyTempSortedArrayToOriginal(arr, tempSortedArray, low, high);
    }

    private static void copyTempSortedArrayToOriginal(Object[] arr, Object[] tempSortedArray, int low, int high) {
        for (int i = low; i < high; i++) {
            arr[i] = tempSortedArray[i- low];
        }
    }
}
