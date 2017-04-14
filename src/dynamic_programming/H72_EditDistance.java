package dynamic_programming;

public class H72_EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for(int i = 0;i<word1.length()+1;i++)dp[i][0] = i;
		for(int j = 0;j<word2.length()+1;j++)dp[0][j] = j;
		
		for(int i = 1;i<word1.length()+1;i++){
			for(int j = 1;j<word2.length()+1;j++){
				if(word1.charAt(i-1)==word2.charAt(j-1))dp[i][j] = dp[i-1][j-1];
				else{
					int insert = dp[i][j-1]+1;
					int replace = dp[i-1][j-1]+1;
					int delete = dp[i-1][j]+1;
					int temp = Math.min(insert, replace);
					dp[i][j] = Math.min(delete, temp);
				}
			}
		}
		return dp[word1.length()][word2.length()];
        
    }
	
	public static void main(String[] args) {
		H72_EditDistance sol = new H72_EditDistance();
		String w1 = "";
		String w2 = "abb";
		System.out.println(sol.minDistance(w1, w2));
	}
}
