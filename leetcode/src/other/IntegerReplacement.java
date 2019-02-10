package other;

// leetcode 397
public class IntegerReplacement {
	class Solution {
	    public int integerReplacement(int n) {
	        if (n == 1) {
	            return 0;
	        }

	        return findSteps(n);
	    }
	    
	    public int findSteps(int i) {
	        if (i <= 1) {
	            return 0;
	        }
	        
	        if (i % 2 == 0) {
	            return 1 + findSteps(i/2);
	        } else {
	        	// use 1 + (i - 1) / 2 to avoid overflow problem, also, this is doing even number divided by 2 already, so plus one step
 	            return 1 + Math.min(findSteps(1 + (i - 1) / 2) + 1, findSteps(i - 1));
	        }
	    }
	}
}
