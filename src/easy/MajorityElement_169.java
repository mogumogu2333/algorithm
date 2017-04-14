package easy;

public class MajorityElement_169 {
	public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1;i<nums.length;i++){
        	if(nums[i]==candidate)count++;
        	else count--;
        	
        	if(count<0){
        		candidate=nums[i];
        		count=1;
        	}
        }
        return candidate;
    }
	
	public static void main(String[] args) {
		MajorityElement_169 sol = new MajorityElement_169();
		System.out.println(sol.majorityElement(new int[]{1,1,3,2}));
	}
}
