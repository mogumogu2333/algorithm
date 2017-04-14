package dynamic_programming;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int ncol = dungeon.length;
		int nrow = dungeon[0].length;
		int[][] hp = new int[ncol][nrow];
		for(int i = ncol-1;i>=0;i--){
			for(int j = nrow-1;j>=0;j--){
				
				if(i == ncol-1 && j == nrow-1){
					hp[i][j] = Math.max(1-dungeon[i][j], 1);
					continue;
				}
				else if(i == ncol-1){
					hp[i][j] = Math.max(1, hp[i][j+1]-dungeon[i][j]);
					continue;
				}
				else if(j == nrow-1){
					hp[i][j] = Math.max(1, hp[i+1][j]-dungeon[i][j]);
					continue;
				}
				else{
					hp[i][j] = Math.max(1, Math.min(hp[i+1][j], hp[i][j+1])-dungeon[i][j]);
				}
			}
		}
		return hp[0][0];
        
    }
	
	public static void main(String[] args) {
		int[][] dungeon ={{-2,-3,3},{-5,-10,1},{10,30,-5}};
		
		DungeonGame sol = new DungeonGame();
		int hp = sol.calculateMinimumHP(dungeon);
		System.out.println(hp);
	}
}
