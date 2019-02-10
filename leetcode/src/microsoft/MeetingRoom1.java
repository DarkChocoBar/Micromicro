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

		// overwrite comparator�µ�compare�������������ǾͿ���ͨ����ʼʱ��õ�sort���array
	    public boolean canAttendMeetings(Interval[] intervals) {
	        Arrays.sort(intervals, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return i1.start - i2.start;
	            }
	        });
	        
	        // ֮�����Ǿͼ�����ڵ�interval��û���ص�
	        // �����һ��interval�Ľ���ʱ����ڵڶ���interval�Ŀ�ʼʱ�䣬˵���г�ͻ
	        
	        for (int i = 0; i < intervals.length - 1; i++) {
	            if (intervals[i].end > intervals[i+1].start) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
