package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M77_Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		backtracking(results, cur, n, k);
		return results;
    }
	
	public void backtracking(List<List<Integer>> results, List<Integer> cur, int n, int k){
		if(cur.size() == k){
			results.add(new ArrayList<>(cur));
			return;
		}
		int i = (cur.size()==0)?1:(cur.get(cur.size()-1)+1);
		for(;i<=n;i++){
			cur.add(i);
			backtracking(results, cur, n, k);
			cur.remove(cur.size()-1);
		}
	}
	
	public static void main(String[] args) {
		M77_Combination sol = new M77_Combination();
		List<List<Integer>> results = sol.combine(4, 2);
		for(List<Integer> s: results){
			System.out.println(Arrays.toString(s.toArray()));
		}
	}
}
