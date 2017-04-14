package easy;

import java.util.Arrays;

public class LongestPalindrome_409 {
	
	
	public int longestPalindrome(String s) {
		int[] table = new int[256];
		Arrays.fill(table, 0);
        for(int i = 0;i<s.length();i++){
        	int id = s.charAt(i);
        	table[id] += 1;
        }
        
        int sumEven = 0;
        int sumOdd = 0;
        int countOdd = 0;
        for(int i = 0;i<table.length;i++){
        	int count = table[i];
        	if(count%2==0)sumEven+=count;
        	else{
        		sumOdd += count;
        		countOdd += 1;
        	}
        }
        if(countOdd>0)sumOdd = sumOdd-(countOdd-1);
        return sumEven+sumOdd;
    }
	
	public static void main(String[] args) {
		String s = "sss";
		LongestPalindrome_409 sol = new LongestPalindrome_409();
		System.out.println(sol.longestPalindrome(s));;
	}
	
}
