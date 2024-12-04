package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];

	@Override
	public boolean add(T item) {
		boolean updateSuccess = false;
		if (items == null) {
			items[0] = item;
			updateSuccess = true;
		} else if (items[items.length - 1] != null) {
			Object[] items = increaseArraySizeIfNeeded();
		}
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				updateSuccess = true;
				break;
			} else {
				continue;
			}
		}
		return updateSuccess;
	}

	@Override
	public int getSize() {
		int elementsCount = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				elementsCount++;
			} else {
				continue;
			}
		}
		return elementsCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];
	}

	public Object[] increaseArraySizeIfNeeded() {
		int arraySize = items.length;
		Object[] moreItems = new Object[arraySize * 2];
		for (int i = 0; i < items.length; i++) {
			moreItems[i] = items[i];
		}
		items = moreItems;
		return items;
	}

}
