package array;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		
		//123 + 1 = 124
		//129 + 1 = 130
		//899 + 1 = 900
		//999 + 1 = 1000
		
		
		if(digits == null)return digits;
		int len = digits.length;
		for(int i = len-1; i >= 0; i--){
			if(digits[i]<9){
				digits[i]++;
				return digits;
				
			}
			else{
				digits[i]=0;
			}
		}
		// 999
		int[] newdigits = new int[len+1];
		newdigits[0] = 1;
		return newdigits;
		
		
        
    }
	
	public static void main(String[] args) {
		int[] nums = {9,9,9};
		PlusOne sol = new PlusOne();
		
		int[] addone = sol.plusOne(nums);
		System.out.println(Arrays.toString(addone));
	}
}
