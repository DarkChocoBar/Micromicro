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
		        
		        //�����˼���ǣ����ǽ�start �� end�ֿ�������
		        // ����ÿ������start time С�� end time��ʱ��
		        // ˵�����ǲ���reuse meeting room�� һ��Ҫ����һ���µ�meetingroom
		        // �����ʱ�����Ǿ�count++��  i++
		        // ��������������Ļ��������Ľ�i++,j++�����б���
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
	        
	        //��������comparator�������ǣ�����pq���interval����ͨ������ǰinterval��end��ֵ��С�����������
	        // ˼·��
	        // ���ǽ�ԭarray sort֮�󣬱���
	        // �����ǿ���pq�е��������Ԫ�� ��peek��    ��end��ֵ�ȵ�ǰ�����е�Ԫ�ص�startֵС�������ǾͿ���ɾ���Ǹ�Ԫ�أ������뵱ǰ��interval
	        // ����һ��greedy ��˼�룬��Զ�ҵ�ǰ���������meeting��Ȼ���ٷ���һ��meeting
	        // ���Ĵ𰸾���pq�Ĵ�С��Ҳ��������meeting room���ж���
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
