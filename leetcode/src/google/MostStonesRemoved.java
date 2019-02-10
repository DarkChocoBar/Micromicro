package google;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

// 947

public class MostStonesRemoved {
	class Solution {
		  public int removeStones(int[][] stones) {
		        Map<Integer, HashSet<Integer>> rmap = new HashMap<>();
		        Map<Integer, HashSet<Integer>> cmap = new HashMap<>();
		        
		        for (int i = 0; i < stones.length; i++) {
		        	// x y 坐标
		            int r = stones[i][0];
		            int c = stones[i][1];
		            
		            
		            // 将和r对应的c放到对应的set中，之后找重复会用到
		            if (!rmap.containsKey(r)) {
		                rmap.put(r, new HashSet<Integer>());
		            }
		            
		            // 同理
		            if (!cmap.containsKey(c)) {
		                cmap.put(c, new HashSet<Integer>());
		            }
		            
		            rmap.get(r).add(c);
		            cmap.get(c).add(r);
		        }
		        
		        int count = 0;
		        
		        
		        // set用于记录看到过的点坐标
		        Set<String> set = new HashSet<>();
		        for (int i = 0; i < stones.length; i++) {
		            int r = stones[i][0];
		            int c = stones[i][1];
		            
		            
		            String s = r + "," + c;
		            
		            // 这个算法的corner case要注意
		            // 每次在看一个点的时候，无论是否他有关联点或者没有关联点，他都可以先被当成一个独立的点来判断
		            // 因为我们每次去dfs关联点的时候，我们都最多只会删除 n - 1个点   (比如，我们有4个点成为一个正方形，他们是互相关联的，这时候我们只需要删除3个点，最后会得到一个独立的点)
		            if (!set.contains(s)) {
		                count++;
		                set.add(s);
		                dfs(r, c, rmap, cmap, set);
		            }
		        }
		      
		      return stones.length - count;
		    }
		    
		    public void dfs(int r, int c, Map<Integer, HashSet<Integer>> rmap, Map<Integer, HashSet<Integer>> cmap, Set<String> set){
		        for (int col : rmap.get(r)) {
		            String s = r + "," + col;
		            if (!set.contains(s)) {
		                
		                set.add(s);
		                dfs(r, col, rmap, cmap, set);
		            }
		        }
		        
		        for (int row : cmap.get(c)) {
		            String s = row + "," + c;
		            if (!set.contains(s)) {
		                
		                set.add(s);
		                dfs(row, c, rmap, cmap, set);
		            }
		        }        
		    }
	}
}
