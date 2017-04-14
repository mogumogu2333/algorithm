package dynamic_programming;

public class M63_UniquePath2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int nrow = obstacleGrid.length;
		int ncol = obstacleGrid[0].length;
		
		int[][] res = new int[nrow][ncol];
		for(int i = 0;i<nrow;i++){
			if(obstacleGrid[i][0]==0)res[i][0] = 1;
			else break;
		}
		for(int j = 0;j<ncol;j++){
			if(obstacleGrid[0][j]==0)res[0][j]=1;
			else break;
		}
		
		for(int i = 1;i<nrow;i++){
			for(int j = 1;j<ncol;j++){
				if(obstacleGrid[i][j]==1){
					res[i][j]=0;
					continue;
				}
				else{
					res[i][j] = res[i-1][j]+res[i][j-1];
				}
			}
		}
		return res[nrow-1][ncol-1];
        
    }
}
