package tutorials.list;

import tutorials.utils.ListNode;
import tutorials.utils._;


/**
 * Implement the reversal of a singly linked list iteratively and recursively. 
 * Note that the reversal is inplace reversal. 
 * 
 * http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html 
 * 
 * @author endeavour
 *
 */
public class ListReversal {

	
	
	public static void reverseIterative(_<ListNode> list){
			
		if( list.value() == null)
			return ; 
				
		ListNode prev = null ; 	
		ListNode curr = list.value() ; 
		while( curr!=null){
			 ListNode next = curr.next ; 
			 curr.next = prev ; 
			 prev = curr ; 
			 curr = next ; 
		}
		list.set(prev); 
	}
	
	
	
	
	public static void reverseRecursive(_<ListNode> list){
		
		if( list.value() == null )
			return ; 
		
		ListNode head = list.value(); 
		ListNode rest = head.next ; 
		if(rest==null)  // a singular list 
			return ; 
		
		_<ListNode> reversed = new _<ListNode>(rest); 
		reverseRecursive( reversed ); 
		head.next.next = head ; 
		head.next = null ; 
		list.set(reversed.value()); 
	} 

		
	
	
}
