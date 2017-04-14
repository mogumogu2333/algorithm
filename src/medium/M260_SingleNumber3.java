package medium;

import java.util.Arrays;

public class M260_SingleNumber3 {
	public int[] singleNumber(int[] nums) {
		int temp = 0;
		for(int num:nums){
			temp = temp^num;
		}
		int j;
		for(j = 0;j<32;j++){
			if(((1<<j)&temp)!=0)break;
		}
		
		int[] ret = new int[2];
		
		int mask = 1<<j;
		for(int num:nums){
			if((num & mask) == 0){
				ret[0]^=num;
			}
			else{
				ret[1]^=num;
			}
		}
		return ret;
        
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,1,3,2,5};
		M260_SingleNumber3 sol = new M260_SingleNumber3();
		int[] ret = sol.singleNumber(nums);
		System.out.println(Arrays.toString(ret));
	}
	
}
