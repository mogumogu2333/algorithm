package array;

public class FindMinRotatedSortedArray2_154 {
	public int findMin(int[] nums) {
		if(nums==null || nums.length==0)return -1;
		int left = 0;
		int right = nums.length-1;
		while(left < right){
			int m = left + (right-left)/2;
			if(nums[left] == nums[m]) {
				if(nums[m] < nums[right])right = m-1;
				else left++;
			}
			else if(nums[m] == nums[right])right--;
			else if(nums[left] < nums[m]){
				if(nums[m] <nums[right]){
					return nums[left];
				}
				else{
					//l<m, m > r
					// => l>=r
					left = m+1;
				}
			}
			else if(nums[m] < nums[right]){
				// l>=m
				// => l>=r
				right = m;
			}
//			else{
//				
//			}
		}
		return nums[left];
        
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,3};
		FindMinRotatedSortedArray2_154 sol = new FindMinRotatedSortedArray2_154();
		System.out.println(sol.findMin(nums));
	}
}
