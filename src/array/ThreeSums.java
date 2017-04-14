package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		
		for(int i = 0; i<nums.length-2; i++){
			if(i>0 && nums[i] == nums[i-1])continue; 
			int j = i+1;
			int k = nums.length-1;
			int target = -nums[i];
			while(j<k){
				if(nums[j]+nums[k] == target){
					ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
					k--;
					j++;
					while(j<k && nums[k]==nums[k+1])k--;
					while(j<k && nums[j]==nums[j-1])j++;
				}
				else if(nums[j]+nums[k]<target){
					j++;
				}
				else{
					k--;
				}
				
				
				
			}
			
		}
		return ret;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2,0,2,1,1};
		ThreeSums sol = new ThreeSums();
		List<List<Integer>> ret = sol.threeSum(nums);
		for(List<Integer> l:ret){
			System.out.println(Arrays.toString(l.toArray()));
		}
	}
}
