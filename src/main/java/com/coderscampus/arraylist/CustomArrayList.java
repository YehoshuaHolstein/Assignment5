package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		if (items.length == size) {
			resizeArray();
		}
		items[size++] = item;
		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (items.length == size) {
			resizeArray();
		}
		for (int i = size; i >= index; i--) {
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
	public T get(int index) {
		return (T) items[index];
	}

	public void resizeArray() {
		items = Arrays.copyOf(items, items.length * 2);
	}

	public T remove(int index) throws IndexOutOfBoundsException {
		@SuppressWarnings("unchecked")
		T object_removed = (T) items[index];
		for (int i = index; i < size; i++) {
			items[i] = items[i + 1];
		}
		size--;
		return object_removed;
	}

}
