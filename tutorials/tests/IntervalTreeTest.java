package tutorials.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tutorials.trees.Interval;
import tutorials.trees.IntervalTree; 


public class IntervalTreeTest {

	@Test
	public void test() {

		Interval[] intervals = { new Interval(15,20), new Interval(10,30), new Interval(17,19), 
								 new Interval(5, 20), new Interval(12, 15), new Interval(30,40) }; 
		
		// O(n^2) solution 
		HashMap<Interval, List<Interval>> expectedOverlaps = new HashMap<Interval, List<Interval>>();
		for(int i=0;  i<intervals.length; i++){
			Interval current = intervals[i];
			List<Interval> overlaps = new ArrayList<Interval>(); 
			for(int j=0;  j<intervals.length; j++){
				if(j==i) 
					continue; 
				if(Interval.doOverlap(current, intervals[j]))
					overlaps.add(intervals[j]); 
			}
			expectedOverlaps.put(current, overlaps); 
		}
		
		
		// O(nlogn) solution 
		for(int i=0;  i<intervals.length; i++){
			Interval current = intervals[i];
			IntervalTree intervalTree = new IntervalTree(); 
			
			
			for(int j=0;  j<intervals.length; j++){
				if(j==i) 
					continue; 
				intervalTree.insert(intervals[j]);
			}
			
			List<Interval> actual = intervalTree.searchOverlaps(current); 
			List<Interval> expected = expectedOverlaps.get(current); 
			
			assertEquals(expected.size(), actual.size()); 
			Collections.sort(actual);
			Collections.sort(expected);
			
			Assert.assertTrue(actual.equals(expected)); 

		}
	}

}
