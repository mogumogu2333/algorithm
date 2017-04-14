package array;

import java.util.Arrays;

public class M215_KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length-1;
        k = nums.length-k;
        int index;
        while(lo<=hi){
        	index = partition(nums, lo, hi);
        	if(index<k){
        		lo = index+1;
        	}
        	else if(index >k){
        		
        		hi = index-1;
        	}
        	else{
        		break;
        	}
        }
        return nums[k];
    }
	
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
	
	
	public static void main(String[] args) {
//		int[] nums = new int[]{2,8,7,1,3,5,6,4};
		int[] nums = new int[]{8,7,6,5,4,3,2,1};
		M215_KthLargestElement sol = new M215_KthLargestElement();
		System.out.println(sol.findKthLargest(nums, 3));
//		sol.quicksort(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));
	}

}
