package easy;

/**
 * This is a math problem. 
 * To solve it, you need to calculate all the one digit value's happy number. 
 * Got the conclusion that, only 1 and 7 could eventually get 1.
 * @author Shang
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        return bruceForce(n);
    }
	
	public boolean bruceForce(int n){
		
		while(n>=10){
			int val = 0;
			while(n>0){
				int sqrt = (n%10)*(n%10);
				val+=sqrt;
				n = n/10;
			}
			n=val;
			System.out.println(n);
		}
		return n==1 || n==7;
	}
	
	
	public static void main(String[] args) {
		HappyNumber solution = new HappyNumber();
		System.out.println(solution.isHappy(19));
		
//		int n = 19;
//		System.out.println(n%10);
	}

}
