package easy;

public class ReverseInt {
	public int reverse(int x) {
		long result = 0;
		while(x!=0){
			result = result * 10 + x%10;
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)return 0;
			x = x/10;
		}
		
		return (int)result;
		
		
    }
	
	public static void main(String[] args) {
		int x = 65535;
		System.out.println(x);
		ReverseInt sal = new ReverseInt();
		int y = sal.reverse(x);
		System.out.println(y);
		
//		System.out.println(-101 % 10);
	}
}
