package backtracking;

import java.util.Arrays;

public class H52_NQueen2 {
	int count = 0;
	public int totalNQueens(int n) {
        int[] set = new int[n];
        backtracking(n, 0, set);
        return count;
    }
	
	public void backtracking(int n,  int pos, int[] set){
		if(pos==n){
			count++;
			return;
		}
		
		boolean[] placable = new boolean[n];
		Arrays.fill(placable, true);
		for(int i=0;i<pos;i++){
			placable[set[i]] = false;
			if(set[i]-(pos-i)>=0)placable[set[i]-(pos-i)]=false;
			if(set[i]+(pos-i)<n)placable[set[i]+(pos-i)] = false;
		}
		for(int i = 0;i<n;i++){
			if(placable[i]==true){
				set[pos] = i;
				backtracking(n, pos+1, set);
			}
		}
	}
	
	public static void main(String[] args) {
		H52_NQueen2 sol = new H52_NQueen2();
		System.out.println(sol.totalNQueens(5));
	}
}
