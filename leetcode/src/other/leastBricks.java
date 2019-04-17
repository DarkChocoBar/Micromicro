package other;

import java.util.HashMap;
import java.util.List;

public class leastBricks {
	class Solution {
	    public int leastBricks(List<List<Integer>> wall) {
	        // ÿ����϶������һ��index�����������Ǿ���hashmap��key����Ϊ��϶�����ֵĴ�������Ϊvalue
	        // �����������ǿ��Ի�õ��ܴ���ǽ�ڵ���С��ֵ����wall�ĺ�ȣ�wall.size()����ȥ value
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
	        
	        // ���max������Сֵ��˵�����Ǳ���Ҫ��������ǽ�ڣ�û�з������
	        return (max == Integer.MIN_VALUE) ? wall.size() : wall.size() - max;
	    }
	}
}
