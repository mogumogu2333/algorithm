package math;

public class M29_DivideTwoInt {
	public int divide(int dividend, int divisor) {
		if(divisor==0)return Integer.MAX_VALUE;
		if(divisor == 1)return dividend;
		if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		
		long myDividedn;
		long myDivisor;
		
		if(dividend == Integer.MIN_VALUE) myDividedn = Math.abs((long)dividend);
		else myDividedn = Math.abs(dividend);
		
		
		if( divisor == Integer.MIN_VALUE) myDivisor = Math.abs((long)divisor);
		else myDivisor = Math.abs(divisor);
		
		int res = 0;
		while(myDividedn >= myDivisor){
			int numShift = 0;
			while(myDividedn >= (myDivisor<<numShift))
				numShift++;
			res += (1<<(numShift-1));
			myDividedn -= (myDivisor<<(numShift-1));
			
		}
		System.out.println(res);
		if(((dividend>0) && (divisor > 0)) || ((dividend <0) && (divisor < 0))){
			return res;
		}
		
		else{
			return -res;
		}
		
    }
	
	
	public static void main(String[] args) {
		M29_DivideTwoInt solution = new M29_DivideTwoInt();
		int res = solution.divide(-2147483648, 1);
		System.out.println(res);
	}

}
