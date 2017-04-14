package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H51_NQueen {
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		int[] set = new int[n];
		dfs(res, n,0, set);
		return res;
	}
	
	
	/**
	 * 
	 * @param res
	 * @param n
	 * @param set set[row]=col.
	 */
	public void dfs(List<List<String>> res, int n, int pos, int[] set){
		if(pos ==n){
			List<String> result = new ArrayList<>();
			for(int i = 0;i<n;i++){
				char[] s = new char[n];
				Arrays.fill(s, '.');
				s[set[i]] = 'Q';
				result.add(new String(s));
			}
			res.add(result);
			return;
		}
		
		boolean[] setable = new boolean[n];
		Arrays.fill(setable, true);
		for(int i = 0;i<pos;i++){
			// row=i,col = set[i]
			setable[set[i]] = false; // horizon
			if(set[i]-(pos-i)>=0)setable[set[i]-(pos-i)] = false;
			if(set[i]+(pos-i)<n)setable[set[i]+(pos-i)] = false; 
		}

		for(int i = 0;i<n;i++){
			//for each column
			if(setable[i]==true){
				set[pos] = i;
				dfs(res, n, pos+1, set);
			}
		}
	}
	
	public static void main(String[] args) {
		H51_NQueen sol = new H51_NQueen();
		
		List<List<String>> results = sol.solveNQueens(5);
		for(List<String> result : results){
			System.out.println("Solution:\n");
			for(String line : result){
				System.out.println(line);
			}
			System.out.println();
		}
	}

}
