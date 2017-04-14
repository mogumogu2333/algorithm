import java.util.Arrays;

public class LC215_kth_largest_number {
	public int findKthLargest(int[] nums, int k) {
        return 1;
    }
	
	public void quicksort(int[] nums){
		
	}
	
	// right element as pivot
	public int partition1(int[] nums, int low, int high){
		
		int pivot = nums[high];
		int tmp;
		while(low<=high){
			while(low<=high &&nums[low]<pivot)low++;
			nums[high] = nums[low];
			while(low<=high && nums[high]>pivot)high--;
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{6,5,4,3,2,1};
		LC215_kth_largest_number sol = new LC215_kth_largest_number();
		sol.quicksort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
