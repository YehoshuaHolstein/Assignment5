package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		return add(size, item);
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
		}
		if (items.length == size) {
			resizeArray();
		}
		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = item;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
		}
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for length: " + items.length);
		}
		@SuppressWarnings("unchecked")
		T objectRemoved = (T) items[index];
		for (int i = index; i < size; i++) {
			items[i] = items[i + 1];
		}
		items[size] = null;
		size--;
		return objectRemoved;
	}
	
	private void resizeArray() {
		items = Arrays.copyOf(items, items.length * 2);
	}

}
