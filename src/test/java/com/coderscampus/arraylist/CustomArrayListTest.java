package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-Driven Development Methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass
	// Step 3 - Refactor your code
	
	@Test
	void should_add_one_item_to_list() {
		// Three A's
		// Arrange, Act, Assert
		
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		sut.add(10);
		Integer expected_Result_for_add_1_item = sut.get(0);
		Integer expected_Size_for_add_1_item = sut.getSize();
		
		// Assert
		// What would we expect to happen?
		// I expect there to be an Integer with value 10 stored in the first
		// index in my customList
		assertEquals(10, expected_Result_for_add_1_item);
		assertEquals(1, expected_Size_for_add_1_item);			
	}
	
	@Test
	void should_add_11_items_to_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i=1; i<=11; i++) {
			sut.add(i);
		}
		
		// Assert
		for (int i=0; i<11; i++) {
			assertEquals(i+1, sut.get(i));
		}
		assertEquals(11, sut.getSize());		
	}
	
	@Test
	void should_add_100000_items_to_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i=1; i<=100000; i++) {
			sut.add(i);
		}
		
		// Assert
		for (int i=0; i<99999; i++) {
			assertEquals(i+1, sut.get(i));
		}
		assertEquals(100000, sut.getSize());		
	}
	
	@Test
	void should_add_one_item_at_specific_index_in_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		sut.add(4, 999);
		Integer expected_Result_for_add_1_item_at_index = sut.get(4);
		Integer expected_Result_for_add_1_item_at_next_index = sut.get(5);
		Integer expected_Size_for_add_1_item_at_index = sut.getSize();
		
		// Assert
		assertEquals(999, expected_Result_for_add_1_item_at_index);
		assertEquals(5, expected_Result_for_add_1_item_at_next_index);
		assertEquals(20, expected_Size_for_add_1_item_at_index);
		
		
	}

}
