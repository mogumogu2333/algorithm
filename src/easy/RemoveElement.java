package easy;

import java.util.Arrays;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0, j = 0;
		// j is the length of the return array
		// j is the position to write down the next element
		// i is the walker.
		
		for(i = 0;i<nums.length;i++){
			if(nums[i]==val)continue;
			
			if(j!=i)
				nums[j] = nums[i];
			j++;
		}
		return j;
        
    }
	
	public static void main(String[] args) {
		int[] list = {1,2,3,3,3,3,5};
		int val = 3;
		
		RemoveElement sol = new RemoveElement();
		System.out.println(sol.removeElement(list, val));
		System.out.println(Arrays.toString(list));
		
	}

}
