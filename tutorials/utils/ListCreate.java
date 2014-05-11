package tutorials.utils;

public class ListCreate {

	public static boolean isTwoListSame(ListNode first, ListNode second){
		
		if(first==null && second==null)
			return true; 
		
		if(first==null || second==null)
			return false; 
		
		return (first.value == second.value) && 
				isTwoListSame(first.next, second.next); 
	}
	
	
}
