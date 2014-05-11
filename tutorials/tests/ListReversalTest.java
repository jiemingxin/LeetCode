package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.list.ListReversal;
import tutorials.utils.ListCreate;
import tutorials.utils.ListNode;
import tutorials.utils._;

public class ListReversalTest {


	public static void createOddLengthList(_<ListNode> head, _<ListNode> reversed){
		
		ListNode list   = new ListNode(6); 
		list.next       = new ListNode(5); 
		list.next.next  = new ListNode(4); 
		list.next.next.next  = new ListNode(3); 
		list.next.next.next.next  = new ListNode(2); 
		head.set(list); 
		
		ListNode rlist   = new ListNode(2); 
		rlist.next       = new ListNode(3); 
		rlist.next.next  = new ListNode(4); 
		rlist.next.next.next  = new ListNode(5); 
		rlist.next.next.next.next  = new ListNode(6); 
		reversed.set(rlist); 
	}
	
	
	
	
	public static void createEvenLengthList(_<ListNode> head, _<ListNode> reversed){
		
		ListNode list   = new ListNode(6); 
		list.next       = new ListNode(5); 
		list.next.next  = new ListNode(4); 
		list.next.next.next  = new ListNode(3); 
		head.set(list); 
		
		ListNode rlist   = new ListNode(3); 
		rlist.next       = new ListNode(4); 
		rlist.next.next  = new ListNode(5); 
		rlist.next.next.next  = new ListNode(6); 
		reversed.set(rlist); 
	}
	
	
	
	
	public static void createSingularList(_<ListNode> head, _<ListNode> reversed){
		
		ListNode list   = new ListNode(6); 
		head.set(list); 
		
		ListNode rlist   = new ListNode(6); 
		reversed.set(rlist); 
	}
	
	
	
	
	@Test
	public void testReverseIterativeNullCase() {
		
		_<ListNode> head = new _<ListNode>(); 
		ListReversal.reverseIterative(head); 
		assertTrue(head.value() == null); 
	}

	
	@Test
	public void testReverseIterativeSingularList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createSingularList(head, reversed); 
		
		ListReversal.reverseIterative(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	@Test
	public void testReverseIterativeListEvenLengthList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createEvenLengthList(head, reversed); 

		ListReversal.reverseIterative(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	@Test
	public void testReverseIterativeListOddLengthList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createOddLengthList(head, reversed); 
		
		ListReversal.reverseIterative(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	
	@Test
	public void testReverseRecurisveNullCase() {
		
		_<ListNode> head = new _<ListNode>(); 
		ListReversal.reverseRecursive(head); 
		assertTrue(head.value() == null); 
	}

	
	@Test
	public void testReverseRecursiveSingularList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createSingularList(head, reversed); 
		
		
		
		ListReversal.reverseRecursive(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	@Test
	public void testReverseRecursiveListEvenLengthList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createEvenLengthList(head, reversed); 

		ListReversal.reverseRecursive(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	
	@Test
	public void testReverseRecursiveListOddLengthList() {
				
		_<ListNode> head = new _<ListNode>();  
		_<ListNode> reversed = new _<ListNode>();  
		createOddLengthList(head, reversed); 
		
		ListReversal.reverseRecursive(head);
		assertTrue( ListCreate.isTwoListSame(head.value(), reversed.value())); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
