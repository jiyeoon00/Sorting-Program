package com.example.mypackage;

import java.util.Comparator;

public abstract class Sorter {
    Comparator comparator = Comparator.naturalOrder();

    public abstract Object[] sort(Object[] arr);

    public void setAscendingOrder() {
        comparator = Comparator.reverseOrder();
    }
}
