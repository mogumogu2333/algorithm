package array;

import java.util.Arrays;

public class MaximumGap {
	
	public int maximumGap(int[] nums) {
		if(nums == null || nums.length<2)return 0;
		// use bucket sort
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int num:nums){
			if(num > max)max = num;
			if(num < min)min = num;
		}
		double x = (max-min+1)/(nums.length*1.0);
		int gap = (int)Math.ceil(x); // gap is how many numbers in one bucket
		
		int[] bucket_MAX = new int[nums.length];
		int[] bucket_MIN = new int[nums.length];
		Arrays.fill(bucket_MAX, -1);
		Arrays.fill(bucket_MIN, Integer.MAX_VALUE);
		for(int num : nums){
			int bucket_id = (num-min)/gap;
			bucket_MAX[bucket_id] = Math.max(bucket_MAX[bucket_id], num);
			bucket_MIN[bucket_id] = Math.min(bucket_MIN[bucket_id], num);
		}
		
		int maxGap = 0;
		int prev = min; // actually it's min
		for(int i = 0;i<nums.length;i++){
			if(bucket_MAX[i]==-1)continue;
			else{
				maxGap = Math.max(maxGap, bucket_MIN[i]-prev);
				prev = bucket_MAX[i];
			}
		}
		maxGap = Math.max(maxGap, max-prev);
		
		return maxGap;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,1,6};
		MaximumGap sol = new MaximumGap();
		System.out.println(sol.maximumGap(nums));
	}

}
