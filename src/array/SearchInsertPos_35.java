package array;

import java.util.Arrays;

public class SearchInsertPos_35 {
	/**
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * 
	 * Solution: Binary Search
	 */
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		int m;
		while(low <= high){
			m = low + ((high-low) >> 1);
			System.out.println(low+"\t"+m+"\t"+high);
			if(nums[m] == target)return m;
			else if(nums[m]<target)low = m+1;
			else if(nums[m]>target)high = m-1;
		}
		
		System.out.println(low+"\t"+high);
		return low;//return high will be wrong if target is smallest number
        
    }
	
	
	
	
	//non-recursive
	//return the insert position
	public int binarySearch(int[] nums, int left, int right, int target){
		int m = 0;
		while(left <= right){
			m = left + ((right-left)>>1);
			if(nums[m] == target)return m;
			else if(nums[m]>target)right = m-1;
			else if(nums[m]<target)left = m+1;
			
		}
		return left;
	}
	
	public int binarySearchRec(int[] nums, int left, int right, int target){
		if(nums==null)return -1;
		else if(left>right)return left;
		
		int m = left + ((right-left)>>1);
		if(target == nums[m])return m;
		else if(target > nums[m])return binarySearchRec(nums, m+1, right, target);
		else return binarySearchRec(nums, left, m-1, target);
	}
	
	
	public static void main(String[] args) {
		SearchInsertPos_35 sol = new SearchInsertPos_35();
		int[] nums = new int[]{5,7,7,8,8,10};
		int ret = sol.searchInsert(nums, 0);
		System.out.println(ret);
		
//		int ret = sol.binarySearchRec(nums, 0, 5, 16);
//		System.out.println(ret);
		
	}

}
