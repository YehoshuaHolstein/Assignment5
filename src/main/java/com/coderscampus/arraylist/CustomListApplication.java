package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomListApplication {

	public static void main(String[] args) {
		CustomList<String> myCustomList = new CustomArrayList<>();
		for (int i = 0; i < 52; i++) {
			boolean elementAdd = myCustomList.add("element " + i);
		}
		System.out.println("Total number of elements in array: " + myCustomList.getSize());
		for(int i = 0; i < myCustomList.getSize(); i++)	{
			System.out.println("i = " + i + " " + myCustomList.get(i));
		}
		System.out.println(myCustomList.get(-1));
		System.out.println(myCustomList.get(100));
	}
}
