package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private static int addMethodCallCount = 0;

	@Override
	public boolean add(T item) {
		boolean updateSuccess = false;
		
		if (items[items.length - 1] != null) {
			Object[] items = increaseArraySizeIfNeeded();
		}
		
		items[addMethodCallCount] = item;
		addMethodCallCount++;
		
		return updateSuccess = true;
	}

	@Override
	public int getSize() {
		return addMethodCallCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index >= 0 && index <= items.length) {
			return (T) items[index];
		} else {
			return (T)("Index value: " + index + " not valid");
		}
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
