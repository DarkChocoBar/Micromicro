package microsoft;


// 75
public class SortColor {
	
	//思路：
	// 看到0就往前放，看到2就往后放
	// 用两个pointer来记录一开始放0和2的位置
	class Solution {
	    public void sortColors(int[] nums) {
	        int p0 = 0;
	        int p2 = nums.length - 1;
	        
	        for (int i = 0; i < p2; i++) {
	            if (nums[i] == 0) {
	                swap(nums, i, p0);
	                for (int k = 0; k < nums.length; k++) {
	                    System.out.print(nums[k] + ",");
	                }
	                System.out.println();
	                p0++;
	            } else if (nums[i] == 2) {
	                
	                swap(nums, i, p2);
	                for (int k = 0; k < nums.length; k++) {
	                    System.out.print(nums[k] + ".");
	                }
	                System.out.println();
	                p2--;
	                i--;
	            }
	        }
	    }
	    
	    public void swap(int[] nums, int i1, int i2) {
	        int temp = nums[i1];
	        nums[i1] = nums[i2];
	        nums[i2] = temp;
	    }
	}
}
