package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class M49_GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
        int id = 0;
        List<List<String>> results = new ArrayList<List<String>>();
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for(String str: strs){
        	char[] c = str.toCharArray();
        	Arrays.sort(c);
        	String s = new String(c);
        	int hash = s.hashCode();
        	if(mapping.containsKey(hash)){
        		results.get(mapping.get(hash)).add(str);
        	}
        	else{
        		mapping.put(hash, id);
        		id++;
        		List<String> newlist = new ArrayList<>();
        		newlist.add(str);
        		results.add(newlist);
        	}
        }
        
        return results;
    }
	
	public List<String> getAllAnagram(String str){
		List<String> result = new ArrayList<>();
		String cur = "";
		backtracking(str, 0, cur, new HashSet<Integer>(), result);
		return result;
	}
	
	private void backtracking(String str, int start, String cur, HashSet<Integer> curset, List<String> res){
		if(start == str.length()){
			res.add(new String(cur));
			return;
		}
		
		for(int i = 0;i<str.length();i++){
			if(curset.contains(i))continue;
			else{
				curset.add(i);
				cur = cur + str.charAt(i);
				backtracking(str, start+1, cur, curset, res);
				curset.remove(i);
				cur = cur.substring(0,cur.length()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc";
		String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		M49_GroupAnagram sol = new M49_GroupAnagram();
		List<List<String>> results = sol.groupAnagrams(input);
		for(List<String> result:results){
			System.out.println(Arrays.toString(result.toArray()));
		}
//		List<String> l = sol.getAllAnagram(str);
//		for(String s : l)System.out.println(s);
		
	}

}
