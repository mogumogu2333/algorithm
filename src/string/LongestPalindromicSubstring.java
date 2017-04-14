package string;

public class LongestPalindromicSubstring {
	// brute forth: N^3
	public String longestPalindrome_bf(String s) {
		int len = s.length();
		if(s==null || len==0)return null;
        while(len>0){
        	for(int i = 0; i<=s.length()-len;i++){
        		if(isPalindrome(s, i, i+len-1)){
        			return s.substring(i,i+len);
        		}
        	}
        	len--;
        }
        return null;
    }
	
	private boolean isPalindrome(String s, int i, int j){
		if(i==j)return true;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))return false;
			i++;
			j--;
		}
		return true;
	}
	
	//dp
	public String longestPalindrome_dp(String s) {
		if(s==null || s.length()==0)return null;
		int maxStart = 0;
		int maxLen=1;
		boolean P[][] = new boolean[1000][1000];
		for(int i = 0;i<s.length();i++){
			P[i][i] = true;
		}
		
		for(int i = 0; i<s.length()-1;i++){
			if(s.charAt(i) == s.charAt(i+1)){
				P[i][i+1]=true;
				if(maxLen < 2){
					maxLen = 2;
					maxStart = i;
				}
			}
			else P[i][i+1]=false;
		}
		
		for(int len = 3;len<=s.length();len++){
			for(int i = 0; i<= s.length()-len;i++){
				int j = i+len-1;
				P[i][j] = (P[i+1][j-1] && (s.charAt(i)==s.charAt(j)))?true:false;
				if(P[i][j] && len>maxLen){
					maxLen = len;
					maxStart = i;
				}
			}
		}
		return s.substring(maxStart, maxStart+maxLen);
		
		
	}
	
	int center_maxLen;
	int center_maxStart;
	//find center
	public String longestPalindrome(String s) {
		if(s==null || s.length()==0)return null;
		if(s.length()==1)return s;
		for(int i = 0; i<s.length()-1;i++){
			expendPalindrome(s, i, i);
			expendPalindrome(s, i, i+1);
		}
		return s.substring(center_maxStart, center_maxLen+center_maxStart);
	}
	
	private void expendPalindrome(String s, int c1, int c2){
//		while(c1 >=0 && c2<s.length()){
//			if(s.charAt(c1)==s.charAt(c2)){
//				c1--;
//				c2++;
//			}
//			else{
//				break;
//			}
//			
//		}
		while(c1 >=0 && c2<s.length() && s.charAt(c1)==s.charAt(c2)){
			c1--;
			c2++;
		}
		
		c2 = c2-1;
		c1 = c1+1;
		if(c2-c1+1 > center_maxLen){
			center_maxLen = c2-c1+1;
			center_maxStart = c1;
		}
	}
	

		
	
	public static void main(String[] args) {
		String s = "ababa";
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		System.out.println(sol.longestPalindrome(s));
	}
}
