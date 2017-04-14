package dynamic_programming;

public class M62_UniquePath {
	
	public int uniquePaths(int m, int n) {
        int[][] results = new int[m][n];
        for(int i = 0;i<n;i++)results[0][i] = 1;
        for(int j = 0;j<m;j++)results[j][0] = 1;
        
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                results[i][j] = results[i-1][j]+results[i][j-1];
            }
        }
        return results[m-1][n-1];
            
        
    }
	
	public static void main(String[] args) {
		M62_UniquePath sol = new M62_UniquePath();
		System.out.println(sol.uniquePaths(3, 7));
	}

}
