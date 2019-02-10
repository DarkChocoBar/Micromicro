package google;

// 308 
public class RangeSum2Darray {
	class NumMatrix {

	    int[][] matrix;
	    int[][] rowsum;
	    
	    public NumMatrix(int[][] matrix) {
	        if (matrix == null) {
	            return;
	        }
	        
	        if (matrix.length == 0) {
	            return;
	        }
	        
	        if (matrix[0].length == 0) {
	            return;
	        }
	        this.matrix = matrix;
	        rowsum = new int[matrix.length][matrix[0].length];
	        for (int i = 0; i < matrix.length; i++) {
	            rowsum[i][0] = matrix[i][0];
	            //System.out.println("test");
	            for (int j = 1; j < matrix[i].length; j++) {
	                //System.out.println("test2");
	                rowsum[i][j] = rowsum[i][j - 1] + matrix[i][j];
	            }
	            //System.out.println("test3");
	        }
	        //System.out.println("test4");
	    }
	    
	    public void update(int row, int col, int val) {
	        this.matrix[row][col] = val;
	        
	        rowsum[row][0] = matrix[row][0];
	        for (int j = 1; j < matrix[row].length; j++) {
	            rowsum[row][j] = rowsum[row][j - 1] + matrix[row][j];
	        }
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        //System.out.println("sumResgion: [" + row1 + "," + col1 + "," + row2 + "," + col2 + "]");

	        int ans = 0;
	        for (int i = row1; i <= row2; i++) {
	            //System.out.println("ye12" + ans);
	            ans += rowsum[i][col2];
	            
	            if (col1 > 0) {
	                //System.out.println("ye2" + ans);
	                ans -= rowsum[i][col1 - 1];
	                //System.out.println("ye3" + ans);

	            }
	        }
	        return ans;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * obj.update(row,col,val);
	 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
	 */
}
