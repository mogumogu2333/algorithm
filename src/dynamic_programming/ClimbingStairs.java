package dynamic_programming;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n==1)return 1;
		if(n==2)return 2;
		
		int[] a = new int[2];
        a[0] = 1;
        a[1] = 2;
        int next = 0;
        for(int i = 3;i<=n;i++){
        	next = a[0]+a[1];
        	a[0] = a[1];
        	a[1] = next;
        }
        return next;
    }
	public static void main(String[] args) {
		ClimbingStairs sol = new ClimbingStairs();
		System.out.println(sol.climbStairs(5));
	}
}
