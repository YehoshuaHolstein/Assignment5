package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomListApplication {

	public static void main(String[] args) {
		CustomList<String> myCustomList = new CustomArrayList<>();
		for (int i = 0; i < 52; i++) {
			boolean elementAdd = myCustomList.add("element " + i);
			System.out.println("Added element: " + i + " result: " + elementAdd);
		}
		System.out.println("Total number of elements in array: " + myCustomList.getSize());
		for(int i = 0; i < myCustomList.getSize(); i++)	{
			System.out.println(myCustomList.get(i));
		}
	}
}
