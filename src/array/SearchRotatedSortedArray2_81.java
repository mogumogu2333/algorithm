package array;

public class SearchRotatedSortedArray2_81 {
	/**
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		Write a function to determine if a given target is in the array.
		The array may contain duplicates.
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
		if(nums==null || nums.length==0)return false;
		
		// find the smallest num's position
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int m = left + (right-left)/2;
			if(nums[m]==target)return true;
			if(nums[left] == nums[m])left++;
			else if(nums[m]==nums[right])right--;
			else if(nums[left] < nums[m]){
				if(nums[left] <= target && target < nums[m])right = m-1;
				else{
					left = m+1;
				}
			}
			else if(nums[m] < nums[right]){
				if(nums[m] < target && target <= nums[right]){
					left = m+1;
				}
				else{
					right = m-1;
				}
			}
		}
		return false;
		
        
    }
	
	
	public static void main(String[] args) {
		// case: 3,1,1
		// case: 1,3,1,1,1
		// case: 1,1,3
		SearchRotatedSortedArray2_81 sol = new SearchRotatedSortedArray2_81();
		int[] nums = new int[]{3,1,1};
		System.out.println(sol.search(nums, 1));
	}
}
