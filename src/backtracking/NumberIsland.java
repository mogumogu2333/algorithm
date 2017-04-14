package backtracking;

public class NumberIsland {
	public int numIslands(char[][] grid) {
		int islands = 0;
        for(int i = 0;i<grid.length;i++){
        	for(int j = 0;j<grid[0].length;j++){
        		if(grid[i][j]=='1'){
        			dfs(grid,i,j);
        			islands ++;
        		}
        	}
        }
        return islands;
    }
	
	public void dfs(char[][] grid, int i, int j){
		if(i<0||j<0||i>=grid.length||j>=grid[0].length)return;
		if(grid[i][j]=='0')return;
		grid[i][j] = '0';
		dfs(grid, i+1, j);
		dfs(grid, i-1, j);
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
		return;
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[5][5];
		grid[0] = "11100".toCharArray();
		grid[1] = "11001".toCharArray();
		grid[2] = "10011".toCharArray();
		grid[3] = "00000".toCharArray();
		grid[4] = "00011".toCharArray();
		NumberIsland sol = new NumberIsland();
		System.out.println(sol.numIslands(grid));
	}
}
