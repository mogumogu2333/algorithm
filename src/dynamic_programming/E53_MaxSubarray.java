package dynamic_programming;

public class E53_MaxSubarray {
	public int maxSubArray_n2(int[] nums) {
		int max = Integer.MIN_VALUE;
        int[][] sums = new int[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++){
        	for(int j = i;j<nums.length;j++){
        		if(j==i)sums[i][j] = nums[i];
        		else{
        			sums[i][j] = sums[i][j-1]+nums[j];
        		}
        		if(sums[i][j] > max){
        			max = sums[i][j];
        		}
        	}
        }
        return max;
    }
	
	public int maxSubArray(int[] nums) {
//		int max = Integer.MIN_VALUE;
//		for(int i = 0;i<nums.length;i++){
//			int num = max_ends_at_i(nums, i);
//			if(num>max)max = num;
//		}
		
//		for(int i = 0;i<nums.length;i++){
//			int num = max_start_at_i(nums, i);
//			if(num>max)max = num;
//		}
		
		
		return max_start_at_i(nums);
		
	}
	
	public int max_ends_at_i(int[] nums, int i){
		if(i==0)return nums[0];
		return (max_ends_at_i(nums, i-1)>0)?(max_ends_at_i(nums, i-1)+nums[i]):nums[i];
	}
	
	public int max_start_at_i(int[] nums){
		int[] max_start = new int[nums.length];
		int max = Integer.MIN_VALUE;
		max_start[nums.length-1] = nums[nums.length-1];
		for(int i = nums.length-2;i>=0;i--){
			max_start[i] =  (max_start[i+1]>0)?(max_start[i+1]+nums[i]):(nums[i]);
			if(max < max_start[i])max = max_start[i] ;
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		E53_MaxSubarray sol = new E53_MaxSubarray();
		System.out.println(sol.maxSubArray(nums));
	}
	
}
