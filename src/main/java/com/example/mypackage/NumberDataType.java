package com.example.mypackage;

import java.util.Scanner;

public class NumberDataType implements DataType {
    @Override
    public String getSortedObjectType() {
        return "numbers";
    }

    @Override
    public Object takeObject(Scanner scanner) {
        return scanner.nextInt();
    }
}
