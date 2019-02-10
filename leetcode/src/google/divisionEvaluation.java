package google;

import java.util.HashMap;
import java.util.HashSet;

public class divisionEvaluation {
	class Solution {
	    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
	        for (int i = 0; i < equations.length; i++) {
	            String[] equation = equations[i];
	            double value = values[i];
	            if (map.containsKey(equation[0])) {
	                HashMap<String, Double> innerMap = map.get(equation[0]);
	                innerMap.put(equation[1], value);
	            } else {
	                HashMap<String, Double> innerMap1 = new HashMap<>();
	                innerMap1.put(equation[1], value);
	                map.put(equation[0], innerMap1);
	            }
	            
	            if (map.containsKey(equation[1])) {
	                HashMap<String, Double> innerMap = map.get(equation[1]);
	                innerMap.put(equation[0], 1/value);
	            } else {
	                HashMap<String, Double> innerMap1 = new HashMap<>();
	                innerMap1.put(equation[0], 1/value);
	                map.put(equation[1], innerMap1);
	            }
	        }
	        double[] ans = new double[queries.length];
	        for (int i = 0; i < queries.length; i++) {
	            String[] query = queries[i];
	            String target = query[1];
	            String start = query[0];
	            ans[i] = dfs(start, target, map, new HashSet<String>(), 1.0);
	        }
	        return ans;
	    }
	    
	    public double dfs(String start, String target, HashMap<String, HashMap<String, Double>> map, HashSet<String> set, double value) {
	        if (set.contains(start)) {
	            return -1.0;
	        }
	        
	        if (!map.containsKey(start)) {
	            return -1.0;
	        }
	        
	        if (start.equals(target)) {
	            return value;
	        }
	        set.add(start);
	        double ans = -1.0;
	        for (String next : map.get(start).keySet()) {
	            double res = map.get(start).get(next);
	            ans = dfs(next, target, map, set, value * res);
	            if (ans != -1.0) {
	                break;
	            }
	        }
	        return ans;
	    }
	}
}
