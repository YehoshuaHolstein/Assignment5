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
	
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index >= items.length) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
		} 
		Object[] new_items = new Object[items.length + 1];
		for (int i = 0; i < index; i++) {
			new_items[i] = items[i];
		}
		new_items[index] = item;
		for (int i = index; i < items.length; i++) {
			new_items[i + 1] = items[i];
		}
		items = new_items;
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
		items = Arrays.copyOf(items, items.length * 2);
		
	}
	
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
		}
		Object toberemoved = items[index];
		for (int i = index; i <= items.length; i++) {
			items[index] = items[index + 1];
		}
		items[items.length - 1] = null;
		return (T) toberemoved;
		
	}

}
