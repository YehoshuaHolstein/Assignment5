package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_one_item_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		sut.add(10);
		Integer expectedResultForAdd1Item = sut.get(0);
		Integer expectedSizeForAdd1Item = sut.getSize();
		sut.add(null);
		Integer expectedResultForAddNull = sut.get(1);
		Integer expectedSizeForAddNull = sut.getSize();

		// Assert
		assertEquals(10, expectedResultForAdd1Item);
		assertEquals(1, expectedSizeForAdd1Item);
		assertNull(expectedResultForAddNull);
		assertEquals(2, expectedSizeForAddNull);
	}

	@Test
	void should_add_11_items_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		for (int i = 1; i <= 11; i++) {
			sut.add(i);
		}

		// Assert
		for (int i = 0; i < 11; i++) {
			assertEquals(i + 1, sut.get(i));
		}
		assertEquals(11, sut.getSize());
	}

	@Test
	void should_add_100000_items_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		for (int i = 1; i <= 100000; i++) {
			sut.add(i);
		}

		// Assert
		for (int i = 0; i < 99999; i++) {
			assertEquals(i + 1, sut.get(i));
		}
		assertEquals(100000, sut.getSize());
	}

	@Test
	void should_add_one_item_at_specific_index_in_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 11; i++) {
			sut.add(i);
		}

		// Act
		sut.add(4, 999);
		Integer expectedResultForAdd1ItemAtIndex4 = sut.get(4);
		Integer expectedResultForAdd1ItemAtIndex5 = sut.get(5);
		Integer expectedSizeForAdd1IItemAtIndex = sut.getSize();
		sut.add(11, 888);
		Integer expectedResultForAdd1ItemAtEndIndex = sut.get(11);
		Integer expectedResultForAdd1ItemAtIndexEnd = sut.get(12);
		Integer expectedSizeForAddItemAtEndIndex = sut.getSize();
		sut.add(0, null);
		Integer expectedResultForAddNullAtIndex0 = sut.get(0);
		Integer expectedSizeForAddNullAtIndex0 = sut.getSize();

		// Assert
		assertEquals(999, expectedResultForAdd1ItemAtIndex4);
		assertEquals(5, expectedResultForAdd1ItemAtIndex5);
		assertEquals(12, expectedSizeForAdd1IItemAtIndex);
		assertEquals(888, expectedResultForAdd1ItemAtEndIndex);
		assertEquals(11, expectedResultForAdd1ItemAtIndexEnd);
		assertEquals(13, expectedSizeForAddItemAtEndIndex);
		assertNull(expectedResultForAddNullAtIndex0);
		assertEquals(14, expectedSizeForAddNullAtIndex0);

	}

	@Test
	void should_remove_item_at_specified_index() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 11; i++) {
			sut.add(i);
		}

		// Act
		sut.remove(4);
		Integer expectedResultForRemoveItemAtIndex4 = sut.get(4);
		Integer expectedResultForRemoveItemAtIndex5 = sut.get(5);
		Integer expectedSizeAfterRemoveItemAtIndex = sut.getSize();
		sut.remove(9);                  
		Integer expectedResultForRemoveItemAtEndIndex = sut.get(8);
		Integer expectedResultForRemoveItemAt2ndlastIndex = sut.get(7);
		Integer expectedSizeAfterRemoveItemAtEndindex = sut.getSize();

		// Assert
		assertEquals(6, expectedResultForRemoveItemAtIndex4);
		assertEquals(7, expectedResultForRemoveItemAtIndex5);
		assertEquals(10, expectedSizeAfterRemoveItemAtIndex);
		assertEquals(10, expectedResultForRemoveItemAtEndIndex);
		assertEquals(9, expectedResultForRemoveItemAt2ndlastIndex);
		assertEquals(9, expectedSizeAfterRemoveItemAtEndindex);

	}
	
	@Test
	void should_throw_exception_when_try_to_add_item_at_index_out_of_bounds() {
		// Arrange
		CustomList<String> sut = new CustomArrayList<>();
		for (int i = 1; i <= 10; i++) {
			sut.add("item" + i);
		}
		
		// Act and Assert
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(11, "out of bounds item (too big)"));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(-1, "out of bounds item (negative)"));
		
	}
	
	@Test
	void should_throw_exception_when_try_to_get_item_at_index_out_of_bounds() {
		// Arrange
		CustomList<String> sut = new CustomArrayList<>();
		for (int i = 1; i <= 10; i++) {
			sut.add("item" + i);
		}
				
		// Act and Assert
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(11));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
				
		
	}

	@Test
	void should_throw_exception_when_try_to_remove_item_at_index_out_of_bounds() {
		// Arrange
		CustomList<String> sut = new CustomArrayList<>();
		for (int i = 1; i <= 10; i++) {
			sut.add("item" + i);
		}
				
		// Act and Assert
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(11));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-1));
				
		
	}
}
