package microsoft;

public class longestPalindrome {
	
	// time: n^2
	// space 1
	// ˼·��һ��һ��Ԫ�ر�����Ȼ�������չ�����Ƿ���palindrome������ǵĻ������ұȵ�ǰ��֪����Ҫ���Ļ����ͼ�¼����ߵ�index�ͳ��ȡ�
	
	class Solution1 {
	    int ans = 0;
	    int leftIndex;
	    public String longestPalindrome(String s) {
	        char[] arr = s.toCharArray();
	        for (int i = 0; i < arr.length; i++) {
	            expand(arr, i, i);
	            expand(arr, i, i+1);
	        }
	        
	        return s.substring(leftIndex, leftIndex + ans);
	    }
	    
	    public void expand(char[] arr, int l, int r) {
	        while (l >= 0 && r <  arr.length && arr[l] == arr[r]) 
	        {
	            l--;
	            r++;
	        }
	        if (ans < r - l - 1) {
	            ans = Math.max(ans, r - l - 1);
	            leftIndex = l + 1; 
	        }
	        
	    }
	}
	
	// ˼·�� dp������¼�Ƿ���palindrome
	// һ��һ���palindrome
	class Solution {
	    String ans;
	    int leng = -1;
	    public String longestPalindrome(String s) {
	        
	        int len = s.length();
	        if (len == 0) {
	            return "";
	        }
	        boolean[][] dp = new boolean[len][len];
	        char[] arr = s.toCharArray();
	        for (int i = 0; i < len; i++) {

	            for (int j = i; j >=0; j--) {
	                dp[i][j] = (arr[i] == arr[j]) && (i - j < 3 || dp[i - 1][j + 1]);
	                
	                if (dp[i][j] && leng < (i - j + 1)) {
	                    leng = (i - j + 1);

	                    ans = s.substring(j, i + 1);
	                }
	            }
	        }
	        return ans;
	    }
	    

	}
}
