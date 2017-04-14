package array;

public class MergeSortedArray {
	/**
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	 * Solution: start from the tail, m+n-1 position in nums1
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m+n-1;
		int i = m-1, j = n-1;
		while(i>-1 && j>-1){
			nums1[k--] = (nums1[i]>nums2[j])?nums1[i--]:nums2[j--];
		}
		// if j < 0, i > 0: ok
		// if i < 0, j > 0: move j to i
		while(j > -1){
			nums1[k--] = nums2[j--];
		}
    }

}
