package array;

import java.util.Arrays;

public class SortColor_75 {
	
	//count based
	public void sortColors_countBased(int[] nums) {
		if(nums==null || nums.length==0)return;
		int[] table = new int[3];
		for(int num:nums){
			table[num]++;
		}
		
		int id = 0;
		for(int i = 0;i<3;i++){
			for(int j = 0;j<table[i];j++){
				nums[id++] = i;
			}
		}
    }
	
	public void sortColors(int[] nums){
		//low point to the right of the right most 0
		//high point to the left of the left most 2
		//mid is our current pointer
		if(nums==null || nums.length==0)return;
		int low = 0, mid = 0, high = nums.length-1;
		while(mid<=high && low<=high){
			if(nums[mid]==1)mid++;
			else if(nums[mid]==0){
				if(low==mid){
					low++;
					mid++;
				}
				else{
					swap(nums, low++, mid);
				}
			}
			else if(nums[mid]==2){
				swap(nums, mid, high--);
			}
		}
	}
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,0};
		SortColor_75 sol = new SortColor_75();
		sol.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
