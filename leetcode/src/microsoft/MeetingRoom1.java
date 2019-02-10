package microsoft;

import java.util.Arrays;
import java.util.Comparator;

//252
public class MeetingRoom1 {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	
	  public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	  
	class Solution {

		// overwrite comparator下的compare方法，这样我们就可以通过开始时间得到sort后的array
	    public boolean canAttendMeetings(Interval[] intervals) {
	        Arrays.sort(intervals, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return i1.start - i2.start;
	            }
	        });
	        
	        // 之后我们就检查相邻的interval有没有重叠
	        // 如果第一个interval的结束时间大于第二个interval的开始时间，说明有冲突
	        
	        for (int i = 0; i < intervals.length - 1; i++) {
	            if (intervals[i].end > intervals[i+1].start) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
