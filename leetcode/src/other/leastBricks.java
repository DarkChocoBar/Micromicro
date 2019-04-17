package other;

import java.util.HashMap;
import java.util.List;

public class leastBricks {
	class Solution {
	    public int leastBricks(List<List<Integer>> wall) {
	        // 每个缝隙可以用一个index来代表，那我们就用hashmap的key来作为缝隙，出现的次数来作为value
	        // 那这样，我们可以获得的能穿过墙壁的最小数值就是wall的厚度（wall.size()）减去 value
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < wall.size(); i++) {
	            List<Integer> innerList = wall.get(i);
	            int sum = 0;
	            for (int j = 0; j < innerList.size() - 1; j++) {
	                int curr = innerList.get(j);
	                sum+= curr;
	                //System.out.println(sum);
	                map.put(sum, map.getOrDefault(sum, 0) + 1);
	            }
	        }
	        
	        int max = Integer.MIN_VALUE;
	        //System.out.println(map.keySet().size());
	        for (int i : map.keySet()) {
	            int fre = map.get(i);
	            //System.out.println(fre);
	            if (fre > max) {
	                max = fre;
	            }
	        }
	        
	        // 如果max还是最小值，说明我们必须要穿过所有墙壁，没有缝可以走
	        return (max == Integer.MIN_VALUE) ? wall.size() : wall.size() - max;
	    }
	}
}
