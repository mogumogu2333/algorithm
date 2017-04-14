package hard;

import java.util.Arrays;

public class H239_SlidingWinMax {
	
//	public int[] maxSlidingWindow(int[] nums, int k) {
//    
//	}
	int nswap = 0;
	public void quicksort(int[] nums, int lo, int hi){
		if(lo>=hi)return;
		int l = lo;
		int r = hi;
		int mid = lo + (hi-lo)/2;
		int pivot = nums[mid];
		
		while(l<=r){
			while(l<=r && nums[l]<pivot)l++;
			while(l<=r && nums[r]>pivot)r--;
			if(l<=r)swap(nums, l++, r--);
		}
		
//		while(l<r){
//			while(l<r && nums[l]<pivot)l++;
//			while(l<r && nums[r]>pivot)r--;
//			swap(nums, l++, r--);
//		}
		
//		System.out.println(Arrays.toString(nums));
//		System.out.println();

		quicksort(nums, lo, r);
		quicksort(nums, l, hi);
	}
	
//	public int partition1(int[] nums, int lo, int hi){
//		int l = lo;
//		int r = hi;
//		int mid = lo + (hi-lo)>>1;
//		int pivot = nums[mid];
//		while(l<=r){
//			while(l<=r && nums[l]<=pivot)l++;
//			while(l<=r && nums[r]>=pivot)r--;
//			swap(nums, l++, r--);
//		}
//	}
	
	public void swap(int nums[], int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		nswap++;
	}
	
	public static void main(String[] args) {
//		int[] nums = new int[]{9,8,7,6,1,3,5,2};
		int[] nums = new int[]{1,1,1,1,1,1};

		H239_SlidingWinMax sol = new H239_SlidingWinMax();
		sol.quicksort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
		System.out.println(sol.nswap);
	}

}
