package tutorials.utils;

/**
 *  Utility functions 
 * 
 * @author J.Xu 
 *
 */

import java.util.List;
import java.util.Random; 

public class Array {

	private static final Random random = new Random();  
	
	public static <T extends Comparable<? super T>>
	void swap(T[] array, int p, int q){
		T tmp    = array[p]; 
		array[p] = array[q]; 
		array[q] = tmp ; 
	}
	
	
	public static int[] generateIntArray(int nelems){
		
		int[] elems = new int[nelems]; 
		for(int j=0;  j<nelems;  j++)
			elems[j] =  random.nextInt() % 100 ; 
		return elems; 
	}
	
	
	
	public static Integer[] generateBoxedIntArray(int nelems){
		
		Integer[] elems = new Integer[nelems]; 
		for(int j=0;  j<nelems;  j++) 
			elems[j] = random.nextInt() % 100; 
		return elems ; 
		
	}
	
	
	public static Float[] generateBoxedFloatArray(int nelems){
		
		Float[] elems = new Float[nelems]; 
		for(int j=0;  j<nelems;  j++) 
			elems[j] = random.nextFloat(); 
		return elems; 
	}
	

	public static Double[] generateBoxedDoubleArray(int nelems){
		
		Double[] elems = new Double[nelems]; 
		for(int j=0;  j<nelems;  j++) 
			elems[j] = random.nextDouble(); 
		return elems; 
	}
	
	
	
	public static <T extends Comparable<? super T>> 
	boolean isArraySorted(T[] array){

		for(int i=0; i<array.length; i++)
			for(int j=i+1; j<array.length; j++) 
				if( array[i].compareTo(array[j]) >0 )
					return false ; 
		
		return true ; 		
	}
	
	public static <T> String convertListToString( List<T> list){
		
		StringBuilder sb = new StringBuilder(); 
		sb.append("["); 
		int i;
		for(i=0; i<list.size()-1; i++)
			sb.append(list.get(i) + ", ");
		sb.append(list.get(i) + "]"); 
		
		return sb.toString() ; 
	}
	
}
