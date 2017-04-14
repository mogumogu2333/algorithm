package array;

public class Search2DMatrix_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if((matrix==null) ||(matrix.length==0)|| (matrix[0]==null)|| (matrix[0].length==0))return false;
        
		int low = 0, high = matrix.length-1;
        
        int m = 0;
        int last_index = matrix[0].length-1;
        while(low <= high){
        	m = low + (high-low)/2;
//        	int last_index = matrix[m].length-1;
        	if(matrix[m][last_index]==target)return true;
        	else if(matrix[m][last_index] <target) low = m+1;
        	else if(matrix[m][last_index] >target)high = m-1;
        }
        
        int srow = low;
        if(srow == matrix.length)return false;
        
        low = 0;
        high = matrix[srow].length-1;
        while(low <= high){
        	m = low + (high-low)/2;
        	if(matrix[srow][m]==target)return true;
        	else if(matrix[srow][m]<target)low = m+1;
        	else if(matrix[srow][m]>target)high = m-1;
        }
        return false;
    }
	
	
	public static void main(String[] args) {
//		int[][] matrix = new int[3][4];
//		matrix[0] = new int[]{1,3,5,7};
//		matrix[1] = new int[]{10, 11, 16, 20};
//		matrix[2] = new int[]{23, 30, 34, 50};
//		int[][] matrix = new int[][]{};
		
//		Search2DMatrix_74 sol = new Search2DMatrix_74();
//		System.out.println(sol.searchMatrix(matrix, 52));;
		
		
		
	}

}
