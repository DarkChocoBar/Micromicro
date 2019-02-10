package google;

import java.util.HashSet;

public class RobotRoomCleaner {
	/**
	 * // This is the robot's control interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface Robot {
	 *     // Returns true if the cell in front is open and robot moves into the cell.
	 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
	 *     public boolean move();
	 *
	 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
	 *     // Each turn will be 90 degrees.
	 *     public void turnLeft();
	 *     public void turnRight();
	 *
	 *     // Clean the current cell.
	 *     public void clean();
	 * }
	 */

	class Solution {

	    public void cleanRoom(Robot robot) {
	        dfs(robot, new HashSet<String>(), 0, 0, 0);

	    }

	    
	    public void dfs(Robot robot, HashSet<String> set, int dir, int x, int y) {
	    	
	    	// dfs进行遍历，走完一步后要进行back tracking
	    	// 可以想象成机器人清洗了一个地方后要原路往返走，去找不同地方需要清洗的地方
	        String tmp = x + "." + y;
	                if (set.contains(tmp)) {
	            return;
	        }
	        robot.clean();
	        set.add(tmp);
	        
	        for (int i = 0; i < 4; i++) {
	            if (robot.move()) {
	                if (dir == 0) {
	                    dfs(robot, set, dir, x+1, y);
	                }
	                if (dir == 1) {
	                    dfs(robot, set, dir, x, y+1);
	                }
	                if (dir == 2) {
	                    dfs(robot, set, dir, x-1, y);
	                }
	                if (dir == 3) {
	                    dfs(robot, set, dir, x, y-1);
	                }      
	                
	                // 转180度
	                robot.turnRight();
	                robot.turnRight();
	                
	                // 往回走一步
	                robot.move();
	                
	                // 再转180度
	                robot.turnRight();
	                robot.turnRight();    
	            }
	            

	            // 走完当前的路程后，向右转，继续找路走
	            robot.turnRight();
	            dir +=1;
	            dir %=4;
	        }
	    }
	}
}
