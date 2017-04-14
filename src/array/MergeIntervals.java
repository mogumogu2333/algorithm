package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//
//class Interval {
//     int start;
//     int end;
//     Interval() { start = 0; end = 0; }
//     Interval(int s, int e) { start = s; end = e; 
//  
//     }
//}


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<>();
		if(intervals==null || intervals.size()==0)return ret;
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		Interval prev = null;
		for(Interval cur:intervals){
			if(prev==null)prev = cur;
			else if(prev.end>=cur.start && prev.end <=cur.end){
				prev.end =cur.end;
			}
			else if(prev.end < cur.start){
				ret.add(prev);
				prev = cur;
			}
		}
		ret.add(prev);
        return ret;
    }
}
