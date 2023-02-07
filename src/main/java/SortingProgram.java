import java.util.Scanner;

abstract public class SortingProgram {
    final int BUBBLESORT_NUMBER = 1;
    final int MERGESORT_NUMBER = 2;
    final int ASCENDING_ORDER_NUMBER = 1;
    final int DESCENDING_ORDER_NUMBER = 2;

    Scanner scanner = new Scanner(System.in);
    Object[] arr;
    Sorter sorter = null;

    public void sort() {
        takeAndSetSortingType();
        takeArrayForSort();
        Object[] sortedArr = sorter.sort(arr);
        printSortedObjects(sortedArr);
    }

    private void takeAndSetSortingType() {
        setSortingAlgorithm(takeSortingAlgorithmNumber());
        setSortOrder(takeSortOrderNumber());
    }

    private void takeArrayForSort() {
        String sortedObjectType = getSortedObjectType();
        System.out.println("The number of "+ sortedObjectType +" to be sorted");
        System.out.print("> ");
        int NumberOfObjectsForSort = takeNumberOfObjectsForSort();
        System.out.println("The "+ sortedObjectType +" to be sorted");
        System.out.print("> ");
        takeObjectsForSort(NumberOfObjectsForSort);
    }

    abstract String getSortedObjectType();

    private int takeSortingAlgorithmNumber() {
        System.out.println("Select a sorting algorithm");
        showSortingAlgorithms();
        return takeSelectionNumber();
    }

    private void showSortingAlgorithms() {
        System.out.println(BUBBLESORT_NUMBER + ". Bubble sort");
        System.out.println(MERGESORT_NUMBER + ". Merge sort");
    }

    private int takeSelectionNumber() {
        System.out.print("> ");
        return scanner.nextInt();
    }

    private int takeSortOrderNumber() {
        System.out.println("Select the sort order");
        showSortOrders();
        return takeSelectionNumber();
    }

    private void showSortOrders() {
        System.out.println(ASCENDING_ORDER_NUMBER + ". Ascending order");
        System.out.println(DESCENDING_ORDER_NUMBER + ". Descending order");
    }

    private int takeNumberOfObjectsForSort() {
        return scanner.nextInt();
    }

    private void takeObjectsForSort(int NumberOfObjectsForSort) {
        arr = new Object[NumberOfObjectsForSort];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = takeObject();
        }
    };

    abstract Object takeObject();

    private void setSortingAlgorithm(int sortingAlgorithmNumber) {
        if (sortingAlgorithmNumber == BUBBLESORT_NUMBER) {
            sorter = new BubbleSorter();
        } else if (sortingAlgorithmNumber == MERGESORT_NUMBER) {
            sorter = new MergeSorter();
        }
    }

    private void setSortOrder(int sortOrderNumber) {
        if (sortOrderNumber == ASCENDING_ORDER_NUMBER) {
            sorter.setAscendingOrder();
        } else if (sortOrderNumber == DESCENDING_ORDER_NUMBER) {
            sorter.setDescendingOrder();
        }
    }

    private void printSortedObjects(Object[] arr) {
        System.out.println("<Results>");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
