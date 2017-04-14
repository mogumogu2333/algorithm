package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M22_GeneratePerentheses {
	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<>();
		backtracking(results, n, n, "");
		return results;
        
    }
	
	public void backtracking(List<String> results, int left, int right, String cur){
		if(left>right)return;
		
		if(left>0){
			backtracking(results, left-1, right, cur+"(");
		}
		if(right>0){
			backtracking(results, left, right-1, cur+")");
		}
		if(left==0 && right==0){
			results.add(cur);
			return;
		}
	}
	
	public static void main(String[] args) {
		M22_GeneratePerentheses sol = new M22_GeneratePerentheses();
		List<String> results = sol.generateParenthesis(3);
		for(String s:results){
			System.out.println(s);
		}
	}
}
