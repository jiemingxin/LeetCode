package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.GroupsOfOne;

public class GroupsOfOneTest {

	@Test
	public void testCountGroupsCase1() {
		
		int[][] matrix = {  {1, 1, 0, 0, 1}, 
				            {1, 0, 0, 1, 0},
				            {1, 1, 0, 1, 0},
				            {0, 0, 1, 0, 0} }; 
		int expected = 4 ; 
		int actual   = GroupsOfOne.countGroups(matrix);  
		assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testCountGroupsCase2() {
		
		int[][] matrix = {  {1, 1, 1, 0, 1}, 
				            {1, 1, 1, 1, 0},
				            {1, 1, 0, 1, 0},
				            {0, 0, 1, 0, 0} }; 
		int expected = 3 ; 
		int actual   = GroupsOfOne.countGroups(matrix);  
		assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testCountGroupsCase3() {
		
		int[][] matrix = {  {1, 1, 1, 0, 1}, 
				            {1, 1, 1, 1, 0},
				            {1, 1, 1, 1, 0},
				            {0, 0, 1, 0, 0} }; 
		int expected = 2 ; 
		int actual   = GroupsOfOne.countGroups(matrix);  
		assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testCountGroupsCase4() {
		
		int[][] matrix = {  {1, 1, 1, 1, 1}, 
				            {1, 1, 1, 1, 0},
				            {1, 1, 1, 1, 0},
				            {0, 0, 1, 0, 0} }; 
		int expected = 1 ; 
		int actual   = GroupsOfOne.countGroups(matrix);  
		assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testCountGroupsCase5() {
		
		int[][] matrix = {  {1, 0} , 
				            {0, 1},
				            {1, 0},
				            {0, 1} }; 
		int expected = 4 ; 
		int actual   = GroupsOfOne.countGroups(matrix);  
		assertEquals(expected, actual); 
	}
	
	
	

}
