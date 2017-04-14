package hard;

public class MedianTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return findMedian(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
    }
	
	public double findMedian(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2){
		int m1 = l1 + (r1-l1)/2;
		int m2 = l2 + (r2-l2)/2;
		
		if(m1==m2)return nums1[m1];
		else if(m1<m2){
			// median is in (m1, r1) and (l2, m2)
			if((m1-l1) >= (m2-l2)){
				return findMedian(nums1, l1+(m2-l2), r1, nums2,l2,m2);
			}
			else{// sub (m2,r2)
				return findMedian(nums1, m1,r1,nums2,l2,r2-(m1-l1));
			}
		}
		else { //if(m1 > m2)
			// median is in (l1, m1) and (m2,r2)
			if((m1-l1) >= (m2-l2)){
				return findMedian(nums1,l1, r1-(r2-m2), nums2, m2, r2);
			}
			else{
				return findMedian(nums1,l1,m1,nums2,l2+(m1-l1),r2);
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3,5,7};
		int[] nums2 = new int[]{2,4,6};
	}

}
