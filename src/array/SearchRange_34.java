package array;

import java.util.Arrays;

public class SearchRange_34 {
	public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1,-1};
        if(nums==null || nums.length==0)return ret;
		int low = 0, high = nums.length-1;
		int m = 0;
		//find left boundary
		while(low < high){
			m = low + ((high-low)>>1);
			if (nums[m]<target) low = m+1;
			else if(nums[m] > target) high = m-1;
			else high = m;
		}
		if(nums[low]!=target)return ret;
		ret[0] = low;
	
		//find right
		low = 0;
		high = nums.length-1;
		while(low < high){
			m = low + ((high-low+1)>>1);
			if(nums[m] > target)high = m-1;
			else if(nums[m] < target) low = m+1;
			else low = m;
		}
		ret[1] = low;
		return ret;
    
    }
	
	
	// standard binary search
	// lb will be the position or insert position for the target
	// ub will be ub-1 (if target not found)
	public int bs(int[] nums, int target){
		int lb = 0;
		int ub = nums.length-1;
		while(lb<=ub){
			int m = lb + (ub-lb)/2;
			if(target ==nums[m])return m;
			else if(target<nums[m])ub = m-1;
			else if(target>nums[m])lb = m+1;
		}
		System.out.println(lb+"\t"+ub);
		return lb;
	}
	
	
	
	public int bs_lb(int[] nums, int target){
		int l = 0, r = nums.length-1;
		while(l<r){
			int m = l + (r-l+1)/2;
			if(target == nums[m])r = m;
			else if(target < nums[m])r = m-1;
			else if(target > nums[m])l = m+1;
		}
		return l;
	}
	
	
	
	public int bs_ub(int[] nums, int target){
		int l = 0, r = nums.length-1;
		while(l<r){
			int m = l + (r-l)/2;
			if(target == nums[m])l = m;
			else if(target < nums[m])r = m-1;
			else if(target > nums[m])l = m+1;
		}
		return r;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{5,7,7,8,8,10};
		SearchRange_34 sol = new SearchRange_34();
		int[] ret = sol.searchRange(nums, 8);
		System.out.println(Arrays.toString(ret));
		System.out.println(sol.bs_lb(nums, 7));
		System.out.println(sol.bs_ub(nums, 7));
	}
}
