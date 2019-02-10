package microsoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 253
public class MeetingRoom2 {
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
	 
	  // solution 1
	  // nlogn  n
	  class Solution {
		    public int minMeetingRooms(Interval[] intervals) {
		        int[] startArr = new int[intervals.length];
		        int[] endArr = new int[intervals.length];
		        
		        for (int i = 0; i < intervals.length; i++) {
		            startArr[i] = intervals[i].start;
		            endArr[i] = intervals[i].end;
		        }
		        
		        // nlogn
		        Arrays.sort(startArr);
		        Arrays.sort(endArr);
		        
		        // pointers
		        int i = 0;
		        int j = 0;
		        int count = 0;
		        
		        //这里的思想是，我们将start 和 end分开来看，
		        // 我们每次遇到start time 小于 end time的时候
		        // 说明我们不能reuse meeting room， 一定要分配一个新的meetingroom
		        // 那这个时候我们就count++，  i++
		        // 如果不是这个情况的话，单纯的将i++,j++，进行遍历
		        while (i < intervals.length && j < intervals.length) {
		            if (startArr[i] < endArr[j]) {
		                count++;
		                i++;
		                continue;
		            }
		            
		            if (startArr[i] >= endArr[j]) {
		                i++;
		                j++;
		                continue;
		            }
		        }
		        
		        return count;
		    }
		}
	  
	  
	  
	  // solution 1:
	  // nlogn n
	  // we use a PRIORITY QUEUE to fix the problem
	class Solution2 {
	    public int minMeetingRooms(Interval[] intervals) {
	        if (intervals.length == 0) {
	            return 0;
	        }
	        
	        //这样定义comparator的作用是，我们pq里的interval都是通过他当前interval的end数值从小到大来排序的
	        // 思路：
	        // 我们将原array sort之后，遍历
	        // 当我们看到pq中的最上面的元素 （peek）    的end的值比当前遍历中的元素的start值小，那我们就可以删掉那个元素，并加入当前的interval
	        // 这是一种greedy 的思想，永远找当前最早结束的meeting，然后再分配一个meeting
	        // 最后的答案就是pq的大小，也就是我们meeting room会有多少
	        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return i1.end - i2.end;
	            }
	        });
	        
	        Arrays.sort(intervals, new Comparator<Interval>() {
	            public int compare(Interval i1, Interval i2) {
	                return i1.start - i2.start;
	            }
	        });
	        
	        pq.add(intervals[0]);
	        
	        for (int i = 1; i < intervals.length; i++) {
	            if (pq.peek().end <= intervals[i].start) {
	                pq.poll();
	                pq.add(intervals[i]);
	            } else {
	                pq.add(intervals[i]);
	            }
	        }
	        
	        return pq.size();
	    }
	}
}
