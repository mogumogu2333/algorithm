package easy;

/**
 * Solution: https://segmentfault.com/a/1190000003481153
 * @author Shang
 *1. 二进制只有一个1
 *2. 减一相与。 ==0 则正确
 *
 */
public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		return n>0 && ( (n-1) & n) ==0 ;
    }
}
