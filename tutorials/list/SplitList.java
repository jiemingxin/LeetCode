package tutorials.list;

/**
 * 
 * http://leetcode.com/2010/09/splitting-linked-list.html 
 * 
 * Given a list, split it into two sublists ¡ª one for the front half, 
 * and one for the back half. If the number of elements is odd, the
 *  extra element should go in the front list. So FrontBackSplit() 
 * on the list {2, 3, 5, 7, 11} should yield the two lists {2, 3, 5}
 * and {7, 11}.
 * 
 * 
 * It is easier to come up with a linear time algorithm. The web site
 * gives an interesting algorithm, which keeps two pointers, namely
 * a fast one, and a slow one. 
 * 
 * 
 * @author endeavour
 *
 */

import tutorials.utils.*; 


public class SplitList {
	
	
	public static void split(ListNode head, _<ListNode> front, _<ListNode> tail) 
	{
		if(head == null){
			front.set(null);
			tail.set(null);
			return; 			
		}

		// this solution keeps two pointers, one is fast, and the other is slow 
		ListNode fast = head; 
		ListNode slow = head; 
		ListNode frontListLastNode = null ; 
		while(fast!= null){ 
			
			// advance the 'fast' pointer by two steps 
			fast = fast.next!=null? fast.next.next: null ; 
			
			// advance the 'slow' pointer by one step 
			frontListLastNode = slow; 
			slow = slow.next ; 
		}
		
		frontListLastNode.next = null ; 
		front.set(head);
		tail.set(slow); 
	}
	
}
