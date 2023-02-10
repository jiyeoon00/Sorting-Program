package com.example.mypackage;

public class WordDataType implements DataType {
    @Override
    public String getSortedObjectType() {
        return "words";
    }

    @Override
    public Object takeObject() {
        return scanner.next();
    }
}
