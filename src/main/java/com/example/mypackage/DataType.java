package com.example.mypackage;

import java.util.Scanner;

public interface DataType {
	Scanner scanner = new Scanner(System.in);

	String getSortedObjectType();

	Object takeObject();
}
