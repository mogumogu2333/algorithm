package math;

public class ArrangeCoin_441 {
	public int arrangeCoins(int n) {
		long left = 0;
		long right = (long)(Math.sqrt(n)*1.8);
		while(left <= right){
			long m = left + (right-left)/2;
			System.out.println(right);
			if((m*m*0.5+m*0.5)==n){
				return (int)m;
			}
			else if((m*m*0.5+m*0.5)<n){
				left = m+1;
			}
			else{
				right = m-1;
			}
		}
		return (int)left-1;
    }
	
	public static void main(String[] args) {
		ArrangeCoin_441 sol = new ArrangeCoin_441();
		System.out.println(sol.arrangeCoins(1804289383));
	}
}
