package array;

public class M73_setMatrixZero {
	public void setZeroes(int[][] matrix) {
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		boolean[] col = new boolean[ncol];
		boolean[] row = new boolean[nrow];
		
		for(int i = 0;i<nrow;i++){
			for(int j = 0;j<ncol;j++){
				if(matrix[i][j] == 0){
					row[i]= true;
					col[j] = true;
				}
			}
		}
		for(int i = 0;i<nrow;i++){
			for(int j = 0;j<ncol;j++){
				if(row[i]==true || col[j]==true)matrix[i][j] = 0;
			}
		}
        
    }
	
	public static void main(String[] args) {
		
	}

}
