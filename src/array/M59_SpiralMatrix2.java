package array;

import java.util.Arrays;

public class M59_SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int num = 1;
		int[][] results = new int[n][n];
		int nLayer = (n%2==0)?n/2:n/2+1;
		
		for(int ly = 0;ly<nLayer;ly++){
			int max = n-1-ly;
			
			// top: l to r
			for(int col = ly;col<=max;col++)results[ly][col] = num++;
			
			//right: top to bottom
			for(int row = ly+1; row<max;row++)results[row][n-1-ly] = num++;
			
			//bottom: r to l
			for(int col = n-1-ly; col>ly; col--)results[n-1-ly][col] = num++;
			
			//left: bottom to top
			for(int row = n-1-ly;row>ly;row--)results[row][ly] = num++;
			
		}
		return results;
        
    }
	
	public static void main(String[] args) {
		M59_SpiralMatrix2 sol = new M59_SpiralMatrix2();
		int n = 5;
		int[][] m = sol.generateMatrix(n);
		for(int i = 0;i<n;i++)System.out.println(Arrays.toString(m[i]));
	}
}
