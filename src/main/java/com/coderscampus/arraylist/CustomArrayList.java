package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		if (items[items.length - 1] != null) {
			resizeArray();
		}
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
        }
		return (T) items[index];
	}
		 
	public void resizeArray() {
//		Object[] moreItems = new Object[items.length * 2];
//		for (int i = 0; i < items.length; i++) {
//			moreItems[i] = items[i];
//		}
//		System.out.println("Array increased to length: " + moreItems.length);
//		items = moreItems;
		
		items = Arrays.copyOf(items, items.length * 2);
		
	}

}
