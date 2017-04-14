package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning_131 {
	
	List<List<String>> res = new ArrayList<>();
	
	public List<List<String>> partition(String s) {
		if(s==null || s.length()==0)return null;
		List<String> path = new ArrayList<>();
		dfs_helper(s, 0, path);
        return res;
    }
	
	private void dfs_helper(String s, int l, List<String> path){
		if(l==s.length()){
			res.add(path);
			return;
		}
		
		for(int r = l; r<s.length();r++){
			if(isPalindrome(s, l, r)){
				List<String> newPath = new ArrayList<>(path);
				newPath.add(s.substring(l, r+1));
				dfs_helper(s, r+1, newPath);
			}
		}
		
	}
	
	private boolean isPalindrome(String s, int l, int r){
		while(l<r){
			if(s.charAt(l)!=s.charAt(r))return false;
			else{
				l++;
				r--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "aab";
		PalindromePartitioning_131 sol = new PalindromePartitioning_131();
		List<List<String>> res = sol.partition(s);
		for(List<String> re:res){
			System.out.println(Arrays.toString(re.toArray()));
		}
	}
}
