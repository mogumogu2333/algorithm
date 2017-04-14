package easy;

import java.util.Arrays;

public class FirstUniqueChar_387 {
    public int firstUniqChar(String s) {
    	if(s==null || s.equals(""))return 0;
        int[] check = new int[26];
        
        for(int i=0;i<26;i++)check[i]=-1;
        
        for(int i = 0;i<s.length();i++){
        	char ch = s.charAt(i);
        	if(check[ch-'a']==-1)check[ch-'a']=i;
        	else check[ch-'a']=-2;
        	
        }
        
        System.out.println(Arrays.toString(check));
        
        int min=s.length();
        for(int i = 0;i<26;i++){
        	if(check[i]<0)continue;
        	else{
        		if(check[i]<min)min=check[i];
        	}
        }
        if(min==s.length())return -1;
        else return min;
    }
    
    public static void main(String[] args) {
    	FirstUniqueChar_387 sol=new FirstUniqueChar_387();
    	System.out.println(sol.firstUniqChar("leetcode"));;
	}
}
