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
		        	// x y ����
		            int r = stones[i][0];
		            int c = stones[i][1];
		            
		            
		            // ����r��Ӧ��c�ŵ���Ӧ��set�У�֮�����ظ����õ�
		            if (!rmap.containsKey(r)) {
		                rmap.put(r, new HashSet<Integer>());
		            }
		            
		            // ͬ��
		            if (!cmap.containsKey(c)) {
		                cmap.put(c, new HashSet<Integer>());
		            }
		            
		            rmap.get(r).add(c);
		            cmap.get(c).add(r);
		        }
		        
		        int count = 0;
		        
		        
		        // set���ڼ�¼�������ĵ�����
		        Set<String> set = new HashSet<>();
		        for (int i = 0; i < stones.length; i++) {
		            int r = stones[i][0];
		            int c = stones[i][1];
		            
		            
		            String s = r + "," + c;
		            
		            // ����㷨��corner caseҪע��
		            // ÿ���ڿ�һ�����ʱ�������Ƿ����й��������û�й����㣬���������ȱ�����һ�������ĵ����ж�
		            // ��Ϊ����ÿ��ȥdfs�������ʱ�����Ƕ����ֻ��ɾ�� n - 1����   (���磬������4�����Ϊһ�������Σ������ǻ�������ģ���ʱ������ֻ��Ҫɾ��3���㣬����õ�һ�������ĵ�)
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
