package array;

public class M153_FindMinRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums==null || nums.length==0)return -1;
		int left= 0;
		int right = nums.length-1;
		while(left < right){
			int m = left + (right-left)/2;
			if(nums[left] <= nums[m]){
				if(nums[m] < nums[right]){
					return nums[left];
				}
				else{
					//m > r, min is in (m,r), m must not be the min, +1
					left = m+1;
				}
			}
			else if(nums[m] < nums[right]){
				// nums[left]>=nums[m]
				// m may be the min, so don't skip it
				right = m;
			}
			else{
				// l >=m, m>=r 
				// case 1=> l == m==r
				// case 2=> l==m, m>r: 4,1
				// case 3=> l>m, m==r: 4,3,3 (not exist in no duplicated case)
				return nums[left];
			}
		}
		return nums[left];
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2};
		M153_FindMinRotatedSortedArray sol = new M153_FindMinRotatedSortedArray();
		System.out.println(sol.findMin(nums));
	}
}
