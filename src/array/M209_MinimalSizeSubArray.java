package array;

public class M209_MinimalSizeSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(j<nums.length){
            sum += nums[j++];
            while(sum>=s){
                min = Math.min(min, j-i);
                sum -= nums[i++];
            }
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }


    public static void main(String[] args) {
		int[] nums = new int[]{2,3,1,2,4,3};
		M209_MinimalSizeSubArray sol = new M209_MinimalSizeSubArray();
		int res = sol.minSubArrayLen(7, nums);
		System.out.println(res);
	}
}
