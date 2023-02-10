package com.example.mypackage;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.mypackage.SharedFinalValue.*;

public class SortingProgram {

    Scanner scanner = new Scanner(System.in);

    DataType selectedType;
    Sorter sorter;
    Object[] arr;

    public void start() {
        while (true) {
            executeProgram();
        }
    }

    private void executeProgram() {
        System.out.println("자바 정렬 프로그램입니다.");

        selectedType = null;
        sorter = null;

        takeAndSetDataType();
        takeAndSetSortingAlgorithm();
        takeAndSetSortingOrder();
        takeArray();
        Object[] sortedArr = sorter.sort(arr);
        printSortedObjects(arr);
    }

    private int takeSelectionNumber() {
        System.out.print("> ");
        return scanner.nextInt();
    }

    private void takeAndSetDataType() {
        System.out.println(SharedFinalValue.SORTING_NUMBERS_NUMBER +". Sort numbers");
        System.out.println(SharedFinalValue.SORTING_WORDS_NUMBER +". Sort words");
        System.out.println(EXIT_NUMBER + ". Quit");

        int dataTypeNumber = takeSelectionNumber();

        switch (dataTypeNumber) {
            case SORTING_NUMBERS_NUMBER:
                selectedType = new NumberDataType();
                break;
            case SORTING_WORDS_NUMBER:
                selectedType = new WordDataType();
                break;
            case EXIT_NUMBER:
                System.exit(0);
                break;
        }
    }

    private void takeAndSetSortingAlgorithm() {
        System.out.println("Select a sorting algorithm");
        System.out.println(BUBBLESORT_NUMBER + ". Bubble sort");
        System.out.println(MERGESORT_NUMBER + ". Merge sort");

        int algorithmNumber = takeSelectionNumber();

        switch (algorithmNumber) {
            case BUBBLESORT_NUMBER:
                sorter = new BubbleSorter();
                break;
            case MERGESORT_NUMBER:
                sorter = new MergeSorter();
        }
    }

    private void takeAndSetSortingOrder() {
        System.out.println("Select the sort order");

        System.out.println(ASCENDING_ORDER_NUMBER + ". Ascending order");
        System.out.println(DESCENDING_ORDER_NUMBER + ". Descending order");

        int OrderNumber = takeSelectionNumber();

        switch (OrderNumber) {
            case ASCENDING_ORDER_NUMBER:
                sorter.setAscendingOrder();
                break;
            case DESCENDING_ORDER_NUMBER:
                break;
        }
    }

    private void takeArray() {
        String sortedObjectType = selectedType.getSortedObjectType();
        System.out.println("The "+ sortedObjectType +" to be sorted");
        System.out.print("> ");
        int NumberOfObjectsForSort = takeSelectionNumber();
        System.out.println("The number of "+ sortedObjectType +" to be sorted");
        System.out.print("> ");
        takeObjectsForSort(NumberOfObjectsForSort);
    }

    private void takeObjectsForSort(int NumberOfObjectsForSort) {
        arr = new Object[NumberOfObjectsForSort];
        Arrays.stream(arr).sorted();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = selectedType.takeObject();
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
