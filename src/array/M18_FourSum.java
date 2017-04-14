package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class M18_FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
//		List<List<Integer>> results = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-3;i++){
			List<List<Integer>> threeresults = threeSum(nums, i+1, nums.length-1, target-nums[i]);
			if(threeresults!=null && threeresults.size()>0){
				for(List<Integer> l : threeresults){
					l.add(nums[i]);
					set.add(l);
				}
			}
		}
		return new ArrayList<>(set);
        
    }
	
	private List<List<Integer>> threeSum(int[] sorted_nums, int lo, int hi, int target){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for(int i = lo;i<=hi-2;i++){
				
			List<List<Integer>> twos = twoSum(sorted_nums, i+1, hi, target-sorted_nums[i]);
			if(twos!=null){
				for(List<Integer> l : twos){
					l.add(sorted_nums[i]);
					results.add(l);
				}
			}
		}
		return results;
	}
	
	private List<List<Integer>> twoSum(int[] sorted_nums, int lo, int hi, int target){
		if(hi-lo<1)return null;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for(int i = lo,j=hi;i<j;){
			if(sorted_nums[i]+sorted_nums[j] == target){
				List<Integer> l = new ArrayList<>();
				l.add(sorted_nums[i]);
				l.add(sorted_nums[j]);
				results.add(l);
				i++;
				j--;
			}
			else if(sorted_nums[i]+sorted_nums[j] < target)i++;
			else j--;
		}
		return results;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
		M18_FourSum sol = new M18_FourSum();
		List<List<Integer>> results = sol.fourSum(nums, 0);
		for(List<Integer> l : results){
			System.out.println(Arrays.toString(l.toArray()));
		}
	}
}
