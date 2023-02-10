package com.example.mypackage;

public class NumberDataType implements DataType {
    @Override
    public String getSortedObjectType() {
        return "numbers";
    }

    @Override
    public Object takeObject() {
        return scanner.nextInt();
    }
}
