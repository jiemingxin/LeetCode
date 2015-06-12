package tutorials.trees;

/**
 *  This class defines the interval data structure which
 *  will be used by the Interval Tree class 
 * 
 * @author orthogonal
 *
 */
public class Interval implements Comparable<Interval> {
	
	public int low, high ; 
	
	
	public Interval(int low, int high){
		this.low = low; 
		this.high = high; 
	}
	
	public Interval(Interval interval){
		this.low = interval.low ; 
		this.high = interval.high ;  
	}
	
	
	
	public static boolean doOverlap(Interval i1, Interval i2){
		
		if (i1.low < i2.low)
			return i2.low <= i1.high ;
		else
			return i1.low <= i2.high ;
		
	}


	@Override
	public int compareTo(Interval interval) {
		
		 // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
		if( low < interval.low )
			return -1; 
		
		if( low == interval.low)
			return 0; 
		
		return 1;
	}
	

}
