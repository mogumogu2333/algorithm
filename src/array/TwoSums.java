package array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mapping = new HashMap<>();
        for(int i = 0; i <nums.length;i++){
        	int sub = target - nums[i];
        	if(mapping.containsKey(sub)){
        		return new int[]{mapping.get(sub), i};
        	}
        	else{
        		mapping.put(nums[i], i);
        	}
        }
        return null;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,4};
		TwoSums sol = new TwoSums();
		System.out.println(Arrays.toString(sol.twoSum(nums, 6)));
	}

}
