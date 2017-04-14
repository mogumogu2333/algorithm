package math;

public class PalindromeNumber {
	
	//reverse half
	
    public boolean isPalindrome(int x) {
    	if(x<0)return false;
    	if(x<10)return true;
    	if(x%10==0)return false;
    	int rev = 0;
    	while(rev<x){
    		rev = rev*10 + x%10;
    		x =x/10;
    	}
    	return (rev == x)||(rev/10==x) ;
    }
    
    // full reverse a x
    public boolean isPalindrome_full_reverse(int x){
    	if(x<0)return false;
    	long rev = 0;
    	int newx = x;
    	while(newx>0){
    		rev = rev*10 + newx%10;
    		newx /= 10;
    	}
    	return (rev == x);
    }
    
    public static void main(String[] args) {
    	System.out.println(Integer.MIN_VALUE);
		int num = 100;
		PalindromeNumber sol = new PalindromeNumber();
		System.out.println(sol.isPalindrome(num));
	}
    
	
}
