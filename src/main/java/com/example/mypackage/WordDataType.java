package com.example.mypackage;

import java.util.Scanner;

public class WordDataType implements DataType {
    @Override
    public String getSortedObjectType() {
        return "words";
    }

    @Override
    public Object takeObject(Scanner scanner) {
        return scanner.next();
    }
}
