package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring_3 {

	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0)return 0;
		int max = 0;
		int size = 256;
		int[] table = new int[size];
		for(int i = 0;i<s.length()-max;i++){
			Arrays.fill(table, -1);
			for(int j = i; j< s.length();j++){
				int ch = s.charAt(j);
				if(table[ch]==-1){
					table[ch] = j;
				}
				else{
					max = Math.max(max, j-i);
					i = table[ch];
					break;
				}
			}
			
		}
		
		return max;

	}
	
	public static void main(String[] args) {
		String s = "c";
		LongestSubstring_3 sol = new LongestSubstring_3();
		int len = sol.lengthOfLongestSubstring(s);
		System.out.println(len);
		
		char ch = '\u0000';
		System.out.println((int)ch);
		System.out.println(ch);
	}
	
}
