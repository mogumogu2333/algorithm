package string;

import java.util.Arrays;

public class ShortestPalindrome_214 {
	public String shortestPalindrome(String s) {
		if(s==null || s.length()==0)return "";
		if(s.length()==1)return s;
		StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1;i>0;i--){
        	if(isPalindrome(s, 0, i)){
        		for(int j = s.length()-1;j>i;j--)sb.append(s.charAt(j));
        		for(int k = 0; k<s.length();k++)sb.append(s.charAt(k));
        		
        		return sb.toString();
        	}
        }
        for(int i = s.length()-1;i>=0;i--)sb.append(s.charAt(i));
        for(int i = 1;i<s.length();i++)sb.append(s.charAt(i));
        return sb.toString();
        
    }
	
	private boolean isPalindrome(String s, int lo, int hi){
		while(lo<hi){
			if(s.charAt(lo)!=s.charAt(hi))return false;
			lo++;
			hi--;
		}
		return true;
	}
	public String shortestPalindromeKMP(String s) {
	    String temp = s + "#" + new StringBuilder(s).reverse().toString();
	    int[] table = getTable(temp);
	    
	    //get the maximum palin part in s starts from 0
	    return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	}

	public int[] getTable(String s){
	    //get lookup table
	    int[] table = new int[s.length()];
	    
	    //pointer that points to matched char in prefix part
	    
	    int index = 0;
	    //skip index 0, we will not match a string with itself
	    for(int i = 1; i < s.length(); i++){
	        if(s.charAt(index) == s.charAt(i)){
	            //we can extend match in prefix and postfix
	            table[i] = table[i-1] + 1;
	            index ++;
	        }else{
	            //match failed, we try to match a shorter substring
	            
	            //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
	            //prefix part that we used to match postfix ended at i - 1
	            index = table[i-1];
	            
	            while(index > 0 && s.charAt(index) != s.charAt(i)){
	                //we will try to shorten the match string length until we revert to the beginning of match (index 1)
	                index = table[index-1];
	            }
	            
	            //when we are here may either found a match char or we reach the boundary and still no luck
	            //so we need check char match
	            if(s.charAt(index) == s.charAt(i)){
	                //if match, then extend one char 
	                index ++ ;
	            }
	            
	            table[i] = index;
	        }
	        
	    }
	    
	    return table;
	}
	
	
	public static void main(String[] args) {
		String s = "aba";
		ShortestPalindrome_214 sol = new ShortestPalindrome_214();
		System.out.println(sol.shortestPalindromeKMP(s));
	}
}
