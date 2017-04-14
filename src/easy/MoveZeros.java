package easy;

import java.util.Arrays;

public class MoveZeros {
	
	/**
	 * Two pointer, head scan from begining to the end. if head is 0, continue, else write this num to the writePos.
	 * WritePos always point to the position that is ready to right.
	 * 
	 * @param nums
	 */
	
	public void moveZeroes(int[] nums) {
		if(nums==null || nums.length<=1)return;
		
		int writePos = 0;
		int head = 0;
		
		while(head<nums.length){
			if(nums[head]==0){
				head++;
				continue;
			}
			else{
				nums[writePos] = nums[head];
				head++;
				writePos++;
			}
		}
		
		
		while(writePos<nums.length)nums[writePos++]=0;
        
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,0,3,12};
		MoveZeros sol= new MoveZeros();
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}
