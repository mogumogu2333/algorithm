package easy;

/**
 * 比较巧妙的方法。在判断是power of two的基础上，num & 1010101....如果还等于num 则为power of four. 
 * 
 * 因为 power of four的1之存在在奇数位上
 * 
 * int is32bit. for each 4 bit, is 0101=5, so is eight 5s.
 * 
 * @author Shang
 *
 */
public class PowerofFour {
	public boolean isPowerOfFour(int num) {
		return (num>0) && ((num-1) & num)==0 && ((num & 0x55555555) == num);
		
	}
	
	public static void main(String[] args) {
		PowerofFour sol = new PowerofFour();
		int n =8;
		System.out.println(sol.isPowerOfFour(n));
	}
}
