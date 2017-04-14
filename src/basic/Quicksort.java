package basic;

public class Quicksort {
	public int partition(int[] nums, int lo, int hi){
		int i = lo-1;
		int pivot = nums[hi];
		int j = lo;
		for(j=lo;j<hi;j++){
			if(nums[j]<=pivot){
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, hi);
		return i+1;
		
	}
	
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void quicksort(int[] nums, int lo, int hi){
		if(lo<hi){
			int p = partition(nums, lo, hi);
			quicksort(nums, lo, p-1);
			quicksort(nums, p+1, hi);
		}
	}

}
