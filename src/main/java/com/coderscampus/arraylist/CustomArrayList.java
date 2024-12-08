package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		boolean updateSuccess = false;
		
		if (items[items.length - 1] != null) {
			Object[] items = increaseArraySizeIfNeeded();
		}
		
		items[size] = item;
		size++;
		
		return updateSuccess = true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		try {
			return (T) items[index];
		} catch (IndexOutOfBoundsException e) {
		    System.out.println(e.getMessage());
		}
		return null;
	}

	public Object[] increaseArraySizeIfNeeded() {
		int arraySize = items.length;
		Object[] moreItems = new Object[arraySize * 2];
		for (int i = 0; i < items.length; i++) {
			moreItems[i] = items[i];
		}
		System.out.println("Array increased to length: " + moreItems.length);
		return items = moreItems;
	}

}
