package clrs.ch7;

import java.util.Arrays;

import org.apache.log4j.Logger;

import tutorials.utils.Array;

/**
 *  This class implements the Quicksort algorithm
 *
 * @author J. Xu
 * @since  Mar 09, 2013
 */

public class QuickSort {

	private static final Logger logger = Logger.getLogger( QuickSort.class );

	/**
	 *  Quick sort the array, both indices are inclusive
	 *
	 * @param array
	 * @param begin
	 * @param end
	 */
	public static <T extends Comparable<? super T>>
	void quickSort(T[] array, int begin, int end){

		if( begin < end ){
			int index = partition(array, begin, end);
			//int index  = partition2(array, begin, end);
			quickSort(array, begin, index-1);
			quickSort(array, index+1, end);
		}
	}


	public static <T extends Comparable<? super T>>
	int partition(T[] array, int begin, int end){

		logger.debug("Begin = " + begin + ", End =" + end);

		T pivot  = array[end];
		int   i  = begin - 1;
		for(int j=begin;  j<end;  j++){
			if( array[j].compareTo(pivot) <= 0  ){
				i++;
				Array.swap(array, i, j);
			}
			logger.debug("Pivot = (" + pivot + "), i=(" + i + "), j=(" + j + ") :" + Arrays.toString(array));
		}

		Array.swap(array, i+1, end);
		logger.debug(" Swap [" + (i+1) + "] and [" + end +"] :" + Arrays.toString(array));
		logger.debug(" Return index = " + (i+1));

		return (i+1);
	}



	public static <T extends Comparable<? super T>>
	int partition2(T[] array, int begin, int end){

		logger.debug("Begin = " + begin + ", End = " + end);
		T pivot 	= array[end];
		int left  	= begin ;
		int right 	= end - 1;
		logger.debug("Left = "  + left + ",  End = " + right);
		do{
			while( left  < end-1 && array[left].compareTo(pivot)  <= 0 ) left ++ ;
			while( right >=0     && array[right].compareTo(pivot) > 0  ) right--;

			logger.debug("Pivot = (" + pivot + "), Left=(" + left + "), Right=(" + right + ") :" + Arrays.toString(array));
			if( left < right ){
				Array.swap(array, left, right);
				logger.debug("Swap (" + left + ") and (" + right +")" );
			}else
				break ;
		}while(true);
		Array.swap(array, right+1, end);
		return (right+1) ;
	}



	protected static void testQuickSort(){

		int nelems     = 10;
		int iterations = 12;

		for(int i=0;   i<iterations;  i++){

			switch(i%3){
				case 0:
					Integer[] intArray = Array.generateBoxedIntArray(nelems);
					logger.debug("INPUT  = " + Arrays.toString(intArray));
					QuickSort.quickSort(intArray, 0, intArray.length-1);
					logger.debug("SORTED = " + Arrays.toString(intArray));
					logger.info("Iterations [" + i + "] isSORTED = " + Array.isArraySorted(intArray) );

					break;
				case 1:
					Float[] floatArray = Array.generateBoxedFloatArray(nelems);
					logger.debug("INPUT  = " + Arrays.toString(floatArray));
					QuickSort.quickSort(floatArray, 0, floatArray.length-1);
					logger.debug("SORTED = " + Arrays.toString(floatArray));
					logger.info("Iterations [" + i + "] isSORTED = " + Array.isArraySorted(floatArray) );

					break;
				default:
					Double[] doubleArray = Array.generateBoxedDoubleArray(nelems);
					logger.debug("INPUT  = " + Arrays.toString(doubleArray));
					QuickSort.quickSort(doubleArray, 0, doubleArray.length-1);
					logger.debug("SORTED = " + Arrays.toString(doubleArray));
					logger.info("Iterations [" + i + "] isSORTED = " +  Array.isArraySorted(doubleArray) );
					break;
			}

		}
	}



	public static void main(String[] args){
		QuickSort.testQuickSort();

	}



}
