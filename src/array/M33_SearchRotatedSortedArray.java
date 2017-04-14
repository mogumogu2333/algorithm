package array;

public class M33_SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums==null || nums.length == 0) return -1;
		int l = 0, h = nums.length-1, m = 0;
	
		// find the smallest number's position
		// 找逆序部分
		while(l<h){
			m = l + ((h-l)>>1);
			if(nums[m] > nums[h]) l = m+1;
			else if(nums[m] < nums[l])h = m;
			else{
				//m>=l && m<=h 
				// to find the smallest, show be at lower part
				h = m;
			}
		}
		
		// low is the smallest
		int pivot = l;
		l = 0;
		h = nums.length-1;
		int n = nums.length;
		while(l <= h){
			m = l + ((h-l)>>1);
			int realmid = (m+pivot)%n;
			if(nums[realmid]==target)return realmid;
			else if(nums[realmid]>target)h = m-1;
			else l = m+1;
		}
        return -1;
    }
	
	public int search2(int[] nums, int target) {
		// 另一种解法：
		if(nums==null || nums.length == 0) return -1;
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int m = left + ((right-left)>>1);
			System.out.println(left+"\t"+m+"\t"+right);
			if(nums[m]==target) return m;
			if(nums[left] <= nums[m]){
				if(nums[left]<=target && target < nums[m]){
					right = m-1;
				}
				else{
					left = m+1;
				}
			}
			else if(nums[m] <= nums[right]){
				if(nums[m] < target && target <= nums[right]){
					left = m+1;
				}
				else right = m-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{5,6,1,2,3,4};
		M33_SearchRotatedSortedArray sol = new M33_SearchRotatedSortedArray();
		System.out.println(sol.search2(nums, 5));
	}

}
