package math;

public class E69_Sqrt {
	public int mySqrt(int x) {
		// use binary search
//		long low = 0, high = x/2 + 1;
		long low = 0, high = x;
		long m = 0;
		while(low <=  high){
			m = low + ((high-low)>>1);
			System.out.println(low+"\t"+m+"\t"+high);
			if(x == m*m) return (int)m;
			else if(x > m*m){
				low = m+1;
			}
			else{
				high = m-1;
			}
		}
		return (int)high;
    }
	
	public int binarysearch(int[] nums, int x){
		int low = 0, high = nums.length-1;
		int m = 0;
		while(low <=  high){
			m = low + ((high-low)>>1);
			System.out.println(low+"\t"+m+"\t"+high);
			if(x == nums[m]) return (int)m;
			else if(x > nums[m]){
				low = m+1;
			}
			else{
				high = m-1;
			}
		}
		System.out.println(low+"\t"+m+"\t"+high);
		return (int)high;
	}
	
	
	public int binarysearch2(int[] nums, int x){
		int low = 0, high = nums.length-1;
		int m = 0;
		while(low <=  high){
			m = low + ((high-low)>>1);
			System.out.println(low+"\t"+m+"\t"+high);
			if(x == nums[m]) return (int)m;
			else if(x > nums[m]){
				low = m+1;
			}
			else{
				high = m-1;
			}
		}
		System.out.println(low+"\t"+m+"\t"+high);
		return (int)high;
	}
	
	
	public static void main(String[] args) {
		E69_Sqrt sol = new E69_Sqrt();
		int n = 1;
		int[] nums = new int[]{1,3,5,7};
		sol.binarysearch(nums, 2);
//		int x = sol.mySqrt(10);
//		System.out.println(x);
//		System.out.println(Integer.MAX_VALUE);
	}
}
