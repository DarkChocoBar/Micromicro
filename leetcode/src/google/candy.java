package google;

import java.util.Arrays;

public class candy {
	// using one array
	class Solution {
	    public int candy(int[] ratings) {
	        int[] candies = new int[ratings.length];
	        Arrays.fill(candies, 1);
	        
	        // 从左往右数，每当相邻两位的大小不相等，前一位比后一位小的时候，更新数字
	        // positive slope: +1
	        for (int i = 1; i < ratings.length; i++) {
	            int rat1 = ratings[i - 1];
	            int rat2 = ratings[i];
	            
	            if (rat1 < rat2) {
	                candies[i] = candies[i - 1] + 1;
	            }
	        }
	        
	        // 从右往左数，后一位比前一位小的时候，更新数字
	        //negative slope: +1;
	        int ans = candies[candies.length - 1];
	        for (int i = ratings.length - 2; i >= 0; i--) {
	            int rat1 = ratings[i + 1];
	            int rat2 = ratings[i];
	            
	            if (rat1 < rat2) {
	            	// 有可能会出现更新后的数字会让我们的准则破坏掉
	            	// 比如：
	            	// 1234211
	            	// 1234111
	            	// 1233211， 如果我们没有max的话，那这个是错误的，因为rating 4 比3大，我们需要给4更多糖果
	                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
	            }
	            ans += candies[i];
	        }
	        
	        return ans;
	    }
	}
	

	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[] rating = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
		System.out.println(sol.candy(rating));
	}
	
}

// wtf is this
class Solution2 {
	public Solution2() {
		
	}
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
            	System.out.println("updating candies at: " + i + ": case 1: " + (old_slope > 0 && new_slope == 0) + ", case 2: " + (old_slope < 0 && new_slope >= 0));
            	System.out.println("up has: " + count(up));
            	System.out.println("down has: " + count(down));
            	System.out.println("max has: " + Math.max(up, down));

            	// if up is 4, ( 1 + 2 + 3 + 4 ) = 10
            	// if down is 3, (1 + 2 + 3) = 6
            	// 再加上up和down的最大值                                       
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
