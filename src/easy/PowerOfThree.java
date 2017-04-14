package easy;

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
        return (n>0) && ((Math.pow(3, 19) % n)==0);
    }

	public static void main(String[] args) {
		int n = (int)Math.pow(3, 15);
		PowerOfThree sol = new PowerOfThree();
		boolean pot = sol.isPowerOfThree(n);
		System.out.println(pot);
	}
}
