package easy;

public class E137_SingleNumber2 {
	public int singleNumber(int[] nums) {
		int ret = 0;
        for(int j = 0;j<32;j++){
        	int mask = 1<<j;
        	int sum = 0;
        	for(int i = 0;i<nums.length;i++){
        		sum += (nums[i]&mask)>>j;
        	}
        	ret += (sum%3)<<j;
        }
        return ret;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,0,0,5};
		
		E137_SingleNumber2 sol = new E137_SingleNumber2();
		System.out.println(sol.singleNumber(nums));
	}
}
