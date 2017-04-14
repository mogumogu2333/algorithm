package array;

import java.util.Arrays;

public class ThreeSumClosest_16 {
	public int threeSumClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		
		
		int j,k;
		int closest_sum = 0;
		int min_diff = Integer.MAX_VALUE;
		for(int i = 0;i<nums.length-2;i++){
			j = i+1;
			k = nums.length-1;
			while(j<k){
				int sum = nums[i] + nums[j] + nums[k];
				int diff = sum-target;
				if(Math.abs(diff)<min_diff){
					min_diff = Math.abs(diff);
					closest_sum = sum;
				}
				if(sum>target)k--;
				else if(sum<target)j++;
				else return sum;
			}
		}
		return closest_sum;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{-1,1,2,-4};
		ThreeSumClosest_16 sol = new ThreeSumClosest_16();
		System.out.println(sol.threeSumClosest(nums, -2));
	}
}
