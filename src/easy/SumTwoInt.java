package easy;

//371
public class SumTwoInt {
	/**
	 * carry保存进位
	 * a保存半加器的结果
	 * b每次左移一位，使1+1得到的进位1，与高一位在下一次迭代中相加。
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
		while(b!=0){
			int carry = a&b;
			a = a^b;  // half adder
			b = carry<<1; // carries are added to the higher bit on the next iteration
		}
        return a;
    }
	
	public static void main(String[] args) {
		SumTwoInt sol = new SumTwoInt();
		int sum = sol.getSum(0, 0);
		System.out.println(sum);
		
	}
}
