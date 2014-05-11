package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.list.SplitList;
import tutorials.utils.ListNode;
import tutorials.utils.ListCreate; 
import tutorials.utils._;

public class SplitListTest {
	
	
	public static void createOddLengthList(_<ListNode> head, _<ListNode> front, _<ListNode> tail){
		
		ListNode list   = new ListNode(6); 
		list.next       = new ListNode(5); 
		list.next.next  = new ListNode(4); 
		list.next.next.next  = new ListNode(3); 
		list.next.next.next.next  = new ListNode(2); 
		head.set(list); 
		
		ListNode frontList = new ListNode(6); 
		frontList.next = new ListNode(5);  
		frontList.next.next = new ListNode(4); 
		front.set(frontList); 
		
		
		ListNode tailList = new ListNode(3); 
		tailList.next = new ListNode(2);  
		tail.set(tailList); 
	}
	
	
	
	public static void createEvenLengthList(_<ListNode> head, _<ListNode> front, _<ListNode> tail){
		
		ListNode list   = new ListNode(6); 
		list.next       = new ListNode(5); 
		list.next.next  = new ListNode(4); 
		list.next.next.next  = new ListNode(3); 
		head.set(list);  
		
		ListNode frontList = new ListNode(6); 
		frontList.next = new ListNode(5);  
		front.set(frontList); 
		
		
		ListNode tailList = new ListNode(4); 
		tailList.next = new ListNode(3);  
		tail.set(tailList); 
	}
		
	
	
	@Test
	public void testSplitNullList() {
			
		ListNode head = null ; 
		_<ListNode> front = new _<ListNode>(); 
		_<ListNode> tail  = new _<ListNode>(); 
		
		SplitList.split(head, front, tail);  
		assertTrue(front.value()==null); 
		assertTrue(tail.value()==null); 
	}
	
	
	
	
	@Test
	public void testSplitEvenList() {
			
		_<ListNode> head  = new _<ListNode>(); 
		
		_<ListNode> expectedFront = new _<ListNode>(); 
		_<ListNode> expectedTail  = new _<ListNode>(); 
		_<ListNode> actualFront = new _<ListNode>(); 
		_<ListNode> actualTail  = new _<ListNode>(); 
		
		createEvenLengthList(head, expectedFront, expectedTail); 
		SplitList.split(head.value(), actualFront, actualTail);  
		

		assertTrue(ListCreate.isTwoListSame(expectedFront.value(), actualFront.value())); 
		assertTrue(ListCreate.isTwoListSame(expectedTail.value(), actualTail.value())); 
	}
	
	
	
	
	@Test
	public void testSplitOddList() {
			
		_<ListNode> head  = new _<ListNode>(); 
		
		_<ListNode> expectedFront = new _<ListNode>(); 
		_<ListNode> expectedTail  = new _<ListNode>(); 
		_<ListNode> actualFront = new _<ListNode>(); 
		_<ListNode> actualTail  = new _<ListNode>(); 
		
		createOddLengthList(head, expectedFront, expectedTail); 
		SplitList.split(head.value(), actualFront, actualTail);  
		
		assertTrue(ListCreate.isTwoListSame(expectedFront.value(), actualFront.value())); 
		assertTrue(ListCreate.isTwoListSame(expectedTail.value(), actualTail.value())); 
	}
	
	
	
	
	@Test
	public void testSingletonList() {
			
		ListNode head = new ListNode(1); 
		_<ListNode> actualFront = new _<ListNode>(); 
		_<ListNode> actualTail  = new _<ListNode>(); 
		
		SplitList.split(head, actualFront, actualTail);  
		ListNode expectedFront = head ; 
		ListNode expectedTail = null ;
		
		assertTrue(ListCreate.isTwoListSame(expectedFront, actualFront.value())); 
		assertTrue(ListCreate.isTwoListSame(expectedTail, actualTail.value())); 
	}
	
	
	
	
	

}
