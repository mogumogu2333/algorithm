package dynamic_programming;

class NumMatrix {
    private int[][] sumMatrix = null;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0)
		    return;
        sumMatrix = new int[matrix.length+1][matrix[0].length+1];
		for(int i = 0;i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
            	sumMatrix[i+1][j+1]= sumMatrix[i][j+1]+sumMatrix[i+1][j]-sumMatrix[i][j]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2+1][col2+1] - sumMatrix[row2+1][col1]-sumMatrix[row1][col2+1]+sumMatrix[row1][col1];
    }
}

public class RangeSumQuery {
	
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		matrix[0] = new int[]{3,0,1,4,2};
		matrix[1] = new int[]{5,6,3,2,1};
		matrix[2] = new int[]{1,2,0,1,5};
		matrix[3] = new int[]{4,1,0,1,7};
		matrix[4] = new int[]{1,0,3,0,5};
		
		NumMatrix numMatrix = new NumMatrix(matrix);
		
		
		int rsum = numMatrix.sumRegion(1, 1, 2, 2);
		
		System.out.println(rsum);
	}
}


