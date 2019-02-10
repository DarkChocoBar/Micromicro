package google;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MiminumAreaRec {
	// 这个方法更好！
	class Solution {
	    public int minAreaRect(int[][] points) {
	        Set<Integer> pointSet = new HashSet();
	        // 自己创建了一个hash，不用创一个object去存储信息，这样更快
	        for (int[] point: points)
	            pointSet.add(40001 * point[0] + point[1]);

	        int ans = Integer.MAX_VALUE;
	        for (int i = 0; i < points.length; ++i)
	            for (int j = i+1; j < points.length; ++j) {
	                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
	                    if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
	                            pointSet.contains(40001 * points[j][0] + points[i][1])) {
	                        ans = Math.min(ans, Math.abs(points[j][0] - points[i][0]) *
	                                            Math.abs(points[j][1] - points[i][1]));
	                    }
	                }
	            }

	        return ans < Integer.MAX_VALUE ? ans : 0;
	    }
	}
	
	class Solution2 {
	    public int minAreaRect(int[][] points) {
	        if (points.length < 4) {
	            return 0;
	        }   
	        
	        // 把所有点都放到一个hash set里面
	        HashSet<Point> set = new HashSet<>();
	        for (int[] point : points) {
	            int x = point[0];
	            int y = point[1];
	            
	            set.add(new Point(x,y));
	        }
	        
	        // 思路：
	        // 用一个nested for loop， 并找第三第四个坐标点
	        // 如果这两个坐标点存在的话，就用他们更新area
	        int maxArea = Integer.MAX_VALUE;
	        for (int[] point1 : points) {
	            int x1 = point1[0];
	            int y1 = point1[1];
	            for (int[] point2 : points) {
	                if (point1.equals(point2)) {
	                    continue;
	                }
	                int x2 = point2[0];
	                int y2 = point2[1];
	                
	                
	                Point c1 = new Point(x2, y1);
	                Point c2 = new Point(x1, y2);
	                if (set.contains(c1) && set.contains(c2)) {
	                    int res = Math.abs(x2 - x1) * Math.abs(y2 - y1);
	                    if (res != 0) {
	                        maxArea = Math.min(maxArea, Math.abs(x2 - x1) * Math.abs(y2 - y1));
	                    }  
	                } else {
	                    continue;
	                }
	            }            
	        }
	        return maxArea == Integer.MAX_VALUE ? 0 : maxArea;
	    }
	    
	    class Point {
	        int x;
	        int y;
	        
	        public Point(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        
	        @Override
	        public boolean equals(Object obj) {
	            return ((Point) obj).x == this.x && ((Point) obj).y == this.y;
	        }
	        
	        @Override
	        public int hashCode() {
	            return Objects.hash(this.x, this.y);
	        }
	    }
	}
}
