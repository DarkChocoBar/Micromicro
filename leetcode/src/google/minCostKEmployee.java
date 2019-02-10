package google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minCostKEmployee {
	class Solution {
	    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
	        if (K > quality.length) {
	            return 0.0;
	        }
	        
	        Worker[] workerList = new Worker[quality.length];
	        PriorityQueue<Integer> qualityPQ = new PriorityQueue<Integer>(); 
	        for (int i = 0; i < quality.length; i++) {
	            int q = quality[i];
	            int w = wage[i];
	            double e = w / (double) q;
	            workerList[i] = new Worker(q,w,e,i);
	        }
	        
	        Arrays.sort(workerList);
	        double ans = Double.MAX_VALUE;
	        int sumOfQ = 0;
	        for (int i = 0; i < workerList.length; i++) {
	            qualityPQ.add(-workerList[i].quality);
	            sumOfQ += workerList[i].quality;
	            if (qualityPQ.size() > K) {
	                sumOfQ += qualityPQ.poll();
	            }
	            if (qualityPQ.size() == K) {
	                ans = Math.min(ans, sumOfQ * workerList[i].e);
	            }
	        }
	        return ans;        
	    }
	     
	    class Worker implements Comparable<Worker>{
	        int quality;
	        int wage;
	        double e;
	        int index;
	        
	        public Worker(int quality, int wage, double e, int index) {
	            this.quality = quality;
	            this.wage = wage;
	            this.e = e;
	            this.index = index;
	        }
	        
	        public int compareTo(Worker other) {
	            return Double.compare(this.e, other.e);
	        }
	    }
	}
}
