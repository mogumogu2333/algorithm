package dynamic_programming;

public class M64_MinPathSum {
	public int minPathSum(int[][] grid) {
		int nRow = grid.length;
		int ncol = grid[0].length;
		int[][] min = new int[nRow][ncol];
		min[0][0] = grid[0][0];
		for(int i = 1;i<nRow;i++)min[i][0] = min[i-1][0]+grid[i][0];
		for(int i = 1;i<ncol;i++)min[0][i] = min[0][i-1]+grid[0][i];
		for(int i = 1;i<nRow;i++){
			for(int j = 1;j<ncol;j++){
				min[i][j] = Math.min(min[i-1][j], min[i][j-1])+grid[i][j];
			}
		}
		return min[nRow-1][ncol-1];
    }
	
}
