package array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums==null)return;
		if(nums.length<2)return;
		int second = nums.length-1, first = second-1;
		for(;second>0;second--){
			first = second-1;
			if(nums[first]>=nums[second])continue;
			else break;
		}
		
		// 5,4,3,2,1
		if(first==0 && nums[first]>nums[second]){
			reverse(nums,0);
			return;
		}
		
		//2,3,5,4,1: num[first] = 3, nums[second] = 5
		int i = nums.length-1;
		for(;i>second;i--){
			if(nums[i]>nums[first])break;
		}
		
		if(i>second){
			swap(nums, first, i);
		}
		else{
			swap(nums, first, second);
		}
		reverse(nums, second);
        
    }
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void reverse(int[] nums, int frompos){
		for(int i = frompos, j = nums.length-1;i<=j;i++,j--){
			if(i==j)return;
			else{
				swap(nums, i, j);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2};
		NextPermutation sol = new NextPermutation();
		sol.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
