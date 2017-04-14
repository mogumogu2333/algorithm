package array;

public class M80_RemoveDuplicate2 {
	public int removeDuplicates(int[] nums) {
		if(nums==null)return 0;
		if(nums.length<3)return nums.length;
		int i = 0,j=1;
		int len = 0;
		while(j<nums.length){
			if(nums[j]!=nums[i]){
				i = j;
				j++;
				len++;
			}
			else if(nums[j]==nums[i]){
				while(j<nums.length && nums[j] == nums[i] )j++;
				if(j==nums.length){
					len+=2;
					break;
				}
				else{
					len+=1;
					i = j-1;
				}
			}
		}
		return len;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2};
		M80_RemoveDuplicate2 sol = new M80_RemoveDuplicate2();
		System.out.println(sol.removeDuplicates(nums));
	}
}
